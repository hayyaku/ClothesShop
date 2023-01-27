CREATE DATABASE  IF NOT EXISTS `clothesshopdb` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clothesshopdb`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: clothesshopdb
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `parent_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Nam',0),(2,'Nữ',0),(3,'Trẻ em',0),(4,'Áo nam',1),(5,'Quần nam',1),(6,'Áo nữ',2),(7,'Quần nữ',2),(8,'Áo trẻ em',3),(9,'Quần trẻ em',3),(10,'Áo thun',4),(11,'Áo thun',6),(12,'Áo thun',8),(13,'Áo phao',4),(14,'Áo phao',6),(15,'Áo phao',8),(16,'Áo nỉ',4),(17,'Áo nỉ',6),(18,'Áo nỉ',8),(19,'Áo len',4),(20,'Áo len',6),(21,'Áo len',8),(22,'Áo khoác',4),(23,'Áo khoác',6),(24,'Áo chống nắng',4),(25,'Áo chống nắng',6),(26,'Áo gió',6),(27,'Áo gió',8),(28,'Quần âu',5),(29,'Quần nỉ',5),(30,'Quần jean',5),(31,'Quần kaki',5),(32,'Quần ngố',5),(33,'Quần gió',5),(34,'Quần short',5),(35,'Quần âu',7),(36,'Quần jean',7),(37,'Quần dài',9),(38,'Quần ngố bò',9),(39,'Quần nỉ',9),(40,'Quần ngố kaki',9);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (1,'Trắng'),(2,'Nâu'),(3,'Xanh đen'),(4,'Xanh tím than'),(5,'Tím than'),(6,'Ghi'),(7,'Đen'),(8,'Hồng cam'),(9,'Xanh bích'),(10,'Rêu'),(11,'Vàng bò'),(12,'Hồng'),(13,'Cốm'),(14,'Đỏ'),(15,'Cam'),(16,'Vàng'),(17,'Trắng-Vàng'),(18,'Đen-Cam'),(19,'Xanh Rêu'),(20,'Xám');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category_id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `old_price` double DEFAULT NULL,
  `new_price` double NOT NULL,
  `qty` int NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,11,'Áo Thun Nữ Cổ Tròn',320000,149000,165,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(2,11,'Áo Thun Nữ',320000,55000,50,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(3,14,'Áo Phao Nữ W1',750000,469000,102,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(4,14,'Áo Phao Nữ W2',750000,150000,66,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(5,17,'Áo Nỉ Nữ WA',385000,149000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(6,17,'Áo Nỉ Nữ In Hoa Hồng',450000,90000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(7,20,'Áo Len Nữ W1',450000,199000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(8,20,'Áo Len Nữ WW',525000,262000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(9,26,'Áo Gió Nữ WG',499000,299000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(10,26,'Áo Gió Nữ Savani Mũ Tháo Rời Tiện Lợi',499000,299000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(11,10,'Áo Thun Nam Cổ Tròn ML',380000,55000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(12,10,'Áo Thun Nam ML2',380000,55000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(13,13,'Áo Phao Nam MA',1500000,900000,40,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(14,16,'Áo Nỉ Nam MAN',455000,169000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(15,19,'Áo Len Nam MAL',599000,199000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(16,22,'Áo Da Lộn Nam MJ',1555000,755000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(17,24,'Áo chống nắng nam có mũ',399000,199000,120,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(18,28,'Quần Âu Nam Kẻ Ô Chìm Nhỏ',600000,199000,130,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.'),(19,28,'Quần Âu Nam Ống Đứng Công Sở',600000,199000,180,'Lorem ipsum dolor sit amet consectetur adipisicing elit. Quis nesciunt cupiditate est minima hic magnam aut molestias nihil, voluptates, iusto ipsam esse quae quisquam numquam sunt. Placeat rerum eaque molestias.');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_detail`
--

DROP TABLE IF EXISTS `product_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint NOT NULL,
  `size_id` bigint NOT NULL,
  `color_id` bigint NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_productdetail_product` (`product_id`),
  KEY `fk_productdetail_size` (`size_id`),
  KEY `fk_productdetail_color` (`color_id`),
  CONSTRAINT `fk_productdetail_color` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`),
  CONSTRAINT `fk_productdetail_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_productdetail_size` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_detail`
--

LOCK TABLES `product_detail` WRITE;
/*!40000 ALTER TABLE `product_detail` DISABLE KEYS */;
INSERT INTO `product_detail` VALUES (1,1,1,1,10),(2,1,2,1,10),(3,1,3,1,10),(4,1,4,1,10),(5,1,5,1,10),(6,1,1,2,11),(7,1,2,2,11),(8,1,3,2,11),(9,1,4,2,11),(10,1,5,2,11),(11,1,1,3,12),(12,1,2,3,12),(13,1,3,3,12),(14,1,4,3,12),(15,1,5,3,12),(16,2,1,4,10),(17,2,2,4,10),(18,2,3,4,10),(19,2,4,4,10),(20,2,5,4,10),(24,3,1,5,10),(25,3,2,5,10),(26,3,3,5,11),(27,3,1,6,11),(28,3,2,6,10),(29,3,3,6,11),(30,3,1,7,12),(31,3,2,7,12),(32,3,3,7,15),(38,4,1,8,10),(39,4,2,8,15),(40,4,3,8,16),(41,4,4,8,12),(42,4,5,8,13),(43,5,1,1,10),(44,5,2,1,10),(45,5,3,1,10),(46,5,4,1,10),(47,5,1,5,10),(48,5,2,5,10),(49,5,3,5,10),(50,5,4,5,10),(51,5,1,5,10),(52,5,2,9,10),(53,5,3,9,10),(54,5,4,9,10),(67,6,1,1,10),(68,6,2,1,10),(69,6,3,1,10),(70,6,4,1,10),(71,6,1,3,10),(72,6,2,3,10),(73,6,3,3,10),(74,6,4,3,10),(75,6,1,7,10),(76,6,2,7,10),(77,6,3,7,10),(78,6,4,7,10),(79,7,1,10,10),(80,7,2,10,10),(81,7,3,10,10),(82,7,4,10,10),(83,7,1,11,20),(84,7,2,11,20),(85,7,3,11,20),(86,7,4,11,20),(87,8,1,12,20),(88,8,2,12,10),(89,8,3,12,20),(90,8,4,12,10),(91,8,1,13,20),(92,8,2,13,10),(93,8,3,13,20),(94,8,4,13,10),(95,9,1,4,20),(96,9,2,4,10),(97,9,3,4,20),(98,9,4,4,10),(99,9,1,14,10),(100,9,2,14,20),(101,9,3,14,20),(102,9,4,14,10),(103,10,1,15,20),(104,10,2,15,20),(105,10,3,15,10),(106,10,4,15,10),(107,10,1,16,20),(108,10,2,16,20),(109,10,3,16,10),(110,10,4,16,10),(111,11,1,1,10),(112,11,2,1,10),(113,11,3,1,10),(114,11,4,1,20),(115,11,1,7,20),(116,11,2,7,20),(117,11,3,7,20),(118,11,4,7,10),(119,12,1,1,30),(120,12,2,1,10),(121,12,3,1,20),(122,12,4,1,10),(123,12,1,3,20),(124,12,2,3,10),(125,12,3,3,20),(126,13,1,4,10),(127,13,2,4,10),(128,13,3,4,10),(129,13,4,4,10),(130,14,1,1,20),(131,14,2,1,20),(132,14,3,1,20),(133,14,4,1,20),(134,14,1,5,10),(135,14,2,5,10),(136,14,3,5,10),(137,14,5,5,10),(138,15,1,17,20),(139,15,2,17,20),(140,15,3,17,20),(141,15,4,17,10),(142,15,1,18,10),(143,15,2,18,10),(144,15,3,18,20),(145,15,4,18,10),(146,16,1,2,20),(147,16,2,2,20),(148,16,4,2,10),(149,16,6,2,10),(150,16,2,19,10),(151,16,3,19,20),(152,16,4,19,10),(153,16,5,19,20),(154,17,1,6,10),(155,17,2,6,10),(156,17,3,6,10),(157,17,4,6,10),(158,17,1,20,20),(159,17,2,20,20),(160,17,3,20,20),(161,17,4,20,20),(162,17,5,20,20),(163,18,13,2,10),(164,18,14,2,20),(165,18,15,2,30),(166,18,16,2,10),(167,18,14,20,30),(168,18,15,20,20),(169,18,16,20,10),(170,19,14,6,10),(171,19,15,6,20),(172,19,16,6,30),(173,19,17,6,30),(174,19,18,6,20),(175,19,15,4,10),(176,19,16,4,30),(177,19,17,4,20),(178,19,18,4,10);
/*!40000 ALTER TABLE `product_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_productimage_product` (`product_id`),
  CONSTRAINT `fk_productimage_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES (1,'Nu-01-01.jpg',1),(2,'Nu-02-01.jpg',1),(3,'Nu-03-01.jpg',1),(4,'Nu-01-02.jpg',2),(5,'Nu-02-02.jpg',2),(6,'Nu-01-03.jpg',3),(7,'Nu-02-03.jpg',3),(8,'Nu-01-04.jpg',4),(9,'Nu-02-04.jpg',4),(10,'Nu-03-04.jpg',4),(11,'Nu-01-05.jpg',5),(12,'Nu-02-05.jpg',5),(13,'Nu-03-05.jpg',5),(14,'Nu-04-05.jpg',5),(15,'Nu-01-06.jpg',6),(16,'Nu-02-06.jpg',6),(17,'Nu-03-06.jpg',6),(18,'Nu-01-07.jpg',7),(19,'Nu-02-07.jpg',7),(20,'Nu-01-08.jpg',8),(21,'Nu-02-08.jpg',8),(22,'Nu-01-09.jpg',9),(23,'Nu-02-09.jpg',9),(24,'Nu-01-10.jpg',10),(25,'Nu-02-10.jpg',10),(26,'Nam-01-11.jpg',11),(27,'Nam-02-11.jpg',11),(32,'Nam-01-12.jpg',12),(33,'Nam-02-12.jpg',12),(34,'Nam-01-13.jpg',13),(35,'Nam-02-13.jpg',13),(36,'Nam-01-14.jpg',14),(37,'Nam-02-14.jpg',14),(38,'Nam-01-15.jpg',15),(39,'Nam-02-15.jpg',15),(40,'Nam-01-16.jpg',16),(41,'Nam-02-16.jpg',16),(42,'Nam-01-17.jpg',17),(43,'Nam-02-17.jpg',17),(44,'Nam-01-18.jpg',18),(45,'Nam-02-18.jpg',18),(46,'Nam-01-19.jpg',19),(47,'Nam-02-19.jpg',19);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'S'),(2,'M'),(3,'L'),(4,'XL'),(5,'XXL'),(6,'XXXL'),(7,'2'),(8,'4'),(9,'6'),(10,'8'),(11,'10'),(12,'28'),(13,'29'),(14,'30'),(15,'31'),(16,'32'),(17,'33'),(18,'34');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleid` int DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_users_role` (`roleid`),
  CONSTRAINT `fk_users_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin','$2a$12$F4vbW2juRdzu0JoV12B2p.qpaPLN7BNdCnzzpuIyokmmpL0/zVwMa',1,'admin@gmail.com','0123456789'),(2,'user','user','$2a$12$D0Q2tBtsxUwcEF04iJYcpeeA7YLEqMLiscMZXOM.Hd82ipakjDScu',2,'user@gmail.com','0123654789');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-27 11:07:46
