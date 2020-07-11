package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant.COOKIES_TOKEN
import com.tcl.comic.manager.config.Constant.LOGIN_API
import com.tcl.comic.manager.config.Constant.LOGIN_ID
import com.tcl.comic.manager.config.Constant.LOGOUT_API
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode.QUERY_ERROR
import com.tcl.comic.manager.entity.ResponseCode.SUCCESS
import com.tcl.comic.manager.entity.user.LoginRequestVO
import com.tcl.comic.manager.service.LoginService
import com.tcl.comic.manager.service.SystemConfigService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono


/**
 * Created by traburiss on 2020/5/29.
 * describe:
 */
@RestController
@Tag(name = "LoginController", description = "登陆接口")
class LoginController {

    @Autowired
    private lateinit var loginService: LoginService

    @Autowired
    private lateinit var systemConfigService: SystemConfigService

    @Operation(summary = "登陆")
    @PostMapping(LOGIN_API)
    fun login(@RequestBody loginRequest: LoginRequestVO, exchange: ServerWebExchange): Mono<Response<String>> {
        return Mono.fromSupplier {
            loginService.login(loginRequest.loginName, loginRequest.passWord)
            val token = loginService.login(loginRequest.loginName, loginRequest.passWord)
            if (StringUtils.isNotBlank(token)) {
                val responseCookie = if (systemConfigService.useExpire()) {
                    ResponseCookie.from(COOKIES_TOKEN, token).maxAge(systemConfigService.loginExpire()).path("/").build()
                } else {
                    ResponseCookie.from(COOKIES_TOKEN, token).maxAge(-1).path("/").build()
                }
                exchange.response.addCookie(responseCookie)
                Response(token)
            } else {
                Response("", QUERY_ERROR.code, "登录失败，请检查账号密码")
            }
        }
    }

    @Operation(summary = "检查token")
    @GetMapping("/api/token/check")
    fun tokenCheck(@RequestParam("token") token: String): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val success = loginService.tokenCheck(token)
            if (success) {
                Response(success)
            } else {
                Response(success, QUERY_ERROR.code, "校验token失败，你还未登录")
            }
        }
    }

    @Operation(summary = "登出")
    @PostMapping(LOGOUT_API)
    fun logout(model: Model, exchange: ServerWebExchange): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val id = model.getAttribute(LOGIN_ID)
            val cookie = exchange.request.cookies[COOKIES_TOKEN]
            if (id is Int && cookie != null) {
                val token = cookie[0].value
                loginService.logout(id, token)
                Response(true, SUCCESS.code, "登出成功")
            } else {
                exchange.response.statusCode = HttpStatus.UNAUTHORIZED
                Response(false, QUERY_ERROR.code, "你还未登录")
            }
        }
    }
}
