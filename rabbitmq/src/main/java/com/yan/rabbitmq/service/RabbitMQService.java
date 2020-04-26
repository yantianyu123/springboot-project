package com.yan.rabbitmq.service;

import com.rabbitmq.client.Channel;
import com.yan.rabbitmq.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author
 * @date 2020/4/26 20:23
 */
@Service
public class RabbitMQService {

    @RabbitListener(queues = {"testQueue"})
    public void lister(Message message, User user, Channel channel) {

        System.out.println("接收到了信息：" + user);
        
        //回复成功消息
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        /*try {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        
        //int i = 1/0;

    }
}
