package com.tcl.comic.manager.utils.encrypt.utils

import java.security.Key
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

/**
 * Created by traburiss on 2020/5/27.
 * describe:
 */
object DesUtils {

    /**
     * 加密
     * @param text 明文
     * @param password 密码
     */
    fun encrypt(text: String, password: String): String {
        val cipher = Cipher.getInstance("DES")
        val kf = SecretKeyFactory.getInstance("DES")
        val keySpe = DESKeySpec(password.toByteArray())
        val key: Key = kf.generateSecret(keySpe)
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val encrypt = cipher.doFinal(text.toByteArray())
        return Base64.getEncoder().encodeToString(encrypt)
    }

    /**
     * 解密
     * @param cipherText 密文
     * @param password 密码
     */
    fun decrypt(cipherText: String, password: String): String {
        val cipher = Cipher.getInstance("DES")
        val kf = SecretKeyFactory.getInstance("DES")
        val keySpe = DESKeySpec(password.toByteArray())
        val key: Key = kf.generateSecret(keySpe)
        cipher.init(Cipher.DECRYPT_MODE, key)
        val encrypt = cipher.doFinal(Base64.getDecoder().decode(cipherText))
        return String(encrypt)
    }
}
