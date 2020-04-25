/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : bbs_sifou

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2020-04-25 13:41:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_channels
-- ----------------------------
DROP TABLE IF EXISTS `tb_channels`;
CREATE TABLE `tb_channels` (
  `uuid` varchar(50) NOT NULL,
  `name` varchar(10) DEFAULT NULL COMMENT '名称',
  `url` varchar(50) DEFAULT NULL COMMENT '地址',
  `icon_url` varchar(255) DEFAULT NULL COMMENT '图标',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='频道表';

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `uuid` varchar(50) NOT NULL,
  `recommend_id` varchar(50) DEFAULT NULL COMMENT '文章id/问答id',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `like_number` int(9) DEFAULT '0' COMMENT '点赞数',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime DEFAULT NULL,
  `parent_id` varchar(50) DEFAULT NULL COMMENT '父级id',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论主表';

-- ----------------------------
-- Table structure for tb_labels
-- ----------------------------
DROP TABLE IF EXISTS `tb_labels`;
CREATE TABLE `tb_labels` (
  `uuid` varchar(50) NOT NULL,
  `channels_id` varchar(50) DEFAULT NULL COMMENT '频道id',
  `name` varchar(20) DEFAULT NULL COMMENT '标签名称',
  `icon_url` varchar(255) DEFAULT NULL COMMENT '图标',
  `description` varchar(120) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Table structure for tb_recommend
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommend`;
CREATE TABLE `tb_recommend` (
  `uuid` varchar(50) CHARACTER SET utf8 NOT NULL,
  `title` varchar(60) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `excerpt` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '列表展示字段',
  `content` longtext CHARACTER SET utf8mb4 COMMENT '富文本内容',
  `markdown_content` longtext COMMENT 'markdown内容',
  `image_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '封面图',
  `user_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户id',
  `channels_id` varchar(50) DEFAULT NULL COMMENT '频道id',
  `labels` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '标签id',
  `views_word` int(11) DEFAULT NULL COMMENT '阅读数',
  `status` int(1) DEFAULT NULL COMMENT '1、草稿箱  2、审核中 3、推荐',
  `type` int(1) DEFAULT NULL COMMENT '1 文章  2 问答',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=sjis COMMENT='文章、问答表';

-- ----------------------------
-- Table structure for tb_recommend_vote
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommend_vote`;
CREATE TABLE `tb_recommend_vote` (
  `uuid` varchar(50) NOT NULL,
  `recommend_id` varchar(50) DEFAULT NULL COMMENT '文章id/问答id',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章、问答点赞表';

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `uuid` varchar(50) NOT NULL,
  `nickname` varchar(10) DEFAULT NULL COMMENT '昵称',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `username` varchar(10) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `website` varchar(50) DEFAULT NULL COMMENT '个人网站',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `image_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `location_city` varchar(10) DEFAULT NULL COMMENT '所在城市',
  `address` varchar(50) DEFAULT NULL COMMENT '通讯地址',
  `resume_description` varchar(255) DEFAULT NULL COMMENT '履历说明',
  `good_at_technology` varchar(255) DEFAULT NULL COMMENT '擅长技术（逗号隔开）',
  `description` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for tb_users_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_users_info`;
CREATE TABLE `tb_users_info` (
  `uuid` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `name_sub` varchar(20) DEFAULT NULL COMMENT '子标题',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `is_time` bit(1) DEFAULT NULL COMMENT '判断结束时间是否要填',
  `city` varchar(50) DEFAULT NULL COMMENT '所在城市',
  `label_id` varchar(255) DEFAULT NULL COMMENT '标签id',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `type` int(1) DEFAULT NULL COMMENT '1、工作经历 2、教育经历 3、开源项目',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表(工作经历,教育经历,开源项目 & 文章著作)';
