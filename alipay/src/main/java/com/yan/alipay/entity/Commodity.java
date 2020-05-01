package com.yan.alipay.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 闫天宇
 * @date 2020/5/1 10:24
 * 商品类
 */
@Data
public class Commodity implements Serializable {

    private static final long serialVersionUID = -5601081120574527569L;

    //商品标题
    private String title;
    //商品备注
    private String body;
    //价格
    private BigDecimal price;

}
