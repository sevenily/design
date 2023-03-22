package com.adapter.model.mqService;

import com.adapter.model.mq.OrderMq;
import com.alibaba.fastjson.JSON;

/**
 * 内部订单MQ处理
 */
public class OrderMqService {
    public void onMessage(String message){
        OrderMq mq = JSON.parseObject(message, OrderMq.class);
        mq.getOrderId();
        mq.getCreateOrderTime();
        //...处理自己的业务
    }
}
