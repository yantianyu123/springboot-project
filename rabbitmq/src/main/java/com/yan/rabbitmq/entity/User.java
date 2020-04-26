package com.yan.rabbitmq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 * @date 2020/4/26 20:27
 */
@Data
public class User implements Serializable {
    
    private static final long serialVersionUID = 5023248361323245647L;
    
    private String name;
    private String phone;
}
