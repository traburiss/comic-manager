package com.tcl.comic.manager.mapper

import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * Created by traburiss on 2020/5/29.
 * describe:
 */
@Repository
interface SysConfigMapper {
    fun getValue(@Param("key") key: String): String
}
