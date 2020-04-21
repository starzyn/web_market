-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: bill
-- ------------------------------------------------------
-- Server version	5.7.25-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_provider`
--

DROP TABLE IF EXISTS `t_provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_provider` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商编号',
  `p_name` varchar(20) NOT NULL COMMENT '供应商名称',
  `p_date` date NOT NULL COMMENT '创建时间',
  `p_tel` varchar(14) NOT NULL COMMENT '联系电话',
  `p_contact` varchar(14) NOT NULL COMMENT '联系人',
  `p_fax` varchar(14) NOT NULL COMMENT '传真',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_provider`
--

LOCK TABLES `t_provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbill`
--

DROP TABLE IF EXISTS `t_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bill` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账单主键',
  `p_name` varchar(20) NOT NULL COMMENT '商品名称',
  `p_untis` varchar(20) NOT NULL COMMENT '商品单位',
  `p_count` int(11) NOT NULL COMMENT '商品数量',
  `b_date` date NOT NULL COMMENT '创建时间',
  `b_price` double(6,1) DEFAULT NULL COMMENT '账单金额',
  `p_type` int(11) DEFAULT '0' COMMENT '0未付款1付款',
  `p_id` int(11) DEFAULT NULL COMMENT '供应商编号',
  PRIMARY KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbill`
--

LOCK TABLES `t_bill` WRITE;
/*!40000 ALTER TABLE `tbill` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `u_account` varchar(64) NOT NULL COMMENT '用户账号',
  `u_password` varchar(64) NOT NULL COMMENT '密码',
  `u_name` varchar(8) NOT NULL COMMENT '用户名',
  `u_sex` int(11) DEFAULT '0' COMMENT '0女1男',
  `u_age` int(11) DEFAULT NULL COMMENT '年龄',
  `u_tel` varchar(14) DEFAULT NULL COMMENT '用户电话',
  `u_type` varchar(10) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_account` (`u_account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'root','123','zhaoweif',1,18,'18511113456','CEO');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-01  2:30:26
