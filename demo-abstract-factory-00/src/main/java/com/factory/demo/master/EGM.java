package com.factory.demo.master;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 模拟Redis集群
 */
@Slf4j
public class EGM {
    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key){
        log.info("BGM获取数据key：{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value){
        log.info("BGM 写入数据key：{}, value：{}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit){
        log.info("BGM 写入数据key：{}, value：{}, timeout：{}, timeunit：{}",
                key, value, timeout, timeUnit.toString());

        dataMap.put(key, value);
    }


    public void delete(String key){
        log.info("BGM删除数据 key：{}", key);
        dataMap.remove(key);
    }

}
