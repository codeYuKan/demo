package com.yukan.demo.leetcode.Ⅰ.ⅥZigzagConversion;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 6.Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author yukan
 * @date 2021/3/12
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 分组后的大小
        int size = numRows * 2 - 2;
        // 除了1和numRows之外的每对值的和
        int sum = size;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        /*
         生成组序列
         */
        List<List<Integer>> listSequence = new ArrayList<>();
        List<Integer> integerList;
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                // 第一行只有1个数字
                listSequence.add(Collections.singletonList(0));
                continue;
            } else if (i == numRows - 1) {
                // 最后一行只有1个数字
                listSequence.add(Collections.singletonList(numRows - 1));
                continue;
            }
            integerList = new ArrayList<>();
            integerList.add(i);
            integerList.add(sum - i);
            listSequence.add(integerList);
        }

        StringBuilder resultBuilder = new StringBuilder();
        /*
        根据组序列生成
         */
        int index;
        for (List<Integer> integers : listSequence) {
            index = 0;
            if (integers.size() == 1) {
                // 直接循环遍历累加
                index = integers.get(0);
                while (index < length) {
                    resultBuilder.append(charArray[index]);
                    index += size;
                }
            } else {
                int count = 0;
                while (index < length) {
                    for (Integer integer : integers) {
                        index = integer + count * size;
                        if (index < length) {
                            resultBuilder.append(charArray[index]);
                        } else {
                            break;
                        }
                    }
                    count++;
                }
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        log.info("{}", convert("AB", 1));
    }
}
