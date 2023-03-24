package org.structure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: Test
 * @Description: 代理测试类
 * @Author: seven
 * @CreateTime: 2023-03-24 11:09
 * @Version: 1.0
 **/


public class TestApplication {
    private Logger logger = LoggerFactory.getLogger(TestApplication.class);
    @Test
    public void test_IUserDao(){
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("10001");
        logger.info("测试结果：{}",res);
        System.out.println("测试结果：{}"+res);
    }



}
