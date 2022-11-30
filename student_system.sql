/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql-8.0
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : student_system

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 29/11/2022 21:12:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_clazz
-- ----------------------------
DROP TABLE IF EXISTS `tb_clazz`;
CREATE TABLE `tb_clazz`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `clazz_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `subject_id` int(0) NULL DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_1`(`subject_id`) USING BTREE,
  FOREIGN KEY (`subject_id`) REFERENCES `tb_subject` (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_clazz
-- ----------------------------
INSERT INTO `tb_clazz` VALUES (15, '计算机201', 17, '');
INSERT INTO `tb_clazz` VALUES (16, '计算机202', 17, '');
INSERT INTO `tb_clazz` VALUES (19, '网络202', 17, '');
INSERT INTO `tb_clazz` VALUES (20, '物联网201', 17, '');
INSERT INTO `tb_clazz` VALUES (21, '物联网202', 17, '');
INSERT INTO `tb_clazz` VALUES (22, '材料201', 27, NULL);
INSERT INTO `tb_clazz` VALUES (23, '材料202', 27, NULL);
INSERT INTO `tb_clazz` VALUES (24, '材料203', 27, NULL);
INSERT INTO `tb_clazz` VALUES (27, '化工201', 21, '');
INSERT INTO `tb_clazz` VALUES (28, '俄语201', 18, '');
INSERT INTO `tb_clazz` VALUES (29, '数学201', 22, '');
INSERT INTO `tb_clazz` VALUES (30, '文学203', 29, '');

-- ----------------------------
-- Table structure for tb_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE `tb_course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_course
-- ----------------------------
INSERT INTO `tb_course` VALUES (5, 'Java', '1131');
INSERT INTO `tb_course` VALUES (6, '网络基础', '');
INSERT INTO `tb_course` VALUES (7, 'Javascript', '');
INSERT INTO `tb_course` VALUES (8, '高分子材料', '');
INSERT INTO `tb_course` VALUES (9, '物理化学', '');
INSERT INTO `tb_course` VALUES (10, '大学俄语', '');

-- ----------------------------
-- Table structure for tb_job
-- ----------------------------
DROP TABLE IF EXISTS `tb_job`;
CREATE TABLE `tb_job`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `comp_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job_date` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salay` int(0) NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_7`(`stu_id`) USING BTREE,
  CONSTRAINT `tb_job_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_job
-- ----------------------------
INSERT INTO `tb_job` VALUES (11, '1111', '2111', 3111, '444111', 9);
INSERT INTO `tb_job` VALUES (12, '112', '333', 44, '555', 10);
INSERT INTO `tb_job` VALUES (13, '莫某企业科技公司', '2020-07-01', 15000, '薪水', 11);
INSERT INTO `tb_job` VALUES (14, '互联网公司', '2022-6-5', 10000, '', 16);

-- ----------------------------
-- Table structure for tb_request
-- ----------------------------
DROP TABLE IF EXISTS `tb_request`;
CREATE TABLE `tb_request`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `stu_id` int(0) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `attach` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stu_id`(`stu_id`) USING BTREE,
  CONSTRAINT `tb_request_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`id`)  
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_request
-- ----------------------------
INSERT INTO `tb_request` VALUES (9, '12312', '3123', '休学', '2020-06-28 22:36:12', 9, 3, '', '休息休息', 'xxxxxxxx');
INSERT INTO `tb_request` VALUES (12, '申请休学1个月', '个人私事儿', '休学', '2020-07-05 23:11:15', 16, 3, '7cdedcc1-9920-47a2-8b02-1a177d1bb8fc.jpg', NULL, NULL);
INSERT INTO `tb_request` VALUES (13, '11', '请假', '休学', '2022-05-13 15:21:09', 16, 1, '', NULL, NULL);
INSERT INTO `tb_request` VALUES (14, '请假', '家里私事', '休学', '2022-05-15 12:28:50', 16, 3, '', NULL, NULL);

-- ----------------------------
-- Table structure for tb_score
-- ----------------------------
DROP TABLE IF EXISTS `tb_score`;
CREATE TABLE `tb_score`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `section_id` int(0) NULL DEFAULT NULL,
  `course_id` int(0) NULL DEFAULT NULL,
  `stu_id` int(0) NULL DEFAULT NULL,
  `score` decimal(10, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_10`(`stu_id`) USING BTREE,
  INDEX `FK_Reference_8`(`section_id`) USING BTREE,
  INDEX `FK_Reference_9`(`course_id`) USING BTREE,
  CONSTRAINT `tb_score_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `tb_student` (`id`)  ,
  CONSTRAINT `tb_score_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`)  ,
  CONSTRAINT `tb_score_ibfk_3` FOREIGN KEY (`section_id`) REFERENCES `tb_section` (`id`)  
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_score
-- ----------------------------
INSERT INTO `tb_score` VALUES (52, 11, 5, 17, 88.0);
INSERT INTO `tb_score` VALUES (53, 13, 7, 16, 90.0);
INSERT INTO `tb_score` VALUES (54, 14, 8, 16, 60.0);
INSERT INTO `tb_score` VALUES (55, 15, 10, 22, 75.0);
INSERT INTO `tb_score` VALUES (56, 17, 6, 21, 58.0);

