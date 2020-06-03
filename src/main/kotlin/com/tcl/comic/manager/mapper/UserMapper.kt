package com.tcl.comic.manager.mapper

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
    fun checkToken(@Param("token") token: String): UserInfoDo?
    fun updateToken(@Param("id") id: Int, @Param("token") token: String)
    fun deleteToken(@Param("id") id: Int)
}
