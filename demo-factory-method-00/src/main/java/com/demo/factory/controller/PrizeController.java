package com.demo.factory.controller;

import com.alibaba.fastjson.JSON;
import com.demo.factory.award.AwardReq;
import com.demo.factory.award.AwardRes;
import com.demo.factory.card.IQiYiCardService;
import com.demo.factory.coupon.CouponResult;
import com.demo.factory.coupon.CouponService;
import com.demo.factory.goods.DeliverReq;
import com.demo.factory.goods.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "奖品发放")
public class PrizeController {

    private final Logger logger =  LoggerFactory.getLogger(PrizeController.class);

    @RequestMapping(value = "awardToUser", method = RequestMethod.POST)
    @ApiOperation(value = "奖品发放", notes = "奖品发放")
    public AwardRes awardToUser(@RequestBody AwardReq req){
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            logger.info("奖品发放开始{}。req:{}", req.getUId(), reqJson);
            //按照不同类型方法商品[1优惠券，2实物商品，3第三方兑换卡（爱奇艺）]
            if (1 == req.getAwardType()){
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getUId(),
                        req.getAwardNumber(),
                        req.getBizId());
                if ("0000".equals(couponResult.getCode())){
                    awardRes = new AwardRes("0000", "发放成功");
                }else {
                    awardRes = new AwardRes("0001", couponResult.getInfo());
                }
            }else if (2 == req.getAwardType()){
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getUId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));

                Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                if (isSuccess) {
                    awardRes = new AwardRes("0000", "发放成功");
                } else {
                    awardRes = new AwardRes("0001", "发放失败");
                }
            } else if (3 == req.getAwardType()){
                String bindMobileNumber = queryUserPhoneNumber(req.getUId());

                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());

                awardRes = new AwardRes("0000", "发放成功");

            }
            logger.info("奖品发放完成{}", req.getUId());
        } catch (Exception e) {
            logger.error("奖品发放失败{}。 req:{}", req.getUId(), reqJson);
            awardRes = new AwardRes("0001", "发放失败");
        }

        return awardRes;
    }


    private String queryUserName(String uId){
        return "花花";
    }

    private String queryUserPhoneNumber(String uId){
        return "15200001111";
    }
}
