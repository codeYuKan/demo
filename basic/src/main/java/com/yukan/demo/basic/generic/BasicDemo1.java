package com.yukan.demo.basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型(generic)基本知识
 *
 * @author yukan
 * @date 2019/9/16
 * @email yukan.cn.mail@gmail.com
 */
public class BasicDemo1<T extends Number> {

    // 指定集合元素只能是T类型
    List<T> list1 = new ArrayList<>();
    // 集合元素可以是任何类型，这种没有任何意思，一般是在方法中，只是为了说明用法
    List<?> list2 = new ArrayList<>();

    Class clazz1;

    Class<?> clazz2;

    Class<T> clazz3;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        BasicDemo1<Integer> basicDemo = new BasicDemo1<>();
        basicDemo.clazz1.newInstance();
    }
}
