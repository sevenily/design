package org.design.channel;

import org.design.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class WxPay extends Pay{

    private Logger logger = LoggerFactory.getLogger(WxPay.class);

    public WxPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟微信支付划账开始。uId：{}, tradeId：{}，amount：{}", uId, tradeId, amount);

        boolean security = payMode.security(uId);
        logger.info("模拟微信渠道支付风控校验。uId:{}, tradeId:{}, security:{}", uId, tradeId, security);

        if (!security){
            logger.info("模拟微信渠道支付划账拦截。uId:{}, tradeId:{}, security:{}", uId, tradeId, security);
            return "0001";
        }
        logger.info("模拟微信渠道支付划账成功。uId:{}, tradeId:{}, security:{}", uId, tradeId, security);
        return "0000";
    }
}
