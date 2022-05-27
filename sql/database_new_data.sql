/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : database_new

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 27/05/2022 13:46:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `commentContent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `commentTime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`commentid`) USING BTREE,
  INDEX `comment_ibfk_1`(`uid`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, '1', 'test', '05-23 09:15:22');
INSERT INTO `comment` VALUES (2, '1', 'test2', '05-23 09:15:23');
INSERT INTO `comment` VALUES (3, '1', '123', '05-23 10:03:11');
INSERT INTO `comment` VALUES (4, '1', '<img src=\"./static/image/tootha_thumb.gif\" title=\"[嘻嘻]\">', '05-23 13:50:14');
INSERT INTO `comment` VALUES (5, '1', 'hi', '05-23 16:59:40');
INSERT INTO `comment` VALUES (6, '1', 'test again', '05-23 19:55:11');
INSERT INTO `comment` VALUES (7, '1', '<img src=\"./static/image/smilea_thumb.gif\" title=\"[呵呵]\">你好啊！', '05-23 20:24:29');
INSERT INTO `comment` VALUES (8, '123', '我是老师', '05-23 22:25:02');
INSERT INTO `comment` VALUES (9, 'admin', '新版本正式上线！', '05-25 12:21:44');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cName` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cInfo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cLast` int(11) NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE INDEX `cName`(`cName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '数据库系统及安全', '本课程介绍了数据库的基本理论和实践', 135);
INSERT INTO `course` VALUES (2, '操作系统及安全', '本课程讲述操作系统原理和设计', 180);
INSERT INTO `course` VALUES (3, '计算机通信与网络', '本课程讲述计算机网络原理', 180);
INSERT INTO `course` VALUES (4, '网络安全的数学基础', '本课程介绍数论群论原理', 135);
INSERT INTO `course` VALUES (5, '数据结构与算法', '本课程介绍了常用数据结构和算法实践', 180);
INSERT INTO `course` VALUES (6, '计算机组成与体系结构', '本课程讲述计算机组成原理和体系结构', 135);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`fid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES (4, '123', 'abc@163.com', 'hahahahahahahahahahahahaahahahhahahahahahahahhahahahahahahhahahahahhahhahahahahahahahahahahahaahahahhahahahahahahahhahahahahahahhahahahahhah');
INSERT INTO `feedback` VALUES (5, '123', '123@123.com', '1');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gHref` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gPrice` int(11) NOT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, 'static/image/pic01.png', 10000);
INSERT INTO `goods` VALUES (2, 'static/image/pic02.png', 20000);
INSERT INTO `goods` VALUES (3, 'static/image/pic03.png', 10000);
INSERT INTO `goods` VALUES (4, 'static/image/pic04.png', 20000);
INSERT INTO `goods` VALUES (5, 'static/image/pic05.jpg', 20000);
INSERT INTO `goods` VALUES (6, 'static/image/pic06.png', 20000);

-- ----------------------------
-- Table structure for parent_child
-- ----------------------------
DROP TABLE IF EXISTS `parent_child`;
CREATE TABLE `parent_child`  (
  `pid` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uid` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pass` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`pid`, `uid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `parent_child_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parent_child_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of parent_child
-- ----------------------------
INSERT INTO `parent_child` VALUES ('12', '111111', '0');
INSERT INTO `parent_child` VALUES ('1234', '1', '1');

-- ----------------------------
-- Table structure for take_course
-- ----------------------------
DROP TABLE IF EXISTS `take_course`;
CREATE TABLE `take_course`  (
  `cid` int(11) NOT NULL,
  `uid` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`cid`, `uid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `take_course_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `course` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `take_course_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of take_course
-- ----------------------------
INSERT INTO `take_course` VALUES (1, '1');
INSERT INTO `take_course` VALUES (2, '1');
INSERT INTO `take_course` VALUES (3, '1');
INSERT INTO `take_course` VALUES (1, '123');
INSERT INTO `take_course` VALUES (2, '123');
INSERT INTO `take_course` VALUES (3, '123');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `upwd` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uName` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uSex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uAge` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uTel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uType` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `uScore` int(11) NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'c4ca4238a0b923820dcc509a6f75849b', '李伊一', '2', '18', '19960221035', '1', 6200);
INSERT INTO `user` VALUES ('111111', '96e79218965eb72c92a549dd5a330112', '王尼玛', '1', '11', '15974562013', '1', 5000);
INSERT INTO `user` VALUES ('12', 'c20ad4d76fe97759aa27a0c99bff6710', '王大宝', '1', '42', '17730126445', '3', 5000);
INSERT INTO `user` VALUES ('123', '202cb962ac59075b964b07152d234b70', '张三', '1', '26', '18320034019', '2', 5300);
INSERT INTO `user` VALUES ('1234', '81dc9bdb52d04dc20036dbd8313ed055', '莉丝', '2', '43', '14799632001', '3', 5000);
INSERT INTO `user` VALUES ('admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', '2', '20', '18864325765', '4', 5000);

-- ----------------------------
-- Table structure for verification
-- ----------------------------
DROP TABLE IF EXISTS `verification`;
CREATE TABLE `verification`  (
  `uid` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `teacherPass` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  CONSTRAINT `verification_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of verification
-- ----------------------------
INSERT INTO `verification` VALUES ('123', '4');

SET FOREIGN_KEY_CHECKS = 1;
