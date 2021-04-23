package com.yukan.demo.leetcode.Ⅰ.ⅣMedianOfTwoSortedArrays;

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

    private static double getResult (int a, int b) {
        if (needDivide) {
            return (double) (a + b) / 2;
        } else {
            return Math.max(a, b);
        }
    }

    private static double getResult (int a1, int a2, int b1, int b2) {
        if (b2 >= a1) {
            if (a2 >= b1) {
                return getResult(a2, b2);
            } else {
                return getResult(b1, b2);
            }
        } else {
            return getResult(a1, a2);
        }
    }

    private static boolean needDivide;

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLength = nums1.length;
        int bLength = nums2.length;
        int length = aLength + bLength;
        int leftNum;
        //boolean needDivide;
        if (length % 2 == 0) {
            // 偶数
            leftNum = (length + 2) / 2;
            needDivide = true;
        } else {
            // 奇数
            leftNum = (length + 1) / 2;
            needDivide = false;
        }

        if (aLength == 0) {
            if (needDivide) {
                return (double) (nums2[leftNum - 1] + nums2[leftNum - 2]) / 2;
            } else {
                return nums2[leftNum - 1];
            }
        }
        if (bLength == 0) {
            if (needDivide) {
                return (double) (nums1[leftNum - 1] + nums1[leftNum - 2]) / 2;
            } else {
                return nums1[leftNum - 1];
            }
        }
        if (aLength == 1 && bLength == 1) {
            return (double) (nums1[0] + nums2[0]) / 2;
        }

        if (aLength < bLength) {
            int aIndex = aLength - 1;
            int bIndex = leftNum - aIndex - 1;
            int aNum = nums1[aIndex];
            int bNum = nums2[bIndex];

            if (aNum <= bNum) {
                if (aLength == 1) {
                    if (bIndex == 1) {
                        return getResult(aNum, nums2[bIndex - 1]);
                    }
                    return getResult(Math.max(aNum, nums2[bIndex - 2]), nums2[bIndex - 1]);
                } else if (bIndex == 1) {
                    return getResult(Math.max(nums2[bIndex - 1], nums1[aIndex - 1]), aNum);
                }
                return getResult(nums1[aIndex - 1], aNum, nums2[bIndex - 2], nums2[bIndex - 1]);
                //return getResult(aNum, Math.max(nums1[aIndex - 1], nums2[bIndex - 1]));
            }
            while (aIndex > 0) {
                aNum = nums1[--aIndex];
                bNum = nums2[++bIndex];
                if (aNum <= bNum) {
                    if (bIndex == 1) {
                        return getResult(aNum, nums2[bIndex - 1]);
                    }
                    if (aIndex < 1) {
                        return getResult(Math.max(aNum, nums2[bIndex - 2]), nums2[bIndex - 1]);
                    } else {
                        return getResult(nums1[aIndex - 1], aNum, nums2[bIndex - 2], nums2[bIndex - 1]);
                    }
                }
            }
            return getResult(nums2[bIndex - 1], nums2[bIndex]);
        } else if (aLength == bLength) {
            int aIndex = aLength - 1;
            int bIndex = leftNum - aIndex - 1;
            int aNum = nums1[aIndex];
            int bNum = nums2[bIndex];


            if (aNum <= bNum) {
                //if (bIndex == 1) {
                    if (nums1[aIndex - 1] >= nums2[bIndex - 1]) {
                        return getResult(aNum, nums1[aIndex - 1]);
                    } else {
                        return getResult(aNum, nums2[bIndex - 1]);
                    }
                //}
                //return getResult(nums1[aIndex - 1], aNum, nums2[bIndex - 2], nums2[bIndex - 1]);
            }
            while (aIndex > 1) {
                aNum = nums1[--aIndex];
                bNum = nums2[++bIndex];
                if (aNum <= bNum) {
                    if (bIndex == 1) {
                        return getResult(aNum, nums2[bIndex - 1]);
                    }
                    //return getResult(Math.max(aNum, nums2[bIndex - 2]), nums2[bIndex - 1]);
                    return getResult(nums1[aIndex - 1], aNum, nums2[bIndex - 2], nums2[bIndex - 1]);
                }
            }
            return getResult(Math.max(nums1[0], nums2[bIndex - 1]), nums2[bIndex]);
        } else {
            int bIndex = bLength - 1;
            int aIndex = leftNum - bIndex - 1;
            int aNum = nums1[aIndex];
            int bNum = nums2[bIndex];


            if (bNum <= aNum) {
                if (bLength == 1) {
                    if (aIndex == 1) {
                        return getResult(bNum, nums1[aIndex - 1]);
                    }
                    return getResult(Math.max(bNum, nums1[aIndex - 2]), nums1[aIndex - 1]);
                } else if ( aIndex == 1) {
                    return getResult(Math.max(nums1[aIndex - 1], nums2[bIndex - 1]), bNum);
                }
                return getResult(nums2[bIndex - 1], bNum, nums1[aIndex - 2], nums1[aIndex - 1]);
                //return getResult(bNum, Math.max(nums1[aIndex - 1], nums2[bIndex - 1]));
            }
            while (bIndex > 0) {
                bNum = nums2[--bIndex];
                aNum = nums1[++aIndex];
                if (bNum <= aNum) {
                    if (aIndex == 1) {
                        return getResult(bNum, nums1[aIndex - 1]);
                    }
                    if (bIndex < 1) {
                        return getResult(Math.max(bNum, nums1[aIndex - 2]), nums1[aIndex - 1]);
                    } else {
                        return getResult(nums2[bIndex - 1], bNum, nums1[aIndex - 2], nums1[aIndex - 1]);
                    }
                }
            }
            return getResult(nums1[aIndex - 1], nums1[aIndex]);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6};
        int[] nums2 = {1,2,3,7,8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
