package com.yukan.demo.component.process;

@FunctionalInterface
public interface ThrowingConsumer <T, E extends Throwable> {

    /**
     * 对异常选择上抛
     * 原consumer接口没有上抛 才使得不好处理
     *
     * @param t
     * @throws E
     */
    void accept (T t)throws E;
}
