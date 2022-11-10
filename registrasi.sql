/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.4.14-MariaDB : Database - registrasi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`registrasi` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `registrasi`;

/*Table structure for table `les` */

DROP TABLE IF EXISTS `les`;

CREATE TABLE `les` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `born_date` datetime DEFAULT NULL,
  `kelas_id` int(11) DEFAULT NULL,
  `jurusan_id` int(11) DEFAULT NULL,
  `jenis_pertemuan_id` int(11) DEFAULT NULL,
  `jadwal_id` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `les` */

insert  into `les`(`id`,`name`,`address`,`born_date`,`kelas_id`,`jurusan_id`,`jenis_pertemuan_id`,`jadwal_id`,`status`,`created_time`,`created_by`,`updated_time`,`updated_by`) values (1,'dwiki','bogor',NULL,0,0,0,0,'canceled','2022-11-10 17:05:18','dwiki',NULL,NULL),(2,'dwiki','bogor',NULL,1,4,6,8,'unpaid','2022-11-10 17:10:02','dwiki',NULL,NULL),(3,'dwiki','bogor',NULL,1,4,6,9,'unpaid','2022-11-10 17:50:54','anonymousUser',NULL,NULL),(4,'dwiki 2','bogor','2022-11-10 00:00:00',3,5,7,8,'paid','2022-11-10 18:01:49','dwiki','2022-11-10 20:24:33','dwiki');

/*Table structure for table `master` */

DROP TABLE IF EXISTS `master`;

CREATE TABLE `master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

/*Data for the table `master` */

insert  into `master`(`id`,`value`,`type`) values (1,'7','kelas'),(2,'8','kelas'),(3,'9','kelas'),(4,'IPA','jurusan'),(5,'IPS','jurusan'),(6,'Online','jenis_pertemuan'),(7,'Offline','jenis_pertemuan'),(8,'Siang','jadwal'),(9,'Sore','jadwal'),(10,'Malam','jadwal');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`) values (1,'dwiki','E91F39DD30EE8D28C0BF895810DB1AD3',NULL),(3,'aaa','202CB962AC59075B964B07152D234B70','a@a.a'),(4,'aaa','74B87337454200D4D33F80C4663DC5E5','a@a.co'),(5,'aaa','74B87337454200D4D33F80C4663DC5E5','a@a.a'),(6,'ccc','41FCBA09F2BDCDF315BA4119DC7978DD','c@c.c'),(7,'qqq','B2CA678B4C936F905FB82F2733F5297F','q@q.q'),(9,'dwiki2','202CB962AC59075B964B07152D234B70','a@a.a');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
