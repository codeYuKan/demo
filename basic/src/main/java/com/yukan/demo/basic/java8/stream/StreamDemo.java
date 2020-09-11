package com.yukan.demo.basic.java8.stream;

import com.yukan.demo.basic.model.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yukan
 * @date 2020/8/28
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StreamDemo {

    public void streamDemo() {
        Stream.of(new Student(),new Student(),new Student()).forEach(System.out::println);
    }

    public void randomDemo() {
        Random random = new Random(47);
        show(random.ints().boxed());
        show(random.doubles().boxed());
        show(random.ints(30,50).boxed());
        show(random.ints(10).boxed());
        show(random.ints(5,30,50).boxed());
    }

    private <T> void show(Stream<T> stream) {
        stream.peek(System.out::println).limit(4).forEach(System.out::println);
    }

    public void rangeDemo() {
        System.out.println(IntStream.range(2,10).sum());

    }

    public static void repeat(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }

    public void generateDemo() {
        Stream.generate(() -> "test")
                .limit(3)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        demo.randomDemo();
    }
}
