package org.structure.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * @ClassName: MapperFactoryBean
 * @Description:  代理类定义，
 * @Author: seven
 * @CreateTime: 2023-03-24 10:21
 * @Version: 1.0
 **/

public class MapperFactoryBean<T> implements FactoryBean {
    private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);

    private Class<T> mapperInterface;

    /**
     *  透传代理类
     * @param mapperInterface
     */
    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 提供bean对象
     * @return  提供类的代理
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        InvocationHandler handler = (proxy, method, args) ->{
            Select select = method.getAnnotation(Select.class);
            //模拟sql语句处理
            logger.info("SQL: {}", select.value().replace("#{uId}", args[0].toString()));
            System.out.println("SQL: {}"+ select.value().replace("#{uId}", args[0].toString()));
            return args[0] + "     MapperFactoryBean<T> ------  InvocationHandler";
        };

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{mapperInterface}, handler);
    }

    /**
     * 提供对象类型反馈
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    /**
     * 返回类是单例的
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
