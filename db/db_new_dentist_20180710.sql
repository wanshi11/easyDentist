/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_new_dentist

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-10 00:28:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章标题',
  `title` varchar(100) NOT NULL,
  `keyWords` varchar(100) DEFAULT NULL COMMENT '关键字',
  `articleType` varchar(30) NOT NULL COMMENT '文章类型',
  `createTime` datetime NOT NULL,
  `introduction` varchar(800) NOT NULL COMMENT '简介',
  `top` int(1) NOT NULL COMMENT '是否置顶',
  `status` varchar(255) NOT NULL COMMENT '文章状态',
  `operatorId` int(11) NOT NULL COMMENT '操作员ID',
  `thumbnailUrl` varchar(100) NOT NULL COMMENT '缩略图url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('18', '王申：“80后”种植牙医，带着“死磕”精神热血前行', '种植牙', 'ARTICLE_NEWS', '2018-07-09 00:09:59', '如今再提起“80后”，大多数人印象里还是那群热血沸腾的青年人。当“90后”占据舆论，“00后”初露锋芒，“80后”这个曾经站在风口浪尖上的群体，早已沉淀成熟，低调的在各行各业发光发热，成为社会的中流砥柱，成为行业的精英人才。', '1', '1', '1', '/Dentist_UPLOAD/image/art_thumbnail/20180709000953_3.png');
INSERT INTO `t_article` VALUES ('19', '33333333', '333333', 'ARTICLE_NEWS', '2018-07-09 00:27:09', '666666666666666', '0', '1', '1', '/Dentist_UPLOAD/image/art_thumbnail/20180709002706_3.png');
INSERT INTO `t_article` VALUES ('20', '555555', '555555555', 'ARTICLE_HEALTH', '2018-07-09 00:34:38', '11111', '1', '1', '1', '/Dentist_UPLOAD/image/art_thumbnail/20180709003433_2.png');
INSERT INTO `t_article` VALUES ('21', '怎么回事啊', '怎么回事啊', 'ARTICLE_YH_ACTIVITY', '2018-07-09 00:37:40', '6666666', '0', '1', '1', '/Dentist_UPLOAD/image/art_thumbnail/20180709003737_1.png');
INSERT INTO `t_article` VALUES ('22', '666666666', '666666666', 'ARTICLE_YH_ACTIVITY', '2018-07-09 21:40:21', '王申，1981年生，妥妥的“80后大叔”，毕业于上海交通大学医学院，口腔医学硕士。作为一位年仅36岁的口腔专家，王申在口腔领域的专注和坚持，让他身上有着很多耀眼的光环：“上海九院种植修复专家”、“口腔种植学会(ITI)会员”、“口腔医学会口腔种植专业委员会青年委员”……”。', '0', '0', '1', '/Dentist_UPLOAD/image/art_thumbnail/20180709214017_3.png');

-- ----------------------------
-- Table structure for `t_article_ext`
-- ----------------------------
DROP TABLE IF EXISTS `t_article_ext`;
CREATE TABLE `t_article_ext` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `articleId` int(11) NOT NULL COMMENT '文章ID',
  `content` text NOT NULL COMMENT '文章内容',
  `readValue` int(7) NOT NULL DEFAULT '0' COMMENT '阅读量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article_ext
