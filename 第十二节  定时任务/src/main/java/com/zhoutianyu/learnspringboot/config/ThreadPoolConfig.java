package com.zhoutianyu.learnspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhoutianyu
 * @date 2020/7/1
 */
@Component
public class ThreadPoolConfig {

    @Bean(value = "threadPoolTaskExecutor")
    public Executor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //线程池维护线程的最少数量，即使没有任务需要执行，也会一直存活
        executor.setCorePoolSize(5);
        //线程池维护线程的最大数量
        executor.setMaxPoolSize(10);
        //允许的空闲时间，当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
        executor.setKeepAliveSeconds(60);
        //缓存队列（阻塞队列）当核心线程数达到最大时，新任务会放在队列中排队等待执行
        executor.setQueueCapacity(10);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("demo.tyzhou-");
        /**
         * 拒绝task的处理策略
         * CallerRunsPolicy使用此策略，如果添加到线程池失败，那么主线程会自己去执行该任务,不会等待线程池中的线程去执行
         * AbortPolicy丢掉这个任务并且抛出
         * DiscardPolicy线程池队列满了，会直接丢掉这个任务并且不会有任何异常
         * DiscardOldestPolicy队列满了，会将最早进入队列的任务删掉腾出空间，再尝试加入队列
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
