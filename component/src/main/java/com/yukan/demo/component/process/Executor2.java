package com.yukan.demo.component.process;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
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
@SuppressWarnings("rawtypes")
public abstract class Executor2<E extends Executor2> {

    protected boolean end = false;

    public static void main(String[] args) {
        File file = new File("");
        String name = Executor2.build(File::getName).estimate(1==1).data(file).execute();
        Supplier<String> stringSupplier = () -> "123";
        String s = Executor2.build(stringSupplier).estimate(("123")::equals, "123").execute();
    }

    @SuppressWarnings("unchecked")
    public E estimate(Boolean condition) {
        end = !condition;
        return (E)this;
    }

    @SuppressWarnings("unchecked")
    public <T> E estimate(Predicate<T> condition, T t) {
        end = !condition.test(t);
        return (E)this;
    }

    public static <R> SupplierExecutor<R> build(Supplier<R> supplier) {
        return new SupplierExecutor<>(supplier);
    }

    public static <T, R> FunctionExecutor<T, R> build(Function<T, R> function) {
        return new FunctionExecutor<>(function);
    }

    public static class SupplierExecutor<R> extends Executor2<SupplierExecutor<R>> {

        private final Supplier<R> supplier;

        private Supplier<R> elseSupplier;

        public SupplierExecutor(Supplier<R> supplier) {
            this.supplier = supplier;
        }

        public SupplierExecutor orElse(Supplier<R> supplier) {
            this.elseSupplier = supplier;
            return this;
        }

        public R execute() {
            if (end) {
                return null;
            }
            return supplier.get();
        }
    }

    public static class FunctionExecutor<T, R> extends Executor2<FunctionExecutor<T, R>> {

        private T t;

        private final Function<T, R> function;

        public FunctionExecutor(Function<T, R> function) {
            this.function = function;
        }

        public FunctionExecutor<T, R> data(T t) {
            this.t = t;
            return this;
        }

        public Executor2 estimate(Predicate<T> condition) {
            end = !condition.test(t);
            return this;
        }

        public R execute() {
            if (end) {
                return null;
            }
            return function.apply(t);
        }
    }

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