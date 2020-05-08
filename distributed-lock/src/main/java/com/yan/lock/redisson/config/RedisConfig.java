package com.yan.lock.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 闫天宇
 * @date 2020/5/8 20:07
 */
@Configuration
public class RedisConfig {


    /**
     * redisson分布式锁配置
     * @return
     */
    @Bean
    public RedissonClient redissonClient(){

        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        return Redisson.create(config);

    }

}
