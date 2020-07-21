create TABLE payment
(
    id     BIGINT(20) not null Auto_increment COMMENT 'id',
    serial VARCHAR(200) DEFAULT '',
    PRIMARY KEY (id)
) engine = INNODB
  Auto_increment = 1
  DEFAULT CHARSET = utf8;


