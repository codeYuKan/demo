package com.yukan.demo.basic.regex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thinking in Java example
 *
 * @author yukan
 * @date 2019/11/29
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class RegexDemo11 {

    /*!
        River flows in you
        champagne ocean
        Dusk
        HEY HEY
        something just like this
        sakura tears
     !*/
    public static void main(String[] args) {
        //String s = TextFile.read()

        String s = "var apidata={ content:\"<table class='w782 comm lsjz'><thead><tr><th class='first'>净值日期</th><th>单位净值</th><th>累计净值</th><th>日增长率</th><th>申购状态</th><th>赎回状态</th><th class='tor last'>分红送配</th></tr></thead><tbody><tr><td>2021-04-12</td><td class='tor bold'>1.3627</td><td class='tor bold'>1.3627</td><td class='tor bold grn'>-2.16%</td><td>开放申购</td><td>开放赎回</td><td class='red unbold'></td></tr></tbody></table>\",records:1,pages:1,curpage:1};";

        String regex = "bold'>\\d*.\\d*</td>";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(s);
        log.info("{} match start:", regex);
        while (matcher.find()) {
            log.info("{}-{}:{}", matcher.start(), matcher.end(), matcher.group());
        }
        log.info("match end~");
    }
}
