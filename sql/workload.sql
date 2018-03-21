/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-03-22 00:44:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '0521062B', '电路与电子技术');
INSERT INTO `course` VALUES ('2', '1222554', 'huaxue');

-- ----------------------------
-- Table structure for expriment
-- ----------------------------
DROP TABLE IF EXISTS `expriment`;
CREATE TABLE `expriment` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(20) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `teach_class` int(11) unsigned zerofill NOT NULL,
  `grades` varchar(20) NOT NULL,
  `type` char(20) NOT NULL DEFAULT 'A',
  `peroid` float unsigned zerofill DEFAULT NULL,
  `people` int(10) unsigned zerofill DEFAULT NULL,
  `credit` float unsigned zerofill DEFAULT '000000000000',
  `coefficient` float unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`),
  KEY `idx_id` (`id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='实验教学表';

-- ----------------------------
-- Records of expriment
-- ----------------------------

-- ----------------------------
-- Table structure for lessons
-- ----------------------------
DROP TABLE IF EXISTS `lessons`;
CREATE TABLE `lessons` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) DEFAULT NULL COMMENT '教师ID',
  `courseId` int(11) DEFAULT NULL COMMENT '课程ID',
  `class_number` int(11) DEFAULT NULL COMMENT '教学班号',
  `student_number` int(11) DEFAULT NULL COMMENT '学生人数',
  `period` int(11) DEFAULT NULL COMMENT '学时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lessons
-- ----------------------------
INSERT INTO `lessons` VALUES ('00000000001', '100001', '10001', '1', '25', '48');

-- ----------------------------
-- Table structure for local_course
-- ----------------------------
DROP TABLE IF EXISTS `local_course`;
CREATE TABLE `local_course` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(20) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `teach_class` int(11) unsigned zerofill NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `period` float unsigned zerofill DEFAULT NULL,
  `credit` float DEFAULT NULL,
  `people` int(11) unsigned zerofill DEFAULT NULL,
  `coefficient` float unsigned zerofill DEFAULT '000000000000',
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=360 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_course
-- ----------------------------
INSERT INTO `local_course` VALUES ('0000000359', '李四', 'jsj', '00000002017', '00000001001', '1', '000000000002', '1.5', '00000000050', '000000000000', null, null);

-- ----------------------------
-- Table structure for local_design
-- ----------------------------
DROP TABLE IF EXISTS `local_design`;
CREATE TABLE `local_design` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(20) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(10) unsigned zerofill NOT NULL,
  `teach_class` int(10) unsigned zerofill NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `people` int(10) unsigned zerofill DEFAULT NULL,
  `weeks` int(10) unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_design
-- ----------------------------

-- ----------------------------
-- Table structure for local_expriment
-- ----------------------------
DROP TABLE IF EXISTS `local_expriment`;
CREATE TABLE `local_expriment` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) NOT NULL,
  `lesson` varchar(255) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `teach_class` int(11) unsigned zerofill NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `type` char(255) DEFAULT 'A',
  `period` float unsigned zerofill DEFAULT NULL,
  `people` int(10) unsigned zerofill DEFAULT NULL,
  `load_coefficient` float unsigned zerofill DEFAULT NULL,
  `type_coefficient` float unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_expriment
-- ----------------------------

-- ----------------------------
-- Table structure for local_graduate_design
-- ----------------------------
DROP TABLE IF EXISTS `local_graduate_design`;
CREATE TABLE `local_graduate_design` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(20) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `grades` varchar(20) NOT NULL,
  `people` int(11) unsigned zerofill DEFAULT NULL,
  `weeks` int(11) unsigned zerofill DEFAULT NULL,
  `coefficient` float unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`grades`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_graduate_design
-- ----------------------------

-- ----------------------------
-- Table structure for local_graduate_practice
-- ----------------------------
DROP TABLE IF EXISTS `local_graduate_practice`;
CREATE TABLE `local_graduate_practice` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) NOT NULL,
  `college` varchar(255) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `major` varchar(255) NOT NULL,
  `people` int(11) unsigned zerofill DEFAULT NULL,
  `weeks` int(11) unsigned zerofill DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`college`,`years`,`major`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_graduate_practice
