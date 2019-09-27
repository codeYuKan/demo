package com.yukan.demo.common.tool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 计时器
 * 用于程序运行耗时记录
 *
 * @author yukan
 * @date 2019/9/27
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class Timer {

    private List<Long> timestampList = new ArrayList<>();

    public Timer(){
        record();
    }

    public void clear(){
        timestampList.clear();
    }

    public void record(){
        timestampList.add(System.currentTimeMillis());
    }

    public void print(){
        timestampList.add(System.currentTimeMillis());
        print(timestampList);
    }

    private long print(List<Long> timestampList) {
        return timestampList.get(timestampList.size() - 1) - timestampList.get(timestampList.size() - 2);
    }

}
