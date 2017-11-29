/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for local_match
-- ----------------------------
DROP TABLE IF EXISTS `local_match`;
CREATE TABLE `local_match` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) NOT NULL,
  `years` int(10) unsigned zerofill NOT NULL,
  `number` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_match
-- ----------------------------
INSERT INTO `local_match` VALUES ('0000000001', '张三', '0000002016', '10001', '专利', '国际级', '二等', '000000000032', null);
INSERT INTO `local_match` VALUES ('0000000003', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000004', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000005', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000006', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000007', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000008', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000009', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000010', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000011', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000012', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000013', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000014', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000015', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000016', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', null);
INSERT INTO `local_match` VALUES ('0000000017', '张三', '0000002016', '10001', '专利', '国际级', '二等', '000000000032', '');
INSERT INTO `local_match` VALUES ('0000000018', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000019', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000020', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000021', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000022', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000023', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000024', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000025', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000026', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000027', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000028', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000029', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000030', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
INSERT INTO `local_match` VALUES ('0000000031', '张三', '0000002016', '10001', '专利', '国际级', '一等', '000000000064', '');