-- ----------------------------

-- ----------------------------
-- Table structure for local_match
-- ----------------------------
DROP TABLE IF EXISTS `local_match`;
CREATE TABLE `local_match` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) NOT NULL,
  `years` int(10) unsigned zerofill NOT NULL,
  `number` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_match
-- ----------------------------

-- ----------------------------
-- Table structure for local_net
-- ----------------------------
DROP TABLE IF EXISTS `local_net`;
CREATE TABLE `local_net` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `lesson` varchar(255) NOT NULL,
  `answer` int(11) unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`lesson`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_net
-- ----------------------------

-- ----------------------------
-- Table structure for local_practice
-- ----------------------------
DROP TABLE IF EXISTS `local_practice`;
CREATE TABLE `local_practice` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(255) NOT NULL,
  `teacher` varchar(255) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `major` varchar(255) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `people` int(11) unsigned zerofill DEFAULT NULL,
  `class_number` int(11) unsigned zerofill DEFAULT NULL,
  `weeks` int(11) unsigned zerofill DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`,`major`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_practice
-- ----------------------------

-- ----------------------------
-- Table structure for local_project
-- ----------------------------
DROP TABLE IF EXISTS `local_project`;
CREATE TABLE `local_project` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `years` int(11) NOT NULL,
  `teacher` varchar(255) NOT NULL,
  `number` varchar(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`years`,`teacher`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_project
-- ----------------------------

-- ----------------------------
-- Table structure for remote_design
-- ----------------------------
DROP TABLE IF EXISTS `remote_design`;
CREATE TABLE `remote_design` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(20) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(11) NOT NULL,
  `teach_class` int(11) NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `weeks` int(11) DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `load_coefficient` float DEFAULT NULL,
  `workload` float(7,2) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_design
-- ----------------------------

-- ----------------------------
-- Table structure for remote_expriment
-- ----------------------------
DROP TABLE IF EXISTS `remote_expriment`;
CREATE TABLE `remote_expriment` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(40) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  `years` int(11) NOT NULL,
  `teach_class` int(11) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `period` float DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `re_coefficient` float DEFAULT NULL,
  `type_coefficient` float DEFAULT NULL,
  `workload` float(7,2) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`,`teach_class`,`lesson`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_expriment
-- ----------------------------

-- ----------------------------
-- Table structure for remote_graduate
-- ----------------------------
DROP TABLE IF EXISTS `remote_graduate`;
CREATE TABLE `remote_graduate` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(20) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  `years` int(11) NOT NULL,
  `grades` varchar(20) NOT NULL,
  `people` int(11) NOT NULL,
  `weeks` int(11) DEFAULT NULL,
  `workload` float(7,2) DEFAULT NULL,
  `money` float(11,0) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_graduate
-- ----------------------------

