package com.yukan.demo.basic.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class WaitNotifyDemo {

    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        log.info("Thread1 begin");
                        Thread.sleep(100);
                        log.info("Thread1 sleep end and wait");
                        lock.wait();
                        log.info("Thread1 wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread 1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("Thread2 begin and waiting for lock");
                synchronized (lock) {
                    try {
                        log.info("Thread2 get lock");
                        Thread.sleep(100);
                        log.info("Thread2 sleep end and wait");
                        lock.notify();
                        log.info("Thread2 wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Thread 2").start();
    }


}
