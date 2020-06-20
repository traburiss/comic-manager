package com.tcl.comic.manager.service

import com.tcl.comic.manager.entity.Response
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

    fun updatePassword(id: Int, password: String, newPassword: String): Response<Boolean> {
        val userInfo = userMapper.userInfo(id) ?: return Response(false, ResponseCode.QUERY_ERROR.code, "为查找到对应用户")
        if (!StringUtils.equals(userInfo.passWord, password)) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "原始密码错误")
        }
        userMapper.updatePassword(id, newPassword)
        return Response(true)
    }
}
