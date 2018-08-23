use `member`;

create table `coins_rules`(
`id` int(10) primary key not null AUTO_INCREMENT,
`card_type` int(4) not null default 0 comment '卡类型',
`start_time` datetime not null comment '开始时间',
`end_time` datetime not null comment '结束时间',
`weeks` varchar(32) comment '星期，选择星期一到星期日的集合',
`house` varchar(128) comment '适用房型',
`low_price` int(10) comment '房价范围-最低房价',
`top_price` int(10) comment '房价范围-最高',
`cost_amout` int(10) comment '消费金额',
`earn_coins` int(10) comment '可得积分',
`reset_time` datetime comment '清零时间',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='积分规则表';


create table `dictionary`(
`id` int(10) primary key not null AUTO_INCREMENT,
`dic_type` varchar(32) comment '功能代码',
`dic_code` varchar(32) comment '功能code',
`dic_name` varchar(32) comment '描述',
`dic_value` varchar(32) comment '值',
`unit` varchar(32) comment '单位',
`is_delete` tinyint(2) comment '启用标志 0-可用 1-弃用',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='字典表';

create table `member_adject`(
`id` int(10) primary key not null AUTO_INCREMENT,
`adject_name` varchar(32) not null default '' comment '优惠名称',
`adject_type` tinyint(4) not null default 0 comment '优惠类型 0-立减，1-折扣',
`adject_state` tinyint(4) not null default 0 comment '活动状态 未开始、进行中、已结束、已作废',
`start_time` datetime not null comment '开始时间',
`end_time` datetime not null comment '结束时间',
`init_amount` int(10) not null default 0 comment '门槛金额',
`adject_amount` int(10) not null default 0 comment '立减金额 折扣比例 根据优惠类型判断',
`join_times` tinyint(4) not null default 1 comment '每天没人参加次数',
`member_level` varchar(64) not null default '' comment  '会员等级，多选 , 分割',
`hotel` varchar(256) not null default '' comment '酒店范围，多选 , 分割',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员优惠表';



create table `member_card`(
`id` int(10) primary key not null AUTO_INCREMENT,
`member_id` int(10) not null default 0 comment'会员 id',
`card_type` int(10) not null default 0 comment '会员卡类型',
`valid_date` datetime not null comment '有效期',
`coins` int(10) not null default 0 comment '积分',
`deposit_amount` int(10) not null default 0 comment '押金',
`balance` int(10) not null default 0 comment '余额',
`real_balance` int(10) not null default 0 comment '净余额',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员卡管理';

create table `member_care`(
`id` int(10) primary key not null AUTO_INCREMENT,
`care_name` varchar(64) not null default '' comment '关怀名称',
`care_type` tinyint(4) not null default 0 comment '关怀类型 0-短信，1-邮件',
`care_content` blob not null default '' comment '关怀内容',
`care_member_level` varchar(128) not null default '' comment '关怀会员等级,多选 , 分隔',
`send_time` datetime comment '发送时间',
`state` tinyint(2) not null default 0 comment '启用标志 0-启用，1-禁用',
`complete_time` datetime not null default now() comment '完成时间',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员关怀表';

create table `member_coins_record`(
`id` int(10) primary key not null AUTO_INCREMENT,
`member_card_no` varchar(32) not null default '' comment '会员卡号',
`member_phone` varchar(32) not null default '' comment '会员手机号',
`create_time` datetime not null default now() comment '创建时间',
`record_type` tinyint(4) not null default 0 comment '积分类型',
`coins` int(10) not null default 0 comment '积分 正负两种类型'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员积分记录';

create table `member`(
`id` int(10) primary key not null AUTO_INCREMENT,
`member_no` varchar(32) not null default '' comment '会员编号',
`name` varchar(32) not null default '' comment '会员姓名',
`gender` tinyint(2) not null default 0 comment '性别',
`birth` varchar(32) not null default '' comment '生日',
`phone` varchar(32) not null default '' comment '联系方式',
`identity` varchar(32) not null default '' comment '证件号',
`card_no` varchar(32) not null default '' comment '会员卡号',
`card_password` varchar(64) not null default '' comment '会员卡密码',
`source` int(10) not null default 0 comment '发展来源，选择的酒店列表',
`coins` int(10) not null default 0 comment '积分',
`balance` int(10) not null default 0 comment '余额',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员表';


create table `member_feedback_message`(
`id` int(10) primary key not null AUTO_INCREMENT,
`member_id` int(10) not null default 0 comment '会员ID',
`hotel_id` int(10) not null default 0 comment '酒店id',
`state` tinyint(4) not null default 0 comment '是否展示在前台 0-不展示，1-展示',
`comment` varchar(512) not null default '' comment '反馈内容',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员反馈信息表';


create table `member_level`(
`id` int(10) primary key not null AUTO_INCREMENT,
`level_name` varchar(64) not null default '' comment '等级名称',
`condition` tinyint(4) not null default 0 comment '最近几个月',
`in_times` int(10) not null default 0 comment '入住次数',
`in_costs` int(10) not null default 0 comment '花费金额',
`create_time` datetime comment '创建时间',
`create_user_id` int(10) comment '创建用户id',
`modify_time` datetime comment '修改时间',
`modify_user_id` int(10) comment '修改用户ID'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员等级表';

create table `member_third_message`(
`id` int(10) primary key not null AUTO_INCREMENT,
`member_no` varchar(32) not null default '' comment '会员编号',
`menber_phone` varchar(32) not null default '' comment '会员手机号',
`qq` varchar(32) not null default '' comment 'qq号',
`wechart` varchar(64) not null default '' comment '微信号',
`nick_name` varchar(128) not null default '' comment '昵称',
`weibo` varchar(64) not null default '' comment '微博'
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='会员第三方信息表';