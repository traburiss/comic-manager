package com.tcl.comic.manager.utils.encrypt.entity

import java.io.Serializable
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

/**
 * rsa秘钥，包含公私钥
 * Created by traburiss on 2018/1/3.
 */
data class RsaKey(val publicKey: RSAPublicKey ,val privateKey: RSAPrivateKey) : Serializable
