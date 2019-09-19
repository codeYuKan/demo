package com.yukan.demo.basic.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/19
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ThreadDemo5 {

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
        t1.start();
        /**
         * join()方法，会等待直到线程t1执行结束
         */
        t1.join();
        t2.start();

    }
}
