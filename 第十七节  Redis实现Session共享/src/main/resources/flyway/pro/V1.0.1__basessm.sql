/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : basessm

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-10-08 17:01:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', '生产库大宇', '22');
INSERT INTO `t_student` VALUES ('2', '生产库小宇', '20');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'jay', '25');
INSERT INTO `t_user` VALUES ('2', 'sunny', '24');
INSERT INTO `t_user` VALUES ('3', 'charles', '23');
INSERT INTO `t_user` VALUES ('4', 'klose', '22');
INSERT INTO `t_user` VALUES ('5', 'jim', '21');

-- ----------------------------
-- Procedure structure for getStuById
-- ----------------------------
DROP PROCEDURE IF EXISTS `getStuById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getStuById`(IN stuId INT(11),OUT stuName VARCHAR(255),OUT stuAge INT(11))
    COMMENT 'query students by their id'
BEGIN
   SELECT name ,age INTO stuName , stuAge FROM t_student WHERE id = stuId; -- 分号要加
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for getStuNameById
-- ----------------------------
DROP FUNCTION IF EXISTS `getStuNameById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getStuNameById`(stuId INT) RETURNS varchar(255) CHARSET utf8
RETURN  (SELECT name FROM t_student WHERE id = stuId)
;;
DELIMITER ;
