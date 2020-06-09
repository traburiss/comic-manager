package com.tcl.comic.manager.service

import com.tcl.comic.manager.entity.user.UserInfoDo
import com.tcl.comic.manager.mapper.UserMapper
import com.tcl.comic.manager.utils.encrypt.utils.DesUtils
import org.apache.commons.lang3.math.NumberUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

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

    fun login(loginName: String, passWord: String): String {
        val userInfoDo: UserInfoDo = userMapper.login(loginName, passWord) ?: return ""
        val expired = systemConfigService.loginExpire()
        val expireTime = System.currentTimeMillis() + expired.toMillis()
        val token = DesUtils.encrypt(expireTime.toString(), userInfoDo.loginName + userInfoDo.salt)
        userMapper.updateToken(userInfoDo.id, token)
        return token
    }

    fun tokenGetUserData(token: String): UserInfoDo? {
        return userMapper.tokenGetData(token)
    }

    fun tokenCheck(token: String): Boolean {
        val userInfo = userMapper.tokenGetData(token)
        return when {
            userInfo == null -> false
            !systemConfigService.useExpire() -> true
            else -> NumberUtils.toLong(DesUtils.decrypt(userInfo.token, userInfo.loginName + userInfo.salt)) > System.currentTimeMillis()
        }
    }

    fun logout(id: Int, token: String): Boolean {
        userMapper.deleteToken(id)
        return true
    }
}
