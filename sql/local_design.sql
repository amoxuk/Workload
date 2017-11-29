/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:06:50
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_design
-- ----------------------------
INSERT INTO `local_design` VALUES ('0000000002', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000015', '000000000120', null);
INSERT INTO `local_design` VALUES ('0000000003', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000013', '000000000104', null);
INSERT INTO `local_design` VALUES ('0000000004', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000022', '000000000176', null);
INSERT INTO `local_design` VALUES ('0000000005', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000005', '000000000040', null);
INSERT INTO `local_design` VALUES ('0000000006', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000010', '000000000080', '');
INSERT INTO `local_design` VALUES ('0000000007', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000015', '000000000120', '');
INSERT INTO `local_design` VALUES ('0000000008', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000013', '000000000104', '');
INSERT INTO `local_design` VALUES ('0000000009', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000022', '000000000176', '');
INSERT INTO `local_design` VALUES ('0000000010', '张三', '计算机原理', '0000002017', '0000010001', '计算机', '0000000010', '0000000005', '000000000040', '');
