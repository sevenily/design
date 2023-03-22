package com.adapter.model.mqService;

import com.adapter.model.mq.POPOrderDelivered;
import com.alibaba.fastjson.JSON;

/**
 * 第三方订单mq处理
 */
public class POPOrderDeliveredService {
    public void onMessage(String message){
        POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);
        mq.getOrderId();
        mq.getDecimal();
        //... 处理自己的业务

    }

}
