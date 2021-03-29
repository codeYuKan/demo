package com.yukan.demo.leetcode.ⅩRegularExpressionMatching;

import lombok.extern.slf4j.Slf4j;

/**
 * 10. 正则表达式匹配
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 *  
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3：
 *
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 *
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 *
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yukan
 * @date 2021/3/24
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {

    public static boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        int sIndex = 0;
        int pIndex = 0;

        char firstChar;
        while (pIndex < pLength) {
            // 去除字符规律p的第一个字符
            firstChar = p.charAt(pIndex++);
            // pIndex != pLength表明后续还有，才能获取第二项，判断是否为*
            if (pIndex != pLength && p.charAt(pIndex) == '*') {
                for (int i = 0;i <= sLength - sIndex; i++) {
                    // 可匹配的数量从0个到剩余数量
                    if (i > 0 && firstChar != '.' && s.charAt(sIndex + i - 1) != firstChar) {
                        return false;
                    }
                    if (isMatch(s.substring(sIndex + i), p.substring(pIndex + 1))) {
                        return true;
                    }
                }
                return false;
            } else if (sIndex < sLength){
                if (firstChar != '.' && firstChar != s.charAt(sIndex)) {
                    return false;
                }
            } else {
                //sIndex越界
                return false;
            }
            sIndex++;
        }
        return sIndex == sLength;
    }

    public static void main(String[] args) {
        //System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("issippi", "is*p*."));
        //System.out.println(isMatch("ippi", "p*."));
    }
}
