package com.factroy.demo.factory.impl;

import com.factroy.demo.factory.ICacheAdapter;
import com.factroy.demo.factory.MyClassLoaderUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(),
                MyClassLoaderUtils.getClazzByArgs(args)).invoke(cacheAdapter, args);
    }
}
