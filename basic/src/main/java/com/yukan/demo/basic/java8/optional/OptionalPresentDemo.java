package com.yukan.demo.basic.java8.optional;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author yukan
 * @date 2020/9/21
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class OptionalPresentDemo {

    static void basic(Optional<String> stringOptional) {
        if (stringOptional.isPresent()) {
            log.info("{}", stringOptional.get());
        } else {
            log.info("nothing inside");
        }
    }

    static void ifPresent(Optional<String> stringOptional) {
        stringOptional.ifPresent(System.out::println);
    }

}
