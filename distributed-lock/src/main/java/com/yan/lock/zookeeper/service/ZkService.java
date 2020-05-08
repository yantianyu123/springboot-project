package com.yan.lock.zookeeper.service;

import com.yan.lock.zookeeper.component.ZookeeperLockComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author 闫天宇
 * @date 2020/5/8 17:39
 */
@Service
public class ZkService {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    ZookeeperLockComponent zkComponent;


    //没有使用锁
    public void saveNum(){

        String orderNum = redisTemplate.opsForValue().get("orderNum");
        Integer integer = Integer.valueOf(orderNum);
        integer += 1;

        redisTemplate.opsForValue().set("orderNum",integer.toString());

    }

    public void saveNumLock(){
        zkComponent.zkLock();

        String orderNum = redisTemplate.opsForValue().get("orderNum");
        Integer integer = Integer.valueOf(orderNum);
        integer += 1;
        redisTemplate.opsForValue().set("orderNum",integer.toString());

        zkComponent.zkUnLock();
    }

}
