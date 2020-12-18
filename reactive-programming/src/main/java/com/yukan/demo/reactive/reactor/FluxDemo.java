package com.yukan.demo.reactive.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * @author yukan
 * @date 2020/11/18
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FluxDemo {

    public static void test() {
        Flux flux1 = Flux.just("a","b");
        String[] strArr = {"a", "b", "c"};
        Flux flux2 = Flux.fromArray(strArr);
        Flux flux3 = Flux.empty();
        flux1 = Flux.error(new RuntimeException());
        flux1 = Flux.never();
        flux1 = Flux.range(3, 15);
        //flux1 = Flux.interval();

    }

    public static void test2() {
        Flux.generate(sink -> {
            sink.next("hello");
            sink.currentContext().put("1","2");
            //sink.next("1");
            //sink.next("hello3");
            //sink.next("hello4");
            //sink.next("hello5");
            sink.currentContext().get("1");
            sink.complete();
        }).subscribe(System.out::println);
    }

    public static void test1() {
        Flux.just("a","b").subscribe(System.out::println);
    }

    public static void main(String[] args) {
        char d = (char)70000;
        System.out.println(d + " " +(int)d );
    }
}