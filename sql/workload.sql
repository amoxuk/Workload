/*
Navicat MySQL Data Transfer

Source Server         : mysql_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : workload

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2018-03-17 14:16:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '0521062B', '电路与电子技术');
INSERT INTO `course` VALUES ('2', '1222554', 'huaxue');

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
  `grades` varchar(20) NOT NULL,
  `type` char(20) NOT NULL DEFAULT 'A',
  `peroid` float unsigned zerofill DEFAULT NULL,
  `people` int(10) unsigned zerofill DEFAULT NULL,
  `credit` float unsigned zerofill DEFAULT '000000000000',
  `coefficient` float unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`),
  KEY `idx_id` (`id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='实验教学表';

-- ----------------------------
-- Records of expriment
-- ----------------------------
INSERT INTO `expriment` VALUES ('0000000004', '张三', '信息', '00000002015', '00000002015', '14-计算机', 'A', '000000000015', '0000000015', '000000000000', '000000000001', '0225.00', '');
INSERT INTO `expriment` VALUES ('0000000005', '阿莫', '计算机', '00000002016', '00000002015', '15-物联网', 'A', '000000000012', '0000000015', '000000000000', '000000000001', '0180.00', null);
INSERT INTO `expriment` VALUES ('0000000006', '无误', '技术', '00000002015', '00000020015', '15-计算机', 'A', '000000000010', '0000000012', '000000000000', '000000000001', '0120.00', '');
INSERT INTO `expriment` VALUES ('0000000007', '张三', '信息', '00000002015', '00000002015', '14-计算机', 'A', '000000000015', '0000000015', '000000000000', '000000000001', '0225.00', '');
INSERT INTO `expriment` VALUES ('0000000008', '阿莫', '计算机', '00000002016', '00000002015', '15-物联网', 'A', '000000000012', '0000000015', '000000000000', '000000000001', '0180.00', '');
INSERT INTO `expriment` VALUES ('0000000009', '无误', '技术', '00000002015', '00000020015', '15-计算机', 'A', '000000000010', '0000000012', '000000000000', '000000000001', '0120.00', '');

-- ----------------------------
-- Table structure for lessons
-- ----------------------------
DROP TABLE IF EXISTS `lessons`;
CREATE TABLE `lessons` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) DEFAULT NULL COMMENT '教师ID',
  `courseId` int(11) DEFAULT NULL COMMENT '课程ID',
  `class_number` int(11) DEFAULT NULL COMMENT '教学班号',
  `student_number` int(11) DEFAULT NULL COMMENT '学生人数',
  `period` int(11) DEFAULT NULL COMMENT '学时',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lessons
-- ----------------------------
INSERT INTO `lessons` VALUES ('00000000001', '100001', '10001', '1', '25', '48');

-- ----------------------------
-- Table structure for local_course
-- ----------------------------
DROP TABLE IF EXISTS `local_course`;
CREATE TABLE `local_course` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(20) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `teach_class` int(11) unsigned zerofill NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `period` float unsigned zerofill DEFAULT NULL,
  `credit` float DEFAULT NULL,
  `people` int(11) unsigned zerofill DEFAULT NULL,
  `coefficient` float unsigned zerofill DEFAULT '000000000000',
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=358 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_course
-- ----------------------------
INSERT INTO `local_course` VALUES ('0000000347', '张三', '计算机', '00000002017', '00000001001', '计科', '000000000010', '1', '00000000055', '0000000001.1', '0011.00', '');
INSERT INTO `local_course` VALUES ('0000000348', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '10', '00000000046', '0000000001.1', '0005.50', '');
INSERT INTO `local_course` VALUES ('0000000349', '张si', '工程图学', '00000002017', '00000010001', '计算机', '000000000005', '5', '00000000010', '000000000001', '0006.00', '');
INSERT INTO `local_course` VALUES ('0000000350', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');
INSERT INTO `local_course` VALUES ('0000000351', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');
INSERT INTO `local_course` VALUES ('0000000352', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');
INSERT INTO `local_course` VALUES ('0000000353', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');
INSERT INTO `local_course` VALUES ('0000000354', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');
INSERT INTO `local_course` VALUES ('0000000355', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');
INSERT INTO `local_course` VALUES ('0000000356', '张三', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');
INSERT INTO `local_course` VALUES ('0000000357', '张三1', '计算机原理', '00000002017', '00000010001', '计算机', '000000000005', '0', '00000000010', '000000000001', '0005.00', '');

-- ----------------------------
-- Table structure for local_design
-- ----------------------------
DROP TABLE IF EXISTS `local_design`;
CREATE TABLE `local_design` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(20) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(10) unsigned zerofill NOT NULL,
  `teach_class` int(10) unsigned zerofill NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `people` int(10) unsigned zerofill DEFAULT NULL,
  `weeks` int(10) unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_design
-- ----------------------------
INSERT INTO `local_design` VALUES ('0000000001', 'amox', 'yuwne', '0000002016', '0000001001', '计科2', '0000000015', '0000000002', '0024.00', null);
INSERT INTO `local_design` VALUES ('0000000002', 'amox1', 'yuwne', '0000002016', '0000001001', '计科2', '0000000013', '0000000010', '0104.00', null);
INSERT INTO `local_design` VALUES ('0000000003', 'amox1', 'yuwne', '0000002017', '0000001001', null, null, null, null, null);
INSERT INTO `local_design` VALUES ('0000000004', 'amoxe', 'yuwne', '0000002018', '0000001001', null, null, null, null, null);

-- ----------------------------
-- Table structure for local_expriment
-- ----------------------------
DROP TABLE IF EXISTS `local_expriment`;
CREATE TABLE `local_expriment` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) NOT NULL,
  `lesson` varchar(255) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `teach_class` int(11) unsigned zerofill NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `type` char(255) DEFAULT 'A',
  `period` float unsigned zerofill DEFAULT NULL,
  `people` int(10) unsigned zerofill DEFAULT NULL,
  `load_coefficient` float unsigned zerofill DEFAULT NULL,
  `type_coefficient` float unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_expriment
-- ----------------------------
INSERT INTO `local_expriment` VALUES ('0000000013', '张三1', '计算机原理', '00000002017', '00000010001', '计算机', 'B', '000000000005', '0000000105', '0000000001.6', '0000000001.2', '0009.00', '');
INSERT INTO `local_expriment` VALUES ('0000000014', '张三2', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '0005.00', '');
INSERT INTO `local_expriment` VALUES ('0000000015', '张三3', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '0005.00', '');
INSERT INTO `local_expriment` VALUES ('0000000016', '张三4', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '0005.00', '');
INSERT INTO `local_expriment` VALUES ('0000000017', '张三5', '计算机原理', '00000002017', '00000010001', '计算机', 'A', '000000000005', '0000000010', '000000000001', '0000000001.1', '0005.00', '');
INSERT INTO `local_expriment` VALUES ('0000000018', '张三6', '计算机原理', '00000002017', '00000010001', '计算机', 'B', '000000000005', '0000000010', '000000000001', '0000000001.2', '0006.00', '');

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
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`grades`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_graduate_design
-- ----------------------------
INSERT INTO `local_graduate_design` VALUES ('00000000013', '张三1', '00000002017', '计算机', '00000000015', '00000000005', '0000000001.2', '0090.00', '');
INSERT INTO `local_graduate_design` VALUES ('00000000014', '张三2', '00000002017', '计算机', '00000000015', '00000000005', '0000000001.2', '0090.00', '');
INSERT INTO `local_graduate_design` VALUES ('00000000015', '张三3', '00000002017', '计算机', '00000000015', '00000000005', '0000000001.2', '0090.00', '');

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
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`college`,`years`,`major`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_graduate_practice
-- ----------------------------
INSERT INTO `local_graduate_practice` VALUES ('00000000011', '张三', '信息工程', '00000002017', '计算机', '00000000022', '00000000008', '本市', '0158.00', '');
INSERT INTO `local_graduate_practice` VALUES ('00000000012', '王五', '机械工程', '00000002017', '结构', '00000000015', '00000000002', '外地', '0030.00', '');

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
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_match
-- ----------------------------
INSERT INTO `local_match` VALUES ('0000000001', '张三', '0000002016', '10001', '专利', '国际级', '二等', '0032.00', null);
INSERT INTO `local_match` VALUES ('0000000003', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000004', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000005', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000006', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000007', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000008', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000009', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000010', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000011', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000012', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000013', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000014', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000015', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000016', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', null);
INSERT INTO `local_match` VALUES ('0000000017', '张三', '0000002016', '10001', '专利', '国际级', '二等', '0032.00', '');
INSERT INTO `local_match` VALUES ('0000000018', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000019', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000020', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000021', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000022', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000023', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000024', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000025', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000026', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000027', '烟雨', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000028', '张三', '0000002017', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000029', '燕山', '0000002014', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000030', '张是', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');
INSERT INTO `local_match` VALUES ('0000000031', '张三', '0000002016', '10001', '专利', '国际级', '一等', '0064.00', '');

-- ----------------------------
-- Table structure for local_net
-- ----------------------------
DROP TABLE IF EXISTS `local_net`;
CREATE TABLE `local_net` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) NOT NULL,
  `years` int(11) unsigned zerofill NOT NULL,
  `lesson` varchar(255) NOT NULL,
  `answer` int(11) unsigned zerofill DEFAULT NULL,
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`,`lesson`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_net
-- ----------------------------
INSERT INTO `local_net` VALUES ('00000000041', '张三', '00000002017', 'java', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000042', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000043', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000044', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000045', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000046', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000047', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000048', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000049', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000050', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000051', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000052', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000053', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000054', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000055', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000056', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000057', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000058', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000059', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000060', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');
INSERT INTO `local_net` VALUES ('00000000061', '张三', '00000002015', 'JAVA', '00000000020', '0012.00', '');

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
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`,`major`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_practice
-- ----------------------------
INSERT INTO `local_practice` VALUES ('00000000019', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000055', '00000000010', '00000000002', '外地', '0400.00', '');
INSERT INTO `local_practice` VALUES ('00000000020', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000001', '本市', '0090.00', '');
INSERT INTO `local_practice` VALUES ('00000000021', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000003', '野外', '0360.00', '');
INSERT INTO `local_practice` VALUES ('00000000022', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000001', '本地', '0090.00', '');
INSERT INTO `local_practice` VALUES ('00000000023', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000002', '本市', '0180.00', '');
INSERT INTO `local_practice` VALUES ('00000000024', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000003', '本市', '0270.00', '');
INSERT INTO `local_practice` VALUES ('00000000025', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000001', '本市', '0090.00', '');
INSERT INTO `local_practice` VALUES ('00000000026', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000002', '本市', '0180.00', '');
INSERT INTO `local_practice` VALUES ('00000000027', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000001', '本市', '0090.00', '');
INSERT INTO `local_practice` VALUES ('00000000028', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000010', '00000000002', '外地', '0400.00', '');
INSERT INTO `local_practice` VALUES ('00000000029', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');
INSERT INTO `local_practice` VALUES ('00000000030', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');
INSERT INTO `local_practice` VALUES ('00000000031', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');
INSERT INTO `local_practice` VALUES ('00000000032', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');
INSERT INTO `local_practice` VALUES ('00000000033', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');
INSERT INTO `local_practice` VALUES ('00000000034', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');
INSERT INTO `local_practice` VALUES ('00000000035', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');
INSERT INTO `local_practice` VALUES ('00000000036', '信息工程', '张三', '00000002017', '物联网', '市场调查实习', '00000000015', '00000000005', '00000000022', '本市', '1980.00', '');

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
  `workload` float(7,2) unsigned zerofill DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`years`,`teacher`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of local_project
-- ----------------------------
INSERT INTO `local_project` VALUES ('00000000014', '2017', '张三', '1001', '计算机专利', '创新项目', '其他', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000015', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000016', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000017', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000018', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000019', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000020', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000021', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000022', '2014', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', null);
INSERT INTO `local_project` VALUES ('00000000023', '2017', '张三', '1001', '计算机专利', '创新项目', '校级', '0016.00', '');
INSERT INTO `local_project` VALUES ('00000000024', '2017', '张三', '1001', '计算机专利', '创新项目', '省级', '0024.00', '');
INSERT INTO `local_project` VALUES ('00000000025', '2017', '张无', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000026', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000027', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000028', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000029', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000030', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000031', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000032', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000033', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000034', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000035', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000036', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000037', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000038', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000039', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000040', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000041', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000042', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000043', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000044', '2017', '张三', '1001', '计算机专利', '创新项目', '其他', '0015.00', '');
INSERT INTO `local_project` VALUES ('00000000045', '2017', '张三', '1001', '计算机专利', '创新项目', '省级', '0024.00', '');
INSERT INTO `local_project` VALUES ('00000000046', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000047', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000048', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000049', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000050', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000051', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000052', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000053', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000054', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000055', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000056', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000057', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000058', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000059', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000060', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000061', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000062', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000063', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000064', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000065', '2017', '张三', '1001', '计算机专利', '创新项目', '校级', '0016.00', '');
INSERT INTO `local_project` VALUES ('00000000066', '2017', '张三', '1001', '计算机专利', '创新项目', '省级', '0024.00', '');
INSERT INTO `local_project` VALUES ('00000000067', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000068', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000069', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000070', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000071', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000072', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000073', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000074', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000075', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000076', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000077', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000078', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000079', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000080', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000081', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000082', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000083', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000084', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000085', '2017', '张三', '1001', '计算机专利', '创新项目', '国家级', '0048.00', '');
INSERT INTO `local_project` VALUES ('00000000086', '2018', '哈哈哈', '1003', '关于。。信息', '创新项目', '国家级', '0048.00', '');

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
  `workload` float(7,2) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_design
-- ----------------------------
INSERT INTO `remote_design` VALUES ('00000000046', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '3', '89', '0.3', '125.00', '8757', '');
INSERT INTO `remote_design` VALUES ('00000000047', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '6', '10', '0.6', '36.00', '2520', '');
INSERT INTO `remote_design` VALUES ('00000000048', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '11', '0.6', '33.00', '2310', '');
INSERT INTO `remote_design` VALUES ('00000000049', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '55', '0.3', '158.00', '11025', '');
INSERT INTO `remote_design` VALUES ('00000000050', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000051', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000052', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000053', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000054', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000055', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000056', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000057', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000058', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000059', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000060', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000061', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000062', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000063', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000064', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');
INSERT INTO `remote_design` VALUES ('00000000065', '信息工程', '张三', '数据结构', '2017', '1', '计算机二班', '5', '10', '0.6', '30.00', '2100', '');

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
  `workload` float(7,2) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`,`teach_class`,`lesson`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_expriment
-- ----------------------------
INSERT INTO `remote_expriment` VALUES ('00000000188', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000189', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '5', '1.1', '27.50', '1925', '');
INSERT INTO `remote_expriment` VALUES ('00000000190', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '11', '10', '7', '1.1', '84.70', '5929', '');
INSERT INTO `remote_expriment` VALUES ('00000000191', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '2', '10', '9', '1.1', '19.80', '1386', '');
INSERT INTO `remote_expriment` VALUES ('00000000192', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '3', '10', '5', '1.1', '16.50', '1155', '');
INSERT INTO `remote_expriment` VALUES ('00000000193', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '55', '10', '8', '1.1', '484.00', '33880', '');
INSERT INTO `remote_expriment` VALUES ('00000000194', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '8', '10', '2', '1.1', '17.60', '1232', '');
INSERT INTO `remote_expriment` VALUES ('00000000195', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '9', '10', '4', '1.1', '39.60', '2772', '');
INSERT INTO `remote_expriment` VALUES ('00000000196', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '6', '10', '4', '1.1', '26.40', '1848', '');
INSERT INTO `remote_expriment` VALUES ('00000000197', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '7', '10', '4', '1.1', '30.80', '2156', '');
INSERT INTO `remote_expriment` VALUES ('00000000198', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000199', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '8', '10', '4', '1.1', '35.20', '2464', '');
INSERT INTO `remote_expriment` VALUES ('00000000200', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000201', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000202', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000203', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000204', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000205', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000206', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000207', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000208', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000209', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000210', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000211', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000212', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000213', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000214', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000215', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000216', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000217', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000218', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000219', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000220', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000221', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000222', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000223', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');
INSERT INTO `remote_expriment` VALUES ('00000000224', '信息工程', '张三', '2017', '1', '数据结构', '计算机二班', '5', '10', '4', '1.1', '22.00', '1540', '');

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
  `workload` float(7,2) DEFAULT NULL,
  `money` float(11,0) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`years`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_graduate
-- ----------------------------
INSERT INTO `remote_graduate` VALUES ('0000000026', '信息工程', '张三', '2017', '计算机', '8', '5', '36.00', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000027', '信息工程', '张三', '2017', '计算机', '8', '5', '36.00', '2520', '');
INSERT INTO `remote_graduate` VALUES ('0000000028', '信息工程', '张三', '2017', '计算机', '10', '5', '45.00', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000029', '信息工程', '张三', '2017', '计算机', '10', '5', '45.00', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000030', '信息工程', '张三', '2017', '计算机', '10', '5', '45.00', '3150', '');
INSERT INTO `remote_graduate` VALUES ('0000000031', '信息工程', '张三', '2017', '计算机', '10', '5', '45.00', '3150', '');

-- ----------------------------
-- Table structure for remote_non_lesson
-- ----------------------------
DROP TABLE IF EXISTS `remote_non_lesson`;
CREATE TABLE `remote_non_lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `colleage` varchar(20) DEFAULT NULL,
  `teacher` varchar(20) NOT NULL,
  `years` int(11) NOT NULL,
  `days` int(2) DEFAULT NULL,
  `weeks` int(2) DEFAULT NULL,
  `alldays` int(4) DEFAULT NULL,
  `allownce` float(7,2) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`teacher`,`years`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_non_lesson
-- ----------------------------
INSERT INTO `remote_non_lesson` VALUES ('2', '信息', '张三', '2016', '2', '5', '10', '1200.00', '');
INSERT INTO `remote_non_lesson` VALUES ('3', '信息', '张三', '2018', '3', '5', '15', '1800.00', '');
INSERT INTO `remote_non_lesson` VALUES ('4', '信息', '张三', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('5', '机械', '王五', '2015', '3', '5', '15', '1800.00', '');
INSERT INTO `remote_non_lesson` VALUES ('6', '机械', '张三', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('7', '化工', '张三3', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('8', '信息', '张三', '2016', '2', '5', '10', '1200.00', '');
INSERT INTO `remote_non_lesson` VALUES ('9', '信息', '张三', '2018', '3', '5', '15', '1800.00', '');
INSERT INTO `remote_non_lesson` VALUES ('10', '信息', '张三', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('11', '机械', '王五', '2015', '3', '5', '15', '1800.00', '');
INSERT INTO `remote_non_lesson` VALUES ('12', '机械', '张三', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('13', '化工', '张三3', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('14', '信息', '张三', '2016', '2', '5', '10', '1200.00', '');
INSERT INTO `remote_non_lesson` VALUES ('15', '信息', '张三', '2018', '3', '5', '15', '1800.00', '');
INSERT INTO `remote_non_lesson` VALUES ('16', '信息', '张三', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('17', '机械', '王五', '2015', '3', '5', '15', '1800.00', '');
INSERT INTO `remote_non_lesson` VALUES ('18', '机械', '张三', '2017', '2', '10', '20', '2400.00', '');
INSERT INTO `remote_non_lesson` VALUES ('19', '化工', '张三3', '2017', '2', '10', '20', '2400.00', '');

-- ----------------------------
-- Table structure for remote_teach
-- ----------------------------
DROP TABLE IF EXISTS `remote_teach`;
CREATE TABLE `remote_teach` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `college` varchar(20) NOT NULL,
  `teacher` varchar(10) NOT NULL,
  `lesson` varchar(20) NOT NULL,
  `years` int(10) NOT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `teach_class` int(10) NOT NULL,
  `period` float DEFAULT NULL,
  `credit` float DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `class_coefficient` float DEFAULT NULL,
  `workload` float(7,2) DEFAULT NULL,
  `money` float DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`college`,`teacher`,`lesson`,`years`,`teach_class`)
) ENGINE=InnoDB AUTO_INCREMENT=383 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of remote_teach
-- ----------------------------
INSERT INTO `remote_teach` VALUES ('00000000358', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '137', '1.2', '19.20', '1344', '');
INSERT INTO `remote_teach` VALUES ('00000000359', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000360', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '137', '1.2', '19.20', '1344', '');
INSERT INTO `remote_teach` VALUES ('00000000361', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000362', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '110', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000363', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000364', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '137', '1.2', '19.20', '1344', '');
INSERT INTO `remote_teach` VALUES ('00000000365', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000366', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（高分子）', '1', '16', '2', '137', '1.2', '19.20', '1344', '');
INSERT INTO `remote_teach` VALUES ('00000000367', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000368', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000369', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000370', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000371', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000372', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000373', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000374', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000375', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000376', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000377', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000378', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000379', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000380', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000381', '机械学院', '褚向前', 'MATLAB程序设计', '2017', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');
INSERT INTO `remote_teach` VALUES ('00000000382', '机械学院', '褚向前', 'MATLAB程序设计', '2016', '2016级化工（精细化工）', '2', '16', '2', '97', '1.1', '17.60', '1232', '');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) unsigned zerofill NOT NULL DEFAULT '00000000000',
  `name` varchar(10) NOT NULL,
  `college` varchar(20) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('100', '00000001001', '张三', '信息', null);
INSERT INTO `teacher` VALUES ('135', '00000000000', '张三3', null, null);
INSERT INTO `teacher` VALUES ('136', '00000000000', '王五', null, null);
INSERT INTO `teacher` VALUES ('137', '00000000000', '褚向前', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `level` int(11) unsigned zerofill DEFAULT NULL,
  `colleage` varchar(20) DEFAULT NULL,
  `tid` int(11) unsigned zerofill DEFAULT NULL,
  `user` varchar(20) NOT NULL,
  `password` varchar(40) DEFAULT NULL,
  `mail` varchar(20) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10000', '00000000001', '信息', '00000001001', 'amoxu', '11a9d9f0794dafe80ab4ed4ef6145215', 'amoxu@qq.com', '我的名字', '张三');
INSERT INTO `user` VALUES ('10001', '00000000000', '机械', '00000001002', 'misty', '11a9d9f0794dafe80ab4ed4ef6145215', 'amoxu@qq.com', 'who', '小白鼠');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `level_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(12) DEFAULT NULL,
  PRIMARY KEY (`level_id`),
  KEY `level_id` (`level_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('0', '教师');
INSERT INTO `user_role` VALUES ('1', '超级管理员');

-- ----------------------------
-- Table structure for workload
-- ----------------------------
DROP TABLE IF EXISTS `workload`;
CREATE TABLE `workload` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher` varchar(255) DEFAULT NULL,
  `lesson` varchar(255) DEFAULT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `teach_class` int(11) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `years` int(11) DEFAULT NULL,
  `people` int(11) DEFAULT NULL,
  `coefficient` float(255,0) DEFAULT NULL,
  `workload` float(255,0) DEFAULT NULL,
  `money` float(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workload
-- ----------------------------

-- ----------------------------
-- View structure for expriment_view
-- ----------------------------
DROP VIEW IF EXISTS `expriment_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `expriment_view` AS select `expriment`.`teacher` AS `teacher`,`expriment`.`years` AS `years`,sum(`expriment`.`workload`) AS `workload` from `expriment` group by `expriment`.`teacher`,`expriment`.`years` ;

-- ----------------------------
-- View structure for local_course_view
-- ----------------------------
DROP VIEW IF EXISTS `local_course_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_course_view` AS select `local_course`.`teacher` AS `teacher`,`local_course`.`years` AS `years`,sum(`local_course`.`workload`) AS `workload` from `local_course` group by `local_course`.`years`,`local_course`.`teacher` order by `local_course`.`teacher` ;

-- ----------------------------
-- View structure for local_design_view
-- ----------------------------
DROP VIEW IF EXISTS `local_design_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_design_view` AS select `local_design`.`teacher` AS `teacher`,`local_design`.`years` AS `years`,sum(`local_design`.`workload`) AS `workload` from `local_design` group by `local_design`.`years`,`local_design`.`teacher` order by `local_design`.`teacher` ;

-- ----------------------------
-- View structure for local_expriment_view
-- ----------------------------
DROP VIEW IF EXISTS `local_expriment_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_expriment_view` AS select `local_expriment`.`teacher` AS `teacher`,`local_expriment`.`years` AS `years`,sum(`local_expriment`.`workload`) AS `workload` from `local_expriment` group by `local_expriment`.`years`,`local_expriment`.`teacher` order by `local_expriment`.`teacher` ;

-- ----------------------------
-- View structure for local_graduate_design_view
-- ----------------------------
DROP VIEW IF EXISTS `local_graduate_design_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_graduate_design_view` AS select `local_graduate_design`.`teacher` AS `teacher`,`local_graduate_design`.`years` AS `years`,sum(`local_graduate_design`.`workload`) AS `workload` from `local_graduate_design` group by `local_graduate_design`.`years`,`local_graduate_design`.`teacher` order by `local_graduate_design`.`teacher` ;

-- ----------------------------
-- View structure for local_graduate_practice_view
-- ----------------------------
DROP VIEW IF EXISTS `local_graduate_practice_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_graduate_practice_view` AS select `local_graduate_practice`.`teacher` AS `teacher`,`local_graduate_practice`.`years` AS `years`,sum(`local_graduate_practice`.`workload`) AS `workload` from `local_graduate_practice` group by `local_graduate_practice`.`years`,`local_graduate_practice`.`teacher` order by `local_graduate_practice`.`teacher` ;

-- ----------------------------
-- View structure for local_match_view
-- ----------------------------
DROP VIEW IF EXISTS `local_match_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_match_view` AS select `local_match`.`teacher` AS `teacher`,`local_match`.`years` AS `years`,sum(`local_match`.`workload`) AS `workload` from `local_match` group by `local_match`.`teacher`,`local_match`.`years` order by `local_match`.`teacher` ;

-- ----------------------------
-- View structure for local_practice_view
-- ----------------------------
DROP VIEW IF EXISTS `local_practice_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_practice_view` AS select `local_practice`.`teacher` AS `teacher`,`local_practice`.`years` AS `years`,sum(`local_practice`.`workload`) AS `workload` from `local_practice` group by `local_practice`.`teacher`,`local_practice`.`years` order by `local_practice`.`teacher` ;

-- ----------------------------
-- View structure for local_project_view
-- ----------------------------
DROP VIEW IF EXISTS `local_project_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_project_view` AS select `local_project`.`teacher` AS `teacher`,sum(`local_project`.`workload`) AS `workload`,`local_project`.`years` AS `years` from `local_project` group by `local_project`.`teacher`,`local_project`.`years` order by `local_project`.`teacher` ;

-- ----------------------------
-- View structure for local_total_view
-- ----------------------------
DROP VIEW IF EXISTS `local_total_view`;
CREATE ALGORITHM=MERGE DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `local_total_view` AS select `t`.`teacher` AS `teacher`,`t`.`years` AS `years`,ifnull(`local_course_view`.`workload`,0) AS `course`,ifnull(`local_design_view`.`workload`,0) AS `design`,ifnull(`local_expriment_view`.`workload`,0) AS `expriment`,ifnull(`local_graduate_design_view`.`workload`,0) AS `graduate_design`,ifnull(`local_graduate_practice_view`.`workload`,0) AS `graduate_practice`,ifnull(`local_project_view`.`workload`,0) AS `project`,ifnull(`local_practice_view`.`workload`,0) AS `practice`,ifnull(`local_match_view`.`workload`,0) AS `matchs`,((((((ifnull(`local_course_view`.`workload`,0) + ifnull(`local_design_view`.`workload`,0)) + ifnull(`local_expriment_view`.`workload`,0)) + ifnull(`local_graduate_practice_view`.`workload`,0)) + ifnull(`local_project_view`.`workload`,0)) + ifnull(`local_practice_view`.`workload`,0)) + ifnull(`local_match_view`.`workload`,0)) AS `total` from ((((((((((select `local_course_view`.`teacher` AS `teacher`,`local_course_view`.`years` AS `years` from `workload`.`local_course_view`) union select `local_design_view`.`teacher` AS `teacher`,`local_design_view`.`years` AS `years` from `workload`.`local_design_view` union select `local_expriment_view`.`teacher` AS `teacher`,`local_expriment_view`.`years` AS `years` from `workload`.`local_expriment_view` union select `local_graduate_design_view`.`teacher` AS `teacher`,`local_graduate_design_view`.`years` AS `years` from `workload`.`local_graduate_design_view` union select `local_graduate_practice_view`.`teacher` AS `teacher`,`local_graduate_practice_view`.`years` AS `years` from `workload`.`local_graduate_practice_view` union select `local_match_view`.`teacher` AS `teacher`,`local_match_view`.`years` AS `years` from `workload`.`local_match_view` union select `local_practice_view`.`teacher` AS `teacher`,`local_practice_view`.`years` AS `years` from `workload`.`local_practice_view` union select `local_project_view`.`teacher` AS `teacher`,`local_project_view`.`years` AS `years` from `workload`.`local_project_view` group by `local_project_view`.`teacher`,`local_project_view`.`years` order by `teacher`) `t` left join `workload`.`local_course_view` on(((`local_course_view`.`teacher` = `t`.`teacher`) and (`local_course_view`.`years` = `t`.`years`)))) left join `workload`.`local_design_view` on(((`local_design_view`.`teacher` = `t`.`teacher`) and (`local_design_view`.`years` = `t`.`years`)))) left join `workload`.`local_expriment_view` on(((`local_expriment_view`.`teacher` = `t`.`teacher`) and (`local_expriment_view`.`years` = `t`.`years`)))) left join `workload`.`local_graduate_design_view` on(((`local_graduate_design_view`.`teacher` = `t`.`teacher`) and (`local_graduate_design_view`.`years` = `t`.`years`)))) left join `workload`.`local_graduate_practice_view` on(((`local_graduate_practice_view`.`teacher` = `t`.`teacher`) and (`local_graduate_practice_view`.`years` = `t`.`years`)))) left join `workload`.`local_project_view` on(((`local_project_view`.`teacher` = `t`.`teacher`) and (`local_project_view`.`years` = `t`.`years`)))) left join `workload`.`local_practice_view` on(((`local_practice_view`.`teacher` = `t`.`teacher`) and (`local_practice_view`.`years` = `t`.`years`)))) left join `workload`.`local_match_view` on(((`local_match_view`.`teacher` = `t`.`teacher`) and (`local_match_view`.`years` = `t`.`years`)))) ;

-- ----------------------------
-- View structure for remote_design_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_design_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_design_view` AS select `remote_design`.`teacher` AS `teacher`,`remote_design`.`years` AS `years`,sum(`remote_design`.`workload`) AS `workload` from `remote_design` group by `remote_design`.`teacher`,`remote_design`.`years` order by `remote_design`.`teacher` ;

-- ----------------------------
-- View structure for remote_expriment_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_expriment_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_expriment_view` AS select `remote_expriment`.`teacher` AS `teacher`,`remote_expriment`.`years` AS `years`,sum(`remote_expriment`.`workload`) AS `workload` from `remote_expriment` group by `remote_expriment`.`teacher`,`remote_expriment`.`years` order by `remote_expriment`.`teacher` ;

-- ----------------------------
-- View structure for remote_graduate_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_graduate_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_graduate_view` AS select `remote_graduate`.`teacher` AS `teacher`,`remote_graduate`.`years` AS `years`,sum(`remote_graduate`.`workload`) AS `workload` from `remote_graduate` group by `remote_graduate`.`teacher`,`remote_graduate`.`years` order by `remote_graduate`.`teacher` ;

-- ----------------------------
-- View structure for remote_non_lesson_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_non_lesson_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_non_lesson_view` AS select sum(`remote_non_lesson`.`allownce`) AS `allownce`,`remote_non_lesson`.`teacher` AS `teacher`,`remote_non_lesson`.`years` AS `years` from `remote_non_lesson` group by `remote_non_lesson`.`teacher`,`remote_non_lesson`.`years` order by `remote_non_lesson`.`teacher` ;

-- ----------------------------
-- View structure for remote_teach_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_teach_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_teach_view` AS select `remote_teach`.`teacher` AS `teacher`,`remote_teach`.`years` AS `years`,sum(`remote_teach`.`workload`) AS `workload` from `remote_teach` group by `remote_teach`.`teacher`,`remote_teach`.`years` order by `remote_teach`.`teacher` ;

-- ----------------------------
-- View structure for remote_total_view
-- ----------------------------
DROP VIEW IF EXISTS `remote_total_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `remote_total_view` AS select `t`.`teacher` AS `teacher`,`t`.`years` AS `years`,ifnull(`remote_teach_view`.`workload`,0) AS `course`,ifnull(`remote_design_view`.`workload`,0) AS `design`,ifnull(`remote_expriment_view`.`workload`,0) AS `expriment`,ifnull(`remote_graduate_view`.`workload`,0) AS `graduate`,ifnull(`remote_non_lesson_view`.`allownce`,0) AS `non_lesson`,(((((ifnull(`remote_teach_view`.`workload`,0) + ifnull(`remote_non_lesson_view`.`allownce`,0)) + ifnull(`remote_design_view`.`workload`,0)) + ifnull(`remote_expriment_view`.`workload`,0)) + ifnull(`remote_graduate_view`.`workload`,0)) + ifnull(`remote_non_lesson_view`.`allownce`,0)) AS `total` from (((((((select `remote_design_view`.`teacher` AS `teacher`,`remote_design_view`.`years` AS `years` from `workload`.`remote_design_view`) union select `remote_expriment_view`.`teacher` AS `teacher`,`remote_expriment_view`.`years` AS `years` from `workload`.`remote_expriment_view` union select `remote_graduate_view`.`teacher` AS `teacher`,`remote_graduate_view`.`years` AS `years` from `workload`.`remote_graduate_view` union select `remote_non_lesson_view`.`teacher` AS `teacher`,`remote_non_lesson_view`.`years` AS `years` from `workload`.`remote_non_lesson_view` union select `remote_teach_view`.`teacher` AS `teacher`,`remote_teach_view`.`years` AS `years` from `workload`.`remote_teach_view` group by `remote_teach_view`.`teacher`,`remote_teach_view`.`years` order by `teacher`) `t` left join `workload`.`remote_teach_view` on(((`remote_teach_view`.`teacher` = `t`.`teacher`) and (`remote_teach_view`.`years` = `t`.`years`)))) left join `workload`.`remote_design_view` on(((`remote_design_view`.`teacher` = `t`.`teacher`) and (`remote_design_view`.`years` = `t`.`years`)))) left join `workload`.`remote_expriment_view` on(((`remote_expriment_view`.`teacher` = `t`.`teacher`) and (`remote_expriment_view`.`years` = `t`.`years`)))) left join `workload`.`remote_graduate_view` on(((`remote_graduate_view`.`teacher` = `t`.`teacher`) and (`remote_graduate_view`.`years` = `t`.`years`)))) left join `workload`.`remote_non_lesson_view` on(((`remote_non_lesson_view`.`teacher` = `t`.`teacher`) and (`remote_non_lesson_view`.`years` = `t`.`years`)))) ;

-- ----------------------------
-- View structure for teacher_remote_view
-- ----------------------------
DROP VIEW IF EXISTS `teacher_remote_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_remote_view` AS select `remote_teach`.`college` AS `college`,`remote_teach`.`teacher` AS `teacher` from `remote_teach` union select `remote_non_lesson`.`colleage` AS `colleage`,`remote_non_lesson`.`teacher` AS `teacher` from `remote_non_lesson` union select `remote_graduate`.`college` AS `college`,`remote_graduate`.`teacher` AS `teacher` from `remote_graduate` union select `remote_expriment`.`college` AS `college`,`remote_expriment`.`teacher` AS `teacher` from `remote_expriment` union select `remote_design`.`college` AS `college`,`remote_design`.`teacher` AS `teacher` from `remote_design` ;

-- ----------------------------
-- View structure for test_remote_teacher_view
-- ----------------------------
DROP VIEW IF EXISTS `test_remote_teacher_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `test_remote_teacher_view` AS select `t`.`teacher` AS `name` from ((select `remote_design_view`.`teacher` AS `teacher`,`remote_design_view`.`years` AS `years`,'design' AS `type` from `workload`.`remote_design_view`) union select `remote_expriment_view`.`teacher` AS `teacher`,`remote_expriment_view`.`years` AS `years`,'expriment' AS `type` from `workload`.`remote_expriment_view` union select `remote_graduate_view`.`teacher` AS `teacher`,`remote_graduate_view`.`years` AS `years`,'graduate' AS `type` from `workload`.`remote_graduate_view` union select `remote_non_lesson_view`.`teacher` AS `teacher`,`remote_non_lesson_view`.`years` AS `years`,'non_lesson' AS `type` from `workload`.`remote_non_lesson_view` union select `remote_teach_view`.`teacher` AS `teacher`,`remote_teach_view`.`years` AS `years`,'teach' AS `type` from `workload`.`remote_teach_view`) `t` group by `t`.`teacher` order by `t`.`teacher` ;

-- ----------------------------
-- Procedure structure for test_proc
-- ----------------------------
DROP PROCEDURE IF EXISTS `test_proc`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_proc`()
BEGIN
INSERT INTO teacher(name)
 SELECT test_remote_teacher_view.name FROM test_remote_teacher_view WHERE test_remote_teacher_view.name not in (SELECT `name` FROM teacher);
end
;;
DELIMITER ;

-- ----------------------------
-- Function structure for ins
-- ----------------------------
DROP FUNCTION IF EXISTS `ins`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `ins`() RETURNS int(11)
BEGIN
	#Routine body goes here...

set @i :=0;
WHILE @i<100 do
INSERT INTO `local_course` (
	`teacher`,
	`lesson`,
	`years`,
	`teach_class`,
	`grades`,
	`period`,
	`credit`,
	`people`,
	`coefficient`,
	`workload`,
	`note`
)
VALUES
	(
		CONCAT('张三',@i),
		'计算机原理',
		'2017',
		'10001',
		'计算机',
		'5',
		'0',
		'10',
		'1',
		'5',
		''
	);
set @i := @i+1;
end WHILE;

	RETURN 0;
END
;;
DELIMITER ;
