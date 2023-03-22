package org.design.channel;

import org.design.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class ZfbPay extends Pay{
    private Logger logger = LoggerFactory.getLogger(ZfbPay.class);

    public ZfbPay(IPayMode payMode) {
        super(payMode);
    }

    @Override
    public String transfer(String uId, String tradeId, BigDecimal amount) {
        logger.info("模拟⽀支付宝渠道⽀支付划账开始。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
        boolean security = payMode.security(uId);
        logger.info("模拟⽀支付宝渠道⽀支付⻛风控校验。uId：{} tradeId：{} security： {}", uId, tradeId, security);
        if (!security) {
            logger.info("模拟⽀支付宝渠道⽀支付划账拦截。uId：{} tradeId：{} amount：{}", uId, tradeId, amount);
            return "0001";
        }
        logger.info("模拟⽀支付宝渠道⽀支付划账成功。uId：{} tradeId：{} amount： {}", uId, tradeId, amount);
        return "0000";
    }
}
