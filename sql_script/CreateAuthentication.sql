USE `Business_Management_Database`;

SET FOREIGN_KEY_CHECKS = 0;
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

SET FOREIGN_KEY_CHECKS = 1;
