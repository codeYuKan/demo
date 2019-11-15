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
        Thread t3 = new Thread();
        Thread[] tl = new Thread[1];
        tl[0] = t3;
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                try {
                    tl[0].join(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("thread1.run{}", i);
            }
        });
        tl[0] = t1;
        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 100) {
                log.info("thread2.run{}", i);
            }
        });
        t1.start();
        /**
         * join()方法，会等待直到线程t1执行结束
         *
         * 当前线程在判断目标线程是否存活，如果存活根据参数的值，
         * 是无限等待到目标线程结束才执行当前线程，还是执行一段时间就开始执行当前线程。
         */
        log.info("1");
        t1.join(3000);
        log.info("1");
        t2.start();

    }
}
