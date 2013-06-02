CREATE DATABASE  IF NOT EXISTS `agenda` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_turkish_ci */;
USE `agenda`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: agenda
-- ------------------------------------------------------
-- Server version	5.5.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `todolist`
--

DROP TABLE IF EXISTS `todolist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `todolist` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EVENT_NAME` varchar(45) COLLATE utf8_turkish_ci NOT NULL,
  `EVENT_DETAIL` varchar(200) COLLATE utf8_turkish_ci DEFAULT NULL,
  `EVENT_START_DATE` date NOT NULL,
  `EVENT_START_TIME` time NOT NULL,
  `EVENT_END_DATE` date NOT NULL,
  `EVENT_END_TIME` time NOT NULL,
  `EVENT_PLACE` varchar(45) COLLATE utf8_turkish_ci DEFAULT NULL,
  `EVENT_COMPLETE` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todolist`
--

LOCK TABLES `todolist` WRITE;
/*!40000 ALTER TABLE `todolist` DISABLE KEYS */;
INSERT INTO `todolist` VALUES (1,'sdfdfds','dfgdfgdfgf','2013-06-02','12:33:11','2013-06-02','13:33:00','ghfghfghfg',1),(2,'sdfdfds','dfgdfgdfgffdd','2013-06-02','13:33:00','2013-06-02','14:33:00','ghfghfghfgfgfdfdgdf',0),(3,'sdfdfdssds','dfgdfgdfgffdda','2013-06-02','14:33:00','2013-06-02','15:33:00','ghfghfghfgfgfdfdgdfaa',1),(4,'fgjgvj','ghfgh','2013-06-03','16:41:28','2013-06-02','17:41:00','ghfghfg',0),(5,'Taksim Gezi Parkı','Saat 14:00\'de Taksim Gezi Parkında buluşalım.','2013-06-03','16:00:00','2013-06-02','20:00:00','Taksim - İSTANBUL',0);
/*!40000 ALTER TABLE `todolist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-03  1:42:40
