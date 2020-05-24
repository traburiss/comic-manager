package com.tcl.comic.manager.config

import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

/**
 * Created by traburiss on 2020/5/24.
 * describe:
 */
@Component
class FrontendFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val path = exchange.request.uri.path
        return if (!path.startsWith("/api") && path.matches(Regex("[^\\\\.]*"))) {
            chain.filter(exchange.mutate().request(exchange.request.mutate().path("/index.html").build()).build())
        } else chain.filter(exchange)
    }
}
