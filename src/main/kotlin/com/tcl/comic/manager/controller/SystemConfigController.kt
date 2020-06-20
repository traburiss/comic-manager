package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.entity.Page
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.config.SysCfgRequestVO
import com.tcl.comic.manager.entity.config.SystemConfigModifyVO
import com.tcl.comic.manager.entity.config.SystemConfigVO
import com.tcl.comic.manager.service.SystemConfigService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

/**
 * Created by traburiss on 2020/6/14.
 * describe:
 */
@RestController
@RequestMapping("/api/sys_cfg")
@Tag(name = "LoginController", description = "登陆接口")
class SystemConfigController {
    @Autowired
    private lateinit var systemConfigService: SystemConfigService

    @Operation(summary = "获取系统配置")
    @GetMapping("/list")
    fun getConfigList(query: SysCfgRequestVO): Response<Page<SystemConfigVO>> {
        return systemConfigService.getConfigList(query)
    }

    @Operation(summary = "新增配置")
    @PostMapping("/add")
    @Deprecated(message = "傻逼了，这个功能根本木有用……算了，都开发完了")
    fun addConfig(@RequestBody systemConfigVO: SystemConfigModifyVO, model: Model): Response<Boolean> {
        val userId = model.getAttribute(Constant.LOGIN_ID) as Int
        return systemConfigService.addConfig(systemConfigVO, userId)
    }

    @Operation(summary = "编辑配置")
    @PostMapping("/edit")
    fun editConfig(@RequestBody systemConfigVO: SystemConfigModifyVO, model: Model): Response<Boolean> {
        val userId = model.getAttribute(Constant.LOGIN_ID) as Int
        return systemConfigService.editConfig(systemConfigVO, userId)
    }
}
