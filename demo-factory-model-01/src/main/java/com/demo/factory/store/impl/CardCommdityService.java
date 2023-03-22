package com.demo.factory.store.impl;

import com.alibaba.fastjson.JSON;
import com.demo.factory.award.AwardRes;
import com.demo.factory.card.IQiYiCardService;
import com.demo.factory.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CardCommdityService implements ICommodity {
    private static Logger logger = LoggerFactory.getLogger(CardCommdityService.class);
    private IQiYiCardService iQiYiCardService = new IQiYiCardService();
    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        String bindMobileNumber = queryUserPhoneNumber(uId);
        iQiYiCardService.grantToken(bindMobileNumber, bizId);

        logger.info("请求参数[爱奇艺卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[爱奇艺卡]：success");
    }


    private String queryUserPhoneNumber(String uId){
        return "15200001111";
    }
}
