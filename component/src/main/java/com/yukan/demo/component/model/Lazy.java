package com.yukan.demo.component.model;

import lombok.NonNull;

import java.util.function.Supplier;

/**
 *  延迟加载类
 *
 * @author yukan
 * @date 2020/5/18
 * @email yukan.cn.mail@gmail.com
 */
public class Lazy<T> implements Supplier<T> {

    private Supplier<T> supplier;

    public static <T> Lazy<T> of(@NonNull Supplier<T> supplier) {
        if (supplier instanceof Lazy) {
            return (Lazy<T>) supplier;
        } else {
            return new Lazy<>(supplier);
        }
    }

    public Lazy(@NonNull Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T get() {
        return supplier.get();
    }
}
