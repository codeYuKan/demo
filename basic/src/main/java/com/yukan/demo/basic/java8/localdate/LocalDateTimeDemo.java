package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * 获取年月日时分秒，等于LocalDate+LocalTime
 *
 * @author yukan
 * @date 2020/11/20
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class LocalDateTimeDemo {

    public static void test1() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);

        LocalDate localDate2 = localDateTime.toLocalDate();

        LocalTime localTime2 = localDateTime.toLocalTime();
    }

    /**
     * LocalDate、LocalTime、LocalDateTime、Instant为不可变对象，修改这些对象对象会返回一个副本
     */
    public static void test2() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, Month.SEPTEMBER, 10,
                14, 46, 56);
        //增加一年
        localDateTime = localDateTime.plusYears(1);
        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);
        //减少一个月
        localDateTime = localDateTime.minusMonths(1);
        localDateTime = localDateTime.minus(1, ChronoUnit.MONTHS);

        //修改年为2019
        localDateTime = localDateTime.withYear(2020);
        //修改为2022
        localDateTime = localDateTime.with(ChronoField.YEAR, 2022);

    }
}
