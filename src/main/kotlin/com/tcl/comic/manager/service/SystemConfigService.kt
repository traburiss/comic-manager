package com.tcl.comic.manager.service

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.mapper.SysConfigMapper
import org.apache.commons.lang3.BooleanUtils
import org.apache.commons.lang3.math.NumberUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Duration
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct

/**
 * Created by traburiss on 2020/5/31.
 * describe:
 */
@Service
class SystemConfigService {

    @Autowired
    private lateinit var sysConfigMapper: SysConfigMapper

    private lateinit var configCache: LoadingCache<String, String>

    @PostConstruct
    fun init() {
        configCache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(10, TimeUnit.SECONDS)
                .concurrencyLevel(10)
                .build(object : CacheLoader<String, String>() {
                    override fun load(key: String): String {
                        return sysConfigMapper.getValue(key)
                    }
                })
    }

    fun getValue(key: String): String {
        return configCache.get(key)
    }

    fun loginExpire(): Duration {
        val expired = NumberUtils.toLong(configCache.get(Constant.CONFIG_LOGIN_EXPIRED))
        return Duration.ofSeconds(expired);
    }

    fun useExpire(): Boolean {
        val expired = configCache.get(Constant.CONFIG_EXPIRED_USED)
        return BooleanUtils.toBoolean(expired)
    }
}
