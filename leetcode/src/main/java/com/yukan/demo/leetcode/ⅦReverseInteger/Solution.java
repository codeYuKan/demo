package com.yukan.demo.leetcode.ⅦReverseInteger;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 7.整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yukan
 * @date 2021/3/20
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {

    public static int reverse(int x) {
        //int a;
        //boolean signFlag = true;
        //if (x < 0) {
        //    a = -x;
        //    signFlag = false;
        //}
        //a = x;
        //char[] chars = String.valueOf(a).toCharArray();
        //char[] result = new char[chars.length];
        //for (int i = chars.length - 1, j = 0; i >= 0 ; i--, j++) {
        //    result[j] =  chars[i];
        //}
        //String reverseStr = String.valueOf(result);
        //if (reverseStr)
        //int reverse = Integer.parseInt(reverseStr);
        //return signFlag ? reverse : -reverse;

        int result = 0;
        while (x != 0) {
            if (result * 10 / 10 != result) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        //int a = 2141241241;
        //log.info("{}", a);
        //char[] chars = String.valueOf(a).toCharArray();
        //char[] result = new char[chars.length];
        //for (int i = chars.length - 1, j = 0; i >= 0 ; i--, j++) {
        //    result[j] =  chars[i];
        //}
        //log.info("{}", String.valueOf(result));
        log.info("{}", reverse(-1257891202));


        System.out.println(10E3);
    }
}
