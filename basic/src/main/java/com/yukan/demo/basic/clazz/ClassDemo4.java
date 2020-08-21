package com.yukan.demo.basic.clazz;

import com.google.common.collect.ImmutableList;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;

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
public class ClassDemo4 {
    public static class A implements C,D{
        final List<C> aList;

        public A(C c){
            this.aList = ImmutableList.copyOf(Collections.singleton(c));
        }

        public int test() {
            return 1;
        }

        @Override
        public int test2() {
            return 0;
        }
    }

    public static class B extends A{

        private B(C b){
            super(b);
        }

        public int test() {
            return 2;
        }

        public static void main(String[] args) {
            Substitute substitute = new Substitute();
            C proxy = (C)Proxy.newProxyInstance(B.class.getClassLoader(), new Class[]{C.class, D.class}, substitute);
            //C proxy = (C)Proxy.newProxyInstance(C.class.getClassLoader(), C.class.getInterfaces(), substitute);
            B b = new B(proxy);
            substitute.setB(b);
            System.out.println(b.test());
            //System.out.println(proxy.test2());
        }
    }

    public interface C {
        int test();
    }


    public interface D {
        int test2();
    }

    public interface E extends C,D{

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
