package com.tcl.comic.manager.entity.library

import io.swagger.v3.oas.annotations.media.Schema
import java.sql.Timestamp

/**
 * Created by traburiss on 2020/6/20.
 * describe:
 */
@Schema(description = "书库配置项")
data class LibraryVO(
        @Schema(description = "书库id")
        val id: Int,
        @Schema(description = "书库名称")
        val name: String,
        @Schema(description = "书库说明")
        val desc: String,
        @Schema(description = "书库类型:1.file 2.smb")
        val type: Int,
        @Schema(description = "书库路径")
        val path: String,
        @Schema(description = "书库参数")
        val param: String,
        @Schema(description = "扫描状态:0已准备，1正在扫描，2已完成扫描")
        val status: Int,
        @Schema(description = "扫描时间")
        val scanTime: Timestamp,
        @Schema(description = "扫描信息")
        val scanMsg: String,
        @Schema(description = "更新人")
        val updater: String,
        @Schema(description = "更新时间")
        val updateTime: String
)
