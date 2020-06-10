package com.tcl.comic.manager.entity.user

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/11.
 * describe:
 */
@Schema(description = "修改用户名")
data class UpdateUserNameVO(@Schema(description = "用户名") val userName: String)
