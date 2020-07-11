package com.tcl.comic.manager.controller

import com.tcl.comic.manager.config.Constant.LOGIN_ID
import com.tcl.comic.manager.config.Constant.LOGIN_NAME
import com.tcl.comic.manager.config.Constant.ROLE_ID
import org.slf4j.LoggerFactory
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
 * Created by traburiss on 2020/5/24.
 * describe:
 */
@RestController
@RequestMapping("/api/test")
class TestController {

    val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/hw")
    fun test(model: Model): Mono<String> {
        return Mono.fromSupplier {
            logger.info("{}/{}/{}", model.getAttribute(LOGIN_NAME), model.getAttribute(LOGIN_ID), model.getAttribute(ROLE_ID))
            "hello world"
        }
    }
}
