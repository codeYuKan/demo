package com.yukan.demo.basic.reflect;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yukan
 * @date 2019/9/24
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ReflectDemo {

    private void test(){
        System.out.println(123);
    }

    private static void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj = Class.forName("com.yukan.demo.basic.reflect.ReflectDemo").newInstance();
        // getMethod/getMethods can only get public method(include its super method)
        //Method methodTest =  obj.getClass().getMethod("test");
        // getDeclaredMethod/getDeclaredMethods can get its own method(include its own private method)
        Method methodTest =  obj.getClass().getDeclaredMethod("test");
        methodTest.setAccessible(true);
        methodTest.invoke(obj);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        test1();
    }
}
