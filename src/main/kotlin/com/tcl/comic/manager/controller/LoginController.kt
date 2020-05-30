package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant.COOKIES_TOKEN
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode.QUERY_ERROR
import com.tcl.comic.manager.entity.user.LoginRequestVO
import com.tcl.comic.manager.service.LoginService
import com.tcl.comic.manager.service.SystemConfigService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseCookie
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ServerWebExchange


/**
 * Created by traburiss on 2020/5/29.
 * describe:
 */
@RestController
@RequestMapping("/api/login")
@Tag(name = "LoginController", description = "登陆接口")
class LoginController {

    @Autowired
    lateinit var loginService: LoginService

    @Autowired
    lateinit var systemConfigService: SystemConfigService

    @Operation(summary = "登陆")
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequestVO, exchange: ServerWebExchange): Response<String> {
        loginService.login(loginRequest.loginName, loginRequest.passWord);
        val token = loginService.login(loginRequest.loginName, loginRequest.passWord);
        return if (StringUtils.isNotBlank(token)) {
            val responseCookie = if (systemConfigService.useExpire()) {
                ResponseCookie.from(COOKIES_TOKEN, token).maxAge(systemConfigService.loginExpire()).path("/").build()
            } else {
                ResponseCookie.from(COOKIES_TOKEN, token).maxAge(-1).path("/").build()
            }
            exchange.response.addCookie(responseCookie)
            Response(data = token)
        } else {
            Response(QUERY_ERROR.code, "登录失败，请检查账号密码", "")
        }
    }

    @Operation(summary = "检查token")
    @GetMapping("/token/check")
    fun tokenCheck(@RequestParam("token") loginName: String): Response<Boolean> {
        val success = loginService.tokenCheck(loginName)
        return if (success) {
            Response(data = success)
        } else {
            Response(QUERY_ERROR.code, "校验token失败，你还未登录", success)
        }
    }
}
