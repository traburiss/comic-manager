package com.tcl.comic.manager.entity.user

/**
 * Created by traburiss on 2020/5/28.
 * describe:
 */
data class UserInfoDo(val id: Int = 0,
                      val userName: String = "",
                      val loginName: String = "",
                      val passWord: String = "",
                      val salt: String = "",
                      val token: String = "")
