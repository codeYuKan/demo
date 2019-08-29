package com.yukan.demo.basic.array;

/**
 * @author yukan
 * @date 2019/8/29
 * @email yukan.cn.mail@gmail.com
 */
public class ArrayTypeDemo {

    public static void main(String[] args) {
        int[] iArr = new int[3];
        iArr[0] = 1;

        if(iArr instanceof Object){
            System.out.println(1);
        }
        System.out.println(iArr);
    }
}