-- ----------------------------
INSERT INTO `t_article_ext` VALUES ('12', '18', '<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 如今再提起“80后”，大多数人印象里还是那群热血沸腾的青年人。当“90后”占据舆论，“00后”初露锋芒，“80后”这个曾经站在风口浪尖上的群体，早已沉淀成熟，低调的在各行各业发光发热，成为社会的中流砥柱，成为行业的精英人才。</p><p><strong>人近中年，热血未凉，希波克拉底誓词犹在耳旁</strong></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 王申，1981年生，妥妥的“80后大叔”，毕业于上海交通大学医学院，口腔医学硕士。作为一位年仅36岁的口腔专家，王申在口腔领域的专注和坚持，让他身上有着很多耀眼的光环：“上海九院种植修复专家”、“口腔种植学会(ITI)会员”、“口腔医学会口腔种植专业委员会青年委员”……”。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 不到中年已然得志，拥有着可以“恃才傲物”的实力，但王申却非常低调，成熟内敛的性格与他的职业十分契合。作为医生的他认为医学十分严肃，需要近乎“死磕”的严谨。但是在面对客户的同事的时候，王申还是会展现自己略带逗比的一面，因为在他的心中，每一个客户的信任都非常的重要，他希望是以朋友的身份帮助他们，而不是扮演一个冷冰冰的医生去俯视患者。</p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; “医生应该被‘尊敬’，却不是‘敬畏’”。谈到如今敏感微妙的医患关系，王申沉思片刻说道：“我希望当顾客牙齿不舒服时，会像想起一个老朋友一样找我帮忙，而不是带着心理压力紧张的拖延，到后一刻来求助医生”。不希望顾客遭受无谓的痛苦，为了让顾客能够轻松就诊，不惧怕治疗，王申总是会用尽各种办法消灭作为医生与患者的距离感。真切的站在顾客立场，通过自己的专业为顾客制定更体贴的解决方案，正是这一点，让他收获了很多顾客的尊重。都说上海阿姨多挑剔，但年轻有为的王申却有一个“阿姨阿叔”粉丝团。</p><p><strong>接诊“牙齿掉光”的同龄人，很心痛</strong></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2016年，王申接诊了一位年龄与他相仿的顾客，全口牙缺失，即使已经从业十几年，王申还是难免痛心。因为早的少数牙缺失，拖一拖发展到后牙齿全部掉光，本不应如此啊!虽说顾客后通过种植牙重新恢复，但王申却意识到，人们对于“基础牙病”、“单科牙缺失”的不重视，导致后牙缺失发展到非常严重的程度才不得不去医院就诊，已成为目前非常普遍的现象了。“口腔保健拖延症”、“非等到口腔疾病严重影响到生活才后知后觉”，王申对这些社会常态充满忧虑。</p><p>此后稍有空闲，王申就会在个人社交账号上发布口腔科普知识，让大家了解口腔疾病、口腔治疗流程，从而不再畏惧“拔牙”、“种牙”、“看牙医”;不厌其烦的“唠叨”大家一定要重视口腔健康，出现问题及时止损，避免拖到更严重的程度…</p><p>曾经，少年人一腔热血投身口腔医疗事业，在修学到执业的近20年里，王申多次赴瑞士、意大利、日本等国家进修，二十年磨一剑;如今，王申已完成上万例牙齿种植修复病例，手术成功率之高，更使他在业内被誉为“种植奇才”，而往后的行医路，他仍选择赤诚前行。</p><p><strong>专家简介</strong></p><p style=\"text-align:center;\"><strong><img alt=\"\" src=\"http://www.shsbyk.com/uploads/allimg/171113/1-1G113140PT01.JPG\" style=\"width:400px;height:267px;\" /></strong></p><p><strong>王申</strong></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 上海交通大学医学院口腔医学硕士，2003至2013年在上海交大附属第九人民医院口腔种植科任职，专业从事种植及修复工作10余年。上海口腔医学会口腔种植专业委员会委员、口腔种植学会(ITI)会员、中华口腔种植专业委员会会员，瑞士straumann种植培训讲师，多次赴瑞士、意大利、美国等国家进修。擅长微创种植、即刻种植、All-on-4种植技术。</p>', '0');
INSERT INTO `t_article_ext` VALUES ('13', '19', '<br />\r\n<br />\r\n如今再提起“80后”，大多数人印象里还是那群热血沸腾的青年人。当“90后”占据舆论，“00后”初露锋芒，“80后”这个曾经站在风口浪尖上的群体，早已沉淀成熟，低调的在各行各业发光发热，成为社会的中流砥柱，成为行业的精英人才。<br />\r\n<br />\r\n人近中年，热血未凉，希波克拉底誓词犹在耳旁<br />\r\n<br />\r\n王申，1981年生，妥妥的“80后大叔”，毕业于上海交通大学医学院，口腔医学硕士。作为一位年仅36岁的口腔专家，王申在口腔领域的专注和坚持，让他身上有着很多耀眼的光环：“上海九院种植修复专家”、“口腔种植学会(ITI)会员”、“口腔医学会口腔种植专业委员会青年委员”……”。<br />\r\n<br />\r\n不到中年已然得志，拥有着可以“恃才傲物”的实力，但王申却非常低调，成熟内敛的性格与他的职业十分契合。作为医生的他认为医学十分严肃，需要近乎“死磕”的严谨。但是在面对客户的同事的时候，王申还是会展现自己略带逗比的一面，因为在他的心中，每一个客户的信任都非常的重要，他希望是以朋友的身份帮助他们，而不是扮演一个冷冰冰的医生去俯视患者。<br />\r\n<br />\r\n“医生应该被‘尊敬’，却不是‘敬畏’”。谈到如今敏感微妙的医患关系，王申沉思片刻说道：“我希望当顾客牙齿不舒服时，会像想起一个老朋友一样找我帮忙，而不是带着心理压力紧张的拖延，到后一刻来求助医生”。不希望顾客遭受无谓的痛苦，为了让顾客能够轻松就诊，不惧怕治疗，王申总是会用尽各种办法消灭作为医生与患者的距离感。真切的站在顾客立场，通过自己的专业为顾客制定更体贴的解决方案，正是这一点，让他收获了很多顾客的尊重。都说上海阿姨多挑剔，但年轻有为的王申却有一个“阿姨阿叔”粉丝团。<br />\r\n<br />\r\n接诊“牙齿掉光”的同龄人，很心痛<br />\r\n<br />\r\n2016年，王申接诊了一位年龄与他相仿的顾客，全口牙缺失，即使已经从业十几年，王申还是难免痛心。因为早的少数牙缺失，拖一拖发展到后牙齿全部掉光，本不应如此啊!虽说顾客后通过种植牙重新恢复，但王申却意识到，人们对于“基础牙病”、“单科牙缺失”的不重视，导致后牙缺失发展到非常严重的程度才不得不去医院就诊，已成为目前非常普遍的现象了。“口腔保健拖延症”、“非等到口腔疾病严重影响到生活才后知后觉”，王申对这些社会常态充满忧虑。<br />\r\n<br />\r\n此后稍有空闲，王申就会在个人社交账号上发布口腔科普知识，让大家了解口腔疾病、口腔治疗流程，从而不再畏惧“拔牙”、“种牙”、“看牙医”;不厌其烦的“唠叨”大家一定要重视口腔健康，出现问题及时止损，避免拖到更严重的程度…<br />\r\n<br />\r\n曾经，少年人一腔热血投身口腔医疗事业，在修学到执业的近20年里，王申多次赴瑞士、意大利、日本等国家进修，二十年磨一剑;如今，王申已完成上万例牙齿种植修复病例，手术成功率之高，更使他在业内被誉为“种植奇才”，而往后的行医路，他仍选择赤诚前行。<br />\r\n<br />\r\n专家简介<br />\r\n<div align=\"center\">\r\n	<img src=\"/Dentist_UPLOAD/kindeditor_files/image/20180709/20180709002600_592.png\" alt=\"\" /><br />\r\n</div>\r\n王申<br />\r\n<br />\r\n上海交通大学医学院口腔医学硕士，2003至2013年在上海交大附属第九人民医院口腔种植科任职，专业从事种植及修复工作10余年。上海口腔医学会口腔种植专业委员会委员、口腔种植学会(ITI)会员、中华口腔种植专业委员会会员，瑞士straumann种植培训讲师，多次赴瑞士、意大利、美国等国家进修。擅长微创种植、即刻种植、All-on-4种植技术。<br />\r\n<br />', '0');
INSERT INTO `t_article_ext` VALUES ('14', '20', '<div align=\"center\">\r\n	<p>\r\n		<strong>小阿森纳达拉斯来拿地阿斯弄电脑斯内德</strong>\r\n	</p>\r\n	<p align=\"left\">\r\n		&nbsp;mldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmas。\r\n	</p>\r\n	<p align=\"center\">\r\n		<img src=\"/Dentist_UPLOAD/kindeditor_files/image/20180709/20180709003213_559.png\" alt=\"\" />\r\n	</p>\r\n	<p align=\"center\">\r\n		&nbsp;mldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmasmldmas。图片链接：<a href=\"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531075841105&di=9a7ccf5ab42439e532b5206544aaae90&imgtype=0&src=http%3A%2F%2Ffiles.b2b.cn%2Fproduct%2FProductImages%2F2013_01%2F22%2F085%2F22085235691.jpg\" target=\"_blank\">https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1531075841105&amp;di=9a7ccf5ab42439e532b5206544aaae90&amp;imgtype=0&amp;src=http%3A%2F%2Ffiles.b2b.cn%2Fproduct%2FProductImages%2F2013_01%2F22%2F085%2F22085235691.jpg</a>\r\n	</p>\r\n</div>', '0');
INSERT INTO `t_article_ext` VALUES ('15', '21', '怎么回事啊怎么回事啊怎么回事啊<img src=\"/Dentist_UPLOAD/kindeditor_files/image/20180709/20180709003730_812.png\" alt=\"\" />', '0');
INSERT INTO `t_article_ext` VALUES ('16', '22', '<p align=\"center\">\r\n	<strong><span style=\"font-size:14px;\">人近中年，热血未凉，希波克拉底誓词犹在耳旁</span></strong>\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \r\n王申，1981年生，妥妥的“80后大叔”，毕业于上海交通大学医学院，口腔医学硕士。作为一位年仅36岁的口腔专家，王申在口腔领域的专注和坚持，让他身上有着很多耀眼的光环：“上海九院种植修复专家”、“口腔种植学会(ITI)会员”、“口腔医学会口腔种植专业委员会青年委员”……”。\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n不到中年已然得志，拥有着可以“恃才傲物”的实力，但王申却非常低调，成熟内敛的性格与他的职业十分契合。作为医生的他认为医学十分严肃，需要近乎“死磕”的严谨。但是在面对客户的同事的时候，王申还是会展现自己略带逗比的一面，因为在他的心中，每一个客户的信任都非常的重要，他希望是以朋友的身份帮助他们，而不是扮演一个冷冰冰的医生去俯视患者。\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n“医生应该被‘尊敬’，却不是‘敬畏’”。谈到如今敏感微妙的医患关系，王申沉思片刻说道：“我希望当顾客牙齿不舒服时，会像想起一个老朋友一样找我帮忙，而不是带着心理压力紧张的拖延，到后一刻来求助医生”。不希望顾客遭受无谓的痛苦，为了让顾客能够轻松就诊，不惧怕治疗，王申总是会用尽各种办法消灭作为医生与患者的距离感。真切的站在顾客立场，通过自己的专业为顾客制定更体贴的解决方案，正是这一点，让他收获了很多顾客的尊重。都说上海阿姨多挑剔，但年轻有为的王申却有一个“阿姨阿叔”粉丝团。\r\n</p>\r\n<p align=\"center\">\r\n	<strong><span style=\"font-size:14px;\">接诊“牙齿掉光”的同龄人，很心痛</span></strong>\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n2016年，王申接诊了一位年龄与他相仿的顾客，全口牙缺失，即使已经从业十几年，王申还是难免痛心。因为早的少数牙缺失，拖一拖发展到后牙齿全部掉光，本不应如此啊!虽说顾客后通过种植牙重新恢复，但王申却意识到，人们对于“基础牙病”、“单科牙缺失”的不重视，导致后牙缺失发展到非常严重的程度才不得不去医院就诊，已成为目前非常普遍的现象了。“口腔保健拖延症”、“非等到口腔疾病严重影响到生活才后知后觉”，王申对这些社会常态充满忧虑。\r\n</p>\r\n<p>\r\n	此后稍有空闲，王申就会在个人社交账号上发布口腔科普知识，让大家了解口腔疾病、口腔治疗流程，从而不再畏惧“拔牙”、“种牙”、“看牙医”;不厌其烦的“唠叨”大家一定要重视口腔健康，出现问题及时止损，避免拖到更严重的程度…\r\n</p>\r\n<p>\r\n	曾经，少年人一腔热血投身口腔医疗事业，在修学到执业的近20年里，王申多次赴瑞士、意大利、日本等国家进修，二十年磨一剑;如今，王申已完成上万例牙齿种植修复病例，手术成功率之高，更使他在业内被誉为“种植奇才”，而往后的行医路，他仍选择赤诚前行。\r\n</p>\r\n<p>\r\n	<strong>专家简介</strong>\r\n</p>\r\n<p style=\"text-align:center;\">\r\n	<strong><img alt=\"\" src=\"http://www.shsbyk.com/uploads/allimg/171113/1-1G113140PT01.JPG\" style=\"width:400px;height:267px;\" /></strong>\r\n</p>\r\n<p align=\"center\">\r\n	<strong>王申</strong>\r\n</p>\r\n<p>\r\n	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n上海交通大学医学院口腔医学硕士，2003至2013年在上海交大附属第九人民医院口腔种植科任职，专业从事种植及修复工作10余年。上海口腔医学会口腔种植专业委员会委员、口腔种植学会(ITI)会员、中华口腔种植专业委员会会员，瑞士straumann种植培训讲师，多次赴瑞士、意大利、美国等国家进修。擅长微创种植、即刻种植、All-on-4种植技术。\r\n</p>', '0');

