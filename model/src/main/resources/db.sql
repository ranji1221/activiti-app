CREATE DATABASE IF NOT EXISTS `activitiapp` DEFAULT CHARACTER SET utf8;
USE `activitiapp`;

DROP TABLE IF EXISTS `tbl_sys_user`;
CREATE TABLE `tbl_sys_user`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`userName` varchar(100) DEFAULT NULL COMMENT '用户名',
	`pwd` varchar(200) DEFAULT NULL COMMENT '密码',
	`enabled`int(2) DEFAULT -1 COMMENT '用户是否可用，默认不可用',
	`description` varchar(200)  DEFAULT NULL COMMENT '用户描述',
	PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tbl_sys_role`;
CREATE TABLE `tbl_sys_role`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` varchar(255) DEFAULT NULL COMMENT '角色名称',
	`description` varchar(255) DEFAULT NULL COMMENT '描述信息',
	PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tbl_sys_userrole`;
CREATE TABLE `tbl_sys_userrole`(
	`userId` int(11) NOT NULL COMMENT '外键，用户表ID',
	`roleId` int(11) NOT NULL COMMENT '外键，角色表ID',
	PRIMARY KEY (`userId`,`roleId`),
	CONSTRAINT `FK_userrole_role` FOREIGN KEY (`roleId`) REFERENCES `tbl_sys_role` (`id`) ON DELETE CASCADE,
  	CONSTRAINT `FK_userrole_user` FOREIGN KEY (`userId`) REFERENCES `tbl_sys_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tbl_sys_resource`;
CREATE TABLE `tbl_sys_resource`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` varchar(200) COMMENT '资源对象的描述，如果资源描述的是一个portlet对象，则为这个portlet对象的portletId.如果是一个class, 则为带包名的class全名称,相当于类型',
	`displayName` varchar(200) COMMENT '用于做显示的名称',
	`sortNum` int(11),
	`action` varchar(200) COMMENT '动作名称',
	`bitwisevalue` int(11) COMMENT '动作的权值' ,
	PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tbl_sys_resourcepermission`;
CREATE TABLE `tbl_sys_resourcepermission`(
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`name` varchar(200) COMMENT '资源对象的描述，如果资源描述的是一个portlet对象，则为这个portlet对象的portletId.如果是一个class, 则为带包名的class全名称,相当于类型',
	`roleId` int(11) NOT NULL COMMENT '角色的id',
	`actions` int(11) DEFAULT 0 COMMENT '资源表中的bitwisevalue的值相加的结果',
	PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



