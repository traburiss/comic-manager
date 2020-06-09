package com.tcl.comic.manager.config.token

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.tcl.comic.manager.entity.user.UserInfoDo
import com.tcl.comic.manager.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

/**
 * Created by traburiss on 2020/6/10.
 */
@Service("tokenCache")
class TokenCacheImpl : TokenCache {

    @Autowired
    private lateinit var userMapper: UserMapper

    private lateinit var tokenCache: LoadingCache<String, UserInfoDo>

    @PostConstruct
    fun init() {
        tokenCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(1, TimeUnit.DAYS)
                .concurrencyLevel(10)
                .build(object : CacheLoader<String, UserInfoDo>() {
                    override fun load(key: String): UserInfoDo? {
                        return userMapper.tokenGetData(key)
                    }
                })
    }

    override fun tokenGetData(token: String): UserInfoDo? {
        return tokenCache.get(token)
    }

    override fun tokenPutData(token: String, userInfo: UserInfoDo) {
        tokenCache.put(token, userInfo)
    }

    override fun refresh(token: String) {
        tokenCache.refresh(token)
    }
}
