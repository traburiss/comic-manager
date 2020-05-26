package com.tcl.comic.manager.utils.encrypt.utils

import com.tcl.comic.manager.utils.encrypt.utils.base.MessageDigestUtils.getMessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Md5加密工具类
 * Created by traburiss on 2018/1/3.
 */
object Md5Utils {
    
    private const val KEY_MD5 = "MD5"

    /**
     * Md5加密
     *
     * @param text 需要加密的文本
     * @return 加密的结果
     */
    fun getResult(text: String): String {
        return getMessageDigest(text.toByteArray(), KEY_MD5)
    }
}
