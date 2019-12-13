package com.yukan.demo.basic.regex;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * @author yukan
 * @date 2019/11/15
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class RegexDemo1 {

    /**
     * 字符串分割
     *
     * @param str 待分割的字符串
     */
    private static void splitTest(String str){
        String regex = "[+*-/]";
        String regex2 = "[+*/-]";
        String regex3 = "[+\\-*/]";
        String regex4 = "[-+*/]";
        /*
        \ 在java中和regex中都是转义字符
        四个\ 前两个表示regex的转义符
        后两个表示真实的 \
        java的\\\\就形成了regex的\\就是一个\
         */
        String regex5 = "[-+*/\\\\]";
        Pattern pattern = Pattern.compile(regex);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);
        Pattern pattern4 = Pattern.compile(regex4);
        Pattern pattern5 = Pattern.compile(regex5);
        String[] nums = pattern.split(str);
        String[] nums2 = pattern2.split(str);
        String[] nums3 = pattern3.split(str);
        String[] nums4 = pattern4.split(str);
        String[] nums5 = pattern5.split(str);
        // limit 表示要分成的段数
        String[] nums6 = pattern5.split(str, 2);

        System.out.print("1: ");
        for (String num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("2: ");
        for (String num : nums2) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("3: ");
        for (String num : nums3) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("4: ");
        for (String num : nums4) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("5: ");
        for (String num : nums5) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("6: ");
        for (String num : nums6) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        splitTest("13+29-44*55/22");
        splitTest("13+29-44*55/22\\55");
        splitTest("13+29-4--4*55/22");
    }
}
