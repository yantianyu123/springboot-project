package com.yan.rabbitmq.controller;

import com.yan.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author
 * @date 2020/4/26 20:22
 */
@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {
    
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    @PostMapping("/send")
    public String send(@RequestBody User user){
        //发送消息到队列
        rabbitTemplate.convertAndSend("testExchange","test",user);
        
        return "发送成功";
    }
    
}
