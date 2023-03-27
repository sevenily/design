package design.door.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: DoDoor
 * @Description:    切面注解定义
 * @Author: seven
 * @CreateTime: 2023-03-24 16:41
 * @Version: 1.0
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoDoor {

    // 获取某个字段例如用户ID、returnJson :确定白名单拦截后返回的具体内容
    String key() default "";
    String returnJson() default "";

}
