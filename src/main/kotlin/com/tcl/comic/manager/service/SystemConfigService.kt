package com.tcl.comic.manager.service

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.mapper.SysConfigMapper
import org.apache.commons.lang3.BooleanUtils
import org.apache.commons.lang3.math.NumberUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Duration

/**
 * Created by traburiss on 2020/5/31.
 * describe:
 */
@Service
class SystemConfigService {

    @Autowired
    private lateinit var sysConfigMapper: SysConfigMapper

    fun getValue(key: String): String {
        return sysConfigMapper.getValue(key)
    }

    fun loginExpire(): Duration {
        val expired = NumberUtils.toLong(sysConfigMapper.getValue(Constant.CONFIG_LOGIN_EXPIRED))
        return Duration.ofSeconds(expired);
    }

    fun useExpire(): Boolean {
        val expired = sysConfigMapper.getValue(Constant.CONFIG_EXPIRED_USED)
        return BooleanUtils.toBoolean(expired)
    }
}