-- ----------------------------
-- Table structure for tb_section
-- ----------------------------
DROP TABLE IF EXISTS `tb_section`;
CREATE TABLE `tb_section`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `year` int(0) NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clazz_id` int(0) NULL DEFAULT NULL,
  `teacher_id` int(0) NULL DEFAULT NULL,
  `course_id` int(0) NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_2`(`clazz_id`) USING BTREE,
  INDEX `FK_Reference_3`(`teacher_id`) USING BTREE,
  INDEX `FK_Reference_4`(`course_id`) USING BTREE,
  CONSTRAINT `tb_section_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `tb_clazz` (`id`)  ,
  CONSTRAINT `tb_section_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`id`)  ,
  CONSTRAINT `tb_section_ibfk_3` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`id`)  
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_section
-- ----------------------------
INSERT INTO `tb_section` VALUES (11, 2021, '春季', 15, 4, 6, '');
INSERT INTO `tb_section` VALUES (12, 2022, '春季', 15, 5, 5, '');
INSERT INTO `tb_section` VALUES (14, 2022, '春季', 28, 5, 10, '');
INSERT INTO `tb_section` VALUES (15, 2021, '秋季', 20, 5, 6, '');
INSERT INTO `tb_section` VALUES (16, 2021, '春季', 21, 9, 7, '');
INSERT INTO `tb_section` VALUES (17, 2022, '秋季', 19, 5, 7, '');
INSERT INTO `tb_section` VALUES (18, 2022, '春季', 27, 4, 9, '');
INSERT INTO `tb_section` VALUES (25, 2021, '春季', 19, 4, 6, '');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stu_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card_no` char(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `join_date` datetime(0) NULL DEFAULT NULL,
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clazz_id` int(0) NULL DEFAULT NULL,
  `subject_id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_5`(`clazz_id`) USING BTREE,
  INDEX `FK_Reference_6`(`subject_id`) USING BTREE,
  CONSTRAINT `tb_student_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `tb_clazz` (`id`)  ,
  CONSTRAINT `tb_student_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `tb_subject` (`id`)  
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES (16, '0001', '李小孟', '93a9ded8a9ab7cb69dba0c0575665204', '123123123123456789', '男', NULL, '15198929589', '', '', '', '2021-02-21 00:00:00', NULL, 15, 17);
INSERT INTO `tb_student` VALUES (17, '0002', '小萌', '93a9ded8a9ab7cb69dba0c0575665204', '123456789123123123', '女', NULL, '15029716979', '', '', '', '2022-05-02 00:00:00', NULL, 15, 17);
INSERT INTO `tb_student` VALUES (19, '0003', '吴晓东', '93a9ded8a9ab7cb69dba0c0575665204', '123123178962423123', '男', NULL, '18538492893', '', '', '', '2022-01-27 00:00:00', NULL, 16, 17);
INSERT INTO `tb_student` VALUES (20, '0004', '邵霎', '93a9ded8a9ab7cb69dba0c0575665204', '123159151918923123', '女', NULL, '18516597924', '', '', '', '2022-03-17 00:00:00', NULL, 23, 27);
INSERT INTO `tb_student` VALUES (21, '0005', '张添', '93a9ded8a9ab7cb69dba0c0575665204', '598182982123123123', '男', NULL, '18795299265', '', '', '', '2022-05-02 00:00:00', NULL, 22, 27);
INSERT INTO `tb_student` VALUES (22, '0006', '李萨', '93a9ded8a9ab7cb69dba0c0575665204', '198499312381259510', '男', NULL, '13095983981', '', '', '', '2022-05-05 00:00:00', NULL, 15, 17);
INSERT INTO `tb_student` VALUES (23, '0007', '胡静', '93a9ded8a9ab7cb69dba0c0575665204', '591929211248791044', '男', NULL, '18533333333', '', '', '', '2022-05-06 00:00:00', NULL, 28, 18);
INSERT INTO `tb_student` VALUES (24, '0020', '王东', '93a9ded8a9ab7cb69dba0c0575665204', '782623129923149192', '男', NULL, '18533384916', '', '', '', '2022-04-13 00:00:00', '正常', 24, 27);
INSERT INTO `tb_student` VALUES (25, '0011', '夏季', '93a9ded8a9ab7cb69dba0c0575665204', '956929262959298233', '女', NULL, '12347598696', NULL, NULL, NULL, '2022-05-14 18:47:08', NULL, 21, 17);
INSERT INTO `tb_student` VALUES (26, '0012', '小天', '93a9ded8a9ab7cb69dba0c0575665204', '492933594299126298', '男', NULL, '13597297928', NULL, NULL, NULL, NULL, '', 20, 17);
INSERT INTO `tb_student` VALUES (27, '0045', '张章', '93a9ded8a9ab7cb69dba0c0575665204', '782623568923149192', '男', NULL, '18578953621', '张爱国', '1542396321', '南江临下路', '2022-05-15 00:00:00', '正常', 28, 18);
INSERT INTO `tb_student` VALUES (28, '0046', '于舟', '93a9ded8a9ab7cb69dba0c0575665204', '123123123123123123', '男', NULL, '18533333333', '于浒', '15963799566', '南江临下3号路', '2019-05-14 00:00:00', '正常', 29, 22);
INSERT INTO `tb_student` VALUES (29, '0047', '宋以山', '93a9ded8a9ab7cb69dba0c0575665204', '123159151918923236', '男', NULL, '18578931564', '宋文', '15963799125', '夏橙3号路', '2019-05-14 00:00:00', '正常', 30, 29);
INSERT INTO `tb_student` VALUES (30, '0048', '宋洁', '93a9ded8a9ab7cb69dba0c0575665204', '123125456963456789', '女', NULL, '15112389654', '宋霞', '12967813691', '西城小苑', '2019-05-14 00:00:00', '正常', 22, 27);
INSERT INTO `tb_student` VALUES (31, '0049', '张文', '93a9ded8a9ab7cb69dba0c0575665204', '123123123123123123', '男', NULL, '18533333333', '', '', '', '2020-05-05 00:00:00', '正常', 19, 17);
INSERT INTO `tb_student` VALUES (32, '0050', '孟杨', '93a9ded8a9ab7cb69dba0c0575665204', '123123123123123123', '男', NULL, '18533333333', '', '', '', '2018-05-09 00:00:00', '正常', 19, 17);
INSERT INTO `tb_student` VALUES (33, '0051', '刘旭', '93a9ded8a9ab7cb69dba0c0575665204', '123123123789624123', '男', NULL, '18533856333', '', '', '', '2018-05-03 00:00:00', '正常', 15, 17);
INSERT INTO `tb_student` VALUES (34, '0052', '夏明', '93a9ded8a9ab7cb69dba0c0575665204', '123753621143123123', '女', NULL, '18542638761', '', '', '', '2018-05-23 00:00:00', '正常', 27, 21);
INSERT INTO `tb_student` VALUES (35, '0055', '文静', '93a9ded8a9ab7cb69dba0c0575665204', '123741236965854126', '女', NULL, '13024635981', '', '', '', '2019-05-10 00:00:00', '正常', 29, 22);

