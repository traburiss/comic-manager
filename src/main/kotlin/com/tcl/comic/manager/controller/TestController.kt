package com.tcl.comic.manager.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by traburiss on 2020/5/24.
 * describe:
 */
@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping("/test")
    fun test():String{
        return "hello world"
    }
}
