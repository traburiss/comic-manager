package com.tcl.comic.manager.entity.user

/**
 * Created by traburiss on 2020/6/9.
 * describe: 前端缓存的用户信息
 */
data class UserDataVO(val userName: String = "",
                      val loginName: String = "",
                      val roleName: String = "",
                      val menuList: ArrayList<MenuInfo> = arrayListOf())
