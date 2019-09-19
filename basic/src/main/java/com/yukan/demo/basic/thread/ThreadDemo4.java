package com.yukan.demo.basic.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/19
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ThreadDemo4 {

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
         * 线程的状态：
         * 创建（new）状态: 准备好了一个多线程的对象
         * 就绪（runnable）状态: 调用了 start() 方法, 等待 cpu 进行调度
         * 运行（running）状态: 执行 run() 方法
         * 阻塞（blocked）状态: 暂时停止执行, 可能将资源交给其它线程使用
         * 终止（dead）状态: 线程销毁
         */
        /**
         * 通过start方法，启动一个新线程(就绪状态)，等待cpu去调度执行对应的run方法
         *
         * start方法只能被调用一次,否则会抛出异常
         *  Exception in thread "main" java.lang.IllegalThreadStateException
         * 	at java.lang.Thread.start(Thread.java:708)
         * 	at com.yukan.demo.basic.thread.ThreadDemo4.main(ThreadDemo4.java:xxx)
         *
         */
        t1.start();
        //t1.start();
        t2.start();

    }
}
