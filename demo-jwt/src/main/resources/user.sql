/*
Navicat MySQL Data Transfer

Source Server         : jwt测试
Source Server Version : 80028
Source Host           : localhost:3306
Source Database       : jwt

Target Server Type    : MYSQL
Target Server Version : 80028
File Encoding         : 65001

Date: 2022-10-26 16:45:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xwc', '123456');
