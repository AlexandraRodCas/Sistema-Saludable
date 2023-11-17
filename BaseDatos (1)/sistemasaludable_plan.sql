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
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `inicio` date NOT NULL,
  `fin` date NOT NULL,
  `jefe_id` int NOT NULL,
  `metodologo_id` int NOT NULL,
  `deporte_id` int NOT NULL,
  `rama_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_plan_jefe1_idx` (`jefe_id`),
  KEY `fk_plan_metodologo1_idx` (`metodologo_id`),
  KEY `fk_plan_deporte1_idx` (`deporte_id`),
  KEY `fk_plan_rama1_idx` (`rama_id`),
  KEY `fk_plan_usuario1_idx` (`usuario_id`),
  CONSTRAINT `fk_plan_deporte1` FOREIGN KEY (`deporte_id`) REFERENCES `deporte` (`id`),
  CONSTRAINT `fk_plan_jefe1` FOREIGN KEY (`jefe_id`) REFERENCES `jefe` (`id`),
  CONSTRAINT `fk_plan_metodologo1` FOREIGN KEY (`metodologo_id`) REFERENCES `metodologo` (`id`),
  CONSTRAINT `fk_plan_rama1` FOREIGN KEY (`rama_id`) REFERENCES `rama` (`id`),
  CONSTRAINT `fk_plan_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (3,'2023-11-17','2023-11-17',2,2,3,4,1),(4,'2023-11-10','2024-02-29',2,2,3,4,1),(5,'2023-11-18','2024-02-29',2,2,3,4,1),(6,'2023-11-17','2024-02-29',2,2,3,4,1),(7,'2023-11-17','2024-02-29',2,2,3,4,1),(8,'2023-11-17','2024-02-29',2,2,3,4,1),(9,'2023-11-18','2024-03-01',2,2,3,4,1),(10,'2023-11-18','2024-02-29',2,2,3,4,1),(11,'2023-11-18','2024-02-29',2,2,3,4,1),(12,'2023-11-04','2024-04-01',2,2,3,4,1),(13,'2023-11-18','2024-03-28',2,2,3,4,1),(14,'2023-11-18','2024-02-29',2,2,3,4,1),(15,'2023-11-18','2024-04-01',2,2,3,4,1),(16,'2023-11-18','2024-03-01',2,2,3,4,1),(17,'2023-11-18','2024-03-01',2,2,3,4,1),(18,'2023-11-18','2024-03-01',2,2,3,4,1),(19,'2023-11-11','2024-03-01',2,2,3,4,1),(20,'2023-11-18','2024-03-01',2,2,3,4,1),(21,'2023-11-17','2024-03-01',2,2,3,4,1),(22,'2023-11-11','2024-03-01',2,2,3,4,1),(23,'2023-11-11','2024-03-01',2,2,3,4,1),(24,'2023-11-11','2024-03-01',2,2,3,4,1),(25,'2023-11-18','2024-03-01',2,2,3,4,1),(26,'2023-11-18','2024-03-01',2,2,3,4,1),(27,'2023-11-17','2024-03-01',2,2,3,4,1),(28,'2023-11-17','2024-02-29',2,2,3,4,1),(29,'2023-11-17','2024-03-01',2,2,3,4,1),(30,'2023-11-17','2024-03-01',2,2,3,4,1);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
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
