/*
Navicat MySQL Data Transfer

Source Server         : 正式环境
Source Server Version : 50616
Source Host           : rm-bp138y5rq628s790h4o.mysql.rds.aliyuncs.com:3306
Source Database       : devfire

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2019-08-26 17:14:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_equip_info
-- ----------------------------
DROP TABLE IF EXISTS `t_equip_info`;
CREATE TABLE `t_equip_info` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `equip_code` varchar(32) DEFAULT NULL COMMENT '设备编号',
  `type` varchar(64) DEFAULT NULL COMMENT '设备类型（取字典表code）',
  `equip_model` varchar(64) DEFAULT NULL COMMENT '设备型号（取字典表code）',
  `date_type` varchar(64) DEFAULT NULL COMMENT '巡检周期（取字典表code）',
  `place_id` char(32) DEFAULT NULL COMMENT '场所id',
  `area_id` char(32) DEFAULT NULL COMMENT '区域id',
  `address` varchar(200) DEFAULT NULL COMMENT '设备地址',
  `contacts` varchar(64) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(15) DEFAULT NULL COMMENT '联系方式',
  `second_phone` varchar(15) DEFAULT NULL COMMENT '第二联系方式',
  `jd` float(10,6) DEFAULT NULL COMMENT '经度',
  `wd` float(10,6) DEFAULT NULL COMMENT '纬度',
  `install_origin` smallint(2) DEFAULT NULL COMMENT '安装日志来源(1:app安装  2:pc 安装，3：onenet同步，4：天翼云同步 ，5：移动oc平台同步，6：华为openlab平台同步)',
  `create_by` char(32) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` char(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `sensor_time` datetime DEFAULT NULL COMMENT '最新通讯时间',
  `patrol_time` datetime DEFAULT NULL COMMENT '最新巡检时间',
  `state` varchar(64) DEFAULT '0' COMMENT '设备状态（0-离线，1-在线，2-自检，3-异常，4-故障，5-报警）取code',
  `del_flag` smallint(2) DEFAULT '0' COMMENT '删除标记,0-正常，1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备信息表';

-- ----------------------------
-- Table structure for t_manager_area
-- ----------------------------
DROP TABLE IF EXISTS `t_manager_area`;
CREATE TABLE `t_manager_area` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` varchar(64) NOT NULL COMMENT '父级id',
  `parent_ids` varchar(255) NOT NULL COMMENT '所有父级id',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `manager` varchar(255) DEFAULT NULL COMMENT '管理员',
  `sort` int(10) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` int(2) DEFAULT NULL COMMENT '区域类型',
  `create_user` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记  0.未删除  1.已删除',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `id_index` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=472 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for t_manager_place
-- ----------------------------
DROP TABLE IF EXISTS `t_manager_place`;
CREATE TABLE `t_manager_place` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(64) NOT NULL COMMENT '场所编号',
  `name` varchar(32) DEFAULT NULL COMMENT '场所名称',
  `address` varchar(125) DEFAULT NULL COMMENT '场所地址',
  `type` varchar(32) DEFAULT NULL COMMENT '场所性质',
  `manager` varchar(64) DEFAULT NULL COMMENT '负责人',
  `manager_telephone` varchar(64) DEFAULT NULL COMMENT '负责人电话',
  `unit_id` varchar(32) DEFAULT NULL COMMENT '单位id',
  `area_size` varchar(32) DEFAULT NULL COMMENT '面积大小',
  `fire_telephone` varchar(32) DEFAULT NULL COMMENT '消防室tel',
  `is_main` varchar(32) DEFAULT NULL COMMENT '是否独立主机  0.是   1.否',
  `lon` varchar(64) DEFAULT NULL COMMENT '经度',
  `lat` varchar(64) DEFAULT NULL COMMENT '纬度',
  `province` varchar(32) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `city_code` varchar(32) DEFAULT NULL,
  `district` varchar(32) DEFAULT NULL,
  `adcode` varchar(32) DEFAULT NULL,
  `formatted_address` varchar(128) DEFAULT NULL,
  `create_user` varchar(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_user` varchar(64) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL COMMENT '描述信息',
  `del_flag` int(32) DEFAULT '0' COMMENT '是否删除  0.未删除  1.删除',
  `area_id` varchar(64) NOT NULL,
  `admin_area_id` varchar(32) NOT NULL,
  `freeze_status` int(2) DEFAULT '0' COMMENT '冻结状态  0：未冻结，1：已冻结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for t_manager_unit
-- ----------------------------
DROP TABLE IF EXISTS `t_manager_unit`;
CREATE TABLE `t_manager_unit` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(32) DEFAULT NULL COMMENT '单位编码',
  `name` varchar(32) DEFAULT NULL COMMENT '单位名称',
  `address` varchar(255) DEFAULT NULL COMMENT '单位地址',
  `area_id` varchar(32) DEFAULT NULL,
  `manager` varchar(32) DEFAULT NULL COMMENT '负责人',
  `manager_telephone` varchar(32) DEFAULT NULL COMMENT '负责人电话',
  `credit_code` varchar(32) DEFAULT NULL COMMENT '统一信用代码',
  `unit_credent_url` varchar(255) NOT NULL COMMENT '单位证书url',
  `logo_url` varchar(255) NOT NULL COMMENT 'logo地址url',
  `freeze_status` int(2) DEFAULT '0' COMMENT '冻结状态  0.未冻结  1.冻结',
  `create_time` datetime DEFAULT NULL,
  `create_user` varchar(32) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` varchar(32) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `del_flag` int(2) DEFAULT '0' COMMENT '是否删除  0.未删除  1.删除',
  `lon` varchar(32) DEFAULT NULL COMMENT '经度',
  `lat` varchar(32) DEFAULT NULL COMMENT '纬度',
  `province` varchar(32) DEFAULT NULL,
  `city` varchar(32) DEFAULT NULL,
  `city_code` varchar(32) DEFAULT NULL COMMENT '城市编码',
  `district` varchar(32) DEFAULT NULL,
  `adcode` varchar(32) DEFAULT NULL COMMENT '区划分编码',
  `formatted_address` varchar(255) DEFAULT NULL,
  `admin_area_id` varchar(32) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for t_sys_account
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_account`;
CREATE TABLE `t_sys_account` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '密码',
  `real_name` varchar(32) NOT NULL COMMENT '姓名',
  `sex` int(1) DEFAULT NULL COMMENT '性别',
  `tel` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '电子邮箱',
  `pro_id` varchar(32) DEFAULT NULL COMMENT '项目id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `status` int(1) DEFAULT '0' COMMENT '状态( 0-启用 1-禁用)',
  `lastlogin_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `isbind` int(1) DEFAULT '0' COMMENT '是否绑定到项目，0-未绑定，1-已绑定，项目管理员',
  `self_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `del_flag` int(1) DEFAULT '0' COMMENT '是否删除标识，0-正常，1-删除',
  PRIMARY KEY (`id`),
  KEY `index_account` (`account`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Table structure for t_sys_area
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_area`;
CREATE TABLE `t_sys_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '地区名称',
  `path_ids` varchar(200) DEFAULT NULL,
  `short_name` varchar(40) DEFAULT NULL COMMENT '简写名称',
  `level` int(11) NOT NULL COMMENT '城市级别 1.省 2.市 3.区 4.街道、镇',
  `longitude` double(10,6) DEFAULT NULL COMMENT '经度',
  `latitude` double(10,6) DEFAULT NULL COMMENT '纬度',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `pk_key` (`id`,`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=659004509 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='地区,该表为临时表，只做数据清洗中间表使用，组织机构完善会删除该表，业务逻辑不要使用该表';

-- ----------------------------
-- Table structure for t_sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_authority`;
CREATE TABLE `t_sys_authority` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `auth_name` varchar(64) NOT NULL COMMENT '权限名称',
  `auth_sign` varchar(64) NOT NULL COMMENT '权限标识',
  `auth_url` varchar(200) DEFAULT NULL COMMENT '访问路径',
  `auth_filePath` varchar(64) DEFAULT NULL COMMENT '实际文件路径',
  `parent_id` varchar(32) NOT NULL COMMENT '上级ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `auth_type` varchar(10) DEFAULT NULL COMMENT '权限类型（0:无子级菜单;1:菜单;2:操作;3-按钮）',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `sort_no` int(5) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Table structure for t_sys_dic
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dic`;
CREATE TABLE `t_sys_dic` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `category_id` varchar(32) DEFAULT NULL COMMENT '类别id',
  `dic_key` varchar(150) NOT NULL COMMENT '字典key',
  `dic_value` varchar(150) DEFAULT NULL COMMENT '字典value',
  `is_enable` int(1) NOT NULL COMMENT '是否启用 1-启用 0-关闭',
  `sort_no` int(10) NOT NULL COMMENT '排序',
  `remark` varchar(300) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典表';

-- ----------------------------
-- Table structure for t_sys_dic_category
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dic_category`;
CREATE TABLE `t_sys_dic_category` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `dic_key` varchar(64) NOT NULL COMMENT '字典key',
  `dic_value` varchar(64) NOT NULL COMMENT '字典value',
  `is_enable` int(1) NOT NULL COMMENT '是否启用 1-启用 0-关闭',
  `sort_no` int(10) NOT NULL COMMENT '排序',
  `remark` varchar(300) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字典类别表';

-- ----------------------------
-- Table structure for t_sys_params
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_params`;
CREATE TABLE `t_sys_params` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `params_name` varchar(32) NOT NULL COMMENT '参数名称',
  `params_key` varchar(64) NOT NULL COMMENT '参数key',
  `params_value` varchar(200) NOT NULL COMMENT '参数值',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

-- ----------------------------
-- Table structure for t_sys_project
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_project`;
CREATE TABLE `t_sys_project` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `parent_id` varchar(32) DEFAULT '0' COMMENT '上级ID',
  `cascade_id` varchar(500) DEFAULT NULL COMMENT '串联id',
  `pro_code` varchar(128) DEFAULT NULL COMMENT '项目编码',
  `pro_name` varchar(128) NOT NULL COMMENT '项目名称',
  `contacts` varchar(32) DEFAULT NULL COMMENT '联系人',
  `is_leaf` int(1) DEFAULT '0' COMMENT '是否叶子节点（0-不是叶子节点，1-叶子节点）',
  `orders` varchar(32) DEFAULT NULL COMMENT '排序字段',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `is_enable` int(1) DEFAULT '0' COMMENT '是否启用（0-启用，1-禁用）',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `account_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_index` (`id`) USING BTREE,
  KEY `parent_index` (`parent_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统项目表';

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `role_name` varchar(32) NOT NULL COMMENT '角色名称',
  `role_sign` varchar(32) DEFAULT NULL COMMENT '角色标识',
  `org_id` varchar(32) DEFAULT NULL COMMENT '所属机构id',
  `status` int(1) DEFAULT '0' COMMENT '状态(-1-删除 0-启用， 1-禁用)',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `account_id` varchar(32) DEFAULT NULL COMMENT '创建人',
  `is_login` int(1) DEFAULT '0' COMMENT '该角色是否可以登录，0-可以，1-拒绝登录，默认为0',
  `del_flag` int(1) DEFAULT '0' COMMENT '0-正常，1-删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for t_sys_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_authority`;
CREATE TABLE `t_sys_role_authority` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `auth_id` varchar(32) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色权限关系表';
