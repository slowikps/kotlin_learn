package com.slowikps.learn.interceptor

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.ThreadContext
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class LoggerInterceptor : HandlerInterceptorAdapter() {

    val log = LogManager.getLogger()

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any): Boolean {
        val header: String = request.getHeader("X-Flow-Id") ?: UUID.randomUUID().toString()
        ThreadContext.put("flowId", header)
        ThreadContext.put("startTime", "${System.currentTimeMillis()}")
        return true
    }

//    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any, model: ModelAndView?) {
//        log.info("3. from PostHandle method.")
//    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any, e: Exception?) {
        log.info("Request took: {} millis",
                ThreadContext.get("startTime")?.toLongOrNull()?.let { System.currentTimeMillis() - it } ?: "UNKNOWN")
        ThreadContext.clearAll()
    }
}