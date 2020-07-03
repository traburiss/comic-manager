package com.tcl.comic.manager.entity.library

import com.tcl.comic.manager.entity.PageRequest
import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/14.
 * describe:
 */
@Schema(description = "查询书库")
data class LibraryRequestVO(
        override val page: Int,
        override val pageSize: Int,
        @Schema(description = "书库名称")
        val name: String,
        @Schema(description = "查询人角色ID")
        var roleId: Int = 0) : PageRequest(page, pageSize)
