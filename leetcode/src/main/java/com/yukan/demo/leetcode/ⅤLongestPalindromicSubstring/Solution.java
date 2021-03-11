package com.yukan.demo.leetcode.ⅤLongestPalindromicSubstring;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import sun.util.resources.in.CalendarData_in_ID;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * 5.最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author yukan
 * @date 2021/3/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Set<Integer>> charMap = new HashMap<>(chars.length);
        Set<Integer> integerSet;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            integerSet = charMap.get(c);
            if (Objects.isNull(integerSet)) {
                // LinkedHashSet是有序的
                Set<Integer> set = new LinkedHashSet<>();
                set.add(i);
                charMap.put(c, set);
            } else {
                integerSet.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int count = 1;
        int tmpCount;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            integerSet = charMap.get(c);
            if (integerSet.size() > 1) {
                // size大于1才有必要判断
                a:
                for (Integer endIndex : integerSet) {
                    /*
                    短路判断:长度是否超过现有第一
                     */
                    tmpCount = endIndex - i + 1;
                    if (tmpCount <= count) {
                        // 长度不超过现有则删除
                        continue;
                    }

                    /*
                    判断i到endIndex之间是否回文
                     */
                    // 三个数字或者两个数字 必定构成回文
                    if (tmpCount <= 3) {
                        // 判断是超过现有最长回文串
                        start = i;
                        end = endIndex;
                        count = tmpCount;
                        continue;
                    }
                    for (int x = i + 1, y = endIndex - 1; x <= y; x++, y--) {
                        if (chars[x] != chars[y]) {
                            // 不在则删除
                            continue a;
                        }
                    }
                    start = i;
                    end = endIndex;
                    count = tmpCount;
                }
            }
            // 判断完 删除
            integerSet.remove(i);
        }


        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
//        //longestPalindrome("124dascasfcaswdfr12rf");
//        //List<Integer> l = Stream.of(3).collect(Collectors.toList());
//        //l.remove(0);
//        //System.out.println(l.size());
//Set<Integer> set = Stream.of(2,5,6,6,3,4,5,6).collect(Collectors.toSet());
//        System.out.println(JSON.toJSONString(set));
//        set.remove(3);
//        System.out.println(JSON.toJSONString(set));

        System.out.println(longestPalindrome("sxxxrjgrirnkkiafhdlzirazovyyutbysmteztuhezmfmrxwbsklykwukesocrprvlezocszhmpmfakxjxawsxirefkhoalqmgwqqgeemdvjigvmtorzobfqnkqrdytydglfvcinnhagehieoxpvufeutlmcgcsplwnaqmrtqtmxyrf"));
    }
}
