/*
Navicat MySQL Data Transfer

Source Server         : 1703
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : gamemanager

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2017-07-31 16:53:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gameplayhistory
-- ----------------------------
DROP TABLE IF EXISTS `gameplayhistory`;
CREATE TABLE `gameplayhistory` (
  `game_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '��Ϸ��¼ID',
  `account` varchar(30) NOT NULL COMMENT '�û��˺�',
  `start_time` datetime NOT NULL,
  `integral_get` int(10) DEFAULT NULL COMMENT '��û���',
  `play_min` int(10) NOT NULL COMMENT '��Ϸʱ��',
  `game_name` varchar(30) NOT NULL COMMENT '��Ϸ����',
  `xp_gain_factor` double(10,2) DEFAULT '0.00' COMMENT '����ӳ�',
  `integral_gain_factor` double(10,2) DEFAULT '0.00' COMMENT '���ּӳ�',
  `record` int(10) DEFAULT NULL COMMENT '��߼�¼',
  PRIMARY KEY (`game_id`),
  KEY `FK_Reference_1` (`account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='��Ϸ��¼��';

-- ----------------------------
-- Records of gameplayhistory
-- ----------------------------

-- ----------------------------
-- Table structure for games
-- ----------------------------
DROP TABLE IF EXISTS `games`;
CREATE TABLE `games` (
  `game_id` int(10) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(30) NOT NULL COMMENT '��Ϸ����',
  `game_introduction` varchar(200) DEFAULT NULL COMMENT '��Ϸ���',
  PRIMARY KEY (`game_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='��Ϸ��';

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
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='��Ʒ��';

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
  `nick_name` varchar(50) NOT NULL COMMENT '�û��ǳ�',
  `integral` int(10) DEFAULT '0',
  `registration_date` datetime DEFAULT NULL COMMENT 'ע��ʱ��',
  `xp` double(10,2) DEFAULT '0.00',
  PRIMARY KEY (`account`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='�û���';

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('test', '123', 'test', null, null, '0.00');
INSERT INTO `userinfo` VALUES ('lxy', 'lxy', 'yoki', null, null, '0.00');
