/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_new_dentist

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-15 17:23:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章标题',
  `title` varchar(100) NOT NULL,
  `keyWords` varchar(100) DEFAULT NULL COMMENT '关键字',
  `columnId` int(11) NOT NULL COMMENT '栏目ID',
  `createTime` datetime NOT NULL,
  `introduction` varchar(300) NOT NULL COMMENT '简介',
  `top` int(1) NOT NULL COMMENT '是否置顶',
  `status` varchar(255) NOT NULL COMMENT '文章状态',
  `operatorId` int(11) NOT NULL COMMENT '操作员ID',
  `thumb` varchar(100) NOT NULL COMMENT '缩略图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------

-- ----------------------------
-- Table structure for t_article_ext
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
-- Table structure for t_banner
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
-- Table structure for t_column
-- ----------------------------
DROP TABLE IF EXISTS `t_column`;
CREATE TABLE `t_column` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '栏目名称',
  `description` varchar(30) DEFAULT NULL COMMENT '栏目描述',
  `status` varchar(15) NOT NULL COMMENT '栏目状态',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `operatorId` int(11) NOT NULL COMMENT '操作员ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_column
-- ----------------------------

-- ----------------------------
-- Table structure for t_config
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
-- Table structure for t_dentist
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
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(20) NOT NULL COMMENT '菜单名称',
  `menuDescribe` varchar(50) NOT NULL COMMENT '描述',
  `parentId` int(20) DEFAULT NULL COMMENT '父菜单ID',
  `url` varchar(30) DEFAULT NULL COMMENT '方法路径',
  `version` varchar(20) DEFAULT NULL COMMENT '扩展',
  `createTime` datetime DEFAULT NULL,
  `operatorId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '用户权限管理', '用户与权限', null, null, null, '2018-06-15 17:15:59', '1');
INSERT INTO `t_menu` VALUES ('2', '栏目管理', '栏目', null, null, null, '2018-06-15 17:17:43', '1');
INSERT INTO `t_menu` VALUES ('3', '菜单管理', '菜单', null, null, null, '2018-06-15 17:20:15', '1');

-- ----------------------------
-- Table structure for t_online_message
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
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) NOT NULL COMMENT '角色名称',
  `description` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `operationTime` datetime NOT NULL COMMENT '操作时间',
  `operatorId` int(11) NOT NULL COMMENT '操作员ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '超级管理员', '超级管理员', '2018-06-15 17:14:27', '1');

-- ----------------------------
-- Table structure for t_role_menu
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
-- Table structure for t_user
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
  `version` varchar(20) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '徐永杰', 'admin', '111111', '13351614719', '1', '277780875', '2018-06-12 19:08:33', null, null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `operationTime` datetime DEFAULT NULL,
  `operatorId` int(11) NOT NULL COMMENT '操作员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '2018-06-15 17:15:22', '1');
