package com.tcl.comic.manager.service

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.tcl.comic.manager.entity.user.UserInfoDo
import com.tcl.comic.manager.mapper.UserMapper
import com.tcl.comic.manager.utils.encrypt.utils.DesUtils
import org.apache.commons.lang3.math.NumberUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

/**
 * Created by traburiss on 2020/5/28.
 * describe:
 */
@Service
class LoginService {

    @Autowired
    private lateinit var userMapper: UserMapper

    @Autowired
    private lateinit var systemConfigService: SystemConfigService

    private lateinit var tokenCache: LoadingCache<String, Long>

    @PostConstruct
    fun init() {
        tokenCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(1, TimeUnit.DAYS)
                .concurrencyLevel(10)
                .build(object : CacheLoader<String, Long>() {
                    override fun load(key: String): Long {
                        val userInfo = userMapper.checkToken(key) ?: return 0
                        return NumberUtils.toLong(DesUtils.decrypt(userInfo.token, userInfo.loginName + userInfo.salt))
                    }
                })
    }

    fun login(loginName: String, passWord: String): String {
        val userInfoDo: UserInfoDo? = userMapper.login(loginName, passWord) ?: return ""
        val expired = systemConfigService.loginExpire()
        val token = DesUtils.encrypt((System.currentTimeMillis() + expired.toMillis()).toString(), userInfoDo!!.loginName + userInfoDo.salt)
        userMapper.updateToken(userInfoDo.id, token)
        return token
    }

    fun tokenCheck(token: String): Boolean {
        val checkToken = tokenCache.get(token)
        return if (checkToken == null) {
            false
        } else if (systemConfigService.useExpire()) {
            true
        } else {
            checkToken > System.currentTimeMillis()
        }
    }
}
