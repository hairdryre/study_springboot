package com.zhoutianyu.learnspringboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

import static com.zhoutianyu.learnspringboot.aop.WebUtils.getRequest;

/**
 * @author zhoutianyu
 * @date 2020/7/3
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Before(value = "pointCutName()")
    public void operation(JoinPoint joinPoint) {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return;
        }
        LOGGER.info("进入前置通知");
        //被代理的对象
        Object target = joinPoint.getTarget();
        //方法的签名
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //被代理的对象的方法反射
        final Method methodTarget = methodSignature.getMethod();
        //方法上的注解
        LogHandler logHandler = methodTarget.getAnnotation(LogHandler.class);

        LOGGER.error("被代理对象的包名:{}", target.getClass().getName());
        LOGGER.error("被代理对象的方法名:{}", methodTarget.getName());
        LOGGER.error("被代理对象的方法参数:{}", Arrays.toString(joinPoint.getArgs()));
        LOGGER.error("本次请求URL:{}", request.getRequestURL());
        LOGGER.error("本次请求者IP来自:{}", getIpAddress(request));
        LOGGER.error("本次操作：{}", logHandler.methodType());
    }

    @Pointcut(value = "@annotation(com.zhoutianyu.learnspringboot.aop.LogHandler)")
    public void pointCutName() {
        // do nothing
    }

    /**
     * 获得客户端IP
     *
     * @param request request
     * @return 客户端IP
     */
    private String getIpAddress(HttpServletRequest request) {
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
