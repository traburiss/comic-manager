package com.tcl.comic.manager.entity.role

import com.tcl.comic.manager.entity.PageRequest
import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/14.
 * describe:
 */
@Schema(description = "查询角色")
data class RoleRequestVO(
        override val page: Int,
        override val pageSize: Int,
        @Schema(description = "角色名称")
        val name: String) : PageRequest(page, pageSize)
