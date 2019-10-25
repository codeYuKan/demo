package com.yukan.demo.basic.java8.localdate;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * dayOfWeekInMonth  创建一个新的日期,它的值为同一个月中每一周的第几天,
 * firstDayOfMonth  创建一个新的日期,它的值为当月的第一天
 * firstDayOfNextMonth  创建一个新的日期,它的值为下个月的第一天
 * firstDayOfNextYear  创建一个新的日期,它的值为明年的第一天
 * firstDayOfYear  创建一个新的日期,它的值为当年的第一天
 * firstInMonth 创建一个新的日期 它的值同一个月中,第一个符合星期几要求的值
 * lastDayOfMonth  创建一个新的日期,它的值为当月的最后一天
 * lastDayOfNextMonth  创建一个新的日期,它的值为下个月的最后一天
 * lastDayOfNextYear  创建一个新的日期,它的值为明年的最后一天
 * lastDayOfYear  创建一个新的日期,它的值为当年的最后一天
 * lastInMonth 创建一个新的日期 它的值同一个月中,最后一个符合星期几要求的值
 * next/previous 创建一个新的日期 并将其值设定为日期调整后或者调整前,第一个符合指定星期几要求的日期
 * nextOrSame/previousOrSame 创建一个新的日期 并将其值设定为日期调整后或者调整前,第一个符合指定星期几要求的日期 如果该日期符合要求,直接返回改对象
 *
 * @author yukan
 * @date 2019/10/24
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class TemporalAdjustersTest {

    public static void test1() {
        LocalDate localDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        log.info(":{}",localDate);
    }

    public static void main(String[] args) {
        test1();
    }

}
