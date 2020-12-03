/*
 Navicat Premium Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : localhost:3306
 Source Schema         : xb

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : 65001

 Date: 21/11/2020 13:36:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章内容',
  `browse_count` int(11) NULL DEFAULT NULL COMMENT '浏览次数',
  `publish_date` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `publish_real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人名称',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '发布人id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '如何做一名合格的Java工程师？', '如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师如何做一名合格的Java工程师', 1062, '2020-01-18 16:30:21', '东方标准', 1);
INSERT INTO `article` VALUES (2, '学会自立', '学会自立', 269, '2019-01-11 21:30:29', '超级管理员', 1);
INSERT INTO `article` VALUES (3, '在逆境中生长', '在逆境中生长', 748, '2018-01-11 16:14:11', '东方标准', 6);
INSERT INTO `article` VALUES (4, '阳光总在风雨后', '阳光总在风雨后', 147, '2019-07-11 16:30:21', '小标', 4);
INSERT INTO `article` VALUES (5, '我真的很不错', '我真的很不错', 260, '2019-07-11 16:30:21', '小东', 2);
INSERT INTO `article` VALUES (6, '你若安好便是晴天', '你若安好便是晴天', 159, '2019-06-08 16:12:21', '小准', 5);
INSERT INTO `article` VALUES (8, '入门到精通', '删库跑路(rm /rf /*)', 2589545, '2019-07-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (9, 'Java入门到精通', 'Java入门到精通', 114, '2020-01-18 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (10, 'Spring入门到精通', 'Java入门到精通', 544, '2020-01-18 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (11, 'SpringMVC入门到精通', 'Java入门到精通', 26, '2019-02-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (12, 'SpringBoot入门到精通', 'Java入门到精通', 51, '2020-01-18 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (13, 'MyBatis入门到精通', 'Java入门到精通', 232, '2019-07-24 10:52:31', '小准', 5);
INSERT INTO `article` VALUES (14, '23423424', '23423', 21, '2019-12-03 10:47:54', '超级管理员', 1);
INSERT INTO `article` VALUES (15, '东方标准', '东方标准真好', 23, '2019-07-25 10:55:06', '超级管理员', 1);
INSERT INTO `article` VALUES (16, '今天天气好晴朗', '今天天气好晴朗，处处好风光，好风光', 0, '2019-07-25 12:48:34', '超级管理员', 1);
INSERT INTO `article` VALUES (17, '不要抱怨', '不要抱怨啊', 1, '2020-01-18 18:26:34', '超级管理员', 1);
INSERT INTO `article` VALUES (18, '如何生存', '如何生存', 0, '2020-01-18 18:27:11', '超级管理员', 1);
INSERT INTO `article` VALUES (19, '学会自律', '学会自律', 0, '2019-12-05 18:28:49', '超级管理员', 1);
INSERT INTO `article` VALUES (20, '如何稳定情绪', '如何稳定情绪', 1, '2019-12-05 18:29:09', '超级管理员', 1);
INSERT INTO `article` VALUES (21, '关于升级问题标题', 'aaa', 0, '2019-12-06 20:17:51', '超级管理员', 1);
INSERT INTO `article` VALUES (25, '奶茶', '去星巴克喝奶茶', NULL, '2020-11-19 19:17:48', NULL, 1);
INSERT INTO `article` VALUES (26, '奶茶', '去酒店和奶茶', NULL, '2020-11-19 19:19:41', NULL, 1);
INSERT INTO `article` VALUES (27, '奶茶', '去厕所喝奶茶', NULL, '2020-11-19 19:23:16', NULL, 1);
INSERT INTO `article` VALUES (28, '奶茶', 'tall杯拿铁去脂奶茶', NULL, '2020-11-19 19:24:27', NULL, 1);
INSERT INTO `article` VALUES (29, '奶茶', '去喝奶茶', NULL, '2020-11-19 19:25:49', NULL, 1);
INSERT INTO `article` VALUES (30, '奶茶', '我想喝奶茶', NULL, '2020-11-19 19:30:10', '东方标准总裁', 1);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '研发部');
INSERT INTO `dept` VALUES (2, '推广部');
INSERT INTO `dept` VALUES (3, '行政部');
INSERT INTO `dept` VALUES (4, '财务部');
INSERT INTO `dept` VALUES (5, '总裁办公室');
INSERT INTO `dept` VALUES (7, '秘书部');
INSERT INTO `dept` VALUES (8, '市场部');
INSERT INTO `dept` VALUES (9, '宣传部');
INSERT INTO `dept` VALUES (10, '销售部');

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite`  (
  `u_id` int(11) NOT NULL COMMENT '收藏用户id',
  `a_id` int(11) NOT NULL COMMENT '文章id',
  PRIMARY KEY (`u_id`, `a_id`) USING BTREE,
  INDEX `u_id_favorite_rk`(`u_id`) USING BTREE,
  INDEX `a_id_favorite_rk`(`a_id`) USING BTREE,
  CONSTRAINT `c` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `d` FOREIGN KEY (`a_id`) REFERENCES `article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES (1, 2);
INSERT INTO `favorite` VALUES (1, 5);
INSERT INTO `favorite` VALUES (2, 1);
INSERT INTO `favorite` VALUES (3, 1);
INSERT INTO `favorite` VALUES (5, 1);
INSERT INTO `favorite` VALUES (7, 1);

-- ----------------------------
-- Table structure for meeting
-- ----------------------------
DROP TABLE IF EXISTS `meeting`;
CREATE TABLE `meeting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议内容',
  `publish_date` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `status` int(1) NOT NULL COMMENT '会议状态 0:未开始 1:进行中 2:已结束',
  `make_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '抄送人id，以逗号分隔',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dept_id_conference_rk`(`dept_id`) USING BTREE,
  CONSTRAINT `meeting_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meeting
-- ----------------------------
INSERT INTO `meeting` VALUES (1, '研发部', 1, '关于小标交友部门功能升级', '小标交友有如下问题：1、会议模块需要升级，2、文章模块需要升级，3、用户模块需要升级', '2020-01-18 00:00:00', '2019-12-16 21:07:00', '2019-12-27 12:43:00', 2, '2,3');
INSERT INTO `meeting` VALUES (2, '研发部', 1, '客户需求变更', '客户需求变更', '2019-12-05 00:00:00', '2020-01-17 19:43:00', '2020-01-25 19:43:50', 2, '1,2,3,4');
INSERT INTO `meeting` VALUES (3, '研发部', 1, '测试会议', '测试会议', '2020-08-24 15:31:49', '2020-08-24 15:32:15', '2020-08-28 13:34:10', 2, '2,3,4,5,1');
INSERT INTO `meeting` VALUES (4, NULL, 1, '今晚吃鸡', '打游戏', '2020-11-20 19:56:48', '2020-11-19 10:50:53', '2020-11-22 19:50:53', 1, '2,3,4');
INSERT INTO `meeting` VALUES (5, NULL, 1, 'lol', '开始你的表演', '2020-11-20 19:58:42', '2020-11-23 05:25:30', '2020-11-25 06:30:31', 0, '4,5,6,1');

-- ----------------------------
-- Table structure for meeting_join
-- ----------------------------
DROP TABLE IF EXISTS `meeting_join`;
CREATE TABLE `meeting_join`  (
  `u_id` int(11) NULL DEFAULT NULL COMMENT '需参加人id',
  `m_id` int(11) NULL DEFAULT NULL COMMENT '会议id',
  INDEX `u_id_con_join_rk`(`u_id`) USING BTREE,
  INDEX `c_id_con_join_rk`(`m_id`) USING BTREE,
  CONSTRAINT `meeting_join_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `meeting_join_ibfk_2` FOREIGN KEY (`m_id`) REFERENCES `meeting` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meeting_join
-- ----------------------------
INSERT INTO `meeting_join` VALUES (2, 2);
INSERT INTO `meeting_join` VALUES (1, 2);
INSERT INTO `meeting_join` VALUES (1, 5);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `qq_openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ登录标识符',
  `wx_openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信登录标识符',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 1:男 0:女',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `register_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录时间',
  `pic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `look` int(11) NULL DEFAULT NULL COMMENT '查看数',
  `is_secret` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否私密 0：私密 1：公开',
  `dept_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dept_id`(`dept_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', 'zijun1024@aliyun.com', NULL, NULL, '东方标准总裁', 45, '110453', '1', '我是总裁哦', '2020-01-18 10:51:50', '2020-08-25 20:31:22', 'https://www.baidu.com/favicon.ico', 50, '0', '宣传部', 9);
INSERT INTO `user` VALUES (2, 'xiaodong', 'admin', 'xiaobiao@dfbz.com', NULL, NULL, '小东', 18, '110', '1', '我很帅啊', '2019-12-02 12:35:10', '2019-11-20 10:51:53', 'https://www.baidu.com/favicon.ico', 32, '1', '研发部', 1);
INSERT INTO `user` VALUES (3, 'xiaofang', 'admin', 'xiaofang@dfbz.com', NULL, NULL, '小方', 18, '110', '1', '我很帅啊', '2020-01-17 12:35:10', '2019-11-20 10:51:53', 'https://www.baidu.com/favicon.ico', 34, '1', '研发部', 1);
INSERT INTO `user` VALUES (4, 'xiaobiao', 'admin', 'xiaobiao@dfbz.com', NULL, NULL, '小标', 18, '110', '1', '我很帅啊', '2019-12-02 12:35:10', '2019-11-20 10:51:53', 'https://www.baidu.com/favicon.ico', 27, '1', '研发部', 1);
INSERT INTO `user` VALUES (5, 'xiaozhun', 'admin', 'xiaozhun@dfbz.com', NULL, NULL, '小准', 18, '110', '1', '我很帅啊', '2019-12-02 12:35:10', '2019-11-20 10:51:53', 'https://www.baidu.com/favicon.ico', 31, '1', '研发部', 1);
INSERT INTO `user` VALUES (6, 'dfbz', 'admin', 'dfbz@dfbz.com', NULL, NULL, '东方标准', 18, '110', '1', '我很帅啊', '2019-11-28 11:30:24', '2019-11-20 10:51:53', 'https://www.baidu.com/favicon.ico', 22, '1', '研发部', 1);
INSERT INTO `user` VALUES (7, 'xiaoming', 'admin', 'xm@dfbz.com', NULL, NULL, '小明', 18, '110', '1', '我很帅啊', '2019-12-04 07:30:28', '2019-11-20 10:51:53', 'https://www.baidu.com/favicon.ico', 21, '1', '研发部', 1);
INSERT INTO `user` VALUES (8, 'root', 'admin', 'root@dfbz.com', NULL, NULL, '管理员', 28, '110', '0', '我是副总裁', '2020-01-18 12:33:41', '2019-12-06 00:00:00', 'https://www.baidu.com/favicon.ico', 4, '1', '行政部', 3);
INSERT INTO `user` VALUES (9, 'root_1', 'admin', 'root_1@dfbz.com', NULL, NULL, '管理员1号', 18, '119', '0', '我是副总裁', '2020-01-17 12:37:29', '2019-12-06 00:00:00', 'https://www.baidu.com/favicon.ico', 1, '1', '研发部', 1);
INSERT INTO `user` VALUES (13, 'yjf', '123456', '825362171@qq.com', NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for userfocus
-- ----------------------------
DROP TABLE IF EXISTS `userfocus`;
CREATE TABLE `userfocus`  (
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `user_focus_id` int(10) NOT NULL COMMENT '用户关注的朋友id',
  PRIMARY KEY (`user_id`, `user_focus_id`) USING BTREE,
  INDEX `fk_userFocus_user_1`(`user_id`) USING BTREE,
  INDEX `fk_userFocus_user_2`(`user_focus_id`) USING BTREE,
  CONSTRAINT `a` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `b` FOREIGN KEY (`user_focus_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of userfocus
-- ----------------------------
INSERT INTO `userfocus` VALUES (1, 2);
INSERT INTO `userfocus` VALUES (1, 3);
INSERT INTO `userfocus` VALUES (1, 4);
INSERT INTO `userfocus` VALUES (1, 5);
INSERT INTO `userfocus` VALUES (1, 9);

-- ----------------------------
-- Event structure for auto_update_status
-- ----------------------------
DROP EVENT IF EXISTS `auto_update_status`;
delimiter ;;
CREATE EVENT `auto_update_status`
ON SCHEDULE
EVERY '1' SECOND STARTS '2020-01-17 19:42:29'
DO begin
	-- 修改使用子查询,否则报错(You can't specify target table 'meeting' for update in FROM clause) 不可以在update语句中使用本表查询
	update meeting set status = 1 where id in (
	
		select a.id from (
			select id from meeting where DATE_FORMAT(start_time,'%Y-%m-%d %H:%i:%s')=DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s')
		
		) a
	
	);
	update meeting set status = 2 where id in (
	
		select a.id from (
			select id from meeting where DATE_FORMAT(end_time,'%Y-%m-%d %H:%i:%s')=DATE_FORMAT(now(),'%Y-%m-%d %H:%i:%s')
		) a
	
	);
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
