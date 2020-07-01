package com.zhoutianyu.learnspringboot.lock.single;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author zhoutianyu <tyzhou@wisedu.com>
 * @version 1.0.0
 * @date 2019/10/10 16:02
 */
@Aspect
@Configuration
public class LockMethodInterceptor {

    private static final Cache<String, Object> CACHES =
            CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(5, TimeUnit.SECONDS).build();

    @Around(value = "execution(public * *(..)) && @annotation(com.zhoutianyu.learnspringboot.lock.single.LocalLock)")
    public Object interceptor(ProceedingJoinPoint pjp) throws Exception {
        //get Method by aop
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        //generate a key by Method
        String key = generateKey(pjp, method);

        if (!StringUtils.isEmpty(key)) {
            if (CACHES.getIfPresent(key) != null) {
                //if key exist in caches
                throw new RuntimeException("重复提交");
            } else {
                //put key into caches when the first time
                CACHES.put(key, key);
            }
        }

        //normal business
        try {
            Object[] args = pjp.getArgs();
            return pjp.proceed(args);
        } catch (Throwable throwable) {
            throw new Exception("服务器内部错误");
        }
    }

    /**
     * generate a key by Method sign
     */
    private String generateKey(ProceedingJoinPoint pjp, Method method) {
        KeyGenerator keyGenerator = new SimpleKeyGenerator();
        LocalLock localLock = method.getAnnotation(LocalLock.class);
        return localLock.key() + keyGenerator.generate(pjp.getTarget(), method, pjp.getArgs());
    }
}
