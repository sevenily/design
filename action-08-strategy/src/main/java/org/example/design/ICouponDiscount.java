package org.example.design;

import java.math.BigDecimal;

/**
 * @ClassName: ICouponDiscount
 * @Description: 优惠券金额计算
 * @Author: seven
 * @CreateTime: 2023-03-22 09:45
 * @Version: 1.0
 **/

public interface ICouponDiscount<T> {
    /**
     * 优惠券金额计算
     * @param couponInfo    券折扣信息：直减、满减、折扣、N元购
     * @param skuPrice      sku金额
     * @return  优惠券金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);
}
