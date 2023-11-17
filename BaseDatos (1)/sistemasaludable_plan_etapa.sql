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
-- Table structure for table `plan_etapa`
--

DROP TABLE IF EXISTS `plan_etapa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_etapa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `plan_id` int NOT NULL,
  `etapa_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_plan_has_etapa_etapa1_idx` (`etapa_id`),
  KEY `fk_plan_has_etapa_plan1_idx` (`plan_id`),
  CONSTRAINT `fk_plan_has_etapa_etapa1` FOREIGN KEY (`etapa_id`) REFERENCES `etapa` (`id`),
  CONSTRAINT `fk_plan_has_etapa_plan1` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_etapa`
--

LOCK TABLES `plan_etapa` WRITE;
/*!40000 ALTER TABLE `plan_etapa` DISABLE KEYS */;
INSERT INTO `plan_etapa` VALUES (1,10,10),(2,10,11),(3,10,12),(4,10,13),(5,11,14),(6,11,15),(7,11,16),(8,11,17),(9,12,18),(10,12,19),(11,12,20),(12,12,21),(13,13,22),(14,13,23),(15,13,24),(16,13,25),(17,14,26),(18,14,27),(19,14,28),(20,14,29),(21,15,30),(22,15,31),(23,15,32),(24,15,33),(25,16,34),(26,16,35),(27,16,36),(28,16,37),(29,17,38),(30,17,39),(31,17,40),(32,17,41),(33,18,42),(34,18,43),(35,18,44),(36,18,45),(37,19,46),(38,19,47),(39,19,48),(40,19,49),(41,20,50),(42,20,51),(43,20,52),(44,20,53),(45,21,54),(46,21,55),(47,21,56),(48,21,57),(49,22,58),(50,22,59),(51,22,60),(52,22,61),(53,23,62),(54,23,63),(55,23,64),(56,23,65),(57,24,66),(58,24,67),(59,24,68),(60,24,69),(61,25,70),(62,25,71),(63,25,72),(64,25,73),(65,26,74),(66,26,75),(67,26,76),(68,26,77),(69,27,78),(70,27,79),(71,27,80),(72,27,81),(73,28,82),(74,28,83),(75,28,84),(76,28,85),(77,29,86),(78,29,87),(79,29,88),(80,29,89),(81,30,90),(82,30,91),(83,30,92),(84,30,93);
/*!40000 ALTER TABLE `plan_etapa` ENABLE KEYS */;
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
