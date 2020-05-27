insert into sys_config 
    (config_key, config_value, config_name, config_desc, type, update_id)
values 
    ('login_expired', '2073600', '登陆过期时间，单位秒', '登陆过期时间，默认值为2个月', 1, 0),
    ('expired_used', 'true', '是否使用登陆超时时间', '登陆过期时间，默认值为2个月', 1, 0),
    ('key', substring(md5(rand()),1,20), '加密用密钥', '加密用的密钥，不可修改', 0, 0);

# 手动算好，密码的SHA256(真的密码+盐)
insert into user_info (user_name, login_name, pass_word, salt, update_id)
values ('system', 'system', ?, ?, 0);

insert into role_info (role_name, role_desc, update_id)
values ('system', 'system橘色', 0);

insert into menu_info (id, menu_name, menu_desc, menu_sort, update_id)
values (1, '开始', '开始页面', 1, 0),
       (2, '书柜', '查阅漫画', 2, 0),
       (3, '我', '我的页面', 3, 0),
       (4, '漫画管理', '漫画管理', 4, 0),
       (5, '用户管理', '用户/角色/兴趣管理', 5, 0),
       (6, '系统管理', '系统管理', 6, 0);

insert into user_role_map (user_id, role_id)
values (1, 1);
insert into role_menu_map (role_id, menu_id)
values (1, 1),(1,2),(1,3),(1,4),(1,5),(1,6);
