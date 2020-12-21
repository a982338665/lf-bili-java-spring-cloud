create database seata_order;
create database seata_storage;
create database seata_account;

use seata_order;
create table t_order
(
    `id`         bigint(11) not null auto_increment primary key,
    `user_id`    bigint(11)     default null comment '用户id',
    `product_id` bigint(11)     default null comment '产品id',
    `count`      int(11)        default null comment '数量',
    `money`      decimal(11, 0) default null comment '金额',
    `status`     int(11)        default null comment '订单状态 0-创建中 1-已完结'
) engine = innodb
  auto_increment = 7
  default charset = utf8;
CREATE TABLE `undo_log` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `branch_id` bigint(20) NOT NULL,
                            `xid` varchar(100) NOT NULL,
                            `context` varchar(128) NOT NULL,
                            `rollback_info` longblob NOT NULL,
                            `log_status` int(11) NOT NULL,
                            `log_created` datetime NOT NULL,
                            `log_modified` datetime NOT NULL,
                            `ext` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

use seata_storage;
create table t_storage (
                           `id` bigint(11) not null auto_increment primary key,
                           `product_id` bigint(11) default null comment '产品id',
                           `total` int(11) default null comment '总库存',
                           `used` int(11) default null comment '已用库存',
                           `residue` int(11) default null comment '剩余库存'
) engine=innodb auto_increment=2 default charset=utf8;
insert into seata_storage.t_storage(`id`,`product_id`,`total`,`used`,`residue`) values ('1','1','100','0','100');
CREATE TABLE `undo_log` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `branch_id` bigint(20) NOT NULL,
                            `xid` varchar(100) NOT NULL,
                            `context` varchar(128) NOT NULL,
                            `rollback_info` longblob NOT NULL,
                            `log_status` int(11) NOT NULL,
                            `log_created` datetime NOT NULL,
                            `log_modified` datetime NOT NULL,
                            `ext` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

use seata_account;
create table t_account (
                           `id` bigint(11) not null auto_increment primary key,
                           `user_id` bigint(11) default null comment '用户id',
                           `total` int(11) default null comment '总余额',
                           `used` int(11) default null comment '已用余额',
                           `residue` int(11) default null comment '剩余余额'
) engine=innodb auto_increment=2 default charset=utf8;
insert into seata_account.t_account(`id`,`user_id`,`total`,`used`,`residue`) values ('1','1','1000','0','1000');
CREATE TABLE `undo_log` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `branch_id` bigint(20) NOT NULL,
                            `xid` varchar(100) NOT NULL,
                            `context` varchar(128) NOT NULL,
                            `rollback_info` longblob NOT NULL,
                            `log_status` int(11) NOT NULL,
                            `log_created` datetime NOT NULL,
                            `log_modified` datetime NOT NULL,
                            `ext` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
