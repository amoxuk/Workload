/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-11-29 23:07:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for local_project
-- ----------------------------
DROP TABLE IF EXISTS `local_project`;
CREATE TABLE `local_project` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `years` int(11) NOT NULL,
  `teacher` varchar(255) NOT NULL,
  `number` varchar(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `workload` float unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`years`,`teacher`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_project
-- ----------------------------
INSERT INTO `local_project` VALUES ('00000000001', '2017', '张三', '1001', '计算机专利', '创新项目', '其他', '000000000015', null);
INSERT INTO `local_project` VALUES ('00000000002', '2017', '张三', '1001', '计算机专利', '创新项目', '省级', '000000000024', null);
INSERT INTO `local_project` VALUES ('00000000004', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000005', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000006', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000007', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000008', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000009', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000010', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000011', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000012', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000013', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000014', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000015', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000016', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000017', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000018', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000019', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000020', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000021', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000022', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', null);
INSERT INTO `local_project` VALUES ('00000000023', '2017', '张三', '1001', '计算机专利', '创新项目', '校级', '000000000016', '');
INSERT INTO `local_project` VALUES ('00000000024', '2017', '张三', '1001', '计算机专利', '创新项目', '省级', '000000000024', '');
INSERT INTO `local_project` VALUES ('00000000025', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000026', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000027', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000028', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000029', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000030', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000031', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000032', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000033', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000034', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000035', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000036', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000037', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000038', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000039', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000040', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000041', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000042', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000043', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000044', '2017', '张三', '1001', '计算机专利', '创新项目', '其他', '000000000015', '');
INSERT INTO `local_project` VALUES ('00000000045', '2017', '张三', '1001', '计算机专利', '创新项目', '省级', '000000000024', '');
INSERT INTO `local_project` VALUES ('00000000046', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000047', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000048', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000049', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000050', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000051', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000052', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000053', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000054', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000055', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000056', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000057', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000058', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000059', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000060', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000061', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000062', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000063', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000064', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000065', '2017', '张三', '1001', '计算机专利', '创新项目', '校级', '000000000016', '');
INSERT INTO `local_project` VALUES ('00000000066', '2017', '张三', '1001', '计算机专利', '创新项目', '省级', '000000000024', '');
INSERT INTO `local_project` VALUES ('00000000067', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000068', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000069', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000070', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000071', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000072', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000073', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000074', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000075', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000076', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000077', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000078', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000079', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000080', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000081', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000082', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000083', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000084', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
INSERT INTO `local_project` VALUES ('00000000085', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '000000000048', '');
