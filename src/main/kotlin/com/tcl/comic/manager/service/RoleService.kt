package com.tcl.comic.manager.service

import com.tcl.comic.manager.entity.Page
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode
import com.tcl.comic.manager.entity.role.RoleModifyVO
import com.tcl.comic.manager.entity.role.RoleRequestVO
import com.tcl.comic.manager.entity.role.RoleVO
import com.tcl.comic.manager.mapper.LibraryMapper
import com.tcl.comic.manager.mapper.MenuMapper
import com.tcl.comic.manager.mapper.RoleMapper
import org.apache.commons.lang3.ObjectUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by traburiss on 2020/7/11.
 * describe:
 */
@Service
class RoleService {

    @Autowired
    private lateinit var roleMapper: RoleMapper

    @Autowired
    private lateinit var libraryMapper: LibraryMapper

    @Autowired
    private lateinit var menuMapper: MenuMapper

    fun roleList(query: RoleRequestVO): Response<Page<RoleVO>> {
        if (ObjectUtils.isEmpty(query)) {
            return Response(Page(emptyList(), 0), ResponseCode.PARAM_ERROR.code, "参数为空，请检查参数")
        }
        val start = query.start()
        val list = roleMapper.roleList(query, start, query.pageSize)
        val count = roleMapper.roleCount(query)
        val data = Page(list, count)
        return Response(data)
    }

    fun addRole(role: RoleModifyVO, userId: Int): Response<Boolean> {
        if (ObjectUtils.isEmpty(role)) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "参数为空，请检查参数")
        }
        roleMapper.addRole(role, userId)
        return Response(true)
    }

    fun relateRoleAndLibrary(roleId: Int, libraryId: Int): Response<Boolean> {
        if (libraryMapper.getLibrary(libraryId) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有书库信息，请检查参数")
        }
        if (roleMapper.getRole(roleId) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有角色信息，请检查参数")
        }
        roleMapper.relateRoleAndLibrary(roleId, libraryId)
        return Response(true)
    }

    fun relateRoleAndMenu(roleId: Int, menuId: Int): Response<Boolean> {
        if (menuMapper.getMenuById(menuId) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有目录信息，请检查参数")
        }
        if (roleMapper.getRole(roleId) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有角色信息，请检查参数")
        }
        roleMapper.relateRoleAndMenu(roleId, menuId)
        return Response(true)
    }

    fun editRole(role: RoleModifyVO, userId: Int): Response<Boolean> {
        if (ObjectUtils.isEmpty(role)) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "参数为空，请检查参数")
        }
        if (roleMapper.getRole(role.id) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有角色信息，请检查参数")
        }
        roleMapper.editRole(role, userId)
        return Response(true)
    }

    fun removeRole(roleId: Int, userId: Int): Response<Boolean> {
        if (roleMapper.getRole(roleId) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "没有角色信息，请检查参数")
        }
        roleMapper.removeRole(roleId, userId)
        return Response(true)
    }
}
