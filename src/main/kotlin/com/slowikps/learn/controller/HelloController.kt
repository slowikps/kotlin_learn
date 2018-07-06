package com.slowikps.learn.controller

import io.micrometer.core.annotation.Timed
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
class HelloController {

    private val logger = LogManager.getLogger()

    @Autowired
    lateinit var self: HelloController

    @RequestMapping("/")
    @Timed
    fun index(): String {
        logger.info("Index: Before sleep1")
        self.sleep1(100)
        logger.info("Index: Before sleep2")
        self.sleep2(200)
        return "Greetings from Spring Boot!"
    }

    fun sleep1(howLong: Long) {
        TimeUnit.MILLISECONDS.sleep(howLong)
        logger.info("Slep1: Before sleep2")
        self.sleep2(300)
    }

    fun sleep2(howLong: Long) {
        TimeUnit.MILLISECONDS.sleep(howLong)
    }

}