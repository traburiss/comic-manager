package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode
import com.tcl.comic.manager.entity.user.UpdatePasswordVO
import com.tcl.comic.manager.entity.user.UpdateUserNameVO
import com.tcl.comic.manager.entity.user.UserDataVO
import com.tcl.comic.manager.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

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
    fun userData(model: Model): Response<UserDataVO> {
        val id = model.getAttribute(Constant.LOGIN_ID) as Int
        val userDataVO = userService.userData(id)
        return if (userDataVO != null) {
            Response(ResponseCode.SUCCESS.code, "成功", userDataVO)
        } else {
            Response(ResponseCode.QUERY_ERROR.code, "为查找到用户", UserDataVO())
        }
    }


    @Operation(summary = "更新用户名")
    @PostMapping("/update/username")
    fun updateUserName(model: Model, @RequestBody userName: UpdateUserNameVO): Response<Boolean> {
        val id = model.getAttribute(Constant.LOGIN_ID) as Int
        userService.updateUserName(id, userName.userName)
        return Response(data = true)
    }

    @Operation(summary = "更新用户密码")
    @PostMapping("/update/password")
    fun updatePassword(model: Model, @RequestBody pwd: UpdatePasswordVO): Response<Boolean> {
        val id = model.getAttribute(Constant.LOGIN_ID) as Int
        return when (val code = userService.updatePassword(id, pwd.pwd, pwd.newPwd)) {
            ResponseCode.QUERY_ERROR -> Response(code.code, "为查找到对应用户", false)
            ResponseCode.PARAM_ERROR -> Response(code.code, "原始密码错误", false)
            ResponseCode.SUCCESS -> Response(data = true)
            else -> return Response(code.code, code.msg, false)
        }
    }
}
