/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:06:56
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_expriment
-- ----------------------------
INSERT INTO `local_expriment` VALUES ('0000000001', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'C', '000000000005', '0000000105', '0000000001.6', '0000000001.4', '000000000011', null);
INSERT INTO `local_expriment` VALUES ('0000000002', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'B', '000000000005', '0000000010', '000000000001', '0000000001.2', '000000000006', null);
INSERT INTO `local_expriment` VALUES ('0000000003', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', null);
INSERT INTO `local_expriment` VALUES ('0000000004', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', null);
INSERT INTO `local_expriment` VALUES ('0000000005', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', null);
INSERT INTO `local_expriment` VALUES ('0000000006', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', null);
INSERT INTO `local_expriment` VALUES ('0000000007', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'C', '000000000005', '0000000105', '0000000001.6', '0000000001.4', '000000000011', '');
INSERT INTO `local_expriment` VALUES ('0000000008', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'B', '000000000005', '0000000010', '000000000001', '0000000001.2', '000000000006', '');
INSERT INTO `local_expriment` VALUES ('0000000009', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', '');
INSERT INTO `local_expriment` VALUES ('0000000010', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', '');
INSERT INTO `local_expriment` VALUES ('0000000011', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', '');
INSERT INTO `local_expriment` VALUES ('0000000012', '张三', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '000000000005', '');
