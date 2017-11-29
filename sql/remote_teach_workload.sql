/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for remote_teach_workload
-- ----------------------------
DROP TABLE IF EXISTS `remote_teach_workload`;
CREATE TABLE `remote_teach_workload` (
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
  `workload` float DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=357 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_teach_workload
-- ----------------------------
INSERT INTO `remote_teach_workload` VALUES ('00000000329', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000330', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '110', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000331', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000332', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '137', '1.2', '19.2', '1344', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000333', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000334', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '137', '1.2', '19.2', '1344', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000335', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000336', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000337', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000338', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000339', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000340', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000341', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000342', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000343', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000344', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000345', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000346', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000347', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000348', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000349', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
INSERT INTO `remote_teach_workload` VALUES ('00000000350', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.6', '1232', '');
