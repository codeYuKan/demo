package com.yukan.demo.leetcode.ⅤLongestPalindromicSubstring;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

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
        Map<Character, List<Integer>> charMap = new HashMap<>(chars.length);
        List<Integer> tempIList;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            tempIList = charMap.get(c);
            if (Objects.isNull(tempIList)) {
                // 第一次遇到
                //List<Integer> l = new LinkedList<>();
                //l.add(i);
                charMap.put(c, Stream.of(i).collect(Collectors.toList()));
            } else {
                tempIList.add(i);
            }
        }
        log.info("{}", JSON.toJSONString(charMap));

        int start = 0;
        int end = 0;
        int count = 1;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            tempIList = charMap.get(c);
            if (tempIList.size() <= 1) {
                // 没有可能构成回文
                break;
            } else {
                Iterator<Integer> iterator = tempIList.iterator();
                iterator.next();
                while (iterator.hasNext()) {

                }
                //for (int j = 1; j < tempIList.size(); j++) {
                //    int endIndex = tempIList.get(j);
                //    // 判断在i到endIndex之间
                //
                //
                //    // 不在则删除
                //    tempIList.remove(j);
                //}


            }
            // 不在则删除
            tempIList.remove(0);
        }


        return s;
    }

    public static void main(String[] args) {
        //longestPalindrome("124dascasfcaswdfr12rf");
        //List<Integer> l = Stream.of(3).collect(Collectors.toList());
        //l.remove(0);
        //System.out.println(l.size());

    }
}
