package com.yukan.demo.springbootdemo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yukan
 * @date 2020/3/25
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
@Service
public class AsyncTestService {

    @Async
    public void testAsync() {
        log.info("1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("11");
    }

    public void testAsyn2() {
        log.info("2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("22");
    }
}
