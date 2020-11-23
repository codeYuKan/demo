package com.yukan.demo.reactive.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.util.TestLogger;

/**
 * @author yukan
 * @date 2020/11/18
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StepVerifierDemo {

    public static void test1() {
        StepVerifier.create(Flux.just("a", "b"))
                .expectNext("a")
                .expectNext("b")
                .verifyComplete();
    }

    public static void main(String[] args) {
        test1();
    }
}
