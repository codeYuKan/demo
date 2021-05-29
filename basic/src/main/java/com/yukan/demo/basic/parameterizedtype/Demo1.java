package com.yukan.demo.basic.parameterizedtype;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * @author yukan
 * @date 2021/5/29
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Demo1 {


    public static void test1() {
        A a = new A("xxx", 3003, new Object());
        Type type = a.getClass().getGenericSuperclass();
    }

    public static void main(String[] args) {
        test1();
    }
}
