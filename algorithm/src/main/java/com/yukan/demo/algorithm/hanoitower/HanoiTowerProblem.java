package com.yukan.demo.algorithm.hanoitower;

import lombok.extern.slf4j.Slf4j;

/**
 * 汉诺塔 问题
 * 有三个柱子 A B C
 * A上面有n个圆盘 从上到下从小到大放置
 * 现在需要将n个圆盘移动到C柱上，要求
 * 1.每次只能移动一个圆盘
 * 2.大的圆盘不能放在小的上面
 * 求最少需要移动几次？
 *
 *
 * @author yukan
 */
@Slf4j
public class HanoiTowerProblem {

    private static long countMoveBasic(int n){
        if(n == 1){
            return 1;
        }
        return countMoveBasic(n - 1) * 2 + 1;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 40; i++){
            int count = i + 1;
            long beginTimeMills = System.currentTimeMillis();
            //log.info("count begin n:{}", count);
            long result = countMoveBasic(count);
            //log.info("count n result:{}", result);
            log.info("count {} move result:{},use time:{}", count, result, System.currentTimeMillis() - beginTimeMills);
            //log.info("count end n:{},use time:{}", count, System.currentTimeMillis() - beginTimeMills);
        }
    }

}
