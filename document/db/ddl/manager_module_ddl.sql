# 配置、用户、角色、组织（喜好）
create table sys_config(
  config_key varchar(20) primary key not null comment '配置key',
  config_value varchar(20) not null comment '配置值',
  config_name varchar(20) not null comment '配置名称',
  config_desc varchar(100) not null comment '配置说明',
  type tinyint(1) not null default 0 comment '配置类型，0为不可修改系统全局配置，1为可修改系统全局配置，2为用户默认配置',
  update_id bigint not null comment '上次更新人的id，0为system',
  update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
)engine=InnoDB comment '系统配置信息表(其实把参数表也放进来了)';

create table user_config(
    id bigint primary key auto_increment not null comment 'id',
    user_id bigint not null comment '配置所属用户',
    config_key varchar(20) not null unique comment '配置key',
    config_value varchar(20) not null comment '配置值',
    config_name varchar(20) not null comment '配置名称',
    config_desc varchar(100) not null comment '配置说明',
    update_id bigint not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
)engine=InnoDB comment '用户配置信息表';
