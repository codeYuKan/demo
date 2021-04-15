package com.yukan.demo.basic.regex;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2021/4/15
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class CommonRegexDemo {

    // 数字
    private final static String r1 = "^[0-9]*$";
    // n位的数字
    private final static String r2 = "^\\d{n}$";
    // 至少n位的数字
    private final static String r3 = "^\\d{n,}$";
    // m-n位的数字
    private final static String r4 = "^\\d{m,n}$";
    // 零和非零开头的数字
    private final static String r5 = "^(0|[1-9][0-9]*)$";
    // 非零开头的最多带两位小数的数字
    private final static String r6 = "^([1-9][0-9]*)+(.[0-9]{1,2})?$";
    // 带1-2位小数的正数或负数
    private final static String r7 = "^(\\-)?\\d+(\\.\\d{1,2})?$";
}
