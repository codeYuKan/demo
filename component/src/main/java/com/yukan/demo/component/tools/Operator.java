package com.yukan.demo.component.tools;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 操作工具
 *
 * @author yukan
 * @date 2020/3/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Operator {

    private Operator () throws InstantiationException {
        throw new InstantiationException("not allow to instantiate Operator!");
    }

    /**
     * 当t不为null时，对t执行tConsumer操作
     */
    public static <T> void execute(T t, Consumer<T> tConsumer) {
        execute(t, Objects::nonNull, tConsumer);
    }

    public static <T> void execute(T t, Predicate<T> predicate, Consumer<T> tConsumer) {
        if (predicate.test(t)){
            tConsumer.accept(t);
        }
    }
}
