/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:31
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `workload` float DEFAULT NULL,
  `money` float(11,0) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_graduate
-- ----------------------------
INSERT INTO `remote_graduate` VALUES ('0000000005', '信息工程', '张三', '2017', '计算机', '8', '6', '43', '3024', '老师');
INSERT INTO `remote_graduate` VALUES ('0000000006', '信息工程', '张三', '2017', '计算机', '7', '5', '32', '2205', '');
INSERT INTO `remote_graduate` VALUES ('0000000007', '信息工程', '张三', '2017', '计算机', '15', '5', '68', '4725', null);
INSERT INTO `remote_graduate` VALUES ('0000000008', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', null);
INSERT INTO `remote_graduate` VALUES ('0000000010', '信息工程', '张三', '2017', '计算机', '8', '5', '36', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000011', '信息工程', '张三', '2017', '计算机', '8', '5', '36', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000012', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000013', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000014', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000015', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000016', '信息工程', '张三', '2017', '计算机', '8', '5', '36', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000017', '信息工程', '张三', '2017', '计算机', '8', '5', '36', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000018', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000019', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000020', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000021', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000022', '信息工程', '张三', '2017', '计算机', '8', '5', '36', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000023', '信息工程', '张三', '2017', '计算机', '8', '5', '36', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000025', '信息工程', '张三', '2017', '计算机', '10', '5', '45', '3150', '');
