package com.yukan.demo.reactive.webflux;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yukan
 * @date 2021/4/28
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
class FluxCreateDemo {

    private void fruitFluxVerify(Flux<String> fruitFlux) {
        StepVerifier.create(fruitFlux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    void create_just() {
        // publisher
        Flux<String> fruitFlux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");

        // add a subscriber
        fruitFlux.subscribe(f -> System.out.println("Here's some fruit: " + f));

        fruitFluxVerify(fruitFlux);
    }

    @Test
    void create_fromArray() {
        String[] fruitArr = new String[]{"Apple", "Orange", "Grape", "Banana", "Strawberry"};

        // publisher
        Flux<String> fruitFlux = Flux.fromArray(fruitArr);

        // add a subscriber
        fruitFlux.subscribe(f -> System.out.println("Here's some fruit: " + f));

        fruitFluxVerify(fruitFlux);
    }

    @Test
    void create_fromIterable() {
        String[] fruitArr = new String[]{"Apple", "Orange", "Grape", "Banana", "Strawberry"};
        List<String> fruitList = new ArrayList<>(Arrays.asList(fruitArr));

        // publisher
        Flux<String> fruitFlux = Flux.fromIterable(fruitList);

        // add a subscriber
        fruitFlux.subscribe(f -> System.out.println("Here's some fruit: " + f));

        fruitFluxVerify(fruitFlux);
    }

    @Test
    void create_fromStream() {
        String[] fruitArr = new String[]{"Apple", "Orange", "Grape", "Banana", "Strawberry"};

        // publisher
        Flux<String> fruitFlux = Flux.fromStream(Stream.of(fruitArr));

        //// add a subscriber Stream 没法使用两次 所以需注释
        //fruitFlux.subscribe(f -> System.out.println("Here's some fruit: " + f));

        fruitFluxVerify(fruitFlux);
    }

    @Test
    void create_range() {
        // publisher
        Flux<Integer> rangeFlux = Flux.range(1, 5);

        // add a subscriber
        rangeFlux.subscribe(i -> System.out.println("integer: " + i));
    }

    @Test
    void create_interval() {
        // publisher
        Flux<Long> rangeFlux = Flux.interval(Duration.ofMillis(1000))
                // 限制长度
                //.take(5)
                ;

        // add a subscriber
        rangeFlux.subscribe(i -> System.out.println("Long: " + i));

        while (true) {}
    }

    @Test
    void create_mergeWith() {
        String[] fruitArr1 = new String[]{"Apple1", "Orange1", "Grape1", "Banana1", "Strawberry1"};
        String[] fruitArr2 = new String[]{"Apple2", "Orange2", "Grape2", "Banana2", "Strawberry2"};

        // publisher
        Flux<String> fruitFlux1 = Flux.fromArray(fruitArr1)
                .delayElements(Duration.ofMillis(500));
        Flux<String> fruitFlux2 = Flux.fromArray(fruitArr2)
                .delayElements(Duration.ofMillis(300));

        Flux<String> fruitFlux = fruitFlux1.mergeWith(fruitFlux2);

        fruitFlux.subscribe(f -> log.info("Here's some fruit: {}",f));

        while (true) {}
    }

    @Test
    void create_zip() {
        String[] fruitArr1 = new String[]{"Apple1", "Orange1", "Grape1", "Banana1", "Strawberry1"};
        String[] fruitArr2 = new String[]{"Apple2", "Orange2", "Grape2"};

        // publisher
        Flux<String> fruitFlux1 = Flux.fromArray(fruitArr1);
        Flux<String> fruitFlux2 = Flux.fromArray(fruitArr2);

        // 两个数据源都有数据才结成一对 所以 min(5, 3) = 3, 结果是3个打印，并保持原顺序
        Flux<Tuple2<String, String>> fruitFlux = Flux.zip(fruitFlux1, fruitFlux2);

        fruitFlux.subscribe(f -> log.info("Here's some fruit: {} | {}", f.getT1(), f.getT2()));

        while (true) {}
    }

    @Test
    void create_firstWithSignal() {
        String[] fruitArr1 = new String[]{"Apple1", "Orange1", "Grape1", "Banana1", "Strawberry1"};
        String[] fruitArr2 = new String[]{"Apple2", "Orange2", "Grape2", "Banana2", "Strawberry2"};

        // publisher
        Flux<String> fruitFlux1 = Flux.fromArray(fruitArr1).delayElements(Duration.ofMillis(100));
        Flux<String> fruitFlux2 = Flux.fromArray(fruitArr2);

        // 选择first flux(会丢弃第二个)，只会打印first
        Flux<String> fruitFlux = Flux.firstWithSignal(fruitFlux1, fruitFlux2);

        fruitFlux.subscribe(f -> log.info("Here's some fruit: {}", f));

        while (true) {}
    }

    @Test
    void create_skiptake() {
        String[] fruitArr1 = new String[]{"Apple1", "Orange1", "Grape1", "Banana1", "Strawberry1"};

        // publisher
        // 跳过前三个  还可以从时间角度
        Flux<String> fruitFlux = Flux.fromArray(fruitArr1).skip(3);
        // 取前三个
        Flux<String> fruitFlux2 = Flux.fromArray(fruitArr1).take(3);

        fruitFlux.subscribe(f -> log.info("Here's some fruit: {}", f));

    }

    @Test
    void create_filter() {
        String[] fruitArr1 = new String[]{"Apple1", "Orange1", "Grape1", "Banana1", "Strawberry1"};

        // publisher
        Flux<String> fruitFlux = Flux.fromArray(fruitArr1).filter(s -> s.length() > 5);

        fruitFlux.subscribe(f -> log.info("Here's some fruit: {}", f));

    }

    @Test
    void create_distinct() {
        String[] fruitArr1 = new String[]{"Apple1", "Apple1", "Orange1", "Grape1", "Banana1", "Strawberry1"};

        // publisher
        Flux<String> fruitFlux = Flux.fromArray(fruitArr1).distinct();

        fruitFlux.subscribe(f -> log.info("Here's some fruit: {}", f));

    }
}
