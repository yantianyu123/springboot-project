package com.yan.lock.zookeeper.controller;

import com.yan.lock.zookeeper.component.ZookeeperLockComponent;
import com.yan.lock.zookeeper.service.ZkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 闫天宇
 * @date 2020/5/8 18:59
 */
@Controller
@RequestMapping("/zk")
public class ZkController {

    @Autowired
    ZkService zkService;

    @GetMapping("/noLock")
    @ResponseBody
    public String test1(){

        try {
            zkService.saveNum();
            return "保存成功！";
        } catch (Exception e) {
            return "保存失败！";
        }
    }

    @GetMapping("/Lock")
    @ResponseBody
    public String test2(){

        try {
            zkService.saveNumLock();
            return "保存成功！";
        } catch (Exception e) {
            e.printStackTrace();
            return "保存失败！";
        }
    }

}