-- ----------------------------
-- Table structure for remote_non_lesson
-- ----------------------------
DROP TABLE IF EXISTS `remote_non_lesson`;
CREATE TABLE `remote_non_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `colleage` varchar(20) DEFAULT NULL,
  `teacher` varchar(20) NOT NULL,
  `years` int(11) NOT NULL,
  `days` int(2) DEFAULT NULL,
  `weeks` int(2) DEFAULT NULL,
  `alldays` int(4) DEFAULT NULL,
  `allownce` float(7,2) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_non_lesson
-- ----------------------------

-- ----------------------------
-- Table structure for remote_teach
-- ----------------------------
DROP TABLE IF EXISTS `remote_teach`;
CREATE TABLE `remote_teach` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(20) NOT NULL,
  `teacher` varchar(10) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(10) NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `teach_class` int(10) NOT NULL,
  `period` float DEFAULT NULL,
  `credit` float DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `class_coefficient` float DEFAULT NULL,
  `workload` float(7,2) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=383 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_teach
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `tid` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `name` varchar(10) NOT NULL,
  `location` int(10) unsigned zerofill NOT NULL,
  `college` varchar(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE,
  KEY `tid` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=393 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('00000000387', '00000001003', '李四', '0000000001', 'jsj', null);
INSERT INTO `teacher` VALUES ('00000000392', '00000001005', '几十块', '0000000000', '计算机', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `tid` int(11) unsigned zerofill DEFAULT '00000000000',
  `user` varchar(20) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `mail` varchar(20) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `alter_time` datetime DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role` (`level`),
  CONSTRAINT `role` FOREIGN KEY (`level`) REFERENCES `user_role` (`level_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10000', '1', '00000000000', 'amoxu', '11a9d9f0794dafe80ab4ed4ef6145215', 'amoxu@qq.com', '我的名字', null, '2018-03-22 00:42:57', '张三');
INSERT INTO `user` VALUES ('10001', '0', '00000000000', 'misty', '11a9d9f0794dafe80ab4ed4ef6145215', 'amoxu@qq.com', 'who', null, null, '小白鼠');
INSERT INTO `user` VALUES ('10012', '0', '00000010003', 'zssd', 'c0ad536a63cdc7718483e8c047c05fbc', '950815@qq.com', null, '2018-03-22 00:00:00', '2018-03-22 00:16:47', null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `level_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(12) DEFAULT NULL,
  PRIMARY KEY (`level_id`),
  KEY `level_id` (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('0', '管理员');
INSERT INTO `user_role` VALUES ('1', '超级管理员');

-- ----------------------------
-- Table structure for workload
-- ----------------------------
DROP TABLE IF EXISTS `workload`;
CREATE TABLE `workload` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) DEFAULT NULL,
  `lesson` varchar(255) DEFAULT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `teach_class` int(11) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `years` int(11) DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `coefficient` float(255,0) DEFAULT NULL,
  `workload` float(255,0) DEFAULT NULL,
  `money` float(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workload
-- ----------------------------

-- ----------------------------
-- View structure for expriment_view
-- ----------------------------
DROP VIEW IF EXISTS `expriment_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `expriment_view` AS select `expriment`.`teacher` AS `teacher`,`expriment`.`years` AS `years`,sum(`expriment`.`workload`) AS `workload` from `expriment` group by `expriment`.`teacher`,`expriment`.`years` ;

-- ----------------------------
-- View structure for local_course_view
-- ----------------------------
DROP VIEW IF EXISTS `local_course_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_course_view` AS select `local_course`.`teacher` AS `teacher`,`local_course`.`years` AS `years`,sum(`local_course`.`workload`) AS `workload` from `local_course` group by `local_course`.`years`,`local_course`.`teacher` order by `local_course`.`teacher` ;

-- ----------------------------
-- View structure for local_design_view
-- ----------------------------
DROP VIEW IF EXISTS `local_design_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_design_view` AS select `local_design`.`teacher` AS `teacher`,`local_design`.`years` AS `years`,sum(`local_design`.`workload`) AS `workload` from `local_design` group by `local_design`.`years`,`local_design`.`teacher` order by `local_design`.`teacher` ;

-- ----------------------------
-- View structure for local_expriment_view
-- ----------------------------
DROP VIEW IF EXISTS `local_expriment_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_expriment_view` AS select `local_expriment`.`teacher` AS `teacher`,`local_expriment`.`years` AS `years`,sum(`local_expriment`.`workload`) AS `workload` from `local_expriment` group by `local_expriment`.`years`,`local_expriment`.`teacher` order by `local_expriment`.`teacher` ;

-- ----------------------------
-- View structure for local_graduate_design_view
-- ----------------------------
DROP VIEW IF EXISTS `local_graduate_design_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_graduate_design_view` AS select `local_graduate_design`.`teacher` AS `teacher`,`local_graduate_design`.`years` AS `years`,sum(`local_graduate_design`.`workload`) AS `workload` from `local_graduate_design` group by `local_graduate_design`.`years`,`local_graduate_design`.`teacher` order by `local_graduate_design`.`teacher` ;

-- ----------------------------
-- View structure for local_graduate_practice_view
-- ----------------------------
DROP VIEW IF EXISTS `local_graduate_practice_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_graduate_practice_view` AS select `local_graduate_practice`.`teacher` AS `teacher`,`local_graduate_practice`.`years` AS `years`,sum(`local_graduate_practice`.`workload`) AS `workload` from `local_graduate_practice` group by `local_graduate_practice`.`years`,`local_graduate_practice`.`teacher` order by `local_graduate_practice`.`teacher` ;

-- ----------------------------
-- View structure for local_match_view
-- ----------------------------
DROP VIEW IF EXISTS `local_match_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_match_view` AS select `local_match`.`teacher` AS `teacher`,`local_match`.`years` AS `years`,sum(`local_match`.`workload`) AS `workload` from `local_match` group by `local_match`.`teacher`,`local_match`.`years` order by `local_match`.`teacher` ;

-- ----------------------------
-- View structure for local_practice_view
-- ----------------------------
DROP VIEW IF EXISTS `local_practice_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_practice_view` AS select `local_practice`.`teacher` AS `teacher`,`local_practice`.`years` AS `years`,sum(`local_practice`.`workload`) AS `workload` from `local_practice` group by `local_practice`.`teacher`,`local_practice`.`years` order by `local_practice`.`teacher` ;

-- ----------------------------
-- View structure for local_project_view
-- ----------------------------
DROP VIEW IF EXISTS `local_project_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_project_view` AS select `local_project`.`teacher` AS `teacher`,sum(`local_project`.`workload`) AS `workload`,`local_project`.`years` AS `years` from `local_project` group by `local_project`.`teacher`,`local_project`.`years` order by `local_project`.`teacher` ;

-- ----------------------------
-- View structure for local_total_view
-- ----------------------------
DROP VIEW IF EXISTS `local_total_view`;
CREATE ALGORITHM=MERGE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_total_view` AS select `t`.`teacher` AS `teacher`,`t`.`years` AS `years`,ifnull(`local_course_view`.`workload`,0) AS `course`,ifnull(`local_design_view`.`workload`,0) AS `design`,ifnull(`local_expriment_view`.`workload`,0) AS `expriment`,ifnull(`local_graduate_design_view`.`workload`,0) AS `graduate_design`,ifnull(`local_graduate_practice_view`.`workload`,0) AS `graduate_practice`,ifnull(`local_project_view`.`workload`,0) AS `project`,ifnull(`local_practice_view`.`workload`,0) AS `practice`,ifnull(`local_match_view`.`workload`,0) AS `matchs`,((((((ifnull(`local_course_view`.`workload`,0) + ifnull(`local_design_view`.`workload`,0)) + ifnull(`local_expriment_view`.`workload`,0)) + ifnull(`local_graduate_practice_view`.`workload`,0)) + ifnull(`local_project_view`.`workload`,0)) + ifnull(`local_practice_view`.`workload`,0)) + ifnull(`local_match_view`.`workload`,0)) AS `total` from ((((((((((select `local_course_view`.`teacher` AS `teacher`,`local_course_view`.`years` AS `years` from `workload`.`local_course_view`) union select `local_design_view`.`teacher` AS `teacher`,`local_design_view`.`years` AS `years` from `workload`.`local_design_view` union select `local_expriment_view`.`teacher` AS `teacher`,`local_expriment_view`.`years` AS `years` from `workload`.`local_expriment_view` union select `local_graduate_design_view`.`teacher` AS `teacher`,`local_graduate_design_view`.`years` AS `years` from `workload`.`local_graduate_design_view` union select `local_graduate_practice_view`.`teacher` AS `teacher`,`local_graduate_practice_view`.`years` AS `years` from `workload`.`local_graduate_practice_view` union select `local_match_view`.`teacher` AS `teacher`,`local_match_view`.`years` AS `years` from `workload`.`local_match_view` union select `local_practice_view`.`teacher` AS `teacher`,`local_practice_view`.`years` AS `years` from `workload`.`local_practice_view` union select `local_project_view`.`teacher` AS `teacher`,`local_project_view`.`years` AS `years` from `workload`.`local_project_view` group by `local_project_view`.`teacher`,`local_project_view`.`years` order by `teacher`) `t` left join `workload`.`local_course_view` on(((`local_course_view`.`teacher` = `t`.`teacher`) and (`local_course_view`.`years` = `t`.`years`)))) left join `workload`.`local_design_view` on(((`local_design_view`.`teacher` = `t`.`teacher`) and (`local_design_view`.`years` = `t`.`years`)))) left join `workload`.`local_expriment_view` on(((`local_expriment_view`.`teacher` = `t`.`teacher`) and (`local_expriment_view`.`years` = `t`.`years`)))) left join `workload`.`local_graduate_design_view` on(((`local_graduate_design_view`.`teacher` = `t`.`teacher`) and (`local_graduate_design_view`.`years` = `t`.`years`)))) left join `workload`.`local_graduate_practice_view` on(((`local_graduate_practice_view`.`teacher` = `t`.`teacher`) and (`local_graduate_practice_view`.`years` = `t`.`years`)))) left join `workload`.`local_project_view` on(((`local_project_view`.`teacher` = `t`.`teacher`) and (`local_project_view`.`years` = `t`.`years`)))) left join `workload`.`local_practice_view` on(((`local_practice_view`.`teacher` = `t`.`teacher`) and (`local_practice_view`.`years` = `t`.`years`)))) left join `workload`.`local_match_view` on(((`local_match_view`.`teacher` = `t`.`teacher`) and (`local_match_view`.`years` = `t`.`years`)))) ;

-- ----------------------------
-- View structure for remote_design_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_design_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_design_view` AS select `remote_design`.`teacher` AS `teacher`,`remote_design`.`years` AS `years`,sum(`remote_design`.`workload`) AS `workload` from `remote_design` group by `remote_design`.`teacher`,`remote_design`.`years` order by `remote_design`.`teacher` ;

-- ----------------------------
-- View structure for remote_expriment_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_expriment_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_expriment_view` AS select `remote_expriment`.`teacher` AS `teacher`,`remote_expriment`.`years` AS `years`,sum(`remote_expriment`.`workload`) AS `workload` from `remote_expriment` group by `remote_expriment`.`teacher`,`remote_expriment`.`years` order by `remote_expriment`.`teacher` ;

-- ----------------------------
-- View structure for remote_graduate_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_graduate_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_graduate_view` AS select `remote_graduate`.`teacher` AS `teacher`,`remote_graduate`.`years` AS `years`,sum(`remote_graduate`.`workload`) AS `workload` from `remote_graduate` group by `remote_graduate`.`teacher`,`remote_graduate`.`years` order by `remote_graduate`.`teacher` ;

-- ----------------------------
-- View structure for remote_non_lesson_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_non_lesson_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_non_lesson_view` AS select sum(`remote_non_lesson`.`allownce`) AS `allownce`,`remote_non_lesson`.`teacher` AS `teacher`,`remote_non_lesson`.`years` AS `years` from `remote_non_lesson` group by `remote_non_lesson`.`teacher`,`remote_non_lesson`.`years` order by `remote_non_lesson`.`teacher` ;

-- ----------------------------
-- View structure for remote_teach_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_teach_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_teach_view` AS select `remote_teach`.`teacher` AS `teacher`,`remote_teach`.`years` AS `years`,sum(`remote_teach`.`workload`) AS `workload` from `remote_teach` group by `remote_teach`.`teacher`,`remote_teach`.`years` order by `remote_teach`.`teacher` ;

-- ----------------------------
-- View structure for remote_total_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_total_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_total_view` AS select `t`.`teacher` AS `teacher`,`t`.`years` AS `years`,ifnull(`remote_teach_view`.`workload`,0) AS `course`,ifnull(`remote_design_view`.`workload`,0) AS `design`,ifnull(`remote_expriment_view`.`workload`,0) AS `expriment`,ifnull(`remote_graduate_view`.`workload`,0) AS `graduate`,ifnull(`remote_non_lesson_view`.`allownce`,0) AS `non_lesson`,(((((ifnull(`remote_teach_view`.`workload`,0) + ifnull(`remote_non_lesson_view`.`allownce`,0)) + ifnull(`remote_design_view`.`workload`,0)) + ifnull(`remote_expriment_view`.`workload`,0)) + ifnull(`remote_graduate_view`.`workload`,0)) + ifnull(`remote_non_lesson_view`.`allownce`,0)) AS `total` from (((((((select `remote_design_view`.`teacher` AS `teacher`,`remote_design_view`.`years` AS `years` from `workload`.`remote_design_view`) union select `remote_expriment_view`.`teacher` AS `teacher`,`remote_expriment_view`.`years` AS `years` from `workload`.`remote_expriment_view` union select `remote_graduate_view`.`teacher` AS `teacher`,`remote_graduate_view`.`years` AS `years` from `workload`.`remote_graduate_view` union select `remote_non_lesson_view`.`teacher` AS `teacher`,`remote_non_lesson_view`.`years` AS `years` from `workload`.`remote_non_lesson_view` union select `remote_teach_view`.`teacher` AS `teacher`,`remote_teach_view`.`years` AS `years` from `workload`.`remote_teach_view` group by `remote_teach_view`.`teacher`,`remote_teach_view`.`years` order by `teacher`) `t` left join `workload`.`remote_teach_view` on(((`remote_teach_view`.`teacher` = `t`.`teacher`) and (`remote_teach_view`.`years` = `t`.`years`)))) left join `workload`.`remote_design_view` on(((`remote_design_view`.`teacher` = `t`.`teacher`) and (`remote_design_view`.`years` = `t`.`years`)))) left join `workload`.`remote_expriment_view` on(((`remote_expriment_view`.`teacher` = `t`.`teacher`) and (`remote_expriment_view`.`years` = `t`.`years`)))) left join `workload`.`remote_graduate_view` on(((`remote_graduate_view`.`teacher` = `t`.`teacher`) and (`remote_graduate_view`.`years` = `t`.`years`)))) left join `workload`.`remote_non_lesson_view` on(((`remote_non_lesson_view`.`teacher` = `t`.`teacher`) and (`remote_non_lesson_view`.`years` = `t`.`years`)))) ;

-- ----------------------------
-- View structure for teacher_local_view
-- ----------------------------
DROP VIEW IF EXISTS `teacher_local_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_local_view` AS select `t`.`teacher` AS `teacher`,`t`.`college` AS `college` from (select `workload`.`local_graduate_practice`.`teacher` AS `teacher`,`workload`.`local_graduate_practice`.`college` AS `college` from `workload`.`local_graduate_practice` union select `expriment_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`expriment_view` union select `local_course_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_course_view` union select `local_design_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_design_view` union select `local_expriment_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_expriment_view` union select `local_graduate_design_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_graduate_design_view` union select `local_graduate_practice_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_graduate_practice_view` union select `local_match_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_match_view` union select `local_practice_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_practice_view` union select `local_project_view`.`teacher` AS `teacher`,NULL AS `colleage` from `workload`.`local_project_view`) `t` group by `t`.`teacher` ;

-- ----------------------------
-- View structure for teacher_remote_view
-- ----------------------------
DROP VIEW IF EXISTS `teacher_remote_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_remote_view` AS select `t`.`teacher` AS `teacher`,`t`.`college` AS `college` from (select `workload`.`remote_teach`.`teacher` AS `teacher`,`workload`.`remote_teach`.`college` AS `college` from `workload`.`remote_teach` union select `workload`.`remote_non_lesson`.`teacher` AS `teacher`,`workload`.`remote_non_lesson`.`colleage` AS `colleage` from `workload`.`remote_non_lesson` union select `workload`.`remote_graduate`.`teacher` AS `teacher`,`workload`.`remote_graduate`.`college` AS `college` from `workload`.`remote_graduate` union select `workload`.`remote_expriment`.`teacher` AS `teacher`,`workload`.`remote_expriment`.`college` AS `college` from `workload`.`remote_expriment` union select `workload`.`remote_design`.`teacher` AS `teacher`,`workload`.`remote_design`.`college` AS `college` from `workload`.`remote_design`) `t` group by `t`.`teacher` ;

-- ----------------------------
-- Procedure structure for search_teacher_into_proc
-- ----------------------------
DROP PROCEDURE IF EXISTS `search_teacher_into_proc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_teacher_into_proc`()
BEGIN
INSERT INTO teacher(name,college,location)
SELECT teacher,college,location from (
 SELECT teacher_local_view.teacher,teacher_local_view.college,'1' as location FROM teacher_local_view WHERE teacher_local_view.teacher not in (SELECT `name` FROM teacher) UNION
 SELECT teacher_remote_view.teacher,teacher_remote_view.college, '0' as location FROM teacher_remote_view WHERE teacher_remote_view.teacher not in (SELECT `name` FROM teacher)) as t GROUP BY t.teacher ;
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for ins
-- ----------------------------
DROP FUNCTION IF EXISTS `ins`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `ins`() RETURNS int(11)
BEGIN
	#Routine body goes here...

set @i :=0;
WHILE @i<100 do
INSERT INTO `local_course` (
	`teacher`,
	`lesson`,
	`years`,
	`teach_class`,
	`grades`,
	`period`,
	`credit`,
	`people`,
	`coefficient`,
	`workload`,
	`note`
)
VALUES
	(
		CONCAT('张三',@i),
		'计算机原理',
		'2017',
		'10001',
		'计算机',
		'5',
		'0',
		'10',
		'1',
		'5',
		''
	);
set @i := @i+1;
end WHILE;

	RETURN 0;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `name_update_tri`;
DELIMITER ;;
CREATE TRIGGER `name_update_tri` AFTER UPDATE ON `teacher` FOR EACH ROW BEGIN
if new.name != old.name then
UPDATE expriment SET expriment.teacher =new.name WHERE teacher = old.name;
UPDATE local_course SET local_course.teacher =new.name WHERE teacher = old.name;
UPDATE local_design SET local_design.teacher =new.name WHERE teacher = old.name;
UPDATE local_course SET local_course.teacher =new.name WHERE teacher = old.name;
UPDATE local_expriment SET local_expriment.teacher =new.name WHERE teacher = old.name;
UPDATE local_graduate_design SET local_graduate_design.teacher =new.name WHERE teacher = old.name;
UPDATE local_graduate_practice SET local_graduate_practice.teacher =new.name WHERE teacher = old.name;
UPDATE local_match SET local_match.teacher =new.name WHERE teacher = old.name;
UPDATE local_net SET local_net.teacher =new.name WHERE teacher = old.name;
UPDATE local_practice SET local_practice.teacher =new.name WHERE teacher = old.name;
UPDATE local_project SET local_project.teacher =new.name WHERE teacher = old.name;

UPDATE remote_design SET remote_design.teacher =new.name WHERE teacher = old.name;
UPDATE remote_expriment SET remote_expriment.teacher =new.name WHERE teacher = old.name;
UPDATE remote_graduate SET remote_graduate.teacher =new.name WHERE teacher = old.name;
UPDATE remote_non_lesson SET remote_non_lesson.teacher =new.name WHERE teacher = old.name;
UPDATE remote_teach SET remote_teach.teacher =new.name WHERE teacher = old.name;
end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `name_delete_tri`;
DELIMITER ;;
CREATE TRIGGER `name_delete_tri` AFTER DELETE ON `teacher` FOR EACH ROW BEGIN
delete from expriment  WHERE teacher = old.name;
delete from local_course WHERE teacher = old.name;
delete from local_design WHERE teacher = old.name;
delete from local_course   WHERE teacher = old.name;
delete from local_expriment  WHERE teacher = old.name;
delete from local_graduate_design   WHERE teacher = old.name;
delete from local_graduate_practice  WHERE teacher = old.name;
delete from local_match   WHERE teacher = old.name;
delete from local_net   WHERE teacher = old.name;
delete from local_practice   WHERE teacher = old.name;
delete from local_project   WHERE teacher = old.name;

delete from remote_design  WHERE teacher = old.name;
delete from remote_expriment   WHERE teacher = old.name;
delete from remote_graduate   WHERE teacher = old.name;
delete from remote_non_lesson   WHERE teacher = old.name;
delete from remote_teach  WHERE teacher = old.name;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `create_time_tri`;
DELIMITER ;;
CREATE TRIGGER `create_time_tri` BEFORE INSERT ON `user` FOR EACH ROW SET new.create_time = NOW()
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `alter_time_tri`;
DELIMITER ;;
CREATE TRIGGER `alter_time_tri` BEFORE UPDATE ON `user` FOR EACH ROW set new.alter_time = now()
;;
DELIMITER ;
