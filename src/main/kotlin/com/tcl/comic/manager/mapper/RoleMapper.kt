package com.tcl.comic.manager.mapper

import com.tcl.comic.manager.entity.role.RoleModifyVO
import com.tcl.comic.manager.entity.role.RoleRequestVO
import com.tcl.comic.manager.entity.role.RoleVO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * Created by traburiss on 2020/7/5.
 * describe:
 */
@Repository
interface RoleMapper {
    fun roleList(@Param("query") query: RoleRequestVO, @Param("start") start: Int, @Param("pageSize") pageSize: Int): List<RoleVO>
    fun roleCount(@Param("query") query: RoleRequestVO): Int
    fun getRole(@Param("roleId") roleId: Int): RoleVO?
    fun addRole(@Param("item") role: RoleModifyVO, @Param("userId") userId: Int)
    fun relateRoleAndLibrary(@Param("roleId") roleId: Int, @Param("libraryId") libraryId: Int)
    fun relateRoleAndMenu(@Param("roleId") roleId: Int, @Param("menuId") menuId: Int)
    fun editRole(@Param("item") role: RoleModifyVO, @Param("userId") userId: Int)
    fun removeRole(@Param("roleId") roleId: Int, @Param("userId") userId: Int)
}
