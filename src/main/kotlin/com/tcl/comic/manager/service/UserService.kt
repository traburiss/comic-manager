package com.tcl.comic.manager.service

import com.tcl.comic.manager.entity.user.UserDataVO
import com.tcl.comic.manager.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by traburiss on 2020/6/9.
 * describe:
 */
@Service
class UserService {
    @Autowired
    private lateinit var userMapper: UserMapper

    fun userData(id: Int): UserDataVO {
        return userMapper.userData(id)
    }
}
