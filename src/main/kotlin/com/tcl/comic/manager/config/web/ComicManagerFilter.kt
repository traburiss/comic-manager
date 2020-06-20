package com.tcl.comic.manager.config.web

import com.alibaba.fastjson.JSON
import com.tcl.comic.manager.config.Constant.API
import com.tcl.comic.manager.config.Constant.API_DOC
import com.tcl.comic.manager.config.Constant.COOKIES_TOKEN
import com.tcl.comic.manager.config.Constant.CSS
import com.tcl.comic.manager.config.Constant.FAVICON
import com.tcl.comic.manager.config.Constant.FONTS
import com.tcl.comic.manager.config.Constant.FRONTEND
import com.tcl.comic.manager.config.Constant.INDEX_PAGE
import com.tcl.comic.manager.config.Constant.JS
import com.tcl.comic.manager.config.Constant.LOGIN_API
import com.tcl.comic.manager.config.Constant.LOGIN_PAGE
import com.tcl.comic.manager.config.Constant.SWAGGER
import com.tcl.comic.manager.entity.Response
import com.tcl.comic.manager.entity.ResponseCode
import com.tcl.comic.manager.service.LoginService
import org.apache.commons.lang3.StringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.netty.ByteBufFlux
import java.net.URI
import java.nio.charset.StandardCharsets
import java.util.*


/**
 * Created by traburiss on 2020/5/24.
 * describe:
 */
@Component
class ComicManagerFilter : WebFilter {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var loginService: LoginService

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val path = exchange.request.uri.path
        if (need2login(exchange, chain)) {
            return if (StringUtils.startsWith(path, API)){
                responseError(exchange, chain)
            }else{
                gotoLogin(exchange, chain)
            }
        }
        return when {
            StringUtils.startsWith(path, API) -> {
                logger.debug("api -> {}", path)
                chain.filter(exchange)
            }
            StringUtils.contains(path, SWAGGER) || StringUtils.contains(path, API_DOC) -> {
                logger.debug("swagger -> {}", path)
                chain.filter(exchange)
            }
            path.matches(Regex(FRONTEND)) -> {
                logger.debug("front -> {}", path)
                chain.filter(exchange.mutate().request(exchange.request.mutate().path(INDEX_PAGE).build()).build())
            }
            else -> {
                logger.debug("else -> {}", path)
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
        logger.debug("login -> {}", path)
        return response.setComplete()
    }
    
    fun responseError(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val path = exchange.request.uri.path
        val response = exchange.response
        response.statusCode = HttpStatus.UNAUTHORIZED
        response.headers.contentType = APPLICATION_JSON
        response.headers.acceptCharset = Collections.singletonList(StandardCharsets.UTF_8)
        val data = JSON.toJSONString(Response("请登陆", ResponseCode.USER_ERROR.code, ResponseCode.USER_ERROR.msg)).toByteArray(Charsets.UTF_8)
        logger.debug("login -> {}", path)
        return response.writeAndFlushWith(Flux.just(ByteBufFlux.just(response.bufferFactory().wrap(data))))
    }
}
