/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.28-log : Database - video
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`video` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `video`;

/*Table structure for table `table_feed_ugc` */

DROP TABLE IF EXISTS `table_feed_ugc`;

CREATE TABLE `table_feed_ugc` (
  `id` int(11) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `like_count` int(11) DEFAULT '0',
  `share_count` int(11) DEFAULT '0',
  `comment_count` int(11) DEFAULT '0',
  `has_favorite` tinyint(1) NOT NULL DEFAULT '0',
  `has_liked` tinyint(1) NOT NULL DEFAULT '0',
  `hasdiss` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_feed_ugc` */

insert  into `table_feed_ugc`(`id`,`item_id`,`like_count`,`share_count`,`comment_count`,`has_favorite`,`has_liked`,`hasdiss`) values 
(0,1755848782698,1,0,0,0,0,0),
(1010,1679188110424,1,0,0,0,0,0);

/*Table structure for table `table_feed_ugc_like` */

DROP TABLE IF EXISTS `table_feed_ugc_like`;

CREATE TABLE `table_feed_ugc_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `has_like` int(11) DEFAULT '0',
  `has_diss` int(11) DEFAULT '0',
  `has_favorite` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_user_item` (`user_id`,`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_feed_ugc_like` */

insert  into `table_feed_ugc_like`(`id`,`user_id`,`item_id`,`has_like`,`has_diss`,`has_favorite`) values 
(7,1755252391,1679188170706,1,0,0),
(8,1755252391,1679188110424,1,0,0),
(9,1755252391,1755848782698,1,0,0);

/*Table structure for table `table_feeds_comment` */

DROP TABLE IF EXISTS `table_feeds_comment`;

CREATE TABLE `table_feeds_comment` (
  `id` int(11) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `comment_type` int(11) NOT NULL COMMENT '1=文字, 2=图片, 3=视频',
  `create_time` bigint(20) NOT NULL,
  `comment_text` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `video_url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `like_count` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_feeds_comment` */

insert  into `table_feeds_comment`(`id`,`item_id`,`comment_id`,`user_id`,`comment_type`,`create_time`,`comment_text`,`image_url`,`video_url`,`width`,`height`,`like_count`) values 
(6756,1679188110424,1683279163756,1679188110580,1,1679188110580,'喀秋莎',NULL,NULL,0,0,199),
(6758,1679188170706,1683279163758,1679188172121,1,1679188172121,'你开这么快都不用看前边嘛','https://jetpack2023.oss-cn-shanghai.aliyuncs.com/31659b1193364647ac5593f9f0633c8d.png',NULL,0,0,20);

/*Table structure for table `table_feeds_comment_like` */

DROP TABLE IF EXISTS `table_feeds_comment_like`;

CREATE TABLE `table_feeds_comment_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) DEFAULT NULL,
  `has_like` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_feeds_comment_like` */

insert  into `table_feeds_comment_like`(`id`,`comment_id`,`has_like`,`user_id`) values 
(5,1683279163758,0,1755252391),
(6,1683279163758,0,0);

/*Table structure for table `table_feeds_comment_ugc` */

DROP TABLE IF EXISTS `table_feeds_comment_ugc`;

CREATE TABLE `table_feeds_comment_ugc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` bigint(20) DEFAULT NULL,
  `like_count` bigint(20) DEFAULT NULL,
  `has_liked` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_feeds_comment_ugc` */

insert  into `table_feeds_comment_ugc`(`id`,`comment_id`,`like_count`,`has_liked`) values 
(4,1683279163758,20,NULL);

/*Table structure for table `table_hot_feeds` */

DROP TABLE IF EXISTS `table_hot_feeds`;

