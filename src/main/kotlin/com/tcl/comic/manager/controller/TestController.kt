package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant.LOGIN_ID
import com.tcl.comic.manager.config.Constant.LOGIN_NAME
import org.slf4j.LoggerFactory
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

/**
 * Created by traburiss on 2020/5/24.
 * describe:
 */
@RestController
@RequestMapping("/api/test")
class TestController {

    val logger = LoggerFactory.getLogger(this.javaClass)
    
    @GetMapping("/hw")
    fun test(model: Model):String{
        logger.info("{}/{}", model.getAttribute(LOGIN_NAME), model.getAttribute(LOGIN_ID))
        return "hello world"
    }
}
