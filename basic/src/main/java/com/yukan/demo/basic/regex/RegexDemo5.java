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
public class RegexDemo5 {

    /**
     * 贪婪模式的测试
     *
     * @param regex 正则表达式
     */
    private static void greedyTest(String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher("abcaxc");
        log.info("{} match start:", regex);
        while (matcher.find()) {
            log.info("{}-{}:{}", matcher.start(), matcher.end(), matcher.group());
        }
        log.info("match end~");
    }

    public static void main(String[] args) {
        // 贪婪模式
        greedyTest("ab.*c");
        // 非贪婪模式(在量词后面加一个?)
        greedyTest("ab.*?c");
    }
}
