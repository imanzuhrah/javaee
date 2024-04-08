-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: dbagenda
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `contatos`
--

DROP TABLE IF EXISTS `contatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contatos` (
  `idcon` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `fone` varchar(15) NOT NULL,
  `fone2` varchar(10) DEFAULT NULL,
  `fone3` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idcon`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contatos`
--

LOCK TABLES `contatos` WRITE;
/*!40000 ALTER TABLE `contatos` DISABLE KEYS */;
INSERT INTO `contatos` VALUES (1,'Satya Nadella','1','234','4332-3223','satya.nadella@outlook.com'),(15,'Jonathan ','55','14','99999-9999','jonathan222@gmail.com'),(16,'Lucas','55','14','99999-9999','lucas@outlook.com'),(17,'Evelyn','55','11','99999-9999','evelyn@gmail.com '),(18,'Marcela','55','14','99999-9999','marcela@gmail.com'),(19,'Geonvane','55','14','99999-9999','geovanne@outlook.com'),(20,'Kauan','55','14','99999-9999','kauan@gmail.com'),(21,'Marcos','55','14','99999-9999','marcos@gmail.com'),(22,'Gabriel','55','14','99999-9999',''),(23,'Marcio','55','14','99999-9999',''),(24,'Pedro','55','14','99999-9999','pedro@gmail.com'),(25,'Vitor ','55','14','99999-9999','vitor@gmail.com'),(26,'Miguel','55','14','99999-9999','miguel@yahoo.com'),(27,'Vitoria','55','14','99999-9999','vivi@gmail.com'),(28,'Guilherme','55','13','99999-9999','guilherme@gmail.com'),(31,'Ana C. Barros','555','34','32423','ana@gmail.com');
/*!40000 ALTER TABLE `contatos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-08 14:22:58
