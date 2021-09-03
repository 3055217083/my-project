package com.song.springboot.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author : zhixian.song
 * @description : 日志切面
 * @time : 2021.9.2 14:31
 */
@Aspect
@Component
@Order
@Slf4j
public class MyLogAspect {
    /**
     * 切点
     * @params :
     * @returns :
     */
    @Pointcut("@annotation(com.song.springboot.annotation.MyLog)")
    public void myAspect() {
    }

    /**
     * 前置方法,在目标方法执行前执行
     * @params :
     * @returns :
     */
    @Before("myAspect()")
    public void before(JoinPoint joinPoint) throws Exception {
        // 类名
        String targetName = joinPoint.getTarget().getClass().getSimpleName();
        // 得到方法名
        String methodName = joinPoint.getSignature().getName();
        // 方法签名
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        // 入参key
        String[] parameterNames = ms.getParameterNames();
        // 入参value
        Object[] arguments = joinPoint.getArgs();
        Method method = ms.getMethod();
        System.out.println("before");
    }

    /**
     * 环绕
     * @params :
     * @returns :
     */
    @Around("myAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        try {
            log.info("around前");
            obj = joinPoint.proceed();
            log.info("around后");
        } catch (Throwable e) {
            log.info("aop,Around,异常");
        }
        return obj;
    }

    /**
     * 后置方法,在目标方法执行后执行
     * @params :
     * @returns :
     */
    @After(value = "myAspect()")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        System.out.println("doAfter");
    }

    /**
     * 处理完请求，返回内容
     * @params :
     * @returns :
     */
    @AfterReturning(pointcut = "myAspect()", returning = "returnValue")
    public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("doAfterReturning:返回值/ "+returnValue);
    }

    /**
     * 异常
     * @params :
     * @returns :
     */
    @AfterThrowing(value = "myAspect()", throwing = "e")
    public void doAfterException(JoinPoint joinPoint, Exception e) {
        System.out.println("出现错误");
        e.printStackTrace();
    }

}
