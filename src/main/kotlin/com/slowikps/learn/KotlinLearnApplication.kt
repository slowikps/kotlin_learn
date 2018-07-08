package com.slowikps.learn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true /*CGLIB*/)
class KotlinLearnApplication

fun main(args: Array<String>) {
    System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager")
    System.setProperty("Log4jContextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector")
    runApplication<KotlinLearnApplication>(*args)
}
