package com.yukan.demo.leetcode.Ⅰ.ⅢLongestSubstringWithoutRepeatingCharacters;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Objects;

/**
 * 3.给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author yukan
 * @date 2020/8/12
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> indexMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int tempLength = 0;
        int tempIndex;
        char tempChar;
        String tempStr = "";
        int duplicateIndex;
        String tempRemoveStr = "";

        for (int i = 0; i < chars.length; i++) {
            tempChar = chars[i];
            if(Objects.isNull(indexMap.get(tempChar))) {
                tempLength++;
                tempStr = tempStr + tempChar;
                indexMap.put(tempChar, i);
            } else {
                tempIndex = indexMap.get(tempChar);

                duplicateIndex = tempStr.indexOf(tempChar);
                tempRemoveStr = tempStr.substring(0, duplicateIndex + 1);
                for (char c : tempRemoveStr.toCharArray()) {
                    indexMap.remove(c);
                }
                tempStr = tempStr.substring(duplicateIndex + 1) + tempChar;


                indexMap.put(tempChar, i);
                tempLength = i - tempIndex;
            }
            if(tempLength > maxLength) {
                maxLength = tempLength;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

        //String tempStr = "asdfgh";
        //byte tempByte = 'f';
        //System.out.println(tempStr.substring(0, tempStr.indexOf(tempByte)));
        //System.out.println(tempStr.substring(tempStr.indexOf(tempByte)));
    }
}