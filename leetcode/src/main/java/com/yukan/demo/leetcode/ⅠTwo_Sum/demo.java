package com.yukan.demo.leetcode.ⅠTwo_Sum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yukan
 * @date 2019/11/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class demo {

    private static int[] test(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        return compare(nums, i, j, target);
    }

    private static int[] compare(int[] nums, int i, int j, int target){
        if(j == i) {
            return null;
        }
        int x = nums[i];
        int y = nums[j];
        if(x + y == target) {
            return new int[]{i, j};
        } else if (x + y < target) {
            return compare(nums, ++i ,j , target);
        } else {
            return compare(nums, i ,--j , target);
        }
    }

    private static int[] test2(int[]nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int r = target - nums[i];
            if(m.containsKey(r)) {
                return new int[]{i, m.get(r)};
            }
            m.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        log.info("start");
        log.info("{}", Arrays.toString(test(new int[]{1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,87,188,12300,12400,4324652,64363463}, 12487)));
        log.info("start");
        log.info("{}", Arrays.toString(test2(new int[]{1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,1, 2, 3,5,87,188,12300,12400,4324652,64363463}, 12487)));

    }
}
