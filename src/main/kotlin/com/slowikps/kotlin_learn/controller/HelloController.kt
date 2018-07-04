package com.slowikps.kotlin_learn.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

@RestController
class HelloController {

    @Autowired
    lateinit var self: HelloController

    @RequestMapping("/")
    fun index(): String {
        self.sleep1(100)
        self.sleep2(200)
        return "Greetings from Spring Boot!"
    }

    fun sleep1(howLong: Long) {
        TimeUnit.MILLISECONDS.sleep(howLong)
        sleep2(300)
    }

    fun sleep2(howLong: Long) {
        TimeUnit.MILLISECONDS.sleep(howLong)
    }

}