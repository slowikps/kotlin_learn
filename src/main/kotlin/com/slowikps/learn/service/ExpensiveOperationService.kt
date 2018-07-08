package com.slowikps.learn.service

import io.micrometer.core.annotation.Timed
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class ExpensiveOperationService {

    @Timed("someName")//If no value (name) then it is ignored by metrics Aspect!!
    fun expensiveOperation(){
        println("Start of expensive operation")
        TimeUnit.MILLISECONDS.sleep(100)
        println("End of expensive operation")
    }
}