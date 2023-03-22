package com.demo.factory.store;

import com.demo.factory.store.impl.CardCommdityService;
import com.demo.factory.store.impl.CouponCommodityService;
import com.demo.factory.store.impl.GoodsCommodityService;

/**
 * 创建商店工厂
 */
public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType){
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommdityService();
        throw new RuntimeException("不存在的商品服务类型");
    }


}
