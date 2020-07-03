package com.tcl.comic.manager.entity

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/14.
 * describe:
 */
@Schema(description = "分页")
data class Page<T>(
        @Schema(description = "数据")
        val list: List<T>,
        @Schema(description = "总页数")
        val count: Int)
