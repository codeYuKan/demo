package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * 只会获取几点几分几秒
 *
 * @author yukan
 * @date 2020/11/20
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class LocalTimeDemo {

    public static void test1() {
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime localTime1 = LocalTime.now();

        //获取小时
        int hour = localTime.getHour();
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        //获取分
        int minute = localTime.getMinute();
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        //获取秒
        int second = localTime.getSecond();
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
    }
}
