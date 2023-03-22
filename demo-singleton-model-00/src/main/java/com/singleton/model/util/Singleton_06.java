package com.singleton.model.util;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS【AtomicReference】（线程安全）
 * 原子类：AtomicInteger、AtomicBoolean、AtomicLong、AtomicReference
 * 优点：相对于其他锁的实现没有线程的切换和阻塞也就没有额外的开销，可以支持较大的并发性
 * 缺点：忙等
 *
 */
public class Singleton_06 {
    private static final AtomicReference<Singleton_06> INSTANCE =
            new AtomicReference<>();

    private static Singleton_06 instance;
    private Singleton_06(){
    }

    public static final Singleton_06 getInstance(){
        for (;;){
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) return instance;
            INSTANCE.compareAndSet(null, new Singleton_06());
            return INSTANCE.get();
        }
    }

    public static void main(String[] args) {
        //com.singleton.model.util.Singleton_06@27973e9b
        System.out.println(Singleton_06.getInstance());
        //com.singleton.model.util.Singleton_06@27973e9b
        System.out.println(Singleton_06.getInstance());
    }

}
