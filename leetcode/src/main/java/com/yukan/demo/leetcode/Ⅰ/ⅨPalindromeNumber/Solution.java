package com.yukan.demo.leetcode.Ⅰ.ⅨPalindromeNumber;

import lombok.extern.slf4j.Slf4j;

/**
 * 9. 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yukan
 * @date 2021/3/23
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * official solution
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }

        return x == y || x == y / 10;
    }

    public static void main(String[] args) {
        log.info("xx");
        Long s = System.currentTimeMillis();
        System.out.println(isPalindrome2(3123213));
        System.out.println(isPalindrome2(2));
        System.out.println(isPalindrome2(-101));
        System.out.println(isPalindrome2(3));
        Long e = System.currentTimeMillis();
        log.info("xx{}", e - s);
    }
}
