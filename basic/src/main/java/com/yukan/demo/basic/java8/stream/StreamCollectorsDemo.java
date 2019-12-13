package com.yukan.demo.basic.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yukan
 * @date 2019/11/19
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StreamCollectorsDemo {

    public static void main(String[] args) {
        Double sum = Stream.of(1, 2, 3, 4).collect(Collectors.averagingInt(i -> i));
        log.info("sum:{}", sum);
    }
}
