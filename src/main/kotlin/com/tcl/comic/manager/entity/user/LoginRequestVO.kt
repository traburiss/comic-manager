package com.tcl.comic.manager.entity.user

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable

/**
 * Created by traburiss on 2020/5/29.
 * describe:
 */
@Schema(description = "登陆实体")
data class LoginRequestVO(
        @Schema(description = "登录名")
        var loginName: String = "",
        @Schema(description = "密码")
        var passWord: String) : Serializable
