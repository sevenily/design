package com.demo.factory.store;

import java.util.Map;

public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId,
                       Map<String, String> extMap);
}
