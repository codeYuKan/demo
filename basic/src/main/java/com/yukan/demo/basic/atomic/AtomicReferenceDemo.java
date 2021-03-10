package com.yukan.demo.basic.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yukan
 * @date 2021/2/22
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class AtomicReferenceDemo {

    public static void test1() {
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("xxx");
        log.info("xxx:{}", atomicReference.get());

        boolean result = atomicReference.compareAndSet("xxx", "ttt");
        log.info("result:{}|||atomicReference:{}", result, atomicReference.get());
        result = atomicReference.compareAndSet("xxx", "ttt2");
        log.info("result:{}|||atomicReference:{}", result, atomicReference.get());
    }

    public static void test2() throws InterruptedException {
        AtomicReference<Integer> ref = new AtomicReference<>(new Integer(0));

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(new Task(ref), "Thread-no" + i);
            list.add(t);
            t.start();
        }

        for (Thread t : list) {
            t.join();
        }

        System.out.println(ref.get());    // 打印2000
    }

    static class Task implements Runnable {
        private AtomicReference<Integer> ref;

        Task(AtomicReference<Integer> ref) {
            this.ref = ref;
        }

        @Override
        public void run() {
            for (; ; ) {    //自旋操作
                log.info("{}", Thread.currentThread().getName());
                Integer oldV = ref.get();
                if (ref.compareAndSet(oldV, oldV + 1))  // CAS操作
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test2();
    }
}
