package org.design.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayFaceMode implements IPayMode{

    protected Logger logger = LoggerFactory.getLogger(PayFaceMode.class);

    @Override
    public boolean security(String uId) {
        logger.info("人脸支付， 风控校验人脸识别。。");
        return true;
    }
}
