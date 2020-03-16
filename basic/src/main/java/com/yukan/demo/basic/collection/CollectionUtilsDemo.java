package com.yukan.demo.basic.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yukan
 * @date 2019/12/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class CollectionUtilsDemo {

    public static List<String> list1 = new ArrayList<>(8);

    public static List<String> list2 = new ArrayList<>(8);
    static {
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");

        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("e");
        list2.add("f");
    }

    public void testUnion() {
    }
}
