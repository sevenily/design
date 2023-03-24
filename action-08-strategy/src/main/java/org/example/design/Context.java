package org.example.design;

import org.example.design.impl.NYGCouponDiscount;

import java.math.BigDecimal;

/**
 * @ClassName: Context
 * @Description: 策略控制类
 * 外部可传递不同的策略实现，在统一方法执行优惠策略计算，
 * 也可包装成map结构，外部只需对应的泛型类型即可使用相应的服务。
 * @Author: seven
 * @CreateTime: 2023-03-22 10:10
 * @Version: 1.0
 **/

public class Context<T> {
    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice){
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

    public static void main(String[] args) {
        //n元购
        Context<Double> context = new Context<>(new NYGCouponDiscount());
        BigDecimal bigDecimal = context.discountAmount(90D, new BigDecimal(100));
        System.out.println(String.format("测试结果：n元购优惠后金额：%s", bigDecimal));
    }
}
