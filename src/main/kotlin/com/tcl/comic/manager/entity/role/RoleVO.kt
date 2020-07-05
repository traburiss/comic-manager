package com.tcl.comic.manager.entity.role

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/20.
 * describe:
 */
@Schema(description = "角色信息")
data class RoleVO(
        @Schema(description = "角色ID")
        val id: Int,
        @Schema(description = "角色名称")
        val name: String,
        @Schema(description = "角色说明")
        val desc: String,
        @Schema(description = "更新人")
        val updater: String,
        @Schema(description = "更新时间")
        val updateTime: String
)