-- ----------------------------
-- Table structure for `t_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bannerName` varchar(50) NOT NULL COMMENT 'banner名称',
  `picUrl` varchar(255) NOT NULL COMMENT '图片路径',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'banner状态',
  `href` varchar(50) DEFAULT NULL COMMENT '超链接地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_banner
-- ----------------------------

-- ----------------------------
-- Table structure for `t_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_config`;
CREATE TABLE `t_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(20) NOT NULL,
  `descr` varchar(20) DEFAULT NULL,
  `value` varchar(20) DEFAULT NULL,
  `updateTime` datetime NOT NULL,
  `operatorId` int(11) NOT NULL COMMENT '操作员Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_config
-- ----------------------------

-- ----------------------------
-- Table structure for `t_dentist`
-- ----------------------------
DROP TABLE IF EXISTS `t_dentist`;
CREATE TABLE `t_dentist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(20) NOT NULL COMMENT '医生名称',
  `education` varchar(15) DEFAULT NULL COMMENT '学历',
  `

schools` varchar(15) DEFAULT NULL COMMENT '毕业院校',
  `position` varchar(20) DEFAULT NULL COMMENT '职位',
  `

qualification` varchar(300) DEFAULT NULL COMMENT '资质',
  `major` varchar(300) DEFAULT NULL COMMENT '专业特长',
  `picUrl` varchar(50) NOT NULL COMMENT '图片路径',
  `ext` varchar(20) DEFAULT NULL COMMENT '扩展',
  `createTime` datetime DEFAULT NULL,
  `operatorId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dentist
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(20) NOT NULL COMMENT '菜单名称',
  `menuDescribe` varchar(50) NOT NULL COMMENT '描述',
  `parentId` int(20) DEFAULT NULL COMMENT '父菜单ID',
  `url` varchar(100) DEFAULT NULL COMMENT '方法路径',
  `version` varchar(20) DEFAULT NULL COMMENT '扩展',
  `createTime` datetime DEFAULT NULL,
  `operatorId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '用户&角色管理', '用户与角色', null, null, null, '2018-06-30 19:02:03', '1');
