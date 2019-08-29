package com.yukan.demo.basic.jmm;

/**
 * @author yukan
 * @date 2019/8/27
 * @email yukan.cn.mail@gmail.com
 */
public class VolatileDemo extends Thread {

    private static boolean flag = false;
    //private volatile static boolean flag = false;

    @Override
    public void run() {
        double temp = 1;
        while (!flag){
            System.out.println(temp++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new VolatileDemo().start();
        sleep(100);
        flag = true;
    }
}
