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
# Source for table city
#

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `Id` int(11) NOT NULL auto_increment,
  `cityCode` varchar(255) default NULL,
  `cityName` varchar(255) default NULL,
  `provinceCode` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

#
# Dumping data for table city
#
LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;

INSERT INTO `city` VALUES (1,'JN','济南','SD');
INSERT INTO `city` VALUES (2,'QD','青岛','SD');
INSERT INTO `city` VALUES (3,'WF','潍坊','SD');
INSERT INTO `city` VALUES (4,'ZB','淄博','SD');
INSERT INTO `city` VALUES (5,'TA','泰安','SD');
INSERT INTO `city` VALUES (6,'YT','烟台','SD');
INSERT INTO `city` VALUES (7,'LC','聊城','SD');
INSERT INTO `city` VALUES (8,'ZZ','枣庄','SD');
INSERT INTO `city` VALUES (9,'HZ','菏泽','SD');
INSERT INTO `city` VALUES (10,'LW','莱芜','SD');
INSERT INTO `city` VALUES (11,'LL','临沂','SD');
INSERT INTO `city` VALUES (12,'RZ','日照','SD');
INSERT INTO `city` VALUES (13,'WH','威海','SD');
INSERT INTO `city` VALUES (14,'NJ','南京','JS');
INSERT INTO `city` VALUES (15,'SZ','苏州','JS');
INSERT INTO `city` VALUES (16,'WX','无锡','JS');
INSERT INTO `city` VALUES (17,'XZ','徐州','JS');
INSERT INTO `city` VALUES (18,'NT','南通','JS');
INSERT INTO `city` VALUES (19,'LYG','连云港','JS');
INSERT INTO `city` VALUES (20,'ZJ','镇江','JS');
INSERT INTO `city` VALUES (21,'CZ','常州','JS');
INSERT INTO `city` VALUES (22,'HA','淮安','JS');
INSERT INTO `city` VALUES (23,'YZ','扬州','JS');
INSERT INTO `city` VALUES (24,'GZ','广州','GD');
INSERT INTO `city` VALUES (25,'SZ','深圳','GD');
INSERT INTO `city` VALUES (26,'ZH','珠海','GD');
INSERT INTO `city` VALUES (27,'ST','汕头','GD');
INSERT INTO `city` VALUES (28,'FS','佛山','GD');
INSERT INTO `city` VALUES (29,'DG','东莞','GD');
INSERT INTO `city` VALUES (30,'ZJ','湛江','GD');
INSERT INTO `city` VALUES (31,'JM','江门','GD');
INSERT INTO `city` VALUES (32,'ZS','中山','GD');
INSERT INTO `city` VALUES (33,'HZ','惠州','GD');
INSERT INTO `city` VALUES (34,'CY','朝阳','BJ');
INSERT INTO `city` VALUES (35,'HD','海淀','BJ');
INSERT INTO `city` VALUES (36,'TZ','通州','BJ');
INSERT INTO `city` VALUES (37,'FS','房山','BJ');
INSERT INTO `city` VALUES (38,'FT','丰台','BJ');
INSERT INTO `city` VALUES (39,'CP','昌平','BJ');
INSERT INTO `city` VALUES (40,'XC','西城','BJ');
INSERT INTO `city` VALUES (41,'SY','顺义','BJ');
INSERT INTO `city` VALUES (42,'XW','宣武','BJ');
INSERT INTO `city` VALUES (43,'CW','崇文','BJ');
INSERT INTO `city` VALUES (44,'HR','怀柔','BJ');
INSERT INTO `city` VALUES (45,'PD','浦东','SH');
INSERT INTO `city` VALUES (46,'QP','青浦','SH');
INSERT INTO `city` VALUES (47,'HP','黄埔','SH');
INSERT INTO `city` VALUES (48,'HK','虹口','SH');
INSERT INTO `city` VALUES (49,'SJ','松江','SH');
INSERT INTO `city` VALUES (50,'BS','宝山','SH');
INSERT INTO `city` VALUES (51,'JD','嘉定','SH');
INSERT INTO `city` VALUES (52,'NH','南汇','SH');
INSERT INTO `city` VALUES (53,'FX','奉贤','SH');
INSERT INTO `city` VALUES (54,'HP','和平','TJ');
INSERT INTO `city` VALUES (55,'BZ','北展','TJ');
INSERT INTO `city` VALUES (56,'HB','河北','TJ');
INSERT INTO `city` VALUES (57,'HX','河西','TJ');
INSERT INTO `city` VALUES (58,'XQ','西青','TJ');
INSERT INTO `city` VALUES (59,'JN','津南','TJ');
INSERT INTO `city` VALUES (60,'HQ','红桥','TJ');
INSERT INTO `city` VALUES (61,'DG','大港','TJ');
INSERT INTO `city` VALUES (62,'TG','塘沽','TJ');
INSERT INTO `city` VALUES (63,'HD','河东','TJ');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
