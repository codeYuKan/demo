package com.yukan.demo.component.process;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author yukan
 * @date 2020/4/27
 * @email yukan.cn.mail@gmail.com
 */
public class Estimate {

    public static <T, E extends Throwable> void estimate(Predicate<T> predicate, T t, Supplier<E> exceptionSupplier) throws E {
        if (!predicate.test(t)) {
            throw exceptionSupplier.get();
        }
    }

    public static <T, E extends Throwable> void negateEstimate(Predicate<T> predicate, T t, Supplier<E> exceptionSupplier) throws E {
        if (predicate.test(t)) {
            throw exceptionSupplier.get();
        }
    }
}
