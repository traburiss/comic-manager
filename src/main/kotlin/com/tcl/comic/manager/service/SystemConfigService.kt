package com.tcl.comic.manager.service

import com.tcl.comic.manager.config.Constant
import com.tcl.comic.manager.entity.Page
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode
import com.tcl.comic.manager.entity.config.SysCfgRequestVO
import com.tcl.comic.manager.entity.config.SystemConfigModifyVO
import com.tcl.comic.manager.entity.config.SystemConfigVO
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
        return sysConfigMapper.getValue(key) ?: ""
    }

    fun getConfigList(query: SysCfgRequestVO): Response<Page<SystemConfigVO>> {
        val start = query.start()
        val list = sysConfigMapper.configList(query, start, query.pageSize)
        val count = sysConfigMapper.configCount(query)
        val data = Page(list, count)
        return Response(data = data)
    }

    fun addConfig(systemConfigVO: SystemConfigModifyVO, userId: Int): Response<Boolean> {
        if (sysConfigMapper.getValue(systemConfigVO.key) != null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "key已经使用，请更换一个")
        }
        sysConfigMapper.addConfig(systemConfigVO, userId)
        return Response(true)
    }

    fun editConfig(systemConfigVO: SystemConfigModifyVO, userId: Int): Response<Boolean> {
        if (sysConfigMapper.getValue(systemConfigVO.key) == null) {
            return Response(false, ResponseCode.PARAM_ERROR.code, "不存在该key对应的值，请确认")
        }
        sysConfigMapper.editConfig(systemConfigVO, userId)
        return Response(true)
    }

    fun loginExpire(): Duration {
        val expired = NumberUtils.toLong(sysConfigMapper.getValue(Constant.CONFIG_LOGIN_EXPIRED))
        return Duration.ofSeconds(expired)
    }

    fun useExpire(): Boolean {
        val expired = sysConfigMapper.getValue(Constant.CONFIG_EXPIRED_USED)
        return BooleanUtils.toBoolean(expired)
    }
}
