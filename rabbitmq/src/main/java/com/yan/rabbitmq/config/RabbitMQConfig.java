package com.yan.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @date 2020/4/25 22:57
 */
@Configuration
public class RabbitMQConfig  {

    /**
     * 把消息队列中的数据转成json
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    /**
     * 创建交换机
     * @return
     */
    @Bean
    public Exchange testExchange(){
        return new DirectExchange("testExchange",true,false);
    }

    /**
     * 创建队列
     * @return
     */
    @Bean
    public Queue testQueue(){
        return new Queue("testQueue",true,false,false);
    }

    /**
     * 交换机绑定队列
     * @return
     */
    @Bean
    public Binding testBinging(){
        return new Binding("testQueue", Binding.DestinationType.QUEUE,"testExchange","test",null);
    }
}
