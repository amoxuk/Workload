/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:06:26
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `grades` varchar(20) DEFAULT NULL,
  `type` char(20) DEFAULT 'A',
  `peroid` float unsigned zerofill DEFAULT NULL,
  `people` int(10) unsigned zerofill DEFAULT NULL,
  `credit` float unsigned zerofill DEFAULT NULL,
  `coefficient` float unsigned zerofill DEFAULT NULL,
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`),
  KEY `idx_id` (`id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expriment
-- ----------------------------
INSERT INTO `expriment` VALUES ('0000000001', '1', '1', '00000000001', '00000000001', null, 'A', null, null, null, null, null, null);
INSERT INTO `expriment` VALUES ('0000000002', '张三', '语文', '00000000012', '00000000012', '12', 'A', '000000000012', '0000000012', '000000000045', '000000000001', '000000000144', '');
INSERT INTO `expriment` VALUES ('0000000003', 'ss', '2121', '00000000012', '00000000012', '122', 'A', '000000000012', '0000000121', null, '000000000001', '000000001452', '');
