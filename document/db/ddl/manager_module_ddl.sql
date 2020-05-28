# 配置、用户、角色、组织（喜好）
drop table if exists sys_config;
drop table if exists user_config;
drop table if exists user_info;
drop table if exists role_info;
drop table if exists interest_group;
drop table if exists menu_info;
drop table if exists user_role_map;
drop table if exists role_menu_map;
drop table if exists user_interest_map;

create table sys_config
(
    config_key   varchar(20) primary key not null comment '配置key',
    config_value varchar(20)             not null comment '配置值',
    config_name  varchar(20)             not null comment '配置名称',
    config_desc  varchar(100)            not null comment '配置说明',
    type         tinyint(1)              not null default 0 comment '配置类型，0为不可修改系统全局配置，1为可修改系统全局配置，2为用户默认配置',
    update_id    bigint                  not null comment '上次更新人的id，0为system',
    update_time  timestamp                        default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '系统配置信息表(其实把参数表也放进来了)';

create table user_config
(
    id           bigint primary key auto_increment not null comment 'id',
    user_id      bigint                            not null comment '配置所属用户',
    config_key   varchar(20)                       not null unique comment '配置key',
    config_value varchar(20)                       not null comment '配置值',
    config_name  varchar(20)                       not null comment '配置名称',
    config_desc  varchar(100)                      not null comment '配置说明',
    update_id    bigint                            not null comment '上次更新人的id，0为system',
    update_time  timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '用户配置信息表';

create table user_info
(
    id          bigint primary key auto_increment not null comment 'id',
    user_name   varchar(30)                       not null comment '用户名',
    login_name  varchar(30) unique                not null comment '登陆名',
    pass_word   varchar(65)                       not null comment '密码',
    salt        varchar(5)                        not null comment '加密的盐',
    token       varchar(100) default null comment 'token,懒得弄redis',
    update_id   bigint                            not null comment '上次更新人的id，0为system',
    update_time timestamp    default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '用户信息表';
# 说实话一下表纯属无聊建着玩，系统本来不需要这么复杂的东西
create table role_info
(
    id          bigint primary key auto_increment not null comment 'id',
    role_name   varchar(30)                       not null comment '角色名称',
    role_desc   varchar(60)                       not null comment '角色说明',
    update_id   bigint                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '角色表';

create table interest_group
(
    id          bigint primary key auto_increment not null comment 'id',
    group_name  varchar(30)                       not null comment '圈子名称',
    group_desc  varchar(60)                       not null comment '圈子说明',
    update_id   bigint                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '圈子表';

create table menu_info
(
    id          bigint primary key not null comment 'id',
    menu_name   varchar(30)        not null comment '目录名称',
    menu_desc   varchar(60)        not null comment '目录说明',
    menu_sort   mediumint          not null comment '目录排序',
    update_id   bigint             not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '目录表';

create table user_role_map
(
    user_id bigint not null comment 'user_info的id',
    role_id bigint not null comment 'user_info的id'
) engine = InnoDB comment '用户角色关联表';

create table role_menu_map
(
    role_id bigint not null comment 'user_info的id',
    menu_id bigint not null comment 'menu_info的id'
) engine = InnoDB comment '角色目录关联表';

create table user_interest_map
(
    user_id     bigint not null comment 'user_info的id',
    interest_id bigint not null comment 'interest的id'
) engine = InnoDB comment '用户兴趣关联表';
