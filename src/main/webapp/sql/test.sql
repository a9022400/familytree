/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-04-04 16:32:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'paperID',
  `name` varchar(100) NOT NULL COMMENT 'paper名称',
  `number` int(11) NOT NULL COMMENT 'paper数量',
  `detail` varchar(200) NOT NULL COMMENT 'paper描述',
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='paper表';

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('1', '机器学习', '2', 'mlmlmlml');
INSERT INTO `paper` VALUES ('2', '深度学习', '3', 'dldldl');
INSERT INTO `paper` VALUES ('3', '大数据', '4', 'bdbdbd');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `login_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `login_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `purview` varchar(40) DEFAULT NULL,
  `modify_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `modify_uuid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `modify_ip` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `create_uuid` varchar(40) DEFAULT NULL,
  `create_ip` varchar(40) DEFAULT NULL,
  `try_times` int(1) DEFAULT NULL COMMENT '尝试登陆次数，超过5次，禁止登陆',
  `status` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '0-禁止登陆，1-正常，2-需修改密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `old_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `birth` date NOT NULL,
  `father_idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mother_idcard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '',
  `partner_idcard` varchar(18) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `text` varchar(255) DEFAULT NULL,
  `temp1` varchar(255) DEFAULT NULL,
  `temp2` varchar(255) DEFAULT NULL,
  `temp3` varchar(255) DEFAULT NULL,
  `temp4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '', '孙大大', '孙小小', '男', '0001', '2001-08-25', '0002', '0003', null, null, '他是管理员啊', null, null, null, null);
INSERT INTO `user_info` VALUES ('2', '', '孙爸爸', '孙霸霸', '男', '0002', '1980-08-08', '0004', '0005', null, null, '他是管理员的爸爸', null, null, null, null);
INSERT INTO `user_info` VALUES ('3', '', '孙妈妈', '孙玛玛', '女', '0003', '1981-07-07', '0006', '0007', null, null, '他是管理员的妈妈', null, null, null, null);
INSERT INTO `user_info` VALUES ('4', '', '孙爷爷', '孙烨烨', '男', '0004', '1949-10-01', null, null, null, null, '他是管理员的爷爷', null, null, null, null);
INSERT INTO `user_info` VALUES ('5', '', '孙奶奶', '孙乃乃', '女', '0005', '1956-06-03', null, null, null, null, '他是管理员的奶奶', null, null, null, null);
INSERT INTO `user_info` VALUES ('6', '', '孙外公', '孙歪公', '男', '0006', '1950-04-04', null, null, null, null, '他是管理员的外公', null, null, null, null);
INSERT INTO `user_info` VALUES ('7', '', '孙外婆', '孙歪婆', '女', '0007', '1955-03-03', null, null, null, null, '他是管理员的外婆', null, null, null, null);
INSERT INTO `user_info` VALUES ('8', '', '孙爷爷', '孙ss', '男', '0008', '2019-01-03', '0006', '0007', null, null, '他是管理员的舅舅', null, null, null, null);
INSERT INTO `user_info` VALUES ('11', '', '小星星', '小星啊', '女', '0009', '2016-01-26', null, null, null, null, '巴巴啊啊', null, null, null, null);
