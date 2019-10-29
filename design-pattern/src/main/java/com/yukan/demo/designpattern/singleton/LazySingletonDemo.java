package com.yukan.demo.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 懒汉式单例
 *
 * @author yukan
 * @date 2019/10/29
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class LazySingletonDemo {

    private static volatile LazySingletonDemo instance;

    private LazySingletonDemo() {}

    public synchronized LazySingletonDemo getInstance() {
        if(Objects.isNull(instance)) {
            instance = new LazySingletonDemo();
        }
        return instance;
    }
}
