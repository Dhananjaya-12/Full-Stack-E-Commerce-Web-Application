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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int NOT NULL,
  `email_addr` varchar(200) DEFAULT NULL,
  `delivery_addr` varchar(200) DEFAULT NULL,
  `total_price_purchased` int DEFAULT NULL,
  `date_purchased` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-01-29 19:00:47'),(2,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',47498,'2021-01-29 19:02:32'),(3,'prajwal@gmail.com','XYZ, ABC, Bengaluru 560090',19998,'2021-01-30 05:22:59'),(4,'shubanakarsamantray@gmail.com','ABC, XYZ, PQR, ODISHA',28498,'2021-01-30 06:02:39'),(5,'varunkumar@gmail.com','XYZ, ABCD, BENGALURU',47498,'2021-01-30 06:28:28'),(6,'xyz@gmail.com','XYZ, bengaluru',47498,'2021-01-30 07:37:27'),(7,'rachuuuu16@gmail.com','KUmarswamy Layout',42498,'2021-01-30 11:38:46'),(8,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',47498,'2021-02-09 08:16:53'),(9,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',47498,'2021-03-09 16:26:49'),(10,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',47498,'2021-06-01 20:24:11'),(11,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-01 20:32:01'),(12,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',77497,'2021-06-02 08:05:02'),(13,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 08:28:01'),(14,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 08:29:23'),(15,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 08:46:11'),(16,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 08:48:07'),(17,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 08:49:38'),(18,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 08:51:16'),(19,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 08:59:52'),(20,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 09:01:02'),(21,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',47498,'2021-06-02 09:03:22'),(22,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',47498,'2021-06-02 09:04:23'),(23,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 09:06:17'),(24,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 11:49:18'),(25,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 11:57:04'),(26,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 11:58:29'),(27,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:08:02'),(28,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:15:24'),(29,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:16:25'),(30,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',47498,'2021-06-02 12:17:09'),(31,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:18:17'),(32,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:20:41'),(33,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:23:07'),(34,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:24:23'),(35,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:25:39'),(36,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:44:04'),(37,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:47:02'),(38,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',34999,'2021-06-02 12:50:52'),(39,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:55:15'),(40,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 12:59:17'),(41,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 13:12:22'),(42,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 15:25:02'),(43,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 15:25:56'),(44,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-02 19:24:43'),(45,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-03 11:35:53'),(46,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',12499,'2021-06-03 11:51:37'),(47,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',80995,'2021-06-03 11:52:10'),(48,'meshrihari19@gmail.com','Sandhya Nagara, Dasapanna Palya\nChikkabanavara,\nBengaluru - 560090',37498,'2021-06-03 12:19:58');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-03 18:40:32
