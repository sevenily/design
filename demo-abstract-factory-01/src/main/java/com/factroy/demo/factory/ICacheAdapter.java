package com.factroy.demo.factory;

import java.util.concurrent.TimeUnit;

/**
 * 让所有集群的提供方，可以在统一的方法名称下进行操作，方便后续的扩展
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
