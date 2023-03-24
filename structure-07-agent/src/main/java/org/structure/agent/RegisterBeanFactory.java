package org.structure.agent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.structure.IUserDao;

/**
 * @ClassName: RegisterBeanFactory
 * @Description: 将Bean 定义注册到Spring容器中，交由spring容器管理 可以方便获取到代理bean
 *
 * @Author: seven
 * @CreateTime: 2023-03-24 10:21
 * @Version: 1.0
 **/

public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //1. 定义bean的基本信息
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(MapperFactoryBean.class);
        beanDefinition.setScope("singleton");

        // 可以透传给构造函数信息
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(IUserDao.class);

        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userDao");

        //进行bean注册， 注册至DefaultListableBeanFactory中
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder, registry);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // let intentionally blank

    }
}
