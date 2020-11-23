package com.yukan.demo.reactive.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * @author yukan
 * @date 2020/11/18
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FluxDemo {

    public void test() {
        Flux flux1 = Flux.just("a","b");
        String[] strArr = {"a", "b", "c"};
        Flux flux2 = Flux.fromArray(strArr);
        Flux flux3 = Flux.empty();
        flux1 = Flux.error(new RuntimeException());
        flux1 = Flux.never();
        flux1 = Flux.range(3, 15);
        //flux1 = Flux.interval();

    }

    public void test1() {
        Flux.just("a","b").subscribe(System.out::println);
    }
}