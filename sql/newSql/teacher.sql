--USE `before`;
--创建教师表
CREATE TABLE teacher(
id int auto_increment COMMENT "工号",
name VARCHAR(20) COMMENT "姓名",
colleage VARCHAR(20) COMMENT "学院",
note VARCHAR (255) COMMENT "备注"
PRIMARY key (`id`)
) ENGINE=INNODB DEFAULT  CHARACTER SET=utf8 COLLATE=utf8_general_ci;
