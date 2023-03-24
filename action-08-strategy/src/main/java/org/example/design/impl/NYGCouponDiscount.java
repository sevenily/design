package org.example.design.impl;

import org.example.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @ClassName: NYGCouponDiscount
 * @Description: N元购购买
 * @Author: seven
 * @CreateTime: 2023-03-22 10:09
 * @Version: 1.0
 **/

public class NYGCouponDiscount implements ICouponDiscount<Double> {
    /**
     * n元购购买
     * 1. 无论原价多少钱都固定金额购买
     * @param couponInfo    券折扣信息：直减、满减、折扣、N元购
     * @param skuPrice      sku金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {

        return new BigDecimal(couponInfo);
    }
}
