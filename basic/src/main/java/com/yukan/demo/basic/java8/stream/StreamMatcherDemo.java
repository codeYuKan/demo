package com.yukan.demo.basic.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yukan
 * @date 2020/9/22
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StreamMatcherDemo {
    static void show(Matcher match, int val) {
        System.out.println(
                match.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(n -> System.out.format("%d ", n)),
                        n -> n < val));
    }
    public static void main(String[] args) {
        //show(Stream::allMatch, 10);
        //show(Stream::allMatch, 4);
        //show(Stream::anyMatch, 2);
        //show(Stream::anyMatch, 0);
        //show(Stream::noneMatch, 5);
        //show(Stream::noneMatch, 0);

        IntStream.rangeClosed(1, 9)
                .boxed()
                .peek(n -> System.out.format("%d ", n))
                .map(n -> n + 1)
                .peek(n -> System.out.format("%d | ", n))
                ;
    }
}

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}
