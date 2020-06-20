package com.tcl.comic.manager.entity.library

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Created by traburiss on 2020/6/20.
 * describe:
 */
@Schema(description = "标签信息")
data class TagVO(
        @Schema(description = "标签ID")
        val id: Int,
        @Schema(description = "书库ID")
        val libraryId: Int,
        @Schema(description = "漫画标签名称")
        val name: String
)
