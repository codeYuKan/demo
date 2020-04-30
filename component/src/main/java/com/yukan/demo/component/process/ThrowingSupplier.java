package com.yukan.demo.component.process;

/**
 * @author yukan
 * @date 2020/4/28
 * @email yukan.cn.mail@gmail.com
 */
@FunctionalInterface
public interface ThrowingSupplier<T, E extends Throwable>{

    T get() throws E;
}
