package com.yukan.demo.basic.collection.list;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yukan
 * @date 2020/12/30
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class CompareTwoListDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add("test" + i);
            list1.add("test" + (i * 2));
        }
        System.out.println(checkDiffrent(list, list1));
    }

    /**
     * 方法一：使用循环遍历
     */
    private static boolean checkDiffrent(List<String> list, List<String> list1) {
        long st = System.nanoTime();
        if (list.size() != list1.size()) {
            System.out.println("消耗时间：" + (System.nanoTime() - st));
            return false;
        }
        for (String str : list) {
            if (!list1.contains(str)) {
                System.out.println("消耗时间：" + (System.nanoTime() - st));
                return false;
            }
        }
        System.out.println("消耗时间：" + (System.nanoTime() - st));
        return true;
    }

    /**
     * 方法2：利用List的 retainAll的方法进行判断
     */
    private static boolean checkDiffrent1(List<String> list, List<String> list1) {
        long st = System.nanoTime();
        System.out.println("消耗时间为：" + (System.nanoTime() - st));
        return !list.retainAll(list1);
    }

    /**
     * 方法3
     * 利用HashMap key唯一，value可以重复的特点，把list中各种元素放到hashMap中
     */
    private static boolean checkDiffrent2(List<String> list, List<String> list1) {
        long st = System.nanoTime();
        Map<String, Integer> map = new HashMap<>(list.size() + list1.size());
        if (list.size() != list1.size()) {
            System.out.println("消耗时间为： " + (System.nanoTime() - st));
            return false;
        }
        for (String str : list) {
            map.put(str, 1);
        }
        for (String str : list1) {
            Integer cc = map.get(str);
            if (null != cc) {
                continue;
            }
            System.out.println("消耗时间为： " + (System.nanoTime() - st));
            return false;
        }
        System.out.println("消耗时间为： " + (System.nanoTime() - st));
        return true;
    }

    /**
     * md5加密法使用
     * 方法4
     */
    //private static boolean getDiffrent3(List<String> list, List<String> list1) {
    //    long st = System.nanoTime();
    //    /** 使用Security的md5方法进行加密 */
    //    String str = SecureUtil.md5(list.toString());
    //    String str1 = SecureUtil.md5(list1.toString());
    //    System.out.println("消耗时间为： " + (System.nanoTime() - st));
    //    return str.equals(str1);
    //}

    /**
     * 使用stream流去比较两个数组是否相等
     * 方法5
     */
    private static boolean checkDiffrent4(List<String> list, List<String> list1) {
        long st = System.nanoTime();
        System.out.println("消耗时间为： " + (System.nanoTime() - st));
        /** 先将集合转成stream流进行排序然后转成字符串进行比较 */
        return list.stream().sorted().collect(Collectors.joining())
                .equals(list1.stream().sorted().collect(Collectors.joining()));
    }

    /**
     * 使用list自带的sort方法先进性排序，然后转成toString去判断两个集合是否相等
     * 方法6
     */
    private static boolean checkDiffrent5(List<String> list, List<String> list1) {
        long st = System.nanoTime();
        System.out.println("消耗时间为： " + (System.nanoTime() - st));
        list.sort(Comparator.comparing(String::hashCode));
        list1.sort(Comparator.comparing(String::hashCode));
        return list.toString().equals(list1.toString());
    }
}
