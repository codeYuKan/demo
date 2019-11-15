package com.yukan.demo.basic.dynamicproxy.demo1;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yukan
 * @date 2019/11/13
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ProxySaler implements InvocationHandler {

    private Object targetObject;

    /**
     * InvocationHandler可以是一个FunctionInterface
     * 可以通过lambda表达式来写
     */
    Object proxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        /*
         根据提供的接口和代理处理器 创建代理对象 代理targetObject
         代理对象的每个执行方法都会被替换执行代理处理器的invoke方法
         */
        /*
        为什么要传classloader和interfaces？
        JDK的动态代理只能代理接口，代理后的对象并不属于任何一个现有的接口的实现。它是基于interfaces和classloader加载出来的。
         */
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("before invoke");
        //if("buy".equals(method.getName())) {
        //    person.buy();
        //} else if ("buy1".equals(method.getName())) {
        //    person.buy1();
        //}
        method.invoke(targetObject, args);
        log.info("after invoke");
        return null;
    }
}