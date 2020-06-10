package com.tcl.comic.manager.service

import com.tcl.comic.manager.entity.ResponseCode
import com.tcl.comic.manager.entity.user.UserDataVO
import com.tcl.comic.manager.mapper.UserMapper
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by traburiss on 2020/6/9.
 * describe:
 */
@Service
class UserService {
    @Autowired
    private lateinit var userMapper: UserMapper

    fun userData(id: Int): UserDataVO? {
        return userMapper.userData(id)
    }

    fun updateUserName(id: Int, userName: String) {
        userMapper.updateUserName(id, userName)
    }

    fun updatePassword(id: Int, password: String, newPassword: String): ResponseCode {
        val userInfo = userMapper.userInfo(id) ?: return ResponseCode.QUERY_ERROR
        if (!StringUtils.equals(userInfo.passWord, password)) {
            return ResponseCode.PARAM_ERROR
        }
        userMapper.updatePassword(id, newPassword)
        return ResponseCode.SUCCESS
    }
}
