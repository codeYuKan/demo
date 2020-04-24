package com.yukan.demo.basic.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * @author yukan
 * @date 2019/11/19
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StreamReduceDemo {

    public static void main(String[] args) {
        // 从stream的数据(1, 2, 3, 4)，根据指定的计算模型accumulator(Integer::sum)，生成一个值  可以设置初始值(3)
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(3, Integer::sum);
        log.info("reduce:{}", reduce);
    }
}
