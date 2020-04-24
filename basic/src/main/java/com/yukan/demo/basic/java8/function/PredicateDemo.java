package com.yukan.demo.basic.java8.function;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author yukan
 * @date 2020/3/20
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PredicateDemo {

    private static final Predicate predicate = Objects::isNull;

    public static void test(Object obj) {
        log.info("test.result:{}", predicate.test(obj));
        log.info("negate()test.result:{}", predicate.negate().test(obj));
        log.info("negate()test.result:{}", predicate.and(predicate.negate()).test(obj));
        log.info("negate()test.result:{}", predicate.or(predicate.negate()).test(obj));
    }

    public static void main(String[] args) {
        test(null);

        test(new Object());
    }
}
