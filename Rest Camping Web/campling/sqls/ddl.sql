CREATE TABLE user
(
    `name`         VARCHAR(50)    NOT NULL, 
    `username`     VARCHAR(50)    NOT NULL, 
    `password`     TEXT    NOT NULL, 
    `phone_num`    VARCHAR(50)    NOT NULL, 
    `create_date`  DATE           NOT NULL, 
    CONSTRAINT  PRIMARY KEY (username)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE user_role
(
    `username`   VARCHAR(50)    NOT NULL, 
    `role_name`  VARCHAR(50)    NOT NULL, 
    CONSTRAINT  PRIMARY KEY (username, role_name),
    foreign key (username) references user(username) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE campsite_facility
(
    `campsite_id`  INT            NOT NULL, 
    `name`         VARCHAR(50)    NOT NULL, 
    CONSTRAINT  PRIMARY KEY (campsite_id, name),
	foreign key (campsite_id) references campsite(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE campsite_operating
(
    `campsite_id`  INT            NOT NULL, 
    `type`         VARCHAR(50)    NOT NULL, 
    CONSTRAINT  PRIMARY KEY (campsite_id, type),
	foreign key (campsite_id) references campsite(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE file
(
    `id`           INT             NOT NULL    AUTO_INCREMENT, 
    `username`     VARCHAR(50)     NOT NULL, 
    `filePath`     VARCHAR(255)    NOT NULL, 
    CONSTRAINT  PRIMARY KEY (id)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE mealkit
(
    `id`           INT            NOT NULL    AUTO_INCREMENT, 
    `campsite_id`  INT            NULL, 
    `name`         VARCHAR(50)    NULL, 
    `price`        INT            NULL, 
    `numRemains`   INT            NULL, 
    CONSTRAINT  PRIMARY KEY (id),
	foreign key (campsite_id) references campsite(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE room
(
    `id`           INT            NOT NULL    AUTO_INCREMENT, 
    `campsite_id`  INT			  NULL, 
    `name`         VARCHAR(50)    NULL, 
    `price`        INT            NULL, 
    `numRemains`   INT            NULL, 
    `maxHeadCnt`   INT            NULL, 
    `baseNumCars`  INT            NULL, 
    `baseHeadCnt`  INT            NULL, 
    CONSTRAINT  PRIMARY KEY (id),
    foreign key (campsite_id) references campsite(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tourist_info
(
    `id`           INT            NOT NULL    AUTO_INCREMENT, 
    `campsite_id`  INT            NULL, 
    `name`         VARCHAR(50)    NULL, 
    `desc`         TEXT           NULL, 
    `address`      varchar(50)    NULL, 
    CONSTRAINT  PRIMARY KEY (id),
	foreign key (campsite_id) references campsite(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE restaurant_info
(
    `id`           INT            NOT NULL    AUTO_INCREMENT, 
    `campsite_id`  INT            NULL, 
    `name`         VARCHAR(50)    NULL, 
    `desc`         TEXT           NULL, 
    `address`      varchar(50)    NULL, 
    CONSTRAINT  PRIMARY KEY (id),
    foreign key (campsite_id) references campsite(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE mealkit_image
(
    `mealkit_id`  INT    NOT NULL, 
    `image_id`    INT    NOT NULL        AUTO_INCREMENT, 
     CONSTRAINT  PRIMARY KEY (image_id),
     foreign key (mealkit_id) references mealkit(id) ON DELETE CASCADE ON UPDATE CASCADE,
     foreign key (image_id) references file(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE campsite_image
(
    `campsite_id`  INT    NOT NULL, 
    `image_id`     INT    NOT NULL        AUTO_INCREMENT, 
    CONSTRAINT  PRIMARY KEY (image_id),
    foreign key (campsite_id) references campsite(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (image_id) references file(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tourist_image
(
    `tourist_id`  INT    NOT NULL, 
    `image_id`    INT    NOT NULL        AUTO_INCREMENT, 
    CONSTRAINT  PRIMARY KEY (image_id),
    foreign key (tourist_id) references tourist_info(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (image_id) references file(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE restaurant_image
(
    `restaurant_id`  INT    NOT NULL, 
    `image_id`       INT    NOT NULL        AUTO_INCREMENT, 
    CONSTRAINT  PRIMARY KEY (image_id),
    foreign key (image_id) references file(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (restaurant_id) references restaurant_info(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE room_image
(
    `room_id`   INT    NOT NULL, 
    `image_id`  INT    NOT NULL    AUTO_INCREMENT, 
    CONSTRAINT  PRIMARY KEY (image_id),
	foreign key (image_id) references file(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (room_id) references room(id) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE campsite
(
    `id`                       INT            NOT NULL    AUTO_INCREMENT COMMENT '캠핑장 id', 
    `owner`                    VARCHAR(50)    NULL        COMMENT '캠핑장 주인 이름', 
    `name`                     VARCHAR(50)    NULL        COMMENT '캠핑장 이름', 
    `address`                  VARCHAR(50)    NULL, 
    `contact`                  VARCHAR(50)    NULL, 
    `introduction`             TEXT    NULL, 
    `notice`                   TEXT           DEFAULT 0 NULL, 
    `is_approve`               INT            NULL, 
    `price_per_excess_person`  INT            NULL, 
    `price_per_excess_car`     INT            NULL, 
    CONSTRAINT  PRIMARY KEY (id),
	foreign key (owner) references user(username) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE reservation
(
    `id`                  INT            NOT NULL    AUTO_INCREMENT, 
    `room_id`             INT            NULL, 
    `check_in_date`       DATE           NULL, 
    `check_out_date`      DATE           NULL, 
    `phone_num`           VARCHAR(50)    NULL, 
    `username`            VARCHAR(50)    NULL, 
    `campsite_id`         INT            NULL, 
    `reservationHeadCnt`  INT            NULL, 
    `reservationNumCars`  INT            NULL, 
    `totalPrice`          INT            NULL, 
    CONSTRAINT PK_reservation PRIMARY KEY (id),
    foreign key (username) references user(username) ON DELETE CASCADE ON UPDATE CASCADE,
	foreign key (username) references user(username) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE reservation
    ADD CONSTRAINT FK_reservation_room_id_room_id FOREIGN KEY (room_id)
        REFERENCES room (id) ON DELETE RESTRICT ON UPDATE RESTRICT;
        
        
