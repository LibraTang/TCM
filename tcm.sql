/*
 Navicat MySQL Data Transfer

 Source Server         : tcm
 Source Server Type    : MySQL
 Source Server Version : 100327
 Source Host           : localhost:3306
 Source Schema         : tcm

 Target Server Type    : MySQL
 Target Server Version : 100327
 File Encoding         : 65001

 Date: 10/04/2021 20:36:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tcm_chat
-- ----------------------------
DROP TABLE IF EXISTS `tcm_chat`;
CREATE TABLE `tcm_chat` (
  `cid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `fuid` int(11) NOT NULL COMMENT 'from用户',
  `tuid` int(11) NOT NULL COMMENT 'to用户',
  `chatid` varchar(20) NOT NULL COMMENT '会话id冗余用于查询',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `status` tinyint(1) NOT NULL COMMENT '状态',
  `ctime` bigint(20) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tcm_chat
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_notify
-- ----------------------------
DROP TABLE IF EXISTS `tcm_notify`;
CREATE TABLE `tcm_notify` (
  `nid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '消息id',
  `type` tinyint(1) NOT NULL COMMENT '消息类型',
  `isread` tinyint(1) NOT NULL COMMENT '是否已读',
  `time` bigint(20) NOT NULL COMMENT '通知时间',
  PRIMARY KEY (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息通知总表';

-- ----------------------------
-- Records of tcm_notify
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_notify_follow
-- ----------------------------
DROP TABLE IF EXISTS `tcm_notify_follow`;
CREATE TABLE `tcm_notify_follow` (
  `nfid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `nid` bigint(20) NOT NULL COMMENT '消息id',
  `fuid` int(11) NOT NULL COMMENT '消息发起者id',
  `tuid` int(11) NOT NULL COMMENT '消息接受者id',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `time` bigint(20) NOT NULL COMMENT '通知时间',
  PRIMARY KEY (`nfid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关注消息详细';

-- ----------------------------
-- Records of tcm_notify_follow
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_notify_nu
-- ----------------------------
DROP TABLE IF EXISTS `tcm_notify_nu`;
CREATE TABLE `tcm_notify_nu` (
  `nuid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '关联表id',
  `nid` bigint(20) NOT NULL COMMENT '消息id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`nuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息用户关联表';

-- ----------------------------
-- Records of tcm_notify_nu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_notify_pbravo
-- ----------------------------
DROP TABLE IF EXISTS `tcm_notify_pbravo`;
CREATE TABLE `tcm_notify_pbravo` (
  `npbid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `nid` bigint(20) NOT NULL COMMENT '消息id',
  `fuid` int(11) NOT NULL COMMENT '消息发起者id',
  `tuid` int(11) NOT NULL COMMENT '消息接受者id',
  `pid` bigint(20) NOT NULL COMMENT '发布消息id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `time` bigint(20) NOT NULL COMMENT '通知时间',
  PRIMARY KEY (`npbid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点赞消息详细表';

-- ----------------------------
-- Records of tcm_notify_pbravo
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_notify_pcomment
-- ----------------------------
DROP TABLE IF EXISTS `tcm_notify_pcomment`;
CREATE TABLE `tcm_notify_pcomment` (
  `npcmid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `nid` bigint(20) NOT NULL COMMENT '消息id',
  `fuid` int(11) NOT NULL COMMENT '消息发起者id',
  `tuid` int(11) NOT NULL COMMENT '消息接受者id',
  `pid` bigint(20) NOT NULL COMMENT '发布信息id',
  `title` varchar(255) NOT NULL COMMENT '信息标题',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `time` bigint(20) NOT NULL COMMENT '通知时间',
  PRIMARY KEY (`npcmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论消息详细';

-- ----------------------------
-- Records of tcm_notify_pcomment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_bravo
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_bravo`;
CREATE TABLE `tcm_post_bravo` (
  `pbid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '点赞表id',
  `pid` bigint(20) NOT NULL COMMENT '发布信息id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `optime` bigint(20) NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`pbid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='信息点赞行为';

-- ----------------------------
-- Records of tcm_post_bravo
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_bravocount
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_bravocount`;
CREATE TABLE `tcm_post_bravocount` (
  `pbvid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '点赞数量表id',
  `pid` bigint(20) NOT NULL COMMENT '发布信息id',
  `bravocount` int(11) NOT NULL COMMENT '点赞数量',
  PRIMARY KEY (`pbvid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发布信息点赞数量表';

-- ----------------------------
-- Records of tcm_post_bravocount
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_cc
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_cc`;
CREATE TABLE `tcm_post_cc` (
  `pcccid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '关联表id',
  `pcmid` bigint(20) NOT NULL COMMENT '评论回复id',
  `tpcmid` bigint(20) NOT NULL COMMENT '目标评论id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`pcccid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发布评论与和发布评论有关评论关联表';

-- ----------------------------
-- Records of tcm_post_cc
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_comment
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_comment`;
CREATE TABLE `tcm_post_comment` (
  `pcmid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `detail` varchar(255) NOT NULL COMMENT '评论内容',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `ctime` bigint(20) NOT NULL COMMENT '评论时间',
  `bravo` tinyint(4) NOT NULL COMMENT '点赞数量',
  `img` varchar(255) DEFAULT NULL COMMENT '图片评论',
  `mtime` bigint(20) NOT NULL COMMENT '修改时间',
  `commenttype` tinyint(1) NOT NULL COMMENT '评论目标类型',
  PRIMARY KEY (`pcmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='信息评论内容表';

-- ----------------------------
-- Records of tcm_post_comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_commentcount
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_commentcount`;
CREATE TABLE `tcm_post_commentcount` (
  `pccid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '评论数量id',
  `pid` bigint(20) NOT NULL COMMENT '发布id',
  `commentcount` int(11) NOT NULL COMMENT '发布评论数量',
  PRIMARY KEY (`pccid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tcm_post_commentcount
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_dc
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_dc`;
CREATE TABLE `tcm_post_dc` (
  `pdcid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '关联表id',
  `pcmid` bigint(20) NOT NULL COMMENT '信息评论id',
  `pid` bigint(20) NOT NULL COMMENT '发布信息id',
  `uid` int(11) NOT NULL COMMENT '评论用户id',
  PRIMARY KEY (`pdcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发布与评论关联表';

-- ----------------------------
-- Records of tcm_post_dc
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_detail
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_detail`;
CREATE TABLE `tcm_post_detail` (
  `pid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '发布信息id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `ctime` bigint(20) NOT NULL COMMENT '创建时间',
  `mtime` bigint(20) NOT NULL COMMENT '更新时间',
  `word` text DEFAULT NULL COMMENT '文字内容',
  `img` varchar(255) DEFAULT NULL COMMENT '图片内容',
  `video` varchar(255) DEFAULT NULL COMMENT '视频内容',
  `audio` varchar(255) DEFAULT NULL COMMENT '音频内容',
  `tag` varchar(255) DEFAULT NULL COMMENT '标签',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `top` tinyint(1) NOT NULL COMMENT '置顶',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='发布信息及信息详细内容表';

-- ----------------------------
-- Records of tcm_post_detail
-- ----------------------------
BEGIN;
INSERT INTO `tcm_post_detail` VALUES (1, 32, 0, 1, 1, 'dewsqadq', 'weq', 'ewq', 'ewq', 'ewq', 'ewq', 0);
COMMIT;

-- ----------------------------
-- Table structure for tcm_post_viewcount
-- ----------------------------
DROP TABLE IF EXISTS `tcm_post_viewcount`;
CREATE TABLE `tcm_post_viewcount` (
  `pvid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '浏览数量id',
  `pid` bigint(20) NOT NULL COMMENT '发布信息id',
  `viewcount` int(11) NOT NULL COMMENT '浏览数量',
  PRIMARY KEY (`pvid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='信息浏览数量表';

-- ----------------------------
-- Records of tcm_post_viewcount
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_tl
-- ----------------------------
DROP TABLE IF EXISTS `tcm_tl`;
CREATE TABLE `tcm_tl` (
  `tlid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '时间轴id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `intro` varchar(255) NOT NULL COMMENT '简介',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `ctime` bigint(20) NOT NULL COMMENT '创建时间',
  `mtime` bigint(20) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`tlid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='时间轴表信息简要内容';

-- ----------------------------
-- Records of tcm_tl
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_tl_tp
-- ----------------------------
DROP TABLE IF EXISTS `tcm_tl_tp`;
CREATE TABLE `tcm_tl_tp` (
  `tlpid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '关联表id',
  `tlid` bigint(20) NOT NULL COMMENT '时间轴id',
  `pid` bigint(20) NOT NULL COMMENT '发布信息id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`tlpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='时间轴与用户发布信息关联表';

-- ----------------------------
-- Records of tcm_tl_tp
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tcm_user_acc
-- ----------------------------
DROP TABLE IF EXISTS `tcm_user_acc`;
CREATE TABLE `tcm_user_acc` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `uname` varchar(255) NOT NULL COMMENT '登录用户名',
  `pword` varchar(255) NOT NULL COMMENT '登录密码',
  `name` varchar(255) NOT NULL COMMENT '昵称',
  `auth` tinyint(1) NOT NULL COMMENT '用户权限等级',
  `isdel` tinyint(1) NOT NULL COMMENT '软删除标志',
  `salt` varchar(255) NOT NULL COMMENT '盐',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COMMENT='用户账户表';

-- ----------------------------
-- Records of tcm_user_acc
-- ----------------------------
BEGIN;
INSERT INTO `tcm_user_acc` VALUES (1, 'ycc', '123', 'ycc', 0, 0, '');
INSERT INTO `tcm_user_acc` VALUES (2, 'ccy', '321', 'ccy', 1, 1, '');
INSERT INTO `tcm_user_acc` VALUES (4, 'test', '123', 'test', 0, 0, '');
INSERT INTO `tcm_user_acc` VALUES (5, 'test', '123', 'test', 0, 0, '');
INSERT INTO `tcm_user_acc` VALUES (6, 'test', '123', 'test', 0, 1, '');
INSERT INTO `tcm_user_acc` VALUES (7, 'vcxz', '132455', 'vcz', 0, 0, 'vcxvxzcd');
INSERT INTO `tcm_user_acc` VALUES (8, 'test', '123', 'test', 0, 1, 'fedsafgaerafre');
INSERT INTO `tcm_user_acc` VALUES (9, '18111111111', 'ae1229f60fb8ee8593861c26cb6706dc', '18****1111', 0, 0, '307ea20');
INSERT INTO `tcm_user_acc` VALUES (10, '18222222222', '97a758d2c9f8c112bfdd9ccd2e5f25be', '182****2222', 0, 0, 'b3896f4');
INSERT INTO `tcm_user_acc` VALUES (11, '18333333333', '46a297ad0f34a6c72dca7b8b193e7885', '183****3333', 0, 0, '48b7e11');
INSERT INTO `tcm_user_acc` VALUES (12, '10000000000', '3a52376bf49b6d6d9e4b4efcc1a4c505', '100****0000', 0, 0, 'b0323fe');
INSERT INTO `tcm_user_acc` VALUES (13, '10000000001', 'ec59c5542032d7a931c8f8154e14d28a', '100****0001', 0, 0, 'ac3e1c8');
INSERT INTO `tcm_user_acc` VALUES (14, '10000000002d', '2a05d59faf6cd37fffb0c5f7525dabf0', '100****0002', 0, 1, 'a736baf');
INSERT INTO `tcm_user_acc` VALUES (15, '10000000010d', 'd650eaebc028dd10c317cc5e0955c660', '100****0010', 0, 1, '7d2a117');
INSERT INTO `tcm_user_acc` VALUES (16, '10000000011', 'fc545040f16763790cd9ae29a954ac32', '100****0011', 0, 0, 'f17346c');
INSERT INTO `tcm_user_acc` VALUES (17, 'qqqqqqqqqqqd', '6f95cb6c99ddc8622525e2688e6bbb7f', 'qqq****qqqq', 0, 1, 'e1e7758');
INSERT INTO `tcm_user_acc` VALUES (18, 'wwwwwwwwwww', '85680727c9fdd16dfca35592999479ac', 'www****wwww', 1, 0, 'df19e4f');
INSERT INTO `tcm_user_acc` VALUES (19, 'eeeeeeeeeee', 'cf54311a6b9477207f531c2f48997c34', 'eee****eeee', 1, 0, '55fc664');
INSERT INTO `tcm_user_acc` VALUES (20, 'rrrrrrrrrrr', 'd41e0fca43bb6520d53057f43963e88c', 'rrr****rrrr', 0, 0, '1d35cd4');
INSERT INTO `tcm_user_acc` VALUES (21, '10000000100', '11ad720c08b76240335db0af7c6cf313', '100****0100', 0, 0, '906ead6');
INSERT INTO `tcm_user_acc` VALUES (22, '11111111111', '973d92ec6c2dd0a904ecdf01f8310ee0', '111****1111', 0, 0, '80a7cdf');
INSERT INTO `tcm_user_acc` VALUES (23, '11111111110', 'a377b2d802d19ff7973c05cdd98af40b', '111****1110', 0, 0, '7eda630');
INSERT INTO `tcm_user_acc` VALUES (24, '11111111100', 'e73757e82b23da41fc7972f7dddebf34', '111****1100', 1, 0, 'c74c97b');
INSERT INTO `tcm_user_acc` VALUES (25, '22222222222', 'b6bb90ca0dfbd61620c59031fc5f4a02', '222****2222', 0, 0, '8338ad1');
INSERT INTO `tcm_user_acc` VALUES (26, '33333333333', '361db266994ba22e85f864827ff6cfae', '333****3333', 0, 0, 'bb95742');
INSERT INTO `tcm_user_acc` VALUES (27, '44444444444', '9816de36053ddcb951b6aef5ca7fdd10', '444****4444', 0, 0, '471e2d9');
INSERT INTO `tcm_user_acc` VALUES (28, 'ccccccccccc', '254e4ba1808ab7369a820f28cd759a91', 'ccc****cccc', 1, 0, '647968f');
INSERT INTO `tcm_user_acc` VALUES (29, 'bbbbbbbbbbb', 'be9d10dcd88b9e6099f91de0add39ef0', 'bbb****bbbb', 0, 0, 'f73201c');
INSERT INTO `tcm_user_acc` VALUES (30, 'zzzzzzzzzzz', '5dd1b94c14a8f937d9a5c5cdfb6e5b9e', 'zzz****zzzz', 0, 0, 'a4c7b7a');
INSERT INTO `tcm_user_acc` VALUES (31, 'sssssssssss', 'a1ad1943ddc8cff25ac4e709dd8e4990', 'sss****ssss', 0, 0, '67e3e8a');
INSERT INTO `tcm_user_acc` VALUES (32, 'nnnnnnnnnnn', '075703aeb64641d7951b7657eea0a59f', 'nnn****nnnn', 0, 0, '3b88f3c');
INSERT INTO `tcm_user_acc` VALUES (33, 'xxxxxxxxxxx', '90058e58cd2a65d1a574b61a2490fce9', 'xxx****xxxx', 0, 0, '07ce066');
INSERT INTO `tcm_user_acc` VALUES (36, 'aaaaaaaaaaad', '87fe567985bc5eb55feebf45c82a3a3d', 'Usera3e0c78e43b7405', 0, 1, '38abfb7');
INSERT INTO `tcm_user_acc` VALUES (37, 'aaaaaaaaaaa', '7b1e7e5065ab0fbc5ec6e60024ad4f06', 'Usera6536e5b99ba4a9', 0, 0, '67e6b4f');
INSERT INTO `tcm_user_acc` VALUES (38, 'ooooooooooo', 'c51a8ee2446cf311e9fdcf26dda69507', 'User9c66d92e306b430', 0, 0, 'bfdff2c');
INSERT INTO `tcm_user_acc` VALUES (39, 'iiiiiiiiiii', '7dcf8d494cd4871b9990b1c13bd02cbe', 'User1e5683f8ce6d480', 0, 0, '4704b06');
INSERT INTO `tcm_user_acc` VALUES (40, 'uuuuuuuuuuu', 'd8c1cf6206a5acf57c93fc0fa093729f', 'User40331b571bf14bf', 0, 0, '4c96ac7');
INSERT INTO `tcm_user_acc` VALUES (41, 'yyyyyyyyyyyd', 'b0ee11db46bfd182dbf0aedf950aa348', 'Userd6eba3a24d49479', 0, 1, '6568845');
INSERT INTO `tcm_user_acc` VALUES (42, 'ttttttttttt', '8e9d452d7c1d4f573a841909df111134', 'User53d3f31eeec545b', 0, 0, 'c5901ae');
INSERT INTO `tcm_user_acc` VALUES (43, 'gggggggggggd', 'fc0acb1a3f99dad25c3a0914bbfc44cb', 'User0f6323eec3374f0', 0, 1, '4487bdb');
INSERT INTO `tcm_user_acc` VALUES (44, 'gggggggggggd', '0db1328baffa1af8eae33edfc7b65331', 'User307bde8aa52b4ca', 0, 1, '6a28c83');
INSERT INTO `tcm_user_acc` VALUES (45, 'vvvvvvvvvvv', 'ecdb7f55e57c99819fe84d7a505112d1', 'Userdfeb845e857746f', 0, 0, 'b6facd9');
INSERT INTO `tcm_user_acc` VALUES (46, 'mmmmmmmmmmm', '20a8698aea1eb20ca12ec9d3807609d5', 'User322aedc157c04b8', 0, 0, '96807d3');
COMMIT;

-- ----------------------------
-- Table structure for tcm_user_ainfo
-- ----------------------------
DROP TABLE IF EXISTS `tcm_user_ainfo`;
CREATE TABLE `tcm_user_ainfo` (
  `uaid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '关联表id',
  `uid` int(11) NOT NULL COMMENT '用户账户表id',
  `uiid` int(11) NOT NULL COMMENT '用户信息表id',
  PRIMARY KEY (`uaid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='用户账户与信息相关';

-- ----------------------------
-- Records of tcm_user_ainfo
-- ----------------------------
BEGIN;
INSERT INTO `tcm_user_ainfo` VALUES (1, 1, 1);
INSERT INTO `tcm_user_ainfo` VALUES (2, 2, 2);
INSERT INTO `tcm_user_ainfo` VALUES (3, 4, 4);
INSERT INTO `tcm_user_ainfo` VALUES (4, 15, 7);
INSERT INTO `tcm_user_ainfo` VALUES (5, 16, 8);
INSERT INTO `tcm_user_ainfo` VALUES (6, 17, 9);
INSERT INTO `tcm_user_ainfo` VALUES (7, 18, 10);
INSERT INTO `tcm_user_ainfo` VALUES (8, 21, 11);
INSERT INTO `tcm_user_ainfo` VALUES (9, 22, 12);
INSERT INTO `tcm_user_ainfo` VALUES (10, 23, 13);
INSERT INTO `tcm_user_ainfo` VALUES (11, 30, 17);
INSERT INTO `tcm_user_ainfo` VALUES (12, 31, 18);
INSERT INTO `tcm_user_ainfo` VALUES (13, 32, 19);
INSERT INTO `tcm_user_ainfo` VALUES (14, 36, 23);
INSERT INTO `tcm_user_ainfo` VALUES (15, 37, 24);
INSERT INTO `tcm_user_ainfo` VALUES (16, 38, 25);
INSERT INTO `tcm_user_ainfo` VALUES (17, 39, 26);
INSERT INTO `tcm_user_ainfo` VALUES (18, 40, 27);
INSERT INTO `tcm_user_ainfo` VALUES (19, 41, 28);
INSERT INTO `tcm_user_ainfo` VALUES (20, 42, 29);
INSERT INTO `tcm_user_ainfo` VALUES (21, 43, 30);
INSERT INTO `tcm_user_ainfo` VALUES (22, 44, 31);
INSERT INTO `tcm_user_ainfo` VALUES (23, 45, 32);
INSERT INTO `tcm_user_ainfo` VALUES (24, 46, 33);
COMMIT;

-- ----------------------------
-- Table structure for tcm_user_follow
-- ----------------------------
DROP TABLE IF EXISTS `tcm_user_follow`;
CREATE TABLE `tcm_user_follow` (
  `ufid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '关注表id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `fid` int(11) NOT NULL COMMENT '用户id',
  `optime` bigint(20) NOT NULL COMMENT '操作时间',
  `isdel` tinyint(1) NOT NULL COMMENT '是否关注过或者拉黑',
  PRIMARY KEY (`ufid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='关注粉丝表';

-- ----------------------------
-- Records of tcm_user_follow
-- ----------------------------
BEGIN;
INSERT INTO `tcm_user_follow` VALUES (1, 1, 1, 0, 1);
INSERT INTO `tcm_user_follow` VALUES (2, 1, 2, 0, 0);
INSERT INTO `tcm_user_follow` VALUES (3, 32, 1, 0, 0);
INSERT INTO `tcm_user_follow` VALUES (4, 32, 2, 0, 0);
INSERT INTO `tcm_user_follow` VALUES (5, 32, 4, 0, 1);
INSERT INTO `tcm_user_follow` VALUES (6, 1, 32, 0, 0);
INSERT INTO `tcm_user_follow` VALUES (7, 2, 32, 0, 0);
INSERT INTO `tcm_user_follow` VALUES (8, 5, 32, 0, 0);
INSERT INTO `tcm_user_follow` VALUES (9, 4, 32, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for tcm_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tcm_user_info`;
CREATE TABLE `tcm_user_info` (
  `uiid` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户信息表id',
  `ctime` bigint(20) NOT NULL COMMENT '注册时间',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `email` varchar(255) DEFAULT NULL COMMENT 'email',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `location` varchar(255) DEFAULT NULL COMMENT '定位',
  `selfintro` text DEFAULT NULL COMMENT '个人介绍',
  `pic` varchar(255) DEFAULT NULL COMMENT '头像',
  `tag` varchar(255) DEFAULT NULL COMMENT '个性标签',
  `isidenti` tinyint(1) NOT NULL COMMENT '是否验证',
  PRIMARY KEY (`uiid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COMMENT='注册用户信息表';

-- ----------------------------
-- Records of tcm_user_info
-- ----------------------------
BEGIN;
INSERT INTO `tcm_user_info` VALUES (1, 0, 0, 0, '0', '0', '0', '0', '0', '0', '0', 0);
INSERT INTO `tcm_user_info` VALUES (2, 0, 18, 1, 'wewr@qq.com', 'sichuan', 'chengdu', '127.0,122.0', 'feafgeatrewatewtgf', '/dsa/dsa/sda.png', 'fesafewwe', 0);
INSERT INTO `tcm_user_info` VALUES (3, 0, 18, 1, 'wewr@qq.com', 'sichuan', 'chengdu', '127.0,122.0', 'feafgeatrewatewtgf', '/dsa/dsa/sda.png', 'fesafewwe', 0);
INSERT INTO `tcm_user_info` VALUES (4, 0, 0, 0, '0', '0', '0', '0', '0', '0', '0', 0);
INSERT INTO `tcm_user_info` VALUES (5, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (6, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (7, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (8, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (9, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (10, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (11, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (12, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `tcm_user_info` VALUES (13, 0, 1, NULL, '1', 'sc', 'cd', '1', 'fdasfgdagdgag', '', '1', 0);
INSERT INTO `tcm_user_info` VALUES (14, 0, 0, 0, '', '', '', '', '', '', '', 0);
INSERT INTO `tcm_user_info` VALUES (15, 0, 0, 0, '', '', '', '', '', '', '', 0);
INSERT INTO `tcm_user_info` VALUES (16, 0, 0, 0, '', '', '', '', '', '', '', 0);
INSERT INTO `tcm_user_info` VALUES (17, 0, 0, 0, '', '', '', '', '', '', '', 0);
INSERT INTO `tcm_user_info` VALUES (18, 0, 1, 1, '1', 'sc', 'cd', '1', 'fdasfgdagdgag', '', '1', 0);
INSERT INTO `tcm_user_info` VALUES (19, 0, 1, 1, '1', 'sc', 'cd', '1', 'fdasfgdagdgag', 'headpic/diy/554a1bf06817a5c14e713a2f87c14e07.png', '1', 0);
INSERT INTO `tcm_user_info` VALUES (20, 0, 0, 0, '', '', '', '', '', '', '', 0);
INSERT INTO `tcm_user_info` VALUES (23, 1612187294893, 0, 0, '', '', '', '', '', 'http://localhost:8080/headpic/38h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (24, 1612228808905, 0, 0, '', '', '', '', '', 'http://localhost:8080/headpic/10h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (25, 1612672121873, 2, 0, '', '', '', '', '', 'http://localhost:8080/headpic/33h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (26, 1612672626693, 0, 0, '', '', '', '', '', 'http://localhost:8080/headpic/7h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (27, 1612688971805, 0, 0, '', '', '', '', '', 'http://localhost:8080/headpic/96h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (28, 1612689035232, 0, 0, '', '', '', '', '', 'http://localhost:8080/headpic/94h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (29, 1612704821948, 0, 0, '', '', '', '', '', '/headpic/default/57h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (30, 1612705959617, 0, 0, '', '', '', '', '', '/headpic/default/55h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (31, 1612706415652, 0, 0, '', '', '', '', '', '/headpic/default/17h.png', '', 0);
INSERT INTO `tcm_user_info` VALUES (32, 1612783108061, 0, 1, '0', '0', '0', '0', '0', '/headpic/default/0h.png', '0', 1);
INSERT INTO `tcm_user_info` VALUES (33, 1612784788696, 0, 0, '', '', '', '', '', '/headpic/default/83h.png', '', 0);
COMMIT;

-- ----------------------------
-- Table structure for tcm_user_token
-- ----------------------------
DROP TABLE IF EXISTS `tcm_user_token`;
CREATE TABLE `tcm_user_token` (
  `utid` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表id',
  `uid` int(11) NOT NULL COMMENT '用户id',
  `token` varchar(255) NOT NULL COMMENT 'token',
  `expired` bigint(20) NOT NULL COMMENT '过期时间',
  `status` tinyint(1) NOT NULL COMMENT '登录状态',
  `logintime` bigint(20) NOT NULL COMMENT '登录时间',
  PRIMARY KEY (`utid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COMMENT='登录token表';

-- ----------------------------
-- Records of tcm_user_token
-- ----------------------------
BEGIN;
INSERT INTO `tcm_user_token` VALUES (2, 16, '80815d7516194bc29184efe24f4547e3', 0, 1, 0);
INSERT INTO `tcm_user_token` VALUES (3, 15, '0', 0, 0, 0);
INSERT INTO `tcm_user_token` VALUES (4, 14, '0', 0, 0, 0);
INSERT INTO `tcm_user_token` VALUES (5, 13, '0', 0, 0, 0);
INSERT INTO `tcm_user_token` VALUES (6, 17, '0', 0, 0, 0);
INSERT INTO `tcm_user_token` VALUES (7, 18, '0', 0, 0, 0);
INSERT INTO `tcm_user_token` VALUES (8, 20, '0', 0, 0, 0);
INSERT INTO `tcm_user_token` VALUES (9, 21, '4ee594781a72448ba7d7843783e50eb9', 0, 1, 0);
INSERT INTO `tcm_user_token` VALUES (10, 22, 'de4dfc61db2f4192b342c02569598e16', 1612831538739, 1, 1612745138739);
INSERT INTO `tcm_user_token` VALUES (11, 23, 'af90279f09484e31a471aea55f072c39', 0, 1, 0);
INSERT INTO `tcm_user_token` VALUES (12, 24, '6bd64452b5cf47a68f81d9016fc53406', 0, 1, 0);
INSERT INTO `tcm_user_token` VALUES (13, 25, '6b53222c15634dd88ae342862506609b', 0, 1, 0);
INSERT INTO `tcm_user_token` VALUES (14, 28, '51b28d694cf041ed8560fe399674dab9', 0, 1, 0);
INSERT INTO `tcm_user_token` VALUES (15, 30, '0', 0, 0, 0);
INSERT INTO `tcm_user_token` VALUES (16, 31, '6d2fed2515b24a4fa6f929012db6380b', 0, 1, 0);
INSERT INTO `tcm_user_token` VALUES (17, 32, '281bd24d561242cdae666302beb5aea1', 1613694102878, 1, 1613607702878);
INSERT INTO `tcm_user_token` VALUES (18, 36, '0', 0, 0, 1612190202893);
INSERT INTO `tcm_user_token` VALUES (19, 37, '0', 0, 0, 1612228808905);
INSERT INTO `tcm_user_token` VALUES (20, 38, '457977adbd90468d88325c399565f32c', 1612831398003, 1, 1612744998003);
INSERT INTO `tcm_user_token` VALUES (21, 39, '0', 0, 0, 1612672626693);
INSERT INTO `tcm_user_token` VALUES (22, 40, '0', 0, 0, 1612688971805);
INSERT INTO `tcm_user_token` VALUES (23, 41, '0', 0, 0, 1612690830156);
INSERT INTO `tcm_user_token` VALUES (24, 42, '0', 0, 0, 1612704866655);
INSERT INTO `tcm_user_token` VALUES (25, 43, '0', 0, 0, 1612706317564);
INSERT INTO `tcm_user_token` VALUES (26, 44, '0', 0, 0, 1612706433230);
INSERT INTO `tcm_user_token` VALUES (27, 45, '0', 0, 0, 1612783785191);
INSERT INTO `tcm_user_token` VALUES (28, 46, '4f3d9dc7226a4679ba2ee016bdbf23a6', 1612871195004, 1, 1612784795004);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
