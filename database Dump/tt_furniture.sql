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
-- Table structure for table `furniture`
--

DROP TABLE IF EXISTS `furniture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `furniture` (
  `furniture_id` int NOT NULL,
  `furniture_name` varchar(200) NOT NULL,
  `furniture_img_link` varchar(200) NOT NULL,
  `furniture_desc` longtext NOT NULL,
  `furniture_price` varchar(10) NOT NULL,
  PRIMARY KEY (`furniture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `furniture`
--

LOCK TABLES `furniture` WRITE;
/*!40000 ALTER TABLE `furniture` DISABLE KEYS */;
INSERT INTO `furniture` VALUES (1,'TEAK BEDROOM SET....','C:\\\\Users\\\\meshr\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\dbms_assign2\\\\src\\\\dbms_assign2\\\\furniture1.jpg','Assembly Type : Assembly Service Provided by Retailer\n    Type : King Bed\n    Storage Type : Box Storage\n    Dimension : King Bed : 2.05 m L x 1.88 m W x 1.0 m H\n    Recommended Mattress Size : 180 x 195 cm\n    Headboard Type : Solid\n    Country of Origin : India\n    Contact Us/Consumer Care : Name: Syed Ismail, Email: help@homecentre.in, Lifestyle International Pvt Ltd, 1800-212-7500\n','34999'),(2,'GOLD TEAK GOD MANDIR....','C:\\\\Users\\\\meshr\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\dbms_assign2\\\\src\\\\dbms_assign2\\\\furniture4.jpg','Made from Premium Quality Sheesham Wood (Indian Rosewood) Hand carved Beautiful designed, \npremium embossed finishing,\nHandmade by skilled craftsmen which give royal look to your decoration','12499'),(3,'3+1+1 SOFA COMBO.....','C:\\\\Users\\\\meshr\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\dbms_assign2\\\\src\\\\dbms_assign2\\\\furniture2.jpg','Bharat Lifestyle brings to you modern and comfortable sofa set for your living room.\nBharat Lifestyle Lexus Dark Grey Jute Fabric 3+1+1 Sofa Set is made of Acacia wood.\nIt has an elegant design which enhances the interior decor of your living room.\nDesigned in such a way, the sofa is comfortable to sit. The best part it, it comes with good price without compromising on quality.','29999'),(4,'GLASS TOP TEA TABLE....','C:\\\\Users\\\\meshr\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\dbms_assign2\\\\src\\\\dbms_assign2\\\\furniture5.jpg','woodFurniture','7499'),(5,'COMFORT CUSION SOFA....','C:\\\\Users\\\\meshr\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\dbms_assign2\\\\src\\\\dbms_assign2\\\\furniture3.jpg','woodFurniture','15999'),(6,'4 SEATED DINING TABLE....','C:\\\\Users\\\\meshr\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\dbms_assign2\\\\src\\\\dbms_assign2\\\\furniture6.jpg','woodFurniture','9999');
/*!40000 ALTER TABLE `furniture` ENABLE KEYS */;
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
