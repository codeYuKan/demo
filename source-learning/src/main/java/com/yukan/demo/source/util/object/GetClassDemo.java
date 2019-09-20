package com.yukan.demo.source.util.object;

import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * @author yukan
 * @date 2019/9/20
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class GetClassDemo {

    public static void main(String[] args) {
        Class<?> strClazz = "str".getClass();
        // result:String.class.equals(strClazz).result:true
        log.info("String.class.equals(strClazz).result:{}", String.class.equals(strClazz));
        Number n = 1;
        Class<? extends Number> nClazz1 = n.getClass();
        Class<?> nClazz2 = n.getClass();
        // result:nClazz1=class java.lang.Integer,nClazz2=class java.lang.Integer
        // java中数值默认是Integer类型，所以getClass方法返回的是java.lang.Integer
        log.info("nClazz1={},nClazz2={}", nClazz1, nClazz2);
    }
}
