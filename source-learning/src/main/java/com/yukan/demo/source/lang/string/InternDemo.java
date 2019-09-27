package com.yukan.demo.source.lang.string;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * @author yukan
 * @date 2019/9/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class InternDemo {

    /**
     * str1 == str1.intern():true   这个字符串第一次出现，所以常量池中记录了该字符串的引用，直接引用str1(JDK1.7以后才这样，
     *      JDK1.6中，intern方法会将首次出现的字符串实例复制到永久代中，与new出来的在堆上的实例必然不是同一个引用)
     * str2 == str2.intern():false  因为java这个字符串在之前已经添加到常量池中了，所以new出来的和常量池中的不一致
     * str3 == str1.intern():false  因为之前str1那部分已经将该字符串常量... 同str2
     * str4 == str1.intern():false  同str2
     * str5 == str1.intern():true   这种形式的定义会直接从常量池中获取，所以为true
     * str6 == str1.intern():false  通str2
     */
    private static void test(){
        //String java = "java";
        String str1 = new StringBuilder().append("测试").append("java").toString();
        log.info("str1 == str1.intern():{}", str1 == str1.intern());
        String str2 = new StringBuilder().append("ja").append("va").toString();
        log.info("str2 == str2.intern():{}", str2 == str2.intern());
        String str3 = new StringBuilder().append("测试").append("java").toString();
        log.info("str3 == str1.intern():{}", str3 == str1.intern());
        String str4 = new StringBuilder().append("测试java").toString();
        log.info("str4 == str1.intern():{}", str4 == str1.intern());
        String str5 = "测试java";
        log.info("str5 == str1.intern():{}", str5 == str1.intern());
        String str6 = new String("测试java");
        log.info("str6 == str1.intern():{}", str6 == str1.intern());
    }

    private static final int MAX = 1000 * 10000;

    private static final String[] arr = new String[MAX];

    private static void test2(){
        Integer[] baseData = new Integer[10];
        Random random = new Random(10 * 10000);
        for (int i = 0; i < baseData.length; i++) {
            baseData[i] = random.nextInt();
        }

        for (int j = 0; j < arr.length; j++) {

        }
    }

    public static void main(String[] args) {
        test();
    }
}
