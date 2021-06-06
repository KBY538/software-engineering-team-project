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


