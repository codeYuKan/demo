package com.yukan.demo.basic.autoboxing;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2021/5/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Demo1 {

    public static void test1() {
        Integer a = 1;
        Integer b = 1;
        Integer c = 3;
        Integer d = 3;
        Integer e = 312;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }

    public static void main(String[] args) {
        test1();
    }
}
