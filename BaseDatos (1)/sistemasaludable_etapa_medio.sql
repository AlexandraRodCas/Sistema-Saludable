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
-- Table structure for table `etapa_medio`
--

DROP TABLE IF EXISTS `etapa_medio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `etapa_medio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `etapa_id_etapa` int NOT NULL,
  `medio_id` int NOT NULL,
  `volumen` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_etapa_has_medio_medio1_idx` (`medio_id`),
  KEY `fk_etapa_has_medio_etapa1_idx` (`etapa_id_etapa`),
  CONSTRAINT `fk_etapa_has_medio_etapa1` FOREIGN KEY (`etapa_id_etapa`) REFERENCES `etapa` (`id`),
  CONSTRAINT `fk_etapa_has_medio_medio1` FOREIGN KEY (`medio_id`) REFERENCES `medio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etapa_medio`
--

LOCK TABLES `etapa_medio` WRITE;
/*!40000 ALTER TABLE `etapa_medio` DISABLE KEYS */;
INSERT INTO `etapa_medio` VALUES (1,2,1,45),(2,3,1,45),(3,4,1,45),(4,5,1,45),(5,6,1,45),(6,7,1,45),(7,8,1,45),(8,9,1,45),(9,10,1,45),(10,11,1,45),(11,12,1,45),(12,13,1,45),(13,14,1,45),(14,15,1,45),(15,16,1,45),(16,17,1,45),(17,18,1,45),(18,19,1,45),(19,20,1,45),(20,21,1,45),(21,22,1,45),(22,23,1,45),(23,24,1,45),(24,25,1,45),(25,26,1,45),(26,27,1,45),(27,28,1,45),(28,29,1,45),(29,30,1,45),(30,31,1,45),(31,32,1,45),(32,33,1,45),(33,34,1,45),(34,35,1,45),(35,36,1,45),(36,37,1,45),(37,38,1,45),(38,39,1,45),(39,40,1,45),(40,41,1,45),(41,42,1,45),(42,43,1,45),(43,44,1,45),(44,45,1,45),(45,46,1,45),(46,47,1,45),(47,48,1,45),(48,49,1,45),(49,50,1,45),(50,51,1,45),(51,52,1,45),(52,53,1,45),(53,54,1,45),(54,55,1,45),(55,56,1,45),(56,57,1,45),(57,58,1,45),(58,59,1,45),(59,60,1,45),(60,61,1,45),(61,62,1,45),(62,63,1,45),(63,64,1,45),(64,65,1,45),(65,66,1,45),(66,67,1,45),(67,68,1,45),(68,69,1,45),(69,70,1,45),(70,71,1,45),(71,72,1,45),(72,73,1,45),(73,74,1,45),(74,75,1,45),(75,76,1,45),(76,77,1,45),(77,2,1,270),(78,3,1,270),(79,4,1,270),(80,5,1,270),(81,6,1,270),(82,7,1,270),(83,8,1,270),(84,9,1,270),(85,10,1,270),(86,11,1,270),(87,12,1,270),(88,13,1,270),(89,14,1,270),(90,15,1,270),(91,16,1,270),(92,17,1,270),(93,18,1,270),(94,19,1,270),(95,20,1,270),(96,21,1,270),(97,22,1,270),(98,23,1,270),(99,24,1,270),(100,25,1,270),(101,26,1,270),(102,27,1,270),(103,28,1,270),(104,29,1,270),(105,30,1,270),(106,31,1,270),(107,32,1,270),(108,33,1,270),(109,34,1,270),(110,35,1,270),(111,36,1,270),(112,37,1,270),(113,38,1,270),(114,39,1,270),(115,40,1,270),(116,41,1,270),(117,42,1,270),(118,43,1,270),(119,44,1,270),(120,45,1,270),(121,46,1,270),(122,47,1,270),(123,48,1,270),(124,49,1,270),(125,50,1,270),(126,51,1,270),(127,52,1,270),(128,53,1,270),(129,54,1,270),(130,55,1,270),(131,56,1,270),(132,57,1,270),(133,58,1,270),(134,59,1,270),(135,60,1,270),(136,61,1,270),(137,62,1,270),(138,63,1,270),(139,64,1,270),(140,65,1,270),(141,66,1,270),(142,67,1,270),(143,68,1,270),(144,69,1,270),(145,70,1,270),(146,71,1,270),(147,72,1,270),(148,73,1,270),(149,74,1,270),(150,75,1,270),(151,76,1,270),(152,77,1,270),(153,2,1,36),(154,3,1,36),(155,4,1,36),(156,5,1,36),(157,6,1,36),(158,7,1,36),(159,8,1,36),(160,9,1,36),(161,10,1,36),(162,11,1,36),(163,12,1,36),(164,13,1,36),(165,14,1,36),(166,15,1,36),(167,16,1,36),(168,17,1,36),(169,18,1,36),(170,19,1,36),(171,20,1,36),(172,21,1,36),(173,22,1,36),(174,23,1,36),(175,24,1,36),(176,25,1,36),(177,26,1,36),(178,27,1,36),(179,28,1,36),(180,29,1,36),(181,30,1,36),(182,31,1,36),(183,32,1,36),(184,33,1,36),(185,34,1,36),(186,35,1,36),(187,36,1,36),(188,37,1,36),(189,38,1,36),(190,39,1,36),(191,40,1,36),(192,41,1,36),(193,42,1,36),(194,43,1,36),(195,44,1,36),(196,45,1,36),(197,46,1,36),(198,47,1,36),(199,48,1,36),(200,49,1,36),(201,50,1,36),(202,51,1,36),(203,52,1,36),(204,53,1,36),(205,54,1,36),(206,55,1,36),(207,56,1,36),(208,57,1,36),(209,58,1,36),(210,59,1,36),(211,60,1,36),(212,61,1,36),(213,62,1,36),(214,63,1,36),(215,64,1,36),(216,65,1,36),(217,66,1,36),(218,67,1,36),(219,68,1,36),(220,69,1,36),(221,70,1,36),(222,71,1,36),(223,72,1,36),(224,73,1,36),(225,74,1,36),(226,75,1,36),(227,76,1,36),(228,77,1,36),(229,2,1,45),(230,2,1,45),(231,2,1,495),(232,82,1,750),(233,82,1,0),(234,82,1,1500),(235,90,1,80),(236,91,1,80),(237,93,1,64);
/*!40000 ALTER TABLE `etapa_medio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-16 20:12:54
