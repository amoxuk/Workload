/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:06:43
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_course
-- ----------------------------
INSERT INTO `local_course` VALUES ('0000000002', '张三', '工程图学', '00000002017', '00000010001', '计算机', '000000000005', '5', '00000000010', '000000000001', '000000000006', null);
INSERT INTO `local_course` VALUES ('0000000006', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', null);
INSERT INTO `local_course` VALUES ('0000000007', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', null);
INSERT INTO `local_course` VALUES ('0000000008', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', null);
INSERT INTO `local_course` VALUES ('0000000009', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', null);
INSERT INTO `local_course` VALUES ('0000000010', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000120', '0000000001.8', '000000000009', null);
INSERT INTO `local_course` VALUES ('0000000011', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', null);
INSERT INTO `local_course` VALUES ('0000000020', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000110', '0000000001.7', '0000000008.5', '');
INSERT INTO `local_course` VALUES ('0000000022', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', '');
INSERT INTO `local_course` VALUES ('0000000023', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', '');
INSERT INTO `local_course` VALUES ('0000000024', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '000000000005', '');
