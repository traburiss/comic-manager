package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode
import com.tcl.comic.manager.entity.user.UserDataVO
import com.tcl.comic.manager.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ServerWebExchange

/**
 * Created by traburiss on 2020/6/9.
 * describe:
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "UserController", description = "用户接口")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @Operation(summary = "获取用户信息")
    @GetMapping("/data")
    fun userData(model: Model, exchange: ServerWebExchange): Response<UserDataVO> {
        val id = model.getAttribute(Constant.LOGIN_ID)
        return if (id != null && id is Int) {
            val userDataVO = userService.userData(id)
            Response(ResponseCode.SUCCESS.code, "成功", userDataVO)
        } else {
            exchange.response.statusCode = HttpStatus.UNAUTHORIZED
            Response(ResponseCode.USER_ERROR.code, "你还未登录", UserDataVO())
        }
    }
}
