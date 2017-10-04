# MySQL-Front 5.1  (Build 1.5)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: haier
# ------------------------------------------------------
# Server version 5.0.45-community-nt

#
# Source for table province
#

DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `Id` int(11) NOT NULL auto_increment,
  `provinceCode` varchar(255) default NULL,
  `provinceName` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Dumping data for table province
#
LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;

INSERT INTO `province` VALUES (1,'SD','山东');
INSERT INTO `province` VALUES (2,'BJ','北京');
INSERT INTO `province` VALUES (3,'TJ','天津');
INSERT INTO `province` VALUES (4,'SH','上海');
INSERT INTO `province` VALUES (5,'JS','江苏');
INSERT INTO `province` VALUES (6,'GD','广东');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
