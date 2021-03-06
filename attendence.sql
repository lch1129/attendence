/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - mydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mydb`;

/*Table structure for table `tb_course` */

DROP TABLE IF EXISTS `tb_course`;

CREATE TABLE `tb_course` (
  `course_id` int(4) NOT NULL AUTO_INCREMENT,
  `course_teacher` varchar(10) NOT NULL,
  `course_name` varchar(20) NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_course` */

insert  into `tb_course`(`course_id`,`course_teacher`,`course_name`) values (1,'袁斯昊','嵌入式驱动开发'),(2,'饶莉莉','嵌入式系统测试'),(3,'张海','JSP程序设计'),(4,'张广顺','物联网应用技术'),(5,'杨学风','大学生职业发展指导'),(6,'邓长寿','专业英语');

/*Table structure for table `tb_course_time` */

DROP TABLE IF EXISTS `tb_course_time`;

CREATE TABLE `tb_course_time` (
  `course_time_id` int(5) NOT NULL AUTO_INCREMENT,
  `course_id` int(5) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  PRIMARY KEY (`course_time_id`),
  KEY `FK_tb_course_time` (`course_id`),
  CONSTRAINT `FK_tb_course_time` FOREIGN KEY (`course_id`) REFERENCES `tb_course` (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

/*Data for the table `tb_course_time` */

insert  into `tb_course_time`(`course_time_id`,`course_id`,`start_time`,`end_time`) values (1,1,'2019-09-02 08:00:00','2019-09-02 09:35:00'),(2,2,'2019-09-02 10:15:00','2019-09-02 11:50:00'),(3,4,'2019-09-03 10:15:00','2019-09-03 11:50:00'),(4,4,'2019-09-03 15:55:00','2019-09-03 17:30:00'),(5,4,'2019-09-05 08:00:00','2019-09-05 09:35:00'),(6,3,'2019-09-05 10:15:00','2019-09-05 11:50:00'),(7,2,'2019-09-05 14:00:00','2019-09-05 15:35:00'),(8,6,'2019-09-06 10:15:00','2019-09-06 11:50:00'),(9,1,'2019-09-06 14:00:00','2019-09-06 15:35:00'),(10,1,'2019-09-09 08:00:00','2019-09-09 09:35:00'),(11,2,'2019-09-09 10:15:00','2019-09-09 11:50:00'),(12,3,'2019-09-09 15:55:00','2019-09-09 17:30:00'),(13,4,'2019-09-12 08:00:00','2019-09-12 09:35:00'),(14,3,'2019-09-12 10:15:00','2019-09-12 11:50:00'),(15,6,'2019-09-13 10:15:00','2019-09-13 11:50:00'),(16,1,'2019-09-13 14:00:00','2019-09-13 15:35:00'),(17,1,'2019-09-16 08:00:00','2019-09-16 09:35:00'),(18,2,'2019-09-16 10:15:00','2019-09-16 11:50:00'),(19,4,'2019-09-17 10:15:00','2019-09-17 11:50:00'),(20,4,'2019-09-17 15:55:00','2019-09-17 17:30:00'),(21,4,'2019-09-19 08:00:00','2019-09-19 09:35:00'),(22,3,'2019-09-19 10:15:00','2019-09-19 11:50:00'),(23,2,'2019-09-19 14:00:00','2019-09-19 15:35:00'),(24,6,'2019-09-20 10:15:00','2019-09-20 11:50:00'),(25,1,'2019-09-20 14:00:00','2019-09-20 15:35:00'),(26,1,'2019-09-23 08:00:00','2019-09-23 09:35:00'),(27,2,'2019-09-23 10:15:00','2019-09-23 11:50:00'),(28,3,'2019-09-23 15:55:00','2019-09-23 17:30:00'),(29,4,'2019-09-26 08:00:00','2019-09-26 09:35:00'),(30,3,'2019-09-26 10:15:00','2019-09-26 11:50:00'),(31,6,'2019-09-27 10:15:00','2019-09-27 11:50:00'),(32,1,'2019-09-27 14:00:00','2019-09-27 15:35:00'),(33,1,'2019-09-30 08:00:00','2019-09-30 09:35:00'),(34,2,'2019-09-30 10:15:00','2019-09-30 11:50:00'),(35,4,'2019-10-01 10:15:00','2019-10-01 11:50:00'),(36,4,'2019-10-01 15:55:00','2019-10-01 17:30:00'),(37,4,'2019-10-03 08:00:00','2019-10-03 09:35:00'),(38,3,'2019-10-03 10:15:00','2019-10-03 11:50:00'),(39,2,'2019-10-03 14:00:00','2019-10-03 15:35:00'),(40,6,'2019-10-04 10:15:00','2019-10-04 11:50:00'),(41,1,'2019-10-04 14:00:00','2019-10-04 15:35:00'),(42,1,'2019-10-07 08:00:00','2019-10-07 09:35:00'),(43,2,'2019-10-07 10:15:00','2019-10-07 11:50:00'),(44,3,'2019-10-07 15:55:00','2019-10-07 17:30:00'),(45,4,'2019-10-10 08:00:00','2019-10-10 09:35:00'),(46,3,'2019-10-10 10:15:00','2019-10-10 11:50:00'),(47,6,'2019-10-11 10:15:00','2019-10-11 11:50:00'),(48,1,'2019-10-11 14:00:00','2019-10-11 15:35:00'),(49,1,'2019-10-14 08:00:00','2019-10-14 09:35:00'),(50,2,'2019-10-14 10:15:00','2019-10-14 11:50:00'),(51,4,'2019-10-15 10:15:00','2019-10-15 11:50:00'),(52,4,'2019-10-15 15:55:00','2019-10-15 17:30:00'),(53,4,'2019-10-17 08:00:00','2019-10-17 09:35:00'),(54,3,'2019-10-17 10:15:00','2019-10-17 11:50:00'),(55,2,'2019-10-17 14:00:00','2019-10-17 15:35:00'),(56,6,'2019-10-18 10:15:00','2019-10-18 11:50:00'),(57,1,'2019-10-18 14:00:00','2019-10-18 15:35:00'),(58,1,'2019-10-21 08:00:00','2019-10-21 09:35:00'),(59,2,'2019-10-21 10:15:00','2019-10-21 11:50:00'),(60,3,'2019-10-21 15:55:00','2019-10-21 17:30:00'),(61,4,'2019-10-24 08:00:00','2019-10-24 09:35:00'),(62,3,'2019-10-24 10:15:00','2019-10-24 11:50:00'),(63,6,'2019-10-25 10:15:00','2019-10-25 11:50:00'),(64,1,'2019-10-25 14:00:00','2019-10-25 15:35:00'),(65,1,'2019-10-28 08:00:00','2019-10-28 09:35:00'),(66,2,'2019-10-28 10:15:00','2019-10-28 11:50:00'),(67,4,'2019-10-29 10:15:00','2019-10-29 11:50:00'),(68,4,'2019-10-29 15:55:00','2019-10-29 17:30:00'),(69,4,'2019-10-31 08:00:00','2019-10-31 09:35:00'),(70,2,'2019-10-31 14:00:00','2019-10-31 15:35:00'),(71,6,'2019-11-01 10:15:00','2019-11-01 11:50:00'),(72,1,'2019-11-01 14:00:00','2019-11-01 15:35:00'),(73,1,'2019-11-04 08:00:00','2019-11-04 09:35:00'),(74,2,'2019-11-04 10:15:00','2019-11-04 11:50:00'),(75,4,'2019-11-07 08:00:00','2019-11-07 09:35:00'),(76,5,'2019-11-08 08:00:00','2019-11-08 09:35:00'),(77,6,'2019-11-08 10:15:00','2019-11-08 11:50:00'),(78,1,'2019-11-08 14:00:00','2019-11-08 15:35:00'),(79,1,'2019-11-11 08:00:00','2019-11-11 09:35:00'),(80,2,'2019-11-11 10:15:00','2019-11-11 11:50:00'),(81,4,'2019-11-12 08:00:00','2019-11-12 09:35:00'),(82,4,'2019-11-12 15:55:00','2019-11-12 17:30:00'),(83,4,'2019-11-14 08:00:00','2019-11-14 09:35:00'),(84,2,'2019-11-14 14:00:00','2019-11-14 15:35:00'),(85,6,'2019-11-15 10:15:00','2019-11-15 11:50:00'),(86,1,'2019-11-15 14:00:00','2019-11-15 15:35:00'),(87,1,'2019-11-18 08:00:00','2019-11-18 09:35:00'),(88,2,'2019-11-18 10:15:00','2019-11-18 11:50:00'),(89,4,'2019-11-21 08:00:00','2019-11-21 09:35:00'),(90,5,'2019-11-22 08:00:00','2019-11-22 09:35:00'),(91,6,'2019-11-22 10:15:00','2019-11-22 11:50:00'),(92,1,'2019-11-22 14:00:00','2019-11-22 15:35:00');

/*Table structure for table `tb_record` */

DROP TABLE IF EXISTS `tb_record`;

CREATE TABLE `tb_record` (
  `record_id` int(4) NOT NULL AUTO_INCREMENT,
  `record_time` datetime NOT NULL,
  `course_time_id` int(4) NOT NULL,
  `late` tinyint(1) NOT NULL DEFAULT '0',
  `card_id` int(4) NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `FK_tb_record_stu` (`card_id`),
  KEY `FK_tb_record_course_time` (`course_time_id`),
  CONSTRAINT `FK_tb_record_course_time` FOREIGN KEY (`course_time_id`) REFERENCES `tb_course_time` (`course_time_id`),
  CONSTRAINT `FK_tb_record_stu` FOREIGN KEY (`card_id`) REFERENCES `tb_stu` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_record` */

insert  into `tb_record`(`record_id`,`record_time`,`course_time_id`,`late`,`card_id`) values (1,'2019-09-02 09:23:51',1,1,1);

/*Table structure for table `tb_stu` */

DROP TABLE IF EXISTS `tb_stu`;

CREATE TABLE `tb_stu` (
  `stu_id` int(5) NOT NULL AUTO_INCREMENT,
  `stu_card_id` int(5) NOT NULL,
  `stu_class` varchar(10) NOT NULL,
  `stu_name` varchar(10) NOT NULL,
  `stu_sex` varchar(5) NOT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_stu` */

insert  into `tb_stu`(`stu_id`,`stu_card_id`,`stu_class`,`stu_name`,`stu_sex`) values (1,1,'A1651','周杨','男'),(2,2,'A1651','顾飞龙','男'),(3,3,'A1651','刘成辉','男'),(4,4,'A1651','綦畅通','男'),(5,5,'A1651','吴舟扬','男'),(6,6,'A1651','邹海平','男');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
