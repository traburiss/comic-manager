package com.tcl.comic.manager.mapper

import com.tcl.comic.manager.entity.user.MenuInfoVO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

/**
 * Created by traburiss on 2020/7/11.
 * describe:
 */
@Repository
interface MenuMapper {
    fun getMenuById(@Param("menuId") menuId: Int): MenuInfoVO?
}
