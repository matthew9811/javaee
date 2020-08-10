/*
 Navicat Premium Data Transfer

 Source Server         : carblog
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 47.106.188.177:3306
 Source Schema         : carblog

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 22/12/2019 18:48:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT 'user_id',
  `blog_url` varchar(74) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客路径',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审核状态',
  `reviewer` int(11) NOT NULL COMMENT '审核人',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '摘要',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `create_time` datetime(0) NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user`(`user_id`) USING BTREE,
  INDEX `reviewer`(`reviewer`) USING BTREE,
  CONSTRAINT `reviewer` FOREIGN KEY (`reviewer`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('4028ba816f2c54ae016f2c56e9de0000', 39, '/uploads/20191222/e9784f39a44f4da69a36e47c51c3d8e6.html', '0', 39, '<div class=\"image-package\"><img style=\"max-width:100%;\" class=\"\" data-src=', '正值冬季大雪纷飞时，想不想拍出雪天电影感照片？ ', '2019-12-22 06:41:31');
INSERT INTO `blog` VALUES ('4028ba816f2c5d35016f2c67eae30000', 39, '/uploads/20191222/87947b04c74c42b2822c2467751eb91f.html', '0', 39, '<p style=\"text-align: left;\"><span style=\"font-family: 宋体, SimSun; font-si', '最想旅行的地方是爱人的心：4步教你拍出浪漫情侣写真 ', '2019-12-22 07:00:05');
INSERT INTO `blog` VALUES ('4028e4816f2262e0016f227ff30f0000', 1, '/uploads/20191220/5505e2f62fa04d94b659b371b53af64c.html', '0', 1, '<span class=\"bjh-p\">有人说，怎么才可以拍出摄影大师才能拍出的照片？我想说掌握了这6个摄影技巧，让你成为摄影大师。</spa', '6个摄影技巧，让你成为摄影大师', '2019-12-20 08:50:08');
INSERT INTO `blog` VALUES ('4028e4816f2793f7016f279554810000', 1, '/uploads/20191221/e034b2c1754d4594bea3521f11be5faf.html', '0', 1, '<div class=\"img-container\"><img class=\"large\" data-loadfunc=\"0\" src=\"https', '摄影构图的三大要素，学会强化视觉主题，易记易用', '2019-12-21 08:31:36');

-- ----------------------------
-- Table structure for blog_like
-- ----------------------------
DROP TABLE IF EXISTS `blog_like`;
CREATE TABLE `blog_like`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT 'user_id',
  `blog_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'blog_id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `blog_like_user_id`(`user_id`) USING BTREE,
  INDEX `blog_like_blog_id`(`blog_id`) USING BTREE,
  CONSTRAINT `blog_like_blog_id` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `blog_like_user_id` FOREIGN KEY (`user_id`) REFERENCES `blog` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_tips
-- ----------------------------
DROP TABLE IF EXISTS `blog_tips`;
CREATE TABLE `blog_tips`  (
  `id` int(11) NOT NULL COMMENT 'id',
  `blog_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'blog id',
  `order` int(1) NOT NULL COMMENT '标签顺序',
  `tip_id` int(11) NOT NULL COMMENT '便签id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tips_blog_id`(`blog_id`) USING BTREE,
  INDEX `tips_tip_id`(`tip_id`) USING BTREE,
  CONSTRAINT `tips_blog_id` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tips_tip_id` FOREIGN KEY (`tip_id`) REFERENCES `tips` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `concent` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `create_time` datetime(0) NOT NULL COMMENT '评论时间',
  `user_id` int(11) NOT NULL COMMENT '评论人_id',
  `blog_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博客id',
  `blog_user_id` int(11) NOT NULL COMMENT '被评论人id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `comment_blog_id`(`blog_id`) USING BTREE,
  INDEX `comment_user_id`(`user_id`) USING BTREE,
  INDEX `comment_blog_user_id`(`blog_user_id`) USING BTREE,
  CONSTRAINT `comment_blog_id` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_blog_user_id` FOREIGN KEY (`blog_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `comment_user_id` FOREIGN KEY (`user_id`) REFERENCES `blog` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for draw
-- ----------------------------
DROP TABLE IF EXISTS `draw`;
CREATE TABLE `draw`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT 'user_id',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审核状态',
  `content_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `reviewer` int(11) NOT NULL COMMENT '审核人',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `upload_time` datetime(0) NOT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `draw_user_id`(`user_id`) USING BTREE,
  INDEX `draw_reviewer`(`reviewer`) USING BTREE,
  INDEX `draw_title_id`(`title`) USING BTREE,
  CONSTRAINT `draw_reviewer` FOREIGN KEY (`reviewer`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `draw_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for draw_like
-- ----------------------------
DROP TABLE IF EXISTS `draw_like`;
CREATE TABLE `draw_like`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `draw_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `draw_like_user_id`(`user_id`) USING BTREE,
  INDEX `draw_like_draw_id`(`draw_id`) USING BTREE,
  CONSTRAINT `draw_like_draw_id` FOREIGN KEY (`draw_id`) REFERENCES `draw` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `draw_like_user_id` FOREIGN KEY (`user_id`) REFERENCES `draw` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT 'user _id ',
  `blog_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'blog_id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `favorites_user_id`(`user_id`) USING BTREE,
  INDEX `favorites_blog_id`(`blog_id`) USING BTREE,
  CONSTRAINT `favorites_blog_id` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `favorites_user_id` FOREIGN KEY (`user_id`) REFERENCES `blog` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT 'user_id',
  `status` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'status',
  `make_up` int(11) NOT NULL COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `make_up`(`make_up`) USING BTREE,
  CONSTRAINT `make_up` FOREIGN KEY (`make_up`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 1, '0', 1);

-- ----------------------------
-- Table structure for tips
-- ----------------------------
DROP TABLE IF EXISTS `tips`;
CREATE TABLE `tips`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'name',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `pwd` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'password',
  `create_time` datetime(0) NOT NULL COMMENT 'create_time',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '个性签名',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像url',
  `status` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '2019-11-17 12:06:39', '我是老板你懂吗!', '132', '0');
INSERT INTO `user` VALUES (2, 'shu', '11qq', '2019-11-27 19:26:57', 'default', 'http://47.106.188.177//...', '0');
INSERT INTO `user` VALUES (36, '暮凉', '111', '2019-12-17 07:43:21', 'default', 'http://47.106.188.177//...', '0');
INSERT INTO `user` VALUES (37, 'muliang', '123', '2019-12-18 02:41:31', 'default', 'http://47.106.188.177//...', '0');
INSERT INTO `user` VALUES (38, 'shu', '123', '2019-12-21 14:45:06', 'default', 'http://47.106.188.177//...', '0');
INSERT INTO `user` VALUES (39, 'liang', 'liang', '2019-12-22 06:04:09', 'default', 'http://47.106.188.177//...', '0');

SET FOREIGN_KEY_CHECKS = 1;
