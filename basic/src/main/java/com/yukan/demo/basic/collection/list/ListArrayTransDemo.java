package com.yukan.demo.basic.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yukan
 * @date 2021/4/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ListArrayTransDemo {

    public static void list2Arr(List<String> list) {
        String[] arr1 = (String[]) list.toArray();
        // this is better
        String[] arr2 = list.toArray(new String[0]);
        String[] arr3 = list.toArray(new String[0]);
    }

    public static void arr2List(String[] arr) {
        List<String> list1 = Stream.of(arr).collect(Collectors.toList());
        // avoid this | return inner class [java.util.Arrays.ArrayList] not [java.util.ArrayList]
        List<String> list2 = Arrays.asList(arr);
        List<String> list3 = new ArrayList<>(Arrays.asList(arr));
        List<String> list4 = new ArrayList<>(arr.length);
        Collections.addAll(list4, arr);
    }
}
