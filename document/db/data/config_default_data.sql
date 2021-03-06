insert into sys_config
    (config_key, config_value, config_name, config_desc, type, update_id)
values ('login_expired', '2073600', '登陆过期时间，单位秒', '登陆过期时间，默认值为2个月', 1, 1),
       ('expired_used', 'true', '是否使用登陆超时时间', '登陆过期时间，默认值为2个月', 1, 1),
       ('key', substring(md5(rand()), 1, 20), '加密用密钥', '加密用的密钥，不可修改', 0, 1),
       ('history', '300', '阅读历史保留长度', '阅读历史保留长度', 1, 1);

# 密码是123456（值是sha256的123456）
insert into user_info (user_name, login_name, pass_word, salt, update_id)
values ('system', 'system', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', substring(md5(rand()), 1, 5), 1);

insert into role_info (role_name, role_desc, update_id)
values ('system', 'system橘色', 1);

insert into menu_info (id, parent_id, sort, menu_name, menu_desc, menu_code, update_id)
values (1, 0, 1, '搜索', '搜索页面', 'search', 1),
       (2, 0, 2, '漫画', '漫画管理', 'comic', 1),
       (3, 0, 3, '系列', '漫画系列', 'series', 1),
       (4, 0, 4, '管理', '管理页面', 'manager', 1),
       (5, 4, 5, '用户', '用户管理', 'user', 1),
       (6, 4, 6, '角色', '角色管理', 'role', 1),
       (7, 4, 7, '书库', '书库管理', 'library', 1),
       (8, 4, 8, '配置', '配置管理', 'config', 1);

insert into user_role_map (user_id, role_id)
values (1, 1);
insert into role_menu_map (role_id, menu_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8);
