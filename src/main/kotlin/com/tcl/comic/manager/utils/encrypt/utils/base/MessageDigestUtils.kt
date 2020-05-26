package com.tcl.comic.manager.utils.encrypt.utils.base

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * 信息摘要工具类
 * Created by traburiss on 2018/1/3.
 */
object MessageDigestUtils {
    /**
     * 信息摘要
     *
     * @param inputData 需要摘要的数据
     * @return 摘要的结果
     */
    fun getMessageDigest(inputData: ByteArray, type: String): String {
        val messageDigest = MessageDigest.getInstance(type)
        messageDigest.update(inputData)
        val byteBuffer = messageDigest.digest()
        return byte2Hex(byteBuffer)
    }

    /**
     * byte数组转为hex字符串
     *
     * @param byteBuffer byte数组
     * @return hex字符串
     */
    fun byte2Hex(byteBuffer: ByteArray): String {
        val strHexString = StringBuilder()
        for (aByteBuffer in byteBuffer) {
            val hex = Integer.toHexString(0xff and aByteBuffer.toInt())
            if (hex.length == 1) {
                strHexString.append('0')
            }
            strHexString.append(hex)
        }
        return strHexString.toString()
    }
}
