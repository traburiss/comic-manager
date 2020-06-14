package com.tcl.comic.manager.entity

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable

/**
 * Created by traburiss on 2020/6/14.
 * describe:
 */

@Schema(description = "分页请求")
open class PageRequest(
        @Schema(description = "页码")
        open val page: Int,
        @Schema(description = "每页大小")
        open val pageSize: Int) : Serializable {
    fun start(): Int {
        return (page - 1) * pageSize
    }
}
