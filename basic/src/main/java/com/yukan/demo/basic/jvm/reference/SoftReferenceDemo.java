package com.yukan.demo.basic.jvm.reference;

import java.lang.ref.SoftReference;

/**
 * @author yukan
 * @date 2019/9/24
 * @email yukan.cn.mail@gmail.com
 */
public class SoftReferenceDemo {

    public void test1() {
        // strong reference
        String strongStr = "str";
        // soft reference
        String str = "str";
        SoftReference<String> stringSoftReference = new SoftReference<>(str);

        /**
         * gc demo
         * @see com.yukan.demo.source.lang.object.FinalizeDemo
         */
    }
}
