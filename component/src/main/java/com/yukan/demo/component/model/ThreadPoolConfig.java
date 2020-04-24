package com.yukan.demo.component.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author yukan
 * @date 2020/3/27
 * @email yukan.cn.mail@gmail.com
 */
public class ThreadPoolConfig {

    private int corePoolSize;

    private int maximumPoolSize;

    private long keepAliveTime;

    private TimeUnit unit;

    private BlockingQueue<Runnable> workQueue;

    private ThreadFactory threadFactory;

    private RejectedExecutionHandler handler;

}
