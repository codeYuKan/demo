package com.yukan.demo.basic.jvm.classloading.passiveinit;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class SubClass extends SuperClass {

    static {
        log.info("SubClass init!");
    }
}
