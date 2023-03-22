package com.factory.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 1.模拟Redis，也就是假定目前所有的系统都在使用的服务
 */
@Slf4j
public class RedisUtils {

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key){
        log.info("Redis获取数据key：{}", key);
        return dataMap.get(key);
    }


    public void set(String key, String value){
        log.info("Redis 写入数据key：{}, value：{}", key, value);
        dataMap.put(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit){
        log.info("Redis 写入数据key：{}, value：{}, timeout：{}, timeunit：{}",
                key, value, timeout, timeUnit.toString());

        dataMap.put(key, value);
    }


    public void del(String key){
        log.info("Redis删除数据 key：{}", key);
        dataMap.remove(key);
    }
}
