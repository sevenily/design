package com.example.demodesiginbridge701;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class DemoDesiginBridge701ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testBridge(){
        PayController pay = new PayController();
        System.out.printf("模拟测试场景：微信支付、人脸方式。。");
        pay.doPay("wenxin_123", "132323", new BigDecimal(100),1,2);

        System.out.println("模拟测试场景：支付宝支付、指纹方式。。");
        pay.doPay("zhifubao123", "31414", new BigDecimal(300), 2, 3);

    }
}
