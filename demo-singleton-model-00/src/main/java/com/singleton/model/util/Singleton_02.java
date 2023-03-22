package com.singleton.model.util;

/**
 * 懒汉式（线程安全）
 * 锁加在方法上，所有的访问都因为需要锁，占用导致资源浪费。
 */
public class Singleton_02 {
    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance(){
        if (null != instance) return instance;
        instance = new Singleton_02();
        return instance;
    }
}
