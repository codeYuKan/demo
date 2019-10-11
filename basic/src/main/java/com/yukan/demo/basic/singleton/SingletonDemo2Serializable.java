package com.yukan.demo.basic.singleton;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 静态工厂方法实现单例
 * Effective java p14
 *
 * @author yukan
 * @date 2019/9/25
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class SingletonDemo2Serializable implements Serializable {

    private static final long serialVersionUID = 8359588914880352104L;

    private final static SingletonDemo2Serializable SINGLETON_DEMO_2 = new SingletonDemo2Serializable();

    private SingletonDemo2Serializable() {}

    public SingletonDemo2Serializable getSingletonInstance(){
        return SINGLETON_DEMO_2;
    }

    /**
     * 为了维护并保证Singleton
     */
    private Object readResolve() {
         return SINGLETON_DEMO_2;
    }
}
