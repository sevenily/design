package org.structure.agent;

import java.lang.annotation.*;

/**
 * @ClassName: Select
 * @Description: 模拟mybatis-spring自定义注解，用于使用在方法层面
 * @Author: seven
 * @CreateTime: 2023-03-24 10:21
 * @Version: 1.0
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {

    //SQL语句
    String value() default "";
}
