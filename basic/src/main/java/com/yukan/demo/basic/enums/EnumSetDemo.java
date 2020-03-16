package com.yukan.demo.basic.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.EnumSet;

/**
 * @author yukan
 * @date 2020/3/12
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class EnumSetDemo {

    public static void main(String[] args) {
        EnumSet<DemoEnum> enums = EnumSet.allOf(DemoEnum.class);
        log.info("{}", enums);

        EnumSet<DemoEnum> enums2 = EnumSet.noneOf(DemoEnum.class);
        enums2.add(DemoEnum.AAAAAAAAAA);
    }
}
