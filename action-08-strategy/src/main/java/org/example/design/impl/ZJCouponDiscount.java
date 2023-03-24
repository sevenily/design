package org.example.design.impl;

import org.example.design.ICouponDiscount;

import java.math.BigDecimal;


/**
 * @ClassName: ZJCouponDiscount
 * @Description: 直减计算
 * @Author: seven
 * @CreateTime: 2023-03-22 10:01
 * @Version: 1.0
 **/

public class ZJCouponDiscount implements ICouponDiscount<Double> {
    /**
     * 直减计算
     * 1. 使用商品加个减去优惠价格
     * 2. 最低知否金额1元
     * @param couponInfo    券折扣信息：直减、满减、折扣、N元购
     * @param skuPrice      sku金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if (discountAmount.compareTo(BigDecimal.ZERO)<1) return BigDecimal.ONE;

        return discountAmount;
    }
}
