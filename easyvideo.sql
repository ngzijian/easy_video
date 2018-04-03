/*
MySQL Data Transfer
Source Host: localhost
Source Database: easyvideo
Target Host: localhost
Target Database: easyvideo
Date: 2018/3/25 17:32:14
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for ev_admin
-- ----------------------------
CREATE TABLE `ev_admin` (
  `ad_id` int(11) NOT NULL AUTO_INCREMENT,
  `ad_name` varchar(64) NOT NULL,
  `ad_pass` varchar(128) NOT NULL,
  `ad_state` int(11) DEFAULT '0',
  PRIMARY KEY (`ad_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_category
-- ----------------------------
CREATE TABLE `ev_category` (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(32) DEFAULT NULL,
  `cate_summary` varchar(255) DEFAULT NULL,
  `cate_inserttime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_comm
-- ----------------------------
CREATE TABLE `ev_comm` (
  `comm_id` int(11) NOT NULL AUTO_INCREMENT,
  `comm_content` varchar(255) DEFAULT NULL,
  `comm_ptime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `vid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`comm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_fav_user
-- ----------------------------
CREATE TABLE `ev_fav_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid1` int(11) DEFAULT NULL,
  `uid2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_fav_video
-- ----------------------------
CREATE TABLE `ev_fav_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_login_record
-- ----------------------------
CREATE TABLE `ev_login_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `logintime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_user
-- ----------------------------
CREATE TABLE `ev_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_nickname` varchar(255) DEFAULT NULL,
  `user_phone` varchar(16) DEFAULT NULL,
  `user_password` varchar(128) DEFAULT NULL,
  `user_regtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_sex` char(2) DEFAULT NULL,
  `user_email` varchar(128) DEFAULT NULL,
  `user_birth` date DEFAULT NULL,
  `user_pic` varchar(128) DEFAULT NULL,
  `user_status` int(11) DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_video
-- ----------------------------
CREATE TABLE `ev_video` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) DEFAULT NULL,
  `video_uploadtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `video_path` varchar(255) DEFAULT NULL,
  `video_viewcount` int(11) DEFAULT '0',
  `video_favcount` int(11) DEFAULT '0',
  `uid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `video_status` int(11) DEFAULT '0',
  `video_pic` varchar(255) DEFAULT NULL,
  `video_comms` int(11) DEFAULT '0',
  `fav_uid` text,
  `video_info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ev_web_info
-- ----------------------------
CREATE TABLE `ev_web_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `icp` varchar(64) DEFAULT NULL,
  `comname` varchar(32) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `ev_admin` VALUES ('7', 'softeem', '123456', '0');
INSERT INTO `ev_admin` VALUES ('8', 'sd', 'ghj', '1');
INSERT INTO `ev_category` VALUES ('2', '搞笑', '搞笑搞笑', '2018-01-25 16:31:03');
INSERT INTO `ev_category` VALUES ('3', '明星', '明星明星', '2018-01-25 16:31:14');
INSERT INTO `ev_category` VALUES ('4', '舞蹈', '舞蹈舞蹈舞蹈', '2018-01-25 16:31:26');
INSERT INTO `ev_category` VALUES ('5', '美女', '美女美女美女', '2018-01-25 16:31:40');
INSERT INTO `ev_category` VALUES ('6', '健身', '健身健身', '2018-01-25 16:31:56');
INSERT INTO `ev_category` VALUES ('7', '帅哥', '帅哥帅哥', '2018-01-25 16:32:10');
INSERT INTO `ev_category` VALUES ('8', '达人', '达人达人', '2018-01-25 16:32:39');
INSERT INTO `ev_category` VALUES ('9', '美食', '美食美食', '2018-01-25 16:32:58');
INSERT INTO `ev_category` VALUES ('10', '野外', '野外野外', '2018-01-25 16:33:13');
INSERT INTO `ev_category` VALUES ('11', '游戏', '游戏游戏', '2018-01-25 16:33:29');
INSERT INTO `ev_category` VALUES ('12', '恶搞', '恶搞恶搞', '2018-01-25 16:36:45');
INSERT INTO `ev_category` VALUES ('13', '宠物', '宠物宠物', '2018-01-25 16:37:47');
INSERT INTO `ev_category` VALUES ('14', '少儿', '少儿少儿', '2018-01-25 16:38:25');
INSERT INTO `ev_category` VALUES ('15', '科技', '科技科技', '2018-01-25 16:38:46');
INSERT INTO `ev_comm` VALUES ('1', 'asdf', '2018-02-09 10:28:08', '1', '2', null);
INSERT INTO `ev_comm` VALUES ('2', '撒旦v房', '2018-02-09 11:31:36', '103', '1', '36');
INSERT INTO `ev_comm` VALUES ('3', '喔', '2018-02-09 11:46:49', '123', '1', null);
INSERT INTO `ev_comm` VALUES ('4', '喔', '2018-02-09 11:47:05', '123', '1', null);
INSERT INTO `ev_comm` VALUES ('5', '阿萨德v房', '2018-02-09 11:47:38', '123', '1', null);
INSERT INTO `ev_comm` VALUES ('6', '学校旁', '2018-02-09 11:48:15', '123', '1', null);
INSERT INTO `ev_comm` VALUES ('7', '撒旦法规和', '2018-02-09 16:31:34', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('8', '水电费都不', '2018-02-09 17:47:43', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('9', '所谓的', '2018-02-09 17:48:29', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('10', '五典三坟', '2018-02-09 17:51:38', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('11', '第三代', '2018-02-09 17:52:59', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('12', '是的v房并轨能更好', '2018-02-09 17:54:02', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('13', '撒到法国', '2018-02-09 17:57:58', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('14', '的说法v从', '2018-02-09 17:58:57', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('15', '双方都规范和', '2018-02-09 18:02:16', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('16', '容不下我的痴', '2018-02-09 20:03:55', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('17', '容不下我的痴', '2018-02-09 20:03:59', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('18', '我听见余地', '2018-02-09 20:13:49', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('19', '我听见余地', '2018-02-09 20:13:50', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('20', '我听见余地', '2018-02-09 20:13:51', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('21', '我听见余地', '2018-02-09 20:13:55', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('22', '我听见远方下课钟声响起', '2018-02-09 20:15:43', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('23', '上大学', '2018-02-09 21:09:51', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('24', '万德福v地方', '2018-02-09 21:11:33', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('25', '卫夫人负担不高', '2018-02-09 21:13:53', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('26', '高海拔今年', '2018-02-09 21:14:35', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('27', '成功后就不', '2018-02-09 21:15:38', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('28', '但是v风格', '2018-02-09 21:18:17', '162', '1', null);
INSERT INTO `ev_comm` VALUES ('29', '阿萨德撒旦v安时处顺的', '2018-02-09 21:30:07', '104', '1', null);
INSERT INTO `ev_comm` VALUES ('30', '而我房v反对', '2018-02-09 21:42:49', '163', '1', null);
INSERT INTO `ev_comm` VALUES ('31', '发到八卦肥牛火锅', '2018-02-10 11:12:22', '120', '1', null);
INSERT INTO `ev_comm` VALUES ('32', '似懂非懂 ', '2018-02-10 11:32:07', '120', '1', null);
INSERT INTO `ev_comm` VALUES ('33', '似懂非懂 ', '2018-02-10 11:32:08', '120', '1', null);
INSERT INTO `ev_comm` VALUES ('34', '但是v反对', '2018-02-10 11:32:23', '120', '1', null);
INSERT INTO `ev_comm` VALUES ('35', '是的', '2018-02-10 11:33:37', '120', '1', null);
INSERT INTO `ev_comm` VALUES ('36', '东窗事发的 ', '2018-02-10 16:08:05', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('37', '热锅突然很', '2018-02-10 16:08:17', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('38', 'jkjkl ', '2018-02-10 16:46:06', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('39', 'yguhilj ', '2018-02-10 16:47:29', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('40', '噩梦', '2018-02-10 16:58:30', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('41', '撒的身份', '2018-02-10 17:04:17', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('42', '阿萨德v房', '2018-02-10 17:04:59', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('43', '是的v房', '2018-02-10 17:05:18', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('44', '是的v风格', '2018-02-10 17:06:04', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('45', '是的v地方', '2018-02-10 17:06:22', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('46', '双方都功能和 ', '2018-02-10 17:06:42', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('47', '爱的方式改革 ', '2018-02-10 17:06:58', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('48', '爱的方式改革 的说法', '2018-02-10 17:07:08', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('49', '暗示对方的', '2018-02-10 18:01:42', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('50', 'vfd', '2018-02-10 18:03:31', '103', '1', null);
INSERT INTO `ev_comm` VALUES ('51', '爱的色放', '2018-02-10 18:07:45', '103', '1', '47');
INSERT INTO `ev_comm` VALUES ('52', '暗示大多数地方地方的奋斗', '2018-02-10 18:10:31', '103', '1', '51');
INSERT INTO `ev_comm` VALUES ('53', '大是大非', '2018-02-10 18:11:04', '103', '1', '52');
INSERT INTO `ev_comm` VALUES ('54', '显示出的v翻遍你', '2018-02-10 18:15:00', '103', '1', '49');
INSERT INTO `ev_comm` VALUES ('55', '你说', '2018-02-10 18:15:32', '167', '1', '0');
INSERT INTO `ev_comm` VALUES ('56', '仨人沟通和画面', '2018-02-10 18:15:48', '167', '1', '55');
INSERT INTO `ev_comm` VALUES ('57', '撒旦 ', '2018-02-10 19:02:07', '103', '1', '0');
INSERT INTO `ev_comm` VALUES ('58', '撒旦 阿萨德', '2018-02-10 19:02:09', '103', '1', '0');
INSERT INTO `ev_comm` VALUES ('59', '撒旦 阿萨德奥德赛 ', '2018-02-10 19:02:11', '103', '1', '0');
INSERT INTO `ev_comm` VALUES ('60', '安慰的放入', '2018-02-10 19:58:14', '114', '1', '0');
INSERT INTO `ev_comm` VALUES ('61', '无非温热', '2018-02-10 19:58:22', '114', '1', '60');
INSERT INTO `ev_comm` VALUES ('62', '但是', '2018-02-10 20:22:16', '164', '1', '0');
INSERT INTO `ev_comm` VALUES ('63', '法语歌ihioj', '2018-02-11 09:06:48', '108', '1', '0');
INSERT INTO `ev_comm` VALUES ('64', '分割成v金口难开', '2018-02-11 09:06:59', '108', '1', '63');
INSERT INTO `ev_comm` VALUES ('65', '但是v反对', '2018-03-09 17:03:56', '172', '1', '0');
INSERT INTO `ev_comm` VALUES ('66', 'urhvfd', '2018-03-09 17:04:59', '172', '1', '65');
INSERT INTO `ev_user` VALUES ('1', 'zijian', '18571466945', '123456', '2018-01-26 16:42:13', '0', '766166543@qq.com', '2018-01-01', 'upload/user/u=1611505379,380489200&fm=214&gp=0.jpg', '1');
INSERT INTO `ev_user` VALUES ('2', 'baolei', '13224354364', 'fsvdf', '2018-01-29 19:51:12', '0', '127097253@qq.com', '2018-01-29', 'upload/user/u=1163748697,1760241494&fm=27&gp=0.jpg', '1');
INSERT INTO `ev_video` VALUES ('103', '王大陆', '2018-02-07 06:25:12', 'upload/video/temp/2018/02/07/0ff89d8ee5e1416b99a73798c37d8609_35a7075a29e62d1937.mp4', '84', '1', '1', '3', '0', 'upload/pic/2018/02/07/0ff89d8ee5e1416b99a73798c37d8609_35a7075a29e62d1937.jpg', '18', '1,', 'fsdgfhdj');
INSERT INTO `ev_video` VALUES ('104', '金刚芭比', '2018-02-07 11:21:52', 'upload/video/temp/2018/02/07/ce2a59cd1d094d19ac5d8c0971a89483_15a6d6accc0c373646_H264_15.mp4', '3', '0', '1', '6', '0', 'upload/pic/2018/02/07/ce2a59cd1d094d19ac5d8c0971a89483_15a6d6accc0c373646_H264_15.jpg', '0', null, 'g');
INSERT INTO `ev_video` VALUES ('105', '', '2018-02-07 11:23:16', 'upload/video/temp/2018/02/07/347e5e10d86e4abe863dc0d27268f33c_45a705da79929c8555_H264_3.mp4', '3', '1', '1', '2', '0', 'upload/pic/2018/02/07/347e5e10d86e4abe863dc0d27268f33c_45a705da79929c8555_H264_3.jpg', '0', '1,', 'df');
INSERT INTO `ev_video` VALUES ('106', '', '2018-02-07 11:24:20', 'upload/video/temp/2018/02/07/1ccc09d9767a4a0b956e00680681acbc_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/1ccc09d9767a4a0b956e00680681acbc_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'gd');
INSERT INTO `ev_video` VALUES ('107', '', '2018-02-07 11:25:50', 'upload/video/temp/2018/02/07/7b3f13fc15d0437f8602ccb80f2f9d4a_55a6fe4ca6cf609681_H264_3.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/7b3f13fc15d0437f8602ccb80f2f9d4a_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'fg');
INSERT INTO `ev_video` VALUES ('108', '', '2018-02-07 11:38:05', 'upload/video/temp/2018/02/07/36853d7948ed4706b7045a48ba67b63b_65a6f2deb6643e9695_H264_15.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/36853d7948ed4706b7045a48ba67b63b_65a6f2deb6643e9695_H264_15.jpg', '2', null, 'ds');
INSERT INTO `ev_video` VALUES ('109', '按时打算', '2018-02-07 11:40:07', 'upload/video/temp/2018/02/07/78fc42f948c645299514594899555151_25a69626be672f7007_H264_125.mp4', '0', '0', '1', '5', '0', 'upload/pic/2018/02/07/78fc42f948c645299514594899555151_25a69626be672f7007_H264_125.jpg', '0', null, 'fg');
INSERT INTO `ev_video` VALUES ('110', ' 城是 ', '2018-02-07 11:41:59', 'upload/video/temp/2018/02/07/0cd1d104efda4e65b3ea77c3885d983e_45a705da79929c8555_H264_3.mp4', '0', '0', '1', '7', '0', 'upload/pic/2018/02/07/0cd1d104efda4e65b3ea77c3885d983e_45a705da79929c8555_H264_3.jpg', '0', null, 'sd');
INSERT INTO `ev_video` VALUES ('111', '撒旦', '2018-02-07 11:43:05', 'upload/video/temp/2018/02/07/2f03b2bb17204bb39b97063a4b18df70_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '8', '0', 'upload/pic/2018/02/07/2f03b2bb17204bb39b97063a4b18df70_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'g');
INSERT INTO `ev_video` VALUES ('112', '我吃的是', '2018-02-07 11:45:07', 'upload/video/temp/2018/02/07/d9af30e865fb455b8b2583fc50ab4d92_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '9', '0', 'upload/pic/2018/02/07/d9af30e865fb455b8b2583fc50ab4d92_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'gsdfsdf');
INSERT INTO `ev_video` VALUES ('113', '我吃的是', '2018-02-07 11:46:06', 'upload/video/temp/2018/02/07/b6f7797edbf4440eb1a5bf9643b93930_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '9', '0', 'upload/pic/2018/02/07/b6f7797edbf4440eb1a5bf9643b93930_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'gsdfg');
INSERT INTO `ev_video` VALUES ('114', '', '2018-02-07 11:46:19', 'upload/video/temp/2018/02/07/59c2f57074c9401b8850a800f3583442_45a705da79929c8555_H264_3.mp4', '18', '0', '1', '4', '0', 'upload/pic/2018/02/07/59c2f57074c9401b8850a800f3583442_45a705da79929c8555_H264_3.jpg', '2', null, 'gsdfds');
INSERT INTO `ev_video` VALUES ('115', '', '2018-02-07 11:46:45', 'upload/video/temp/2018/02/07/19867e95e0ed4e04b006cddbaf766685_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/19867e95e0ed4e04b006cddbaf766685_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'sgdfg');
INSERT INTO `ev_video` VALUES ('116', '', '2018-02-07 11:47:25', 'upload/video/temp/2018/02/07/fad42bd32013468e8df7a50835b931a3_45a705da79929c8555_H264_3.mp4', '8', '0', '1', '2', '0', 'upload/pic/2018/02/07/fad42bd32013468e8df7a50835b931a3_45a705da79929c8555_H264_3.jpg', '0', null, 'gsdfgdf');
INSERT INTO `ev_video` VALUES ('117', ' 城是的 ', '2018-02-07 12:06:40', 'upload/video/temp/2018/02/07/5b72e5baf4c44f9d8ec2d46804291528_35a7075a29e62d1937.jpg', '0', '0', '1', '7', '0', 'upload/pic/2018/02/07/5b72e5baf4c44f9d8ec2d46804291528_35a7075a29e62d1937.jpg', '0', null, 'gdsgs');
INSERT INTO `ev_video` VALUES ('118', '', '2018-02-07 12:08:04', 'upload/video/temp/2018/02/07/db8fbbe00bbc4246bdb5bf3920e2a887_25a69626be672f7007_H264_125.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/db8fbbe00bbc4246bdb5bf3920e2a887_25a69626be672f7007_H264_125.jpg', '0', null, 'gsgfd');
INSERT INTO `ev_video` VALUES ('119', '', '2018-02-07 12:10:04', 'upload/video/temp/2018/02/07/e0946ca44ca04d638d9a49cabb25784b_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/e0946ca44ca04d638d9a49cabb25784b_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'regea');
INSERT INTO `ev_video` VALUES ('120', ' 是的v风格', '2018-02-07 12:11:19', 'upload/video/temp/2018/02/07/04ec7cd3aa5b4989be15df3b9dda93c2_55a6fe4ca6cf609681_H264_3.mp4', '19', '0', '1', '5', '0', 'upload/pic/2018/02/07/04ec7cd3aa5b4989be15df3b9dda93c2_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'xcvfdre');
INSERT INTO `ev_video` VALUES ('121', '', '2018-02-07 12:12:46', 'upload/video/temp/2018/02/07/fe088d8d8ea147eba1d242cb55560e55_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/fe088d8d8ea147eba1d242cb55560e55_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'rwetgrhdfgbcv');
INSERT INTO `ev_video` VALUES ('122', '', '2018-02-07 12:14:27', 'upload/video/temp/2018/02/07/cbdea92cef504d468a1988d5c1f3ae33_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/cbdea92cef504d468a1988d5c1f3ae33_55a6fe4ca6cf609681_H264_3.jpg', '0', null, '546576543');
INSERT INTO `ev_video` VALUES ('123', '', '2018-02-07 12:14:45', 'upload/video/temp/2018/02/07/2c37bce7dff94fc9a1d8e825a28419e4_55a6fe4ca6cf609681_H264_3.mp4', '5', '0', '1', '2', '0', 'upload/pic/2018/02/07/2c37bce7dff94fc9a1d8e825a28419e4_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'weargetryt');
INSERT INTO `ev_video` VALUES ('124', '', '2018-02-07 12:14:55', 'upload/video/temp/2018/02/07/aebbde8607a84a7aa0917ee85776b657_15a6d6accc0c373646_H264_15.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/aebbde8607a84a7aa0917ee85776b657_15a6d6accc0c373646_H264_15.jpg', '0', null, 'dfgrthyhgtfds');
INSERT INTO `ev_video` VALUES ('125', '', '2018-02-07 12:18:15', 'upload/video/temp/2018/02/07/c21e41596e164285a03464740ab1e38c_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '8', '0', 'upload/pic/2018/02/07/c21e41596e164285a03464740ab1e38c_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'efrgtrhtgrfed');
INSERT INTO `ev_video` VALUES ('126', '', '2018-02-07 12:18:50', 'upload/video/temp/2018/02/07/c0d6d70ea60047e2bb91c1b899a1d567_35a7075a29e62d1937.mp4', '1', '1', '1', '8', '0', 'upload/pic/2018/02/07/c0d6d70ea60047e2bb91c1b899a1d567_35a7075a29e62d1937.jpg', '0', '1,', 'ertythtgdfs');
INSERT INTO `ev_video` VALUES ('127', '', '2018-02-07 12:19:22', 'upload/video/temp/2018/02/07/bc7b09b08d024433be769e763ab20661_55a6fe4ca6cf609681_H264_3.mp4', '8', '0', '1', '8', '0', 'upload/pic/2018/02/07/bc7b09b08d024433be769e763ab20661_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'ertyuiurtre');
INSERT INTO `ev_video` VALUES ('128', '', '2018-02-07 12:20:07', 'upload/video/temp/2018/02/07/8fd9c0f73c654249a098351ff194c3a6_15a6d6accc0c373646_H264_15.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/8fd9c0f73c654249a098351ff194c3a6_15a6d6accc0c373646_H264_15.jpg', '0', null, 'retuitytrew');
INSERT INTO `ev_video` VALUES ('129', '', '2018-02-07 12:20:49', 'upload/video/temp/2018/02/07/ce7b791f5a724497ada0eb320014a866_45a705da79929c8555_H264_3.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/ce7b791f5a724497ada0eb320014a866_45a705da79929c8555_H264_3.jpg', '0', null, 'rtyrutituytdre');
INSERT INTO `ev_video` VALUES ('130', '', '2018-02-07 12:21:23', 'upload/video/temp/2018/02/07/29d47cc8cdc44b59ab33a8a5ac8407d2_45a705da79929c8555_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/29d47cc8cdc44b59ab33a8a5ac8407d2_45a705da79929c8555_H264_3.jpg', '0', null, 'rethtyryutkujy');
INSERT INTO `ev_video` VALUES ('131', '', '2018-02-07 12:21:30', 'upload/video/temp/2018/02/07/dd4f0e20c27542b297d00919f11f4cbb_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/dd4f0e20c27542b297d00919f11f4cbb_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'e32');
INSERT INTO `ev_video` VALUES ('132', '', '2018-02-07 12:21:58', 'upload/video/temp/2018/02/07/3e23b204b82e4a159c8406b8b5154511_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/3e23b204b82e4a159c8406b8b5154511_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'rqqwtyfsda');
INSERT INTO `ev_video` VALUES ('133', '', '2018-02-07 12:22:03', 'upload/video/temp/2018/02/07/b2f1703af21144aab8e225c2eeca8e2f_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/b2f1703af21144aab8e225c2eeca8e2f_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'rwqeetryh');
INSERT INTO `ev_video` VALUES ('134', '', '2018-02-07 12:22:03', 'upload/video/temp/2018/02/07/98747e57b66d4d59abfc901fbb79e01f_55a6fe4ca6cf609681_H264_3.mp4', '2', '1', '1', '2', '0', 'upload/pic/2018/02/07/98747e57b66d4d59abfc901fbb79e01f_55a6fe4ca6cf609681_H264_3.jpg', '0', '1,', 'rqwewt');
INSERT INTO `ev_video` VALUES ('135', '', '2018-02-07 12:22:04', 'upload/video/temp/2018/02/07/ca5bb783d87d4c3aa8f2159825c0913a_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/ca5bb783d87d4c3aa8f2159825c0913a_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'wwerqwgtr');
INSERT INTO `ev_video` VALUES ('136', '', '2018-02-07 12:22:04', 'upload/video/temp/2018/02/07/30750ed85b5a4dcc965a17f5efdeddc0_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/30750ed85b5a4dcc965a17f5efdeddc0_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 're');
INSERT INTO `ev_video` VALUES ('137', '', '2018-02-07 12:22:05', 'upload/video/temp/2018/02/07/d6d3f659ffe3424db408a8b1f5818010_55a6fe4ca6cf609681_H264_3.mp4', '13', '0', '1', '2', '0', 'upload/pic/2018/02/07/d6d3f659ffe3424db408a8b1f5818010_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'ewrq');
INSERT INTO `ev_video` VALUES ('138', '', '2018-02-07 12:22:06', 'upload/video/temp/2018/02/07/694684e1d02c47fcb92f5c7c6ff6c6e4_55a6fe4ca6cf609681_H264_3.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/694684e1d02c47fcb92f5c7c6ff6c6e4_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'rwe');
INSERT INTO `ev_video` VALUES ('139', '', '2018-02-07 12:22:10', 'upload/video/temp/2018/02/07/750559b63b2a418b9fc78e584b494560_55a6fe4ca6cf609681_H264_3.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/750559b63b2a418b9fc78e584b494560_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'qwery');
INSERT INTO `ev_video` VALUES ('140', '', '2018-02-07 12:22:11', 'upload/video/temp/2018/02/07/0512c79f231544ccb4fdc2515d8b75dd_55a6fe4ca6cf609681_H264_3.mp4', '4', '0', '1', '2', '0', 'upload/pic/2018/02/07/0512c79f231544ccb4fdc2515d8b75dd_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'wer');
INSERT INTO `ev_video` VALUES ('141', '', '2018-02-07 12:22:11', 'upload/video/temp/2018/02/07/36c6366fc05940d99e56e921da25c694_55a6fe4ca6cf609681_H264_3.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/36c6366fc05940d99e56e921da25c694_55a6fe4ca6cf609681_H264_3.jpg', '0', null, 'ewr');
INSERT INTO `ev_video` VALUES ('142', '', '2018-02-07 12:22:17', 'upload/video/temp/2018/02/07/22a48ba6b5d1443c86a06adca98ddc36_65a6f2deb6643e9695_H264_15.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/22a48ba6b5d1443c86a06adca98ddc36_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'rwe');
INSERT INTO `ev_video` VALUES ('143', '', '2018-02-07 12:22:24', 'upload/video/temp/2018/02/07/25597c8549804833840949885c299297_75a6de7b70553a6442.mp4', '3', '0', '1', '2', '0', 'upload/pic/2018/02/07/25597c8549804833840949885c299297_75a6de7b70553a6442.jpg', '0', null, 'qrwewgt');
INSERT INTO `ev_video` VALUES ('144', '', '2018-02-07 12:22:30', 'upload/video/temp/2018/02/07/d453b422b2ee47ed8ba9b4c2892fd30c_75a6de7b70553a6442.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/d453b422b2ee47ed8ba9b4c2892fd30c_75a6de7b70553a6442.jpg', '0', null, 'rwe');
INSERT INTO `ev_video` VALUES ('145', '', '2018-02-07 12:22:48', 'upload/video/temp/2018/02/07/4219de64078d4745b5f179a46d2108f3_75a6de7b70553a6442.mp4', '3', '0', '1', '2', '0', 'upload/pic/2018/02/07/4219de64078d4745b5f179a46d2108f3_75a6de7b70553a6442.jpg', '0', null, 'wergtr');
INSERT INTO `ev_video` VALUES ('146', '', '2018-02-07 12:22:54', 'upload/video/temp/2018/02/07/a82e057c023b46f4ad6b9c6e4786c43f_75a6de7b70553a6442.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/a82e057c023b46f4ad6b9c6e4786c43f_75a6de7b70553a6442.jpg', '0', null, 'v');
INSERT INTO `ev_video` VALUES ('147', '', '2018-02-07 12:22:56', 'upload/video/temp/2018/02/07/866b455ed6d548489d0a0e1eaacb0ad8_75a6de7b70553a6442.mp4', '9', '0', '1', '2', '0', 'upload/pic/2018/02/07/866b455ed6d548489d0a0e1eaacb0ad8_75a6de7b70553a6442.jpg', '0', null, 'adsf');
INSERT INTO `ev_video` VALUES ('148', '', '2018-02-07 12:22:57', 'upload/video/temp/2018/02/07/a17b0881e5084284956bc8a5c699f1e8_75a6de7b70553a6442.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/a17b0881e5084284956bc8a5c699f1e8_75a6de7b70553a6442.jpg', '0', null, 'fasdg');
INSERT INTO `ev_video` VALUES ('149', '', '2018-02-07 12:22:58', 'upload/video/temp/2018/02/07/bfff387578eb402ebfded3bb8d96ea53_75a6de7b70553a6442.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/bfff387578eb402ebfded3bb8d96ea53_75a6de7b70553a6442.jpg', '0', null, 'fsd');
INSERT INTO `ev_video` VALUES ('150', '', '2018-02-07 12:23:00', 'upload/video/temp/2018/02/07/94bd28744e1f4e0686a64aa0b32c04de_75a6de7b70553a6442.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/07/94bd28744e1f4e0686a64aa0b32c04de_75a6de7b70553a6442.jpg', '0', null, 'fsdas');
INSERT INTO `ev_video` VALUES ('151', '', '2018-02-07 12:23:03', 'upload/video/temp/2018/02/07/5411a44a2e634b84b960b308a80ec15f_75a6de7b70553a6442.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/5411a44a2e634b84b960b308a80ec15f_75a6de7b70553a6442.jpg', '0', null, 'fasfd');
INSERT INTO `ev_video` VALUES ('152', '', '2018-02-07 12:23:09', 'upload/video/temp/2018/02/07/2e9e44667b56429cbbf3db4e60d9af4a_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/2e9e44667b56429cbbf3db4e60d9af4a_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'e');
INSERT INTO `ev_video` VALUES ('153', '', '2018-02-07 12:23:11', 'upload/video/temp/2018/02/07/4c718c86d0dd419eb0f4db5b32ac1f34_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/4c718c86d0dd419eb0f4db5b32ac1f34_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'rsdfb');
INSERT INTO `ev_video` VALUES ('154', '', '2018-02-07 12:23:13', 'upload/video/temp/2018/02/07/662a43a30cd948838eba440af61e0d5b_65a6f2deb6643e9695_H264_15.mp4', '2', '0', '1', '2', '0', 'upload/pic/2018/02/07/662a43a30cd948838eba440af61e0d5b_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'f');
INSERT INTO `ev_video` VALUES ('155', '', '2018-02-07 12:23:13', 'upload/video/temp/2018/02/07/907b28d4da224483a00ccc8a1cf7955a_65a6f2deb6643e9695_H264_15.mp4', '2', '0', '1', '2', '0', 'upload/pic/2018/02/07/907b28d4da224483a00ccc8a1cf7955a_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'efrs');
INSERT INTO `ev_video` VALUES ('156', '', '2018-02-07 12:23:14', 'upload/video/temp/2018/02/07/847be40717a940fab4c6683b59bd5149_65a6f2deb6643e9695_H264_15.mp4', '3', '1', '1', '2', '0', 'upload/pic/2018/02/07/847be40717a940fab4c6683b59bd5149_65a6f2deb6643e9695_H264_15.jpg', '0', '1,', 'fwearsd');
INSERT INTO `ev_video` VALUES ('157', '', '2018-02-07 12:23:14', 'upload/video/temp/2018/02/07/9e7867f8f2544fc88aa29d8c168244be_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/9e7867f8f2544fc88aa29d8c168244be_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'wefa');
INSERT INTO `ev_video` VALUES ('158', '', '2018-02-07 12:23:14', 'upload/video/temp/2018/02/07/e568d237202e43998447cb2deac61077_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/e568d237202e43998447cb2deac61077_65a6f2deb6643e9695_H264_15.jpg', '0', null, ' 实现cfwess');
INSERT INTO `ev_video` VALUES ('159', '', '2018-02-07 12:23:14', 'upload/video/temp/2018/02/07/2bdd768009bb44bb877a3940c5829dcf_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/2bdd768009bb44bb877a3940c5829dcf_65a6f2deb6643e9695_H264_15.jpg', '0', null, 'wefr');
INSERT INTO `ev_video` VALUES ('160', '', '2018-02-07 12:23:15', 'upload/video/temp/2018/02/07/33282485d07049d2a48b01efc9009449_65a6f2deb6643e9695_H264_15.mp4', '0', '0', '1', '2', '0', 'upload/pic/2018/02/07/33282485d07049d2a48b01efc9009449_65a6f2deb6643e9695_H264_15.jpg', '0', null, '确认为士大夫vsd');
INSERT INTO `ev_video` VALUES ('161', '', '2018-02-07 12:23:15', 'upload/video/temp/2018/02/07/f046ea4aec1b4faaa21ff1e58eac51b8_65a6f2deb6643e9695_H264_15.mp4', '2', '0', '1', '2', '0', 'upload/pic/2018/02/07/f046ea4aec1b4faaa21ff1e58eac51b8_65a6f2deb6643e9695_H264_15.jpg', '0', null, '你那里昆明；');
INSERT INTO `ev_video` VALUES ('162', '', '2018-02-07 12:23:16', 'upload/video/temp/2018/02/07/874d82fdc4124f869ea3c1370bd10735_65a6f2deb6643e9695_H264_15.mp4', '54', '1', '1', '2', '0', 'upload/pic/2018/02/07/874d82fdc4124f869ea3c1370bd10735_65a6f2deb6643e9695_H264_15.jpg', '0', '1,', '可能离开吗；');
INSERT INTO `ev_video` VALUES ('163', '', '2018-02-07 12:23:16', 'upload/video/temp/2018/02/07/f9d129f989c640499145a26070f8a71a_65a6f2deb6643e9695_H264_15.mp4', '22', '1', '1', '2', '0', 'upload/pic/2018/02/07/f9d129f989c640499145a26070f8a71a_65a6f2deb6643e9695_H264_15.jpg', '0', '1,', 'wergr');
INSERT INTO `ev_video` VALUES ('164', '', '2018-02-07 12:23:16', 'upload/video/temp/2018/02/07/f9e43b6d59354a239c25913bdffb6889_65a6f2deb6643e9695_H264_15.mp4', '8', '1', '1', '2', '0', 'upload/pic/2018/02/07/f9e43b6d59354a239c25913bdffb6889_65a6f2deb6643e9695_H264_15.jpg', '1', '1,', '单人床，；‘ 空么了；让对方fsd');
INSERT INTO `ev_video` VALUES ('165', '而非', '2018-02-10 15:46:56', 'upload/video/temp/2018/02/10/48081b33b0204e0e82c508a678355147_65a6f2deb6643e9695_H264_15.mp4', '4', '0', '1', '6', '0', 'upload/pic/2018/02/10/48081b33b0204e0e82c508a678355147_65a6f2deb6643e9695_H264_15.jpg', '0', null, null);
INSERT INTO `ev_video` VALUES ('166', ' vef', '2018-02-10 15:48:36', 'upload/video/temp/2018/02/10/126df97687904499a879fcd27afd16f9_45a705da79929c8555_H264_3.mp4', '1', '0', '1', '6', '0', 'upload/pic/2018/02/10/126df97687904499a879fcd27afd16f9_45a705da79929c8555_H264_3.jpg', '0', null, null);
INSERT INTO `ev_video` VALUES ('167', '撒旦是', '2018-02-10 15:49:18', 'upload/video/temp/2018/02/10/a5ec0599710f470f89cbbd1123557a11_75a6de7b70553a6442.mp4', '4', '1', '1', '2', '0', 'upload/pic/2018/02/10/a5ec0599710f470f89cbbd1123557a11_75a6de7b70553a6442.jpg', '2', '1,', null);
INSERT INTO `ev_video` VALUES ('168', '按时发的部分', '2018-02-10 18:19:24', 'upload/video/temp/2018/02/10/bf9fb0269ba8463e82a0946c17ddc1cd_75a6de7b70553a6442.mp4', '0', '0', '1', '9', '0', 'upload/pic/2018/02/10/bf9fb0269ba8463e82a0946c17ddc1cd_75a6de7b70553a6442.jpg', '0', null, null);
INSERT INTO `ev_video` VALUES ('169', '', '2018-02-10 18:19:37', 'upload/video/temp/2018/02/10/919f2cf047bc45a0985fa486352ea278_45a705da79929c8555_H264_3.mp4', '1', '0', '1', '2', '0', 'upload/pic/2018/02/10/919f2cf047bc45a0985fa486352ea278_45a705da79929c8555_H264_3.jpg', '0', null, null);
INSERT INTO `ev_video` VALUES ('170', ' 阿萨德v的 ', '2018-02-10 18:19:51', 'upload/video/temp/2018/02/10/f4af3757655c4c1095f5328f418fb0ea_45a705da79929c8555_H264_3.mp4', '0', '0', '1', '7', '0', 'upload/pic/2018/02/10/f4af3757655c4c1095f5328f418fb0ea_45a705da79929c8555_H264_3.jpg', '0', null, null);
INSERT INTO `ev_video` VALUES ('171', '', '2018-02-10 18:20:01', 'upload/video/temp/2018/02/10/b370d170174a4651a77d7bec52cc0276_55a6fe4ca6cf609681_H264_3.mp4', '2', '1', '1', '2', '0', 'upload/pic/2018/02/10/b370d170174a4651a77d7bec52cc0276_55a6fe4ca6cf609681_H264_3.jpg', '0', '1,', null);
INSERT INTO `ev_video` VALUES ('172', '大发慈悲', '2018-02-10 21:58:10', 'upload/video/temp/2018/02/10/7d8d6496bb9f4ec1b79e16b245287d93_55a6fe4ca6cf609681_H264_3.mp4', '1', '0', '1', '5', '0', 'upload/pic/2018/02/10/7d8d6496bb9f4ec1b79e16b245287d93_55a6fe4ca6cf609681_H264_3.jpg', '2', null, null);
INSERT INTO `ev_video` VALUES ('173', '', '2018-02-10 21:59:57', 'upload/video/temp/2018/02/10/af247fef09db4be6bcd339a7507e906c_45a705da79929c8555_H264_3.mp4', '3', '0', '1', '2', '0', 'upload/pic/2018/02/10/af247fef09db4be6bcd339a7507e906c_45a705da79929c8555_H264_3.jpg', '0', null, null);
INSERT INTO `ev_video` VALUES ('174', ' 大时代v房', '2018-03-09 21:50:27', 'upload/video/temp/2018/03/09/fd9f3ca6e0d4408eb56abedaf54078a3_jspSmartUpload.jar包 官方免费版_96@539815.exe', '0', '0', '1', '5', '0', 'upload/pic/2018/03/09/fd9f3ca6e0d4408eb56abedaf54078a3_jspSmartUpload.jar包 官方免费版_96@539815.jpg', '0', null, null);
