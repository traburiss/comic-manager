#书库，漫画，漫画系列，漫画标签表

drop table if exists library;
create table library
(
    id            bigint primary key auto_increment not null comment 'id',
    group_name    varchar(30)                       not null comment '圈子名称',
    group_desc    varchar(60)                       not null comment '圈子说明',
    library_type  varchar(10)                       not null comment '书库类型：file/smb',
    library_path  varchar(512)                      not null comment '书库路径',
    library_param varchar(512)                      not null comment '书库参数',
    update_id     bigint                            not null comment '上次更新人的id，0为system',
    update_time   timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '书库表';

drop table if exists user_library_map;
create table user_library_map
(
    user_id    bigint not null comment 'user_info的id',
    library_id bigint not null comment 'library_的id'
) engine = InnoDB comment '用户书库关联表';

drop table if exists comic_series;
create table comic_series
(

    id          bigint primary key auto_increment not null comment 'id',
    interest_id bigint                            not null comment '兴趣圈ID',
    series_name varchar(30)                       not null comment '系列名称',
    series_desc varchar(60)                       null comment '系类说明',
    update_id   bigint                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '漫画系列表';

drop table if exists comic_index;
create table comic_index
(
    id          bigint primary key auto_increment not null comment 'id',
    interest_id bigint                            not null comment '兴趣圈ID',
    series_id   bigint                            null comment '系列ID',
    comic_name  varchar(30)                       not null comment '漫画名称',
    comic_desc  varchar(60)                       null comment '漫画说明',
    store_path  varchar(512)                      not null comment '存储的路径，相对圈子书库路径的路径，所以其实不用512',
    store_type  varchar(10)                       not null comment '存储类型，zip/dir',
    update_id   bigint                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '漫画索引表';

drop table if exists tag;
create table tag
(
    id          bigint primary key auto_increment not null comment 'id',
    interest_id bigint                            not null comment '兴趣圈ID',
    tag_name    varchar(30)                       not null comment 'tag名称',
    update_id   bigint                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '标签表';

drop table if exists tag_comic_mapper;
create table tag_comic_mapper
(
    comic_index_id bigint not null comment '漫画id',
    tag_id         bigint not null comment '标签ID'
) engine = InnoDB comment '标签漫画关联表';
