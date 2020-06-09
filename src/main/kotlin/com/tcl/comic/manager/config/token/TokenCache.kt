package com.tcl.comic.manager.config.token

import com.tcl.comic.manager.entity.user.UserInfoDo

/**
 * Created by traburiss on 2020/6/10.
 * describe: 这个封装考虑到可能的缓存，但暂时不用
 */
interface TokenCache {
    fun tokenGetData(token: String): UserInfoDo?
    fun tokenPutData(token: String, userInfo: UserInfoDo)
    fun refresh(token: String)
}
