CREATE TABLE system_role(
                            id int(18) NOT NULL AUTO_INCREMENT,
                            name varchar(18) NOT NULL,
                            PRIMARY KEY(id)
);


CREATE TABLE system_users(
                             id int(18) NOT NULL AUTO_INCREMENT,
                             username varchar(18) NOT NULL,
                             PRIMARY KEY(id)
);


CREATE TABLE system_user_role(
                                 id int(18) NOT NULL AUTO_INCREMENT,
                                 user_id int(18) NOT NULL,
                                 role_id int(18) NOT NULL,
                                 PRIMARY KEY(id),
                                 FOREIGN KEY(user_id) REFERENCES system_users(id),
                                 FOREIGN KEY(role_id) REFERENCES system_role(id)
);

INSERT INTO `lab-01-mybatis`.`system_role`
(`name`)
VALUES
    ("user"),("admin"),("super admin"),("super super admin");


INSERT INTO `lab-01-mybatis`.`system_users`
(`username`)
VALUES
    ("joey"),("chandler"),("Rachel"),("Ross");



INSERT INTO `lab-01-mybatis`.`system_user_role`
(`user_id`,`role_id`)
VALUES
    (4,1),(3,2),(2,4),(1,4),(3,4);