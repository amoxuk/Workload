/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:16
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`,`major`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_practice
-- ----------------------------
INSERT INTO `local_practice` VALUES ('00000000001', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000002', '00000000010', '外地', '000000000400', null);
INSERT INTO `local_practice` VALUES ('00000000002', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000003', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000004', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000005', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000006', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000007', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000008', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000009', '信息工程', '张三', '00000002017', '物联网', null, '00000000015', '00000000022', '00000000005', '本市', '000000001980', null);
INSERT INTO `local_practice` VALUES ('00000000010', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000010', '00000000002', '外地', '000000000400', '');
INSERT INTO `local_practice` VALUES ('00000000011', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000002', '本市', '000000000180', '');
INSERT INTO `local_practice` VALUES ('00000000012', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000002', '本市', '000000000180', '');
INSERT INTO `local_practice` VALUES ('00000000013', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000003', '本市', '000000000270', '');
INSERT INTO `local_practice` VALUES ('00000000014', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000022', '本市', '000000001980', '');
INSERT INTO `local_practice` VALUES ('00000000015', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000022', '本市', '000000001980', '');
INSERT INTO `local_practice` VALUES ('00000000016', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000022', '本市', '000000001980', '');
INSERT INTO `local_practice` VALUES ('00000000017', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000022', '本市', '000000001980', '');
INSERT INTO `local_practice` VALUES ('00000000018', '信息工程', '张三', '00000002017', '物联网', '', '00000000015', '00000000005', '00000000022', '本市', '000000001980', '');
