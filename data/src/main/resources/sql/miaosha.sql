/*
 Navicat Premium Data Transfer

 Source Server         : xlx
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : miaosha

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 28/01/2020 19:08:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_password
-- ----------------------------
DROP TABLE IF EXISTS `t_password`;
CREATE TABLE `t_password`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_password
-- ----------------------------
INSERT INTO `t_password` VALUES (1, 'qweqwet', 1);

-- ----------------------------
-- Table structure for t_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `user_gender` tinyint(255) NOT NULL COMMENT '0代表男性1代表女性',
  `user_age` int(11) NOT NULL,
  `user_telphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `regist_mode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '//by phone //by wechat //by qq',
  `thrid_party_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES (1, 'xlx', 0, 25, '13851494437', 'by phone', '13851494437');
INSERT INTO `t_userinfo` VALUES (3, 'qqq', 0, 10, '12312313212', '1', '1');

-- ----------------------------
-- Table structure for tb_school
-- ----------------------------
DROP TABLE IF EXISTS `tb_school`;
CREATE TABLE `tb_school`  (
  `school_id` int(11) NOT NULL COMMENT '学校id',
  `school_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校姓名',
  `school_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校地区',
  PRIMARY KEY (`school_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_school
-- ----------------------------
INSERT INTO `tb_school` VALUES (1, '一中', '南京');
INSERT INTO `tb_school` VALUES (2, '二中', '南京');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `student_id` int(11) NOT NULL COMMENT '学生id',
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `student_age` int(255) NOT NULL COMMENT '学生年龄',
  `teacher_id` int(11) NOT NULL COMMENT '教师id',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (1, 'aa', 22, 1);
INSERT INTO `tb_student` VALUES (2, 'xx', 22, 1);
INSERT INTO `tb_student` VALUES (3, 'bb', 22, 2);

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `teacher_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `teacher_age` int(255) NOT NULL COMMENT '教师年龄',
  `teacher_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师手机',
  `school_id` int(255) NOT NULL COMMENT '学校id',
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES (1, 'xlx', 22, '123123123', 1);
INSERT INTO `tb_teacher` VALUES (2, 'xxx', 22, '123213', 2);

SET FOREIGN_KEY_CHECKS = 1;
