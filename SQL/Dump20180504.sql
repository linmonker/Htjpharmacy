CREATE DATABASE  IF NOT EXISTS `hjtzyg` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hjtzyg`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hjtzyg
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `hjt_access`
--

DROP TABLE IF EXISTS `hjt_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_access` (
  `roleid` int(11) DEFAULT NULL COMMENT 'hjt_role.id',
  `useableid` int(11) DEFAULT NULL COMMENT 'hjt_useable'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_access`
--

LOCK TABLES `hjt_access` WRITE;
/*!40000 ALTER TABLE `hjt_access` DISABLE KEYS */;
INSERT INTO `hjt_access` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(1,51),(1,52),(1,53),(1,54),(1,55),(1,56),(1,57),(1,58),(1,59),(1,60),(1,61),(1,62),(1,63),(1,64),(1,65),(1,66),(1,67),(1,68),(1,69),(1,70),(1,71),(1,72),(1,73),(1,74),(1,75),(1,76),(2,1),(2,2),(2,3),(2,6),(2,9),(2,10),(2,13),(2,16),(2,17),(2,18),(2,19),(2,20),(2,21),(2,22),(2,23),(2,24),(2,25),(2,26),(2,27),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),(2,39),(2,40),(2,41),(2,42),(2,43),(2,44),(2,45),(2,46),(2,47),(2,50),(2,53),(2,54),(2,57),(2,60),(3,1),(3,2),(3,3),(3,6),(3,9),(3,10),(3,13),(3,16),(3,17),(3,18),(3,21),(3,24),(3,25),(3,28),(3,31),(3,32),(3,35),(3,38),(3,39),(3,40),(3,47),(3,50),(3,53),(3,54),(3,57),(3,60),(4,1),(4,2),(4,3),(4,6),(4,9),(4,10),(4,13),(4,16),(4,17),(4,18),(4,21),(4,24),(4,25),(4,28),(4,31),(4,32),(4,35),(4,38),(4,39),(4,40),(4,47),(4,50),(4,53),(4,54),(4,57),(4,60),(4,61),(4,62),(4,63),(4,64),(4,65),(4,66),(4,67),(4,68),(5,1),(5,2),(5,3),(5,6),(5,9),(5,10),(5,13),(5,16),(5,17),(5,18),(5,21),(5,24),(5,25),(5,28),(5,31),(5,32),(5,35),(5,38),(5,39),(5,40),(5,47),(5,50),(5,53),(5,54),(5,57),(5,60),(1,77),(1,78),(1,79),(1,80),(1,81),(1,82),(1,83),(1,84),(1,85),(1,86),(2,79),(2,80),(2,81),(2,82),(4,85),(5,77),(5,78),(5,79),(5,80),(5,81),(5,82),(5,83),(5,84),(5,85);
/*!40000 ALTER TABLE `hjt_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_cangku`
--

DROP TABLE IF EXISTS `hjt_cangku`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_cangku` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `fdid` int(20) DEFAULT '0' COMMENT '分店ID',
  `ckbh` varchar(50) DEFAULT NULL COMMENT '仓库编号 每个分店唯一',
  `ckmc` varchar(50) DEFAULT NULL COMMENT '仓库名称',
  `ckmcjp` varchar(50) DEFAULT NULL COMMENT '仓库名称简拼',
  `ckbz` text COMMENT '仓库备注信息',
  `zt` int(1) DEFAULT '0' COMMENT '仓库状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '删除状态 0:正常 1：已删除',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `ckbh` (`ckbh`,`jtid`,`fdid`),
  KEY `idxjtidfdid` (`jtid`,`fdid`),
  KEY `mcjp` (`ckmcjp`),
  KEY `fdid` (`fdid`),
  CONSTRAINT `FK_hjt_cangku` FOREIGN KEY (`fdid`) REFERENCES `hjt_fendian` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_cangku`
--

LOCK TABLES `hjt_cangku` WRITE;
/*!40000 ALTER TABLE `hjt_cangku` DISABLE KEYS */;
INSERT INTO `hjt_cangku` VALUES (1,1,1,'CK0001','一号店一号仓库','yhdyhck','我是一号店一号仓库',0,0),(2,1,1,'CK0002','一号店二号仓库','yhdehck','我是一号店二号仓库',0,0),(3,1,1,'CK0103','一号店三号仓库','yhdshck','我是一号店三号仓库',0,0),(4,1,1,'CK0104','一号店四号仓库','yhdshck','我是一号店四号仓库',0,0),(5,1,1,'CK0105','一号店五号仓库','yhdwhck','我是一号店五号仓库',0,0),(6,1,1,'CK0106','一号店六号仓库','yhdlhck','我是一号店六号仓库',0,0),(7,1,1,'CK0107','一号店七号仓库','yhdqhck','我是一号店七号仓库',0,0),(8,1,1,'CK0108','一号店八号仓库','yhdbhck','我是一号店八号仓库',0,0),(9,1,1,'CK0109','一号店九号仓库','yhdjhck','我是一号店九号仓库',0,0),(10,1,1,'CK0110','一号店十号仓库','yhdshck','我是一号店十号仓库',0,0),(11,1,2,'CK0201','二号店一号仓库','ehdyhck','我是二号店一号仓库',0,0),(12,1,2,'CK0202','二号店二号仓库','ehdehck','我是二号店二号仓库',0,0),(13,1,2,'CK0203','二号店三号仓库','ehdshck','我是二号店三号仓库',0,0),(14,1,2,'CK0204','二号店四号仓库','ehdshck','我是二号店四号仓库',0,0),(15,1,2,'CK0205','二号店五号仓库','ehdwhck','我是二号店五号仓库',0,0),(16,1,2,'CK0206','二号店六号仓库','ehdlhck','我是二号店六号仓库',0,0),(17,1,3,'CK0301','三号店一号仓库','shdyhck','我是三号店一号仓库',0,0),(18,1,3,'CK0302','三号店二号仓库','shdehck','我是三号店二号仓库',0,0),(19,1,3,'CK0303','三号店三号仓库','shdshck','我是三号店三号仓库',0,0),(20,1,3,'CK0304','三号店四号仓库','shdshck','我是三号店四号仓库',0,0),(21,1,3,'CK0305','三号店五号仓库','shdwhck','我是三号店五号仓库',0,0);
/*!40000 ALTER TABLE `hjt_cangku` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_cangku_huowei`
--

DROP TABLE IF EXISTS `hjt_cangku_huowei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_cangku_huowei` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `fdid` int(20) DEFAULT '0' COMMENT '分店ID',
  `ckid` int(20) DEFAULT NULL COMMENT '所属仓库ID',
  `hwbh` varchar(50) DEFAULT NULL COMMENT '货位编号同一仓库唯一',
  `hwmc` varchar(50) DEFAULT NULL COMMENT '货位名称',
  `hwmcjp` varchar(50) DEFAULT NULL COMMENT '货位名称简拼',
  `hwbz` text COMMENT '货位备注信息',
  `zt` int(1) DEFAULT '0' COMMENT '货位状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '货位删除状态 0：正常 1：已删除',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `hwbh` (`hwbh`,`jtid`,`fdid`,`ckid`),
  KEY `jtid` (`jtid`,`fdid`),
  KEY `ckid` (`ckid`),
  KEY `hwmcjp` (`hwmcjp`),
  KEY `dm` (`dm`),
  KEY `zt` (`zt`),
  KEY `fdid` (`fdid`),
  CONSTRAINT `FK_hjt_cangku_huowei` FOREIGN KEY (`fdid`) REFERENCES `hjt_fendian` (`Id`),
  CONSTRAINT `hjt_cangku_huowei_hjt_cangku_fk` FOREIGN KEY (`ckid`) REFERENCES `hjt_cangku` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_cangku_huowei`
--

LOCK TABLES `hjt_cangku_huowei` WRITE;
/*!40000 ALTER TABLE `hjt_cangku_huowei` DISABLE KEYS */;
INSERT INTO `hjt_cangku_huowei` VALUES (1,1,1,1,'HW0101001','一号店一号仓库一号货位','yhdyhckyhhw','我是一号店一号仓库一号货位',0,0),(2,1,1,1,'HW0101002','一号店一号仓库二号货位','yhdyhckehhw','我是一号店一号仓库二号货位',0,0),(3,1,1,1,'HW0101003','一号店一号仓库三号货位','yhdyhckshhw','我是一号店一号仓库三号货位',0,0),(4,1,1,1,'HW0101004','一号店一号仓库四号货位','yhdyhckshhw','我是一号店一号仓库四号货位',0,0),(5,1,1,1,'HW0101005','一号店一号仓库五号货位','yhdyhckwhhw','我是一号店一号仓库五号货位',0,0),(6,1,1,1,'HW0101006','一号店一号仓库六号货位','yhdyhcklhhw','我是一号店一号仓库六号货位',0,0),(7,1,1,1,'HW0101007','一号店一号仓库七号货位','yhdyhckqhhw','我是一号店一号仓库七号货位',0,0),(8,1,1,1,'HW0101008','一号店一号仓库八号货位','yhdyhckbhhw','我是一号店一号仓库八号货位',0,0),(9,1,1,1,'HW0101009','一号店一号仓库九号货位','yhdyhckjhhw','我是一号店一号仓库九号货位',0,0),(10,1,1,2,'HW0102001','一号店二号仓库一号货位','yhdehckyhhw','我是一号店二号仓库一号货位',0,0),(11,1,1,2,'HW0102002','一号店二号仓库二号货位','yhdehckehhw','我是一号店二号仓库二号货位',0,0),(12,1,1,2,'HW0102003','一号店二号仓库三号货位','yhdehckshhw','我是一号店二号仓库三号货位',0,0),(13,1,1,2,'HW0102004','一号店二号仓库四号货位','yhdehckshhw','我是一号店二号仓库四号货位',0,0),(14,1,1,2,'HW0102005','一号店二号仓库五号货位','yhdehckwhhw','我是一号店二号仓库五号货位',0,0),(15,1,1,3,'HW0103001','一号店三号仓库一号货位','yhdshckyhhw','我是一号店三号仓库一号货位',0,0),(16,1,1,3,'HW0103002','一号店三号仓库二号货位','yhdshckehhw','我是一号店三号仓库二号货位',0,0),(17,1,1,4,'HW0104001','一号店四号仓库一号货位','yhdshckyhhw','我是一号店四号仓库一号货位',0,0),(18,1,1,4,'HW0104002','一号店四号仓库二号货位','yhdshckehhw','我是一号店四号仓库二号货位',0,0),(19,1,2,11,'HW0201001','二号店一号仓库一号货位','ehdyhckyhhw','我是二号店一号仓库一号货位',0,0),(20,1,2,11,'HW0201002','二号店一号仓库二号货位','ehdyhckehhw','我是二号店一号仓库二号货位',0,0),(21,1,2,12,'HW0202001','二号店二号仓库一号货位','ehdehckyhhw','我是二号店二号仓库一号货位',0,0),(22,1,2,12,'HW0202002','二号店二号仓库二号货位','ehdehckehhw','我是二号店二号仓库二号货位',0,0),(23,1,3,17,'HW0301001','三号店一号仓库一号货位','shdyhckyhhw','我是三号店一号仓库一号货位',0,0),(24,1,3,17,'HW0301002','三号店一号仓库二号货位','shdyhckehhw','我是三号店一号仓库二号货位',0,0),(25,1,3,18,'HW0302001','三号店二号仓库一号货位','shdehckyhhw','我是三号店二号仓库一号货位',0,0),(26,1,3,18,'HW0302002','三号店二号仓库二号货位','shdehckehhw','我是三号店二号仓库二号货位',0,0);
/*!40000 ALTER TABLE `hjt_cangku_huowei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_fendian`
--

DROP TABLE IF EXISTS `hjt_fendian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_fendian` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `fdbh` varchar(20) DEFAULT NULL COMMENT '分店编号',
  `fdmc` varchar(50) DEFAULT NULL COMMENT '分店名称',
  `fddz` varchar(150) DEFAULT NULL COMMENT '分店地址',
  `fdlxdh` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `fddzxm` varchar(20) DEFAULT NULL COMMENT '店长姓名',
  `fdbz` text COMMENT '分店备注信息',
  `zt` int(1) DEFAULT '0' COMMENT '分店状态 0：正常 1：已删除',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `idxfdbh` (`fdbh`,`jtid`),
  KEY `idxjtid` (`jtid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_fendian`
--

LOCK TABLES `hjt_fendian` WRITE;
/*!40000 ALTER TABLE `hjt_fendian` DISABLE KEYS */;
INSERT INTO `hjt_fendian` VALUES (1,1,'FD0001','济南中心店','济南市市中区36号','0531-25806775','李明','我是济南中心店我在济南市市中区36号',0),(2,1,'FD0002','济南历下二号店','济南市历城区12号','0531-80386142','张强','我是济南历下二号店我在济南市历城区12号',0),(3,1,'FD0003','济南槐荫店','济南市槐荫区15号','0531-44510417','张克','我是济南槐荫店我在济南市槐荫区15号',0),(4,1,'FD0004','济南章丘店','济南市章丘区32号','0531-61393649','赵东云','我是济南章丘店我在济南市章丘区32号',0),(5,1,'FD0005','济南章丘二号店','济南市历城区425号','0531-73437008','吴宏','我是济南章丘二号店我在济南市历城区425号',0),(6,1,'FD0006','济南历城二号店','济南市历城区1425号','0531-83004106','黄德','我是济南历城二号店我在济南市历城区1425号',0),(7,1,'FD0007','济南历城三号店','济南市历城区10号','0531-94709517','刘峰','我是济南历城三号店我在济南市历城区10号',0),(8,1,'FD0008','济南历城店','济南市历城区425号','0531-34535291','苏季','我是济南历城店我在济南市历城区425号',0),(9,1,'FD0009','济南市中区二号店','济南市市中区425号','0531-58547884','王图','我是济南市中区二号店我在济南市市中区425号',0),(10,1,'FD0010','济南天桥区二号店','济南市天桥区355号','0531-89133561','孙复','我是济南天桥区二号店我在济南市天桥区355号',0),(11,1,'Fd4565465','测试分店','测试地址','14555555555','测试人','这是测试',1);
/*!40000 ALTER TABLE `hjt_fendian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_gongyingshang`
--

DROP TABLE IF EXISTS `hjt_gongyingshang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_gongyingshang` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `fdid` int(11) DEFAULT '0' COMMENT '分店ID',
  `gysbh` varchar(50) DEFAULT NULL COMMENT '供应商编号同一集团唯一',
  `gysmc` varchar(150) DEFAULT NULL COMMENT '供应商名称',
  `gysmcjp` varchar(100) DEFAULT NULL COMMENT '供应商名称简拼',
  `gyslxdh` varchar(50) DEFAULT NULL COMMENT '供应商电话',
  `gyslxr` varchar(50) DEFAULT NULL COMMENT '供应商联系人',
  `gysxxdz` varchar(250) DEFAULT NULL COMMENT '供应商详细地址',
  `gysywy` varchar(50) DEFAULT NULL COMMENT '业务员',
  `gysywydh` varchar(50) DEFAULT NULL COMMENT '业务员电话',
  `gysywysfz` varchar(50) DEFAULT NULL COMMENT '业务员身份证',
  `gysyzbm` varchar(50) DEFAULT NULL COMMENT '邮政编码',
  `gyslyxdz` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `gysyyzz` varchar(50) DEFAULT NULL COMMENT '营业执照',
  `gysyyzzqx` date DEFAULT NULL COMMENT '营业执照期限',
  `gysyyzzfzrq` date DEFAULT NULL COMMENT '营业执照发证日期',
  `gysfrdb` varchar(50) DEFAULT NULL COMMENT '法人代表',
  `gysjyxz` varchar(150) DEFAULT NULL COMMENT '经营性质',
  `gyszczb` varchar(50) DEFAULT NULL COMMENT '供应商注册资本',
  `gysjyfs` varchar(50) DEFAULT NULL COMMENT '供应商经营方式',
  `gysjyfw` text COMMENT '经营范围',
  `gysscjyxkz` varchar(50) DEFAULT NULL COMMENT '生产经营许可证编号',
  `gysxkzmc` varchar(150) DEFAULT NULL COMMENT '许可证名称',
  `gysxkzdz` varchar(250) DEFAULT NULL COMMENT '许可证地址',
  `gysxkzbh` varchar(50) DEFAULT NULL COMMENT '许可证编号',
  `gysxkzfzdw` varchar(50) DEFAULT NULL COMMENT '许可证发证单位',
  `gysxkzyxq` date DEFAULT NULL COMMENT '许可证有效期',
  `gysxkzfzrq` date DEFAULT NULL COMMENT '许可证发证日期',
  `gysgspzj` varchar(50) DEFAULT NULL COMMENT '供应商GSP证件号码',
  `gysgspfzr` varchar(50) DEFAULT NULL COMMENT 'GSP证件负责人',
  `gysgspzjyxq` date DEFAULT NULL COMMENT 'GSP证件有效期至',
  `gysinfo1` varchar(250) DEFAULT NULL COMMENT '扩展字段1',
  `gysinfo2` varchar(250) DEFAULT NULL COMMENT '扩展字段2',
  `gysbz` text COMMENT '备注信息',
  `zt` int(1) DEFAULT '0' COMMENT '状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '删除状态 0：正常 1：已删除',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `jtid` (`jtid`,`gysbh`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_gongyingshang`
--

LOCK TABLES `hjt_gongyingshang` WRITE;
/*!40000 ALTER TABLE `hjt_gongyingshang` DISABLE KEYS */;
INSERT INTO `hjt_gongyingshang` VALUES (1,1,1,'GYS0101','山东泉港药业有限公司','sdqgyyyxgs','0525-80024176','张白','济南市浆水泉路225号','张白','13324764552','328056197610035810','129609','sdqgyyyxgs@hjt.com','a11c1d60a517dce464','2031-01-19','2011-01-19','张白','个人独资性质','9440000','自产自销','药品生产，销售','67cbeb894c2c02cc4e','药品流通许可证','济南市浆水泉路225号','30eeeade67423f353d','济南市工商局','2031-01-19','2011-01-19','bd3b9ebce26e3df73c','张白','2031-01-19','aaa','bbb','我是山东泉港药业有限公司我在济南市浆水泉路225号',0,0),(2,1,1,'GYS0102','山东金泰生物工程有限公司','sdjtswgcyxgs','0525-32720209','张祥修','山东省济南洪家楼西路29号','潘牛泰','16161783775','316602198802123521','162060','sdjtswgcyxgs@hjt.com','16672b2be1e3c2ed8e','2032-05-26','2012-05-26','张祥修','个人独资性质','1370000','自产自销','药品生产，销售','cf0e13edd492e5f21d','药品流通许可证','山东省济南洪家楼西路29号','b3be43947bdc420a39','济南市工商局','2032-05-26','2012-05-26','c8f646861e9d9358ca','张祥修','2032-05-26',NULL,NULL,'我是山东金泰生物工程有限公司我在山东省济南洪家楼西路29号',0,0),(3,1,1,'GYS0103','山东瑞博德制药有限公司','sdrbdzyyxgs','0525-93528498','俞律永','济南市高新开发区济南出口加工区A区7号','莫高俊','13834625463','350649199102024891','121473','sdrbdzyyxgs@hjt.com','ecd23461f55b53c414','2033-12-05','2013-12-05','俞律永','个人独资性质','8500000','自产自销','药品生产，销售','047609330a60a78ce4','药品流通许可证','济南市高新开发区济南出口加工区A区7号','c23a93037e73a7bb79','济南市工商局','2033-12-05','2013-12-05','4d37d694a309e8d659','俞律永','2033-12-05',NULL,NULL,'我是山东瑞博德制药有限公司我在济南市高新开发区济南出口加工区A区7号',0,0),(4,1,1,'GYS0104','广饶县明祥工贸有限公司','grxmxgmyxgs','0525-89481895','李琛凡','东营市李楼工业园','李琛凡','17687776237','373609197111136477','121184','grxmxgmyxgs@hjt.com','935b00f164a50c090c','2032-07-29','2012-07-29','李琛凡','个人独资性质','8380000','自产自销','药品生产，销售','26e38d2ee6d48f82ac','药品流通许可证','东营市李楼工业园','95083b1eb845017dc7','济南市工商局','2032-07-29','2012-07-29','a067e50eaf9894b9df','李琛凡','2032-07-29',NULL,NULL,'我是广饶县明祥工贸有限公司我在东营市李楼工业园',0,0),(5,1,1,'GYS0105','山东新大精细化工有限公司','sdxdjxhgyxgs','0525-66823995','王秀凌','淄博市桓台县新城镇驻地','何拥羿','11935005040','311184197306256468','141501','sdxdjxhgyxgs@hjt.com','37e0740260631ff7bf','2031-02-02','2011-02-02','王秀凌','个人独资性质','6400000','自产自销','药品生产，销售','d06b0326a967c744ee','药品流通许可证','淄博市桓台县新城镇驻地','031e48528080a42e09','济南市工商局','2031-02-02','2011-02-02','f2df5a3e4d422561d2','王秀凌','2031-02-02',NULL,NULL,'我是山东新大精细化工有限公司我在淄博市桓台县新城镇驻地',0,0),(6,1,1,'GYS0106','山东洁晶药业有限公司','sdjjyyyxgs','0525-55674291','骆厚彩','山东省日照市富阳路39号','余太汇','11611696736','367262197309082855','143954','sdjjyyyxgs@hjt.com','62265f49287d2b6f7e','2032-08-23','2012-08-23','骆厚彩','个人独资性质','6840000','自产自销','药品生产，销售','c052d408f6fc597a29','药品流通许可证','山东省日照市富阳路39号','362c141833811a1abf','济南市工商局','2032-08-23','2012-08-23','6cbcfeb04f0d0503ea','骆厚彩','2032-08-23',NULL,NULL,'我是山东洁晶药业有限公司我在山东省日照市富阳路39号',0,0),(7,1,1,'GYS0107','沂水恒源胶业有限公司','yshyjyyxgs','0525-67899473','尤晶志','沂水县一中路28号','邢宙谦','11253468805','378932197108303782','195265','yshyjyyxgs@hjt.com','06ffa7714c77fbfd40','2030-02-03','2010-02-03','尤晶志','个人独资性质','4970000','自产自销','药品生产，销售','3a5f7b239a1e141c5c','药品流通许可证','沂水县一中路28号','55b5d0b86ddf16e5a7','济南市工商局','2030-02-03','2010-02-03','c95bc8e5ec84fdaece','尤晶志','2030-02-03',NULL,NULL,'我是沂水恒源胶业有限公司我在沂水县一中路28号',0,0),(8,1,1,'GYS0108','日照鲁信金禾生化有限公司','rzlxjhshyxgs','0525-72474505','许熹贤','山东省日照市兴海路西段','许熹贤','18432254061','358509197803175671','144460','rzlxjhshyxgs@hjt.com','db2323b9051f913f85','2032-05-20','2012-05-20','许熹贤','个人独资性质','4320000','自产自销','药品生产，销售','fd3d2528d651a40dca','药品流通许可证','山东省日照市兴海路西段','bd853c705110776f3e','济南市工商局','2032-05-20','2012-05-20','aed4df74b019e845de','许熹贤','2032-05-20',NULL,NULL,'我是日照鲁信金禾生化有限公司我在山东省日照市兴海路西段',0,0),(9,1,1,'GYS0109','莒县蔚蓝气体有限公司','zxwlqtyxgs','0525-58674118','雷昂班','莒县县城莒州路62号','杨诚理','15400864136','369497198308191851','136508','zxwlqtyxgs@hjt.com','cddd6a05cb6e8e750e','2031-10-15','2011-10-15','雷昂班','个人独资性质','6690000','自产自销','药品生产，销售','9854ee0ec2fb933a41','药品流通许可证','莒县县城莒州路62号','33e70ede0a7fffb57a','济南市工商局','2031-10-15','2011-10-15','8394350f109706841d','雷昂班','2031-10-15',NULL,NULL,'我是莒县蔚蓝气体有限公司我在莒县县城莒州路62号',0,0),(10,1,1,'GYS0110','文登市明胶厂','wdsmjc','0525-65947079','陈盛依','文登市张家产镇邹家床村','刘彤窍','18707558744','329963199109064947','149158','wdsmjc@hjt.com','b10b59c1b0e3407503','2031-10-10','2011-10-10','陈盛依','个人独资性质','470000','自产自销','药品生产，销售','f506ec109d44deba0d','药品流通许可证','文登市张家产镇邹家床村','a15e60468a81271c60','济南市工商局','2031-10-10','2011-10-10','9ce07f32887f85c0fc','陈盛依','2031-10-10',NULL,NULL,'我是文登市明胶厂我在文登市张家产镇邹家床村',0,0),(11,1,2,'GYS0201','威海华洋药业有限公司','whhyyyyxgs','0525-53713052','何江津','山东省文登市环山路121号','林炎延','12335201556','370575199012186100','136268','whhyyyyxgs@hjt.com','5f452da3bf80a2230e','2033-07-04','2013-07-04','何江津','个人独资性质','2250000','自产自销','药品生产，销售','66e91b5917f7a1e72d','药品流通许可证','山东省文登市环山路121号','8e3eba7dac8c5634f4','济南市工商局','2033-07-04','2013-07-04','9d47b8fadaeabec503','何江津','2033-07-04',NULL,NULL,'我是威海华洋药业有限公司我在山东省文登市环山路121号',0,0),(12,1,2,'GYS0202','威海永康明胶有限公司','whykmjyxgs','0525-60724026','王贤孝','威海市平度路28号','王贤孝','18553331792','347022199004014763','133863','whykmjyxgs@hjt.com','6b81be70d36722125a','2032-05-08','2012-05-08','王贤孝','个人独资性质','9850000','自产自销','药品生产，销售','e05b5569f229150c4e','药品流通许可证','威海市平度路28号','4186368b7fdeba248e','济南市工商局','2032-05-08','2012-05-08','ca51707e07fc282f53','王贤孝','2032-05-08',NULL,NULL,'我是威海永康明胶有限公司我在威海市平度路28号',0,0),(13,1,2,'GYS0203','威海仁济中药饮片厂','whrjzyypc','0525-42480984','孟年细','威海经济技术开发区浦东路5-1号','孟年细','12761054540','376205197706106549','160511','whrjzyypc@hjt.com','1281875220f8fd3283','2031-03-25','2011-03-25','孟年细','个人独资性质','2470000','自产自销','药品生产，销售','7d78ce5a39adf7be72','药品流通许可证','威海经济技术开发区浦东路5-1号','86e2e8c46300dfe143','济南市工商局','2031-03-25','2011-03-25','3433997b8a72a1ba33','孟年细','2031-03-25',NULL,NULL,'我是威海仁济中药饮片厂我在威海经济技术开发区浦东路5-1号',0,0),(14,1,2,'GYS0204','山东新大精细化工有限公司','sdxdjxhgyxgs','0525-20232845','涂丁妙','淄博市桓台县新城镇驻地','章惠良','13145277570','336738199307025696','100964','sdxdjxhgyxgs@hjt.com','d962f6fe5abdba4011','2034-01-05','2014-01-05','涂丁妙','个人独资性质','2800000','自产自销','药品生产，销售','05c942cde532697543','药品流通许可证','淄博市桓台县新城镇驻地','fbada8aaf6633e0c59','济南市工商局','2034-01-05','2014-01-05','dd0d2fe33bc28f2187','涂丁妙','2034-01-05',NULL,NULL,'我是山东新大精细化工有限公司我在淄博市桓台县新城镇驻地',0,0),(15,1,2,'GYS0205','山东鲁维制药有限公司','sdlwzyyxgs','0525-53721266','袁傲翘','淄博市淄川区双凤工业园','廖申','16443224473','311483197911089127','123287','sdlwzyyxgs@hjt.com','9d6c2d7f1c82fb9c6c','2031-08-04','2011-08-04','袁傲翘','个人独资性质','6550000','自产自销','药品生产，销售','a69ebae9e6a5aa6ac3','药品流通许可证','淄博市淄川区双凤工业园','2f9c34ef2f5f4c1598','济南市工商局','2031-08-04','2011-08-04','2fea07612df115a3e5','袁傲翘','2031-08-04',NULL,NULL,'我是山东鲁维制药有限公司我在淄博市淄川区双凤工业园',0,0),(16,1,2,'GYS0206','山东益康药业股份有限公司','sdykyygfyxgs','0525-17907816','陶天冠','滕州市益康大道3288号','岑若峙','15780289901','336707197402286894','113543','sdykyygfyxgs@hjt.com','8464f4c38cb68b9995','2030-11-04','2010-11-04','陶天冠','个人独资性质','4330000','自产自销','药品生产，销售','cb1b8adabd8b908351','药品流通许可证','滕州市益康大道3288号','42711dd6c9d4277370','济南市工商局','2030-11-04','2010-11-04','6f384cfdcceb59e7e5','陶天冠','2030-11-04',NULL,NULL,'我是山东益康药业股份有限公司我在滕州市益康大道3288号',0,0),(17,1,2,'GYS0207','山东蓝金生物工程有限公司','sdljswgcyxgs','0525-98375263','罗研固','济南市高新区天辰路1750号','盛财牧','18571776331','376450198611085336','197853','sdljswgcyxgs@hjt.com','32b98133c43a7154cb','2034-05-13','2014-05-13','罗研固','个人独资性质','1990000','自产自销','药品生产，销售','d287902a722061d470','药品流通许可证','济南市高新区天辰路1750号','17173616675ef27f8f','济南市工商局','2034-05-13','2014-05-13','fbec8227ceab69006f','罗研固','2034-05-13',NULL,NULL,'我是山东蓝金生物工程有限公司我在济南市高新区天辰路1750号',0,0),(18,1,3,'GYS0301','沂水恒源胶业有限公司','yshyjyyxgs','0525-68152913','孙问光','沂水县一中路28号','陈珐羿','18518012196','35487519850111929','148637','yshyjyyxgs@hjt.com','2aae412a338f6a867d','2034-07-02','2014-07-02','孙问光','个人独资性质','6940000','自产自销','药品生产，销售','e643c086a8a0998b0e','药品流通许可证','沂水县一中路28号','aae23af03e7bc20399','济南市工商局','2034-07-02','2014-07-02','fa6ad3dbdcf30e612c','孙问光','2034-07-02',NULL,NULL,'我是沂水恒源胶业有限公司我在沂水县一中路28号',0,0),(19,1,3,'GYS0302','日照鲁信金禾生化有限公司','rzlxjhshyxgs','0525-35638774','汤瑰操','山东省日照市兴海路西段','穆悟清','17874732233','35584119941022134','149625','rzlxjhshyxgs@hjt.com','d11adbeff37fe4ee26','2034-06-25','2014-06-25','汤瑰操','个人独资性质','8720000','自产自销','药品生产，销售','40881747124c77d258','药品流通许可证','山东省日照市兴海路西段','2660629307502cf164','济南市工商局','2034-06-25','2014-06-25','c6c1f3c93dc422db7b','汤瑰操','2034-06-25',NULL,NULL,'我是日照鲁信金禾生化有限公司我在山东省日照市兴海路西段',0,0),(20,1,4,'GYS0401','山东金泰生物工程有限公司','sdjtswgcyxgs','0525-53735127','米亦巧','山东省济南洪家楼西路29号','佟双文','14819624823','315605197812235604','102214','sdjtswgcyxgs@hjt.com','ec57cb077ab5b1fd33','2033-12-21','2013-12-21','米亦巧','个人独资性质','2770000','自产自销','药品生产，销售','51791cb95c0c7202ed','药品流通许可证','山东省济南洪家楼西路29号','64cda08f395aaba399','济南市工商局','2033-12-21','2013-12-21','b109b27d8a7a38c49c','米亦巧','2033-12-21',NULL,NULL,'我是山东金泰生物工程有限公司我在山东省济南洪家楼西路29号',0,0),(21,1,4,'GYS0402','山东新大精细化工有限公司','sdxdjxhgyxgs','0525-61759325','颜若云','淄博市桓台县新城镇驻地','侨锐思','17473927661','360671199305035110','162193','sdxdjxhgyxgs@hjt.com','d0d2628d0c9c45590a','2031-06-26','2011-06-26','颜若云','个人独资性质','7660000','自产自销','药品生产，销售','a5d0e18d9c85bdace3','药品流通许可证','淄博市桓台县新城镇驻地','7bd6bf5db7be703b9d','济南市工商局','2031-06-26','2011-06-26','06d94935e9d69d172f','颜若云','2031-06-26',NULL,NULL,'我是山东新大精细化工有限公司我在淄博市桓台县新城镇驻地',0,0),(22,1,5,'GYS0501','莒县蔚蓝气体有限公司','zxwlqtyxgs','0525-47591254','纪鸿云','莒县县城莒州路62号','荀任真','15910764081','362338197501307755','104325','zxwlqtyxgs@hjt.com','13db1bce8ad95ca6d4','2030-06-07','2010-06-07','纪鸿云','个人独资性质','9960000','自产自销','药品生产，销售','c92c5250a6a6cb9990','药品流通许可证','莒县县城莒州路62号','cf0deb91d2b0969ad7','济南市工商局','2030-06-07','2010-06-07','6e4f4ce54e4624dc8d','纪鸿云','2030-06-07',NULL,NULL,'我是莒县蔚蓝气体有限公司我在莒县县城莒州路62号',0,0),(23,1,5,'GYS0502','山东瑞博德制药有限公司','sdrbdzyyxgs','0525-42678300','孟甫遥','济南市高新开发区济南出口加工区A区7号','孟甫遥','16132037667','328862197006202847','135045','sdrbdzyyxgs@hjt.com','dc481c2acfedebaf92','2032-08-19','2012-08-19','孟甫遥','个人独资性质','6840000','自产自销','药品生产，销售','e0a81f60b2cfe3e5f4','药品流通许可证','济南市高新开发区济南出口加工区A区7号','ed0e5dab15c08bbc08','济南市工商局','2032-08-19','2012-08-19','cdbac88b481bfdb741','孟甫遥','2032-08-19',NULL,NULL,'我是山东瑞博德制药有限公司我在济南市高新开发区济南出口加工区A区7号',0,0),(24,1,6,'GYS0601','山东淄博山川药业有限公司','sdzbscyyyxgs','0525-60617737','廉谓菁','淄博市淄川区山川路88号','廉谓菁','13927896339','335810199408218368','162248','sdzbscyyyxgs@hjt.com','c79de470e286228381','2032-01-06','2012-01-06','廉谓菁','个人独资性质','4290000','自产自销','药品生产，销售','5d40d65a278066c4e2','药品流通许可证','淄博市淄川区山川路88号','784451e47ef54b48de','济南市工商局','2032-01-06','2012-01-06','d50d448a97334eefad','廉谓菁','2032-01-06',NULL,NULL,'我是山东淄博山川药业有限公司我在淄博市淄川区山川路88号',0,0),(25,1,6,'GYS0602','山东舜生堂中药饮片有限公司','sdsstzyypyxgs','0525-75053799','王泰行','鄄城县彭楼镇（舜王城中药科技园）','王泰行','18243368938','325530198411103161','106103','sdsstzyypyxgs@hjt.com','9c50afe6887202df14','2032-02-29','2012-02-29','王泰行','个人独资性质','900000','自产自销','药品生产，销售','cf02334a7d3d1ce0d7','药品流通许可证','鄄城县彭楼镇（舜王城中药科技园）','ebf3fd2e36349e2d06','济南市工商局','2032-02-29','2012-02-29','f9eb4aa827e080e6ef','王泰行','2032-02-29',NULL,NULL,'我是山东舜生堂中药饮片有限公司我在鄄城县彭楼镇（舜王城中药科技园）',0,0),(26,1,7,'GYS0701','山东鲁北药业有限公司','sdlbyyyxgs','0525-93415794','池弈维','山东省沾化县城中心路1145号','王华伯','14433155920','365478197005066903','143774','sdlbyyyxgs@hjt.com','ea73d691488aa4b5a2','2034-10-06','2014-10-06','池弈维','个人独资性质','1620000','自产自销','药品生产，销售','5ca11c52dbbfeef155','药品流通许可证','山东省沾化县城中心路1145号','cff3dbcc49172df9b5','济南市工商局','2034-10-06','2014-10-06','2e8472d416a2f34ac2','池弈维','2034-10-06',NULL,NULL,'我是山东鲁北药业有限公司我在山东省沾化县城中心路1145号',0,0),(27,1,7,'GYS0702','山东瑞博德制药有限公司','sdrbdzyyxgs','0525-51917597','谭宜茗','济南市高新开发区济南出口加工区A区7号','沈圭毅','14435673032','338945199410147323','100558','sdrbdzyyxgs@hjt.com','3840ca0d6faced029d','2032-07-17','2012-07-17','谭宜茗','个人独资性质','5380000','自产自销','药品生产，销售','c559b3c762e8597581','药品流通许可证','济南市高新开发区济南出口加工区A区7号','73eed99e49f5c18d9f','济南市工商局','2032-07-17','2012-07-17','be64a16a13c4ec9c75','谭宜茗','2032-07-17',NULL,NULL,'我是山东瑞博德制药有限公司我在济南市高新开发区济南出口加工区A区7号',0,0),(28,1,8,'GYS0801','山东金泰生物工程有限公司','sdjtswgcyxgs','0525-59340593','赵努应','山东省济南洪家楼西路29号','涂朗书','17878897644','357663197502149838','171469','sdjtswgcyxgs@hjt.com','74766357e523154284','2033-05-06','2013-05-06','赵努应','个人独资性质','2050000','自产自销','药品生产，销售','c50bc21128bd951520','药品流通许可证','山东省济南洪家楼西路29号','9bd57879b87da9c514','济南市工商局','2033-05-06','2013-05-06','a8fdc1682334258d6f','赵努应','2033-05-06',NULL,NULL,'我是山东金泰生物工程有限公司我在山东省济南洪家楼西路29号',0,0),(29,1,8,'GYS0802','山东淄博山川药业有限公司','sdzbscyyyxgs','0525-40950189','俞方钧','淄博市淄川区山川路88号','邓竞御','11087469370','331511198407049884','155670','sdzbscyyyxgs@hjt.com','b36b5fc6d232bfe63a','2034-03-03','2014-03-03','俞方钧','个人独资性质','4090000','自产自销','药品生产，销售','00d9054f00e4b922ed','药品流通许可证','淄博市淄川区山川路88号','a0b454c9f4f21ddac1','济南市工商局','2034-03-03','2014-03-03','44c3e61d868c7ba6da','俞方钧','2034-03-03',NULL,NULL,'我是山东淄博山川药业有限公司我在淄博市淄川区山川路88号',0,0),(30,1,9,'GYS0901','山东舜生堂中药饮片有限公司','sdsstzyypyxgs','0525-16729167','于晨菲','鄄城县彭楼镇（舜王城中药科技园）','费熙胜','14800654162','323982197010095544','163943','sdsstzyypyxgs@hjt.com','42148957b45e98532d','2030-12-15','2010-12-15','于晨菲','个人独资性质','4290000','自产自销','药品生产，销售','f1c0aecdbbe2efe05e','药品流通许可证','鄄城县彭楼镇（舜王城中药科技园）','097d25753a5e1d6707','济南市工商局','2030-12-15','2010-12-15','a42e6b4257b7e34033','于晨菲','2030-12-15',NULL,NULL,'我是山东舜生堂中药饮片有限公司我在鄄城县彭楼镇（舜王城中药科技园）',0,0),(31,1,9,'GYS0902','山东金泰生物工程有限公司','sdjtswgcyxgs','0525-40795261','余昱愿','山东省济南洪家楼西路29号','陈连鹏','13740862946','357744198807306810','152706','sdjtswgcyxgs@hjt.com','cd752f1c675a9f9258','2032-02-11','2012-02-11','余昱愿','个人独资性质','9180000','自产自销','药品生产，销售','60f524416f211371a3','药品流通许可证','山东省济南洪家楼西路29号','cf4e651cac24a15a24','济南市工商局','2032-02-11','2012-02-11','9bda58b52b4b06769a','余昱愿','2032-02-11',NULL,NULL,'我是山东金泰生物工程有限公司我在山东省济南洪家楼西路29号',0,0),(32,1,10,'GYS1001','山东淄博山川药业有限公司','sdzbscyyyxgs','0525-53788818','邱瑾鸣','淄博市淄川区山川路88号','孙悟廉','13302352491','322012199004045496','171699','sdzbscyyyxgs@hjt.com','8729c3f529165c5ce8','2032-10-09','2012-10-09','邱瑾鸣','个人独资性质','2980000','自产自销','药品生产，销售','c65bcf5bf1b97ce476','药品流通许可证','淄博市淄川区山川路88号','e2772e3e876a17e44b','济南市工商局','2032-10-09','2012-10-09','3b871ebf1e41b777b9','邱瑾鸣','2032-10-09',NULL,NULL,'我是山东淄博山川药业有限公司我在淄博市淄川区山川路88号',0,0),(33,1,10,'GYS1002','山东鲁北药业有限公司','sdlbyyyxgs','0525-46558318','王继隐','山东省沾化县城中心路1145号','樊生言','14289173860','331809199208116020','100378','sdlbyyyxgs@hjt.com','70448f3f8723494d2e','2032-08-05','2012-08-05','王继隐','个人独资性质','7380000','自产自销','药品生产，销售','cb5c2db82b13afbb0c','药品流通许可证','山东省沾化县城中心路1145号','689a73fd9162dc6384','济南市工商局','2032-08-05','2012-08-05','61ee12051b77a8f5fb','王继隐','2032-08-05',NULL,NULL,'我是山东鲁北药业有限公司我在山东省沾化县城中心路1145号',0,0);
/*!40000 ALTER TABLE `hjt_gongyingshang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_keshi`
--

DROP TABLE IF EXISTS `hjt_keshi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_keshi` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `fdid` int(11) DEFAULT '0' COMMENT '分店ID',
  `ksbh` varchar(50) DEFAULT NULL COMMENT '科室编号',
  `ksmc` varchar(50) DEFAULT NULL COMMENT '科室名称',
  `ksmcjp` varchar(50) DEFAULT NULL COMMENT '科室名称简拼',
  `kslxdh` varchar(50) DEFAULT NULL COMMENT '科室电话',
  `kszr` varchar(50) DEFAULT NULL COMMENT '科室主任',
  `ksbz` text COMMENT '科室备注信息',
  `zt` int(1) DEFAULT '0' COMMENT '状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '删除状态 0：正常 1：已删除',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `hjt_keshi_un` (`jtid`,`fdid`,`ksbh`,`ksmc`),
  KEY `jtid` (`jtid`,`fdid`),
  KEY `hjt_keshi_hjt_fendian_fk` (`fdid`),
  CONSTRAINT `hjt_keshi_hjt_fendian_fk` FOREIGN KEY (`fdid`) REFERENCES `hjt_fendian` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_keshi`
--

LOCK TABLES `hjt_keshi` WRITE;
/*!40000 ALTER TABLE `hjt_keshi` DISABLE KEYS */;
INSERT INTO `hjt_keshi` VALUES (1,1,1,'KS0101','内科','nk','0532-61425138','王刚','内科',0,0),(2,1,1,'KS0102','外科','wk','0532-67450749','刘瑜','外科',0,0),(3,1,1,'KS0103','儿科','ek','0532-52978344','范宇','儿科',0,0),(4,1,1,'KS0104','皮肤科','pfk','0532-52539472','余华','皮肤科',0,0),(5,1,1,'KS0105','五官科','wgk','0532-93762333','李虹宇','五官科',0,0),(6,1,1,'KS0106','保健养生','bjys','0532-31193282','冷昆雄','保健养生',0,0),(7,1,2,'KS0201','内科','nk','0532-44679390','乐静慧','内科',0,0),(8,1,2,'KS0202','外科','wk','0532-29817120','谢雪珍','外科',0,0),(9,1,2,'KS0203','儿科','ek','0532-95047420','翟茂典','儿科',0,0),(10,1,2,'KS0204','皮肤科','pfk','0532-15785785','宁听南','皮肤科',0,0),(11,1,2,'KS0205','五官科','wgk','0532-53786634','何觅云','五官科',0,0),(12,1,2,'KS0206','保健养生','bjys','0532-31575839','景骊洁','保健养生',0,0),(13,1,3,'KS0301','内科','nk','0532-76519285','郑鹏池','内科',0,0),(14,1,3,'KS0302','外科','wk','0532-97868931','潘乐和','外科',0,0),(15,1,3,'KS0303','儿科','ek','0532-69786822','岳安妮','儿科',0,0),(16,1,3,'KS0304','皮肤科','pfk','0532-45327318','和康德','皮肤科',0,0),(17,1,3,'KS0305','五官科','wgk','0532-97276116','孟曼','五官科',0,0),(18,1,3,'KS0306','保健养生','bjys','0532-70398658','倪典丽','保健养生',0,0),(19,1,4,'KS0401','内科','nk','0532-50164946','常又琴','内科',0,0),(20,1,4,'KS0402','外科','wk','0532-29628759','赫连文光','外科',0,0),(21,1,4,'KS0403','儿科','ek','0532-77648947','濮阳惜天','儿科',0,0),(22,1,4,'KS0404','皮肤科','pfk','0532-19358491','威淑雅','皮肤科',0,0),(23,1,4,'KS0405','五官科','wgk','0532-33845597','伊涵易','五官科',0,0),(24,1,4,'KS0406','保健养生','bjys','0532-11152524','典冷松','保健养生',0,0),(25,1,5,'KS0501','内科','nk','0532-34225822','牧忆远','内科',0,0),(26,1,5,'KS0502','外科','wk','0532-37671550','臧昕月','外科',0,0),(27,1,5,'KS0503','儿科','ek','0532-75680286','甘孤晴','儿科',0,0),(28,1,5,'KS0504','皮肤科','pfk','0532-75386801','迟安和','皮肤科',0,0),(29,1,5,'KS0505','五官科','wgk','0532-49893158','前雅柔','五官科',0,0),(30,1,5,'KS0506','保健养生','bjys','0532-13305393','莫采萱','保健养生',0,0),(31,1,6,'KS0601','内科','nk','0532-86847470','麻慕','内科',0,0),(32,1,6,'KS0602','外科','wk','0532-24321213','尚建义','外科',0,0),(33,1,6,'KS0603','儿科','ek','0532-31063637','纪宛秋','儿科',0,0),(34,1,6,'KS0604','皮肤科','pfk','0532-72354548','孙含海','皮肤科',0,0),(35,1,6,'KS0605','五官科','wgk','0532-78581853','仉绮烟','五官科',0,0),(36,1,6,'KS0606','保健养生','bjys','0532-75845633','瓮兴思','保健养生',0,0),(37,1,7,'KS0701','内科','nk','0532-43482616','杨幼白','内科',0,0),(38,1,7,'KS0702','外科','wk','0532-69876175','黄绮晴','外科',0,0),(39,1,7,'KS0703','儿科','ek','0532-28933048','颜晓蓝','儿科',0,0),(40,1,7,'KS0704','皮肤科','pfk','0532-15036708','苑珺俐','皮肤科',0,0),(41,1,7,'KS0705','五官科','wgk','0532-68384390','庚雁蓉','五官科',0,0),(42,1,7,'KS0706','保健养生','bjys','0532-16811856','郯昌盛','保健养生',0,0),(43,1,8,'KS0801','内科','nk','0532-48906094','肖紫萍','内科',0,0),(44,1,8,'KS0802','外科','wk','0532-94094913','邓鹏举','外科',0,0),(45,1,8,'KS0803','儿科','ek','0532-43756315','谌惜寒','儿科',0,0),(46,1,8,'KS0804','皮肤科','pfk','0532-16496831','冼明轩','皮肤科',0,0),(47,1,8,'KS0805','五官科','wgk','0532-31215200','威采南','五官科',0,0),(48,1,8,'KS0806','保健养生','bjys','0532-96585509','藩笑笑','保健养生',0,0),(49,1,9,'KS0901','内科','nk','0532-19281987','寒和雅','内科',0,0),(50,1,9,'KS0902','外科','wk','0532-66653379','鲁悠雅','外科',0,0),(51,1,9,'KS0903','儿科','ek','0532-85420957','百子惠','儿科',0,0),(52,1,9,'KS0904','皮肤科','pfk','0532-37144669','凌兴贤','皮肤科',0,0),(53,1,9,'KS0905','五官科','wgk','0532-99460458','臧浩思','五官科',0,0),(54,1,9,'KS0906','保健养生','bjys','0532-15868325','奚凝丹','保健养生',0,0),(55,1,10,'KS1001','内科','nk','0532-40960223','广晓莉','内科',0,0),(56,1,10,'KS1002','外科','wk','0532-57196151','邵小翠','外科',0,0),(57,1,10,'KS1003','儿科','ek','0532-63100101','墨瀚漠','儿科',0,0),(58,1,10,'KS1004','皮肤科','pfk','0532-43912063','冯鸿志','皮肤科',0,0),(59,1,10,'KS1005','五官科','wgk','0532-20260014','姚敬曦','五官科',0,0),(60,1,10,'KS1006','保健养生','bjys','0532-49563875','雷新晴','保健养生',0,0);
/*!40000 ALTER TABLE `hjt_keshi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_menu`
--

DROP TABLE IF EXISTS `hjt_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `jtid` int(11) NOT NULL DEFAULT '1' COMMENT '集团ID',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8 COMMENT='菜单管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_menu`
--

LOCK TABLES `hjt_menu` WRITE;
/*!40000 ALTER TABLE `hjt_menu` DISABLE KEYS */;
INSERT INTO `hjt_menu` VALUES (2,0,1,'首页','/index','index',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(3,1001,1,'分店列表','/fendian/list','fendian:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(4,1001,1,'添加分店','/fendian/add','fendian:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(5,1001,1,'执行添加分店','/fendian/doadd','fendian:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(6,1001,1,'查看修改','/fendian/edit','fendian:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(7,1001,1,'执行修改分店','/fendian/doedit','fendian:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(8,1001,1,'删除分店','/fendian/delete','fendian:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(9,1001,1,'搜索分店','/fendian/search','fendian:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(10,1002,1,'供应商列表','/gongyingshang/list','gongyingshang:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(11,1002,1,'添加供应商','/gongyingshang/add','gongyingshang:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(12,1002,1,'执行添加供应商','/gongyingshang/doadd','gongyingshang:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(13,1002,1,'查看修改','/gongyingshang/edit','gongyingshang:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(14,1002,1,'执行修改供应商','/gongyingshang/doedit','gongyingshang:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(15,1002,1,'删除供应商','/gongyingshang/delete','gongyingshang:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(16,1002,1,'搜索供应商','/gongyingshang/search','gongyingshang:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(17,1003,1,'仓库列表首页','/cangku/sylist','cangku:sylist',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(18,1003,1,'仓库列表','/cangku/list','cangku:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(19,1003,1,'添加仓库','/cangku/add','cangku:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(20,1003,1,'执行添加仓库','/cangku/doadd','cangku:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(21,1003,1,'查看修改','/cangku/edit','cangku:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(22,1003,1,'执行修改仓库','/cangku/doedit','cangku:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(23,1003,1,'删除仓库','/cangku/delete','cangku:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(24,1003,1,'搜索仓库','/cangku/search','cangku:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(25,1004,1,'货位列表','/huowei/list','huowei:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(26,1004,1,'添加货位','/huowei/add','huowei:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(27,1004,1,'执行添加货位','/huowei/doadd','huowei:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(28,1004,1,'查看修改','/huowei/edit','huowei:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(29,1004,1,'执行修改货位','/huowei/doedit','huowei:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(30,1004,1,'删除货位','/huowei/delete','huowei:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(31,1004,1,'搜索货位','/huowei/search','huowei:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(32,1005,1,'药品列表','/yaopin/list','yaopin:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(33,1005,1,'添加药品','/yaopin/add','yaopin:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(34,1005,1,'执行添加药品','/yaopin/doadd','yaopin:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(35,1005,1,'查看修改','/yaopin/edit','yaopin:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(36,1005,1,'执行修改药品','/yaopin/doedit','yaopin:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(37,1005,1,'删除药品','/yaopin/delete','yaopin:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(38,1005,1,'搜索药品','/yaopin/search','yaopin:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(39,1006,1,'药品分类列表','/yaopinfenlei/list','yaopinfenlei:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(40,1006,1,'获取药品分类列表','/yaopinfenlei/getlist','yaopinfenlei:getlist',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(41,1006,1,'添加药品分类','/yaopinfenlei/add','yaopinfenlei:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(42,1006,1,'执行添加药品分类','/yaopinfenlei/doadd','yaopinfenlei:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(43,1006,1,'修改名称','/yaopinfenlei/editname','yaopinfenlei:editname',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(44,1006,1,'查看修改','/yaopinfenlei/edit','yaopinfenlei:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(45,1006,1,'执行修改药品分类','/yaopinfenlei/doedit','yaopinfenlei:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(46,1006,1,'删除药品分类','/yaopinfenlei/delete','yaopinfenlei:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(47,1007,1,'科室列表','/keshi/list','keshi:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(48,1007,1,'添加科室','/keshi/add','keshi:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(49,1007,1,'执行添加科室','/keshi/doadd','keshi:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(50,1007,1,'查看修改','/keshi/edit','keshi:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(51,1007,1,'执行修改科室','/keshi/doedit','keshi:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(52,1007,1,'删除科室','/keshi/delete','keshi:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(53,1007,1,'搜索科室','/keshi/search','keshi:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(54,1008,1,'处室列表','/zuzhijigou/list','zuzhijigou:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(55,1008,1,'添加处室','/zuzhijigou/add','zuzhijigou:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(56,1008,1,'执行添加处室','/zuzhijigou/doadd','zuzhijigou:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(57,1008,1,'查看修改','/zuzhijigou/edit','zuzhijigou:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(58,1008,1,'执行修改处室','/zuzhijigou/doedit','zuzhijigou:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(59,1008,1,'删除处室','/zuzhijigou/delete','zuzhijigou:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(60,1008,1,'搜索处室','/zuzhijigou/search','zuzhijigou:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(61,1009,1,'用户列表首页','/yonghu/sylist','yonghu:sylist',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(62,1009,1,'用户列表','/yonghu/list','yonghu:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(63,1009,1,'添加用户','/yonghu/add','yonghu:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(64,1009,1,'执行添加用户','/yonghu/doadd','yonghu:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(65,1009,1,'查看修改','/yonghu/edit','yonghu:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(66,1009,1,'执行修改用户','/yonghu/doedit','yonghu:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(67,1009,1,'删除用户','/yonghu/delete','yonghu:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(68,1009,1,'搜索用户','/yonghu/search','yonghu:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(69,1010,1,'角色列表','/role/list','role:list',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(70,1010,1,'权限菜单列表','/role/menulist','role:menulist',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(71,1010,1,'添加角色','/role/add','role:add',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(72,1010,1,'执行添加角色','/role/doadd','role:doadd',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(73,1010,1,'查看修改','/role/edit','role:edit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(74,1010,1,'执行修改角色','/role/doedit','role:doedit',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(75,1010,1,'删除角色','/role/delete','role:delete',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(76,1010,1,'搜索角色','/role/search','role:search',NULL,NULL,NULL,'2018-04-27 15:30:30',NULL),(77,1001,1,'下载分店Excel','/fendian/download','fendian:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(78,1002,1,'下载供应商Excel','/gongyingshang/download','gongyingshang:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(79,1003,1,'下载仓库Excel','/cangku/download','cangku:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(80,1004,1,'下载货位Excel','/huowei/download','huowei:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(81,1005,1,'下载药品Excel','/yaopin/download','yaopin:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(82,1006,1,'下载药品分类Excel','/yaopinfenlei/download','yaopinfenlei:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(83,1007,1,'下载科室Excel','/keshi/download','keshi:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(84,1008,1,'下载处室Excel','/zuzhijigou/download','zuzhijigou:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(85,1009,1,'下载用户Excel','/yonghu/download','yonghu:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(86,1010,1,'下载角色Excel','/role/download','role:download',NULL,NULL,NULL,'2018-05-04 13:54:30',NULL),(1001,0,1,'分店管理','/fendian/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1002,0,1,'供应商管理','/gongyingshang/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1003,0,1,'仓库管理','/cangku/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1004,0,1,'货位管理','/huowei/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1005,0,1,'药品管理','/yaopin/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1006,0,1,'药品分类管理','/yaopinfenlei/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1007,0,1,'科室管理','/keshi/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1008,0,1,'处室管理','/zuzhijigou/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1009,0,1,'用户管理','/yonghu/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL),(1010,0,1,'角色管理','/role/**',NULL,NULL,NULL,NULL,'2018-04-27 15:38:11',NULL);
/*!40000 ALTER TABLE `hjt_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_role`
--

DROP TABLE IF EXISTS `hjt_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` text COMMENT '备注',
  `user_id_create` bigint(255) DEFAULT NULL COMMENT '创建用户id',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `zt` int(1) DEFAULT '0' COMMENT '状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '删除状态 0:正常 1：已删除',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_role`
--

LOCK TABLES `hjt_role` WRITE;
/*!40000 ALTER TABLE `hjt_role` DISABLE KEYS */;
INSERT INTO `hjt_role` VALUES (1,1,'系统管理员','系统管理员具备对系统进行设置，权限管理功能',1,'2018-02-05 09:02:52',NULL,0,0),(2,1,'仓库管理员','负责管理所属分店仓库',1,'2018-04-27 15:46:31',NULL,0,0),(3,1,'财务管理员','负责管理所属分店财务',1,'2018-04-27 15:46:31',NULL,0,0),(4,1,'人事管理员','负责管理所属分店人事',1,'2018-04-27 15:46:31',NULL,0,0),(5,1,'普通员工','仅限查看',1,'2018-04-27 15:48:07','2018-04-29 21:45:34',0,0),(6,1,'分店管理员','除角色管理外所有权限',1,'2018-04-27 15:48:07','2018-04-29 21:45:34',0,0);
/*!40000 ALTER TABLE `hjt_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_useable`
--

DROP TABLE IF EXISTS `hjt_useable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_useable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `useAble` varchar(250) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(200) DEFAULT NULL COMMENT 'URL',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `jtid` (`jtid`,`useAble`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_useable`
--

LOCK TABLES `hjt_useable` WRITE;
/*!40000 ALTER TABLE `hjt_useable` DISABLE KEYS */;
INSERT INTO `hjt_useable` VALUES (2,1,'首页','/index','2018-04-27 14:54:56',NULL),(3,1,'分店列表','/fendian/list','2018-04-27 14:54:56',NULL),(4,1,'添加分店','/fendian/add','2018-04-27 14:54:56',NULL),(5,1,'执行添加分店','/fendian/doadd','2018-04-27 14:54:56',NULL),(6,1,'查看修改','/fendian/edit','2018-04-27 14:54:56',NULL),(7,1,'执行修改分店','/fendian/doedit','2018-04-27 14:54:56',NULL),(8,1,'删除分店','/fendian/delete','2018-04-27 14:54:56',NULL),(9,1,'搜索分店','/fendian/search','2018-04-27 14:54:56',NULL),(10,1,'供应商列表','/gongyingshang/list','2018-04-27 14:54:56',NULL),(11,1,'添加供应商','/gongyingshang/add','2018-04-27 14:54:56',NULL),(12,1,'执行添加供应商','/gongyingshang/doadd','2018-04-27 14:54:56',NULL),(13,1,'查看修改','/gongyingshang/edit','2018-04-27 14:54:56',NULL),(14,1,'执行修改供应商','/gongyingshang/doedit','2018-04-27 14:54:56',NULL),(15,1,'删除供应商','/gongyingshang/delete','2018-04-27 14:54:56',NULL),(16,1,'搜索供应商','/gongyingshang/search','2018-04-27 14:54:56',NULL),(17,1,'仓库列表首页','/cangku/sylist','2018-04-27 14:54:56',NULL),(18,1,'仓库列表','/cangku/list','2018-04-27 14:54:56',NULL),(19,1,'添加仓库','/cangku/add','2018-04-27 14:54:56',NULL),(20,1,'执行添加仓库','/cangku/doadd','2018-04-27 14:54:56',NULL),(21,1,'查看修改','/cangku/edit','2018-04-27 14:54:56',NULL),(22,1,'执行修改仓库','/cangku/doedit','2018-04-27 14:54:56',NULL),(23,1,'删除仓库','/cangku/delete','2018-04-27 14:54:56',NULL),(24,1,'搜索仓库','/cangku/search','2018-04-27 14:54:56',NULL),(25,1,'货位列表','/huowei/list','2018-04-27 14:54:56',NULL),(26,1,'添加货位','/huowei/add','2018-04-27 14:54:56',NULL),(27,1,'执行添加货位','/huowei/doadd','2018-04-27 14:54:56',NULL),(28,1,'查看修改','/huowei/edit','2018-04-27 14:54:56',NULL),(29,1,'执行修改货位','/huowei/doedit','2018-04-27 14:54:56',NULL),(30,1,'删除货位','/huowei/delete','2018-04-27 14:54:56',NULL),(31,1,'搜索货位','/huowei/search','2018-04-27 14:54:56',NULL),(32,1,'药品列表','/yaopin/list','2018-04-27 14:54:56',NULL),(33,1,'添加药品','/yaopin/add','2018-04-27 14:54:56',NULL),(34,1,'执行添加药品','/yaopin/doadd','2018-04-27 14:54:56',NULL),(35,1,'查看修改','/yaopin/edit','2018-04-27 14:54:56',NULL),(36,1,'执行修改药品','/yaopin/doedit','2018-04-27 14:54:56',NULL),(37,1,'删除药品','/yaopin/delete','2018-04-27 14:54:56',NULL),(38,1,'搜索药品','/yaopin/search','2018-04-27 14:54:56',NULL),(39,1,'药品分类列表','/yaopinfenlei/list','2018-04-27 14:54:56',NULL),(40,1,'获取药品分类列表','/yaopinfenlei/getlist','2018-04-27 14:54:56',NULL),(41,1,'添加药品分类','/yaopinfenlei/add','2018-04-27 14:54:56',NULL),(42,1,'执行添加药品分类','/yaopinfenlei/doadd','2018-04-27 14:54:56',NULL),(43,1,'修改名称','/yaopinfenlei/editname','2018-04-27 14:54:56',NULL),(44,1,'查看修改','/yaopinfenlei/edit','2018-04-27 14:54:56',NULL),(45,1,'执行修改药品分类','/yaopinfenlei/doedit','2018-04-27 14:54:56',NULL),(46,1,'删除药品分类','/yaopinfenlei/delete','2018-04-27 14:54:56',NULL),(47,1,'科室列表','/keshi/list','2018-04-27 14:54:56',NULL),(48,1,'添加科室','/keshi/add','2018-04-27 14:54:56',NULL),(49,1,'执行添加科室','/keshi/doadd','2018-04-27 14:54:56',NULL),(50,1,'查看修改','/keshi/edit','2018-04-27 14:54:56',NULL),(51,1,'执行修改科室','/keshi/doedit','2018-04-27 14:54:56',NULL),(52,1,'删除科室','/keshi/delete','2018-04-27 14:54:56',NULL),(53,1,'搜索科室','/keshi/search','2018-04-27 14:54:56',NULL),(54,1,'处室列表','/zuzhijigou/list','2018-04-27 14:54:56',NULL),(55,1,'添加处室','/zuzhijigou/add','2018-04-27 14:54:56',NULL),(56,1,'执行添加处室','/zuzhijigou/doadd','2018-04-27 14:54:56',NULL),(57,1,'查看修改','/zuzhijigou/edit','2018-04-27 14:54:56',NULL),(58,1,'执行修改处室','/zuzhijigou/doedit','2018-04-27 14:54:56',NULL),(59,1,'删除处室','/zuzhijigou/delete','2018-04-27 14:54:56',NULL),(60,1,'搜索处室','/zuzhijigou/search','2018-04-27 14:54:56',NULL),(61,1,'用户列表首页','/yonghu/sylist','2018-04-27 14:54:56',NULL),(62,1,'用户列表','/yonghu/list','2018-04-27 14:54:56',NULL),(63,1,'添加用户','/yonghu/add','2018-04-27 14:54:56',NULL),(64,1,'执行添加用户','/yonghu/doadd','2018-04-27 14:54:56',NULL),(65,1,'查看修改','/yonghu/edit','2018-04-27 14:54:56',NULL),(66,1,'执行修改用户','/yonghu/doedit','2018-04-27 14:54:56',NULL),(67,1,'删除用户','/yonghu/delete','2018-04-27 14:54:56',NULL),(68,1,'搜索用户','/yonghu/search','2018-04-27 14:54:56',NULL),(69,1,'角色列表','/role/list','2018-04-27 14:54:56',NULL),(70,1,'权限菜单列表','/role/menulist','2018-04-27 14:54:56',NULL),(71,1,'添加角色','/role/add','2018-04-27 14:54:56',NULL),(72,1,'执行添加角色','/role/doadd','2018-04-27 14:54:56',NULL),(73,1,'查看修改','/role/edit','2018-04-27 14:54:56',NULL),(74,1,'执行修改角色','/role/doedit','2018-04-27 14:54:56',NULL),(75,1,'删除角色','/role/delete','2018-04-27 14:54:56',NULL),(76,1,'搜索角色','/role/search','2018-04-27 14:54:56',NULL),(77,1,'下载分店Excel','/fendian/download','2018-05-04 13:18:04',NULL),(78,1,'下载供应商Excel','/gongyingshang/download','2018-05-04 13:18:04',NULL),(79,1,'下载仓库Excel','/cangku/download','2018-05-04 13:18:04',NULL),(80,1,'下载货位Excel','/huowei/download','2018-05-04 13:18:04',NULL),(81,1,'下载药品Excel','/yaopin/download','2018-05-04 13:18:04',NULL),(82,1,'下载药品分类Excel','/yaopinfenlei/download','2018-05-04 13:18:04',NULL),(83,1,'下载科室Excel','/keshi/download','2018-05-04 13:18:04',NULL),(84,1,'下载处室Excel','/zuzhijigou/download','2018-05-04 13:18:04',NULL),(85,1,'下载用户Excel','/yonghu/download','2018-05-04 13:18:04',NULL),(86,1,'下载角色Excel','/role/download','2018-05-04 13:18:04',NULL);
/*!40000 ALTER TABLE `hjt_useable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_yaopin`
--

DROP TABLE IF EXISTS `hjt_yaopin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_yaopin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `yplb` int(11) NOT NULL COMMENT '药品类别ID',
  `ypgys` int(11) NOT NULL COMMENT '供应商ID',
  `ypbh` varchar(50) NOT NULL DEFAULT '0' COMMENT '药品编码同一集团唯一',
  `ypspm` varchar(50) DEFAULT NULL COMMENT '商品名',
  `yptym` varchar(50) DEFAULT NULL COMMENT '通用名',
  `ypgg` varchar(250) NOT NULL COMMENT '药品规格',
  `ypbzgg` varchar(250) DEFAULT NULL COMMENT '包装规格',
  `ypcd` varchar(200) NOT NULL COMMENT '产地',
  `ypzddcgml` decimal(18,2) DEFAULT NULL COMMENT '最大单次购买量',
  `ypsx` varchar(200) DEFAULT NULL COMMENT '属性',
  `ypyytx` int(1) DEFAULT NULL COMMENT '用药提醒开关 0:开方提醒 1:不提醒',
  `ypyytxnr` varchar(200) DEFAULT NULL COMMENT '用药提醒内容',
  `ypscdw` varchar(250) NOT NULL COMMENT '生产单位',
  `ypjx` varchar(50) DEFAULT NULL COMMENT '剂型',
  `ypdw` varchar(50) NOT NULL COMMENT '单位',
  `ypzcsb` varchar(150) DEFAULT NULL COMMENT '注册商标',
  `yppzwh` varchar(50) DEFAULT NULL COMMENT '批准文号',
  `ypysbz` varchar(250) DEFAULT NULL COMMENT '验收标准',
  `ypcctj` varchar(50) DEFAULT NULL COMMENT '储藏条件',
  `ypjhj` decimal(18,2) DEFAULT '0.00' COMMENT '进货价',
  `yppfj` decimal(18,2) DEFAULT '0.00' COMMENT '批发价',
  `yplsj` decimal(18,2) DEFAULT '0.00' COMMENT '零售价',
  `yphyj` decimal(18,2) DEFAULT '0.00' COMMENT '会员价',
  `ypyxq` varchar(50) DEFAULT NULL COMMENT '有效期',
  `ypkcxx` decimal(11,2) DEFAULT '0.00' COMMENT '库存下限',
  `ypkcsx` decimal(11,2) DEFAULT '0.00' COMMENT '库存上限',
  `ypshzt` int(1) DEFAULT NULL COMMENT '审核状态 0:未审核 1:已审核 2:审核不通过',
  `ypyhzq` int(11) DEFAULT NULL COMMENT '药品养护周期（天）',
  `ypsms` text COMMENT '说明书',
  `ypxf` text COMMENT '药品相反名单，多个时以,分隔',
  `ypxw` text COMMENT '药物相畏名单，多个时以,分隔',
  `ypsfdz` int(1) DEFAULT '0' COMMENT '是否允许打折 0:允许打折 1:禁止打折',
  `ypsfcyhyjf` int(1) DEFAULT '0' COMMENT '药品是否参与会员积分 0:参与积分 1:不参与积分',
  `ypcwbj1` varchar(50) DEFAULT NULL COMMENT '财务标记1',
  `ypcwbj2` varchar(50) DEFAULT NULL COMMENT '财务标记2',
  `ypcjr` int(11) DEFAULT NULL COMMENT '创建人',
  `ypkcsl` decimal(18,2) DEFAULT '0.00' COMMENT '药品库存数量',
  `ct` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
  `zt` int(1) DEFAULT '0' COMMENT '仓库状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '删除状态 0:正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `hjt_yaopin_jtid_idx` (`jtid`,`ypbh`) USING BTREE,
  KEY `jtid` (`jtid`,`ypbh`),
  KEY `ypgys` (`ypgys`),
  KEY `yplb` (`yplb`),
  KEY `hjt_yaopin_hjt_yonghu_fk` (`ypcjr`),
  CONSTRAINT `hjt_yaopin_hjt_gongyingshang_fk` FOREIGN KEY (`ypgys`) REFERENCES `hjt_gongyingshang` (`Id`),
  CONSTRAINT `hjt_yaopin_hjt_yaopinfenlei_fk` FOREIGN KEY (`yplb`) REFERENCES `hjt_yaopinfenlei` (`id`),
  CONSTRAINT `hjt_yaopin_hjt_yonghu_fk` FOREIGN KEY (`ypcjr`) REFERENCES `hjt_yonghu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='药品基础信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_yaopin`
--

LOCK TABLES `hjt_yaopin` WRITE;
/*!40000 ALTER TABLE `hjt_yaopin` DISABLE KEYS */;
INSERT INTO `hjt_yaopin` VALUES (1,1,67,4,'YP0001','薄荷','薄荷','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'广饶县明祥工贸有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(2,1,62,1,'YP0002','白芷','白芷','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(3,1,32,2,'YP0003','藿香','藿香','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东金泰生物工程有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(4,1,33,2,'YP0004','佩兰','佩兰','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东金泰生物工程有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(5,1,34,5,'YP0005','苍术','苍术','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(6,1,35,4,'YP0006','白豆蔻','白豆蔻','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'广饶县明祥工贸有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(7,1,36,1,'YP0007','白术','白术','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(8,1,37,5,'YP0008','附子','附子','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(9,1,38,3,'YP0009','干姜','干姜','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东瑞博德制药有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(10,1,39,1,'YP0010','肉桂','肉桂','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(11,1,40,3,'YP0011','橘皮','橘皮','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东瑞博德制药有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(12,1,41,2,'YP0012','青皮','青皮','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东金泰生物工程有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(13,1,42,3,'YP0013','山楂','山楂','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东瑞博德制药有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(14,1,43,5,'YP0014','神曲','神曲','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(15,1,44,1,'YP0015','使君子','使君子','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(16,1,45,3,'YP0016','苦楝皮','苦楝皮','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东瑞博德制药有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(17,1,76,2,'YP0017','生地黄','生地黄','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东金泰生物工程有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(18,1,50,5,'YP0018','冰片','冰片','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(19,1,63,5,'YP0019','麻黄','麻黄','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(20,1,51,4,'YP0020','麝香','麝香','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'广饶县明祥工贸有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(21,1,55,5,'YP0021','常山','常山','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(22,1,68,4,'YP0022','牛蒡子','牛蒡子','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'广饶县明祥工贸有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(23,1,77,2,'YP0023','青蒿','青蒿','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东金泰生物工程有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(24,1,81,5,'YP0024','大蓟','大蓟','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(25,1,69,3,'YP0025','蝉蜕','蝉蜕','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东瑞博德制药有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(26,1,78,5,'YP0026','芒硝','芒硝','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(27,1,82,4,'YP0027','艾叶','艾叶','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'广饶县明祥工贸有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(28,1,83,5,'YP0028','朱砂','朱砂','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(29,1,75,1,'YP0029','金银花','金银花','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(30,1,45,3,'YP0030','苦楝皮','苦楝皮','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东瑞博德制药有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(31,1,79,3,'YP0031','郁李仁','郁李仁','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东瑞博德制药有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(32,1,70,1,'YP0032','桑叶','桑叶','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(33,1,55,1,'YP0033','常山','常山','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(34,1,66,1,'YP0034','紫苏','紫苏','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(35,1,65,2,'YP0035','辛夷','辛夷','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东金泰生物工程有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(36,1,51,5,'YP0036','麝香','麝香','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(37,1,72,1,'YP0037','石韦','石韦','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(38,1,41,5,'YP0038','人参','人参','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(39,1,69,1,'YP0039','蝉蜕','蝉蜕','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(40,1,73,5,'YP0040','黄芩','黄芩','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(41,1,50,5,'YP0041','冰片','冰片','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(42,1,64,4,'YP0042','羌活','羌活','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'广饶县明祥工贸有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(43,1,71,1,'YP0043','大黄','大黄','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东泉港药业有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(44,1,80,2,'YP0044','甘遂','甘遂','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东金泰生物工程有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(45,1,84,5,'YP0045','黄连','黄连','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'山东新大精细化工有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0),(46,1,83,4,'YP0046','酸枣仁','酸枣仁','1克/包','6包/盒','济南',5.00,'凉',1,NULL,'广饶县明祥工贸有限公司','口服','包','DFG845','SFV612','《药物生产标准》','通风',1.00,0.98,2.00,1.50,'1年',50.00,500.00,1,7,'1包/次，3次/天，饭后服用',NULL,NULL,1,1,NULL,NULL,1,100.00,'2018-02-27 12:11:25',0,0);
/*!40000 ALTER TABLE `hjt_yaopin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_yaopinfenlei`
--

DROP TABLE IF EXISTS `hjt_yaopinfenlei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_yaopinfenlei` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `flbh` varchar(20) DEFAULT NULL COMMENT '分类编号同一集团唯一',
  `flmc` varchar(50) DEFAULT NULL COMMENT '名称',
  `fldj` smallint(6) DEFAULT NULL COMMENT '等级',
  `sjflid` int(11) DEFAULT NULL COMMENT '上级分类ID',
  `flbz` text COMMENT '分类备注信息',
  `zt` int(1) DEFAULT '0' COMMENT '分类状态 0：正常 1：已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `NewIndex1` (`jtid`,`flbh`,`sjflid`),
  KEY `FK3EE7F725237A77D8` (`sjflid`),
  KEY `idxjtid` (`jtid`),
  KEY `idxflbh` (`flbh`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COMMENT='药品分类数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_yaopinfenlei`
--

LOCK TABLES `hjt_yaopinfenlei` WRITE;
/*!40000 ALTER TABLE `hjt_yaopinfenlei` DISABLE KEYS */;
INSERT INTO `hjt_yaopinfenlei` VALUES (1,1,'YPFL0001','中药',1,0,'中药总根',0),(2,1,'YPFL0002','解表药',2,1,'凡以发散表邪，解除表证为主要作用的药物称为解表药。',0),(3,1,'YPFL0003','清热药',2,1,'凡以清解里热为主要作用的药物，称为清热药。',0),(4,1,'YPFL0004','泻下药',2,1,'凡能通利大便的药物称为泻下药。',0),(5,1,'YPFL0005','化湿药',2,1,'凡气味芳香，性偏温燥，具有化湿运脾作用的药物，称为化湿药。',0),(6,1,'YPFL0006','温里药',2,1,'凡以温里祛寒、治疗里寒证为主要作用的药物，称为温里药。',0),(7,1,'YPFL0007','理气药',2,1,'凡具有疏畅气机、调整脏腑功能、消除气滞的药物，称为理气药。',0),(8,1,'YPFL0008','消食药',2,1,'凡能促使消化，增进食欲的药物称消食药。',0),(9,1,'YPFL0009','驱虫药',2,1,'凡能将肠道寄生虫能杀死或驱出体外的药物，称为驱虫药。',0),(10,1,'YPFL0010','止血药',2,1,'凡能促进血液凝固而使出血停止的药物，称为止血药。',0),(11,1,'YPFL0011','安神药',2,1,'凡以安神定志为主要功效的药物称为安神药。',0),(12,1,'YPFL0012','开窍药',2,1,'凡以苏醒神识为主要功效的药物称开窍药。',0),(13,1,'YPFL0013','补虚药',2,1,'凡能补益正气，增强体质，以提高抗病能力，治疗虚正证为主的药物，称为补虚药。',0),(14,1,'YPFL0014','收涩药',2,1,'凡以收敛固涩为主要功用的药物称为收涩药。',0),(15,1,'YPFL0015','涌吐药',2,1,'凡以促使呕吐为主要作用的药物，称为涌吐药。',0),(16,1,'YPFL0016','祛风湿药',2,1,'凡能祛除肌肉、经络、筋骨间的风湿，并能解除疼痛的药物称为祛风湿药。',0),(17,1,'YPFL0017','外用药',2,1,'凡在体表或某些粘膜部位应用，具有杀虫止痒、消肿散结、化腐排脓、生肌收口、收敛止血的一些药物，称为外用药。',0),(18,1,'YPFL0018','化痰止咳平喘药',2,1,'凡以祛痰或消痰为主的药物称为化痰药，能缓和或制止咳嗽喘息的药物称止咳平喘药。',0),(19,1,'YPFL0019','平肝息风药',2,1,'凡以平肝潜阳，息风止痉为主要作用，主治肝阳上亢或肝风内动病证的药物，称平肝息风药。',0),(20,1,'YPFL0020','活血化瘀药',2,1,'活血化瘀药是指能疏通血脉，祛除血瘀的药物。',0),(21,1,'YPFL0021','利水渗湿药',2,1,'凡能渗利水湿、通利小便的药物叫利水渗湿药。',0),(22,1,'YPFL0022','发散风寒药',3,2,'发散风寒药多属辛温，故又名辛温解表药，适用于风寒表证。',0),(23,1,'YPFL0023','发散风热药',3,2,'发散风热药多属辛凉，故又名辛凉解表药，适用于风热表证。',0),(24,1,'YPFL0024','清热泻火药',3,3,'主要清泻湿热郁火，主治外感热病气分高热症，以及肺热、胃火、肝火、心火等脏腑火热证等。',0),(25,1,'YPFL0025','清热燥湿药',3,3,'主清热燥湿，兼以清热泻火、主治无论外感或内伤治湿热火毒诸症。',0),(26,1,'YPFL0026','清热解毒药',3,3,'清热解毒，主治外感或内生湿热火毒诸证。',0),(27,1,'YPFL0027','清热凉血药',3,3,'多入心肝经，功主清热凉血，兼以滋润、活血，主治外感热病热入营血之神昏谵语，以及火热内生之火热妄行诸证。',0),(28,1,'YPFL0028','清虚热药',3,3,'清虚热、除疳热，兼凉血。主治热病后期之阴伤发热、久病伤阴之骨蒸潮热，以及小儿疳热。',0),(29,1,'YPFL0029','攻下药',3,4,'多属味苦性寒，既能通便，又能泻火，适用于大便燥结、宿食停积、 实热壅滞等症。',0),(30,1,'YPFL0030','润下药',3,4,'润下药，多为植物的种仁或果仁，富含油脂，具有润滑作用，使大便易于排出，适用于一切血虚津枯所致的便秘。',0),(31,1,'YPFL0031','峻下逐水药',3,4,'峻下逐水药作用峻猛，能引起强烈腹泻，而使大量水分从大小便排出，以达到消除肿胀的目的。',0),(32,1,'YPFL0032','藿香',3,5,'芳香化湿，解暑发表，和中止呕。',0),(33,1,'YPFL0033','佩兰',3,5,'芳香化湿，解暑发表，化内湿。',0),(34,1,'YPFL0034','苍术',3,5,'燥湿健脾，祛风湿。',0),(35,1,'YPFL0035','白豆蔻',3,5,'化湿行气，温中止呕。',0),(36,1,'YPFL0036','白术',3,5,'燥湿健脾，补脾益不足，固表利水安胎。',0),(37,1,'YPFL0037','附子',3,6,'回阳救逆，助阳补火，散寒止痛。',0),(38,1,'YPFL0038','干姜',3,6,'温中散寒，回阳通脉，温肺化饮。',0),(39,1,'YPFL0039','肉桂',3,6,'补火助阳，散寒止痛，引火归元， 温经通脉。',0),(40,1,'YPFL0040','橘皮',3,7,'理气健脾，燥湿化痰。',0),(41,1,'YPFL0041','青皮',3,7,'行气除胀，疏肝理气，消积化滞。',0),(42,1,'YPFL0042','山楂',3,8,'消食化积，行气活血散瘀；善消肉食油腻。',0),(43,1,'YPFL0043','神曲',3,8,'消食和胃，和中助运；善消酒谷之积。',0),(44,1,'YPFL0044','使君子',3,9,'驱虫消积。',0),(45,1,'YPFL0045','苦楝皮',3,9,'杀虫，疗癣。',0),(46,1,'YPFL0046','凉血止血药',3,10,'药性寒凉，功能凉血止血，适用于血热之出血。',0),(47,1,'YPFL0047','温经止血药',3,10,'能温经止血，适用于虚寒出血。',0),(48,1,'YPFL0048','重镇安神药',3,11,'本类药物多为矿石、化石、介类药物，具有质重沉降之性。重者能镇，重可祛怯，故有镇安心神、平惊定志、平肝潜阳等作用。',0),(49,1,'YPFL0049','养心安神药',3,11,'本类药物多为植物类种子、种仁，具有甘润滋养之性，故有滋养心肝、益阴补血、交通心肾等作用。',0),(50,1,'YPFL0050','冰片',3,12,'性寒，开窍醒神，清热止痛。',0),(51,1,'YPFL0051','麝香',3,12,'性温，开窍醒神，活血通经，止痛，催产。',0),(52,1,'YPFL0052','补气药',3,13,'本类药物性味多甘温或甘平，能补益脏腑之气。',0),(53,1,'YPFL0053','补阳药',3,13,'本类药物性味多甘温或咸温或辛热，能温补人体之阳气。',0),(54,1,'YPFL0054','固表止汗药',3,14,'收敛止汗——治自汗、盗汗等。',0),(55,1,'YPFL0055','常山',3,15,'涌吐痰涎，截疟。',0),(56,1,'YPFL0056','祛风湿散寒药',3,16,'祛风湿散寒药',0),(57,1,'YPFL0057','攻毒杀虫止痒药',3,17,'攻毒疗疮，杀虫止痒',0),(58,1,'YPFL0058','温化寒痰药',3,18,'温化寒痰药',0),(59,1,'YPFL0059','平抑肝阳药',3,19,'本类药物具有平肝潜阳或平抑肝阳的功效，以及清肝热、安心神的作用。',0),(60,1,'YPFL0060','活血止痛药',3,20,'活血止痛药',0),(61,1,'YPFL0061','利水消肿药',3,21,'性味多甘淡平或微寒，利水消肿，主治水湿内停之水肿，小便不利等证。',0),(62,1,'YPFL0062','白芷',4,22,'解表散风，通窍，止痛，燥湿止带，消肿排脓。',0),(63,1,'YPFL0063','麻黄',4,22,'发汗解表，宣肺平喘，利水消肿。。',0),(64,1,'YPFL0064','羌活',4,22,'散寒祛风，胜湿止痛。',0),(65,1,'YPFL0065','辛夷',4,22,'发散风寒，宣通鼻窍。',0),(66,1,'YPFL0066','紫苏',4,22,'发汗解表，行气宽中，顺气安胎。',0),(67,1,'YPFL0067','薄荷',4,23,'疏散风热，清利头目，利咽，透疹，疏肝解郁。',0),(68,1,'YPFL0068','牛蒡子',4,23,'疏散风热，透疹利咽，解毒散肿，滑利通便。',0),(69,1,'YPFL0069','蝉蜕',4,23,'疏散风热，透疹止痒，明目退翳，止痉。',0),(70,1,'YPFL0070','桑叶',4,23,'疏散风热，清肺润燥，平肝明目，凉血止血。',0),(71,1,'YPFL0071','大黄',4,24,'泻火通便，解毒祛瘀，除湿退黄，降火止血。',0),(72,1,'YPFL0072','石韦',4,24,'利水通淋，清肺止咳 凉血止血。',0),(73,1,'YPFL0073','黄芩',4,25,'清热燥湿， 泻火解毒，凉血止血，除热安胎。',0),(74,1,'YPFL0074','黄连',4,25,'清热燥湿，泻火解毒，除烦止呕。',0),(75,1,'YPFL0075','金银花',4,26,'清热解毒，疏散风热，凉血止痢。',0),(76,1,'YPFL0076','生地黄',4,27,'清热、凉 血、止血，养阴生津。',0),(77,1,'YPFL0077','青蒿',4,28,'清虚热， 除骨蒸，解暑，截疟。',0),(78,1,'YPFL0078','芒硝',4,29,'清热，泻火通便，消火消肿，润燥软坚。',0),(79,1,'YPFL0079','郁李仁',4,30,'润肠通便，利水消肿。',0),(80,1,'YPFL0080','甘遂',4,31,'泻水逐饮， 消肿散结。',0),(81,1,'YPFL0081','大蓟',4,46,'凉血止血， 散瘀解毒消痈。',0),(82,1,'YPFL0082','艾叶',4,47,'温经止血，暖下散寒调经，安胎。',0),(83,1,'YPFL0083','朱砂',4,48,'镇心安神， 清热解毒。',0),(84,1,'YPFL0084','酸枣仁',4,49,'养心益肝 ，血虚安神，敛汗。',0),(85,1,'YPFL0085','人参',4,52,'大补元 气，补脾益肺，生津止渴，安神益智。',0);
/*!40000 ALTER TABLE `hjt_yaopinfenlei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_yonghu`
--

DROP TABLE IF EXISTS `hjt_yonghu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_yonghu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(20) DEFAULT '1' COMMENT '集团ID',
  `fdid` int(11) DEFAULT '0' COMMENT '分店ID',
  `yhbh` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `yhdlm` varchar(50) DEFAULT NULL COMMENT '登录名',
  `yhmm` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `yhxm` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `yhxmjp` varchar(50) DEFAULT NULL COMMENT '用户姓名简拼',
  `yhxb` varchar(50) DEFAULT NULL COMMENT '用户性别',
  `yhsfzh` varchar(50) DEFAULT NULL COMMENT '用户身份证号',
  `yhsj` varchar(50) DEFAULT NULL COMMENT '用户手机',
  `yhdzyx` varchar(50) DEFAULT NULL COMMENT '电子邮件',
  `yhbmid` int(11) DEFAULT NULL COMMENT '用户所属部门ID',
  `yhcsrq` date DEFAULT NULL COMMENT '用户出生日期',
  `yhdz` varchar(50) DEFAULT NULL COMMENT '地址',
  `yhyb` varchar(50) DEFAULT NULL COMMENT '邮编',
  `yhjsid` int(20) DEFAULT NULL COMMENT '用户角色ID',
  `yhbz` text COMMENT '备注信息',
  `yhrzrq` date DEFAULT NULL COMMENT '用户入职日期',
  `ct` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '档案创建日期',
  `zt` int(1) DEFAULT '0' COMMENT '状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '删除状态 0：正常 1：已删除',
  PRIMARY KEY (`id`),
  KEY `fdid` (`fdid`),
  KEY `yhbmid` (`yhbmid`),
  CONSTRAINT `hjt_yonghu_ibfk_1` FOREIGN KEY (`fdid`) REFERENCES `hjt_fendian` (`Id`),
  CONSTRAINT `hjt_yonghu_ibfk_2` FOREIGN KEY (`yhbmid`) REFERENCES `hjt_zuzhijigou` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_yonghu`
--

LOCK TABLES `hjt_yonghu` WRITE;
/*!40000 ALTER TABLE `hjt_yonghu` DISABLE KEYS */;
INSERT INTO `hjt_yonghu` VALUES (1,1,1,'YH0101','liuhe','123456','刘贺','lh','1','37113719760915947520','13293972400','liuhe@hjt.com',1,'1976-09-15','山东省济南市',NULL,2,NULL,'2012-12-05','2018-02-04 12:43:49',0,0),(2,1,1,'YH0102','jingkunyu','123456','荆昆宇','jky','1','32734519911101741728','16976485012','jingkunyu@hjt.com',2,'1991-11-01','山东省济南市','',3,NULL,'2013-10-27','2018-02-04 12:43:49',0,0),(3,1,1,'YH0103','ninghuaiyan','123456','宁怀雁','nhy','2','35709419830624165204','14000508047','ninghuaiyan@hjt.com',3,'1983-06-24','山东省济南市',NULL,4,NULL,'2012-06-19','2018-02-04 12:43:49',0,0),(4,1,2,'YH0204','xianzuorui','123456','线琛瑞','xzr','1','33869419711118963257','18073085381','xianzuorui@hjt.com',4,'1971-11-18','山东省济南市',NULL,2,NULL,'2012-11-12','2018-02-04 12:43:49',0,0),(5,1,2,'YH0205','sunsi','123456','孙思','ss','2','34355619890505615222','17363902953','sunsi@hjt.com',5,'1989-05-05','山东省济南市',NULL,3,NULL,'2009-01-27','2018-02-04 12:43:49',0,0),(6,1,2,'YH0206','zhouwu','123456','周武','zw','1','33487619850703319911','13600258804','zhouwu@hjt.com',6,'1985-07-03','山东省济南市',NULL,4,NULL,'2008-08-18','2018-02-04 12:43:49',0,0),(7,1,1,'YH0104','shanganran','123456','商安然','sar','1','30397219890626541297','14909585344','shanganran@hjt.com',7,'1989-06-26','山东省济南市',NULL,1,NULL,'2017-10-11','2018-02-04 12:43:49',0,0),(8,1,1,'YH0105','wuliu','123456','吴留','wl','2','32823619700715205508','14747150492','wuliu@hjt.com',1,'1970-07-15','山东省济南市',NULL,5,NULL,'2015-07-28','2018-02-04 12:43:49',0,0),(9,1,1,'YH0106','liming','123456','李明','lm','1','35628619891015832943','16006996612','liming@hjt.com',8,'1989-10-15','山东省济南市',NULL,6,NULL,'2016-07-07','2018-04-30 22:21:36',0,0),(10,1,2,'YH0207','zhongdonglian','123456','钟冬莲','zdl','2','31531619911006476480','16793531770','zhongdonglian@hjt.com',9,'1991-10-06','山东省济南市',NULL,6,NULL,'2008-02-26','2018-04-30 22:21:36',0,0),(11,1,3,'YH0301','zhangxiangzhen','123456','章向真','zxz','1','35108319940405656632','16946669197','zhangxiangzhen@hjt.com',10,'1994-04-05','山东省济南市',NULL,6,NULL,'2012-10-14','2018-04-30 22:35:03',0,0),(12,1,4,'YH0401','zhaodongyun','123456','赵东云','zdy','1','33274519750817987760','15352750859','zhaodongyun@hjt.com',11,'1975-08-17','山东省济南市',NULL,6,NULL,'2011-10-06','2018-04-30 22:35:03',0,0),(13,1,5,'YH0501','wuhong','123456','吴宏','wh','1','37350519750921257874','18923746887','wuhong@hjt.com',12,'1975-09-21','山东省济南市',NULL,6,NULL,'2012-06-11','2018-04-30 22:35:03',0,0),(14,1,6,'YH0601','zhanxinzhi','123456','展新之','zxz','1','33522619810922509702','17560482046','zhanxinzhi@hjt.com',13,'1981-09-22','山东省济南市',NULL,6,NULL,'2009-01-31','2018-04-30 22:35:03',0,0),(15,1,7,'YH0701','liufeng','123456','刘峰','lf','1','30775719860409163542','18031169752','liufeng@hjt.com',14,'1986-04-09','山东省济南市',NULL,6,NULL,'2009-12-08','2018-04-30 22:35:03',0,0),(16,1,8,'YH0801','suji','123456','苏季','sj','1','30811019901225319936','18474402809','suji@hjt.com',15,'1990-12-25','山东省济南市',NULL,6,NULL,'2014-06-05','2018-04-30 22:35:03',0,0),(17,1,9,'YH0901','wangtu','123456','王图','wt','1','38428119750920106943','13278504972','wangtu@hjt.com',16,'1975-09-20','山东省济南市',NULL,6,NULL,'2014-08-10','2018-04-30 22:35:03',0,0),(18,1,1,'YH1001','sunfu','123456','孙复','sf','1','31725119860110952459','15969316616','sunfu@hjt.com',17,'1986-01-10','山东省济南市',NULL,6,NULL,'2011-11-24','2018-04-30 22:35:03',0,0);
/*!40000 ALTER TABLE `hjt_yonghu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hjt_zuzhijigou`
--

DROP TABLE IF EXISTS `hjt_zuzhijigou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hjt_zuzhijigou` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `jtid` int(11) DEFAULT '1' COMMENT '集团ID',
  `fdid` int(11) DEFAULT '0' COMMENT '分店ID',
  `csbh` varchar(50) DEFAULT NULL COMMENT '处室编号同一分店唯一',
  `csmc` varchar(50) DEFAULT NULL COMMENT '处室名称',
  `csmcjp` varchar(50) DEFAULT NULL COMMENT '处室名称简拼',
  `cslxdh` varchar(50) DEFAULT NULL COMMENT '处室电话',
  `cszr` varchar(50) DEFAULT NULL COMMENT '处室主任',
  `csbz` text COMMENT '科室备注信息',
  `zt` int(1) DEFAULT '0' COMMENT '状态 0：启用 1：禁用',
  `dm` int(1) DEFAULT '0' COMMENT '删除状态 0：正常 1：已删除',
  PRIMARY KEY (`Id`),
  KEY `jtid` (`jtid`,`fdid`,`csbh`),
  KEY `fdid` (`fdid`),
  CONSTRAINT `hjt_zuzhijigou_ibfk_1` FOREIGN KEY (`fdid`) REFERENCES `hjt_fendian` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1036 DEFAULT CHARSET=utf8 COMMENT='处室主表数据结构';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hjt_zuzhijigou`
--

LOCK TABLES `hjt_zuzhijigou` WRITE;
/*!40000 ALTER TABLE `hjt_zuzhijigou` DISABLE KEYS */;
INSERT INTO `hjt_zuzhijigou` VALUES (1,1,1,'CS0102','仓库','ck','0533-87039346','刘贺','仓库管理',0,0),(2,1,1,'CS0104','财务部','cwb','0533-96505127','荆昆宇','财务管理',0,0),(3,1,1,'CS0103','人事部','rsb','0533-31407617','宁怀雁','人事管理',0,0),(4,1,2,'CS0202','仓库','ck','0533-37522688','线琛瑞','仓库管理',0,0),(5,1,2,'CS0204','财务部','cwb','0533-83390592','孙思','财务管理',0,0),(6,1,2,'CS0203','人事部','rsb','0533-24384928','周武','人事管理',0,0),(7,1,1,'CS0001','数据管理部','sjglb','0533-41752847','商安然','软件系统维护',0,0),(8,1,1,'CS0101','办公室','bgs','0533-35609464','李明','分店管理',0,0),(9,1,2,'CS0201','办公室','bgs','0533-42788781','钟冬莲','分店管理',0,0),(10,1,3,'CS0301','办公室','bgs','0533-97115514','章向真','分店管理',0,0),(11,1,4,'CS0401','办公室','bgs','0533-77211260','赵东云','分店管理',0,0),(12,1,5,'CS0501','办公室','bgs','0533-84709760','吴宏','分店管理',0,0),(13,1,6,'CS0601','办公室','bgs','0533-91915034','展新之','分店管理',0,0),(14,1,7,'CS0701','办公室','bgs','0533-15445912','刘峰','分店管理',0,0),(15,1,8,'CS0801','办公室','bgs','0533-61484432','苏季','分店管理',0,0),(16,1,9,'CS0901','办公室','bgs','0533-71084444','王图','分店管理',0,0),(17,1,10,'CS1001','办公室','bgs','0533-70968935','孙复','分店管理',0,0),(1012,1,3,'CS0302','仓库','ck','0533-41591356','古尧轮','仓库管理',0,0),(1013,1,3,'CS0303','人事部','rsb','0533-75049968','柳启智','人事管理',0,0),(1014,1,3,'CS0304','财务部','cwb','0533-60475796','盛勤永','财务管理',0,0),(1015,1,4,'CS0402','仓库','ck','0533-67229077','张冲群','仓库管理',0,0),(1016,1,4,'CS0403','人事部','rsb','0533-54718010','江善农','人事管理',0,0),(1017,1,4,'CS0404','财务部','cwb','0533-61902819','石良纳','财务管理',0,0),(1018,1,5,'CS0502','仓库','ck','0533-45360078','黎弘舟','仓库管理',0,0),(1019,1,5,'CS0503','人事部','rsb','0533-31091935','常祯谷','人事管理',0,0),(1020,1,5,'CS0504','财务部','cwb','0533-99379433','陈盛清','财务管理',0,0),(1021,1,6,'CS0602','仓库','ck','0533-33621401','郭鼎','仓库管理',0,0),(1022,1,6,'CS0603','人事部','rsb','0533-39968689','刘纯源','人事管理',0,0),(1023,1,6,'CS0604','财务部','cwb','0533-88979246','詹瑞隆','财务管理',0,0),(1024,1,7,'CS0702','仓库','ck','0533-44990196','周奇康','仓库管理',0,0),(1025,1,7,'CS0703','人事部','rsb','0533-38013233','彭誉龙','人事管理',0,0),(1026,1,7,'CS0704','财务部','cwb','0533-45095580','云仁经','财务管理',0,0),(1027,1,8,'CS0802','仓库','ck','0533-11438214','褚川山','仓库管理',0,0),(1028,1,8,'CS0803','人事部','rsb','0533-91904310','侯备希','人事管理',0,0),(1029,1,8,'CS0804','财务部','cwb','0533-55206949','陈亮备','财务管理',0,0),(1030,1,9,'CS0902','仓库','ck','0533-80321809','席览奇','仓库管理',0,0),(1031,1,9,'CS0903','人事部','rsb','0533-45988222','钱维沃','人事管理',0,0),(1032,1,9,'CS0904','财务部','cwb','0533-68975675','邢备申','财务管理',0,0),(1033,1,10,'CS1002','仓库','ck','0533-16913731','任涧古','仓库管理',0,0),(1034,1,10,'CS1003','人事部','rsb','0533-47641612','梁颁东','人事管理',0,0),(1035,1,10,'CS1004','财务部','cwb','0533-87466878','王峪策','财务管理',0,0);
/*!40000 ALTER TABLE `hjt_zuzhijigou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_base_pinyin`
--

DROP TABLE IF EXISTS `t_base_pinyin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_base_pinyin` (
  `pin_yin_` varchar(255) DEFAULT NULL,
  `code_` int(11) NOT NULL,
  PRIMARY KEY (`code_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='汉字拼音对照临时表，用于将汉字转为拼音';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_base_pinyin`
--

LOCK TABLES `t_base_pinyin` WRITE;
/*!40000 ALTER TABLE `t_base_pinyin` DISABLE KEYS */;
INSERT INTO `t_base_pinyin` VALUES ('zuo',10254),('zun',10256),('zui',10260),('zuan',10262),('zu',10270),('zou',10274),('zong',10281),('zi',10296),('zhuo',10307),('zhun',10309),('zhui',10315),('zhuang',10322),('zhuan',10328),('zhuai',10329),('zhua',10331),('zhu',10519),('zhou',10533),('zhong',10544),('zhi',10587),('zheng',10764),('zhen',10780),('zhe',10790),('zhao',10800),('zhang',10815),('zhan',10832),('zhai',10838),('zha',11014),('zeng',11018),('zen',11019),('zei',11020),('ze',11024),('zao',11038),('zang',11041),('zan',11045),('zai',11052),('za',11055),('yun',11067),('yue',11077),('yuan',11097),('yu',11303),('you',11324),('yong',11339),('yo',11340),('ying',11358),('yin',11536),('yi',11589),('ye',11604),('yao',11781),('yang',11798),('yan',11831),('ya',11847),('xun',11861),('xue',11867),('xuan',12039),('xu',12058),('xiu',12067),('xiong',12074),('xing',12089),('xin',12099),('xie',12120),('xiao',12300),('xiang',12320),('xian',12346),('xia',12359),('xi',12556),('wu',12585),('wo',12594),('weng',12597),('wen',12607),('wei',12802),('wang',12812),('wan',12829),('wai',12831),('wa',12838),('tuo',12849),('tun',12852),('tui',12858),('tuan',12860),('tu',12871),('tou',12875),('tong',12888),('ting',13060),('tie',13063),('tiao',13068),('tian',13076),('ti',13091),('teng',13095),('te',13096),('tao',13107),('tang',13120),('tan',13138),('tai',13147),('ta',13318),('suo',13326),('sun',13329),('sui',13340),('suan',13343),('su',13356),('sou',13359),('song',13367),('si',13383),('shuo',13387),('shun',13391),('shui',13395),('shuang',13398),('shuan',13400),('shuai',13404),('shua',13406),('shu',13601),('shou',13611),('shi',13658),('sheng',13831),('shen',13847),('she',13859),('shao',13870),('shang',13878),('shan',13894),('shai',13896),('sha',13905),('seng',13906),('sen',13907),('se',13910),('sao',13914),('sang',13917),('san',14083),('sai',14087),('sa',14090),('ruo',14092),('run',14094),('rui',14097),('ruan',14099),('ru',14109),('rou',14112),('rong',14122),('ri',14123),('reng',14125),('ren',14135),('re',14137),('rao',14140),('rang',14145),('ran',14149),('qun',14151),('que',14159),('quan',14170),('qu',14345),('qiu',14353),('qiong',14355),('qing',14368),('qin',14379),('qie',14384),('qiao',14399),('qiang',14407),('qian',14429),('qia',14594),('qi',14630),('pu',14645),('po',14654),('ping',14663),('pin',14668),('pie',14670),('piao',14674),('pian',14678),('pi',14857),('peng',14871),('pen',14873),('pei',14882),('pao',14889),('pang',14894),('pan',14902),('pai',14908),('pa',14914),('ou',14921),('o',14922),('nuo',14926),('nue',14928),('nuan',14929),('nv',14930),('nu',14933),('nong',14937),('niu',14941),('ning',15109),('nin',15110),('nie',15117),('niao',15119),('niang',15121),('nian',15128),('ni',15139),('neng',15140),('nen',15141),('nei',15143),('ne',15144),('nao',15149),('nang',15150),('nan',15153),('nai',15158),('na',15165),('mu',15180),('mou',15183),('mo',15362),('miu',15363),('ming',15369),('min',15375),('mie',15377),('miao',15385),('mian',15394),('mi',15408),('meng',15416),('men',15419),('mei',15435),('me',15436),('mao',15448),('mang',15454),('man',15625),('mai',15631),('ma',15640),('luo',15652),('lun',15659),('lue',15661),('luan',15667),('lv',15681),('lu',15701),('lou',15707),('long',15878),('liu',15889),('ling',15903),('lin',15915),('lie',15920),('liao',15933),('liang',15944),('lian',15958),('lia',15959),('li',16155),('leng',16158),('lei',16169),('le',16171),('lao',16180),('lang',16187),('lan',16202),('lai',16205),('la',16212),('kuo',16216),('kun',16220),('kui',16393),('kuang',16401),('kuan',16403),('kuai',16407),('kua',16412),('ku',16419),('kou',16423),('kong',16427),('keng',16429),('ken',16433),('ke',16448),('kao',16452),('kang',16459),('kan',16465),('kai',16470),('ka',16474),('jun',16647),('jue',16657),('juan',16664),('ju',16689),('jiu',16706),('jiong',16708),('jing',16733),('jin',16915),('jie',16942),('jiao',16970),('jiang',16983),('jian',17185),('jia',17202),('ji',17417),('huo',17427),('hun',17433),('hui',17454),('huang',17468),('huan',17482),('huai',17487),('hua',17496),('hu',17676),('hou',17683),('hong',17692),('heng',17697),('hen',17701),('hei',17703),('he',17721),('hao',17730),('hang',17733),('han',17752),('hai',17759),('ha',17922),('guo',17928),('gun',17931),('gui',17947),('guang',17950),('guan',17961),('guai',17964),('gua',17970),('gu',17988),('gou',17997),('gong',18012),('geng',18181),('gen',18183),('gei',18184),('ge',18201),('gao',18211),('gang',18220),('gan',18231),('gai',18237),('ga',18239),('fu',18446),('fou',18447),('fo',18448),('feng',18463),('fen',18478),('fei',18490),('fang',18501),('fan',18518),('fa',18526),('er',18696),('en',18697),('e',18710),('duo',18722),('dun',18731),('dui',18735),('duan',18741),('du',18756),('dou',18763),('dong',18773),('diu',18774),('ding',18783),('die',18952),('diao',18961),('dian',18977),('di',18996),('deng',19003),('de',19006),('dao',19018),('dang',19023),('dan',19038),('dai',19212),('da',19218),('cuo',19224),('cun',19227),('cui',19235),('cuan',19238),('cu',19242),('cou',19243),('cong',19249),('ci',19261),('chuo',19263),('chun',19270),('chui',19275),('chuang',19281),('chuan',19288),('chuai',19289),('chu',19467),('chou',19479),('chong',19484),('chi',19500),('cheng',19515),('chen',19525),('che',19531),('chao',19540),('chang',19715),('chan',19725),('chai',19728),('cha',19739),('ceng',19741),('ce',19746),('cao',19751),('cang',19756),('can',19763),('cai',19774),('ca',19775),('bu',19784),('bo',19805),('bing',19976),('bin',19982),('bie',19986),('biao',19990),('bian',20002),('bi',20026),('beng',20032),('ben',20036),('bei',20051),('bao',20230),('bang',20242),('ban',20257),('bai',20265),('ba',20283),('ao',20292),('ang',20295),('an',20304),('ai',20317),('a',20319);
/*!40000 ALTER TABLE `t_base_pinyin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-04 14:48:00
