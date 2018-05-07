package com.lany.blog;


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
import java.util.Arrays;
import java.util.Enumeration;

/**
 * 实现Web层的日志切面   拦截请求日志
 */
@Slf4j
@Aspect
@Component
public class WebLogAspect {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 定义一个切入点.
     * <p>
     * 解释下：
     * <p>
     * <p>
     * <p>
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * <p>
     * ~ 第二个 * 任意包名
     * <p>
     * ~ 第三个 * 代表任意方法.
     * <p>
     * ~ 第四个 * 定义在web包或者子包
     * <p>
     * ~ 第五个 * 任意方法
     * <p>
     * ~ .. 匹配任意数量的参数.
     */

    @Pointcut("execution(public * com.lany.*.controller..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        log.info("开始请求：");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            log.info("HTTP_HEADERS name:" + name + " value: " + value);
        }
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            System.out.println(paraName + ": " + request.getParameter(paraName));
        }
    }

    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint point) {
        // 处理完请求，返回内容
        log.info("请求结果：" + point.toString());
        log.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
    }
}