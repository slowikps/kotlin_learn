package com.slowikps.learn.service

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import org.springframework.stereotype.Service

@Service
@DefaultProperties(threadPoolProperties = [
    HystrixProperty(name = "coreSize", value = "30"),
    HystrixProperty(name = "maxQueueSize", value = "101"),
    HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
    HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
    HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
    HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
])
class CircuitBreakerExample {

    @HystrixCommand(fallbackMethod = "fallback")
    fun doIt(input: String): String {

        return "didIt [input: $input]"
    }

    fun fallback(input: String): String {
        return "fallback [input: $input]"
    }
}