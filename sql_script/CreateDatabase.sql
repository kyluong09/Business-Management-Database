DROP DATABASE IF EXISTS `Business_Management_Database`;

CREATE DATABASE IF NOT EXISTS `Business_Management_Database`;
USE `Business_Management_Database`;

DROP TABLE IF EXISTS `customer`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE  `customer`(

`id` int(40) NOT NULL AUTO_INCREMENT,
`first_name` varchar(45) DEFAULT NULL,
`last_name` varchar(45) DEFAULT NULL,
`phone_number` varchar(45) DEFAULT NULL,
`address_id` int(40) DEFAULT NULL,



PRIMARY KEY(`id`),
CONSTRAINT `FK_ADDRESS` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)

)Engine=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address`(
`id` int(40) NOT NULL AUTO_INCREMENT,
`address` varchar(80) DEFAULT NULL,
`ward` varchar(80) DEFAULT NULL,
`district` varchar(80) DEFAULT NULL,

PRIMARY KEY (`id`)

)Engine=Innodb DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `Product`;

CREATE TABLE `product`(
`id` int(40) NOT NULL AUTO_INCREMENT,
`product_name` varchar(45) DEFAULT NULL,
`brand_name` varchar(45) DEFAULT NULL,
`price` double(45,2) DEFAULT NULL,

PRIMARY KEY(`id`)

)Engine=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `customer_order`;
CREATE TABLE `order`(
`id` int(40) NOT NULL AUTO_INCREMENT,
`customer_id` int(40) DEFAULT NULL,

PRIMARY KEY(`id`),
KEY `FK_CUSTOMER_ID_IDX` (`customer_id`),
CONSTRAINT `FK_CUSTOMER_ID` FOREIGN KEY(`customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

)Engine=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;


DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`(
`id` int(40) NOT NULL AUTO_INCREMENT,
`order_id` int(40) NOT NULL,
`product_id` int(40) NOT NULL,

PRIMARY KEY(`id`),

CONSTRAINT `FK_ORDER_ID` FOREIGN KEY(`order_id`) REFERENCES `order` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT `FK_PRODUCT_ID` FOREIGN KEY(`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

)Engine=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(50) NOT NULL,
`password` varchar(68) NOT NULL,
`first_name` varchar(50) NOT NULL,
`last_name` varchar(50) NOT NULL,
`enabled` TinyInt(11) NOT NULL,
PRIMARY KEY(`id`),
UNIQUE KEY (`username`)
)Engine=InnoDB DEFAULT CharSet=latin1;

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`name` varchar(50) DEFAULT NULL,

PRIMARY KEY (`id`)

)Engine=InnoDB DEFAULT CharSet=latin1;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`(
`user_id` int(11) NOT NULL,
`role_id` int(11) NOT NULL,

PRIMARY KEY(`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)  ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)  ON DELETE NO ACTION ON UPDATE NO ACTION


)Engine=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user`(id,username,password,first_name,last_name,enabled) VALUES
('1','admin','$2a$04$OFW4/0H9lY2E7UgHNS7mhObaOOnfK4ElXcGLz1O02lqSFLzAJMYWe','admin','db',1);
INSERT INTO `role` (id,name) VALUES
('1','USER'),
('2','ADMIN');
INSERT INTO `user_role` (user_id,role_id) VALUES
('1','1'),
('1','2');




SET FOREIGN_KEY_CHECKS = 1;
