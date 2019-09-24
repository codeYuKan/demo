package com.yukan.demo.basic.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class WaitNotifyDemo3 {

    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                try {
                    log.info("Thread1 begin");
                    Thread.sleep(100);
                    log.info("Thread1 sleep end and wait");
                    // wait放弃锁并挂起自己
                    lock.wait();
                    log.info("Thread1 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread 1").start();


        new Thread(() ->  {
            log.info("Thread2 begin and waiting for lock");
            try {
                log.info("Thread2 get lock");
                Thread.sleep(200);
                log.info("Thread2 sleep end and notify");
                // 没有notify会导致Thread1 一直在等待
                // wait and notify/notifyAll must be in synchronized block
                lock.notify();
                Thread.sleep(200);
                log.info("Thread2 end and notify");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread 2").start();
    }

}
