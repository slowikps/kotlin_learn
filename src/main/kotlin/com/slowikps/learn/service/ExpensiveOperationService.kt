package com.slowikps.learn.service

import io.micrometer.core.annotation.Timed
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit


//@Timed - TimedAspect only intercepts method calls and ignores declaration on a type
@Service
class ExpensiveOperationService {


    @Timed("ExpensiveOperationService1")//If no value (name) then it is ignored by metrics Aspect!!
    fun expensiveOperation(){
        println("Start of expensive operation")
        TimeUnit.MILLISECONDS.sleep(100)
        println("End of expensive operation")
    }

    @Timed("ExpensiveOperationService2")//If no value (name) then it is ignored by metrics Aspect!!
    fun veryExpensiveOperation(){
        println("Start of expensive operation")
        TimeUnit.MILLISECONDS.sleep(500)
        println("End of expensive operation")
    }
}