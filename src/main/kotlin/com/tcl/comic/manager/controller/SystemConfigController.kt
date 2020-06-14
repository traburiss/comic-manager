package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.entity.Page
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode
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
        val data = systemConfigService.getConfigList(query)
        return Response(data = data)
    }

    @Operation(summary = "新增配置")
    @PostMapping("/add")
    //傻逼了，这个功能根本木有用……算了，都开发完了
    fun addConfig(@RequestBody systemConfigVO: SystemConfigModifyVO, model: Model): Response<Boolean> {
        val userId = model.getAttribute(Constant.LOGIN_ID) as Int
        val code = systemConfigService.addConfig(systemConfigVO, userId)
        return when {
            code == ResponseCode.PARAM_ERROR -> Response(code.code, "key已经使用，请更换一个", false)
            code != ResponseCode.SUCCESS -> return Response(code.code, code.msg, false)
            else -> return Response(code.code, code.msg, true)
        }
    }

    @Operation(summary = "编辑配置")
    @PostMapping("/edit")
    fun editConfig(@RequestBody systemConfigVO: SystemConfigModifyVO, model: Model): Response<Boolean> {
        val userId = model.getAttribute(Constant.LOGIN_ID) as Int
        val code = systemConfigService.editConfig(systemConfigVO, userId)
        return when {
            code == ResponseCode.PARAM_ERROR -> Response(code.code, "不存在该key对应的值，请确认", false)
            code != ResponseCode.SUCCESS -> return Response(code.code, code.msg, false)
            else -> return Response(code.code, code.msg, true)
        }
    }
}
