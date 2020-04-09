/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50560
Source Host           : localhost:3306
Source Database       : bbs_sifou

Target Server Type    : MYSQL
Target Server Version : 50560
File Encoding         : 65001

Date: 2020-04-09 21:41:32
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
-- Records of tb_channels
-- ----------------------------
INSERT INTO `tb_channels` VALUES ('049b3bd76c1e49ccbe48b36197e77f76', '前端', '', '', '2020-04-08 16:42:59', '2020-04-08 16:46:24');
INSERT INTO `tb_channels` VALUES ('7b3e40f8b9cc4b7780dc39a71d7f580e', '小程序', '', '', '2020-04-08 16:43:43', '2020-04-08 16:43:43');
INSERT INTO `tb_channels` VALUES ('bb0b7e69ad3e46fcb121baefda8f1f78', '后端', '', '', '2020-04-08 16:43:25', '2020-04-08 16:43:25');

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
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('0487cdbdad7c4a6eaf3188280e18569d', 'a897a027597344ec8a60d17295c5db27', '0718f228e4e84974a2543151cb16d3cc', null, '我第三条回复', '2020-03-31 15:46:24', '9db0f9a4d7e948a59367dca56aa44199');
INSERT INTO `tb_comment` VALUES ('14b5dd5c8a124604b188fc33833fd5fd', 'a897a027597344ec8a60d17295c5db27', '0718f228e4e84974a2543151cb16d3cc', null, '我第二条评论', '2020-03-31 15:45:44', '0');
INSERT INTO `tb_comment` VALUES ('21c0cf5615da418cb1e0060156f1a21c', '', '', null, '我要删除3', '2020-03-31 16:36:42', '');
INSERT INTO `tb_comment` VALUES ('2ac7d4fa14604155b0a4f5ad06a3b73d', 'a897a027597344ec8a60d17295c5db27', '626360af29d544d0a77845df5497ebbc', null, '这是李四的回复二', '2020-03-31 16:11:12', '0');
INSERT INTO `tb_comment` VALUES ('4cdf52391d584b4b83bb89e02dc1db96', 'a897a027597344ec8a60d17295c5db27', '0718f228e4e84974a2543151cb16d3cc', null, '我第一条回复', '2020-03-31 15:46:17', '9db0f9a4d7e948a59367dca56aa44199');
INSERT INTO `tb_comment` VALUES ('4eba486813834bc48322872bb17c1238', 'a897a027597344ec8a60d17295c5db27', '626360af29d544d0a77845df5497ebbc', null, '这是李四的评论一', '2020-03-31 16:05:39', '0');
INSERT INTO `tb_comment` VALUES ('9db0f9a4d7e948a59367dca56aa44199', 'a897a027597344ec8a60d17295c5db27', '0718f228e4e84974a2543151cb16d3cc', null, '我第一条评论', '2020-03-31 15:44:25', '0');
INSERT INTO `tb_comment` VALUES ('b4f3ba2433724e7c8801b27bf780face', 'a897a027597344ec8a60d17295c5db27', '626360af29d544d0a77845df5497ebbc', null, '这是李四的回复一', '2020-03-31 16:07:25', '4eba486813834bc48322872bb17c1238');
INSERT INTO `tb_comment` VALUES ('c48038ce77b6492080c37d748cbf92a9', 'a897a027597344ec8a60d17295c5db27', '0718f228e4e84974a2543151cb16d3cc', null, '我第三条评论', '2020-03-31 15:45:49', '0');
INSERT INTO `tb_comment` VALUES ('d2011f15617149d5a44ac3a267651b70', 'a897a027597344ec8a60d17295c5db27', '0718f228e4e84974a2543151cb16d3cc', null, '我第二条回复', '2020-03-31 15:46:20', '9db0f9a4d7e948a59367dca56aa44199');
INSERT INTO `tb_comment` VALUES ('e06d600998f549c7a6aa2150ffec0b94', '', '', null, '我要删除2', '2020-03-31 16:36:40', '');

