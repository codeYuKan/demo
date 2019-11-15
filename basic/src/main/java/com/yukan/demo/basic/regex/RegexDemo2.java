package com.yukan.demo.basic.regex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * @author yukan
 * @date 2019/11/15
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class RegexDemo2 {

    private static void matchesTest() {
        matchesTest("+");
        System.out.println();
        matchesTest("\\");
        System.out.println();
        matchesTest("\\\\");
        System.out.println();
        matchesTest("+-");
        System.out.println();
    }

    /**
     * 字符串全匹配
     * pattern的matches方法对字符串进行一次匹配，只有全部符合规则才能返回true！
     *
     * @param str 待匹配的字符串
     */
    private static void matchesTest(String str) {
        String regex = "[+*-/]";
        /*
        \ 在java中和regex中都是转义字符
        四个\ 前两个表示regex的转义符
        后两个表示真实的 \
        java的\\\\就形成了regex的\\就是一个\
         */
        String regex2 = "[-+*/\\\\]";

        // 以数字开头
        String regex3 = "[1-9]\\d*[+\\-*/][1-9]\\d*=?";

        String[] regexArr = {regex, regex2, regex3};

        for (String r : regexArr) {
            log.info("regex {} matches {} result: {}", r, str, Pattern.matches(r, str));
        }
    }

    private static void matchesTest2() {
        matchesTest2("1231232+33123=");
        matchesTest2("1231232+33123");
        matchesTest2("1231232++33123=");
        matchesTest2("++33123=");
        matchesTest2("+13++33123=");
    }

    private static void matchesTest2(String str) {
        /*
        以数字开头

        ?在正则表达式式中有特殊的含义，要匹配?需要转义: \?
        ?表示前面内容的一次或0次
         */
        String regex = "[1-9]\\d*[+\\-*/][1-9]\\d*=?";

        log.info("regex {} matches {} result: {}", regex, str, Pattern.matches(regex, str));
    }

    public static void main(String[] args) {
        matchesTest2();
    }
}
