package org.design.bridge;

import org.design.channel.Pay;
import org.design.channel.WxPay;
import org.design.channel.ZfbPay;
import org.design.mode.PayFaceMode;
import org.design.mode.PayFingerprintMode;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class Test {

    @org.junit.Test
    public void testPay(){
        System.out.println("模拟测试场景；微信支付、人脸方式");
        Pay wxPay = new WxPay(new PayFaceMode());
        wxPay.transfer("weixin2133", "234124", new BigDecimal(3213));

        System.out.println("模拟支付场景；支付宝支付、指纹方式");
        Pay zfbPay = new ZfbPay(new PayFingerprintMode());
        zfbPay.transfer("zfb12313", "32241", new BigDecimal(134));
    }
}