-- ----------------------------
-- Table structure for tb_follow
-- ----------------------------
DROP TABLE IF EXISTS `tb_follow`;
CREATE TABLE `tb_follow` (
  `uuid` varchar(50) NOT NULL,
  `target_id` varchar(50) DEFAULT NULL COMMENT '文章id/问答id',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL,
  `type` int(1) DEFAULT NULL COMMENT '1、标签  2、人  3、问答   4、文章  5、专栏',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章、问答关注表';

-- ----------------------------
-- Records of tb_follow
-- ----------------------------

-- ----------------------------
-- Table structure for tb_labels
-- ----------------------------
DROP TABLE IF EXISTS `tb_labels`;
CREATE TABLE `tb_labels` (
  `uuid` varchar(50) NOT NULL,
  `channels_id` varchar(50) DEFAULT NULL COMMENT '频道id',
  `name` varchar(10) DEFAULT NULL COMMENT '标签名称',
  `icon_url` varchar(255) DEFAULT NULL COMMENT '图标',
  `description` varchar(120) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标签表';

-- ----------------------------
-- Records of tb_labels
-- ----------------------------
INSERT INTO `tb_labels` VALUES ('15941dc0af92453481b8a0626f963283', '7b3e40f8b9cc4b7780dc39a71d7f580e', '微信小程序', '', '', '2020-04-09 19:49:34', '2020-04-09 19:49:34');
INSERT INTO `tb_labels` VALUES ('1d0ffae0426e4e6e8add67530ec689b4', '049b3bd76c1e49ccbe48b36197e77f76', 'html', '', '', '2020-04-09 19:47:46', '2020-04-09 19:47:46');
INSERT INTO `tb_labels` VALUES ('219d7aff8dfe4ffc9c8f368e2987187f', '7b3e40f8b9cc4b7780dc39a71d7f580e', '支付宝小程序', '', '', '2020-04-09 19:49:42', '2020-04-09 19:49:42');
INSERT INTO `tb_labels` VALUES ('3283cc5d6e714f1eb30181e3d83d99af', '7b3e40f8b9cc4b7780dc39a71d7f580e', '百度小程序', '', '', '2020-04-09 19:49:47', '2020-04-09 19:49:47');
INSERT INTO `tb_labels` VALUES ('401f1c4dcfbc499e8f7129c091c299f8', '049b3bd76c1e49ccbe48b36197e77f76', 'html5', '', '', '2020-04-09 19:48:27', '2020-04-09 19:48:27');
INSERT INTO `tb_labels` VALUES ('7b39e36da1f543c995c416f3d2950cf5', '049b3bd76c1e49ccbe48b36197e77f76', 'css', '', '', '2020-04-09 19:48:41', '2020-04-09 19:48:41');
INSERT INTO `tb_labels` VALUES ('d07dbcd8900c4d34811137be64dd4301', '049b3bd76c1e49ccbe48b36197e77f76', 'css3', '', '', '2020-04-09 19:48:44', '2020-04-09 19:48:44');
INSERT INTO `tb_labels` VALUES ('d79254c4ca5e45dca9d484307c935281', '049b3bd76c1e49ccbe48b36197e77f76', 'javascript', '', '', '2020-04-09 19:49:00', '2020-04-09 19:49:00');

-- ----------------------------
-- Table structure for tb_recommend
-- ----------------------------
DROP TABLE IF EXISTS `tb_recommend`;
CREATE TABLE `tb_recommend` (
  `uuid` varchar(50) NOT NULL,
  `title` varchar(60) DEFAULT NULL COMMENT '标题',
  `excerpt` varchar(120) DEFAULT NULL COMMENT '列表展示字段',
  `content` varchar(20000) DEFAULT NULL COMMENT '富文本内容',
  `image_url` varchar(255) DEFAULT NULL COMMENT '封面图',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `labels` varchar(255) DEFAULT NULL COMMENT '标签id',
  `votes` int(11) DEFAULT NULL COMMENT '投票数',
  `views_word` int(11) DEFAULT NULL COMMENT '阅读数',
  `status` int(1) DEFAULT NULL COMMENT '1、草稿箱  2、审核中 3、推荐',
  `type` int(1) DEFAULT NULL COMMENT '1 文章  2 问答',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章、问答表';

-- ----------------------------
-- Records of tb_recommend
-- ----------------------------
INSERT INTO `tb_recommend` VALUES ('8c0a29dfbc6e482e92c3f74567cfe13e', '“60分钟，却让我知道了我和50K的差距”，朋友如是说', '前几天朋友跟我视频说：作为一个已经开发好多年的程序员，在这次疫情面前，没有出现在裁员名单中，有一点庆幸，但是内心居然还有一点的难受，我也不知道难受的什么东西', '', '', '', null, '0', '0', '1', '1', '2020-04-08 16:02:35', '2020-04-08 16:02:35');

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
  `location_city` varchar(10) DEFAULT NULL COMMENT '所在城市',
  `address` varchar(50) DEFAULT NULL COMMENT '通讯地址',
  `resume_description` varchar(255) DEFAULT NULL COMMENT '履历说明',
  `good_at_technology` varchar(255) DEFAULT NULL COMMENT '擅长技术（逗号隔开）',
  `desc` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tb_users
-- ----------------------------

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

-- ----------------------------
-- Records of tb_users_info
-- ----------------------------
