package com.yukan.demo.basic.proxy.cglib;

import com.yukan.demo.basic.model.Student;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.NoOp;

/**
 * @author yukan
 * @date 2021/5/12
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class EnhancerDemo {

    public static void demo1() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setUseCache(false);
        /*
        MethodInterceptor:基本上能完成大部分的拦截需求

        @param obj 代理对象
        @param method 拦截的方法
        @param args 拦截的方法的参数
        @param proxy 代理
         */
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            log.info("before intercept");
            Object result = proxy.invokeSuper(obj, args);
            log.info("after intercept");
            return result;
        });

        Student s = (Student)enhancer.create();
        s.printName();
    }

    public static void demo2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setUseCache(false);
        /*
        FixedValue：为提高性能，FixedValue回调对强制某一特定方法返回固定值。

        设置单一回调对象，在调用中拦截对目标方法的调用
         */
        enhancer.setCallback((FixedValue) () -> {
            log.info("xxxx");
            return "xxx";
        });

        Student s = (Student)enhancer.create();
        s.printName();
    }

    public static void demo3() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setUseCache(false);
        /*
        NoOp：NoOp回调把对方法调用直接委派到这个方法在父类中的实现（也可以理解成真实对象直接调用方法）

        设置单一回调对象，在调用中拦截对目标方法的调用
         */
        enhancer.setCallback(NoOp.INSTANCE);

        Student s = (Student)enhancer.create();
        s.printName();
    }

    public static void main(String[] args) {
        demo2();
    }
}