INSERT INTO `t_menu` VALUES ('2', '图文管理', '文章和Banner', null, null, null, '2018-06-15 17:17:43', '1');
INSERT INTO `t_menu` VALUES ('3', '菜单管理', '菜单', null, null, null, '2018-06-15 17:20:15', '1');
INSERT INTO `t_menu` VALUES ('4', '用户管理', '用户', '1', '/admin/user/toBgUser', null, '2018-06-16 16:44:06', '1');
INSERT INTO `t_menu` VALUES ('5', '角色管理', '角色', '1', '/admin/role/toRoles', null, '2018-06-29 11:39:09', '1');
INSERT INTO `t_menu` VALUES ('7', '菜单列表', 'menulist', '3', '/admin/menu/toMenus', null, '2018-06-16 18:12:17', '1');
INSERT INTO `t_menu` VALUES ('8', '赋予角色', '分配角色', '1', '/admin/role/toGiveRoles', null, '2018-06-25 23:44:55', '1');
INSERT INTO `t_menu` VALUES ('9', '分配菜单', '分配菜单', '3', '/admin/menu/toAllotMenus', null, '2018-06-25 23:48:34', '1');
INSERT INTO `t_menu` VALUES ('11', '文章管理', '前台文章', '2', '/admin/article/toArticles', null, '2018-07-01 11:16:22', '1');
INSERT INTO `t_menu` VALUES ('12', '轮播管理', 'Banner管理', '2', '/admin/banner/toBanners', null, '2018-07-09 23:49:52', '1');

