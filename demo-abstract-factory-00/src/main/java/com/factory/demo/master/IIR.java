package com.factory.demo.master;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 集群IIR
 */
@Slf4j
public class IIR {

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key){
        log.info("IIR获取数据key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value){
        log.info("IIR 写入数据key：{}, value：{}", key, value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit){
        log.info("IIR 写入数据key：{}, value：{}, timeout：{}, timeunit：{}",
                key, value, timeout, timeUnit.toString());

        dataMap.put(key, value);
    }


    public void del(String key){
        log.info("IIR删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
