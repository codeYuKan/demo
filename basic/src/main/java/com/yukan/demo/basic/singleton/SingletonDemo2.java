package com.yukan.demo.basic.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 静态工厂方法实现单例
 * Effective java p14
 *
 * @author yukan
 * @date 2019/9/25
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class SingletonDemo2 {

    private final static SingletonDemo2 SINGLETON_DEMO_2 = new SingletonDemo2();

    private SingletonDemo2() {}

    /**
     * 静态工厂方法
     * SingletonDemo1的公有域形式在性能上不再有任何优势：现代的JVM实现几乎都能够将静态工厂方法的调用内联化
     * 优点：
     * 1.灵活性：可以不改变API的前提下，改变内部具体实现，比如考虑是不不再使用Singleton
     * 2.与泛型相关？？？？
     */
    public SingletonDemo2 getSingletonInstance(){
        return SINGLETON_DEMO_2;
    }
}
