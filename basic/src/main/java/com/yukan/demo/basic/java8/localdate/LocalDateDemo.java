package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import static java.time.temporal.TemporalAdjusters.firstDayOfYear;

/**
 * 只会获取年月日
 *
 * Temporal是接口  所有的日期时间类 实现了该接口
 * from 依据传入的Temporal对象创建对象实例
 * now 依据系统时钟创建Temporal对象
 * of 有Temporal对象的某个部分创建该对象的实例
 * parse 由字符串创建Temporal对象的实例
 * atOffset 将Temporal对象和某个时区偏移相结合
 * atZone 将Temporal对象和某个时区相结合
 * format 使用某个指定的格式器将Temporal对象转换为字符串(Instant类不提供该方法)
 * get 读取Temporal对象的某一部分
 * minus 创建Temporal对象的一个副本,通过将当前Temporal对象的值减去一定的时长创建该副本
 * plus 创建Temporal对象的一个副本,通过将当前Temporal对象的值加上一定的时长创建该副本
 * with 以该Temporal对象为模板,对某些状态进行修改创建该对象的副本
 *
 * @author yukan
 * @date 2019/10/24
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class LocalDateDemo {

    public static void test1() {
        /**
         * LocalDate 表示一个具体的日期，但不包含具体时间，也不包含时区信息
         */
        LocalDate localDate1 = LocalDate.MAX;
        LocalDate localDate2 = LocalDate.MIN;
        LocalDate localDate3 = LocalDate.parse("2019-09-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate localDate4 = LocalDate.parse("2019-09-18");
        LocalDate localDate5 = LocalDate.of(2020,9,11);

        log.info("1:{}", localDate1);
        log.info("2:{}", localDate2);
        log.info("3:{}", localDate3);
        log.info("4:{}", localDate4);
        log.info("5:{}", localDate5);
    }

    public static void test2() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.parse("2019-09-18");
        localDate.until(localDate2);
    }

    /**
     * 测试LocalDate的一些基本方法
     */
    public static void test3() {
        LocalDate localDate = LocalDate.now();
        log.info("getYear:{}",localDate.getYear());
        log.info("getDayOfYear:{}",localDate.getDayOfYear());
        log.info("getDayOfMonth:{}",localDate.getDayOfMonth());
        log.info("getDayOfWeek:{}",localDate.getDayOfWeek());
        log.info("getMonth:{}",localDate.getMonth());
        log.info("getMonthValue;{}",localDate.getMonthValue());
        log.info("getChronology:{}",localDate.getChronology());
        log.info("getEra:{}",localDate.getEra());
        //log.info("{}",localDate.getLong(ChronoField.NANO_OF_DAY));
        //log.info("{}",localDate.getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
        //log.info("{}",localDate.getLong(ChronoField.NANO_OF_DAY));
        //log.info("{}",localDate.getLong(ChronoField.NANO_OF_DAY));
        //log.info("{}",localDate.getLong(ChronoField.NANO_OF_DAY));
    }

    public static void test4() {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        //构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);

        int year = localDate.getYear();
        int year1 = localDate.get(ChronoField.YEAR);
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.getDayOfMonth();
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
    }

    public static void test5() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.with(firstDayOfYear());
    }

    public static void main(String[] args) {
        test3();
    }

}