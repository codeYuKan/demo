package com.yukan.demo.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉式单例
 * see more: {@link com.yukan.demo.basic.singleton}
 *
 * @author yukan
 * @date 2019/10/29
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class HungrySingletonDemo {

    private static final HungrySingletonDemo instance = new HungrySingletonDemo();

    private HungrySingletonDemo() {}

    public HungrySingletonDemo getInstance() {
        return instance;
    }


}
