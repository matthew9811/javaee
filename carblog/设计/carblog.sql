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

 Date: 11/11/2019 15:57:23
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
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user`(`user_id`) USING BTREE,
  INDEX `reviewer`(`reviewer`) USING BTREE,
  CONSTRAINT `reviewer` FOREIGN KEY (`reviewer`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  `concent_url` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `reviewer` int(11) NOT NULL COMMENT '审核人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `draw_user_id`(`user_id`) USING BTREE,
  INDEX `draw_reviewer`(`reviewer`) USING BTREE,
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_user
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user`  (
  `id` int(11) NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_user
-- ----------------------------
INSERT INTO `test_user` VALUES (1, 17, 'lcl');
INSERT INTO `test_user` VALUES (2, 17, 'lcl');
INSERT INTO `test_user` VALUES (3, 17, 'lcl');
INSERT INTO `test_user` VALUES (4, 17, 'lcl');

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
  `concent` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '个性签名',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '头像url',
  `status` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
