package com.yukan.demo.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukan
 * @date 2019/8/19
 * @email yukan.cn.mail@gmail.com
 */
public class HashCodeDemo {

    public static void main(String[] args) {

        Map a = new HashMap<String, String>(8);
        a.put("123", "64zxdjnhlifvejhao8wij9803q2FJ23OJFOI23OF23F23");

        String b = "123";
        Integer c = 123;
        int intb;
        System.out.println((intb = b.hashCode()) ^ (intb >>> 16));
        System.out.println(a.hashCode());
        System.out.println((a.hashCode() >>> 16) ^ a.hashCode());
        System.out.println(b.hashCode());
        System.out.println((b.hashCode() >>> 16) ^ b.hashCode());
        System.out.println(c.hashCode());
        System.out.println((c.hashCode() >>> 16) ^ c.hashCode());
    }
}
