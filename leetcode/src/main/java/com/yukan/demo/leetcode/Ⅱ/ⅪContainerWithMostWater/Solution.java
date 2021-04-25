package com.yukan.demo.leetcode.Ⅱ.ⅪContainerWithMostWater;

import lombok.extern.slf4j.Slf4j;

/**
 * 11. 盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 *
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 *
 * 输入：height = [1,2,1]
 * 输出：2
 *  
 *
 * 提示：
 *
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yukan
 * @date 2021/3/30
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {

    public static int maxArea(int[] height) {
        // 初始值取最左最右
        int max = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
        int tmp;

        // lTmp记左边起最大值
        int lHeight = height[0];

        for (int i = 0; i < height.length - 1; i++) {
            if (i != 0 && height[i] <= lHeight) {
                continue;
            }
            lHeight = height[i];

            // rTmp记从右起最大值
            for (int j = height.length - 1, rHeight = height[j]; j > i; j--) {
                if (height[j] >= lHeight) {
                    // 计算一次
                    tmp = lHeight * (j - i);
                    if (tmp > max) {
                        max = tmp;
                    }
                    break;
                }

                if (j != height.length - 1 && height[j] <= rHeight) {
                    continue;
                }
                rHeight = height[j];

                // 计算一次
                tmp = rHeight * (j - i);
                if (tmp > max) {
                    max = tmp;
                }
            }
        }

        return max;
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int tmp;

        // 从两侧同时往里缩进，缩进矮的一边(矮的一边已经决定了面积上限[矮边的高度*宽度])，只有缩进矮边才能获得larger area
        for (int i = 0, j = height.length - 1; i < j;) {
            if (height[i] <= height[j]) {
                tmp = i;
                maxArea = Math.max(height[i] * (j - i++), maxArea);
                while (height[i] < height[tmp]) {
                    i++;
                    if (i == j) {
                        break;
                    }
                }
            } else {
                tmp = j;
                maxArea = Math.max(height[j] * (j-- - i), maxArea);
                while (height[j] < height[tmp]) {
                    j--;
                    if (i == j) {
                        break;
                    }
                }
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {10,9,8,7,6,5,4,3,2,1};
        System.out.println(maxArea2(height));
    }
}
