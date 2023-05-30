-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `car` (
  `car_id` int NOT NULL AUTO_INCREMENT,
  `item_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `num` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES (21,31,16,1,25.20,'25.2'),(22,27,16,1,49.41,'49.41');
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `pj_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `item_id` int DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `addTime` datetime DEFAULT NULL,
  PRIMARY KEY (`pj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (7,3,35,'真的很不错','2018-03-20 19:23:03'),(8,3,28,'真好吃','2018-03-20 19:32:31'),(9,31,35,'haode','2022-04-25 11:17:39'),(10,31,30,NULL,'2022-04-26 16:19:49'),(11,31,30,'推荐给喜欢罐罐茶的朋友们！','2022-04-26 16:24:34'),(12,51,36,'顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶','2022-05-09 23:37:18'),(13,51,36,'很有纪念意义！','2022-05-09 23:39:21'),(14,50,29,'方便携带，小巧！','2022-05-10 11:32:14'),(15,50,29,'方便携带，小巧！','2022-05-10 11:39:49'),(16,50,29,'方便携带，小巧！','2022-05-10 11:42:19'),(17,50,29,'方便携带，小巧！','2022-05-10 11:44:04'),(18,50,29,'方便携带，小巧！','2022-05-10 11:47:21'),(19,50,29,'方便携带，小巧！','2022-05-10 11:53:33'),(20,50,29,'方便携带，小巧！','2022-05-10 11:55:26'),(21,50,29,'方便携带，小巧！','2022-05-10 12:00:09'),(22,50,29,'方便携带，小巧！','2022-05-10 12:00:23'),(23,50,29,'方便携带，小巧！','2022-05-10 12:08:56'),(24,50,29,'方便携带，小巧！','2022-05-10 12:10:06'),(25,50,29,'方便携带，小巧！','2022-05-10 12:11:16'),(26,50,29,'方便携带，小巧！','2022-05-10 12:14:47'),(27,50,27,'喝八宝茶标配！','2022-05-10 12:26:28'),(28,50,37,'很有纪念意义！','2022-05-10 23:22:30'),(29,50,37,'好看','2022-05-11 11:54:37'),(30,47,43,'很有纪念意义','2022-05-11 21:51:37'),(31,47,40,'味道真的不错！','2022-05-11 23:02:33'),(32,47,28,'营养价值高','2022-05-12 14:51:57');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `events` (
  `events_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `addTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`events_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events`
--

LOCK TABLES `events` WRITE;
/*!40000 ALTER TABLE `events` DISABLE KEYS */;
INSERT INTO `events` VALUES (2,'宁夏关键词#征集各类文创产品设计，不限产品种类，突出城市特色文化。','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/12ed4150c51011eccb2a4c0d8aa2a373hudong1.jpg\" title=\"hudong1.jpg\" alt=\"hudong1.jpg\" width=\"500\" height=\"430\"/></p>','2022-04-26 11:22:39',NULL),(3,'拿得出手的一杯咖啡#银川IP咖啡包装设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/5e055880c51011eccb2a4c0d8aa2a373微信图片_20220425143007.jpg\" title=\"微信图片_20220425143007.jpg\" alt=\"微信图片_20220425143007.jpg\" width=\"500\" height=\"430\"/></p>','2022-04-26 11:24:42',NULL),(4,'薪火相传——设计向未来#原创六盘山红军长征纪念馆文创产品征集','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/34d4cd00c51111eccb2a4c0d8aa2a37320dc257447d365d69e487a43417af2aa.jpeg\" title=\"20dc257447d365d69e487a43417af2aa.jpeg\" alt=\"20dc257447d365d69e487a43417af2aa.jpeg\" width=\"500\" height=\"430\"/></p>','2022-04-26 11:30:45','2022-04-26 11:30:55'),(5,'博物馆限定——征集最美博物馆纪念品','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/1e324470d07311ec2780b33642e9f202huodong_museum.jpg\" title=\"huodong_museum.jpg\" alt=\"huodong_museum.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-10 23:09:13',NULL),(6,'茶饮LOGO设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/17b5a500d12811ec324de7dd963ceb81茶叶LOGO设计.jpg\" title=\"茶叶LOGO设计.jpg\" alt=\"茶叶LOGO设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-11 20:44:41','2022-05-11 22:05:50'),(8,'黔东南苗绣X贵州省博物馆文创','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/274eac90d1a111ece7e6bc91901716f2黔东南苗绣X贵州省博物馆文创.jpg\" title=\"黔东南苗绣X贵州省博物馆文创.jpg\" alt=\"黔东南苗绣X贵州省博物馆文创.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 11:11:16',NULL);
/*!40000 ALTER TABLE `events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `scNum` int DEFAULT NULL COMMENT '收藏数',
  `gmNum` int DEFAULT NULL COMMENT '购买数',
  `url1` varchar(255) DEFAULT NULL,
  `url2` varchar(255) DEFAULT NULL,
  `url3` varchar(255) DEFAULT NULL,
  `url4` varchar(255) DEFAULT NULL,
  `url5` varchar(255) DEFAULT NULL,
  `ms` text,
  `kc` int DEFAULT NULL COMMENT '库存',
  `zk` int DEFAULT NULL COMMENT '折扣',
  `category_id_one` int DEFAULT NULL COMMENT '类别id',
  `category_id_two` int DEFAULT NULL COMMENT '类别2级',
  `isDelete` int DEFAULT NULL COMMENT '0否 1是',
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (27,'盖碗牡丹茶杯360ml八宝茶宁夏盖碗茶具','30',999,874,'/test1_war_exploded\\resource\\ueditor\\upload\\92ffe4d0c51d11eccb2a4c0d8aa2a373gaiwan1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\930032f0c51d11eccb2a4c0d8aa2a373gaiwan2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\93008110c51d11eccb2a4c0d8aa2a373gaiwan3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\9300a820c51d11eccb2a4c0d8aa2a373gaiwan4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\9300f640c51d11eccb2a4c0d8aa2a373gaiwan5.jpg','<ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\"><li><p style=\"line-height: 2em;\"><span style=\"font-size: 24px;\">超大360口径</span></p></li><li><p style=\"line-height: 2em;\"><span style=\"font-size: 24px;\">直径125mm</span></p></li><li><p style=\"line-height: 2em;\"><span style=\"font-size: 24px;\">高度105mm</span></p></li></ul>',999,6,112,113,0),(28,'宁夏杞里香枸杞子特优级500g罐装包装一斤中宁红构杞','45.8',19,996,'/test1_war_exploded\\resource\\ueditor\\upload\\a3c055d0c51c11eccb2a4c0d8aa2a373gouqi1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c07ce0c51c11eccb2a4c0d8aa2a373gouqi2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c0a3f0c51c11eccb2a4c0d8aa2a373gouqi3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c0f210c51c11eccb2a4c0d8aa2a373gouqi4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c0f211c51c11eccb2a4c0d8aa2a373gouqi5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/87e63550c51c11eccb2a4c0d8aa2a373gouqims1.jpg\" width=\"501\" height=\"1161\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/87ec01b0c51c11eccb2a4c0d8aa2a373gouqims2.jpg\" width=\"503\" height=\"994\"/></p><p><br/></p>',1197,9,96,97,0),(29,'宁夏杞里香枸杞萌吉吉杯340ml创意卡哇伊茶杯','59.6',432,9294,'/test1_war_exploded\\resource\\ueditor\\upload\\3cbca3e0c51a11eccb2a4c0d8aa2a373shuibei1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3cbccaf0c51a11eccb2a4c0d8aa2a373shuibei2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3cbcf200c51a11eccb2a4c0d8aa2a373shuibei3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3cbd1910c51a11eccb2a4c0d8aa2a373shuibei4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3cbd4020c51a11eccb2a4c0d8aa2a373shuibei5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/3590b3e0c51a11eccb2a4c0d8aa2a373ms.jpg\" title=\"\" alt=\"ms.jpg\" width=\"488\" height=\"1045\"/></p>',1099,9,75,76,0),(30,'罐罐茶煮茶器纯紫铜手工锤纹茶壶炭炉火茶具烤茶罐','168',85,2939,'/test1_war_exploded\\resource\\ueditor\\upload\\50517cb0c53c11eccb2a4c0d8aa2a373guanguancha.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\5051f1e0c53c11eccb2a4c0d8aa2a373guan2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\50528e20c53c11eccb2a4c0d8aa2a373guan3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\50530350c53c11eccb2a4c0d8aa2a373guan4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\50539f90c53c11eccb2a4c0d8aa2a373guan5.jpg','<p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 24px; font-family: 楷体, 楷体_GB2312, SimKai;\">传承工艺 匠心之作</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">遵循传统手工捶点技艺，</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">以独具一格的“古法造型、精雕细琢</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">形神兼备、兼收并蓄”的手工特色</span></p><p style=\"white-space: normal;\"><br/></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 24px; font-family: 楷体, 楷体_GB2312, SimKai;\">纯铜器美 复古质朴</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">每一件器具都是有温度的，经过匠人的手，</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">层层制作出来，器美而质朴古拙，</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">届时品茶论道，别有一番风味</span></p><p style=\"white-space: normal;\"><br/></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 24px; font-family: 楷体, 楷体_GB2312, SimKai;\">美器盈室 可养身心</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">一盏清茶，让生活多一份惬意，心归于静。</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">茶遇好器，如美人在侧，</span></p><p style=\"white-space: normal; line-height: normal;\"><span style=\"font-size: 18px; font-family: 楷体, 楷体_GB2312, SimKai;\">满室生香，茶香撩人</span></p>',221,9,112,113,0),(31,'八宝茶 宁夏特产 银川三炮台兰州盖碗茶枸杞桂圆红枣三炮台小袋装','69',101,2837,'/test1_war_exploded\\resource\\ueditor\\upload\\c9a87bd0c51511eccb2a4c0d8aa2a373babao1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\c9a8f100c51511eccb2a4c0d8aa2a373babao2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\c9a91810c51511eccb2a4c0d8aa2a373babao3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\c9a93f20c51511eccb2a4c0d8aa2a373babao4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\c9a96630c51511eccb2a4c0d8aa2a373babao5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/722400f0c51511eccb2a4c0d8aa2a373ms1.jpg\" width=\"385\" height=\"829\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/722bf030c51511eccb2a4c0d8aa2a373ms2.jpg\" width=\"386\" height=\"710\"/></p><p><br/></p>',333,7,96,97,0),(32,'随机发 宁夏博物馆贺兰山岩画金属书签套装','39',266,1267,'/test1_war_exploded\\resource\\ueditor\\upload\\d499a0d0c30a11ecca8d7a28a500d7ccit2_1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d49a1600c30a11ecca8d7a28a500d7ccit2_2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d49a6420c30a11ecca8d7a28a500d7ccit2_3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d49ad950c30a11ecca8d7a28a500d7ccit2_4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d49b4e80c30a11ecca8d7a28a500d7ccit2_5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/a8dd7de0c30a11ecca8d7a28a500d7ccit2_ms1.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/acbbf090c30a11ecca8d7a28a500d7ccit2ms2.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/b0166630c30a11ecca8d7a28a500d7ccit2ms3.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/c64e9210c30a11ecca8d7a28a500d7ccit2_ms4.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/c9c2f850c30a11ecca8d7a28a500d7ccit2ms5.jpg\"/></p><p><br/></p>',199,9,102,104,0),(33,'宁夏博物馆贺兰山岩画金属卡口书签学生精美文创纪念品','58',145,1374,'/test1_war_exploded\\resource\\ueditor\\upload\\5c7fe3d0c30911ecca8d7a28a500d7ccit1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\5c800ae0c30911ecca8d7a28a500d7cci2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\5c808010c30911ecca8d7a28a500d7cci3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\5c80a720c30911ecca8d7a28a500d7cci4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\5c80ce30c30911ecca8d7a28a500d7cci5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/474551d0c30911ecca8d7a28a500d7ccms1.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/4a70a120c30911ecca8d7a28a500d7ccms2.jpg\"/></p><p><br/></p>',199,10,102,104,0),(34,'小红军木制夜灯纪念品旅游周边','96.8',232,1287,'/test1_war_exploded\\resource\\ueditor\\upload\\e8ff8510c30711ecca8d7a28a500d7cci31.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\e8fffa40c30711ecca8d7a28a500d7cci32.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\e9006f70c30711ecca8d7a28a500d7cci33.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\e900bd90c30711ecca8d7a28a500d7cci34.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\e9010bb0c30711ecca8d7a28a500d7cci35.jpg','<p style=\"line-height: 1.5em;\"><span style=\"font-family: 黑体, SimHei; font-size: 20px; border: 1px solid rgb(0, 0, 0);\">产品内部以河山长城草地为背景，</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-family: 黑体, SimHei; font-size: 20px; border: 1px solid rgb(0, 0, 0);\">表面以行走中的小红军为主，</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-family: 黑体, SimHei; font-size: 20px; border: 1px solid rgb(0, 0, 0);\">展现出小红军不怕艰辛，励志前行的精神。</span></p><p style=\"line-height: 1.5em;\"><span style=\"font-family: 黑体, SimHei; font-size: 20px; border: 1px solid rgb(0, 0, 0);\"><img src=\"/test1_war_exploded/resource/ueditor/upload/b4bc87f0c30511ecca8d7a28a500d7cci3ms3.jpg\" alt=\"i3ms3.jpg\"/></span></p>',500,9,73,74,0),(35,'创意卡通收纳盒','14.5',421,1500,'/test1_war_exploded\\resource\\ueditor\\upload\\afa846a0c30011ecca8d7a28a500d7cci2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\afa894c0c30011ecca8d7a28a500d7cci2_2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\afa8bbd0c30011ecca8d7a28a500d7cci2_3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\afa909f0c30011ecca8d7a28a500d7cci2_4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\afa93100c30011ecca8d7a28a500d7cci2_5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/87daea10c30011ecca8d7a28a500d7cci2ms1.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/8b45b360c30011ecca8d7a28a500d7cci2_ms2.jpg\" width=\"744\" height=\"972\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/8e782ea0c30011ecca8d7a28a500d7cci2ms3.jpg\"/></p><p><br/></p>',666,9,73,74,0),(36,'小红军马口铁冰箱贴磁铁套装 红色文化文创纪念品','35',346,1305,'/test1_war_exploded\\resource\\ueditor\\upload\\fe3a1f70c2f911ecca8d7a28a500d7cc07ffe84d6dfc8e69e9c29752c6fc3bc.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\fe3a94a0c2f911ecca8d7a28a500d7cca9b1276e9dbb4ebb4a16bbbdd4a339b.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\fe3abbb0c2f911ecca8d7a28a500d7ccb2f9bd7df1b59317df74c4230a464fe.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\fe3ae2c0c2f911ecca8d7a28a500d7ccurl1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\fe3b09d0c2f911ecca8d7a28a500d7ccurl3.jpg','<p style=\"text-align: center\"><img src=\"/test1_war_exploded/resource/ueditor/upload/ca21dbd0c2f711ecca8d7a28a500d7cc5a97134975f6746145f0b2bbf48e67d.jpg\"/></p><p style=\"text-align: center\"><img src=\"/test1_war_exploded/resource/ueditor/upload/ca22ed40c2f711ecca8d7a28a500d7ccms.jpg\"/></p><p><br/></p>',1795,10,73,74,0),(37,'原创明信片《城市漫游 银川》宁夏手绘插画旅行纪念','2.5',91,1530,'/test1_war_exploded\\resource\\ueditor\\upload\\3b1ac050d07611ec2780b33642e9f202mingxinp.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3b1b3580d07611ec2780b33642e9f202xy.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3b1bd1c0d07611ec2780b33642e9f202mingxinp.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3b1c1fe0d07611ec2780b33642e9f202xy.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\3b1c6e00d07611ec2780b33642e9f202mingxinp.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/927588b0c52911eccb2a4c0d8aa2a373mingxinp.jpg\" title=\"\" alt=\"mingxinp.jpg\" width=\"653\" height=\"721\"/></p>',114,10,75,114,0),(38,'10张大话西游明信片随机《大话西游》取景地 宁夏旅游','14.9',999,2342,'/test1_war_exploded\\resource\\ueditor\\upload\\583a63d0c52b11eccb2a4c0d8aa2a373dhxy.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\583ad900c52b11eccb2a4c0d8aa2a373','/test1_war_exploded\\resource\\ueditor\\upload\\583b0010c52b11eccb2a4c0d8aa2a373','/test1_war_exploded\\resource\\ueditor\\upload\\583b2720c52b11eccb2a4c0d8aa2a373','/test1_war_exploded\\resource\\ueditor\\upload\\583b7540c52b11eccb2a4c0d8aa2a373','<p style=\"line-height: 2em;\"><span style=\"font-size: 18px;\">镇北堡西部影视城拥有更加浓郁的西部元素和地域风情，古朴与粗犷并存，给人一种“塞外风沙犹自寒”的感觉。如果打卡拍照，尤其是身着古装，能拍出许多自然山水中无法逾越的大片，所以很值得年轻人或亲子游客前往。这里也是周星驰和朱茵合作的著名电影《大话西游》的取景地之一。</span></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/18fbe630c52b11eccb2a4c0d8aa2a373dhxy2.jpg\" title=\"\" alt=\"dhxy2.jpg\" width=\"823\" height=\"600\"/></p>',99,10,75,114,0),(39,'回民自制油香10个装','29.4',283,3834,'/test1_war_exploded\\resource\\ueditor\\upload\\be721a70d07611ec2780b33642e9f202item_url1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\be728fa0d07611ec2780b33642e9f202item_url2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\be732be0d07611ec2780b33642e9f202item_url3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\be73a110d07611ec2780b33642e9f202item_url4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\be741640d07611ec2780b33642e9f202item_url5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/b4a6c770d07611ec2780b33642e9f202item_ms1.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/b4a7b1d0d07611ec2780b33642e9f202item_ms2.jpg\"/></p><p><br/></p>',500,10,96,100,0),(40,'宁夏特产手工馓子油炸粗甜味咸味早点早餐真空气泡袋包装包邮','29.9',113,1000,'/test1_war_exploded\\resource\\ueditor\\upload\\d9538600d11911ec324de7dd963ceb81item2_url1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d9542240d11911ec324de7dd963ceb81item2_url2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d9547060d11911ec324de7dd963ceb81item2_url3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d954be80d11911ec324de7dd963ceb81item2_url4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\d95533b0d11911ec324de7dd963ceb81item2_url5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/ba11a970d11911ec324de7dd963ceb81item2_ms1.jpg\" title=\"\" alt=\"item2_ms1.jpg\" width=\"1\" height=\"1\"/></p><p>油馓子</p>',599,10,96,100,0),(41,'宁夏博物馆贺兰山岩画亚麻帆布包女士学生通勤通用大容量送礼时尚 45 帆布包','45',210,274,'/test1_war_exploded\\resource\\ueditor\\upload\\a3c08fa0d11f11ec324de7dd963ceb81item6_url1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c0b6b0d11f11ec324de7dd963ceb81item6_url2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c104d0d11f11ec324de7dd963ceb81item6_url3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c104d1d11f11ec324de7dd963ceb81item6_url4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\a3c152f0d11f11ec324de7dd963ceb81item6_url5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/9c4a9e50d11f11ec324de7dd963ceb81item6_ms1.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/9f0e0410d11f11ec324de7dd963ceb81item6_ms2.jpg\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/a1b94df0d11f11ec324de7dd963ceb81item6_ms3.jpg\"/></p><p><br/></p>',788,7,102,107,0),(42,'正品夏进纯牛奶24瓶装243ml成长儿童孕妇中老年学生早餐营养纯奶','90.8',1233,2783,'/test1_war_exploded\\resource\\ueditor\\upload\\0ac39790d11d11ec324de7dd963ceb81item4_url1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\0ac3e5b0d11d11ec324de7dd963ceb81item4_url2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\0ac433d0d11d11ec324de7dd963ceb81item4_url3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\0ac45ae0d11d11ec324de7dd963ceb81item4_url4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\0ac481f0d11d11ec324de7dd963ceb81item4_url5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/f87c54f0d11c11ec324de7dd963ceb81item4_ms1.jpg\" title=\"\" alt=\"item4_ms1.jpg\"/></p>',223,9,96,98,0),(43,'宁夏博物馆一马当先钥匙扣挂件可爱卡通金属书包学生情侣精美文创','39',274,695,'/test1_war_exploded\\resource\\ueditor\\upload\\714a1fb0d11e11ec324de7dd963ceb81item5_url1.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\714a94e0d11e11ec324de7dd963ceb81item5_url2.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\714ae300d11e11ec324de7dd963ceb81item5_url3.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\714b7f40d11e11ec324de7dd963ceb81item5_url4.jpg','/test1_war_exploded\\resource\\ueditor\\upload\\714bf470d11e11ec324de7dd963ceb81item5_url5.jpg','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/22130a60d11e11ec324de7dd963ceb81item5_ms1.jpg\" title=\"undefined\" alt=\"item5_ms1.jpg\" width=\"513\" height=\"1555\"/><img src=\"/test1_war_exploded/resource/ueditor/upload/221aab80d11e11ec324de7dd963ceb81item5_ms2.jpg\" alt=\"item5_ms2.jpg\" width=\"502\" height=\"1332\"/></p>',226,10,75,81,0);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_category`
--

DROP TABLE IF EXISTS `item_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_category` (
  `ic_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `isDelete` int DEFAULT NULL,
  PRIMARY KEY (`ic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_category`
--

LOCK TABLES `item_category` WRITE;
/*!40000 ALTER TABLE `item_category` DISABLE KEYS */;
INSERT INTO `item_category` VALUES (50,' 礼帽',44,1),(71,'红色记忆',NULL,1),(72,'测试类别',71,1),(73,'主题系列',NULL,0),(74,'红色记忆',73,0),(75,'纪念文创',NULL,0),(76,'水杯',75,0),(77,'书签',75,0),(78,'嘎拉',75,1),(79,'纪念衫',75,0),(80,'新年福袋',NULL,1),(81,'钥匙扣',75,0),(83,'粒子',NULL,1),(96,'特产食品',NULL,0),(97,'茶',96,0),(98,'奶制品',96,0),(99,'咖啡',96,0),(100,'休闲零食',96,0),(101,'百货',NULL,1),(102,'博物馆联名',NULL,0),(103,'文具',102,1),(104,'贺兰山岩画',102,0),(105,'西夏王朝',102,0),(106,'丝路印象',102,0),(107,'帆布袋',102,0),(108,'宁夏有礼',NULL,1),(112,'宁夏有礼',NULL,0),(113,'器具',112,0),(114,'明信片',75,0);
/*!40000 ALTER TABLE `item_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_order`
--

DROP TABLE IF EXISTS `item_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `item_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `addTime` datetime DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  `isDelete` int DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '0待发货 1已取消  2已发货 3已收货',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_order`
--

LOCK TABLES `item_order` WRITE;
/*!40000 ALTER TABLE `item_order` DISABLE KEYS */;
INSERT INTO `item_order` VALUES (34,NULL,16,'2022041908420001','2022-04-19 08:42:27','49.41',0,1),(35,NULL,16,'2022041922130001','2022-04-19 22:13:22','79.86',0,1),(36,NULL,16,'2022042010230001','2022-04-20 10:23:59','25.20',0,2),(37,NULL,31,'2022042415490001','2022-04-24 15:49:51','13.06',0,1),(38,NULL,31,'2022042511170001','2022-04-25 11:17:08','13.06',0,3),(39,NULL,31,'2022042515260001','2022-04-25 15:26:22','122.23',0,0),(40,NULL,31,'2022042615340001','2022-04-26 15:34:10','453.60',0,3),(41,NULL,51,'2022050921130001','2022-05-09 21:13:45','175.00',0,3),(42,NULL,51,'2022050921260001','2022-05-09 21:26:05','206.10',0,1),(43,NULL,50,'2022051011070001','2022-05-10 11:07:38','71.65',0,3),(44,NULL,50,'2022051023210001','2022-05-10 23:21:53','10.00',0,3),(45,NULL,50,'2022051111530001','2022-05-11 11:53:54','5.00',0,3),(46,NULL,47,'2022051120500001','2022-05-11 20:50:20','31.50',0,0),(47,NULL,47,'2022051121500001','2022-05-11 21:50:38','78.00',0,3),(48,NULL,47,'2022051123010001','2022-05-11 23:01:29','181.10',0,3),(49,NULL,47,'2022051214160001','2022-05-12 14:16:14','96.60',0,1),(50,NULL,47,'2022051214490001','2022-05-12 14:49:24','123.66',0,3);
/*!40000 ALTER TABLE `item_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manage`
--

DROP TABLE IF EXISTS `manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manage` (
  `mid` int NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manage`
--

LOCK TABLES `manage` WRITE;
/*!40000 ALTER TABLE `manage` DISABLE KEYS */;
INSERT INTO `manage` VALUES (1,'admin','111111','管理员');
/*!40000 ALTER TABLE `manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `msg_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (6,'阿狸爱吃桃子','17104535133','希望网站的功能能更加完善！'),(7,'铁酱酱酱','15743956920','喜欢这个这个网站！'),(8,'Naa...','13540625731','看起来还不错哦'),(9,'设计视觉','13965991727','有兴趣讨论下合作嘛'),(10,'设计师联盟','18013206380','很喜欢这个界面风格！'),(11,'Giota','17097637828','支持城市文创，为你点赞'),(12,'宁夏博物馆','17097637828','我是一名博物馆产品策划员，有机会看到了你们的网站，感觉你的想法很好。期待我们后续会有更多合作。'),(13,'Helan','19969709485','我是一名创业者，我最近新推出了一款城市X咖啡联名的挂耳咖啡，不知道能否谈一下合作，想在你的平台上发布产品。'),(14,'pepper2097','18395111161','购物平台的功能有待继续完善'),(16,'DD','13409239987','**'),(17,'游客','18395111161','测试');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `item_id` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '0.未退货 1已退货2已评价',
  `num` int DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (54,27,27,0,1,'1'),(55,32,28,0,5,'25'),(56,27,28,0,3,'9'),(57,28,28,0,1,'1'),(58,35,29,0,2,'4'),(59,34,29,0,4,'16'),(60,32,29,0,3,'9'),(61,36,29,0,3,'9'),(62,32,29,0,2,'4'),(63,35,30,0,6,'36'),(64,30,30,0,3,'9'),(65,28,31,0,4,'16'),(66,28,31,0,2,'4'),(67,28,32,0,1,'1'),(68,28,33,0,1,'1'),(69,27,34,0,1,'49.41'),(70,29,35,1,1,'39.93'),(71,29,35,1,1,'39.93'),(72,31,36,0,1,'25.2'),(73,35,37,1,1,'13.06'),(74,35,38,0,1,'13.06'),(75,34,39,0,1,'87.12'),(76,32,39,0,1,'35.11'),(77,30,40,0,3,'453.59999999999997'),(78,36,41,0,5,'175.0'),(79,28,42,0,5,'206.1'),(80,29,43,2,1,'53.65'),(81,27,43,2,1,'18.0'),(82,37,44,2,4,'10.0'),(83,37,45,2,2,'5.0'),(84,41,46,0,1,'31.5'),(85,43,47,2,2,'78.0'),(86,30,48,0,1,'151.2'),(87,40,48,2,1,'29.9'),(88,31,49,1,2,'96.6'),(89,28,50,2,3,'123.66');
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `post_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `addTime` datetime DEFAULT NULL,
  `events_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `status` int DEFAULT NULL COMMENT '帖子状态\\n0待发布1已发布2活动结束',
  `reviewStatus` int DEFAULT NULL COMMENT '审核状态\n0未审核\n1已审核',
  `isDelete` int DEFAULT NULL COMMENT '0否 1是',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'四月之声','四月之声','2022-04-24 15:49:51',1,31,2,0,1),(5,'设计美学','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/5afff880c3e311eccddde57b1480d245微信图片_20220424211659.jpg\" title=\"\" alt=\"微信图片_20220424211659.jpg\" width=\"423\" height=\"304\"/></p>','2022-04-24 23:29:55',1,31,2,1,0),(7,'产品包装','<p>hhh<br/></p>','2022-04-25 11:11:54',1,31,2,0,1),(8,'四月之声','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/bf5d6800c44511ec8ae5329a104cbd5c大理古城2.jpg\" title=\"大理古城2.jpg\" alt=\"大理古城2.jpg\" width=\"500\" height=\"430\"/></p>','2022-04-25 11:15:23',1,31,2,1,0),(9,'大美敦煌——书签设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/1e3b26c0c53e11eccb2a4c0d8aa2a37307edc4d89d114ef38227dad337e0410.jpg\" title=\"07edc4d89d114ef38227dad337e0410.jpg\" alt=\"07edc4d89d114ef38227dad337e0410.jpg\" width=\"500\" height=\"430\"/></p>','2022-04-26 16:56:10',2,31,1,1,0),(10,'Option B咖啡|商霖品牌','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/cb0366f0cf9411ece0a21ca1b15802afcafe1.jpg\" title=\"cafe1.jpg\" alt=\"cafe1.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-09 20:37:50',3,51,1,1,0),(11,'木几茶饮品牌及包装设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/d5c29a60cf9511ece0a21ca1b15802afcafe2.jpg\" title=\"cafe2.jpg\" alt=\"cafe2.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-09 20:45:22',3,51,1,1,0),(12,'SRAT+COFFEE|0号设计选手','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/3d3975f0cf9711ece0a21ca1b15802afcafe3.jpg\" width=\"500\" height=\"430\" title=\"\" alt=\"\"/></p><p><img src=\"/test1_war_exploded/resource/ueditor/upload/3d3a3940cf9711ece0a21ca1b15802afcafe4.jpg\" width=\"500\" height=\"430\" title=\"\" alt=\"\"/></p><p><br/></p>','2022-05-09 20:55:42',3,51,1,1,0),(13,'敦煌博物馆','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/bea01a30d07411ec2780b33642e9f202敦煌博物馆.jpg\" title=\"敦煌博物馆.jpg\" alt=\"敦煌博物馆.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-10 23:20:53',5,50,1,1,0),(15,'小红军长征拼图纪念品','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/073a33a0d12611ec324de7dd963ceb81小红军长征拼图纪念品.jpg\" title=\"小红军长征拼图纪念品.jpg\" alt=\"小红军长征拼图纪念品.jpg\" width=\"500\" height=\"430\"/></p><p>DIY红色文化南昌起义文创纪念品产品</p>','2022-05-11 20:29:57',4,47,0,1,0),(16,'叻华点心——餐具设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/db728280d12611ec324de7dd963ceb81叻华点心——餐具设计.jpg\" title=\"叻华点心——餐具设计.jpg\" alt=\"叻华点心——餐具设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-11 20:36:29',2,47,0,0,0),(17,'木几茶饮品牌及包装设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/87492ea0d12811ec324de7dd963ceb81木几茶饮品牌及包装设计.jpg\" title=\"木几茶饮品牌及包装设计.jpg\" alt=\"木几茶饮品牌及包装设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-11 20:47:52',6,47,1,1,0),(18,'茶logo','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/31aac2c0d13111ec324de7dd963ceb81木几茶饮品牌及包装设计.jpg\" title=\"木几茶饮品牌及包装设计.jpg\" alt=\"木几茶饮品牌及包装设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-11 21:49:54',6,47,2,1,0),(19,'家乡年货','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/d69ac870d13611ec324de7dd963ceb81家乡年货.jpg\" title=\"家乡年货.jpg\" alt=\"家乡年货.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-11 22:30:33',2,46,1,1,0),(20,'之喜乳酸茶奶茶店logo设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/e5ccdf00d13a11ec324de7dd963ceb81之喜乳酸茶奶茶店logo设计.jpg\" title=\"之喜乳酸茶奶茶店logo设计.jpg\" alt=\"之喜乳酸茶奶茶店logo设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-11 22:59:22',6,47,1,1,0),(21,'测试','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/ee4f88f0d18811eca347d46b059f8318点心外包装设计.jpg\" title=\"点心外包装设计.jpg\" alt=\"点心外包装设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 08:18:00',7,47,2,1,0),(22,'黔东南苗绣X贵州省博物馆文创','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/97d6f670d1a111ece7e6bc91901716f2黔东南苗绣X贵州省博物馆文创.jpg\" title=\"黔东南苗绣X贵州省博物馆文创.jpg\" alt=\"黔东南苗绣X贵州省博物馆文创.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 11:14:28',5,46,1,1,0),(23,'色彩系统','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/262b93e0d1a211ece7e6bc91901716f2色彩系统.jpg\" title=\"色彩系统.jpg\" alt=\"色彩系统.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 11:18:28',8,46,1,1,0),(24,'门票设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/3bc053d0d1a211ece7e6bc91901716f2门票设计.jpg\" title=\"门票设计.jpg\" alt=\"门票设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 11:19:06',8,46,1,1,0),(25,'帆布袋设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/5d9907e0d1a211ece7e6bc91901716f2帆布袋设计.jpg\" title=\"帆布袋设计.jpg\" alt=\"帆布袋设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 11:20:03',8,46,0,0,0),(26,'日历书签设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/c4e2ae60d1a211ece7e6bc91901716f2日历书签设计.jpg\" title=\"日历书签设计.jpg\" alt=\"日历书签设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 11:23:06',8,31,1,1,0),(27,'其他纪念品设计','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/33352c80d1a311ece7e6bc91901716f2其他纪念品设计.jpg\" title=\"其他纪念品设计.jpg\" alt=\"其他纪念品设计.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 11:26:02',8,51,1,1,0),(28,'番鬼凉茶LOGO','<p><img src=\"/test1_war_exploded/resource/ueditor/upload/be6dac20d1bf11ec22712f31471b80d0番鬼凉茶LOGO.jpg\" title=\"番鬼凉茶LOGO.jpg\" alt=\"番鬼凉茶LOGO.jpg\" width=\"500\" height=\"430\"/></p>','2022-05-12 14:50:25',6,47,1,1,0);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sc`
--

DROP TABLE IF EXISTS `sc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sc` (
  `sc_id` int NOT NULL AUTO_INCREMENT,
  `item_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sc`
--

LOCK TABLES `sc` WRITE;
/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
INSERT INTO `sc` VALUES (17,27,3),(18,28,3),(19,30,16),(28,35,31),(29,36,31),(32,29,31),(33,36,51),(34,29,50),(35,37,50),(36,40,51),(37,40,50),(38,36,47),(39,41,47),(40,43,47),(42,30,47),(43,31,47),(44,28,47);
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `passWord` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (31,'pepper2097','d66d24d5376236eb8184391949af4df3964ad0182f705f29','18395111161','佩波','女','银川市贺兰山路1000号','pepper@sohu.com'),(43,'Alex','Alex12345','17104535133','艾利克斯','男','富民路222号','17104535133@126.com'),(46,'Alice','f5dc9206b250199f4828c71e03c127f2845ff6875fb66706','15743956920','爱丽丝','女','北京路2938号','15743956920@163.com'),(47,'Helen123','11157457e607d1fd40860f30e5c25163fa8f789371d3e291','13540625731','海伦','女','上海市浦东新区蓝天路21号','13540625731@126.com'),(50,'test','286075d4cf8938d99799e50b74827a35904525f82885cb62','15309785632','泰斯特','男','曹路镇上川路995号','2249234123@qq.com'),(51,'Pepper','52591344244884439f99b88c83e17b06c93649f291a97104','18667899909','佩珀','女','上川路995号','pepper@sina.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'shop'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-24 22:43:42
