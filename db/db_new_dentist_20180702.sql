/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_new_dentist

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-07-02 00:13:51
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
  `introduction` varchar(500) NOT NULL COMMENT '简介',
  `top` int(1) NOT NULL COMMENT '是否置顶',
  `status` varchar(255) NOT NULL COMMENT '文章状态',
  `operatorId` int(11) NOT NULL COMMENT '操作员ID',
  `thumbnailUrl` varchar(100) NOT NULL COMMENT '缩略图url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article_ext
-- ----------------------------

-- ----------------------------
-- Table structure for `t_banner`
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bannerName` varchar(20) NOT NULL COMMENT 'banner名称',
  `picUrl` varchar(255) NOT NULL COMMENT '图片路径',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT 'banner状态',
  `operationTime` datetime NOT NULL,
  `operatorId` int(11) NOT NULL,
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
  `createTime` datetime NOT NULL,
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
INSERT INTO `t_menu` VALUES ('2', '文章管理', '文章', null, null, null, '2018-06-15 17:17:43', '1');
INSERT INTO `t_menu` VALUES ('3', '菜单管理', '菜单', null, null, null, '2018-06-15 17:20:15', '1');
INSERT INTO `t_menu` VALUES ('4', '用户管理', '用户', '1', '/admin/user/toBgUser', null, '2018-06-16 16:44:06', '1');
INSERT INTO `t_menu` VALUES ('5', '角色管理', '角色', '1', '/admin/role/toRoles', null, '2018-06-29 11:39:09', '1');
INSERT INTO `t_menu` VALUES ('7', '菜单列表', 'menulist', '3', '/admin/menu/toMenus', null, '2018-06-16 18:12:17', '1');
INSERT INTO `t_menu` VALUES ('8', '赋予角色', '分配角色', '1', '/admin/role/toGiveRoles', null, '2018-06-25 23:44:55', '1');
INSERT INTO `t_menu` VALUES ('9', '分配菜单', '分配菜单', '3', '/admin/menu/toAllotMenus', null, '2018-06-25 23:48:34', '1');
INSERT INTO `t_menu` VALUES ('11', '文章管理', '前台文章', '2', '/admin/article/toArticles', null, '2018-07-01 11:16:22', '1');

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
INSERT INTO `t_role` VALUES ('1', 'ADMIN', '超级管理员', '2018-06-15 17:14:27', '1');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '2018-06-15 17:15:22', '1');
INSERT INTO `t_user_role` VALUES ('2', '1', '3', '2018-06-29 14:28:06', '1');
INSERT INTO `t_user_role` VALUES ('6', '4', '1', '2018-07-01 23:29:51', '1');
INSERT INTO `t_user_role` VALUES ('7', '4', '3', '2018-07-01 23:29:51', '1');
