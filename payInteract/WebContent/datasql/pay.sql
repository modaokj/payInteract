/* 
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : pay

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-07-25 10:24:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` varchar(15) NOT NULL COMMENT '活动标识',
  `user_id` varchar(11) NOT NULL COMMENT '用户标识',
  `acname` varchar(200) DEFAULT NULL COMMENT '活动名称',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '活动结束时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT ' 活动创建时间',
  `state` varchar(2) NOT NULL DEFAULT 'C' COMMENT '活动状态（W:预创建,C:进行中,Y:已结束,D:已删除）',
  `url` varchar(2000) DEFAULT NULL COMMENT '活动链接地址',
  `Qrcode_img_url` varchar(200) DEFAULT NULL COMMENT '二维码图片地址',
  `remark` varchar(2000) DEFAULT NULL COMMENT '活动备注',
  `publish` varchar(2) DEFAULT 'F' COMMENT '是否发布，T表示是F表示否',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for `activity_history`
-- ----------------------------
DROP TABLE IF EXISTS `activity_history`;
CREATE TABLE `activity_history` (
  `id` varchar(15) NOT NULL,
  `operation` varchar(100) NOT NULL COMMENT '操作类型',
  `operation_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `activity_id` varchar(15) NOT NULL COMMENT '活动id',
  `user_id` varchar(11) NOT NULL,
  `acname` varchar(200) DEFAULT NULL COMMENT '活动名称',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '活动开始时间',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '活动结束时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT ' 活动创建时间',
  `state` varchar(2) DEFAULT 'W' COMMENT '活动状态（W:预创建，C:进行中,Y:已结束,D:已删除,Z:已暂停）',
  `url` varchar(2000) DEFAULT NULL,
  `Qrcode_img_url` varchar(200) DEFAULT NULL COMMENT '活动短链接地址',
  `remark` varchar(2000) DEFAULT NULL COMMENT '活动备注',
  `to_shop_count` int(11) DEFAULT NULL COMMENT '进店送次数',
  `fx_claim` int(11) DEFAULT NULL COMMENT '分享要求,需要分享多少次',
  `fx_count` int(11) DEFAULT NULL COMMENT '分享达到要求后送的抽奖次数',
  `consume_claim` int(11) DEFAULT NULL COMMENT '消费多少送，0表示无门槛消费',
  `consume_count` int(11) DEFAULT NULL COMMENT '消费达到要求，送的抽奖次数',
  `winning_lock` int(11) DEFAULT NULL COMMENT '中奖限制，0表示不限制，参与者最多只能中奖的次数',
  `game_type` varchar(2) DEFAULT NULL COMMENT '游戏类型 G:刮刮卡,Z:砸蛋',
  `publish` varchar(2) DEFAULT NULL COMMENT '是否发布，T表示是F表示否',
  `publish_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity_history
-- ----------------------------

-- ----------------------------
-- Table structure for `activity_options`
-- ----------------------------
DROP TABLE IF EXISTS `activity_options`;
CREATE TABLE `activity_options` (
  `id` varchar(15) CHARACTER SET utf8 NOT NULL COMMENT '这个id就是活动id',
  `user_id` varchar(11) CHARACTER SET utf8 NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `to_shop_count` int(11) DEFAULT '0' COMMENT '进店送次数,如果小于等于0则为不开启',
  `fx_claim` int(11) DEFAULT '0' COMMENT '分享要求,需要分享多少次',
  `fx_count` int(11) DEFAULT '0' COMMENT '分享达到要求后送的抽奖次数',
  `consume_claim` int(11) DEFAULT '0' COMMENT '消费多少送，0表示无门槛消费',
  `consume_count` int(11) DEFAULT '0' COMMENT '消费达到要求，送的抽奖次数',
  `winning_lock` int(11) DEFAULT '0' COMMENT '中奖限制，0表示不限制，参与者最多只能中奖的次数',
  `game_type` varchar(2) DEFAULT 'G' COMMENT '游戏类型 G:刮刮卡,Z:砸蛋',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of activity_options
-- ----------------------------

-- ----------------------------
-- Table structure for `api_operation`
-- ----------------------------
DROP TABLE IF EXISTS `api_operation`;
CREATE TABLE `api_operation` (
  `id` varchar(15) CHARACTER SET utf8 NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `api` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT 'api名称',
  `content` text CHARACTER SET utf8 COMMENT 'api传入内容',
  `result` text CHARACTER SET utf8 COMMENT 'api返回',
  `ok_no` varchar(2) CHARACTER SET utf8 NOT NULL COMMENT '成功或失败F失败T成功',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of api_operation
-- ----------------------------

-- ----------------------------
-- Table structure for `lottery_record`
-- ----------------------------
DROP TABLE IF EXISTS `lottery_record`;
CREATE TABLE `lottery_record` (
  `id` varchar(15) NOT NULL,
  `wap_id` varchar(15) NOT NULL COMMENT '摇奖人id',
  `wap_nick` varchar(50) DEFAULT NULL COMMENT '摇奖人nick',
  `lottery_source` varchar(10) NOT NULL COMMENT '抽奖来源,shop,fx,consume',
  `prize_id` varchar(15) DEFAULT NULL COMMENT '奖品id',
  `prize_name` varchar(50) DEFAULT NULL COMMENT '奖品名称',
  `prize_type` varchar(2) DEFAULT NULL COMMENT '奖品类型',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `tel` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间(摇奖时间)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lottery_record
-- ----------------------------

-- ----------------------------
-- Table structure for `prize`
-- ----------------------------
DROP TABLE IF EXISTS `prize`;
CREATE TABLE `prize` (
  `id` varchar(15) NOT NULL,
  `user_id` varchar(11) NOT NULL COMMENT '用户id',
  `activity_id` varchar(15) NOT NULL COMMENT '活动id',
  `pname` varchar(50) NOT NULL COMMENT '奖品名称',
  `type` int(11) NOT NULL COMMENT '奖品类型',
  `status` varchar(2) DEFAULT 'T' COMMENT '奖品状态T:使用中F:已删除',
  `proto_count` int(11) NOT NULL DEFAULT '0' COMMENT '原始奖品数量',
  `price` double DEFAULT '0' COMMENT '奖品金额',
  `url` varchar(500) DEFAULT NULL COMMENT '奖品链接',
  `prob` double NOT NULL COMMENT '中奖概率',
  `confine` int(11) DEFAULT '-1' COMMENT '限制每个人最多允许中几次这个奖品小于0表示未开启',
  `avg_grant` varchar(2) DEFAULT 'F' COMMENT '是否开启均匀发放F:否T:是',
  `avg_count` int(11) DEFAULT '0' COMMENT '均匀发放，一天发放多少件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize
-- ----------------------------

-- ----------------------------
-- Table structure for `prize_dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `prize_dynamic`;
CREATE TABLE `prize_dynamic` (
  `id` varchar(15) NOT NULL COMMENT '就是奖品表的id',
  `current_count` int(11) NOT NULL DEFAULT '0' COMMENT '当前奖品数量',
  `proto_count` int(11) NOT NULL DEFAULT '0' COMMENT '原始奖品数量',
  `send_count` int(11) NOT NULL DEFAULT '0' COMMENT '已发放奖品数量',
  `check` varchar(2) NOT NULL DEFAULT 'T' COMMENT '检查数据是否有异常，如果发现异常此字段为F，检查通过T，不通过F',
  `lock_time` timestamp NULL DEFAULT NULL COMMENT '发生异常锁数据的时间，只有check为F时此字段有意义',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize_dynamic
-- ----------------------------

-- ----------------------------
-- Table structure for `prize_wait_send`
-- ----------------------------
DROP TABLE IF EXISTS `prize_wait_send`;
CREATE TABLE `prize_wait_send` (
  `id` varchar(15) NOT NULL,
  `prize_id` varchar(15) NOT NULL COMMENT '奖品id',
  `activity_id` varchar(15) DEFAULT NULL COMMENT '活动id',
  `wap_id` varchar(15) NOT NULL COMMENT '发放对象',
  `wap_nick` varchar(50) DEFAULT NULL COMMENT '中奖人nick',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `result` text COMMENT '发放结果,成功为ok,否则都为失败并且记录失败原因到此字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prize_wait_send
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL COMMENT '用户id',
  `nick` varchar(50) DEFAULT NULL COMMENT '旺旺名称',
  `session_key` varchar(100) DEFAULT NULL COMMENT '用户sessionkey',
  `refresh_token` varchar(100) DEFAULT NULL COMMENT '最新的token',
  `shop_type` varchar(1) DEFAULT NULL COMMENT '店铺类型',
  `mobile` varchar(15) DEFAULT NULL COMMENT '手机号码',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `shop_num` varchar(20) DEFAULT NULL COMMENT '店铺编号',
  `shop_url` varchar(100) DEFAULT NULL COMMENT '店铺链接',
  `shop_logo` varchar(100) DEFAULT NULL COMMENT '店铺logo',
  `level` int(11) DEFAULT NULL COMMENT 'vip等级',
  `regist_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `expires_in` varchar(255) DEFAULT NULL,
  `last_login` timestamp NULL DEFAULT NULL COMMENT '最后一次登录时间',
  `vip_time` timestamp NULL DEFAULT NULL COMMENT '订购截止时间',
  `expire_date` timestamp NULL DEFAULT NULL COMMENT '订购时长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('11111', '测试', 'abc1234567', null, null, null, null, null, null, null, null, '2016-07-23 13:26:10', null, null, null, null);

-- ----------------------------
-- Table structure for `wap_info`
-- ----------------------------
DROP TABLE IF EXISTS `wap_info`;
CREATE TABLE `wap_info` (
  `id` varchar(15) NOT NULL,
  `activity_id` varchar(15) NOT NULL COMMENT '活动id',
  `nick` varchar(50) DEFAULT NULL COMMENT '昵称',
  `shop_count` int(11) DEFAULT '0' COMMENT '通过进店获得的抽奖机会',
  `shop_remain` int(11) DEFAULT NULL COMMENT '进店抽奖还剩多少次',
  `fx_count` int(11) DEFAULT '0' COMMENT '通过分享获得的抽奖机会',
  `fx_remain` int(11) DEFAULT NULL COMMENT '分享抽奖还剩多少次',
  `consume_count` int(11) DEFAULT '0' COMMENT '通过消费获得的抽奖次数',
  `consume_remain` int(11) DEFAULT NULL COMMENT '消费抽奖还剩多少次',
  `free_sum_count` int(11) DEFAULT '0' COMMENT '可用总次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wap_info
-- ----------------------------
