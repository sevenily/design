package design.door;

import com.alibaba.fastjson.JSON;
import design.door.annotation.DoDoor;
import design.door.config.StarterService;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @ClassName: DOJoinPoint
 * @Description: 切面处理白名单
 * @Author: seven
 * @CreateTime: 2023-03-24 16:36
 * @Version: 1.0
 **/
@Aspect
@Component
public class DOJoinPoint {
    private Logger logger = LoggerFactory.getLogger(DOJoinPoint.class);

    @Autowired
    private StarterService starterService;

    //定义切面，采用注解路径，所有加入这个注解的方法都会被切面进行管理
    @Pointcut("@annotation(design.door.annotation.DoDoor)")
    public void aopPoint(){

    }

    /**
     * 切面核心逻辑，这一部分主要是判断当前访问的用户ID是否白名单用户，如果是则放行jp.proceed();
     * 否则返回自定义的拦截信息
     * @param jp
     * @return
     * @throws Throwable
     */
    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable{
        //获取内容
        Method method = getMethod(jp);
        DoDoor doDoor = method.getAnnotation(DoDoor.class);
        //获取字段值
        String keyValue = getFiledValue(doDoor.key(), jp.getArgs());

        logger.info("design door handler method: {}  value:{}", method.getName(), keyValue);

        if (null == keyValue || "".equals(keyValue)) return jp.proceed();

        //配置内容
        String[] split = starterService.split(",");
        for (String str : split) {
            if (keyValue.equals(str)){
                return jp.proceed();
            }
        }

        //拦截
        return returnObject(doDoor, method);

    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException{
        Signature sig = jp.getSignature();
        MethodSignature signature = (MethodSignature) sig;

        return getClass(jp).getMethod(signature.getName(), signature.getParameterTypes());
    }

    private Class<? extends Object> getClass(JoinPoint jp) throws NoSuchMethodException {
        return jp.getTarget().getClass();
    }

    /**
     *  返回拦截后的转换对象，也就是说当非白名单用户访问时则返回一些信息
     * @param doGate
     * @param method
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private Object returnObject(DoDoor doGate, Method method) throws InstantiationException, IllegalAccessException {
        Class<?> returnType = method.getReturnType();
        String returnJson = doGate.returnJson();
        if ("".equals(returnJson)){
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    /**
     *  获取指定key,即获取入参中的某个属性，如用户ID 通过ID进行拦截校验
     * @param filed
     * @param args
     * @return
     */
    private String getFiledValue(String filed, Object[] args){
        String filedValue = null;
        for (Object arg : args) {
            try {
                if (null == filedValue || "".equals(filedValue)){
                    filedValue = BeanUtils.getProperty(arg, filed);
                }
            }catch (Exception e){
                if (args.length == 1){
                    return args[0].toString();
                }
            }

        }
        return filedValue;
    }

}
