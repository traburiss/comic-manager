package com.tcl.comic.manager.entity.config

import com.tcl.comic.manager.entity.PageRequest
import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/14.
 * describe:
 */
@Schema(description = "系统配置项")
data class SysCfgRequestVO(
        override val page: Int,
        override val pageSize: Int,
        @Schema(description = "查询的配置名称")
        val name: String) : PageRequest(page, pageSize)
