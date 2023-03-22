package org.example.ifelse;

/**
 * @ClassName: CouponDiscountServiceByIfElse
 * @Description: 优惠券折扣计算接口
 * 优惠券类型：
 * 1. 直减券
 * 2. 满减券
 * 3. 折扣券
 * 4. n元购
 * @Author: seven
 * @CreateTime: 2023-03-22 09:37
 * @Version: 1.0
 **/

public class CouponDiscountServiceByIfElse {

    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        //1. 直减券
        if (1 == type) {
            return skuPrice - typeContent;
        }
        //2. 满减券
        if (2 == type) {
            if (skuPrice < typeExt) return skuPrice;
            return skuPrice - typeContent;
        }

        //3. 折扣券
        if (3 == type) {
            return skuPrice * typeContent;
        }

        //4. n元购
        if (4 == type) {
            return typeContent;
        }
        return 0D;
    }
}
