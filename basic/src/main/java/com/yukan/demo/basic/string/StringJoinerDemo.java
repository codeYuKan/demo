package com.yukan.demo.basic.string;

import com.yukan.demo.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

/**
 * @author yukan
 * @date 2021/2/22
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StringJoinerDemo {

    public static void test1 () {
        StringJoiner stringJoiner = new StringJoiner(Constants.SEPARATOR_COMMA,"XXX","XxX");
        stringJoiner.setEmptyValue("xxxx");
        stringJoiner.add("xxx1");
        stringJoiner.add("xxx2");
        stringJoiner.add("xxx3");
        stringJoiner.add("xxx4");

        StringJoiner stringJoiner2 = new StringJoiner(Constants.SEPARATOR_COMMA,"YYY","YyY");
        stringJoiner2.add("yyy1");
        stringJoiner2.add("yyy2");


        // merge使用调用方的prefix和suffix(若调用方没有则也没有)
        StringJoiner stringJoiner3 = stringJoiner.merge(stringJoiner2);
        log.info("sj1:{}", stringJoiner.toString());
        log.info("sj2:{}", stringJoiner2.toString());
        log.info("sj3:{}", stringJoiner3.toString());
    }

    public static void main(String[] args) {
        test1();
    }
}
