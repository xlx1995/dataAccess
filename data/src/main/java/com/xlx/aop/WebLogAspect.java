package com.xlx.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Auther: 徐林啸
 * @Date: 2019/7/30 00:15
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * com.xlx.controller.*.*.*.*(..))")
    public void webLog(){
    }
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint)throws Throwable{

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("URL:" + request.getRequestURI().toString());
        log.info("HTTP METHOD::" + request.getMethod());
        log.info("IP::" + request.getRemoteAddr());
        Enumeration<String> enumerAtion = request.getParameterNames();
        while(enumerAtion.hasMoreElements()){
            String name = enumerAtion.nextElement();
            log.info("name{},value{}",name,request.getParameterValues(name));
        }
    }
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doafter(Object ret) throws Throwable{
        log.info("response:" +ret);
    }

}
