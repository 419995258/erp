/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.13-log : Database - erp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`erp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `erp`;

/*Table structure for table `attend` */

DROP TABLE IF EXISTS `attend`;

CREATE TABLE `attend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `nowdate` datetime DEFAULT NULL COMMENT '当前月份',
  `attendday` varchar(255) DEFAULT NULL COMMENT '出勤天数',
  `passday` varchar(255) DEFAULT NULL COMMENT '事假天数',
  `restday` varchar(255) DEFAULT NULL COMMENT '休息天数',
  `sickday` varchar(255) DEFAULT NULL COMMENT '病假天数',
  `leaveday` varchar(255) DEFAULT NULL COMMENT '旷工天数',
  `allday` varchar(255) DEFAULT NULL COMMENT '月总天数',
  `lateday` varchar(255) DEFAULT NULL COMMENT '迟到',
  `inday` varchar(255) DEFAULT NULL COMMENT '早退',
  `overday` varchar(255) DEFAULT NULL COMMENT '加班',
  `leader` varchar(255) DEFAULT NULL COMMENT '考勤员',
  `surer` varchar(255) DEFAULT NULL COMMENT '负责人',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_id` int(11) DEFAULT NULL COMMENT '店铺id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '店铺名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `attend` */

insert  into `attend`(`id`,`name`,`nowdate`,`attendday`,`passday`,`restday`,`sickday`,`leaveday`,`allday`,`lateday`,`inday`,`overday`,`leader`,`surer`,`note`,`user_id`,`user_name`) values (1,'165','2016-10-01 00:00:00','16','51','651','65','165','16','51','65','165','16','5','16',1,'pb'),(2,'1','2016-11-01 00:00:00','1','651','65','165','165','1','651','65','165','165','1','65',1,'pb'),(3,NULL,'2017-04-01 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1,'pb'),(4,NULL,'2017-04-01 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',1,'pb'),(5,'1','2017-04-01 00:00:00','1','1','1','1','1','1','1','1','1','1','12','',1,'pb'),(6,'a 啊','2017-04-01 00:00:00','1','1','1','1','1','1','1','1','1','奥奥','爱爱爱','',1,'pb');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `tel` varchar(255) COLLATE utf8_bin NOT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `saleAmount` double(11,0) NOT NULL,
  `record` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `note` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `firService` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `secService` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `thrService` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `fouService` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `serviceLeader` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `customer` */

insert  into `customer`(`id`,`name`,`tel`,`birthday`,`address`,`email`,`saleAmount`,`record`,`note`,`firService`,`secService`,`thrService`,`fouService`,`serviceLeader`,`user_id`,`user_name`) values (1,'二毛','1651321321','2016-07-06','溧阳','194156165',123,'1321','3211212','1','1','2','3','3',3,NULL),(1561,'65','165','2016-10-26','651','65',16,'1','651',NULL,NULL,NULL,NULL,NULL,1,'pb'),(123456,'132','132','2016-07-05','321','321',321,'321','321',NULL,NULL,NULL,NULL,NULL,3,NULL);

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `id` int(11) NOT NULL,
  `deptName` varchar(255) COLLATE utf8_bin NOT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `dept` */

insert  into `dept`(`id`,`deptName`,`address`) values (1,'系统管理员','天津总部');

/*Table structure for table `export` */

DROP TABLE IF EXISTS `export`;

CREATE TABLE `export` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `barCode` varchar(255) COLLATE utf8_bin NOT NULL,
  `receiveDept` varchar(255) COLLATE utf8_bin NOT NULL,
  `receiver` varchar(255) COLLATE utf8_bin NOT NULL,
  `receiveTime` date NOT NULL,
  `quantity` int(200) NOT NULL,
  `retaPrice` double NOT NULL,
  `note` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `export` */

insert  into `export`(`id`,`barCode`,`receiveDept`,`receiver`,`receiveTime`,`quantity`,`retaPrice`,`note`,`pid`) values (18,'2','2','22','2016-11-15',2,22,'22',2),(19,'1','1','1','2016-11-16',1,1,'1',1),(20,'1','1','1','2016-11-16',1,1,'1',1),(21,'1','1','1','2016-11-16',1,1,'1',1),(23,'666','6666666666','6666666','2016-11-15',6,66,'6',666666),(24,'1','1','1','2017-04-27',1,1,'1',1),(25,'#','1','1','2017-04-18',1,1,'',1),(26,'1','561','651','2017-04-17',651,65,'16',1),(27,'651','651','651','2017-04-29',165,165,'1',1),(28,'651','651','651','2017-05-18',65,165,'1',1);

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL COMMENT '商品id',
  `superPlatPeople` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '监盘人',
  `inventoryPeople` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '盘点人',
  `inventoryTime` date DEFAULT NULL COMMENT '盘点时间',
  `inventoryStock` int(11) DEFAULT NULL COMMENT '盘点库存',
  `note` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `inventory` */

insert  into `inventory`(`id`,`pid`,`superPlatPeople`,`inventoryPeople`,`inventoryTime`,`inventoryStock`,`note`) values (1,11,'1','23','2016-10-27',132,'1'),(2,666666,'165','165','2016-11-22',516,'51');

/*Table structure for table `orderform` */

DROP TABLE IF EXISTS `orderform`;

CREATE TABLE `orderform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` varchar(255) COLLATE utf8_bin NOT NULL,
  `orderDate` date NOT NULL,
  `payDate` date NOT NULL,
  `billingTime` date NOT NULL,
  `quantity` int(11) NOT NULL,
  `closePrice` double NOT NULL,
  `pid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pid` (`pid`),
  KEY `cid` (`cid`),
  CONSTRAINT `orderform_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`id`),
  CONSTRAINT `orderform_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `orderform` */

insert  into `orderform`(`id`,`orderID`,`orderDate`,`payDate`,`billingTime`,`quantity`,`closePrice`,`pid`,`cid`) values (1,'1231321','2016-07-01','2016-07-07','2016-07-07',1,23,1,1);

/*Table structure for table `permission` */

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `links` varchar(255) COLLATE utf8_bin NOT NULL,
  `ptid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ptid` (`ptid`),
  CONSTRAINT `permission_ibfk_1` FOREIGN KEY (`ptid`) REFERENCES `ptype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `permission` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(20) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `supplier` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `leader` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `certificateNum` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `component` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `size` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `subStone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mainStone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `goldCost` double DEFAULT NULL,
  `handCost` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `photoLink` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `note` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `photoName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `product` */

