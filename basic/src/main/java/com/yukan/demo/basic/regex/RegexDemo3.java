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
public class RegexDemo3 {

    private static void matchesTest() {
    }

    /**
     * Matcher matcher(CharSequence input)
     * matcher方法返回的是一个Matcher对象，Matcher类的构造方法也被private保护了起来，只能使用这个方法创建。
     * Pattern类只能做一些简单的匹配工作，要想获得更强大更便捷的正则匹配操作，那就需要Pattern和Matcher一起合作。
     * Matcher提供了对正则表达式的分组支持，以及对正则表达式的多次匹配
     *
     * 除了matches、lookingAt和find(int)， 别的匹配都是基于之前的匹配，即被前面的操作匹配成功了一次，没法被再次匹配
     *
     * @param str 待匹配的字符串
     */
    private static void matcherTest(String str) {
        // 以数字开头
        String regex = "[1-9]\\d*[+\\-*/][1-9]\\d*=?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        // 还未曾匹配 会报错
        //startAndEnd(matcher);

        // 同 Pattern.matches
        log.info("matcher.matches():{}", matcher.matches());
        log.info("matcher.matches():{}", matcher.matches());
        log.info("matcher.matches():{}", matcher.matches());
        log.info("matcher.find():{}", matcher.find());
        log.info("matcher.find(2):{}", matcher.find(2));
        //startAndEnd(matcher);

        // 用regex去匹配str的前缀
        log.info("matcher.lookingAt():{}", matcher.lookingAt());
        startAndEnd(matcher);

        // 在str中找是否有匹配regex的子字符串
        log.info("matcher.find():{}", matcher.find());
        // 上面的matches or lookingAt会导致 find匹配不到
        startAndEnd(matcher);

        // 在str中 从第2位(从0开始 实际为第三位)开始找是否有匹配regex的子字符串
        log.info("matcher.find(2):{}", matcher.find(2));
        startAndEnd(matcher);


        // lookingAt不会被之前的匹配给屏蔽
        log.info("matcher.lookingAt():{}", matcher.lookingAt());
        startAndEnd(matcher);
    }

    /**
     * 必须在一次成功的匹配之后，否则会抛出异常
     *
     * @param matcher 刚经历过一次成功的匹配
     */
    private static void startAndEnd(Matcher matcher) {
        log.info("matcher.start():{}", matcher.start());
        log.info("matcher.end():{}", matcher.end());
    }

    public static void main(String[] args) {
        matcherTest("3223+88");
    }
}
