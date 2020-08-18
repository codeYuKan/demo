package com.yukan.demo.leetcode.ⅣMedianOfTwoSortedArrays;

import lombok.extern.slf4j.Slf4j;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yukan
 * @date 2020/8/18
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLength = nums1.length;
        int bLength = nums2.length;
        int length = aLength + bLength;
        int resultOffset = 0;
        boolean needDivide;
        if (length % 2 == 0) {
            resultOffset = length / 2;
            needDivide = true;
        } else {
            resultOffset = (length + 1) / 2;
            needDivide = false;
        }

        int aIndex = 0;
        int bIndex = 0;
        int aNum = nums1[aIndex];
        int bNum = nums2[bIndex];

        boolean aEnd = aIndex == aLength;
        boolean bEnd = bIndex == bLength;

        for(int i = 0; i < resultOffset - 1; i++) {
            if (aEnd) {
                // a已经全部被淘汰了

            }
            if (bEnd) {

            }

            if (aNum <= bNum) {
                aIndex++;
                aNum = nums1[aIndex];
                aEnd = aIndex + 1 == aLength;
            } else {
                bIndex++;
                bNum = nums2[bIndex];
                bEnd = bIndex + 1 == bLength;
            }
        }

        int divideTmp = 0;
        if (aNum <= bNum) {
            if (!needDivide) {
                return aNum;
            } else {
                divideTmp =+ aNum;
                aIndex++;
                aNum = nums1[aIndex];
                if (aNum <= bNum) {
                    divideTmp =+ aNum;
                } else {
                    divideTmp =+ bNum;
                }
                return (double) divideTmp / 2;
            }
        } else {
            if (!needDivide) {
                return bNum;
            } else {
                divideTmp =+ bNum;
                bIndex++;
                bNum = nums2[bIndex];
                if (aNum <= bNum) {
                    divideTmp =+ aNum;
                } else {
                    divideTmp =+ bNum;
                }
                return (double) divideTmp / 2;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
