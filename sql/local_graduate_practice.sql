/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:06
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`college`,`years`,`major`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_graduate_practice
-- ----------------------------
INSERT INTO `local_graduate_practice` VALUES ('00000000003', '张三', '', '00000002017', '', '00000000010', '00000000002', '本市', '000000000018', null);
INSERT INTO `local_graduate_practice` VALUES ('00000000004', '张三', '信息工程', '00000002017', '计算机', '00000000010', '00000000002', '本市', '000000000018', '');
INSERT INTO `local_graduate_practice` VALUES ('00000000005', '张三', '', '00000002017', '', '00000000010', '00000000002', '本市', '000000000018', '');
INSERT INTO `local_graduate_practice` VALUES ('00000000006', '张三', '信息工程', '00000002017', '计算机', '00000000010', '00000000002', '本市', '000000000018', '');
INSERT INTO `local_graduate_practice` VALUES ('00000000007', '张三', '', '00000002017', '', '00000000010', '00000000002', '本市', '000000000018', '');
INSERT INTO `local_graduate_practice` VALUES ('00000000008', '张三', '信息工程', '00000002017', '计算机', '00000000010', '00000000002', '本市', '000000000018', '');
INSERT INTO `local_graduate_practice` VALUES ('00000000009', '张三', '', '00000002017', '', '00000000010', '00000000002', '本市', '000000000018', '');
INSERT INTO `local_graduate_practice` VALUES ('00000000010', '张三', '信息工程', '00000002017', '计算机', '00000000010', '00000000008', '本市', '000000000072', '');
