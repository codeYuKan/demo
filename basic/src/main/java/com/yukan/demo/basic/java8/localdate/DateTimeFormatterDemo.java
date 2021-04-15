package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.time.temporal.ChronoField;

/**
 * @author yukan
 * @date 2020/9/7
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class DateTimeFormatterDemo {

    public static DateTimeFormatter dateTimeFormatterBuilder1() {
        return new DateTimeFormatterBuilder()
                .appendValue(ChronoField.YEAR_OF_ERA, 4, 4, SignStyle.EXCEEDS_PAD)
                .appendPattern(" MM[ dd]")
                .toFormatter();
    }

    public static void test1() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy MM");
        DateTimeFormatter formatter = dateTimeFormatterBuilder1();
        String text = date.format(formatter1);
        //LocalDate parsedDate = LocalDate.parse(text, formatter);
        //System.out.println(1);
        formatter.parse(text);
        System.out.println(1);
    }

    public static void test2() {
        String pattern = "MM/dd/yyyy[ 'at' HH:mm:ss]";
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

        LocalDate ld = LocalDate.of(2014, Month.JUNE, 30);
        LocalTime lt = LocalTime.of(17, 30, 12);
        LocalDateTime ldt = LocalDateTime.of(ld, lt);

        String str1 = fmt.format(ld);
        System.out.println(fmt.parse(str1));

        String str2 = fmt.format(ldt);

        System.out.println(fmt.parse(str2));
    }

    public static void test3() {
        LocalDate localDate = LocalDate.of(2019, 9, 10);
        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);

        LocalDate localDate1 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static void main(String[] args) {
        test3();
        //test2();
        //DateTimeFormatter.ofPattern("yyyy[/][-]MM[/][-][dd][ HH:mm:ss]").parse("202009");
    }
}
