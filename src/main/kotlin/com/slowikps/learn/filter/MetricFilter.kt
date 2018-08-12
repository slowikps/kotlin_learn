package com.slowikps.learn.filter

import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Component
import javax.servlet.*
import javax.servlet.http.HttpServletResponse

@Component
class MetricFilter: Filter {
    val log = LogManager.getLogger()

    override fun init(filterConfig: FilterConfig?) {
        println("Filter config: $filterConfig")
    }

    override fun destroy() {

    }

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        log.info("Before doFilter")
        val startTime = System.currentTimeMillis()
        chain?.doFilter(request, response)
        if(response is HttpServletResponse)
            log.info("After doFilter [response: ${response.status}, took: ${System.currentTimeMillis() - startTime}]")
    }
}