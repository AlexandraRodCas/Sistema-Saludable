-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sistemasaludable
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `etapa`
--

DROP TABLE IF EXISTS `etapa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etapa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `inicio` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `semanas` int NOT NULL,
  `tipo` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etapa`
--

LOCK TABLES `etapa` WRITE;
/*!40000 ALTER TABLE `etapa` DISABLE KEYS */;
INSERT INTO `etapa` VALUES (2,'2023-11-17','2023-12-22',5,'General'),(3,'2023-12-22','2024-01-26',5,'Especial'),(4,'2024-01-26','2024-01-26',0,'Precompetitiva'),(5,'2024-01-26','2024-02-29',4,'Competitiva'),(6,'2023-11-18','2023-12-22',5,'General'),(7,'2023-12-22','2024-01-26',5,'Especial'),(8,'2024-01-26','2024-01-26',0,'Precompetitiva'),(9,'2024-01-26','2024-03-01',4,'Competitiva'),(10,'2023-11-18','2023-12-22',5,'General'),(11,'2023-12-22','2024-01-26',5,'Especial'),(12,'2024-01-26','2024-01-26',0,'Precompetitiva'),(13,'2024-01-26','2024-02-29',4,'Competitiva'),(14,'2023-11-18','2023-12-22',5,'General'),(15,'2023-12-22','2024-01-26',5,'Especial'),(16,'2024-01-26','2024-01-26',0,'Precompetitiva'),(17,'2024-01-26','2024-02-29',4,'Competitiva'),(18,'2023-11-04','2023-12-08',5,'General'),(19,'2023-12-08','2024-02-16',10,'Especial'),(20,'2024-02-16','2024-02-16',0,'Precompetitiva'),(21,'2024-02-16','2024-04-01',6,'Competitiva'),(22,'2023-11-18','2023-12-22',5,'General'),(23,'2023-12-22','2024-01-26',5,'Especial'),(24,'2024-01-26','2024-01-26',0,'Precompetitiva'),(25,'2024-01-26','2024-03-28',8,'Competitiva'),(26,'2023-11-18','2023-12-22',5,'General'),(27,'2023-12-22','2024-01-26',5,'Especial'),(28,'2024-01-26','2024-01-26',0,'Precompetitiva'),(29,'2024-01-26','2024-02-29',4,'Competitiva'),(30,'2023-11-18','2023-12-22',5,'General'),(31,'2023-12-22','2024-01-26',5,'Especial'),(32,'2024-01-26','2024-01-26',0,'Precompetitiva'),(33,'2024-01-26','2024-04-01',9,'Competitiva'),(34,'2023-11-18','2023-12-22',5,'General'),(35,'2023-12-22','2024-01-26',5,'Especial'),(36,'2024-01-26','2024-01-26',0,'Precompetitiva'),(37,'2024-01-26','2024-03-01',4,'Competitiva'),(38,'2023-11-18','2023-12-22',5,'General'),(39,'2023-12-22','2024-01-26',5,'Especial'),(40,'2024-01-26','2024-01-26',0,'Precompetitiva'),(41,'2024-01-26','2024-03-01',4,'Competitiva'),(42,'2023-11-18','2023-12-22',5,'General'),(43,'2023-12-22','2024-01-26',5,'Especial'),(44,'2024-01-26','2024-01-26',0,'Precompetitiva'),(45,'2024-01-26','2024-03-01',4,'Competitiva'),(46,'2023-11-11','2023-12-15',5,'General'),(47,'2023-12-15','2024-01-19',5,'Especial'),(48,'2024-01-19','2024-01-19',0,'Precompetitiva'),(49,'2024-01-19','2024-03-01',5,'Competitiva'),(50,'2023-11-18','2023-12-22',5,'General'),(51,'2023-12-22','2024-01-26',5,'Especial'),(52,'2024-01-26','2024-01-26',0,'Precompetitiva'),(53,'2024-01-26','2024-03-01',4,'Competitiva'),(54,'2023-11-17','2023-12-22',5,'General'),(55,'2023-12-22','2024-01-26',5,'Especial'),(56,'2024-01-26','2024-01-26',0,'Precompetitiva'),(57,'2024-01-26','2024-03-01',4,'Competitiva'),(58,'2023-11-11','2023-12-15',5,'General'),(59,'2023-12-15','2024-01-19',5,'Especial'),(60,'2024-01-19','2024-01-19',0,'Precompetitiva'),(61,'2024-01-19','2024-03-01',5,'Competitiva'),(62,'2023-11-11','2023-12-15',5,'General'),(63,'2023-12-15','2024-01-19',5,'Especial'),(64,'2024-01-19','2024-01-19',0,'Precompetitiva'),(65,'2024-01-19','2024-03-01',5,'Competitiva'),(66,'2023-11-11','2023-12-15',5,'General'),(67,'2023-12-15','2024-01-19',5,'Especial'),(68,'2024-01-19','2024-01-19',0,'Precompetitiva'),(69,'2024-01-19','2024-03-01',5,'Competitiva'),(70,'2023-11-18','2023-12-22',5,'General'),(71,'2023-12-22','2024-01-26',5,'Especial'),(72,'2024-01-26','2024-01-26',0,'Precompetitiva'),(73,'2024-01-26','2024-03-01',4,'Competitiva'),(74,'2023-11-18','2023-12-22',5,'General'),(75,'2023-12-22','2024-01-26',5,'Especial'),(76,'2024-01-26','2024-01-26',0,'Precompetitiva'),(77,'2024-01-26','2024-03-01',4,'Competitiva'),(78,'2023-11-17','2023-12-21',5,'General'),(79,'2023-12-21','2024-01-25',5,'Especial'),(80,'2024-01-25','2024-01-25',0,'Precompetitiva'),(81,'2024-01-25','2024-03-01',5,'Competitiva'),(82,'2023-11-17','2023-12-21',5,'General'),(83,'2023-12-21','2023-12-21',0,'Especial'),(84,'2023-12-21','2024-01-25',5,'Precompetitiva'),(85,'2024-01-25','2024-02-29',5,'Competitiva'),(86,'2023-11-17','2023-12-21',5,'General'),(87,'2023-12-21','2024-01-25',5,'Especial'),(88,'2024-01-25','2024-01-25',0,'Precompetitiva'),(89,'2024-01-25','2024-03-01',5,'Competitiva'),(90,'2023-11-17','2023-12-22',5,'General'),(91,'2023-12-22','2024-01-26',5,'Especial'),(92,'2024-01-26','2024-01-26',0,'Precompetitiva'),(93,'2024-01-26','2024-03-01',4,'Competitiva');
/*!40000 ALTER TABLE `etapa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-16 20:12:55
