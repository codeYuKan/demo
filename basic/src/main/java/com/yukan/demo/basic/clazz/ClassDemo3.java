package com.yukan.demo.basic.clazz;

import com.google.common.collect.ImmutableList;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * @author yukan
 * @date 2020/8/20
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ClassDemo3 {
    public static class A {
        final List<C> aList;

        public A(C c){
            this.aList = ImmutableList.copyOf(Collections.singleton(c));
        }
    }

    public static class B extends A implements C {

        public static B instance() {
            Substitute substitute = new Substitute();
            C proxy = (C)Proxy.newProxyInstance(B.class.getClassLoader(), B.class.getInterfaces(), substitute);

            B b = new B(proxy);
            substitute.setB(b);
            return b;
        }

        private B(C b){
            super(b);
        }

        public static void main(String[] args) {
            System.out.println(instance().test());
        }

        public int test() {
            return 3;
        }

        //@Override
        //public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //    return null;
        //}
    }

    public interface C {
        int test();
    }

    public static class Substitute implements InvocationHandler{

        @Setter
        private B b;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(b, args);
        }
    }
}