-- ----------------------------
-- Table structure for tb_subject
-- ----------------------------
DROP TABLE IF EXISTS `tb_subject`;
CREATE TABLE `tb_subject`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_subject
-- ----------------------------
INSERT INTO `tb_subject` VALUES (17, '计算机科学与技术', '计算机系', '');
INSERT INTO `tb_subject` VALUES (18, '俄语', '外语系', '');
INSERT INTO `tb_subject` VALUES (19, '物流管理', '工商管理系', '');
INSERT INTO `tb_subject` VALUES (20, '软件工程', '计算机系', '');
INSERT INTO `tb_subject` VALUES (21, '化学材料', '化学系', NULL);
INSERT INTO `tb_subject` VALUES (22, '高等数学', '数学系', NULL);
INSERT INTO `tb_subject` VALUES (23, '物理', '物理系', NULL);
INSERT INTO `tb_subject` VALUES (24, '英语', '外语系', NULL);
INSERT INTO `tb_subject` VALUES (26, '高分子材料', '化学系', NULL);
INSERT INTO `tb_subject` VALUES (27, '材料结构', '材料系', NULL);
INSERT INTO `tb_subject` VALUES (28, '物理化学', '化学系', NULL);
INSERT INTO `tb_subject` VALUES (29, '文学', '教育系', NULL);

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teacher_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES (4, 'zhangsan', '93a9ded8a9ab7cb69dba0c0575665204', '', '张三');
INSERT INTO `tb_teacher` VALUES (5, 'shaoshao ', '93a9ded8a9ab7cb69dba0c0575665204', '', '李四');
INSERT INTO `tb_teacher` VALUES (6, 'hanjing', '93a9ded8a9ab7cb69dba0c0575665204', '', '韩静');
INSERT INTO `tb_teacher` VALUES (9, 'tangzhi ', '93a9ded8a9ab7cb69dba0c0575665204', '', '唐枝');
INSERT INTO `tb_teacher` VALUES (10, 'mutangzhi', '93a9ded8a9ab7cb69dba0c0575665204', '达到', '沐沐');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'admin', '93a9ded8a9ab7cb69dba0c0575665204', '管理员', '备注信息');
INSERT INTO `tb_user` VALUES (7, 'hua', '93a9ded8a9ab7cb69dba0c0575665204', 'hua', 'hua');
INSERT INTO `tb_user` VALUES (8, 'aa', '93a9ded8a9ab7cb69dba0c0575665204', 'aaa', '');

SET FOREIGN_KEY_CHECKS = 1;
