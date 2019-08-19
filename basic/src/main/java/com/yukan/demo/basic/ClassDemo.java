package com.yukan.demo.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukan
 * @date 2019/8/19
 * @email yukan.cn.mail@gmail.com
 */
public class ClassDemo {

    public static void main(String[] args) {

        Map map = new HashMap<String, String>(8);
        map.put("123", "31234");
        Class clazz = map.getClass();
        System.out.println("getPackage:" + clazz.getPackage());
        System.out.println(clazz.getName());
        System.out.println(clazz.getAnnotations());
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getClasses());
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getComponentType());
        System.out.println(clazz.getConstructors());
        System.out.println(clazz.getDeclaredAnnotations());
        System.out.println(clazz.getDeclaredClasses());
        System.out.println(clazz.getDeclaredClasses());
        System.out.println(clazz.getDeclaredConstructors());
        System.out.println(clazz.getDeclaredFields());
        System.out.println(clazz.getDeclaredMethods());
        System.out.println(clazz.getEnclosingClass());
        System.out.println(clazz.getEnclosingMethod());
        System.out.println(clazz.getEnclosingConstructor());
        System.out.println(clazz.getEnumConstants());
        System.out.println(clazz.getFields());
        System.out.println("getGenericInterfaces:" + clazz.getGenericInterfaces());
        System.out.println(clazz.getGenericSuperclass());
        System.out.println(clazz.getInterfaces());
        System.out.println(clazz.getMethods());
        System.out.println(clazz.getModifiers());
        System.out.println(clazz.getProtectionDomain());
        System.out.println(clazz.getSigners());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getTypeParameters());
        System.out.println(clazz.getAnnotatedInterfaces());
        System.out.println(clazz.getAnnotatedSuperclass());
    }
}
