package com.yukan.demo.basic.classloader;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author yukan
 * @date 2019/12/2
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FieldAssignOrderDemo {

    private String aaa = "1";

    private static String aa = "12";

    /**
     * 非编译期常量的static final
     */
    private static final String aaaa = String.valueOf(new Random(47).nextInt(1000));

    /**
     * 编译期常量的static final
     */
    private static final String a = "123";

    private final String bb = "123";

    private static String b = "1234";

    private String c = "12345";

    static {
        String d = "123456";
        System.out.println(123);
    }

    FieldAssignOrderDemo() {
        System.out.println(1234);
    }

    public static void main(String[] args) {
        FieldAssignOrderDemo demo = new FieldAssignOrderDemo();
    }
}
