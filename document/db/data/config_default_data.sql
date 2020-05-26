insert into sys_config 
    (config_key, config_value, config_name, config_desc, type, update_id)
values 
    ('login_expired', '2073600', '登陆过期时间，单位秒', '登陆过期时间，默认值为2个月', 1, 0),
    ('expired_used', '2073600', '是否使用登陆超时时间', '登陆过期时间，默认值为2个月', 1, 0);
