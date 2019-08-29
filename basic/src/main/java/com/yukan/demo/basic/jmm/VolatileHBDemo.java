package com.yukan.demo.basic.jmm;

/**
 * @author yukan
 * @date 2019/8/28
 * @email yukan.cn.mail@gmail.com
 */
public class VolatileHBDemo {

    private int a = 0;
    private boolean flag = false;
    //volatile boolean flag = false;

    private void read(){
        if(flag){
            int i = a;
            if(i == 0){
                System.out.println(1);
            }
        }
    }

    private void write(){
        a = 1;
        flag = true;
    }

    public static void main(String[] args) {
        VolatileHBDemo demo = new VolatileHBDemo();
        while (true){
            new Thread(demo::write).start();
            new Thread(demo::read).start();
        }
    }
}
