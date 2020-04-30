package com.yukan.demo.component.process;

/**
 * @author yukan
 * @date 2020/4/28
 * @email yukan.cn.mail@gmail.com
 */
@FunctionalInterface
public interface ThrowingFunction<T, R, E extends Throwable>{

    R apply(T t) throws E;
}