CREATE TABLE `table_hot_feeds` (
  `id` bigint(200) NOT NULL,
  `item_id` bigint(200) NOT NULL,
  `item_type` int(11) DEFAULT '0',
  `create_time` bigint(20) NOT NULL,
  `duration` double(10,2) NOT NULL,
  `feeds_text` varchar(2000) COLLATE utf8_unicode_ci NOT NULL,
  `author_id` bigint(20) NOT NULL,
  `activity_icon` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activity_text` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cover` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `author` tinyblob,
  `top_comment` tinyblob,
  `ugc` tinyblob,
  PRIMARY KEY (`id`),
  KEY `idx_item_id` (`item_id`),
  KEY `idx_author_id` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_hot_feeds` */

insert  into `table_hot_feeds`(`id`,`item_id`,`item_type`,`create_time`,`duration`,`feeds_text`,`author_id`,`activity_icon`,`activity_text`,`width`,`height`,`url`,`cover`,`author`,`top_comment`,`ugc`) values 
(2296846,1756362830511,0,1756362830511,0.00,'刚刚搞好关系',1679188110424,'https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png','杂谈',0,0,NULL,NULL,NULL,NULL,NULL),
(4302303,1756363296465,0,1756363296465,0.00,'是你们班的',1679188110424,'https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png','杂谈',0,0,NULL,NULL,NULL,NULL,NULL),
(7165199,1756363788348,0,1756363788348,0.00,'嘎嘎嘎嘎',1679188170706,'https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png','杂谈',0,0,NULL,NULL,NULL,NULL,NULL),
(1578923469,1756361686173,1,1756361686173,0.00,'跳过',1679188170706,'https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png','旅游',1440,1080,'https://protectiveimg.oss-cn-hangzhou.aliyuncs.com/blinker/9ea0e66f-499f-4e51-88cd-fa08c5062c97.jpg','https://protectiveimg.oss-cn-hangzhou.aliyuncs.com/blinker/531ea20d-94ac-4f5d-bd6f-5ddd3af8138f.jpg',NULL,NULL,NULL),
(1578923470,1679188110424,2,1679188110424,18.77,'注意力瞬间转移了有么有灵光一闪',1679188110424,'https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png','Aukoala',720,1092,'https://jetpack2023.oss-cn-shanghai.aliyuncs.com/ooAAADUTeDjRbBENR4nMvh1pDhNxDz8gjfWEwn.mp4','https://jetpack2023.oss-cn-shanghai.aliyuncs.com/31659b1193364647ac5593f9f0633c8d.png',NULL,NULL,NULL),
(1578923471,1679188170706,2,1679188170706,9.64,'这推背感',1679188170706,'https://pipijoke.oss-cn-hangzhou.aliyuncs.com/51f076f662ef40c99f056a41b130c516.png','百年教育',720,1280,'https://jetpack2023.oss-cn-shanghai.aliyuncs.com/os4PEhOqnUOm3CQJAweQNSxNNBbnjBAIDugeEg.mp4','https://jetpack2023.oss-cn-shanghai.aliyuncs.com/9e099e8bac4f49cf972c536b4d98bc47_1669468770.png',NULL,NULL,NULL);

/*Table structure for table `table_tag_list` */

DROP TABLE IF EXISTS `table_tag_list`;

CREATE TABLE `table_tag_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `background` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `activity_icon` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `intro` text COLLATE utf8_unicode_ci NOT NULL,
  `feed_num` int(11) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  `enter_num` int(11) NOT NULL,
  `follow_num` int(11) NOT NULL,
  `has_follow` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_tag_id` (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_tag_list` */

insert  into `table_tag_list`(`id`,`icon`,`background`,`activity_icon`,`title`,`intro`,`feed_num`,`tag_id`,`enter_num`,`follow_num`,`has_follow`) values 
(1,'https://picsum.photos/seed/tag1/100/100','https://picsum.photos/seed/tagbg1/200/100','','旅行','探索世界的美丽角落',5,5001,200,50,'\0'),
(2,'https://picsum.photos/seed/tag2/100/100','https://picsum.photos/seed/tagbg2/200/100','','美食','分享美食与烹饪技巧',8,5002,300,80,'');

/*Table structure for table `table_tag_list_like` */

DROP TABLE IF EXISTS `table_tag_list_like`;

CREATE TABLE `table_tag_list_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `has_like` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_tag` (`user_id`,`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_tag_list_like` */

/*Table structure for table `table_user` */

DROP TABLE IF EXISTS `table_user`;

CREATE TABLE `table_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `avatar` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `top_count` int(11) DEFAULT NULL,
  `follow_count` int(11) DEFAULT NULL,
  `follower_count` int(11) DEFAULT NULL,
  `qq_open_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `expires_time` bigint(20) DEFAULT NULL,
  `score` bigint(20) DEFAULT NULL,
  `history_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  `favorite_count` int(11) DEFAULT NULL,
  `feed_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1754969766103 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_user` */

insert  into `table_user`(`user_id`,`name`,`avatar`,`description`,`like_count`,`top_count`,`follow_count`,`follower_count`,`qq_open_id`,`expires_time`,`score`,`history_count`,`comment_count`,`favorite_count`,`feed_count`) values 
(1001,'Alice','https://randomuser.me/api/portraits/women/1.jpg','旅行博主',12,3,5,20,'qq_1001',1893456000,150,10,5,3,8),
(1002,'Bob','https://randomuser.me/api/portraits/men/2.jpg','美食探险家',25,7,10,15,'qq_1002',1893456000,200,8,7,4,12),
(1003,'Charlie','https://randomuser.me/api/portraits/men/3.jpg','摄影师',30,10,15,25,'qq_1003',1893456000,300,15,12,6,20),
(1755252391,'清浅~安然','http://thirdqq.qlogo.cn/ek_qqapp/AQGPq6JrbcMwreiaSmYeib9YziaFLdAwmDOCbaHcTSC14Xt5JKvXAnHbAoGicbnSv8UGwmVmMZC1/100',NULL,5,0,0,0,'EA4CC9EFCE90F51ABD40FF9B46E9BC9A',1761032301649,0,0,0,0,0),
(1679188110424,'凯迪客','https://jetpack2023.oss-cn-shanghai.aliyuncs.com/839a7232aa5a4f2e94b4c87be00b55f6.png','凯迪拉克不拉客，只拉妹妹和模特',8582201,0,0,34108,'1679188110424',0,0,0,0,3,0),
(1679188110580,'吴彦祖娇躯一颤轻声道：','https://jetpack2023.oss-cn-shanghai.aliyuncs.com/1a69563be83d4f938964aeaa82c6d607.png','',NULL,0,0,0,'1679188110580',0,0,0,0,0,0),
(1679188170706,'凊《','https://jetpack2023.oss-cn-shanghai.aliyuncs.com/b5242143203149e7bfc96951e50ae687.png','',152740,0,0,2097,'1679188170706',0,0,0,0,0,0),
(1679188172121,'皮皮侠046','https://jetpack2023.oss-cn-shanghai.aliyuncs.com/3321dbffd6d2446b9ce30157990aadb8.png','',0,0,0,0,'1679188172121',0,0,0,0,0,0),
(1754969494801,'方小盛','https://p6-ppx-sign.byteimg.com/tos-cn-i-0000/1552b806a60a437bb00b2630b6a3bee2~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=NkooqGiJD%2BcRm%2BMcqPe1UuusBkk%3D','',7072900,0,0,19804,'492220634376847',0,0,0,0,0,0),
(1754969494884,'重逢之后啊','https://p9-ppx-sign.byteimg.com/tos-cn-i-8gu37r9deh/dde49906b03b442497c776cd4d34c0b9~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=Sn6HkjnMisazeSwBtinYEsSBM4w%3D','',0,0,0,0,'6413361838',0,0,0,0,0,0),
(1754969494885,'SpaceX-空间观察','https://p6-ppx-sign.byteimg.com/tos-cn-i-0000/a1df4f767d534e818454c9363ad435c9~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=Vcg6iUJdZRo%2F5toSxWR7m10Q3kk%3D','。。。。',0,0,0,0,'82331339530',0,0,0,0,0,0),
(1754969494886,'.5343724（段）','https://p9-ppx-sign.byteimg.com/tos-cn-i-0000/2becd572c3a64c78b433c5095f9bd090~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=bVReeQhS6xd8cZvXL927Fhc%2BSpM%3D','',0,0,0,0,'96598058990',0,0,0,0,0,0),
(1754969494887,'四川彭于晏古蔺分晏','https://p6-ppx-sign.byteimg.com/mosaic-legacy/17810004c10c8c0dda27~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=RVRx3Qes%2FBvzRr1tr1%2BeW7ab1W8%3D','',0,0,0,0,'58279416591',0,0,0,0,0,0),
(1754969766023,'方小盛','https://p6-ppx-sign.byteimg.com/tos-cn-i-0000/1552b806a60a437bb00b2630b6a3bee2~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=NkooqGiJD%2BcRm%2BMcqPe1UuusBkk%3D','',7072900,0,0,19804,'492220634376847',0,0,0,0,0,0),
(1754969766098,'重逢之后啊','https://p9-ppx-sign.byteimg.com/tos-cn-i-8gu37r9deh/dde49906b03b442497c776cd4d34c0b9~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=Sn6HkjnMisazeSwBtinYEsSBM4w%3D','',0,0,0,0,'6413361838',0,0,0,0,0,0),
(1754969766099,'SpaceX-空间观察','https://p6-ppx-sign.byteimg.com/tos-cn-i-0000/a1df4f767d534e818454c9363ad435c9~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=Vcg6iUJdZRo%2F5toSxWR7m10Q3kk%3D','。。。。',0,0,0,0,'82331339530',0,0,0,0,0,0),
(1754969766100,'.5343724（段）','https://p9-ppx-sign.byteimg.com/tos-cn-i-0000/2becd572c3a64c78b433c5095f9bd090~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=bVReeQhS6xd8cZvXL927Fhc%2BSpM%3D','',0,0,0,0,'96598058990',0,0,0,0,0,0),
(1754969766101,'四川彭于晏古蔺分晏','https://p6-ppx-sign.byteimg.com/mosaic-legacy/17810004c10c8c0dda27~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=RVRx3Qes%2FBvzRr1tr1%2BeW7ab1W8%3D','',0,0,0,0,'58279416591',0,0,0,0,0,0),
(1754969766102,'皮皮侠89774661','https://p9-ppx-sign.byteimg.com/tos-cn-i-0000/cd4b83dd14294744a0f007454c3dd9a6~tplv-f3gpralwbh-image.image?x-expires=1717297890&x-signature=e2ydOx%2F%2B8gY9Q08Y82hWk2J6LzI%3D','',0,0,0,0,'2834960246121636',0,0,0,0,0,0);

/*Table structure for table `table_user_follow` */

DROP TABLE IF EXISTS `table_user_follow`;

CREATE TABLE `table_user_follow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `has_follow` int(11) NOT NULL,
  `follow_user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_follow` (`user_id`,`follow_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_user_follow` */

/*Table structure for table `table_watch_history` */

DROP TABLE IF EXISTS `table_watch_history`;

CREATE TABLE `table_watch_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `time` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_item` (`user_id`,`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `table_watch_history` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
