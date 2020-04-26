package com.yan.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqApplicationTests {
    
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     */
    @Test
    void contextLoads() {
        
        rabbitTemplate.convertAndSend("","","");
    }

    /**
     * 监听队列
     */
    @RabbitListener(queues = {"队列名称"})
    public void tese1(){
        
    }

}
