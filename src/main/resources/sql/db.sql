-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id`           BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name`         VARCHAR(30) DEFAULT NULL COMMENT '姓名',
  `age`          INT(11) DEFAULT NULL COMMENT '年龄',
  `email`        VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
  `manager_id`   BIGINT(20) DEFAULT NULL COMMENT '直属上级id',
  `is_deleted`   TINYINT(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  `create_time`  DATEtime NOT NULL COMMENT '创建时间',
  `update_time`  DATEtime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `manager_index` (`manager_id`),
  CONSTRAINT `t_user_fk_manager` FOREIGN KEY (`manager_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
