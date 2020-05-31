package com.tcl.comic.manager.config.web

import com.tcl.comic.manager.config.Constant.COOKIES_TOKEN
import com.tcl.comic.manager.config.Constant.CSS
import com.tcl.comic.manager.config.Constant.FAVICON
import com.tcl.comic.manager.config.Constant.FONTS
import com.tcl.comic.manager.config.Constant.INDEX_PAGE
import com.tcl.comic.manager.config.Constant.JS
import com.tcl.comic.manager.config.Constant.LOGIN_API
import com.tcl.comic.manager.config.Constant.LOGIN_PAGE
import com.tcl.comic.manager.service.LoginService
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono
import java.net.URI


/**
 * Created by traburiss on 2020/5/24.
 * describe:
 */
@Component
class ComicManagerFilter : WebFilter {

    val logger: Logger = LoggerFactory.getLogger("FrontendFilter")

    @Autowired
    lateinit var loginService: LoginService

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val path = exchange.request.uri.path
        if (need2login(exchange, chain)) {
            return gotoLogin(exchange, chain)
        }
        return when {
            StringUtils.startsWith(path, "/api") -> {
                logger.info("api -> {}", path)
                chain.filter(exchange)
            }
            StringUtils.contains(path, "swagger") || StringUtils.contains(path, "api-docs") -> {
                logger.info("swagger -> {}", path)
                chain.filter(exchange)
            }
            path.matches(Regex("[^\\\\.]*")) -> {
                logger.info("front -> {}", path)
                chain.filter(exchange.mutate().request(exchange.request.mutate().path(INDEX_PAGE).build()).build())
            }
            else -> {
                logger.info("else -> {}", path)
                chain.filter(exchange)
            }
        }
    }

    fun need2login(exchange: ServerWebExchange, chain: WebFilterChain): Boolean {
        val cookies = exchange.request.cookies[COOKIES_TOKEN]
        val path = exchange.request.uri.path
        return when {
            StringUtils.startsWith(path, FAVICON) -> false
            StringUtils.startsWith(path, LOGIN_API) -> false
            StringUtils.startsWith(path, LOGIN_PAGE) -> false
            StringUtils.startsWith(path, CSS) -> false
            StringUtils.startsWith(path, JS) -> false
            StringUtils.startsWith(path, FONTS) -> false
            cookies == null -> true
            else -> {
                val token = cookies[0].value
                !loginService.tokenCheck(token)
            }
        }
    }

    fun gotoLogin(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val url = exchange.request.uri
        val path = exchange.request.uri.path
        val mutatedUri = URI(url.scheme, url.userInfo, url.host, url.port, LOGIN_PAGE, url.query, url.fragment)
        val response = exchange.response
        response.statusCode = HttpStatus.MOVED_PERMANENTLY
        response.headers.location = mutatedUri
        logger.info("login -> {}", path)
        return Mono.empty()
    }
}