-- ----------------------------
-- Table structure for `t_online_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_online_message`;
CREATE TABLE `t_online_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickName` varchar(20) NOT NULL COMMENT '昵称',
  `patientName` varchar(20) DEFAULT NULL COMMENT '患者姓名',
  `phoneNo` varchar(15) NOT NULL COMMENT '手机号',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `age` varchar(5) DEFAULT NULL COMMENT '年龄',
  `city` varchar(10) NOT NULL COMMENT '所在城市',
  `clinicId` int(11) NOT NULL COMMENT '选择诊所',
  `messageContent` varchar(1000) NOT NULL COMMENT '留言内容',
  `messageType` varchar(10) NOT NULL COMMENT '留言类型',
  `createTime` datetime NOT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_online_message
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(80) NOT NULL COMMENT '角色名称',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `operationTime` datetime NOT NULL COMMENT '操作时间',
  `operatorId` int(11) NOT NULL COMMENT '操作员ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'ADMIN', '超级管理员', '2018-07-10 00:15:52', '1');
INSERT INTO `t_role` VALUES ('3', '文章管理员', '文章管理', '2018-06-25 23:40:15', '1');

-- ----------------------------
-- Table structure for `t_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NOT NULL,
  `menuid` int(11) NOT NULL,
  `operationTime` datetime NOT NULL,
  `operatorId` int(11) NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('1', '1', '1', '2018-06-15 17:20:55', '1');
INSERT INTO `t_role_menu` VALUES ('2', '1', '2', '2018-06-15 17:21:07', '1');
INSERT INTO `t_role_menu` VALUES ('3', '1', '3', '2018-06-15 17:21:14', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `realname` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `phoneNo` varchar(15) DEFAULT NULL COMMENT '手机号',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `qq` varchar(15) DEFAULT NULL COMMENT 'qq',
  `createTime` datetime NOT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否是超级管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '顽石11', 'admin', '111111', '13351614719', '1', '277780875', '2018-06-24 18:57:49', '192.168.2.115', '1');
INSERT INTO `t_user` VALUES ('4', 'DR.邓3', 'DR.邓3', '111111', '33355555555', '0', '111111', '2018-06-17 19:29:52', '127.0.0.1', '0');
INSERT INTO `t_user` VALUES ('5', 'DR.邓4', '邓4', '111111', '13351614719', '0', '277780875', '2018-06-12 19:08:33', '127.0.0.1', '1');
INSERT INTO `t_user` VALUES ('6', 'DR.邓5', 'DR.邓5', '111111', '33355555555', '0', '111111', '2018-06-17 19:29:52', '127.0.0.1', '0');
INSERT INTO `t_user` VALUES ('7', 'DR.邓6', '邓6', '111111', '13351614719', '0', '277780875', '2018-06-12 19:08:33', '127.0.0.1', '1');
INSERT INTO `t_user` VALUES ('8', 'DR.邓7', 'DR.邓7', '111111', '33355555555', '0', '111111', '2018-06-17 19:29:52', '127.0.0.1', '0');
INSERT INTO `t_user` VALUES ('9', 'DR.邓8', '邓8', '111111', '13351614719', '0', '277780875', '2018-06-12 19:08:33', '127.0.0.1', '1');
INSERT INTO `t_user` VALUES ('10', 'DR.邓9', 'DR.邓9', '111111', '33355555555', '0', '111111', '2018-06-17 19:29:52', '127.0.0.1', '0');
INSERT INTO `t_user` VALUES ('11', 'DR.邓10', '邓10', '111111', '13351614719', '0', '277780875', '2018-06-12 19:08:33', '127.0.0.1', '1');
INSERT INTO `t_user` VALUES ('28', '张三', '张三', '111111', '13311111111', '1', '1111111', '2018-06-25 00:09:51', '192.168.1.5', '0');
INSERT INTO `t_user` VALUES ('29', '李四', '李四', '111111', '15500000001', '0', '1234567', '2018-06-25 00:19:15', '192.168.1.5', '0');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `operationTime` datetime DEFAULT NULL,
  `operatorId` int(11) NOT NULL COMMENT '操作员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '2018-06-15 17:15:22', '1');
INSERT INTO `t_user_role` VALUES ('2', '1', '3', '2018-06-29 14:28:06', '1');
INSERT INTO `t_user_role` VALUES ('10', '6', '3', '2018-07-02 20:09:36', '1');
INSERT INTO `t_user_role` VALUES ('11', '4', '1', '2018-07-02 20:09:54', '1');
INSERT INTO `t_user_role` VALUES ('12', '4', '3', '2018-07-02 20:09:54', '1');
