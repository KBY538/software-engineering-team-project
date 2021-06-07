INSERT INTO user VALUES('길민호', 'rlfalsgh95', '1234', '010-4108-9568', now());

INSERT INTO user_role VALUES('rlfalsgh95', 'ROLE_CAMPER');
INSERT INTO user_role VALUES('rlfalsgh95', 'ROLE_OWNER');
INSERT INTO user_role VALUES('rlfalsgh95', 'ROLE_ADMIN');

INSERT INTO user_role VALUES('owner1', 'ROLE_OWNER');
INSERT INTO user_role VALUES('admin1', 'ROLE_ADMIN');


INSERT INTO facility(name) VALUES('수세식 화장실');
INSERT INTO facility(name) VALUES('놀이방');
INSERT INTO facility(name) VALUES('매점');
INSERT INTO facility(name) VALUES('샤워실');
INSERT INTO facility(name) VALUES('수영장');
INSERT INTO facility(name) VALUES('개수대');


INSERT INTO operating(type) VALUES('오토캠핑');
INSERT INTO operating(type) VALUES('글램핑');
INSERT INTO operating(type) VALUES('카라반');
INSERT INTO operating(type) VALUES('펜션');
INSERT INTO operating(type) VALUES('방가로');


