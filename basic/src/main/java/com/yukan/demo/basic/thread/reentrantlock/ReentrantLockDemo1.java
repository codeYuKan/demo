package com.yukan.demo.basic.thread.reentrantlock;

/**
 * @author yukan
 * @date 2020/5/22
 * @email yukan.cn.mail@gmail.com
 */
public class ReentrantLockDemo1 {

    public static abstract class BaseMerchant implements Runnable {
        protected volatile long revenueToday = 0;

        public long getRevenueToday() {
            //商家日营业额统计
            return revenueToday;
        }
    }

    //外卖商家
    public static class MerchantRunnableUnsafe extends BaseMerchant {
        @Override
        public void run() {
            try {
                Thread.sleep(1);//耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             revenueToday = revenueToday + 10;
            //long temp = revenueToday;
            //long update = temp + 10;
            //revenueToday = update;
            System.out.println(Thread.currentThread().getName() + " revenueToday:" + revenueToday);
        }
    }

    public static void main(String[] arg) throws InterruptedException{
        //外卖商家
        BaseMerchant merchantRunnable = new MerchantRunnableUnsafe();
        //模拟1000个用户
        for (int i = 0; i < 5000; i++) {
            Thread client = new Thread(merchantRunnable);
            client.setName("Client-" + i);
            client.start();
        }

        Thread.sleep(2000);
        System.out.println("今天的营业额是 " + merchantRunnable.getRevenueToday());
    }


}
