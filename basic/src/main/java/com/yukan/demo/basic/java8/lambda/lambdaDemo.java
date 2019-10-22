package com.yukan.demo.basic.java8.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.function.Supplier;

/**
 * @author yukan
 * @date 2019/10/16
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class lambdaDemo {

    Supplier supplier = HashMap::new;
}