-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: pingu
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Dumping data for table `clientes`
--

CREATE DATABASE `pingu`;
USE `pingu`;

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Christia','Rodriguez','105','25','PROVENZA','Bucaramanga','3015258457','cmrcur@gmail.com',1),(2,'Seb','Lop','24','54','CABECERA','Bucaramanga','302578943','sebLop@gmuo',0),(3,'Juan','Carvajal','35','48','PEÑAS','Piedecuesta','30258792','jpjCarvajal@gmail',1),(4,'Juan','Patiño','200','0','CUMBRE','FLoridaBlanca','302587925','patiPati@gmail',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (11,'Cocina',1,'2023-09-25 02:39:14.505140'),(12,'Cocina',2,'2023-10-01 02:39:14.505140'),(13,'Pedido',3,'2023-10-14 01:02:04.677282'),(14,'Pedido',4,'2023-10-14 17:04:25.996745'),(15,'Pedido',4,'2023-10-14 17:10:41.684765'),(16,'Pedido',4,'2023-10-14 17:13:54.934634'),(17,'Pedido',4,'2023-10-14 17:14:46.962305'),(18,'Pedido',4,'2023-10-14 17:16:47.354598'),(19,'Pedido',4,'2023-10-14 17:24:21.016542'),(20,'Pedido',4,'2023-10-14 17:27:11.462640'),(21,'Pedido',4,'2023-10-14 17:35:43.540366'),(22,'Pedido',4,'2023-10-14 17:38:45.210102'),(23,'Pedido',4,'2023-10-14 17:41:15.847753'),(24,'Pedido',4,'2023-10-14 17:50:18.236861'),(25,'Pedido',4,'2023-10-14 17:50:31.011228'),(26,'Pedido',4,'2023-10-14 17:51:10.677724'),(27,'Pedido',2,'2023-10-14 17:55:47.072988'),(28,'Pedido',2,'2023-10-14 17:56:16.018451'),(29,'Pedido',2,'2023-10-14 17:58:14.512359'),(30,'Pedido',2,'2023-10-14 18:01:55.098557'),(31,'Pedido',1,'2023-10-18 04:44:06.028651'),(32,'Pedido',1,'2023-10-18 04:48:51.701262'),(33,'Pedido',1,'2023-10-18 04:49:43.924736'),(34,'Pedido',1,'2023-10-18 04:52:04.926292'),(35,'Pedido',4,'2023-10-18 04:54:52.144106'),(36,'Pedido',4,'2023-10-18 04:57:46.175658'),(37,'Pedido',4,'2023-10-18 05:21:02.435290'),(38,'Pedido',3,'2023-10-18 05:58:36.165096'),(39,'Pedido',3,'2023-10-18 06:00:52.165344'),(40,'Pedido',3,'2023-10-18 06:02:42.231407'),(41,'Pedido',3,'2023-10-18 06:04:25.325183'),(42,'Pedido',3,'2023-10-18 06:06:08.340368'),(43,'Pedido',3,'2023-10-18 06:09:30.709098'),(44,'Pedido',3,'2023-10-18 06:11:10.628400'),(45,'Pedido',3,'2023-10-18 06:12:59.016582'),(46,'Pedido',3,'2023-10-18 06:14:53.987848'),(47,'Pedido',3,'2023-10-18 06:21:34.716099'),(48,'Pedido',3,'2023-10-18 06:22:49.856682'),(49,'Pedido',3,'2023-10-18 06:24:17.699510'),(50,'Pedido',3,'2023-10-18 06:25:48.695948'),(51,'Pedido',3,'2023-10-18 06:28:45.761937'),(52,'Pedido',2,'2023-10-18 21:49:07.458922'),(53,'Pedido',2,'2023-10-18 21:50:36.934290'),(54,'Pedido',1,'2023-10-18 22:53:32.610384'),(55,'Pedido',1,'2023-10-19 02:35:13.732728'),(56,'Pedido',1,'2023-10-19 03:08:29.617455'),(57,'Pedido',1,'2023-10-19 03:09:27.929712'),(58,'Pedido',1,'2023-10-19 03:13:12.189593'),(59,'Pedido',1,'2023-10-19 03:17:07.442734'),(60,'Pedido',1,'2023-10-19 03:26:34.214519'),(61,'Pedido',2,'2023-10-19 03:32:16.927246'),(62,'Pedido',1,'2023-10-22 02:01:39.376129'),(63,'Pedido',1,'2023-10-22 02:02:29.687568'),(64,'Pedido',1,'2023-10-22 02:14:53.276076'),(65,'Pedido',1,'2023-10-22 02:17:23.198612'),(66,'Pedido',1,'2023-10-22 02:28:23.241461'),(67,'Pedido',1,'2023-10-22 02:41:26.042172'),(68,'Pedido',1,'2023-10-22 02:48:37.416877'),(69,'Pedido',4,'2023-10-22 03:18:34.431288'),(70,'Pedido',3,'2023-10-22 06:20:41.426612'),(71,'Pedido',3,'2023-10-23 01:49:37.535299');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pedidos-detalle`
--

LOCK TABLES `pedidos-detalle` WRITE;
/*!40000 ALTER TABLE `pedidos-detalle` DISABLE KEYS */;
INSERT INTO `pedidos-detalle` VALUES (5,11,3,1,'Cocina'),(6,12,8,2,'Cocina'),(7,13,2,3,'Cola'),(8,11,3,3,'Cocina'),(9,11,3,3,'Cocina'),(10,11,7,2,'Cocina'),(11,14,1,1,'Cola'),(12,14,7,2,'Cola'),(13,14,1,3,'Cola'),(14,14,1,3,'Cola'),(15,14,3,3,'Cola'),(16,14,1,3,'Cola'),(17,14,3,3,'Cola'),(18,14,1,3,'Cola'),(19,14,3,3,'Cola'),(20,11,4,1,'Cocina'),(21,11,7,2,'Cocina'),(22,11,7,1,'Cola'),(23,11,1,2,'Cola'),(24,12,4,10,'Cola'),(25,11,1,8,'Cola'),(26,11,7,1,'Cola'),(27,11,3,1,'Cola'),(28,11,2,1,'Cola'),(29,13,2,1,'Cola');
/*!40000 ALTER TABLE `pedidos-detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Hamburguesa',125,10,23000,1),(2,'Crazy Potato',150,10,18000,1),(3,'Hot Perro',120,10,18000,1),(4,'Hamburguesa ElPingu',48,10,30000,1),(5,'Pepito',100,0,18000,1),(6,'Sanwich',100,10,15000,1),(7,'Pipipicada',140,15,40000,0),(8,'Picaña',50,0,55000,0);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin.pingu@gmail.com','admin1122',1,'Christian','Curubo'),(2,'luis.operario@elPingu.com','operario123',0,'Luis','Benson'),(3,'ShaggyCocina@elPingu.com','Coco1257',3,'Shaggy','Salamanca'),(4,'IkerDomicilio@elPingu.com','Rappi12',4,'iker','Casilla'),(11,'linesAnto@gmail','linesAnto@gmail',0,'AntoLove','Love'),(12,'linesAnto@gmail','linesAnto@gmail',0,'AntoLove','Love'),(13,'JuanLopex@gmail','1245',1,'Lopez','Juan');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-22 21:47:10
