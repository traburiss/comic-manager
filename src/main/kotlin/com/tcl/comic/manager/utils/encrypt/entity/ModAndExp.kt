package com.tcl.comic.manager.utils.encrypt.entity

import com.tcl.comic.manager.utils.encrypt.utils.base.MessageDigestUtils
import java.io.Serializable
import java.math.BigInteger

/**
 * Created by traburiss on 2018/1/3.
 * rsa秘钥对应的模和指数实体类
 */
data class ModAndExp(val modulus: BigInteger = BigInteger("-1"),val exponent: BigInteger = BigInteger("-1")) : Serializable{

    override fun toString(): String {
        return "module is " + MessageDigestUtils.byte2Hex(modulus.toByteArray()) +
                " exponent is " + MessageDigestUtils.byte2Hex(exponent.toByteArray())
    }
}
