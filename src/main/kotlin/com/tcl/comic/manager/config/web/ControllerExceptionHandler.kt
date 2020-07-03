package com.tcl.comic.manager.config.web

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.config.Constant.API
import com.tcl.comic.manager.config.Constant.LOGIN_ID
import com.tcl.comic.manager.config.Constant.LOGIN_NAME
import com.tcl.comic.manager.config.Constant.ROLE_ID
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode.PARAM_ERROR
import com.tcl.comic.manager.entity.ResponseCode.SERVER_ERROR
import com.tcl.comic.manager.service.LoginService
import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.ServerWebInputException


/**
 * Created by traburiss on 2020/5/31.
 * describe:
 */
@RestControllerAdvice
class ControllerExceptionHandler {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var loginService: LoginService

    @ModelAttribute
    fun addAttributes(exchange: ServerWebExchange, model: Model) {
        val path = exchange.request.uri.path
        if (StringUtils.startsWith(path, API)) {
            val cookies = exchange.request.cookies[Constant.COOKIES_TOKEN]
            if (cookies != null) {
                val token = cookies[0].value
                val userInfo = loginService.tokenGetUserData(token)
                if (userInfo != null) {
                    model.addAttribute(LOGIN_NAME, userInfo.loginName)
                    model.addAttribute(LOGIN_ID, userInfo.id)
                    model.addAttribute(ROLE_ID, userInfo.roleId)
                }
            }
        }
    }

    @ExceptionHandler(ServerWebInputException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleCustomException(e: Exception): Response<String> {
        logger.error("参数错误", e)
        return Response("", PARAM_ERROR.code, PARAM_ERROR.msg + ":" + e.message)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: Exception): Response<String> {
        logger.error("未知错误", e)
        return Response(e.message.toString(), SERVER_ERROR.code, SERVER_ERROR.msg)
    }
}
