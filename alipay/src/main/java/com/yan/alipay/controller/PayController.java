package com.yan.alipay.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.yan.alipay.component.AliPayComponent;
import com.yan.alipay.entity.Commodity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.LongBinaryOperator;

/**
 * @author 闫天宇
 * @date 2020/5/1 9:46
 */
@Slf4j
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    AliPayComponent aliPayComponent;


    @GetMapping("/index")
    public String payPage(){
        log.debug("前往支付页面。。。");
        return "index";
    }

    /**
     * 扫码支付页面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/zfb")
    public String zfbPay(){
        log.debug("扫码支付页面。。。");
        //随机生成订单号
        String orderNum = UUID.randomUUID().toString().replace("-", "");
        log.debug("当前订单号是={}",orderNum);
        List<Commodity> list = new ArrayList<>();
        Commodity c1 = new Commodity();
        c1.setTitle("机器人");
        c1.setBody("顺丰发货");
        c1.setPrice(new BigDecimal("399.9"));

        String result = aliPayComponent.payOrder(orderNum, c1.getPrice().toString(), c1.getTitle(), c1.getBody());
        return result;
    }

    /**
     * 支付完成后要跳转的页面
     * @return
     */
    @ResponseBody
    @RequestMapping("/zfb/over")
    public String zfbReturn(HttpServletRequest request){
        //out_trade_no=016902b639644c208567ecc7e978b5b9&total_amount=399.90

        log.debug("支付完成后获取的参数： 订单号={}",request.getParameter("out_trade_no"));
        log.debug("支付完成后获取的参数： 支付金额={}",request.getParameter("total_amount"));

        return "支付成功！";
    }


}
