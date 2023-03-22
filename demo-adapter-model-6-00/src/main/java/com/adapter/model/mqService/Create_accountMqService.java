package com.adapter.model.mqService;

import com.adapter.model.mq.create_account;
import com.alibaba.fastjson.JSON;

/**
 * 注册开户mq处理
 */
public class Create_accountMqService {

    public void onMessage(String message){
        create_account mq = JSON.parseObject(message, create_account.class);

        mq.getNumber();
        mq.getAccountDate();

        //...处理自己的业务
    }


}
