/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `level` int(11) unsigned zerofill DEFAULT NULL,
  `teacher_id` int(11) unsigned zerofill DEFAULT NULL,
  `colleage` varchar(20) DEFAULT NULL,
  `user` varchar(20) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `mail` varchar(20) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00000000001', '00000000001', '00000001001', '信息工程', 'amoxu', '093926600491b6033fd60c40f5e4bae9', '852989844@qq.com', null, null);
