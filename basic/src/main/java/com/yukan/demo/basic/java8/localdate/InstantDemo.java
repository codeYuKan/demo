package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
        log.info("currentSecond:{}", currentSecond);

        long currentMilli = instant.toEpochMilli();
        log.info("currentMilli:{}", currentMilli);

        LocalDateTime localDateTime1 = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        log.info("localDateTime1:{}", localDateTime1);
        LocalDateTime localDateTime2 = Instant.ofEpochMilli(currentMilli).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        log.info("localDateTime2:{}", localDateTime2);
        LocalDateTime localDateTime3 = Instant.ofEpochSecond(currentSecond).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        log.info("localDateTime3:{}", localDateTime3);
    }

    public static void main(String[] args) {
        test1();
    }
}
