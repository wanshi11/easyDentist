/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_new_dentist

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-09 23:11:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_appointment
-- ----------------------------
DROP TABLE IF EXISTS `t_appointment`;
CREATE TABLE `t_appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patientName` varchar(20) NOT NULL COMMENT '患者姓名',
  `phone` varchar(15) NOT NULL COMMENT '手机号',
  `clinic` varchar(20) NOT NULL COMMENT '选择诊所',
  `messageContent` varchar(1000) NOT NULL COMMENT '留言内容',
  `messageType` varchar(10) NOT NULL COMMENT '咨询类型',
  `status` varchar(20) NOT NULL COMMENT '预约状态',
  `doctorName` varchar(1000) DEFAULT NULL COMMENT '预约医生姓名',
  `appointDate` date DEFAULT NULL COMMENT '约定时间',
  `remark` varchar(1000) DEFAULT NULL COMMENT '回访备注',
  `operatorId` int(11) DEFAULT NULL COMMENT '操作员ID',
  `createTime` datetime NOT NULL COMMENT '留言时间',
  `updateTime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
