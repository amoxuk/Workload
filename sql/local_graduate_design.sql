/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:01
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`grades`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_graduate_design
-- ----------------------------
INSERT INTO `local_graduate_design` VALUES ('00000000001', '张三', '00000002017', '计算机', '00000000015', '00000000005', '0000000001.2', '000000000090', null);
INSERT INTO `local_graduate_design` VALUES ('00000000002', '张三', '00000002017', '计算机', '00000000015', '00000000005', '0000000001.2', '000000000090', '');
INSERT INTO `local_graduate_design` VALUES ('00000000003', '张三', '00000002017', '计算机', '00000000020', '00000000010', '0000000001.2', '000000000240', '');
INSERT INTO `local_graduate_design` VALUES ('00000000004', '张三', '00000002017', '计算机', '00000000020', '00000000010', '0000000001.2', '000000000240', '');
INSERT INTO `local_graduate_design` VALUES ('00000000005', '张三', '00000002017', '计算机', '00000000042', '00000000009', '0000000001.2', '000000000453', '');
INSERT INTO `local_graduate_design` VALUES ('00000000006', '张三', '00000002017', '计算机', '00000000005', '00000000005', '0000000001.2', '000000000030', '');
INSERT INTO `local_graduate_design` VALUES ('00000000007', '张三', '00000002017', '计算机', '00000000006', '00000000008', '0000000001.2', '000000000057', '');
INSERT INTO `local_graduate_design` VALUES ('00000000008', '张三', '00000002017', '计算机', '00000000003', '00000000002', '0000000001.2', '000000000007', '');
INSERT INTO `local_graduate_design` VALUES ('00000000009', '张三', '00000002017', '计算机', '00000000044', '00000000003', '0000000001.2', '000000000158', '');
INSERT INTO `local_graduate_design` VALUES ('00000000010', '张三', '00000002017', '计算机', '00000000055', '00000000004', '0000000001.2', '000000000264', '');
INSERT INTO `local_graduate_design` VALUES ('00000000011', '张三', '00000002017', '计算机', '00000000009', '00000000006', '0000000001.2', '000000000064', '');
INSERT INTO `local_graduate_design` VALUES ('00000000012', '张三', '00000002017', '计算机', '00000000022', '00000000001', '0000000001.2', '000000000026', '');
