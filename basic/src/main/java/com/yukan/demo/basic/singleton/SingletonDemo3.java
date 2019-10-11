package com.yukan.demo.basic.singleton;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 最佳方法
 * Java1.5之后 通过包含单个元素的枚举类实现单例
 * 与公有域方式接近，但是更加简洁、无偿提供了序列化机制、绝对防止多次实例化，即使在面对复杂的序列化或者反射攻击的时候
 * Effective java p15
 *
 * @author yukan
 * @date 2019/9/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
@AllArgsConstructor
@Getter
public enum SingletonDemo3 {

    /**
     * 用法：
     * SingletonDemo3 singletonDemo3 = SingletonDemo3.INSTAMCE;
     * log.info("name:{}", singletonDemo3.getName());
     */
    INSTAMCE("zhangsan");

    private String name;

    public void method() {

    }

}