package com.singleton.model.util;

/**
 * Effective java 作者推荐的枚举单例（线程安全）
 * 解决:线程安全、自由串行化、单一实例
 * 缺点：在继承场景不可用。
 */
public enum Singleton_07 {
    INSTANCE;
    public void test(){
        System.out.println("hi-");
    }

    public static void main(String[] args) {
        Singleton_07.INSTANCE.test();
    }
}
