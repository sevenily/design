package com.singleton.model.util;

/**
 * 推荐
 * 使用类的内部类（线程安全）
 * 既保证线程安全又保证了懒加载（
 * JVM虚拟机可以保证多线程并发访问的正确性，
 * 一个类的构造方法在多线程环境下可以被正确的加载）
 */
public class Singleton_04 {

    private static class SingletonHolder{
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04(){}

    public static Singleton_04 getInstance(){
        return SingletonHolder.instance;
    }
}
