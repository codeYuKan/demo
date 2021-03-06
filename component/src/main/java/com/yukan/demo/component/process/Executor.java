package com.yukan.demo.component.process;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author yukan
 * @date 2020/4/27
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Executor {


    public static <R> R execute(Supplier<R> process) {
        return process.get();
    }

    public static <T, R> R execute(Function<T, R> process, T t) {
        return process.apply(t);
    }

    public static <T, R> R executeWithEstimate(Boolean condition, Supplier<R> process, Supplier<R> elseProcess) {
        return executeWithEstimate(t -> condition, null, a -> process.get(), a -> elseProcess.get());
    }

    public static <T, R> R executeWithEstimate(Predicate<T> predicate, T t, Supplier<R> process, Supplier<R> elseProcess) {
        return executeWithEstimate(predicate, t, a -> process.get(), a -> elseProcess.get());
    }

    public static <T, R> R executeWithEstimate(Predicate<T> predicate, T t, Function<T, R> process, Function<T, R> elseProcess) {
        if (predicate.test(t)) {
            return process.apply(t);
        } else {
            return elseProcess.apply(t);
        }
    }

    public static void executeWithResultCheck(Supplier<Boolean> process) {
        executeWithResultCheck(process, t -> t, RuntimeException::new);
    }

    public static <E extends Throwable> void executeWithResultCheck(Supplier<Boolean> process, Supplier<E> exceptionSupplier) throws E {
        executeWithResultCheck(process, t -> t, exceptionSupplier);
    }

    public static <T, E extends Throwable> void executeWithResultCheck(Supplier<T> process, Predicate<T> resultEstimate, Supplier<E> exceptionSupplier) throws E {
        if (!resultEstimate.test(process.get())) {
            throw exceptionSupplier.get();
        }
    }

    public static <T> void executeWhen(Predicate<T> condition, T t, Supplier<T> process) {
        if (condition.test(t)) {
            process.get();
        }
    }

    public static <T, R> Optional<R> executeWhen(Predicate<T> condition, T t, Function<T, R> function) {
        if (condition.test(t)) {
            return Optional.ofNullable(function.apply(t));
        } else {
            return Optional.empty();
        }
    }

    public static <T, R, E extends Throwable> Optional<R> executeWhenWithThrow(Predicate<T> condition, T t, ThrowingFunction<T, R, E> function) throws E {
        if (condition.test(t)) {
            try {
                return Optional.ofNullable(function.apply(t));
            } catch (Throwable throwable) {
                log.info(throwable.getMessage());
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }

    public static <T, E extends Throwable> void executeWhenWithThrow(Predicate<T> condition, T t, ThrowingConsumer<T, E> consumer) throws E {
        if (condition.test(t)) {
            try {
                consumer.accept(t);
            } catch (Throwable throwable) {
                log.info(throwable.getMessage());
            }
        }
    }
}
