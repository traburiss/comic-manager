package com.tcl.comic.manager.config.web

import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode.PARAM_ERROR
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ServerWebInputException


/**
 * Created by traburiss on 2020/5/31.
 * describe:
 */
@RestControllerAdvice
class ControllerExceptionHandler {
    private val logger = LoggerFactory.getLogger("ExceptionHandler")

    @ExceptionHandler(ServerWebInputException::class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    fun handleCustomException(e: Exception): Response<String> {
        logger.error("参数错误", e)
        return Response(PARAM_ERROR.code, PARAM_ERROR.msg + ":" + e.message, "")
    }
}
