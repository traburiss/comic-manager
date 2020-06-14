package com.tcl.comic.manager.mapper

import com.tcl.comic.manager.entity.config.SysCfgRequestVO
import com.tcl.comic.manager.entity.config.SystemConfigModifyVO
import com.tcl.comic.manager.entity.config.SystemConfigVO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * Created by traburiss on 2020/5/29.
 * describe:
 */
@Repository
interface SysConfigMapper {
    fun getValue(@Param("key") key: String): String?
    fun configList(@Param("query") query: SysCfgRequestVO, @Param("start") start: Int, @Param("pageSize") pageSize: Int): List<SystemConfigVO>
    fun configCount(@Param("query") query: SysCfgRequestVO): Int
    fun addConfig(@Param("item") systemConfigVO: SystemConfigModifyVO, @Param("userId") userId: Int)
    fun editConfig(@Param("item") systemConfigVO: SystemConfigModifyVO, @Param("userId") userId: Int)
}
