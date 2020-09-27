package com.yukan.demo.basic.exception;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author yukan
 * @date 2020/9/25
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ExceptionMethodDemo {

    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch(Exception e) {
            System.out.println("Caught Exception");
            System.out.println(
                    "getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" +
                    e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
            System.out.println("e.getStackTrace():" + Arrays.toString(e.getStackTrace()));
        }
    }
}
