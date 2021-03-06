package com.tcl.comic.manager.entity.config

import io.swagger.v3.oas.annotations.media.Schema
import java.sql.Timestamp

/**
 * Created by traburiss on 2020/6/14.
 * describe:
 */
@Schema(description = "系统配置项")
data class SystemConfigVO(
        @Schema(description = "系统配置key，唯一")
        val key: String,
        @Schema(description = "配置值")
        val value: String,
        @Schema(description = "配置名称")
        val name: String,
        @Schema(description = "配置说明")
        val desc: String,
        @Schema(description = "配置类型，0为不可改系统配置，1为可改系统配置，2为可改用户配置默认配置")
        val type: Int,
        @Schema(description = "上次更新人")
        val updater: String,
        @Schema(description = "上次更新时间")
        val updateTime: Timestamp)
