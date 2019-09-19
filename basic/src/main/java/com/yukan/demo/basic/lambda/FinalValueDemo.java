package com.yukan.demo.basic.lambda;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yukan
 * @date 2019/9/11
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FinalValueDemo {

    public static void main(String[] args) {

        //String a = "123";
        //
        //Class clazz = new Class();
        //clazz.setName("测试");
        //
        //Runnable runnable = () -> {
        //    log.info("clazz={}", clazz);
        //    //a = "333";
        //    String b = a;
        //    b = "333";
        //    log.info("a={},b={}", a, b);
        //};

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10000 ;i++) {
            list.add(i);
        }
        int sum = list.stream().mapToInt(i -> {
            log.info("i={}", i);
            return i;
        }).sum();
    }
}
