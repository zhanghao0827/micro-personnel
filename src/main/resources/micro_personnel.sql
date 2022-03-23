/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306@MySQL8.0.22
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : micro_personnel0815

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 23/03/2022 16:11:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_login
-- ----------------------------
DROP TABLE IF EXISTS `log_login`;
CREATE TABLE `log_login`  (
  `login_id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录用户名',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录IP',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录地址',
  `browser` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器',
  `os` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作系统',
  `login_time` datetime NULL DEFAULT NULL COMMENT '登录时间',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 414 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_login
-- ----------------------------
INSERT INTO `log_login` VALUES (409, 'admin', '171.82.225.71', '中国湖北省', 'Chrome 9', 'Windows 10', '2022-03-12 21:05:58');
INSERT INTO `log_login` VALUES (410, 'admin', '171.82.225.71', '中国湖北省', 'Chrome 9', 'Windows 10', '2022-03-12 21:07:41');
INSERT INTO `log_login` VALUES (411, 'admin', '171.82.225.71', '中国湖北省', 'Chrome 9', 'Windows 10', '2022-03-12 21:08:26');
INSERT INTO `log_login` VALUES (412, 'admin', '171.82.225.71', '中国湖北省', 'Chrome 9', 'Windows 10', '2022-03-12 21:11:06');
INSERT INTO `log_login` VALUES (413, 'admin', '171.82.225.71', '中国湖北省', 'Chrome 9', 'Windows 10', '2022-03-12 21:19:14');

-- ----------------------------
-- Table structure for log_oper
-- ----------------------------
DROP TABLE IF EXISTS `log_oper`;
CREATE TABLE `log_oper`  (
  `oper_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `oper_module` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作模块',
  `oper_content` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作内容',
  `user_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作用户名',
  `oper_ip` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `oper_location` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `oper_status` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作状态',
  `oper_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_oper
-- ----------------------------

-- ----------------------------
-- Table structure for ser_email
-- ----------------------------
DROP TABLE IF EXISTS `ser_email`;
CREATE TABLE `ser_email`  (
  `email_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `addressee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '收件人',
  `email_subject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮件主题',
  `email_text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '邮件内容',
  `sent_date` datetime NULL DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`email_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ser_email
-- ----------------------------

-- ----------------------------
-- Table structure for ser_notice
-- ----------------------------
DROP TABLE IF EXISTS `ser_notice`;
CREATE TABLE `ser_notice`  (
  `notice_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `notice_title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `notice_type` enum('通知','公告') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `notice_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ser_notice
-- ----------------------------
INSERT INTO `ser_notice` VALUES (1, '项目环境搭建', '公告', '设计数据库表，完成用户登录退出功能', '2020-08-15 13:58:10', '2020-09-10 11:48:29');
INSERT INTO `ser_notice` VALUES (2, '权限管理设计', '公告', '完成动态权限管理功能，以及设计Home页面', '2020-08-16 15:43:15', '2020-08-16 15:43:18');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` int NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` int NULL DEFAULT NULL COMMENT '父级部门id',
  `ancestors` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '祖宗节点',
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, 0, '0', '股东会', '2020-09-09 18:31:11', '2020-09-09 18:31:13');
INSERT INTO `sys_dept` VALUES (2, 1, '1', '董事会', '2020-09-09 18:33:09', '2020-09-10 11:56:02');
INSERT INTO `sys_dept` VALUES (3, 2, '1,2', '上海总部', '2020-09-09 18:34:55', '2020-09-10 16:50:14');
INSERT INTO `sys_dept` VALUES (4, 3, '1,2,3', '运维部', '2020-09-09 20:43:12', '2020-09-09 20:43:12');
INSERT INTO `sys_dept` VALUES (6, 2, '1,2', '南京分部', '2020-09-10 16:49:39', '2020-09-10 16:49:39');
INSERT INTO `sys_dept` VALUES (7, 2, '1,2', '深圳分部', '2020-09-10 16:50:02', '2020-12-16 11:41:51');
INSERT INTO `sys_dept` VALUES (8, 6, '1,2,6', '营销部', '2020-09-10 16:50:39', '2020-09-10 16:50:39');
INSERT INTO `sys_dept` VALUES (41, 7, '1,2,7', '行政部', '2020-12-16 11:42:33', '2020-12-16 11:42:33');
INSERT INTO `sys_dept` VALUES (43, 3, '1,2,3', '市场部', '2020-12-27 23:25:26', '2020-12-27 23:25:26');

-- ----------------------------
-- Table structure for sys_emp
-- ----------------------------
DROP TABLE IF EXISTS `sys_emp`;
CREATE TABLE `sys_emp`  (
  `emp_id` int NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `dept_id` int NULL DEFAULT NULL COMMENT '部门id',
  `emp_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工名称',
  `gender` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '出生日期',
  `native_place` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `nation` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '民族',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `degree` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学位',
  `position` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位',
  `work_time` date NULL DEFAULT NULL COMMENT '入职时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_emp
-- ----------------------------
INSERT INTO `sys_emp` VALUES (1, 1, '张昊', '男', '2000-08-27', '江苏省徐州市', '汉', '320322200008275910', '18114970827', '785896760@qq.com', '本科', 'Java工程师', '2020-09-03', '2020-09-10 13:28:43', '2020-12-24 01:13:09');
INSERT INTO `sys_emp` VALUES (2, 2, '孙岩', '男', '1999-09-19', '江苏省淮安市', '汉', '320322199909191234', '19852105211', '1572837278@qq.com', '本科', 'C++工程师', '2020-09-04', '2020-09-10 13:37:18', '2020-12-24 01:13:15');
INSERT INTO `sys_emp` VALUES (3, 2, '王拓宽', '女', '1999-04-28', '山西省运城市', '汉', '142726199904283011', '15985968023', '1093824058@qq.com', '本科', '算法工程师', '2020-09-05', '2020-09-10 13:39:53', '2020-09-10 19:00:30');
INSERT INTO `sys_emp` VALUES (4, 6, '徐致为', '男', '2000-06-26', '湖北省武汉市', '汉', '420302200006251518', '13190202911', '2217332694@qq.com', '本科', '前端工程师', '2020-09-06', '2020-09-10 13:41:44', '2020-09-10 17:14:17');
INSERT INTO `sys_emp` VALUES (6, 7, '陈艺方', '男', '1999-11-25', '山东省日照市', '汉', '320322199910101234', '15863371897', '1189191010@qq.com', '本科', '运维工程师', '2020-08-31', '2020-09-12 14:26:53', '2020-12-15 22:19:28');
INSERT INTO `sys_emp` VALUES (7, 6, '吴志远', '男', '2001-09-04', '福建省', '汉', '320322199910101234', '18114970827', '17281882@qq.com', '本科', '算法工程师', '2020-09-07', '2020-09-12 15:05:41', '2020-12-15 22:19:55');
INSERT INTO `sys_emp` VALUES (27, 6, '张三', '男', '2000-08-27', '江苏省徐州市', '汉', '320322200008275910', '18114970827', '785896760@qq.com', '本科', 'Java工程师', '2020-09-03', '2020-09-10 13:28:43', '2020-09-10 13:28:45');
INSERT INTO `sys_emp` VALUES (28, 7, '李四', '男', '1999-09-19', '江苏省淮安市', '汉', '320322199909191234', '19852105211', '1572837278@qq.com', '本科', 'C++工程师', '2020-09-04', '2020-09-10 13:37:18', '2020-09-10 13:37:20');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `menu_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `parent_id` int NULL DEFAULT NULL COMMENT '父级菜单id',
  `url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问url',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由path',
  `component` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `enabled` bit(1) NULL DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 304 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, '/', '/home', 'Home', 'el-icon-s-tools', b'1');
INSERT INTO `sys_menu` VALUES (2, '服务管理', 0, '/', '/home', 'Home', 'el-icon-data-line', b'1');
INSERT INTO `sys_menu` VALUES (3, '日志管理', 0, '/', '/home', 'Home', 'el-icon-date', b'1');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, '/sys/user/**', '/sys/user', 'SysUser', 'el-icon-user-solid', b'1');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, '/sys/role/**', '/sys/role', 'SysRole', 'el-icon-s-check', b'1');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, '/sys/menu/**', '/sys/menu', 'SysMenu', 'el-icon-menu', b'1');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, '/sys/dept/**', '/sys/dept', 'SysDept', 'el-icon-office-building', b'1');
INSERT INTO `sys_menu` VALUES (104, '员工管理', 1, '/sys/emp/**', '/sys/emp', 'SysEmp', 'el-icon-s-custom', b'1');
INSERT INTO `sys_menu` VALUES (200, '邮箱服务', 2, '/ser/email/**', '/ser/email', 'SerEmail', 'el-icon-message', b'1');
INSERT INTO `sys_menu` VALUES (201, '通知公告', 2, '/ser/notice/**', '/ser/notice', 'SerNotice', 'el-icon-s-comment\r\n', b'1');
INSERT INTO `sys_menu` VALUES (300, '登录日志', 3, '/log/login/**', '/log/login', 'LogLogin', 'el-icon-s-claim', b'1');
INSERT INTO `sys_menu` VALUES (301, '操作日志', 3, '/log/oper/**', '/log/oper', 'LogOper', 'el-icon-s-order', b'1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色权限标识',
  `del_flag` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROLE_root', b'0');
INSERT INTO `sys_role` VALUES (2, '管理员', 'ROLE_admin', b'0');
INSERT INTO `sys_role` VALUES (3, '普通用户', 'ROLE_comm', b'0');
INSERT INTO `sys_role` VALUES (4, '测试角色123', 'ROLE_test', b'0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int NOT NULL COMMENT '角色ID',
  `menu_id` int NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 100);
INSERT INTO `sys_role_menu` VALUES (1, 101);
INSERT INTO `sys_role_menu` VALUES (1, 102);
INSERT INTO `sys_role_menu` VALUES (1, 103);
INSERT INTO `sys_role_menu` VALUES (1, 104);
INSERT INTO `sys_role_menu` VALUES (1, 200);
INSERT INTO `sys_role_menu` VALUES (1, 201);
INSERT INTO `sys_role_menu` VALUES (1, 300);
INSERT INTO `sys_role_menu` VALUES (1, 301);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 200);
INSERT INTO `sys_role_menu` VALUES (2, 201);
INSERT INTO `sys_role_menu` VALUES (2, 202);
INSERT INTO `sys_role_menu` VALUES (2, 300);
INSERT INTO `sys_role_menu` VALUES (2, 301);
INSERT INTO `sys_role_menu` VALUES (3, 103);
INSERT INTO `sys_role_menu` VALUES (3, 104);
INSERT INTO `sys_role_menu` VALUES (3, 200);
INSERT INTO `sys_role_menu` VALUES (3, 201);
INSERT INTO `sys_role_menu` VALUES (3, 300);
INSERT INTO `sys_role_menu` VALUES (3, 301);
INSERT INTO `sys_role_menu` VALUES (4, 100);
INSERT INTO `sys_role_menu` VALUES (4, 101);
INSERT INTO `sys_role_menu` VALUES (4, 102);
INSERT INTO `sys_role_menu` VALUES (4, 103);
INSERT INTO `sys_role_menu` VALUES (4, 104);
INSERT INTO `sys_role_menu` VALUES (4, 200);
INSERT INTO `sys_role_menu` VALUES (4, 201);
INSERT INTO `sys_role_menu` VALUES (4, 300);
INSERT INTO `sys_role_menu` VALUES (4, 301);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `email` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `enabled` bit(1) NULL DEFAULT NULL COMMENT '是否可用',
  `del_flag` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'Admin', '$2a$10$3A4QtB6o9UvKe9xFoRbh1ubboMAx/U48yAyBRLc37gxzEWldlnzIe', '785896760@qq.com', '18114970827', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-06-30 11:06:30', '2020-12-24 01:15:41', b'1', b'0');
INSERT INTO `sys_user` VALUES (2, 'zhanghao', '张昊', '$2a$10$3A4QtB6o9UvKe9xFoRbh1ubboMAx/U48yAyBRLc37gxzEWldlnzIe', '1572837278@qq.com', '19852105211', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-07-15 11:06:42', '2020-12-09 14:25:09', b'1', b'0');
INSERT INTO `sys_user` VALUES (3, 'sunyan', '孙岩', '$2a$10$3A4QtB6o9UvKe9xFoRbh1ubboMAx/U48yAyBRLc37gxzEWldlnzIe', '1093824058@qq.com', '15371636545', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-08-22 11:06:48', '2020-08-22 11:06:51', b'1', b'0');
INSERT INTO `sys_user` VALUES (4, 'xuzhiwei', '徐致为', '$2a$10$3A4QtB6o9UvKe9xFoRbh1ubboMAx/U48yAyBRLc37gxzEWldlnzIe', '2217332694@qq.com', '15525553555', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-08-22 11:06:54', '2020-08-22 11:06:56', b'1', b'0');
INSERT INTO `sys_user` VALUES (5, 'wangtuokuan', '王拓宽', '$2a$10$3A4QtB6o9UvKe9xFoRbh1ubboMAx/U48yAyBRLc37gxzEWldlnzIe', '572375205@qq.com', '19852105211', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-08-22 11:06:59', '2020-08-22 11:07:01', b'1', b'0');
INSERT INTO `sys_user` VALUES (6, 'chenyifang', '陈艺方', '$2a$10$vyMHGy4BJhfgNGqpNCEwueqxBWH.lp4V6uqCiDrsn1IPBUk5Hup5C', '1998199@qq.com', '18181991991', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-08-22 11:07:03', '2020-08-22 11:07:06', b'1', b'0');
INSERT INTO `sys_user` VALUES (7, 'wuzhiyuan', '吴志远', '$2a$10$11hXrlIyTPYjfomCuEfNVOoVUuhwYOu6aC47aoMijzUueRcX6mVqy', '7188181@qq.com', '17720585704', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-12-16 18:44:57', '2020-12-16 18:44:57', b'1', b'0');
INSERT INTO `sys_user` VALUES (33, 'user', 'User', '$2a$10$euGRAqJC8PvsizRTxPVsLuUrF7s7khcpHeip.Q.bXr46SPRaERcrq', '123981818@qq.com', '15588888888', 'https://zhang-hao.oss-cn-beijing.aliyuncs.com/winter/avatar/default_avatar.jpg', '2020-12-27 23:22:37', '2020-12-27 23:22:37', b'1', b'0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int NOT NULL COMMENT '用户ID',
  `role_id` int NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (1, 3);
INSERT INTO `sys_user_role` VALUES (2, 1);
INSERT INTO `sys_user_role` VALUES (3, 3);
INSERT INTO `sys_user_role` VALUES (4, 2);
INSERT INTO `sys_user_role` VALUES (4, 3);
INSERT INTO `sys_user_role` VALUES (5, 3);
INSERT INTO `sys_user_role` VALUES (6, 1);
INSERT INTO `sys_user_role` VALUES (7, 2);
INSERT INTO `sys_user_role` VALUES (33, 1);
INSERT INTO `sys_user_role` VALUES (33, 2);
INSERT INTO `sys_user_role` VALUES (33, 3);

SET FOREIGN_KEY_CHECKS = 1;
