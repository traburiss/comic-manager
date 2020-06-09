package com.tcl.comic.manager.service

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.tcl.comic.manager.entity.user.UserDataVO
import com.tcl.comic.manager.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

/**
 * Created by traburiss on 2020/6/9.
 * describe:
 */
@Service
class UserService {
    @Autowired
    private lateinit var userMapper: UserMapper

    private lateinit var tokenCache: LoadingCache<Int, UserDataVO>

    @PostConstruct
    fun init() {
        tokenCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(1, TimeUnit.DAYS)
                .concurrencyLevel(10)
                .build(object : CacheLoader<Int, UserDataVO>() {
                    override fun load(id: Int): UserDataVO {
                        return userMapper.userData(id)
                    }
                })
    }

    fun userData(id: Int): UserDataVO {
        return tokenCache.get(id)
    }
}
