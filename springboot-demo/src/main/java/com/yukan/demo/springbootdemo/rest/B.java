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
@Service("b")
public class B  {
    @Autowired
    private A a;

    public B() {
        System.out.println("B construct");
    }

    @PostConstruct
    public void init() {
        initB();
    }

    private void initB(){
        System.out.println("B init");
    }
}