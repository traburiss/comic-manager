package com.tcl.comic.manager.entity.user

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/9.
 * describe: 前端缓存的用户信息
 */
@Schema(description = "用户数据")
data class UserDataVO(
        @Schema(description = "用户名称")
        val userName: String = "",
        @Schema(description = "登陆名称")
        val loginName: String = "",
        @Schema(description = "角色名称")
        val roleName: String = "",
        @Schema(description = "目录列表")
        val menuList: ArrayList<MenuInfoVO> = arrayListOf())
