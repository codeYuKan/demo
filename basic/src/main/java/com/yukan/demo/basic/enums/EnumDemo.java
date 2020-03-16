package com.yukan.demo.basic.enums;


import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2020/3/12
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class EnumDemo {

    public static void main(String[] args) {
        log.info("random:{}", Enums.random(DemoEnum.class));
    }


}
