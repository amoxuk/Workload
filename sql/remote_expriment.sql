/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for remote_expriment
-- ----------------------------
DROP TABLE IF EXISTS `remote_expriment`;
CREATE TABLE `remote_expriment` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(40) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  `years` int(11) NOT NULL,
  `teach_class` int(11) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `period` float DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `re_coefficient` float DEFAULT NULL,
  `type_coefficient` float DEFAULT NULL,
  `workload` float DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`,`teach_class`,`lesson`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_expriment
-- ----------------------------
INSERT INTO `remote_expriment` VALUES ('00000000151', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '0.6', '12', '840', '');
INSERT INTO `remote_expriment` VALUES ('00000000152', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '5', '0.6', '15', '1050', '');
INSERT INTO `remote_expriment` VALUES ('00000000153', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '11', '10', '7', '0.6', '46.2', '3234', '');
INSERT INTO `remote_expriment` VALUES ('00000000154', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '2', '10', '9', '0.6', '10.8', '756', '');
INSERT INTO `remote_expriment` VALUES ('00000000155', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '3', '10', '5', '0.6', '9', '630', '');
INSERT INTO `remote_expriment` VALUES ('00000000156', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '20', '10', '8', '0.6', '96', '6720', '');
INSERT INTO `remote_expriment` VALUES ('00000000157', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '8', '10', '2', '0.6', '9.6', '672', '');
INSERT INTO `remote_expriment` VALUES ('00000000158', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '9', '10', '4', '0.6', '21.6', '1512', '');
INSERT INTO `remote_expriment` VALUES ('00000000159', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '6', '10', '4', '0.6', '14.4', '1008', '');
INSERT INTO `remote_expriment` VALUES ('00000000160', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '7', '10', '4', '0.6', '16.8', '1176', '');
INSERT INTO `remote_expriment` VALUES ('00000000161', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000162', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '8', '10', '4', '1.1', '35.2', '2464', '');
INSERT INTO `remote_expriment` VALUES ('00000000163', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000164', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000165', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000166', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000167', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000168', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000169', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000170', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000171', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000172', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000173', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000174', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000175', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000176', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000177', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000178', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000179', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000180', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000181', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000182', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000183', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000184', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000185', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000186', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000187', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22', '1540', '');
