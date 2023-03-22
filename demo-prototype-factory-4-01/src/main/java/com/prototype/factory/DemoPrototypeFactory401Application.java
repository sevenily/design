package com.prototype.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 原型模式主要解决：创建大量重复的类，而我们模拟的场景就需要给不同的用户创建相同的试卷，
 *但这些试卷的题目不便于每次都从库中获取，甚至有时候需要从远程的RPC中获取，
 *非常耗时，且随着创建对象的增多将严重影响效率。
 *
 * 使用手段：克隆 在需要用到克隆的类中都需要实现 Cloneable接口
 *
 */
@SpringBootApplication
public class DemoPrototypeFactory401Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoPrototypeFactory401Application.class, args);
    }

}
