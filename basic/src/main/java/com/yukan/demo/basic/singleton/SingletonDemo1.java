package com.yukan.demo.basic.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 公有域的形式实现单例
 * Effective java p14
 *
 * @author yukan
 * @date 2019/9/25
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class SingletonDemo1 {

    public final static SingletonDemo1 SINGLETON_DEMO_1 = new SingletonDemo1();

    /**
     * 私有构造函数只会被调用一次
     * 但是可以通过{@link java.lang.reflect.AccessibleObject#setAccessible}，调用私有构造器
     * 可以通过修改构造器，使得被要求创建第二个实例的时候抛出异常
     */
    private SingletonDemo1(){
        if(Objects.isNull(SINGLETON_DEMO_1)) {
            throw new UnsupportedOperationException("SingletonDemo1 must be singleton!!!");
        }
    }
}
