package com.tcl.comic.manager.utils.encrypt.utils

import com.tcl.comic.manager.utils.encrypt.utils.base.MessageDigestUtils.getMessageDigest
import java.security.NoSuchAlgorithmException

/**
 * sha加密工具类
 * Created by traburiss on 2018/1/3.
 */
object ShaUtils {
    private const val KEY_SHA1 = "SHA-1"
    private const val KEY_SHA256 = "SHA-256"
    private const val KEY_SHA512 = "SHA-512"

    /**
     * sha-1加密
     *
     * @param text 需要加密的文本
     * @return 加密的结果
     */
    fun getSha1Result(text: String): String {
        return getShaResult(text, KEY_SHA1)
    }

    /**
     * sha-256加密
     *
     * @param text 需要加密的文本
     * @return 加密的结果
     */
    fun getSha256Result(text: String): String {
        return getShaResult(text, KEY_SHA256)
    }

    /**
     * sha-512加密
     *
     * @param text 需要加密的文本
     * @return 加密的结果
     */
    fun getSha512Result(text: String): String {
        return getShaResult(text, KEY_SHA512)
    }

    /**
     * sha加密
     *
     * @param text 需要加密的文本
     * @param type 加密类型
     * @return 加密的结果
     */
    private fun getShaResult(text: String, type: String): String {
        return getMessageDigest(text.toByteArray(), type)
    }
}
