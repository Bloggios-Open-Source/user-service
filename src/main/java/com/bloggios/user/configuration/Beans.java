package com.bloggios.user.configuration;

import com.bloggios.user.constants.BeanNameConstants;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - user-service
 * Package - com.bloggios.user.configuration
 * Created_on - May 14 - 2024
 * Created_at - 12:49
 */

@Configuration
public class Beans {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(BeanNameConstants.ASYNC_TASK_INTERNAL_POOL)
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("user-internal-pool-");
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(60);
        executor.initialize();
        return executor;
    }

    @Bean(BeanNameConstants.ASYNC_TASK_EXTERNAL_POOL)
    public TaskExecutor externalExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(7);
        executor.setMaxPoolSize(16);
        executor.setQueueCapacity(40);
        executor.setThreadNamePrefix("user-external-pool-");
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(60);
        executor.initialize();
        return executor;
    }
}
