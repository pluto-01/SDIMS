/*
 Navicat Premium Data Transfer

 Source Server         : zed
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : stu_db

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 29/11/2022 17:09:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_adminuser
-- ----------------------------
DROP TABLE IF EXISTS `t_adminuser`;
CREATE TABLE `t_adminuser`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `tel` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_adminuser
-- ----------------------------
INSERT INTO `t_adminuser` VALUES (1, 'admin1', '123', '张三', '男', '13945783428');
INSERT INTO `t_adminuser` VALUES (2, 'admin2', '123', '李欣', '女', '19959209453');

-- ----------------------------
-- Table structure for t_bill
-- ----------------------------
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `departmentId` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `waterbill` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `elecbill` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_bill
-- ----------------------------
INSERT INTO `t_bill` VALUES (1, '101', '61', '93', '2022-11');
INSERT INTO `t_bill` VALUES (2, '102', '74', '85', '2022-11');
INSERT INTO `t_bill` VALUES (3, '103', '85', '99', '2022-11');
INSERT INTO `t_bill` VALUES (4, '104', '83', '88', '2022-11');
INSERT INTO `t_bill` VALUES (5, '189', '82', '75', '2022-11');
INSERT INTO `t_bill` VALUES (6, '199', '77', '73', '2022-11');
INSERT INTO `t_bill` VALUES (7, '101', '66', '83', '2022-10');
INSERT INTO `t_bill` VALUES (8, '102', '67', '80', '2022-10');
INSERT INTO `t_bill` VALUES (9, '103', '95', '79', '2022-10');
INSERT INTO `t_bill` VALUES (10, '104', '99', '75', '2022-10');
INSERT INTO `t_bill` VALUES (11, '189', '85', '94', '2022-10');
INSERT INTO `t_bill` VALUES (12, '199', '88', '75', '2022-10');
INSERT INTO `t_bill` VALUES (13, '101', '75', '73', '2022-09');
INSERT INTO `t_bill` VALUES (14, '102', '85', '93', '2022-09');
INSERT INTO `t_bill` VALUES (15, '103', '85', '83', '2022-09');
INSERT INTO `t_bill` VALUES (16, '104', '90', '73', '2022-09');
INSERT INTO `t_bill` VALUES (17, '189', '98', '85', '2022-09');
INSERT INTO `t_bill` VALUES (18, '199', '83', '73', '2022-09');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `departmentId` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `deptTel` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`departmentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('101', '85357567');
INSERT INTO `t_department` VALUES ('102', '85357566');
INSERT INTO `t_department` VALUES ('103', '85357384');
INSERT INTO `t_department` VALUES ('104', '85347274');
INSERT INTO `t_department` VALUES ('199', '85396242');

-- ----------------------------
-- Table structure for t_itemin
-- ----------------------------
DROP TABLE IF EXISTS `t_itemin`;
CREATE TABLE `t_itemin`  (
  `stuname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `itemname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `date` date NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_itemin
-- ----------------------------
INSERT INTO `t_itemin` VALUES ('张三', '桌子', '2022-10-21', NULL);
INSERT INTO `t_itemin` VALUES ('李四', '椅子', '2022-10-26', '替换损坏的椅子');
INSERT INTO `t_itemin` VALUES ('陈静', '桌子', '2022-11-02', NULL);
INSERT INTO `t_itemin` VALUES ('林南', '书架', '2022-11-02', '用于公共区域');
INSERT INTO `t_itemin` VALUES ('赵颖', '抽屉', '2022-11-06', '');
INSERT INTO `t_itemin` VALUES ('陈力', '椅子', '2022-11-08', '');

-- ----------------------------
-- Table structure for t_itemout
-- ----------------------------
DROP TABLE IF EXISTS `t_itemout`;
CREATE TABLE `t_itemout`  (
  `stuname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `itemname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `date` date NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_itemout
-- ----------------------------
INSERT INTO `t_itemout` VALUES ('李晨', '桌子', '2022-11-02', '已损坏');
INSERT INTO `t_itemout` VALUES ('李彤', '椅子', '2022-11-05', '已损坏');
INSERT INTO `t_itemout` VALUES ('陈琳', '抽屉', '2022-11-06', '已损坏');
INSERT INTO `t_itemout` VALUES ('王明', '桌子', '2022-11-05', '');
INSERT INTO `t_itemout` VALUES ('林宁', '书架', '2022-11-09', '');
INSERT INTO `t_itemout` VALUES ('王莹', '桌子', '2022-11-11', '换新');

-- ----------------------------
-- Table structure for t_property
-- ----------------------------
DROP TABLE IF EXISTS `t_property`;
CREATE TABLE `t_property`  (
  `propertynum` int(0) NOT NULL,
  `propertyname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `propertycount` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`propertynum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_property
-- ----------------------------
INSERT INTO `t_property` VALUES (5, '镜子', '1');
INSERT INTO `t_property` VALUES (8, '晾衣杆', '1');
INSERT INTO `t_property` VALUES (10, '椅子', '4');
INSERT INTO `t_property` VALUES (13, '电风扇', '2');
INSERT INTO `t_property` VALUES (15, '桌子', '4');
INSERT INTO `t_property` VALUES (18, '电灯', '2');
INSERT INTO `t_property` VALUES (25, '柜子', '6');
INSERT INTO `t_property` VALUES (35, '床铺', '4');
INSERT INTO `t_property` VALUES (40, '门', '2');

-- ----------------------------
-- Table structure for t_repair
-- ----------------------------
DROP TABLE IF EXISTS `t_repair`;
CREATE TABLE `t_repair`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `departmentId` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `propertyNum` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `startdate` date NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `finishdate` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_repair
-- ----------------------------
INSERT INTO `t_repair` VALUES (1, '101', '5', '2022-11-03', '打碎了镜子', '已完成', '2022-11-03');
INSERT INTO `t_repair` VALUES (2, '104', '10', '2022-11-04', '椅背断了', '已完成', '2022-11-05');
INSERT INTO `t_repair` VALUES (3, '199', '25', '2022-11-09', '柜子门坏了', '待处理', NULL);

-- ----------------------------
-- Table structure for t_stuinfo
-- ----------------------------
DROP TABLE IF EXISTS `t_stuinfo`;
CREATE TABLE `t_stuinfo`  (
  `sno` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `departmentId` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `major` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `tel` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stuinfo
-- ----------------------------
INSERT INTO `t_stuinfo` VALUES ('212234859', 1, '101', '张三', '软工', '男', '13945783428');
INSERT INTO `t_stuinfo` VALUES ('212243434', 2, '102', '王五', '软工', '男', '18923426447');
INSERT INTO `t_stuinfo` VALUES ('212304833', 3, '101', '郑明', '软工', '男', '18923627323');
INSERT INTO `t_stuinfo` VALUES ('212343534', 4, '103', '李欣', '软工', '女', '19959209453');
INSERT INTO `t_stuinfo` VALUES ('212343843', 5, '102', '李力', '数媒', '男', '18923627386');
INSERT INTO `t_stuinfo` VALUES ('212344352', 6, '101', '李晨', '软工', '男', '18963468262');
INSERT INTO `t_stuinfo` VALUES ('212346348', 7, '189', '林宁', '数媒', '女', '18934687533');
INSERT INTO `t_stuinfo` VALUES ('212347343', 8, '104', '李彤', '数媒', '女', '18923468462');
INSERT INTO `t_stuinfo` VALUES ('212354523', 9, '199', '林南', '计科', '男', '18968406835');
INSERT INTO `t_stuinfo` VALUES ('212453454', 10, '101', '李四', '数媒', '男', '13749567304');
INSERT INTO `t_stuinfo` VALUES ('212454533', 11, '104', '陈琳', '计科', '女', '18923623623');
INSERT INTO `t_stuinfo` VALUES ('212455342', 12, '189', '李丽', '计科', '女', '18923854423');
INSERT INTO `t_stuinfo` VALUES ('212543545', 13, '103', '陈静', '软工', '女', '18929483958');
INSERT INTO `t_stuinfo` VALUES ('212006373', 14, '199', '王明', '计科', '男', '18924578252');
INSERT INTO `t_stuinfo` VALUES ('212934723', 15, '189', '赵颖', '计科', '女', '18934642534');
INSERT INTO `t_stuinfo` VALUES ('212654238', 16, '189', '吴敏', '计科', '女', '18953567357');
INSERT INTO `t_stuinfo` VALUES ('212996345', 17, '199', '孙亮', '软工', '男', '18934281464');
INSERT INTO `t_stuinfo` VALUES ('212675484', 19, '201', '方平', '计科', '男', '15364792467');
INSERT INTO `t_stuinfo` VALUES ('212964346', 30, '201', '刘畅', '数媒', '男', '18943584356');
INSERT INTO `t_stuinfo` VALUES ('212985142', 31, '202', '王莹', '数媒', '女', '18945384623');

-- ----------------------------
-- Table structure for t_stuuser
-- ----------------------------
DROP TABLE IF EXISTS `t_stuuser`;
CREATE TABLE `t_stuuser`  (
  `sno` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `tel` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_stuuser
-- ----------------------------
INSERT INTO `t_stuuser` VALUES ('212344352', '111', '李晨', '123', '男', '18963468262');
INSERT INTO `t_stuuser` VALUES ('212006373', '112', '王明', '123', '男', '18924578252');
INSERT INTO `t_stuuser` VALUES ('212454533', '113', '陈琳', '123', '女', '13957384385');
INSERT INTO `t_stuuser` VALUES ('212455342', '114', '李丽', '123', '女', '13923476864');

-- ----------------------------
-- Table structure for t_visit
-- ----------------------------
DROP TABLE IF EXISTS `t_visit`;
CREATE TABLE `t_visit`  (
  `visitor` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_visit
-- ----------------------------
INSERT INTO `t_visit` VALUES ('访客1', '男', '找同学', '15364736432', '2022-09-20');
INSERT INTO `t_visit` VALUES ('访客2', '男', '送矿泉水', '15376473454', '2022-10-04');
INSERT INTO `t_visit` VALUES ('访客3', '男', '找同学', '15376569732', '2022-10-26');
INSERT INTO `t_visit` VALUES ('访客4', '男', '找同学', '15373457262', '2022-10-31');
INSERT INTO `t_visit` VALUES ('访客5', '男', '找同学', '15334976351', '2022-11-06');
INSERT INTO `t_visit` VALUES ('访客6', '女', '查寝', '15354697352', '2022-11-11');

-- ----------------------------
-- Table structure for t_workeruser
-- ----------------------------
DROP TABLE IF EXISTS `t_workeruser`;
CREATE TABLE `t_workeruser`  (
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_workeruser
-- ----------------------------
INSERT INTO `t_workeruser` VALUES ('worker1', '职工1', '123', '男', '13945863482');
INSERT INTO `t_workeruser` VALUES ('worker2', '职工2', '123', '女', '13923682424');

-- ----------------------------
-- Triggers structure for table t_repair
-- ----------------------------
DROP TRIGGER IF EXISTS `trigger`;
delimiter ;;
CREATE TRIGGER `trigger` BEFORE UPDATE ON `t_repair` FOR EACH ROW IF	old.`status` != '待处理' THEN
	SET new.finishdate = CURRENT_DATE;
	end if
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
