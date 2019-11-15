package com.yukan.demo.basic.dynamicproxy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/11/13
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
@AllArgsConstructor
public class ZhangSan implements Person {

    private String name;

    private String house;

    @Override
    public void buy() {
        log.info("{} buy {}", name, house);
    }

    @Override
    public void buy1() {
        log.info("zzzZZZ......");
    }
}
