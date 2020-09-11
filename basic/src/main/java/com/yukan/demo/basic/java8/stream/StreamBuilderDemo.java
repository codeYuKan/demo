package com.yukan.demo.basic.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yukan
 * @date 2020/9/1
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StreamBuilderDemo {

    Stream.Builder<String> builder  = Stream.builder();

    public StreamBuilderDemo() {
        String str = "lh jk as d h b g j k sd";
        for (String s : str.split("[ .?,]+")) {
            builder.add(s);
        }
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) {
        String result = new StreamBuilderDemo().stream().sorted().collect(Collectors.joining("-"));
        System.out.println(result);
    }
}