package com.tcl.comic.manager.controller

import com.tcl.comic.manager.entity.user.LoginRequestVO
import com.tcl.comic.manager.service.LoginService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * Created by traburiss on 2020/5/29.
 * describe:
 */
@RestController
@RequestMapping("/api/login")
@Tag(name = "登陆")
class LoginController {

    @Autowired
    lateinit var loginService: LoginService

    @Operation(summary = "登陆")
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequestVO): String {
        return loginService.login(loginRequest.loginName, loginRequest.passWord)
    }

    @Operation(summary = "检查token")
    @PostMapping("/token/check")
    fun tokenCheck(@RequestParam("token") loginName: String): Boolean {
        return loginService.tokenCheck(loginName)
    }
}
