package com.yan.lock.redisson.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 闫天宇
 * @date 2020/5/8 20:09
 */
@Service
public class RedissonService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedissonClient redissonClient;

    public void saveNumLock(){
        RLock lock = redissonClient.getLock("lock");
        //上锁
        lock.lock(10, TimeUnit.SECONDS);

        String orderNum = redisTemplate.opsForValue().get("orderNum");
        Integer integer = Integer.valueOf(orderNum);
        integer += 1;
        redisTemplate.opsForValue().set("orderNum",integer.toString());

        lock.unlock();
    }


}