insert  into `product`(`id`,`pid`,`name`,`supplier`,`leader`,`tel`,`certificateNum`,`component`,`size`,`weight`,`subStone`,`mainStone`,`goldCost`,`handCost`,`quantity`,`cost`,`photoLink`,`note`,`photoName`) values (1,1,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct,红宝0.03ct','0.5',6666.66,66666.66,-885,666666.99,'123','Princess Marie系列，样品主石、配石为锆石，','123'),(2,2,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA526526500','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,-23,666667,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，\r\n','178348904656139.JPG'),(3,3,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,1,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，','178348904656139.JPG'),(4,4,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,1,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，','178348904656139.JPG'),(5,5,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,11,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\182906392920029.png','1Princess Marie系列，样品主石、配石为锆石，','182906392920029.png'),(6,6,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,11,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\183067224875224.png','Princess Marie系列，样品主石、配石为锆石，','183067224875224.png'),(7,7,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,1,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，','178348904656139.JPG'),(8,8,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,1,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，','178348904656139.JPG'),(9,9,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,1,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，','178348904656139.JPG'),(10,10,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,1,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，','178348904656139.JPG'),(11,11,'对戒男','深圳瑞玺珠宝','WR0001M','20160601','GIA5265265000','18k红白分色','16.5#',10.99,'钻石0.05ct红宝0.03ct','0.5',6666.66,66666.66,300,666666.99,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','Princess Marie系列，样品主石、配石为锆石，','178348904656139.JPG'),(12,12,'速度','是','是啊','123','123','123','123',123,'123','123',123,123,123,123,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\18980016658332.png','123','18980016658332.png'),(13,13,'132','1','321','321','32','132','1',321,'32','132',1,321,3,21,'../upload/photo/19304140863001.png','31','19304140863001.png'),(14,14,'1','1','1','1','1','1','1',1,'1','1',1,1,1,1,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\19722006562995.png','1','19722006562995.png'),(15,15,'1','1','1','1','1','1','1',1,'1','1',1,1,256,1,'H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\19944425046945.png','1','19944425046945.png'),(16,16,'1','1','1','1','1','1','1',1,'1','1',1,1,1,1,'../upload/photo/20034764066347.png','1','20034764066347.png'),(17,17,'1','1','1','1','1','1','1',1,'1','1',1,1,1,1,'../upload/photo/20245342492624.png','1','20245342492624.png'),(18,18,'1','1','1','1','11','1','1',1,'1','1',1,1,1,1,'../upload/photo/20281311902398.png','1','20281311902398.png'),(19,19,'2','2','2','2','2','2','2',2,'2','2',2,2,2,2,'../erp_v2.0/upload/photo/20458410259473.png','2','20458410259473.png'),(20,55,'561',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(21,21,'156','165','16','51','651','651','61',1,'651','61',651,6,516,16,'../erp_v2.0/upload/photo/2365684912261.png','16','2365684912261.png'),(22,22,'156','165','165','16','51','651','651',651,'65','165',1,61,651,6,'../erp_v2.0/upload/photo/2621028297463.png','16','2621028297463.png'),(23,1,'1','1','1','1','1','11','1',1,'1','1',1,11,1,1,'../upload/photo/317457943177.png','1','317457943177.png'),(24,666666,'6666666666','666666','6','6','6','6','6',6,'66','6',6,6,6,6,'../upload/photo/2357172096284.png','6','2357172096284.png'),(25,65,'16','51','651','65','165','1','61',65,'165','1',65,165,1,61,'../upload/photo/8313039980687.png','65','8313039980687.png'),(26,11,'1','1','1','1','1','11','1',1,'11','1',11,1,1,11,'../erp_v2.0/upload/photo/47743282648143.png','1','47743282648143.png'),(27,1,'1','1','11','1','1','11','1',1,'11','1',1,11,1,11,'../erp_v2.0/upload/photo/47758156375345.png','1','47758156375345.png'),(28,1,'1','1','11','1','1','1','1',11,'1','1',1,1,1,1,'../erp_v2.0/upload/photo/47858618433401.png','1','47858618433401.png');

/*Table structure for table `ptype` */

DROP TABLE IF EXISTS `ptype`;

CREATE TABLE `ptype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `ptype` */

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(20) DEFAULT NULL,
  `diyNum` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `diyDate` date DEFAULT NULL,
  `deliverDate` date DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `retaPrice` double(11,0) DEFAULT NULL,
  `deposit` double(11,0) DEFAULT NULL,
  `billing` double(11,0) DEFAULT NULL,
  `cashier` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `diyConsultant` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `customerArchive` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `note` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `customerArchiveName` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sale` */

insert  into `sale`(`id`,`sid`,`diyNum`,`diyDate`,`deliverDate`,`quantity`,`retaPrice`,`deposit`,`billing`,`cashier`,`diyConsultant`,`customerArchive`,`note`,`pid`,`cid`,`customerArchiveName`,`user_id`,`user_name`) values (1,1,'00007777','2016-07-06','2016-07-06',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',2,''),(2,2,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',3,'撒旦撒'),(3,3,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',4,''),(4,4,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',2,''),(5,5,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',3,'撒旦撒'),(6,6,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',4,''),(7,7,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',2,''),(8,8,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',3,'撒旦撒'),(9,9,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',4,''),(10,10,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',1,1,'178348904656139.JPG',2,''),(11,11,'00008888','2016-06-01','2016-07-01',10,600001,300000,600001,'欧阳纳兰','西门吹雪','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\photo\\178348904656139.JPG','加急。客人自带钻石GIA:1234567890，6月23号顾客确认款式',12,1,'178348904656139.JPG',3,'撒旦撒'),(16,16,'1','2016-07-13','2016-07-08',1,1,1,11,'1','1','H:\\apache-tomcat-7.0.59-windows-x86\\apache-tomcat-7.0.59\\webapps\\erp_v2.0\\upload\\doc\\2342847154128.png','1',1,1,'2342847154128.png',1,''),(17,17,'1','2016-09-12','2016-09-15',1,1,1,1,'1','1','../erp_v2.0/upload/photo/30637289814999.txt','1',1,1,'30637289814999.txt',1,'pb'),(19,19,'6','2016-11-17','2016-11-24',6,6,6,6,'6','6','../upload/photo/6020002236658.png','6',666666,666666,'6020002236658.png',1,'pb'),(20,20,'1561','2016-11-15','2016-11-15',165,16,51,65,'165','12','../upload/photo/8190742225886.png','22',666666,666666,'8190742225886.png',1,'pb'),(21,21,NULL,'2016-11-15','2016-11-15',1,0,0,0,NULL,NULL,'../upload/doc/8339151300037.png','65',666666,666666,'8339151300037.png',1,'pb'),(22,22,'1','2017-03-30','2017-04-06',1,1,1,1,'1','1','../erp_v2.0/upload/photo/88405104670630.png','1',1,1,'88405104670630.png',1,'pb'),(23,23,'1','2017-04-14','2017-05-01',165,165,1,651,'651','6','../erp_v2.0/upload/photo/93265739978339.png','1',165,165,'93265739978339.png',1,'pb');

/*Table structure for table `traffic` */

DROP TABLE IF EXISTS `traffic`;

CREATE TABLE `traffic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `innum` varchar(255) DEFAULT NULL COMMENT '进店人数',
  `intime` datetime DEFAULT NULL COMMENT '进入时间',
  `outtime` datetime DEFAULT NULL COMMENT '离开时间',
  `type` varchar(255) DEFAULT NULL COMMENT '需求类型',
  `age` varchar(255) DEFAULT NULL COMMENT '年龄',
  `pid` int(11) DEFAULT NULL COMMENT '商品款号',
  `reason` varchar(255) DEFAULT NULL COMMENT '成交/失败原因',
  `diyConsultant` varchar(255) DEFAULT NULL COMMENT '定制顾问',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `user_id` int(11) DEFAULT NULL COMMENT '添加账户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '添加账户昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `traffic` */

insert  into `traffic`(`id`,`innum`,`intime`,`outtime`,`type`,`age`,`pid`,`reason`,`diyConsultant`,`note`,`user_id`,`user_name`) values (1,'156',NULL,NULL,'1','321',321,'32','132','1',1,'pb'),(2,'165','2016-10-19 00:00:00','2016-10-26 00:00:00','16','16',1,'616','16','51',1,'pb');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `pwd` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `deptID` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `deptID` (`deptID`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`deptID`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`pwd`,`mobile`,`deptID`,`status`,`type`,`name`) values (1,'admin','E10ADC3949BA59ABBE56E057F20F883E','13510101010',1,1,1,'pb'),(2,'dianzhang','E10ADC3949BA59ABBE56E057F20F883E','15211110000',1,1,2,'1'),(3,'kefu','E10ADC3949BA59ABBE56E057F20F883E','11111111111',1,1,3,'2'),(4,'jinli','E10ADC3949BA59ABBE56E057F20F883E','1111111111',1,0,3,'4'),(5,'test','E10ADC3949BA59ABBE56E057F20F883E','0',1,1,3,'1'),(6,'root','E10ADC3949BA59ABBE56E057F20F883E','0',1,1,1,'root');

/*Table structure for table `userpermission` */

DROP TABLE IF EXISTS `userpermission`;

CREATE TABLE `userpermission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `pid` (`pid`),
  CONSTRAINT `userpermission_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`),
  CONSTRAINT `userpermission_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `userpermission` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
