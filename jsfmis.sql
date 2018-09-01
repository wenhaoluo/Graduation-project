/*
Navicat MySQL Data Transfer

Source Server         : hades
Source Server Version : 50550
Source Host           : localhost:3306
Source Database       : jsfmis

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2017-05-09 01:12:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for am
-- ----------------------------
DROP TABLE IF EXISTS `am`;
CREATE TABLE `am` (
  `amid` int(11) NOT NULL,
  `amusername` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ampassword` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`amid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of am
-- ----------------------------
INSERT INTO `am` VALUES ('10000', '123', '123', '管理员');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `yytime` datetime DEFAULT NULL,
  `classover` bit(1) DEFAULT NULL,
  `teacherid` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseid`),
  KEY `FK_course1` (`studentid`),
  KEY `FK_course2` (`cid`),
  KEY `FK_course` (`teacherid`),
  CONSTRAINT `FK_course` FOREIGN KEY (`teacherid`) REFERENCES `user` (`userid`) ON DELETE SET NULL,
  CONSTRAINT `FK_course1` FOREIGN KEY (`studentid`) REFERENCES `user` (`userid`) ON DELETE SET NULL,
  CONSTRAINT `FK_course2` FOREIGN KEY (`cid`) REFERENCES `jsclass` (`cid`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '2016-11-16 02:05:09', '', '8', '8', '2');
INSERT INTO `course` VALUES ('2', '2016-11-22 14:04:37', '\0', '4', '8', '3');
INSERT INTO `course` VALUES ('3', '2016-11-11 14:04:53', '', '9', '10', '3');
INSERT INTO `course` VALUES ('36', '2016-11-25 15:04:14', '', '8', '1', '567');
INSERT INTO `course` VALUES ('37', '2016-11-25 15:04:14', '', '16', '1', '570');
INSERT INTO `course` VALUES ('39', '2016-11-16 23:31:18', '\0', '8', '1', '566');
INSERT INTO `course` VALUES ('40', '2016-11-24 18:52:35', '\0', '17', '1', '566');
INSERT INTO `course` VALUES ('41', '2016-11-17 18:53:27', '\0', '8', '1', '576');
INSERT INTO `course` VALUES ('42', '2016-11-18 18:55:23', '\0', '18', '8', '566');
INSERT INTO `course` VALUES ('43', '2016-11-11 22:02:25', '\0', '18', '8', '566');
INSERT INTO `course` VALUES ('44', '2016-12-22 04:10:22', '\0', '17', '18', '568');
INSERT INTO `course` VALUES ('45', '2016-12-16 04:21:01', '\0', '17', '4', '2');
INSERT INTO `course` VALUES ('46', '2016-12-16 21:34:40', '\0', '17', '8', '570');
INSERT INTO `course` VALUES ('47', '2017-03-24 20:56:46', null, '17', '19', '569');
INSERT INTO `course` VALUES ('48', '2017-03-23 01:18:54', '', '68', '1', '5');
INSERT INTO `course` VALUES ('49', '2017-03-09 01:21:05', '\0', '68', '1', '4');
INSERT INTO `course` VALUES ('50', '2017-03-30 01:31:06', null, '18', '19', '578');
INSERT INTO `course` VALUES ('51', '2017-04-12 04:14:17', null, '17', '19', '576');
INSERT INTO `course` VALUES ('52', '2017-04-06 16:33:19', null, '17', '19', '567');
INSERT INTO `course` VALUES ('53', '2017-04-13 13:55:05', '\0', '18', '19', '568');

-- ----------------------------
-- Table structure for huifu
-- ----------------------------
DROP TABLE IF EXISTS `huifu`;
CREATE TABLE `huifu` (
  `hfid` int(11) NOT NULL AUTO_INCREMENT,
  `hfauthor` varchar(25) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hfcontext` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hfDate` datetime DEFAULT NULL,
  `tieid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`hfid`),
  KEY `FK_huifu` (`tieid`),
  KEY `FK_huifu1` (`userid`),
  CONSTRAINT `FK_huifu` FOREIGN KEY (`tieid`) REFERENCES `tie` (`tieid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_huifu1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of huifu
-- ----------------------------
INSERT INTO `huifu` VALUES ('1', '小心', 'fghjgfhghjghjhjg', '2016-12-05 02:20:14', '2', '8');
INSERT INTO `huifu` VALUES ('2', '小心', 'hhhh', '2016-12-05 04:29:32', '2', '8');
INSERT INTO `huifu` VALUES ('3', '小心', '546456', '2016-12-05 04:30:35', '2', '8');
INSERT INTO `huifu` VALUES ('4', '小心', '456456', '2016-12-05 15:55:23', '2', '8');
INSERT INTO `huifu` VALUES ('5', '小心', '777777和嘎嘎嘎', '2016-12-05 17:25:01', '13', '8');
INSERT INTO `huifu` VALUES ('6', '小心', '5465发过火法国恢复规划', '2016-12-05 20:44:33', '2', '8');
INSERT INTO `huifu` VALUES ('7', '小心', '45345gggdfgdfg', '2016-12-05 22:28:50', '2', '8');
INSERT INTO `huifu` VALUES ('8', '小心', '贵航股份很反感', '2016-12-06 17:05:14', '2', '8');
INSERT INTO `huifu` VALUES ('9', '小心', '挂号费过很反感', '2016-12-06 17:05:33', '13', '8');
INSERT INTO `huifu` VALUES ('10', '小心', '法国恢复规划', '2016-12-06 17:10:58', '2', '8');
INSERT INTO `huifu` VALUES ('11', '小猪', '水电费水电费', '2017-03-26 02:14:40', '15', '19');
INSERT INTO `huifu` VALUES ('12', '小猪', 'sdfgsdfgdsfg', '2017-04-21 00:59:35', '17', '19');
INSERT INTO `huifu` VALUES ('13', '小猪', '我为什么听你的？', '2017-04-21 01:00:08', '18', '19');
INSERT INTO `huifu` VALUES ('14', '马', '我就不听你的？', '2017-04-21 01:00:38', '18', '1');
INSERT INTO `huifu` VALUES ('15', '小猪', '啊实打实的', '2017-04-21 02:57:14', '18', '19');
INSERT INTO `huifu` VALUES ('16', '小猪', 'sdfsdf', '2017-04-21 04:39:40', '18', '19');
INSERT INTO `huifu` VALUES ('17', '小猪', '打飞机考虑过的房间观看了', '2017-04-21 16:31:04', '19', '19');
INSERT INTO `huifu` VALUES ('18', '小猪', '的更好豆腐干豆腐干', '2017-04-22 13:54:32', '20', '19');

-- ----------------------------
-- Table structure for jsclass
-- ----------------------------
DROP TABLE IF EXISTS `jsclass`;
CREATE TABLE `jsclass` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ctext` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=581 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of jsclass
-- ----------------------------
INSERT INTO `jsclass` VALUES ('2', '杠铃仰卧推举', 'A.重点锻炼部位：胸大肌、三角肌和肱三头肌。绝大多数的冠军健美运动员把仰握推举作为锻炼上身最好的动作。 \r\nB.开始位置：仰卧在平的卧推凳上，两脚平踏在地上。两手掌向上握住横杠，两手间距比肩稍为宽些，两臂伸直支撑住杠铃位于胸的上部。 \r\nC.动作过程：使两直臂向两侧张开，两臂慢慢弯屈，杠铃垂直落下，直至横杠接触到胸部（大约接近乳头线上方）。然后向上推起至开设位置，重复做。 \r\nD.训练要点：不要把背和臀部拱起或憋气，这样会使肌肉失去控制，是危险的。');
INSERT INTO `jsclass` VALUES ('3', '哑铃卧推', 'A.重点锻炼部位：胸大肌、三角肌和肱三头肌。\r\nB.开始位置：仰卧在平的卧推凳上，两脚平踏在地上。两手掌向上伸直握住哑铃。 \r\nC.动作过程：使两直臂向两侧张开，两臂慢慢弯屈，哑铃垂直落下，下降至最低处时，即做上推动作，上推时呼气。然后向上推起至开设位置，重复做。 D.训练要点：不要把背和臀 部拱起或憋气，这样会使肌肉失去控制，是危险的。');
INSERT INTO `jsclass` VALUES ('4', 'xcvxcv', 'xcvcxvxcvxcv');
INSERT INTO `jsclass` VALUES ('5', 'fgdfg', 'fdgdfgdfg');
INSERT INTO `jsclass` VALUES ('56', '上斜杠铃卧推', 'A.重点锻炼部位：胸大肌上部，其次是三角肌前束和肱三头肌。 \r\nB.开始位置：仰卧在上斜角度为35-45度的卧推凳上。 \r\nC.动作过程：两手间距比肩稍为宽些，两臂伸直支撑住杠铃位于肩的上部。放下至胸部上方（接近锁骨处）时吸气。当横杠一接触胸部时，即做上推动作，上推时呼气。 D.训练要点：一般都采用 较宽的握距，横杠放下在锁骨处，这种方法使胸部肌肉更用得上力。');
INSERT INTO `jsclass` VALUES ('566', '上斜哑铃卧推', 'A.重点锻炼部位：胸大肌上部，其次是三角肌前束和肱三头肌。 \r\nB.开始位置：仰卧在上斜角度为35-45度的卧推凳上。 \r\nC.动作过程：两臂伸直持哑铃位于肩的上部。放下至胸部上方（接近锁骨处）时吸气。下降至最低处时，即做上推动作，上推时呼气。 D.训练要点：练习过程将主要力量集中在胸大肌上，使胸肌始终处于紧张状态。肱三头肌作为次要的补充力量。');
INSERT INTO `jsclass` VALUES ('567', '站姿双臂侧下拉夹胸', 'A、重点锻炼部位：主要健美胸大肌和三角肌。握把相碰的位置高，健美的是上胸部；握把的位置在中部或下部，健美的是中胸部或下胸部肌群。 \r\nB、开始位置：两脚开立，与肩同宽，身体站在拉力器的下方，两臂侧上举，肘关节稍微 弯曲，两手心向下分别握住拉力器的各一端把柄。重心方向应该由上向下成45度角。（不小于30度角）。 \r\nC、动作过程：吸气，上体稍前倾，两臂由上往下斜线用力夹至胸前呈交$&*状，直至两拉力器把柄相碰。稍停2-4秒，然后再呼气，缓慢还原。重复练习。 \r\nD、训练要点：上体始终保持稍前倾，不准前后摆动助力；要充分伸展胸肌，动作需缓慢而有节奏地进行；完成动作时两臂均衡用力，防止猛拉或突然性还原动作。');
INSERT INTO `jsclass` VALUES ('568', '双杠双臂屈伸', 'A、重点锻炼部位：主要是胸大肌下部，其次是肱三头肌和三角肌。 \r\nB、开始位置：双杆间距最好宽于肩，双手握杠成直臂支撑、挺胸、收腹，两腿伸直并拢放松呈下垂状。 \r\nC、动作过程：呼气，屈肘弯臂，身体下降，直至两臂弯曲降低到最低位置时，头部应向前引，两肘外展，使胸大肌充分拉长伸展。随即吸气，以胸大肌突然收缩力撑两臂，使身体上升直至两臂完全伸直；当上臂超过杆水平位置时，臀部稍向后缩，躯干呈“低头含胸”的姿势。两臂伸直时，胸大肌处于彻底收紧状态。重复练习。 D、训练要点：动作要缓慢进行，不要借身体的振摆助力完成动作；撑起时速度要快、挺胸、抬头、收腹、不耸肩；为加大训练强度可在腰间负重练习。');
INSERT INTO `jsclass` VALUES ('569', '仰卧后撑', 'A.重点锻炼部位：肱二头肌、胸大肌、三角肌和大圆肌等。 \r\nB.开始位置：身体仰卧，两手背后撑在稍高的凳子上，两脚放在较矮的凳子上，身体其它部分悬空。 \r\nC.动作过程：呼气，两肩放松，两臂慢慢屈肘，身体尽量下沉（尤其要沉臀），稍停2-3秒，然后吸气，用力伸两臂撑起身体还原。重复做。 D.训练要点：臂屈伸时中速平稳，身体要直，两肘要向内夹臂。抬高脚的高度或负重可提高训练难度，加大负荷刺激。');
INSERT INTO `jsclass` VALUES ('570', '仰卧屈臂上拉', 'A．重点锻炼部位：胸大肌、肱三头肌、前锯肌和背阔肌。 \r\nB．开始位置：仰卧在长凳上，使头部露出凳端，后脑$&*在凳的端面，两脚着地支撑。两手握住横杠中央，两手间距比肩稍窄，两手持铃放在头后地上，使下背部稍挺起。\r\nC．动作过程：稍屈臂持铃，把杠铃上拉起至胸部上方。然后，屈臂循原路放下至杠铃在头后稍离地面（杠铃不接触地面）。再用力上拉提起。重复做。\r\nD．训练要点：你可以用较大重量做屈臂上拉，并做直臂上拉比较一下，这样对训练会收 到较大的效果。');
INSERT INTO `jsclass` VALUES ('576', '站姿颈后臂屈伸', 'A.重点锻炼部位：主要健美肱三头肌。\r\nB.开始位置：全身直立，两手正握或反握杠铃，上臂屈曲固定在头的两侧。 \r\nC.动作过程：吸气，以肘关节为轴，用力将前臂伸直上举，稍停2-3秒。然后吸气，屈臂慢慢落下还原至颈后，重复练习。 \r\nD.训练要点：上臂必须紧贴耳侧，两肘夹紧，上臂保持与地面垂直状，两肘尖垂直向上，不要向前后移动借力。');
INSERT INTO `jsclass` VALUES ('577', '窄握推举', 'A.重点锻炼部位：胸大肌的内侧部位，三角肌前束和肱三头肌。\r\nB.开始位置：俯卧在长凳上，两脚平踏在地上，以维持身体平衡。两手握住横杠中间，间距4-6英寸，两臂伸直持铃支撑在两肩上方。\r\nC.动作过程：两臂慢慢弯屈落下至横杠触及胸部。然后向上推起至开始位置，重复练习。 \r\nD.训练要点：宽握卧推主 要是锻炼胸大肌，由内侧向外侧发展。');
INSERT INTO `jsclass` VALUES ('578', '坐姿单臂颈后臂屈伸', 'A．重点锻炼部位：肱三头肌。\r\nB．开始位置：正坐在凳上，两脚平踏在地上，右手持铃，掌心向前，伸直在头顶上方。左手托于左侧腰间。\r\nC．动作过程：右上臂紧贴右侧耳旁，不准移动。持铃以半园弧落下至左肩上方，持铃下落越低越好。然后，以右臂肱三头肌的收缩力，持铃向上举起还原。重复做。左、右 手交替做时，要完成同样次数。\r\nD．训练要点：持铃向头后对角线落下要比直接 向后方落下的训练效果要好。');
INSERT INTO `jsclass` VALUES ('579', '站姿双臂胸前屈肘下压', 'A、重点锻炼部位：肱三头肌和肘肌。\r\nB、开始位置：面对臂力训练机两脚分开站立，身体呈挺胸收腹紧腰状，屈臂两手紧握阻力杠两端把柄，两手间距小于肩宽。肘关节紧贴体侧，\r\nC、动作过程：吸气，小臂用力向下压撑阻力杠，使臂伸直，稍停2～3秒钟。然后呼气，缓慢还原。重复练习。 \r\nD、训练要点：注意动作要舒展，时关节紧贴体侧，防止猛压或 压到中途未能完成功作。身体不要 前伸后仰借力。');
INSERT INTO `jsclass` VALUES ('580', '颈后宽握引体向上', 'A、重点锻炼部位：背阔肌和肩部肌群。 B、开始位置：两臂悬垂在单杆上，两手宽握距，正手握紧横杆，使腰背以下部位放松，背阔肌充分伸长，两小腿弯曲抬起。 C、动作过程：吸气，集中背阔肌的收缩力，屈臂引体上开至颈后，使之接近或触及单杠，稍停2-3秒。然后呼气，以背阔肌的收缩力量控制住，使身体慢慢下降还原。重复练习。 \r\nD、训练要点：动作过程中身体不要前后摆动利用惯性给予助力；全身下垂时，肩胛部要放松。使背阔肌充分伸长.');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `ordertime` datetime DEFAULT NULL,
  `orderprice` int(10) DEFAULT NULL,
  `empid` int(11) DEFAULT NULL,
  `userid` int(23) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FK_order` (`empid`),
  CONSTRAINT `FK_order` FOREIGN KEY (`empid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('113', '2016-12-06 14:19:31', null, '4', null);
INSERT INTO `order` VALUES ('114', '2016-12-06 15:00:47', '1200', '10', null);
INSERT INTO `order` VALUES ('115', '2016-12-06 21:32:41', null, '5', null);
INSERT INTO `order` VALUES ('116', '2016-12-06 21:33:08', null, '8', null);
INSERT INTO `order` VALUES ('117', '2016-12-06 21:37:23', null, '8', null);
INSERT INTO `order` VALUES ('118', '2016-12-06 21:37:36', null, '8', null);
INSERT INTO `order` VALUES ('119', '2016-12-06 23:21:23', '4000', '10', null);
INSERT INTO `order` VALUES ('120', '2016-12-06 23:36:43', '1200', '5', null);
INSERT INTO `order` VALUES ('121', '2016-12-06 23:46:40', '4000', '10', null);
INSERT INTO `order` VALUES ('122', '2016-12-07 14:54:05', '1200', '9', null);
INSERT INTO `order` VALUES ('123', '2016-12-07 14:55:19', '500', '17', null);
INSERT INTO `order` VALUES ('124', '2016-12-07 14:56:43', '4000', '18', null);
INSERT INTO `order` VALUES ('125', '2016-12-07 14:57:37', '4000', '5', null);
INSERT INTO `order` VALUES ('126', '2016-12-07 15:18:54', '1200', '9', '10');
INSERT INTO `order` VALUES ('127', '2016-12-07 16:11:32', '1200', '9', '10');
INSERT INTO `order` VALUES ('128', '2016-12-07 16:16:38', '4000', '9', '10');
INSERT INTO `order` VALUES ('129', '2016-12-07 16:32:41', '4000', '9', '10');
INSERT INTO `order` VALUES ('130', '2016-12-07 16:35:27', '500', '9', '16');
INSERT INTO `order` VALUES ('131', '2016-12-07 16:39:24', '4000', '9', '10');
INSERT INTO `order` VALUES ('132', '2016-12-07 16:39:57', '4000', '9', '18');
INSERT INTO `order` VALUES ('133', '2017-03-25 01:20:32', null, '3', '3');
INSERT INTO `order` VALUES ('134', '2017-04-21 16:35:38', '4000', '19', '5');
INSERT INTO `order` VALUES ('135', '2017-04-21 16:35:50', '4000', '19', '5');
INSERT INTO `order` VALUES ('136', '2017-04-22 13:51:19', null, '19', '19');
INSERT INTO `order` VALUES ('137', '2017-04-22 13:57:59', '1200', '19', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL,
  `rolename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '教练');
INSERT INTO `role` VALUES ('2', '员工');
INSERT INTO `role` VALUES ('3', '会员');

-- ----------------------------
-- Table structure for tie
-- ----------------------------
DROP TABLE IF EXISTS `tie`;
CREATE TABLE `tie` (
  `tieid` int(11) NOT NULL AUTO_INCREMENT,
  `tietitle` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tieauthor` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tiecontext` varchar(2550) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tieDate` datetime DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`tieid`),
  KEY `FK_tie` (`userid`),
  CONSTRAINT `FK_tie` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of tie
-- ----------------------------
INSERT INTO `tie` VALUES ('1', '234234', '234234234', '234234234', '2016-11-08 19:35:14', '8');
INSERT INTO `tie` VALUES ('2', '345345', '345345345', '34534555', '2016-12-22 19:35:37', '8');
INSERT INTO `tie` VALUES ('3', '456456gfgf', 'fggfhfghhfg', 'hfggfhhgfhfg', '2016-11-17 19:35:51', '9');
INSERT INTO `tie` VALUES ('4', '456456546', null, '456456546', '2016-12-04 17:49:35', '18');
INSERT INTO `tie` VALUES ('5', '456456', null, '456456456', '2016-12-04 17:49:38', '18');
INSERT INTO `tie` VALUES ('6', '5647567', null, '5674567', '2016-12-04 17:21:59', '18');
INSERT INTO `tie` VALUES ('7', '56567567', null, '567567567', '2016-12-04 18:00:46', '18');
INSERT INTO `tie` VALUES ('8', '657567', null, '567567', '2016-12-04 21:42:50', '8');
INSERT INTO `tie` VALUES ('9', '67567', '小心', 'jhgjghj', '2016-12-05 04:31:11', '8');
INSERT INTO `tie` VALUES ('10', '456456', '小心', 'tghhh', '2016-12-05 04:32:54', '8');
INSERT INTO `tie` VALUES ('11', 'hhgghgh', '小心', 'hjghj55', '2016-12-05 15:55:39', '8');
INSERT INTO `tie` VALUES ('12', '567657', '小心', 'hghgjghjhgj', '2016-12-05 15:55:50', '8');
INSERT INTO `tie` VALUES ('13', 'fggf', '小心', 'hhhh', '2016-12-05 15:57:48', '8');
INSERT INTO `tie` VALUES ('14', 'gfdhfghfgh', '小心', 'fghfghfgh', '2016-12-06 21:33:56', '8');
INSERT INTO `tie` VALUES ('15', '你们好', '管理员', '我是管理员，你们有什么想问的吗？', '2017-03-25 01:42:41', '1');
INSERT INTO `tie` VALUES ('16', 'fgdgdfg', '小猪', 'dfgdfg', '2017-04-21 00:59:14', '19');
INSERT INTO `tie` VALUES ('17', 'asdasdasd', '小猪', 'asdasdasdasd', '2017-04-21 00:59:27', '19');
INSERT INTO `tie` VALUES ('18', '我在干嘛', '小猪', '你是谁？', '2017-04-21 00:59:58', '19');
INSERT INTO `tie` VALUES ('19', '就是就是', '小猪', '第三方接收到付款', '2017-04-21 16:30:46', '19');
INSERT INTO `tie` VALUES ('20', '哈哈健康', '小猪', '哈哈是道具卡刷多看', '2017-04-22 13:54:22', '19');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `role` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `truename` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vipendtime` date DEFAULT NULL,
  `number` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` bit(5) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `FK_user1` (`username`) USING BTREE,
  KEY `FK_user` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'fg676123', 'ma676123', '会员', '男', '马', '2016-11-23', '2342342342', '2019-03-23', null, null);
INSERT INTO `user` VALUES ('3', '345345', '345345', '员工', '男', '张三', '2016-11-16', '13987349378', '2018-12-22', null, null);
INSERT INTO `user` VALUES ('4', '3453451', '44', '会员', '男', '东方故事电饭锅', '2016-11-08', '发鬼地方个', '2018-12-16', null, null);
INSERT INTO `user` VALUES ('5', '34444', '3432224', '会员', '女', '345345', '2016-11-18', '345435', '2019-12-07', null, null);
INSERT INTO `user` VALUES ('8', '4', '66', '教练', '男', '我是谁', '2016-11-02', '', '2018-12-10', null, null);
INSERT INTO `user` VALUES ('9', '3', '3', '员工', '男', '哈哈', '2016-11-10', '456', '2017-03-07', null, null);
INSERT INTO `user` VALUES ('10', '5', '6', '员工', '女', '啦啦', '2016-11-16', '435435', '2018-12-18', null, null);
INSERT INTO `user` VALUES ('16', '123', '1233', '员工', '男', '李四', '2016-11-10', '1231233', '2018-01-07', null, null);
INSERT INTO `user` VALUES ('17', '6678787', '56565', '教练', '男', '礼拜', '2016-11-09', '867868', '2018-01-07', null, null);
INSERT INTO `user` VALUES ('18', '666666', '6', '教练', '男', '张哥', '2016-11-15', '68686', '2017-12-07', null, null);
INSERT INTO `user` VALUES ('19', '2333', '5555', '管理员', '男', '小猪', '2017-03-31', '45634534555', '2017-12-28', null, null);
INSERT INTO `user` VALUES ('20', '22', '122', '刚刚', null, null, null, null, '2017-03-11', null, null);
INSERT INTO `user` VALUES ('21', 'hha', '2323', '教练', '男', '狂欢节', '2017-03-08', '1312313123', '2017-03-19', null, null);
INSERT INTO `user` VALUES ('32', 'l10111', 'jkld', '会员', '男', '张四', '1988-10-20', '53545565', '2016-10-22', null, null);
INSERT INTO `user` VALUES ('33', 'l10112', 'jkld', '会员', '女', '张三', '1988-10-21', '53545566', '2016-10-23', null, null);
INSERT INTO `user` VALUES ('34', 'l10113', 'jkld', '会员', '女', '张四', '1988-10-22', '53545567', '2016-10-24', null, null);
INSERT INTO `user` VALUES ('35', 'l10114', 'jkld', '会员', '女', '张三', '1988-10-23', '53545568', '2016-10-25', null, null);
INSERT INTO `user` VALUES ('36', 'l10115', 'jkld', '会员', '女', '张四', '1988-10-24', '53545569', '2016-10-26', null, null);
INSERT INTO `user` VALUES ('37', 'l10116', 'jkld', '会员', '女', '张三', '1988-10-25', '53545570', '2016-10-27', null, null);
INSERT INTO `user` VALUES ('38', 'l10117', 'jkld', '会员', '女', '张四', '1988-10-26', '53545571', '2016-10-28', null, null);
INSERT INTO `user` VALUES ('39', 'l10118', 'jkld', '会员', '女', '张三', '1988-10-27', '53545572', '2016-10-29', null, null);
INSERT INTO `user` VALUES ('40', 'l10119', 'jkld', '会员', '女', '张四', '1988-10-28', '53545573', '2016-10-30', null, null);
INSERT INTO `user` VALUES ('41', 'l10120', 'jkld', '会员', '女', '张三', '1988-10-29', '53545574', '2016-10-31', null, null);
INSERT INTO `user` VALUES ('42', 'l10121', 'jkld', '会员', '女', '张四', '1988-10-30', '53545575', '2016-11-11', null, null);
INSERT INTO `user` VALUES ('43', 'l10122', 'jkld', '会员', '女', '张三', '1988-10-31', '53545576', '2016-11-21', null, null);
INSERT INTO `user` VALUES ('44', 'l10123', 'jkld', '会员', '女', '张四', '1988-11-11', '53545577', '2016-11-23', null, null);
INSERT INTO `user` VALUES ('45', 'l1011', 'jkld', '会员', '男', '张三', '1988-10-10', '53545555', '2016-10-12', null, null);
INSERT INTO `user` VALUES ('46', 'l1012', 'jkld', '会员', '男', '张三', '1988-10-11', '53545556', '2016-10-13', null, null);
INSERT INTO `user` VALUES ('47', 'l1013', 'jkld', '会员', '男', '张四', '1988-10-12', '53545557', '2016-10-14', null, null);
INSERT INTO `user` VALUES ('48', 'l1014', 'jkld', '会员', '男', '张三', '1988-10-13', '53545558', '2016-10-15', null, null);
INSERT INTO `user` VALUES ('53', 'l1019', 'jkld', '会员', '男', '张四', '1988-10-18', '53545563', '2016-10-20', null, null);
INSERT INTO `user` VALUES ('54', 'l1020', 'jkld', '会员', '男', '张三', '1988-10-19', '53545564', '2016-10-21', null, null);
INSERT INTO `user` VALUES ('55', 'l1021', 'jkld', '会员', '男', '张四', '1988-10-20', '53545565', '2016-10-22', null, null);
INSERT INTO `user` VALUES ('56', 'l1022', 'jkld', '会员', '女', '张三', '1988-10-21', '53545566', '2016-10-23', null, null);
INSERT INTO `user` VALUES ('57', 'l1023', 'jkld', '会员', '女', '张四', '1988-10-22', '53545567', '2016-10-24', null, null);
INSERT INTO `user` VALUES ('58', 'l1024', 'jkld', '会员', '女', '张三', '1988-10-23', '53545568', '2016-10-25', null, null);
INSERT INTO `user` VALUES ('59', 'l1025', 'jkld', '会员', '女', '张四', '1988-10-24', '53545569', '2016-10-26', null, null);
INSERT INTO `user` VALUES ('65', 'l1031', 'jkld', '会员', '女', '张四', '1988-10-30', '53545575', '2016-11-11', null, null);
INSERT INTO `user` VALUES ('66', 'l1032', 'jkld', '会员', '女', '张三', '1988-10-31', '53545576', '2016-11-21', null, null);
INSERT INTO `user` VALUES ('67', 'l1033', 'jkld', '会员', '女', '张四', '1988-11-11', '53545577', '2016-11-23', null, null);
INSERT INTO `user` VALUES ('68', 'mam112', '123123', '教练', '男', 'sdfsdf', '2017-04-12', 'sdfsdf', '2017-04-21', null, null);
INSERT INTO `user` VALUES ('70', 'a1011', 'jkld', '会员', '男', '张三', '1988-10-10', '53545555', '2018-10-12', null, null);
INSERT INTO `user` VALUES ('71', 'a1012', 'jkld', '会员', '男', '张三', '1988-10-11', '53545556', '2018-10-13', null, null);
INSERT INTO `user` VALUES ('72', 'a1013', 'jkld', '会员', '男', '张四', '1988-10-12', '53545557', '2018-10-14', null, null);
INSERT INTO `user` VALUES ('73', 'a1014', 'jkld', '会员', '男', '张三', '1988-10-13', '53545558', '2018-10-15', null, null);
INSERT INTO `user` VALUES ('74', 'a1015', 'jkld', '会员', '男', '张四', '1988-10-14', '53545559', '2018-10-16', null, null);
INSERT INTO `user` VALUES ('75', 'a1016', 'jkld', '会员', '男', '张三', '1988-10-15', '53545560', '2018-10-17', null, null);
INSERT INTO `user` VALUES ('76', 'a1017', 'jkld', '会员', '男', '张四', '1988-10-16', '53545561', '2018-10-18', null, null);
INSERT INTO `user` VALUES ('77', 'a123123', 'a123123', '教练', '男', 'haha', '2017-04-07', '1312312311', '2017-04-22', null, null);
INSERT INTO `user` VALUES ('78', 'm1011', 'jkld', '会员', '男', '张三', '1988-10-10', '53545555', '2018-10-12', null, null);
INSERT INTO `user` VALUES ('79', 'm1012', 'jkld', '会员', '男', '张三', '1988-10-11', '53545556', '2018-10-13', null, null);
INSERT INTO `user` VALUES ('80', 'm1013', 'jkld', '会员', '男', '张四', '1988-10-12', '53545557', '2018-10-14', null, null);
INSERT INTO `user` VALUES ('81', 'm1014', 'jkld', '会员', '男', '张三', '1988-10-13', '53545558', '2018-10-15', null, null);
INSERT INTO `user` VALUES ('82', 'm1015', 'jkld', '会员', '男', '张四', '1988-10-14', '53545559', '2018-10-16', null, null);
INSERT INTO `user` VALUES ('83', 'm1016', 'jkld', '会员', '男', '张三', '1988-10-15', '53545560', '2018-10-17', null, null);
INSERT INTO `user` VALUES ('84', 'm1017', 'jkld', '会员', '男', '张四', '1988-10-16', '53545561', '2018-10-18', null, null);

-- ----------------------------
-- Table structure for yycourse
-- ----------------------------
DROP TABLE IF EXISTS `yycourse`;
CREATE TABLE `yycourse` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `yytime` datetime DEFAULT NULL,
  `classover` bit(1) DEFAULT NULL,
  `teacherid` int(11) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseid`),
  KEY `FK_course1` (`studentid`),
  KEY `FK_course2` (`cid`),
  KEY `FK_course` (`teacherid`),
  CONSTRAINT `yycourse_ibfk_1` FOREIGN KEY (`teacherid`) REFERENCES `user` (`userid`) ON DELETE SET NULL,
  CONSTRAINT `yycourse_ibfk_2` FOREIGN KEY (`studentid`) REFERENCES `user` (`userid`) ON DELETE SET NULL,
  CONSTRAINT `yycourse_ibfk_3` FOREIGN KEY (`cid`) REFERENCES `jsclass` (`cid`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of yycourse
-- ----------------------------
INSERT INTO `yycourse` VALUES ('1', '2016-11-16 02:05:09', '', null, '8', '2');
INSERT INTO `yycourse` VALUES ('2', '2016-11-22 14:04:37', '\0', '4', '8', '3');
INSERT INTO `yycourse` VALUES ('3', '2016-11-11 14:04:53', '', '9', '10', null);
INSERT INTO `yycourse` VALUES ('36', '2016-11-25 15:04:14', '\0', '4', '1', '567');
INSERT INTO `yycourse` VALUES ('37', '2016-11-25 15:04:14', '\0', '16', '1', '570');
INSERT INTO `yycourse` VALUES ('39', '2016-11-16 23:31:18', '\0', '4', '1', '566');
INSERT INTO `yycourse` VALUES ('40', '2016-11-24 18:52:35', '\0', '17', null, '566');
INSERT INTO `yycourse` VALUES ('41', '2016-11-17 18:53:27', '\0', null, null, '576');
INSERT INTO `yycourse` VALUES ('42', '2016-11-18 18:55:23', '\0', '18', '8', '566');
INSERT INTO `yycourse` VALUES ('43', '2016-11-11 22:02:25', '\0', '18', '8', '566');
INSERT INTO `yycourse` VALUES ('44', '2016-12-22 04:10:22', '\0', '17', '18', '568');
INSERT INTO `yycourse` VALUES ('45', '2016-12-16 04:21:01', '\0', '17', '4', '2');
INSERT INTO `yycourse` VALUES ('46', '2016-12-16 21:34:40', '\0', '17', '8', '570');
