package com.yukan.demo.component.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yukan
 * @date 2020/3/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ThreadPoolUtil {

    public ExecutorService newFixedThreadPool(int nThreads) {
        //return Executors.newFixedThreadPool(nThreads);
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }


}
