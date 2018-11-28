# springboot mybatis 多表联合查询演示项目

    SpringBoot + Mybatis 注解版   + Druid数据库连接池+ thyleamf模板引擎等技术

- JDBC数据库连接参数[ 解决新版本数据库连接失败的多个问题 ]
~~~yaml
 url: jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
~~~


- 建表语句
~~~sql
/*
 Navicat Premium Data Transfer

 Source Server         : MariaDB10.3_3306
 Source Server Type    : MariaDB
 Source Server Version : 100308
 Source Host           : localhost:3306
 Source Schema         : mydb

 Target Server Type    : MariaDB
 Target Server Version : 100308
 File Encoding         : 65001

 Date: 28/11/2018 19:02:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for my_address
-- ----------------------------
DROP TABLE IF EXISTS `my_address`;
CREATE TABLE `my_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_address
-- ----------------------------
INSERT INTO `my_address` VALUES (1, '北京', '北京');
INSERT INTO `my_address` VALUES (2, '天津', '天津');
INSERT INTO `my_address` VALUES (3, '安徽', '宿州');
INSERT INTO `my_address` VALUES (4, '广东', '广州');
INSERT INTO `my_address` VALUES (5, '云南', '昆明');

-- ----------------------------
-- Table structure for my_car
-- ----------------------------
DROP TABLE IF EXISTS `my_car`;
CREATE TABLE `my_car`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_car
-- ----------------------------
INSERT INTO `my_car` VALUES (1, 'green', '路虎', 1);
INSERT INTO `my_car` VALUES (2, 'white', '奔驰', 2);
INSERT INTO `my_car` VALUES (3, 'blue', '玛莎拉蒂', 4);
INSERT INTO `my_car` VALUES (4, 'yellow', '兰博基尼', 4);
INSERT INTO `my_car` VALUES (5, 'red', '丰田', 6);
INSERT INTO `my_car` VALUES (6, 'blue', 'MPV', 6);

-- ----------------------------
-- Table structure for my_user
-- ----------------------------
DROP TABLE IF EXISTS `my_user`;
CREATE TABLE `my_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `address_id` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_user
-- ----------------------------
INSERT INTO `my_user` VALUES (1, '张三', 'very-secret', 'aa@qq.com', '13888888888', '0', 15, 4);
INSERT INTO `my_user` VALUES (2, '李四', 'very-secret', 'bb@qq.com', '123', '1', 60, 6);
INSERT INTO `my_user` VALUES (3, '王五', 'very-secret', '3021@qq.com', NULL, '1', 46, 4);
INSERT INTO `my_user` VALUES (4, '宋江', 'very-secret', '5790@qq.com', '456', '1', 41, 3);
INSERT INTO `my_user` VALUES (5, '卢俊义', 'very-secret', '3883@qq.com', NULL, '0', 54, 6);
INSERT INTO `my_user` VALUES (6, '张飞', 'very-secret', '1046@qq.com', NULL, '1', 38, 3);
INSERT INTO `my_user` VALUES (7, '李逵', 'very-secret', '2583@qq.com', NULL, '1', 18, 3);
INSERT INTO `my_user` VALUES (8, 'tekin', '999998888', '3775@qq.com', '789', '0', 12, 4);
INSERT INTO `my_user` VALUES (9, '章子怡', '999998888', '5123@qq.com', NULL, '1', 45, 4);
INSERT INTO `my_user` VALUES (10, '百度', 'very-secret', '3290@qq.com', NULL, '0', 28, 2);
INSERT INTO `my_user` VALUES (11, '李彦宏', '999998888', '5082@qq.com', NULL, '1', 45, 5);

SET FOREIGN_KEY_CHECKS = 1;

~~~