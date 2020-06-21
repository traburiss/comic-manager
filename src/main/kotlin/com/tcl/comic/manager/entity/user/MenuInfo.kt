package com.tcl.comic.manager.entity.user

/**
 * Created by traburiss on 2020/6/9.
 * describe:
 */
data class MenuInfo(val id: Int = 0,
                    val parentId: Int = 0,
                    val menuName: String = "",
                    val menuDesc: String = "",
                    val menuCode: String = "")
