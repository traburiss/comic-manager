package com.tcl.comic.manager.mapper

import com.tcl.comic.manager.entity.user.UserDataVO
import com.tcl.comic.manager.entity.user.UserInfoDo
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * Created by traburiss on 2020/5/28.
 * describe:
 */
@Repository
interface UserMapper {
    fun login(@Param("loginName") loginName: String, @Param("passWord") passWord: String): UserInfoDo?
    fun tokenGetData(@Param("token") token: String): UserInfoDo?
    fun updateToken(@Param("id") id: Int, @Param("token") token: String)
    fun deleteToken(@Param("id") id: Int)
    fun userData(@Param("id") id: Int): UserDataVO?
    fun userInfo(@Param("id") id: Int): UserInfoDo?
    fun updateUserName(@Param("id") id: Int, @Param("userName") userName: String)
    fun updatePassword(@Param("id") id: Int, @Param("password") password: String)
}
