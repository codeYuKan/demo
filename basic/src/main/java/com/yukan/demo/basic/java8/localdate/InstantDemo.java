package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * 获取秒数
 *
 * @author yukan
 * @date 2020/11/20
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class InstantDemo {

    public static void test1() {
        Instant instant = Instant.now();

        long currentSecond = instant.getEpochSecond();

        long currentMilli = instant.toEpochMilli();
    }
}
