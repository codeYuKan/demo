package com.yukan.demo.basic.jvm.classloading.passiveinit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class SuperClass {

    static {
        log.info("SuperClass init!");
    }

    public static int value = 100;
}
