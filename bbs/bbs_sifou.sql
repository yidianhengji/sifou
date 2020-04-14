/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : bbs_sifou

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-04-14 16:53:54
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
INSERT INTO `tb_channels` VALUES ('04547238127a4676b504cc4496865d7b', '安全', 'netsec', '', '2020-04-14 09:23:09', '2020-04-14 09:23:09');
INSERT INTO `tb_channels` VALUES ('049b3bd76c1e49ccbe48b36197e77f76', '前端', 'frontend', '', '2020-04-08 16:42:59', '2020-04-10 11:33:53');
INSERT INTO `tb_channels` VALUES ('19eb3dd59ef8430d9f637d97449fc417', '开源', 'oss', '', '2020-04-14 09:23:41', '2020-04-14 09:23:41');
INSERT INTO `tb_channels` VALUES ('1a7cc9fbc4654cb0afec84e080816ef1', '游戏', 'game', '', '2020-04-14 09:22:59', '2020-04-14 09:22:59');
INSERT INTO `tb_channels` VALUES ('2a353971222c4aff8e8d3e9c370330cd', '工具', 'toolkit', '', '2020-04-14 09:23:54', '2020-04-14 09:23:54');
INSERT INTO `tb_channels` VALUES ('3798854967b444e0b8156e5154f94b97', '区块链', 'bc', '', '2020-04-14 09:23:31', '2020-04-14 09:23:31');
INSERT INTO `tb_channels` VALUES ('7b3e40f8b9cc4b7780dc39a71d7f580e', '小程序', 'miniprogram', '', '2020-04-08 16:43:43', '2020-04-08 16:43:43');
INSERT INTO `tb_channels` VALUES ('819ad72c1efe450f9d7affc135a4b457', 'Android', 'android', '', '2020-04-14 09:22:31', '2020-04-14 09:22:31');
INSERT INTO `tb_channels` VALUES ('91832bd0c3a244fb88c0bca74c0d404d', '程序员', 'programmer', '', '2020-04-14 09:24:04', '2020-04-14 09:24:04');
INSERT INTO `tb_channels` VALUES ('a0ea520851b4484f9cebac9ff7e47bc6', '金融科技', 'fintech', '', '2020-04-14 09:23:17', '2020-04-14 09:23:17');
INSERT INTO `tb_channels` VALUES ('a2718d66a7234b1499ed897ff4df05c8', '行业', 'industry', '', '2020-04-14 09:24:15', '2020-04-14 09:24:15');
INSERT INTO `tb_channels` VALUES ('a337904dd1d5477b9689d7693be316de', 'IOS', 'ios', '', '2020-04-14 09:22:11', '2020-04-14 09:22:11');
INSERT INTO `tb_channels` VALUES ('b299a2a48cd64e77a3431ce958b42055', '云计算', 'cloud', '', '2020-04-14 09:22:49', '2020-04-14 09:22:49');
INSERT INTO `tb_channels` VALUES ('bb0b7e69ad3e46fcb121baefda8f1f78', '后端', 'backend', '', '2020-04-08 16:43:25', '2020-04-08 16:43:25');
INSERT INTO `tb_channels` VALUES ('cbad2058b4014634aec6515f4adbef0d', 'AI', 'ai', '', '2020-04-14 09:22:41', '2020-04-14 09:22:41');

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
INSERT INTO `tb_comment` VALUES ('30e30671ffb04f12b5047753bca66f52', '062bca4100ca40a1b39e7226b216bf12', 'd6754affc7864ea9b67b61e493d28614', '0', '我是评论4', '2020-04-14 15:34:51', '');
INSERT INTO `tb_comment` VALUES ('47a7bc7cf5ca481fb9785bac2db8251c', '062bca4100ca40a1b39e7226b216bf12', 'd6754affc7864ea9b67b61e493d28614', '0', '我是评论3', '2020-04-14 15:34:43', '');
INSERT INTO `tb_comment` VALUES ('728a0954563542ae9e38108669de6ccf', '062bca4100ca40a1b39e7226b216bf12', 'd6754affc7864ea9b67b61e493d28614', '0', '我是回复1-1', '2020-04-14 15:35:23', 'f18e7b63ceca4166b65c23451535abaa');
INSERT INTO `tb_comment` VALUES ('7615021c3af346e791516fc443b03cc7', '062bca4100ca40a1b39e7226b216bf12', 'd6754affc7864ea9b67b61e493d28614', '0', '我是回复1-3', '2020-04-14 15:35:39', 'f18e7b63ceca4166b65c23451535abaa');
INSERT INTO `tb_comment` VALUES ('76d33636d29b4f78a717d148dca1a23e', '062bca4100ca40a1b39e7226b216bf12', 'd6754affc7864ea9b67b61e493d28614', '0', '我是回复1-2', '2020-04-14 15:35:35', 'f18e7b63ceca4166b65c23451535abaa');
INSERT INTO `tb_comment` VALUES ('7bef431461844a9da921ad1ab29c41d3', '062bca4100ca40a1b39e7226b216bf12', 'd6754affc7864ea9b67b61e493d28614', '0', '我是回复1-4', '2020-04-14 15:35:43', 'f18e7b63ceca4166b65c23451535abaa');
INSERT INTO `tb_comment` VALUES ('f18e7b63ceca4166b65c23451535abaa', '062bca4100ca40a1b39e7226b216bf12', 'd6754affc7864ea9b67b61e493d28614', '0', '我是评论1', '2020-04-14 15:34:08', '');

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
  `excerpt` varchar(255) DEFAULT NULL COMMENT '列表展示字段',
  `content` longtext COMMENT '富文本内容',
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
INSERT INTO `tb_recommend` VALUES ('062bca4100ca40a1b39e7226b216bf12', 'Python正则表达式，这一篇就够了！', '大多数编程语言的正则表达式设计都师从Perl，所以语法基本相似，不同的是每种语言都有自己的函数去支持正则，今天我们就来学习 Python中关于 正则表达式的函数。re模块主要定义了9个常量、12个函数、1个异常，每...', null, 'https://segmentfault.com/img/remote/1460000022242430', null, null, '0', '3', null, null, '2020-04-14 13:29:45', '2020-04-14 14:50:50');
INSERT INTO `tb_recommend` VALUES ('195fab0542d34d768e4bb7b5cf2b9fc6', '[译]Flutter - 使用Provider实现状态管理', '这篇文章好的的地方在于它不仅讲了Flutter Provider如何管理State的，还讲述了一个Flutter App可以采用哪一种架构。这种架构是基于clean architecture和FilledStacks这两种架构原则的（这里可能理解或者表达有误...', null, 'https://segmentfault.com/img/remote/1460000022263766', null, null, '0', '0', null, null, '2020-04-14 13:29:43', '2020-04-14 13:29:43');
INSERT INTO `tb_recommend` VALUES ('2b2da5abcf724c5b9a7e0c5e634108bc', '闲鱼Flutter图片框架架构演进（超详细）', '图片对一个端侧研发来说是一老生常谈的话题了。闲鱼作为业界在Flutter技术方向上最早一批投入的团队。从使用Flutter之初，图片就是我们核心关注和重点优化的功能。图片算是闲鱼业务场景下最为重要的内容表现形式...', null, 'https://segmentfault.com/img/remote/1460000022312435', null, null, '0', '0', null, null, '2020-04-14 13:29:40', '2020-04-14 13:29:40');
INSERT INTO `tb_recommend` VALUES ('3227230289094ce9a948d1ff524d7174', 'Flutter异常监测与上报', '众所周知，软件项目的交付是一个复杂的过程，任何原因都有可能导致交付的失败。很多时候经常遇到的一个现象是，应用在开发测试时没有任何异常，但一旦上线就问题频出。出现这些异常，可能是因为不充分的机型适配...', null, 'https://segmentfault.com/img/remote/1460000022280731', null, null, '0', '0', null, null, '2020-04-14 13:29:43', '2020-04-14 13:29:43');
INSERT INTO `tb_recommend` VALUES ('3a0dbc22bba0477dbc686889b5d32f48', 'DoKit - 滴滴开源的一款功能齐全的客户端（ iOS 、Android ）研发助手', 'SegmentFault 思否消息：滴滴技术团队今天宣布，Dokit 3.0 版本正式发布，DoraemonKit，简称 DoKit，中文名哆啦 A 梦，是滴滴开源的一款功能齐全的客户端（ iOS 、Android ）研发助手。', null, 'https://segmentfault.com/img/remote/1460000022238554', null, null, '0', '0', null, null, '2020-04-14 13:29:46', '2020-04-14 13:29:46');
INSERT INTO `tb_recommend` VALUES ('4e7bf885fc7246df8289c0722d65917f', '中国提出 NEW IP 标准化提案，欲代替现行的 TCP/IP', '英国的《金融时报》近日发表新闻报道，华为联合中国联通、中国电信、中国工信部（MIIT）等向联合国国际电信联盟（ITU）提出了一份全新的网络架构「NEW IP」，并打算在 2030 年用 NEW IP 代替现行的 TCP/IP。', null, 'https://segmentfault.com/img/remote/1460000022225839', null, null, '0', '0', null, null, '2020-04-14 13:29:48', '2020-04-14 13:29:48');
INSERT INTO `tb_recommend` VALUES ('516a5928fcc74600a07352f685f52c57', '做一个震动App', '最近发现给老爸买的安卓手机，电池出现了点问题，充电只能充到60%，还每次都弹出这烦人的警告。感觉这是设计好的，整整好好用了3年，这未免有点太巧了吧？', null, 'https://segmentfault.com/img/remote/1460000022328679', null, null, '0', '0', null, null, '2020-04-14 13:29:36', '2020-04-14 13:29:36');
INSERT INTO `tb_recommend` VALUES ('5e1da24c2a0347198b972126913800f5', '与国同悲，愿我们用技术改变世界', '与国同悲，SegmentFault 思否技术媒体全线暂停更新一天。 特别专题丨新型肺炎防疫，做好防护，我们整理了一些有价值的内容 如何获取靠谱的新型冠状病毒疫情 肺炎前线的科技公司 广东科技出版社发布《新型冠状病毒...', null, 'https://segmentfault.com/img/bVbFzxj', null, null, '0', '0', null, null, '2020-04-14 13:29:44', '2020-04-14 13:29:44');
INSERT INTO `tb_recommend` VALUES ('722636fc688d4623a2d53b6df122c01b', 'iOS SpringBoard tweak插件，双击图标快速启动debugserver', 'debugserver+lldb很好用，但启动起来太麻烦？我们开发了一款iOS SpringBoard tweak小插件，简化debugserver启动过程。老铁，请双击！', null, 'https://segmentfault.com/img/remote/1460000022326917', null, null, '0', '0', null, null, '2020-04-14 13:29:37', '2020-04-14 13:29:37');
INSERT INTO `tb_recommend` VALUES ('734f5ac7e6964f2892da3b5f63236d11', '什么是HSTS，为什么要使用它？', '翻译自：What Is HSTS and Why Should I Use It?作者：Tomasz Andrzej Nidecki，一位非常专业的 Technical Content Writer ，目前是 Acunetix 的技术内容撰写人，他是一名拥有 25 年 IT 经验的记者、翻译和技术撰...', null, 'https://segmentfault.com/img/remote/1460000022316263', null, null, '0', '0', null, null, '2020-04-14 13:29:38', '2020-04-14 13:29:38');
INSERT INTO `tb_recommend` VALUES ('8135b0f5dac14b1d8af1af619693eecf', '【译】10个帮助你捕获更多Bug的TypeScript建议', '然而这个想法是错误的！因为TypeScript最终是被编译成JavaScript代码，并且浏览器中运行的也是JavaScript。此时（译者注：运行时）所有的类型信息都丢失了，所以TypeScript无法自动验证类型。', null, null, null, null, '0', '0', null, null, '2020-04-14 13:29:43', '2020-04-14 13:29:43');
INSERT INTO `tb_recommend` VALUES ('8372a1170c1a4af3a59d49bbff4d8a24', 'IINA 播放器开发者称其开源项目，屡次被盗用上架并且收费获利', 'IINA，是一个基于 mpv、契合 macOS 设计风格、力求做到最佳用户体验、轻便且功能强大的视频播放器项目。IINA 以 mpv 为播放核心，所以享受到了 mpv 解码和图像方面的所有优点。IINA 使用了 libmpv 的 C API，来提...', null, 'https://segmentfault.com/img/remote/1460000022271502', null, null, '0', '0', null, null, '2020-04-14 13:29:41', '2020-04-14 13:29:41');
INSERT INTO `tb_recommend` VALUES ('845c389b4fec4b20987069eff15eab2f', 'core-js 作者入狱 18 个月，周下载 2600 万次的开源项目恐将无人维护', '俄罗斯开发者丹尼斯·普什卡列夫（Denis Pushkarev）是 JavaScript 的模块化标准库 Core-js 的唯一维护人员。去年 10 月，其因驾驶摩托车时撞到了两位行人并造成其中一人死亡，上诉无效后，最终被判处 18 个月有期...', null, 'https://segmentfault.com/img/bVbFwal', null, null, '0', '0', null, null, '2020-04-14 13:29:44', '2020-04-14 13:29:44');
INSERT INTO `tb_recommend` VALUES ('8a782341c1844b358706e73ac9c391c7', '[Skr-Shop]购物车之架构设计', 'skr shop是一群底层码农，由于被工作中的项目折磨的精神失常，加之由于程序员的自傲：别人设计的系统都是一坨shit，我的设计才是宇宙最牛逼，于是乎决定要做一个只设计不编码的电商设计手册。', null, 'https://segmentfault.com/img/remote/1460000022277102', null, null, '0', '0', null, null, '2020-04-14 13:29:42', '2020-04-14 13:29:42');
INSERT INTO `tb_recommend` VALUES ('9af09d4707854093ba12a095a41ae59a', '谷歌十年愚人节，「玩笑」背后是美好生活的企盼', '2010 年愚人节，谷歌宣布公司将更名为托皮卡。谷歌在公司官方博客中称，“美国堪萨斯州首府托皮卡市市长比尔·顿本（Bill Bunten）本月初宣布，托皮卡市要将名称改为谷歌，这令全世界吃惊。我们一直疑惑如何实现这...', null, 'https://segmentfault.com/img/remote/1460000022230822', null, null, '0', '0', null, null, '2020-04-14 13:29:47', '2020-04-14 13:29:47');
INSERT INTO `tb_recommend` VALUES ('9b903cf2a1d240a6a1415a4535ca06ed', '跨端开发框架深度横评之2020版', '对应小程序开发领域，这一年也发生了巨大变化。开发框架从单纯的微信小程序开发，过渡到多端框架成为标配，进一步提升开发效率成为开发者的强烈需求。', null, 'https://segmentfault.com/img/remote/1460000022326485', null, null, '0', '0', null, null, '2020-04-14 13:29:37', '2020-04-14 13:29:37');
INSERT INTO `tb_recommend` VALUES ('9be7b0cf45c54947ba4c6b2ef55b6b65', '服务网格平台探索性指南', '开发人员需要确保跨服务的通信是安全的。他们还需要实施分布式跟踪，以告知每次调用需要多长时间。重试，断路器等分布式服务的一些最佳实践为服务带来了弹性。微服务通常是多语言的，并使用不同的库和SDK。编写通...', null, 'https://segmentfault.com/img/bVbFq1z', null, null, '0', '0', null, null, '2020-04-14 13:29:47', '2020-04-14 13:29:47');
INSERT INTO `tb_recommend` VALUES ('a34e1f9c8a74472d944c37bbbf0c8519', 'MySQL 同步复制及高可用方案总结', 'mysql作为应用程序的数据存储服务，要实现mysql数据库的高可用。必然要使用的技术就是数据库的复制，如果主节点出现故障可以手动的切换应用到从节点，这点相信运维同学都是知道，并且可以实现的。但是这种情况只...', null, 'https://segmentfault.com/img/remote/1460000022313467', null, null, '0', '0', null, null, '2020-04-14 13:29:39', '2020-04-14 13:29:39');
INSERT INTO `tb_recommend` VALUES ('a3a6099281ca404f871a89fb1fcc04fe', '2020年，一文点破跨平台开发框架现状', '多年来，跨平台移动开发已经获得了最流行软件开发趋势之一的声誉。这并不令人意外，因为采用跨平台开发技术使得软件工程师使用同一代码就能为不同平台构建应用程序，从而节省时间、金钱以及不必要的工作。', null, 'https://segmentfault.com/img/remote/1460000022237119', null, null, '0', '0', null, null, '2020-04-14 13:29:46', '2020-04-14 13:29:46');
INSERT INTO `tb_recommend` VALUES ('a55f84e3300f41f09276c428957223ab', '面试问我，创建多少个线程合适？我该怎么说', '你有一个思想，我有一个思想，我们交换后，一个人就有两个思想 If you can NOT explain it simply, you do NOT understand it well enough', null, 'https://segmentfault.com/img/bVbFIun', null, null, '0', '0', null, null, '2020-04-14 13:29:41', '2020-04-14 13:29:41');
INSERT INTO `tb_recommend` VALUES ('af95cb478a3f44a7a66fc79db2e06531', '那些功能逆天，却鲜为人知的pandas骚操作', 'pandas有一种功能非常强大的方法，它就是accessor，可以将它理解为一种属性接口，通过它可以获得额外的方法。其实这样说还是很笼统，下面我们通过代码和实例来理解一下。', null, 'https://segmentfault.com/img/remote/1460000022271880', null, null, '0', '0', null, null, '2020-04-14 13:29:42', '2020-04-14 13:29:42');
INSERT INTO `tb_recommend` VALUES ('b029ff0a04ae4220a80b2355d5c460ad', '我的本科回忆录：从迷茫自卑到保送华科', '今天看新闻，多地高三终于开学了，看着他们风华正茂的样子，想着他们几个月后就要成为大学校园的一份子，我自己不禁也感慨万千。 说长不长，说短不短，距离我踏入大学本科校园的日子也已经过去快11年了。 我觉得...', null, 'https://segmentfault.com/img/remote/1460000022298589', null, null, '0', '0', null, null, '2020-04-14 13:29:38', '2020-04-14 13:29:38');
INSERT INTO `tb_recommend` VALUES ('b0b9117c060a4b948ea65d86b855ca66', 'Redis快速入门，学会这15点，真的够用了！', '     REmote DIctionary Server(Redis)是一个由Salvatore Sanfilippo写的key-value存储系统。Redis是一个开源的使用ANSI C语言编写、遵守BSD协议、支持网络、可基于内存亦可持久化的日志型、Key-Value数据库，并...', null, 'https://segmentfault.com/img/remote/1460000022353598', null, null, '0', '0', null, null, '2020-04-14 13:29:36', '2020-04-14 13:29:36');
INSERT INTO `tb_recommend` VALUES ('b60b1426462d48a39beba98b5e33ab4c', '小程序框架运行时性能大测评', '随着小程序在商业上的巨大成功，小程序开发在国内前端领域越来越受到重视，为了方便广大开发者更好地进行小程序开发，各类小程序框架也层出不穷，呈现出百花齐放的态势。但是到目前为止，业内一直没有出现一份全...', null, 'https://segmentfault.com/img/remote/1460000022249437', null, null, '0', '0', null, null, '2020-04-14 13:29:45', '2020-04-14 13:29:45');
INSERT INTO `tb_recommend` VALUES ('b9b1cafae2b045d2aa3dfd2984c494d1', '好玩、有趣的 Linux 命令学习神器 kmdr！', '所以，大家也会遇到这样的情况，不太懂的命令用法，我们会去查找资料。据不完全统计，Linux系统常见的命令约600+个，一时间想全部掌握太难了，特别对于一个初学者来说，更是难上加难。', null, 'https://segmentfault.com/img/remote/1460000022226937', null, null, '0', '0', null, null, '2020-04-14 13:29:47', '2020-04-14 13:29:47');
INSERT INTO `tb_recommend` VALUES ('bce98f9f583d4d14a90f946421592385', '事件驱动及其设计模式', '在GUI编程中，事件是非常常见的。比如，用户在界面点击了按钮，就会发送一个“点击”事件，而相应的会有一个处理“点击”事件的事件处理器会来处理该事件。', null, 'https://segmentfault.com/img/remote/1460000022048090', null, null, '0', '0', null, null, '2020-04-14 13:29:39', '2020-04-14 13:29:39');
INSERT INTO `tb_recommend` VALUES ('c8fbdd6de71a433e90b2e98eab483c03', '限时0元免费领!!! 8门程序员进阶必修课、机械键盘等多重好礼等你来拿!', '2020末尾，一场疫情突然袭来。 企业延迟开工、学校延迟开学、取消考试及比赛等事件打乱了每个人的计划。 很多人待在家浑浑噩噩，但他们不知道有一部分人却在这个时间段疯狂充实自己！ ​ 国内疫情已经基本控制住，...', null, 'https://segmentfault.com/img/remote/1460000022365419', null, null, '0', '0', null, null, '2020-04-14 13:29:35', '2020-04-14 13:29:35');
INSERT INTO `tb_recommend` VALUES ('dd14ed9677e44171bf8484f370118755', '2020年十大最佳自动化测试工具', '对更快交付高质量软件（或\"快速质量\"）的需求要求组织以敏捷，持续集成（CI）和DevOps方法论来寻找解决方案。测试自动化是这些方面的重要组成部分。最新的《 2018-2019年世界质量报告》表明，测试自动化是实现\"快...', null, 'https://segmentfault.com/img/remote/1460000022303938', null, null, '0', '0', null, null, '2020-04-14 13:29:40', '2020-04-14 13:29:40');
INSERT INTO `tb_recommend` VALUES ('e480f217b4614c48a8b670a5ce2772e1', '互联网通信云 PaaS 选型 开发者必备指南', '几乎所有技术团队都经历过服务选型问题，在最常见的 3 大云服务交付模式（IaaS、PaaS、SaaS）中，PaaS 是目前市场上增速最快的交付模式，选型过程也是最令开发者头疼的。而相同问题往往不止一种解决方案，如何才...', null, 'https://segmentfault.com/img/bVbFGJz', null, null, '0', '0', null, null, '2020-04-14 13:29:38', '2020-04-14 13:29:38');
INSERT INTO `tb_recommend` VALUES ('ea1892c8facd4a35a82c77afef00736b', 'GNU Guix 将终止对 Linux 内核的支持，全面替换为 GNU Hurd', 'GNU Guix 项目官方近日宣布，正在用 GNU Hurd 替换其 Linux（确切地说是GNU Linux-libre）内核，Guix 1.1 将是最后一个支持 Linux 的版本。', null, 'https://segmentfault.com/img/bVbFHty', null, null, '0', '0', null, null, '2020-04-14 13:29:41', '2020-04-14 13:29:41');

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
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('6d86ce8599a94f12ad1191fa38797771', '哈哈哈1', 'e10adc3949ba59abbe56e057f20f883e', null, '18588773301', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_users` VALUES ('ab6384d237e645c8a5afbb8f4c8aaead', '哈哈哈', 'e10adc3949ba59abbe56e057f20f883e', null, '18588773304', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tb_users` VALUES ('d6754affc7864ea9b67b61e493d28614', '12', 'fcea920f7412b5da7be0cf42b8c93759', null, '18588773302', null, null, null, null, null, null, null, null, '2020-04-10 13:51:26', '2020-04-10 13:51:26');

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
