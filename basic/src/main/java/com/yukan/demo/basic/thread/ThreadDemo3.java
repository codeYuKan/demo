package com.yukan.demo.basic.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/19
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ThreadDemo3 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                log.info("thread1.run{}", i);
            }
        });
        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                log.info("thread2.run{}", i);
            }
        });
        /**
         * main线程直接调用run方法
         * 就和调用普通的方法没什么区别，直接顺序执行
         */
        t1.run();
        t2.run();

    }
}
