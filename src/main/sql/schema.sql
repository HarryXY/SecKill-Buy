--Database initialize SQL Script

--create database
CREATE DATABASE secKill;
--use database
use secKill;
--create inventory table seckill
CREATE TABLE seckill(
seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT 'product id',
name varchar(120) NOT NULL COMMENT 'product name',
number int NOT NULL COMMENT 'inventory nmber',
start_time datetime NOT NULL COMMENT 'secKill start time',
end_time datetime NOT NULL COMMENT 'secKill end time',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'secKill create time',
PRIMARY KEY (seckill_id),
KEY idx_start_time(start_time),
KEY idx_end_time(end_time),
KEY idx_create_time(create_time)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=UTF8 COMMENT='seckill inventory table';

--insert initial data
insert into secKill(name,number,start_time,end_time) 
values
('$1000 secKill iphone7',100,'2016-11-11 00:00:00','2016-11-12 00:00:00'),
('$500 secKill ipad2',200,'2016-11-11 00:00:00','2016-11-12 00:00:00'),
('$300 secKill Note4',300,'2016-11-11 00:00:00','2016-11-12 00:00:00'),
('$1000 secKill HuaweiP7',400,'2016-11-11 00:00:00','2016-11-12 00:00:00');

--create secKill success table
--user identify
CREATE table success_killed(
secKill_id bigint NOT NULL COMMENT 'product id',
user_phone bigint NOT NULL COMMENT 'user phone',
state tinyint NOT NULL DEFAULT -1 COMMENT '-1:failed 0:succeed 1:paid',
create_time timestamp NOT NULL COMMENT 'create time',
PRIMARY KEY(secKill_id,user_phone),/*composite key */
KEY idx_create_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET=UTF8 COMMENT='secKill success table';

--connect database console desk
mysql -uroot -p




