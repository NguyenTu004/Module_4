package com.example.thuchanh1.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.example.thuchanh1.service.customer.CustomerService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
//        System.out.println("[CMS] co loi xay ra: " + e.getMessage());
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }
    public void error() {
        System.out.println("[CMS] ERROR!");
    }
}
