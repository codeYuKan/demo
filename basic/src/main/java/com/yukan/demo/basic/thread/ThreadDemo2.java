package com.yukan.demo.basic.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/9/19
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ThreadDemo2 {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("thread.run");
            }
        }).start();
    }
}
