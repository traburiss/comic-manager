package com.tcl.comic.manager.entity.library

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/20.
 * describe:
 */
@Schema(description = "新增/编辑书库配置项")
data class LibraryModifyVO(
        @Schema(description = "书库ID")
        val id: Int,
        @Schema(description = "书库名称")
        val name: String,
        @Schema(description = "书库说明")
        val desc: String,
        @Schema(description = "书库类型")
        val type: Int,
        @Schema(description = "书库路径")
        val path: String,
        @Schema(description = "书库参数")
        val param: String)
