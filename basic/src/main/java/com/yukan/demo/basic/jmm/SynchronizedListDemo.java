package com.yukan.demo.basic.jmm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yukan
 * @date 2019/8/28
 * @email yukan.cn.mail@gmail.com
 */
public class SynchronizedListDemo {
    private List<String> list = Collections.synchronizedList(new ArrayList<>());

    public void add(String str){
    //public synchronized void add(String str){
        list.add(str);
    }

    public  String removeFirst(){
    //public synchronized String removeFirst(){
        if(list.size() > 0) {
            try {
                System.out.println(1);
                Thread.sleep(100);
                System.out.println(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return list.remove(0);
        }
        System.out.println(3);
        return null;
    }

    public static void main(String[] args) {

        SynchronizedListDemo demo = new SynchronizedListDemo();
        demo.add("123");
        new Thread(demo::removeFirst).start();
        new Thread(demo::removeFirst).start();
    }


}
