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

    /**
     * 通过group，在正则表达式中增加括号进行分割操作
     *
     * @param str 待匹配的字符串
     */
    private static void groupTest(String str) {
        // 根据()分割成子模式
        String regex = "([1-9]\\d*)([+\\-*/])([1-9]\\d*)(=?)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        log.info("matcher.find():{}", matcher.find());
        log.info("matcher.groupCount():{}", matcher.groupCount());

        // group的第一项 为匹配到的全字符串，groupCount代表子模式的匹配数量，所以需要用<=才能循环完所有的项
        for (int i = 0; i <= matcher.groupCount(); i++) {
            log.info("{} - {}:{}", matcher.start(i), matcher.end(i), matcher.group(i));
        }

    }


    public static void main(String[] args) {
        groupTest("e33+99=");
    }
}
