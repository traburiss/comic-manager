package com.tcl.comic.manager.entity.user

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/11.
 * describe:
 */
@Schema(description = "修改密码")
data class UpdatePasswordVO(@Schema(description = "旧密码") val pwd: String, @Schema(description = "新密码") val newPwd: String)
