#书库，漫画，漫画系列，漫画标签表

drop table if exists library;
create table library
(
    id            int primary key auto_increment not null comment 'id',
    library_name  varchar(30)                    not null comment '书库名称',
    library_desc  varchar(60)                    not null comment '书库说明',
    library_type  tinyint                        not null comment '书库类型：1.file 2.smb...',
    library_path  varchar(1024)                  not null comment '书库路径',
    library_param varchar(1024)                  not null comment '书库参数',
    scan_status   tinyint      default 0         not null comment '0已准备，1正在扫描，2已完成扫描',
    scan_time     timestamp    default current_timestamp on update current_timestamp comment '上次扫描时间',
    scan_msg      varchar(128) default ''        not null comment '扫描结果信息',
    enabled       boolean      default true      not null comment '是否可用',
    update_id     int                            not null comment '上次更新人的id，0为system',
    update_time   timestamp    default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '书库表';

drop table if exists role_library_map;
create table role_library_map
(
    role_id    int not null comment 'role_info的id',
    library_id int not null comment 'library_的id'
) engine = InnoDB comment '角色书库关联表';

drop table if exists comic_series;
create table comic_series
(

    id          int primary key auto_increment not null comment 'id',
    library_id  int                            not null comment '书库ID',
    series_name varchar(30)                    not null comment '系列名称',
    series_desc varchar(60)                    null comment '系类说明',
    enabled     boolean   default true         not null comment '是否可用',
    update_id   int                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '漫画系列表';

drop table if exists comic_index;
create table comic_index
(
    id           int primary key auto_increment not null comment 'id',
    library_id   int                            not null comment '书库ID',
    series_id    int                            null comment '系列ID',
    comic_name   varchar(30)                    not null comment '漫画名称',
    comic_desc   varchar(60)                    null comment '漫画说明',
    store_path   varchar(512)                   not null comment '存储的路径，相对圈子书库路径的路径，所以其实不用512',
    store_type   varchar(10)                    not null comment '存储类型，zip/dir',
    comic_status tinyint   default 0            not null comment '-1隐藏，0已准备(上传/扫描/加载)，1已发布',
    enabled      boolean   default true         not null comment '是否可用',
    update_id    int                            not null comment '上次更新人的id，0为system',
    update_time  timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '漫画索引表';

drop table if exists tag;
create table tag
(
    id          int primary key auto_increment not null comment 'id',
    library_id  int                            not null comment '书库ID',
    tag_name    varchar(30)                    not null comment 'tag名称',
    enabled     boolean   default true         not null comment '是否可用',
    update_id   int                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '标签表';

drop table if exists tag_comic_mapper;
create table tag_comic_mapper
(
    comic_index_id int not null comment '漫画id',
    tag_id         int not null comment '标签ID'
) engine = InnoDB comment '标签漫画关联表';


drop table if exists read_history;
create table read_history
(
    id          int primary key auto_increment not null comment 'id',
    user_id     int                            not null comment '用户ID',
    comic_id    int                            null comment '漫画ID',
    page        int                            null comment '进度',
    update_id   int                            not null comment '上次更新人的id，0为system',
    update_time timestamp default current_timestamp on update current_timestamp comment '上次更新时间'
) engine = InnoDB comment '漫画阅读历史表';
