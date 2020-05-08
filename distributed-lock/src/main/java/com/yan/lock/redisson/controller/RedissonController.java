package com.yan.lock.redisson.controller;

import com.yan.lock.redisson.service.RedissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 闫天宇
 * @date 2020/5/8 20:11
 */
@RestController
@RequestMapping("/redisson")
public class RedissonController {

    @Autowired
    RedissonService redissonService;

    @ResponseBody
    @GetMapping("/lock")
    public String test1(){

        try {
            redissonService.saveNumLock();
            return "保存成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！";
        }

    }

}
