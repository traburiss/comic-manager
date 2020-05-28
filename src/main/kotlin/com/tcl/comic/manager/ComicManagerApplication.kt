package com.tcl.comic.manager

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.tcl.comic.manager.mapper")
@OpenAPIDefinition(info = Info(title = "comic-manager", version = "1.0", description = "漫画管理工具"))
class ComicManagerApplication
fun main(args: Array<String>) {
    runApplication<ComicManagerApplication>(*args)
}
