package com.yukan.demo.basic.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author yukan
 * @date 2020/8/18
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class RandomDemo {

    public static void main(String[] args) {
        new Random(43)
                .ints(5,0,20)
                .distinct()
                //.limit(11)
                .sorted()
                .forEach(System.out::println);
    }
}