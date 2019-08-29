package com.yukan.demo.basic.jmm;

/**
 * @author yukan
 * @date 2019/8/27
 * @email yukan.cn.mail@gmail.com
 */
public class SynchronizedDemo {
    private static class Resource {
        public int value;
    }

    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();
    private Resource resourceC = new Resource();

    public int read() throws InterruptedException {
        synchronized (resourceA) {
            //System.out.println(1);
            Thread.sleep(100);
            //System.out.println(2);
            //resourceA = null;
            //resourceC = resourceA;
            synchronized (resourceB) {
                return resourceB.value + resourceA.value;
            }
        }
    }

    public void write(int a, int b) throws InterruptedException {
        synchronized (resourceB) {
            //System.out.println(11);
            Thread.sleep(200);
            //System.out.println(22);
            synchronized (resourceC) {
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        new Thread(()-> {
            try {
                demo.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                demo.write(1,2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
