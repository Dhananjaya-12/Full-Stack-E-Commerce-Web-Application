-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: tt
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email_addr` varchar(200) NOT NULL,
  `passcode` longtext NOT NULL,
  `address` longtext NOT NULL,
  `phone_number` varchar(15) NOT NULL,
  `userid` varchar(200) NOT NULL,
  PRIMARY KEY (`email_addr`,`userid`,`phone_number`),
  UNIQUE KEY `email_addr` (`email_addr`),
  UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES ('a','a','a','1cb2d2c053b5c08e7529971da50c8c410eae743e917e1ac0ffd2e881ba16d2e3','snfgsondgv','9876543221','a'),('asdvfa','SAEDg','ASEWG','1cb2d2c053b5c08e7529971da50c8c410eae743e917e1ac0ffd2e881ba16d2e3','WAEgWEg','9916417441','WEAG'),('b','b','b','1cb2d2c053b5c08e7529971da50c8c410eae743e917e1ac0ffd2e881ba16d2e3','djlfbasihjd','9876654321','b'),('Bharath','Kumar','bharathkumarb12345@gmail.com','5e427fc9114ccd8cfe8cd64250f576eb8537123918dc4f0cd3a8aad9ee3b356b','Bengaluru, Karnataka - 560123','7760733191','bharath12345'),('Shri','Hari','meshrihari19@gmail.com','1cb2d2c053b5c08e7529971da50c8c410eae743e917e1ac0ffd2e881ba16d2e3','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090','9886954726','meshrihari19'),('ABC','BCA','mimiLord@ricardomemes.com','4c8f51cbf80ff783008e0449852c0f19b23b60bfb0ad40dc63dd7ff9a4e9a5f8','srirampura, near oklipuram, bengaluru 90','9876543210','huehueDoge'),('Prajwal','S','prajwal@gmail.com','23fcfa5e2286f04a689b79b1cf8be1b5f1eeaf6a70c50bf5d30f1c682fb41e6f','XYZ, ABC, Bengaluru 560090','9916417443','praju'),('Rachu','Shivu','rachuuuu16@gmail.com','46156ffcd4636e3ab962f6325edaafafa8f3f4900783b2407485b8e812217083','KUmarswamy Layout','7975674499','rachuu_16'),('Shubankar','Samantray','shubanakarsamantray@gmail.com','5f76c87298c93acf9ccc3d4e51bbf8bcb7462181cbd7a30aa6641c182db1411d','ABC, XYZ, PQR, ODISHA','6123456789','shubanakar'),('Varun','Kumar','varunkumar@gmail.com','a06202888590567e4739cb0ae6818e9b4fd66aaf9b00300be13b57ad741d143','XYZ, ABCD, BENGALURU','9876543320','varun'),('prabhakara','Sir','xyz@gmail.com','f999174c4d34ec0a4ae14f55b6204550b2c5b0911aea27fe7ad03d428ddff94e','XYZ, bengaluru','9916417448','xyz');
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-03 18:40:31
