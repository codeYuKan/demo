package com.yukan.demo.basic.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yukan
 * @date 2021/2/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class AtomicIntegerDemo {

    public static void test() throws InterruptedException {
        AtomicInteger ref = new AtomicInteger();

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(new AtomicIntegerDemo.Task(ref), "Thread-no" + i);
            list.add(t);
            t.start();
        }

        for (Thread t : list) {
            t.join();
        }

        System.out.println(ref.get());    // 打印2000
    }

    static class Task implements Runnable {
        private AtomicInteger ref;

        Task(AtomicInteger ref) {
            this.ref = ref;
        }

        @Override
        public void run() {
            for ( ; ;) {
                int a = ref.get();
                if (ref.compareAndSet(a, a+1)) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test();
    }
}
