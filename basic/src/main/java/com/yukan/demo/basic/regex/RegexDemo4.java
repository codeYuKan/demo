package com.yukan.demo.basic.regex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yukan
 * @date 2019/11/15
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class RegexDemo4 {

    private static void matchesTest() {
    }

    /**
     * 通过group，在正则表达式中增加括号进行分割操作
     *
     * @param str 待匹配的字符串
     */
    private static void groupTest(String str) {
        // 以数字开头
        String regex = "([1-9]\\d*)([+\\-*/])([1-9]\\d*)(=?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        log.info("matcher.find():{}", matcher.find());
        log.info("matcher.groupCount():{}", matcher.groupCount());

        for (int i = 0; i < matcher.groupCount(); i++) {
            log.info("{}", matcher.group(i));
        }

    }


    public static void main(String[] args) {
        groupTest("3223+88=");
    }
}
