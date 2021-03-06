package com.tcl.comic.manager.config

/**
 * Created by traburiss on 2020/5/29.
 * describe:
 */
object Constant {

    const val LOGIN_NAME = "loginName"
    const val LOGIN_ID = "loginId"
    const val ROLE_ID = "role_id"

    const val API = "/api"
    const val SWAGGER = "swagger"
    const val API_DOC = "api-docs"
    const val FRONTEND = "[^\\\\.]*"
    const val CSS = "/css"
    const val JS = "/js"
    const val FONTS = "/fonts"
    const val FAVICON = "/favicon.ico"
    const val INDEX_PAGE = "/index.html"
    const val LOGIN_PAGE = "/login"
    const val HOME_PAGE = "/home"
    const val LOGIN_API = "/api/user/login"
    const val LOGOUT_API = "/api/user/logout"

    /**
     * token的key
     */
    const val COOKIES_TOKEN = "token"

    /**
     * 登陆过期时间，单位秒
     */
    const val CONFIG_LOGIN_EXPIRED = "login_expired"

    /**
     * 是否使用登陆过期时间
     */
    const val CONFIG_EXPIRED_USED = "expired_used"
}
