package com.yan.alipay.config;

import com.yan.alipay.component.AliPayComponent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 闫天宇
 * @date 2020/4/30 21:56
 */
@Configuration
public class AliPayConfig {

    @Bean
    @ConfigurationProperties(prefix = "alipay")
    public AliPayComponent aliPayComponent(){
        return new AliPayComponent();
    }

}
