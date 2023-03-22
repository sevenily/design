package org.example.design.impl;

import org.example.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @ClassName: MJCouponDiscount
 * @Description: 满减
 * @Author: seven
 * @CreateTime: 2023-03-22 09:51
 * @Version: 1.0
 **/

public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {
    /**
     * 满减计算
     * 1. 判断满足x元后 -n 元， 否则不减
     * 2. 最低支付金额1元
     *
     * @param couponInfo 券折扣信息：直减、满减、折扣、N元购
     * @param skuPrice   sku金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String n = couponInfo.get("n");

        // 小于商品金额条件的，直接返回商品原价
        if (skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        //减去优惠券金额判断
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal((n)));
        if (discountAmount.compareTo(BigDecimal.ZERO) < 1) return BigDecimal.ONE;

        return discountAmount;
    }
}
