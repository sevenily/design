package com.singleton.model.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 静态类：在第一次运行的时候直接初始化Map类，同时这里不需要到延迟加载再使用
 * 使用场景：需要被集成以及需要维持一些特定状态的情况
 */
public class Singleton_00 {
    public static Map<String, String> cache = new ConcurrentHashMap<String, String>();
}
