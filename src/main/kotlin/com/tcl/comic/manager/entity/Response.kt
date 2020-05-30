package com.tcl.comic.manager.entity

import com.tcl.comic.manager.entity.ResponseCode.SUCCESS

/**
 * Created by traburiss on 2020/5/31.
 * describe:
 */
data class Response<T>(val code: Int = SUCCESS.code, val msg: String = SUCCESS.msg, val data: T)
enum class ResponseCode(val code: Int, val msg: String) {
    SUCCESS(200, "成功"),
    PARAM_ERROR(400, "参数异常"),
    QUERY_ERROR(401, "请求错误"),
    SERVER_ERROR(500, "服务器异常异常");
}
