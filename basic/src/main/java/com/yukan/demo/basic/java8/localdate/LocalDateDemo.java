package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
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
        LocalDate localDate1 = LocalDate.MAX;
        LocalDate localDate2 = LocalDate.MIN;
        LocalDate localDate3 = LocalDate.parse("2019-09-15", DateTimeFormatter.ofPattern("yyyy-mm-dd"));
        LocalDate localDate4 = LocalDate.parse("2019-09-18");

        log.info("1:{}", localDate1);
        log.info("2:{}", localDate2);
        log.info("3:{}", localDate3);
        log.info("4:{}", localDate4);
    }

    public static void test2() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.parse("2019-09-18");
        localDate.until(localDate2);
    }

    public static void main(String[] args) {
        test2();
    }
}
