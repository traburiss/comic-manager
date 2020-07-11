package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.entity.Page
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.role.RoleModifyVO
import com.tcl.comic.manager.entity.role.RoleRequestVO
import com.tcl.comic.manager.entity.role.RoleVO
import com.tcl.comic.manager.service.RoleService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

/**
 * Created by traburiss on 2020/7/11.
 * describe:
 */
@RestController
@RequestMapping("/api/role")
@Tag(name = "RoleController", description = "角色接口")
class RoleController {

    @Autowired
    private lateinit var roleService: RoleService

    @Operation(summary = "获取角色列表")
    @GetMapping("/list")
    fun roleList(query: RoleRequestVO): Mono<Response<Page<RoleVO>>> {
        return Mono.fromSupplier {
            roleService.roleList(query)
        }
    }

    @Operation(summary = "新增角色")
    @PostMapping("/add")
    fun addRole(@RequestBody role: RoleModifyVO, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            roleService.addRole(role, userId)
        }
    }

    @Operation(summary = "关联角色与书库")
    @PostMapping("/relate/role/library")
    fun relateRoleAndLibrary(@RequestParam("roleId") roleId: Int, libraryId: Int): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            roleService.relateRoleAndLibrary(roleId, libraryId)
        }
    }

    @Operation(summary = "关联角色与目录")
    @PostMapping("/relate/role/menu")
    fun relateRoleAndMenu(@RequestParam("roleId") roleId: Int, menuId: Int): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            roleService.relateRoleAndMenu(roleId, menuId)
        }
    }

    @Operation(summary = "编辑角色")
    @PostMapping("/edit")
    fun editRole(@RequestBody role: RoleModifyVO, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            roleService.editRole(role, userId)
        }
    }

    @Operation(summary = "删除角色")
    @DeleteMapping("/remove")
    fun removeRole(@RequestParam("roleId") roleId: Int, model: Model): Mono<Response<Boolean>> {
        return Mono.fromSupplier {
            val userId = model.getAttribute(Constant.LOGIN_ID) as Int
            roleService.removeRole(roleId, userId)
        }
    }
}
