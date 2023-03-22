package com.demo.factory.controller;

import com.demo.factory.award.AwardReq;
import com.demo.factory.store.ICommodity;
import com.demo.factory.store.StoreFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "奖品发放01工厂模式")
public class Prize01Controller {

    StoreFactory storeFactory = new StoreFactory();

    @PostMapping(value = "/awardToUser01")
    @ApiOperation(value = "奖品发放", notes = "奖品发放")
    public void awardToUser(@RequestBody AwardReq req){
        // 1.优惠券
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity(req.getUId(), req.getAwardNumber(), req.getBizId(), null);

        // 2.实物商品
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);
        commodityService_2.sendCommodity(req.getUId(), req.getAwardNumber(), req.getBizId(), req.getExtMap());

        //3. 第三方兑换卡（爱奇艺）
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);

        commodityService_3.sendCommodity(req.getUId(), req.getAwardNumber(), null, null);

    }
}
