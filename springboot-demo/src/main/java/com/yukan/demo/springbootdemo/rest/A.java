package com.yukan.demo.springbootdemo.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author yukan
 * @date 2021/5/15
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
@Service("a")
public class A {
    @Autowired
    private B b;

    public A() {
        System.out.println("A construct");
    }

    @PostConstruct
    public void init() {
        initA();
    }

    private void initA() {
        System.out.println("A init");
    }
}
