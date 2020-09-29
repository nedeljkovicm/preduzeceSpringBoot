/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 10.1.28-MariaDB : Database - fpis
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fpis` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `fpis`;

/*Table structure for table `igracka` */

DROP TABLE IF EXISTS `igracka`;

CREATE TABLE `igracka` (
  `igracka_id` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `pozicija` varchar(255) DEFAULT NULL,
  `stanje_na_zalihama` int(11) NOT NULL,
  `trenutna_cena` double NOT NULL,
  PRIMARY KEY (`igracka_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `igracka` */

insert  into `igracka`(`igracka_id`,`naziv`,`opis`,`pozicija`,`stanje_na_zalihama`,`trenutna_cena`) values 
(1,'Beli medved','Plisana igracka, dimenzije 1m*1m','1D3L',70,250),
(6,'Beli zec','Plisana igracka zec, bele boje, dimenzije 1m*1m','D4R5',50,450),
(7,'Crni medved','Plisana igracka, crne boje, oblik medved','3D2W',70,450),
(9,'Automobil','Boja crvena, dimenzije 40cm*40cm, plastika','3W2D',45,450);

/*Table structure for table `katalog` */

DROP TABLE IF EXISTS `katalog`;

CREATE TABLE `katalog` (
  `katalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `datum_do` date DEFAULT NULL,
  `datum_od` date DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`katalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `katalog` */

insert  into `katalog`(`katalog_id`,`datum_do`,`datum_od`,`naziv`,`status`) values 
(1,'2018-06-01','2018-01-01','KATALOG-JAN-MAJ-2018','Zakljucen'),
(16,'2019-07-09','2019-01-07','KATALOG-JUL-SEPT-2019','U pripremi'),
(19,'2019-04-01','2019-03-01','KATALOG MART-APR-2019','U pripremi'),
(23,'2019-12-14','2019-11-14','KATALOG--NOV-DEC-2019','U pripremi');

/*Table structure for table `stavka_kataloga` */

DROP TABLE IF EXISTS `stavka_kataloga`;

CREATE TABLE `stavka_kataloga` (
  `redni_broj` int(11) NOT NULL,
  `katalog_katalog_id` int(11) NOT NULL,
  `igracka_igracka_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`katalog_katalog_id`,`redni_broj`),
  KEY `FKl93ndblsgr703abwllne56w6v` (`igracka_igracka_id`),
  CONSTRAINT `FKaykaa4uhnwhv3ipce0tg66kpq` FOREIGN KEY (`katalog_katalog_id`) REFERENCES `katalog` (`katalog_id`),
  CONSTRAINT `FKl93ndblsgr703abwllne56w6v` FOREIGN KEY (`igracka_igracka_id`) REFERENCES `igracka` (`igracka_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stavka_kataloga` */

insert  into `stavka_kataloga`(`redni_broj`,`katalog_katalog_id`,`igracka_igracka_id`) values 
(1,1,1),
(2,1,6),
(2,16,6),
(1,19,7),
(1,23,7),
(1,16,9),
(2,23,9);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
