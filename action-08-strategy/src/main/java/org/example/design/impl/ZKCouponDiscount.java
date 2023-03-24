package org.example.design.impl;

import org.example.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * @ClassName: ZKCouponDiscount
 * @Description: 折扣计算
 * @Author: seven
 * @CreateTime: 2023-03-22 10:05
 * @Version: 1.0
 **/

public class ZKCouponDiscount implements ICouponDiscount<Double> {

    /**
     * 折扣计算
     * 1. 使用商品加个乘以折扣比例， 为最后支付金额
     * 2. 保留2位小数
     * 3. 最低支付金额1元
     *
     * @param couponInfo 券折扣信息：直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal((couponInfo))).setScale(2, BigDecimal.ROUND_HALF_UP);
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;
        return discountAmount;
    }
}
