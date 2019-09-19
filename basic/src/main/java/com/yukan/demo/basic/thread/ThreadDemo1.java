package com.yukan.demo.basic.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/19
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ThreadDemo1 extends Thread {

    @Override
    public void run() {
        log.info("ThreadDemo1.run");
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        threadDemo1.start();
    }
}
