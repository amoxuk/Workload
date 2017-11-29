/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for remote_design
-- ----------------------------
DROP TABLE IF EXISTS `remote_design`;
CREATE TABLE `remote_design` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(20) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(11) NOT NULL,
  `teach_class` int(11) NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `weeks` int(11) DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `load_coefficient` float DEFAULT NULL,
  `workload` float DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_design
-- ----------------------------
INSERT INTO `remote_design` VALUES ('00000000001', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '3', '89', '0.3', '125.1', '8757', null);
INSERT INTO `remote_design` VALUES ('00000000002', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '6', '10', '0.6', '36', '2520', null);
INSERT INTO `remote_design` VALUES ('00000000003', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '11', '0.6', '33', '2310', null);
INSERT INTO `remote_design` VALUES ('00000000004', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '55', '0.3', '157.5', '11025', null);
INSERT INTO `remote_design` VALUES ('00000000005', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000006', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000007', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000008', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000009', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000010', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000011', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000012', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000013', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000014', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000015', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000016', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000017', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000018', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000019', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000020', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', null);
INSERT INTO `remote_design` VALUES ('00000000026', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '3', '89', '0.3', '125', '8757', '');
INSERT INTO `remote_design` VALUES ('00000000027', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '6', '10', '0.6', '36', '2520', '');
INSERT INTO `remote_design` VALUES ('00000000028', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '11', '0.6', '33', '2310', '');
INSERT INTO `remote_design` VALUES ('00000000029', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '55', '0.3', '158', '11025', '');
INSERT INTO `remote_design` VALUES ('00000000030', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000031', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000032', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000033', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000034', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000035', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000036', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000037', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000038', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000039', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000040', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000041', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000042', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000043', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000044', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000045', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30', '2100', '');
