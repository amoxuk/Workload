/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

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
