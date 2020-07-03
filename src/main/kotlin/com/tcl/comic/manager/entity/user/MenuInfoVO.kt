package com.tcl.comic.manager.entity.user

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/9.
 * describe:
 */
@Schema(description = "目录信息")
data class MenuInfoVO(
        @Schema(description = "目录ID")
        val id: Int = 0,
        @Schema(description = "目录父ID")
        val parentId: Int = 0,
        @Schema(description = "目录名称")
        val menuName: String = "",
        @Schema(description = "目录说明")
        val menuDesc: String = "",
        @Schema(description = "目录编码")
        val menuCode: String = "")
