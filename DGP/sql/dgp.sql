/*
Navicat MySQL Data Transfer

Source Server         : cewin
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : dgp

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2017-08-08 09:05:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gameinfo
-- ----------------------------
DROP TABLE IF EXISTS `gameinfo`;
CREATE TABLE `gameinfo` (
  `account` varchar(30) NOT NULL,
  `current_gameinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(30) DEFAULT NULL,
  `current_skin` int(2) DEFAULT '1',
  `current_box` int(2) DEFAULT '1',
  PRIMARY KEY (`current_gameinfo_id`),
  KEY `account` (`account`),
  CONSTRAINT `gameinfo_ibfk_1` FOREIGN KEY (`account`) REFERENCES `userinfo` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gameinfo
-- ----------------------------
INSERT INTO `gameinfo` VALUES ('cewin', '10', '推箱子', '1', '1');
INSERT INTO `gameinfo` VALUES ('1', '11', '推箱子', '1', '1');
INSERT INTO `gameinfo` VALUES ('cynthia', '12', '推箱子', '1', '1');
INSERT INTO `gameinfo` VALUES ('duitang', '13', '推箱子', '1', '1');
INSERT INTO `gameinfo` VALUES ('777', '14', '推箱子', '2', '2');

-- ----------------------------
-- Table structure for gameplayhistory
-- ----------------------------
DROP TABLE IF EXISTS `gameplayhistory`;
CREATE TABLE `gameplayhistory` (
  `gameplay_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '��Ϸ��¼ID',
  `account` varchar(30) NOT NULL COMMENT '�û��˺�',
  `game_name` varchar(30) NOT NULL COMMENT '��Ϸ����',
  `start_time` datetime NOT NULL,
  `play_min` int(10) NOT NULL COMMENT '��Ϸʱ��',
  `integral_get` int(10) DEFAULT NULL COMMENT '��û���',
  `integral_gain_factor` double(10,2) DEFAULT '0.00' COMMENT '���ּӳ�',
  `xp_get` varchar(255) DEFAULT NULL,
  `xp_gain_factor` double(10,2) DEFAULT '0.00' COMMENT '����ӳ�',
  `record` int(10) DEFAULT NULL COMMENT '��߼�¼',
  `result` int(1) DEFAULT '0',
  PRIMARY KEY (`gameplay_id`),
  KEY `FK_Reference_1` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='��Ϸ��¼��';

-- ----------------------------
-- Records of gameplayhistory
-- ----------------------------
INSERT INTO `gameplayhistory` VALUES ('48', 'cewin', '推箱子', '2017-08-06 14:41:59', '5', '5950', '0.00', '5950', '0.00', '0', '1');
INSERT INTO `gameplayhistory` VALUES ('49', 'cewin', '推箱子', '2017-08-06 14:42:07', '7', '5930', '0.00', '5930', '0.00', '0', '1');
INSERT INTO `gameplayhistory` VALUES ('50', 'cewin', '推箱子', '2017-08-06 14:44:20', '4', '5960', '0.00', '5960', '0.00', '0', '1');
INSERT INTO `gameplayhistory` VALUES ('51', 'cewin', '推箱子', '2017-08-06 14:45:11', '5', '5950', '0.00', '5950', '0.00', '1', '1');
INSERT INTO `gameplayhistory` VALUES ('52', 'cewin', '推箱子', '2017-08-06 14:45:18', '9', '5910', '0.00', '5910', '0.00', '5', '1');
INSERT INTO `gameplayhistory` VALUES ('55', 'duitang', '推箱子', '2017-08-07 15:58:58', '6', '5940', '0.00', '5940', '0.00', '1', '1');
INSERT INTO `gameplayhistory` VALUES ('56', 'duitang', '推箱子', '2017-08-07 15:59:11', '8', '5920', '0.00', '5920', '0.00', '4', '1');
INSERT INTO `gameplayhistory` VALUES ('57', '777', '推箱子', '2017-08-07 19:36:22', '4', '5960', '0.00', '5960', '0.00', '1', '1');
INSERT INTO `gameplayhistory` VALUES ('58', '777', '推箱子', '2017-08-07 19:39:35', '45', '0', '0.00', '0', '0.00', '1', '0');
INSERT INTO `gameplayhistory` VALUES ('59', '777', '推箱子', '2017-08-07 19:42:24', '38', '5620', '0.00', '5620', '0.00', '2', '1');
INSERT INTO `gameplayhistory` VALUES ('60', '777', '推箱子', '2017-08-07 19:44:06', '84', '5160', '0.00', '5160', '0.00', '4', '1');

-- ----------------------------
-- Table structure for games
-- ----------------------------
DROP TABLE IF EXISTS `games`;
CREATE TABLE `games` (
  `game_id` int(10) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(30) NOT NULL COMMENT '��Ϸ����',
  `game_introduction` varchar(200) DEFAULT NULL COMMENT '��Ϸ���',
  PRIMARY KEY (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ϸ��';

-- ----------------------------
-- Records of games
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(30) NOT NULL COMMENT '��Ʒ����',
  `goods_price` int(10) NOT NULL COMMENT '��Ʒ�۸�',
  `goods_introduction` varchar(200) DEFAULT NULL COMMENT '��Ʒ���',
  `xp_gain_factory` double(10,2) DEFAULT NULL COMMENT '����ӳ�',
  `integral_gain_factor` double(10,2) DEFAULT NULL COMMENT '���ּӳ�',
  `game_id` varchar(30) NOT NULL COMMENT '��ϷID',
  PRIMARY KEY (`goods_id`),
  KEY `FK_Reference_2` (`game_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ʒ��';

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `account` varchar(30) NOT NULL COMMENT '�û��˺�',
  `pass_word` varchar(30) NOT NULL COMMENT '�û�����',
  `email` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) NOT NULL COMMENT '�û��ǳ�',
  `integral` int(10) DEFAULT '0',
  `registration_date` datetime DEFAULT NULL COMMENT 'ע��ʱ��',
  `xp` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '123', 'cewin95@qq.com', '1号人物', '0', '2017-08-04 16:09:35', '0.00');
INSERT INTO `userinfo` VALUES ('777', '777', 'cewin95@foxmail.com', '123', '16740', '2017-08-07 19:29:59', '16740.00');
INSERT INTO `userinfo` VALUES ('cewin', '123', 'cewin95@qq.com', '李超程', '153670', '2017-08-04 10:40:39', '153670.00');
INSERT INTO `userinfo` VALUES ('cynthia', 'jiangchan123', 'cynthia47@foxmail.com', '豆芽', '11560', '2017-08-04 21:00:51', '11560.00');
INSERT INTO `userinfo` VALUES ('duitang', '123', 'cewin95@foxmail.com', '堆糖', '23710', '2017-08-07 15:43:02', '23710.00');
