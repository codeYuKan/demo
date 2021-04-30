package com.yukan.demo.reactive.webflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.function.Function;

/**
 * @author yukan
 * @date 2021/4/28
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
class FluxTransDemo {

    @Test
    void create_flatMap_subscribeOn() {
        // publisher
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry")
                .map(Function.identity())
                .flatMap(s -> Mono.just(s).map(str -> str += "xx")
                        //// 线程池大小和cpu核心数一样
                        //.subscribeOn(Schedulers.parallel()));
                        // 在当前线程执行
                        //.subscribeOn(Schedulers.immediate()));
                        // 在一个线程中执行
                        //.subscribeOn(Schedulers.single()));
                        // 专用的线程池执行
                        //.subscribeOn(Schedulers.newSingle("zzz")));
                        // 无界弹性线程池中拉取工作者线程
                        .subscribeOn(Schedulers.boundedElastic()));

        // add a subscriber
        fruitFlux.subscribe(f -> log.info("Here's some fruit: {}", f));
    }


    @Test
    void create_buffer() {
        // publisher
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");

        Flux<List<String>> listFlux = fruitFlux.buffer(3);

        // add a subscriber
        listFlux.log().subscribe();
    }

}
