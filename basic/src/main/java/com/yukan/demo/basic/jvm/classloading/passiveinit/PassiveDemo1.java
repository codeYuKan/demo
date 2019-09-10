package com.yukan.demo.basic.jvm.classloading.passiveinit;

import lombok.extern.slf4j.Slf4j;

/**
 * 被动使用类字段demo1
 * 通过子类引用父类的静态字段，不会导致子类初始化
 *
 * @author yukan
 * @date 2019/9/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PassiveDemo1 {

    public static void main(String[] args) {
        // only SuperClass init
        log.info("value:{}", SubClass.value);
    }
}
