/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : resume

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 14/03/2023 17:14:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nationality` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, 'Azerbaijan', 'Azerbaijani');
INSERT INTO `country` VALUES (2, 'Turkey', 'Turkish');
INSERT INTO `country` VALUES (3, 'Germany', 'German');
INSERT INTO `country` VALUES (4, 'USA', 'American');
INSERT INTO `country` VALUES (5, 'Russia', 'Russian');

-- ----------------------------
-- Table structure for employment_history
-- ----------------------------
DROP TABLE IF EXISTS `employment_history`;
CREATE TABLE `employment_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `header` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `begin_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  `job_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `employment_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employment_history
-- ----------------------------
INSERT INTO `employment_history` VALUES (12, 'Control Engineer at SOCAR', '2018-09-24', '2022-04-11', 'SCADA, PLC, HMI, OPC, InFLuxDB, Grafana', 1);
INSERT INTO `employment_history` VALUES (13, 'Software Engineer at SOCAR', '2022-04-11', NULL, 'Python, Java, MySQL, Backend, Database', 1);
INSERT INTO `employment_history` VALUES (14, 'Senior Employment Expert', NULL, NULL, 'Control over the Ministry bodies', 5);

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES (1, 'Java');
INSERT INTO `skill` VALUES (2, 'Python');
INSERT INTO `skill` VALUES (3, 'C++');
INSERT INTO `skill` VALUES (4, 'PHP');
INSERT INTO `skill` VALUES (6, 'Matlab');
INSERT INTO `skill` VALUES (16, 'C');
INSERT INTO `skill` VALUES (20, 'Scala');
INSERT INTO `skill` VALUES (21, 'Go');
INSERT INTO `skill` VALUES (22, 'Javascript');
INSERT INTO `skill` VALUES (23, 'Rust');
INSERT INTO `skill` VALUES (24, 'Assembly');
INSERT INTO `skill` VALUES (25, 'Ruby');
INSERT INTO `skill` VALUES (27, 'Django');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `surname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `profile_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `country_id` int(11) NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_ibfk_1`(`country_id`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Ərtürk', 'Məmmədli', 'erturk@yahoo.com', '+994507777777', 'Electrical and Electronics Engineering at METU, Senior Software Engineer at SOCAR, Data Structures and Algorithms Expert, AI/ML Enthusiast.', 'Ağdam, Azərbaycan', '1992-06-08', 1, '$2a$04$F7gBbshmQDDIIKzE7HFYheyq8PrgdvP1ndBfvGRnsDHXx8FB5Zjj.');
INSERT INTO `user` VALUES (4, 'Aqşin', 'Fərəcov', 'farajov@hotmail.com', '+905055055055', NULL, NULL, NULL, 0, '$2a$04$CRGt5QKKQfNP2zxu4ih1uuAP2uEkKZqvRexJxbexrq.jptYzd5sIm');
INSERT INTO `user` VALUES (5, 'Ayturan', 'Fətəlisoy', 'fetelisoyayturan@gmail.com', '+994503212321', 'Employment Specialist at MLSPP', '', NULL, 0, '$2a$04$LrrOIa/CXjngsWeWo0hRAeCuxxdv66Y03NJI3eKqBJsxJv/DgAT8i');
INSERT INTO `user` VALUES (6, 'Adil', 'Adilli', 'adil@gmail.com', '+134567453431', NULL, NULL, NULL, 0, '$2a$04$TzsE4GQov8bON2OPWNd5YObfdTUgkYG.epogBz0VvRUCNfAFsiQXO');
INSERT INTO `user` VALUES (16, 'Əli', 'Məmmədli', 'alimammadli@gmail.com', '+901234567865', NULL, NULL, NULL, 0, '$2a$04$qlm6BFyQJlWoQ9RFEfTBxew2d1anbPGzc2t6g9JfHEMz7Tq5XZO1O');
INSERT INTO `user` VALUES (17, 'Ülvi', 'Abdulla', 'ulviabdulla@protonmail.com', '+994552211221', 'null', 'null', NULL, 0, '$2a$04$n9.eEO2jSp4WgFi7g0TPgeCs8tTBvFRVjEA/99Tgzgh.4zsik47nK');

-- ----------------------------
-- Table structure for user_skill
-- ----------------------------
DROP TABLE IF EXISTS `user_skill`;
CREATE TABLE `user_skill`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `power` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_skill_ibfk_1`(`user_id`) USING BTREE,
  INDEX `user_skill_ibfk_2`(`skill_id`) USING BTREE,
  CONSTRAINT `user_skill_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_skill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_skill
-- ----------------------------
INSERT INTO `user_skill` VALUES (13, 1, 1, 9);
INSERT INTO `user_skill` VALUES (14, 1, 2, 10);
INSERT INTO `user_skill` VALUES (40, 1, 6, 7);
INSERT INTO `user_skill` VALUES (43, 1, 21, 7);

SET FOREIGN_KEY_CHECKS = 1;
