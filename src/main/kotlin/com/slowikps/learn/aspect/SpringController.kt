package com.slowikps.learn.aspect

import org.apache.logging.log4j.LogManager
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component

@Aspect
@Component
class SpringController {

    private val log = LogManager.getLogger()


    //Didn't work when function annotated with GetMapping and pointcut for RequestMapping
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)||@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    fun controllerAnnotations(){}


    @Pointcut("within(com.slowikps.learn.controller..*)")
    fun inControllerPackage(){}

    @Before("inControllerPackage() && controllerAnnotations()")
    fun logBeforeRestCall(joinPoin: JoinPoint) {
        log.info("REST call $joinPoin")
        println("The end of aspect")
    }


    @Around("inControllerPackage() && controllerAnnotations()")
    fun timed(joinPoin: ProceedingJoinPoint): Any {
        val start = System.currentTimeMillis()
        val result = joinPoin.proceed()
        log.info("Method invocation took: ${System.currentTimeMillis() - start}, and returned: $result")
        return result
    }

    @Before("execution(* com.slowikps.learn.controller.*.sleep1(..))")
    fun selfInvocationCheck(joinPoin: JoinPoint) {
        println("intercepting sleep1 call")
    }
}