package com.tcl.comic.manager.utils.encrypt.utils

import com.tcl.comic.manager.utils.encrypt.entity.ModAndExp
import com.tcl.comic.manager.utils.encrypt.entity.RsaKey
import java.io.ByteArrayOutputStream
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.security.spec.RSAPrivateKeySpec
import java.security.spec.RSAPublicKeySpec
import java.util.*
import javax.crypto.Cipher

/**
 * RSA加密工具
 * Created by traburiss on 2018/1/3.
 */
object RSAUtils {
    
    private const val TYPE = "RSA"
    private const val ENCRYPT_MAX_SIZE = 117 //加密：每次最大加密长度
    private const val DECRYPT_MAX_SIZE = 128 //解密：每次最大加密长度
    /**
     * 生成公钥和私钥
     *
     * @return RsaKey, 包含了公钥和私钥的东西
     */
    fun createKey(): RsaKey{
        val keyPairGen = KeyPairGenerator.getInstance(TYPE)
        keyPairGen.initialize(1024)
        val keyPair = keyPairGen.generateKeyPair()
        val publicKey = keyPair.public as RSAPublicKey
        val privateKey = keyPair.private as RSAPrivateKey
        return RsaKey(publicKey, privateKey)
    }

    /**
     * 获取公钥的模和指数
     *
     * @param publicKey 公钥
     * @return ModAndExp 返回模和指数
     */
    fun getPublicModAndExp(publicKey: RSAPublicKey): ModAndExp {
        val modulus = publicKey.modulus
        val exponent = publicKey.publicExponent
        return ModAndExp(modulus, exponent)
    }

    /**
     * 获取私钥的模和指数
     *
     * @param privateKey 私钥
     * @return ModAndExp 返回模和指数
     */
    fun getPrivateModAndExp(privateKey: RSAPrivateKey): ModAndExp {
        val modulus = privateKey.modulus
        val exponent = privateKey.privateExponent
        return ModAndExp(modulus, exponent)
    }

    /**
     * 使用模和指数生成RSA公钥
     *
     * @param modAndExp 模和指数
     * @return 公钥
     */
    fun getPublicKey(modAndExp: ModAndExp): RSAPublicKey {
        val keyFactory = KeyFactory.getInstance(TYPE)
        val keySpec = RSAPublicKeySpec(modAndExp.modulus, modAndExp.exponent)
        return keyFactory.generatePublic(keySpec) as RSAPublicKey
    }

    /**
     * 使用模和指数生成RSA私钥
     *
     * @param modAndExp 模和指数
     * @return 私钥
     */
    fun getPrivateKey(modAndExp: ModAndExp): RSAPrivateKey {
        val keyFactory = KeyFactory.getInstance(TYPE)
        val keySpec = RSAPrivateKeySpec(modAndExp.modulus, modAndExp.exponent)
        return keyFactory.generatePrivate(keySpec) as RSAPrivateKey
    }

    /**
     * 公钥加密
     *
     * @param data      需要加密的数据
     * @param publicKey 公钥
     * @return 返回加密后的文本
     */
    fun encrypt(data: String, publicKey: RSAPublicKey): String {
        val cipher = Cipher.getInstance(TYPE)
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        val byteArray = data.toByteArray()
        var temp: ByteArray
        var offset = 0
        val bos = ByteArrayOutputStream()
        while (byteArray.size - offset > 0) { //没加密完
            if (byteArray.size - offset >= ENCRYPT_MAX_SIZE) {
                temp = cipher.doFinal(byteArray, offset, ENCRYPT_MAX_SIZE)
                offset += ENCRYPT_MAX_SIZE
            } else {
                temp = cipher.doFinal(byteArray, offset, byteArray.size - offset)
                offset = byteArray.size
            }
            bos.write(temp)
        }
        bos.close()
        return Base64.getEncoder().encodeToString(bos.toByteArray())
    }

    /**
     * 私钥解密
     *
     * @param data       需要加密的数据
     * @param privateKey 私钥
     * @return 解密后的文本
     */
    fun decrypt(data: String, privateKey: RSAPrivateKey): String {
        val cipher = Cipher.getInstance(TYPE)
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        //3.分段解密
        var temp: ByteArray
        var offset = 0
        val bos = ByteArrayOutputStream()
        val byteArray = Base64.getDecoder().decode(data)
        while (byteArray.size - offset > 0) { //没加密完
            if (byteArray.size - offset >= DECRYPT_MAX_SIZE) {
                temp = cipher.doFinal(byteArray, offset, DECRYPT_MAX_SIZE)
                offset += DECRYPT_MAX_SIZE
            } else {
                temp = cipher.doFinal(byteArray, offset, byteArray.size - offset)
                offset = byteArray.size
            }
            bos.write(temp)
        }
        bos.close()
        return String(bos.toByteArray())
    }
}
