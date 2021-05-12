package com.yukan.demo.basic.util;

import com.yukan.demo.basic.uri.UriDownloadDemo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author yukan
 * @date 2021/4/28
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ClassUtilsDemo {

    public static void test1() throws ReflectiveOperationException {
        System.out.println(ClassUtils.getShortClassName(ClassUtilsDemo.class));
        System.out.println(ClassUtils.getShortCanonicalName(ClassUtilsDemo.class));
        ClassUtils.getPublicMethod(ClassUtilsDemo.class, "test1").invoke(null);
    }

    @SneakyThrows
    public static void main(String[] args) {
        test1();
    }
}
