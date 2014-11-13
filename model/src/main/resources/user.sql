CREATE DATABASE IF NOT EXISTS `activitiapp` DEFAULT CHARACTER SET utf8;
USE `activitiapp`;

DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`userName` varchar(100) DEFAULT NULL COMMENT '用户名',
	`pwd` varchar(200) DEFAULT NULL COMMENT '密码',
	`enabled`int(2) DEFAULT -1 COMMENT '用户是否可用，默认不可用',
	`description` varchar(200)  DEFAULT NULL COMMENT '用户描述',
	PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;