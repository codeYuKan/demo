package com.yukan.demo.common.tool;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/27
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public abstract class Ticker {

    Ticker(){}

    public abstract long read();

    public static Ticker ticker(){
        return INSTANCE;
    }

    private static final Ticker INSTANCE =
        new Ticker(){
            @Override
            public long read() {
                return System.nanoTime();
            }
        };
}
