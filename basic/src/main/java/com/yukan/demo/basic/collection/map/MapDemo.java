package com.yukan.demo.basic.collection.map;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yukan
 * @date 2020/10/9
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class MapDemo {

    private static Map<String, String> map = new HashMap<>();

    /**
     * 1.putIfAbsent有的时候直接返回，没有的时候存入设置的值并返回null
     * 2.computeIfAbsent有的时候直接返回，没有的时候通过右边的获取、存入并返回
     */
    public static void put1() {
        log.info(":{}", map.putIfAbsent("t1", "111111111111"));
        log.info(":{}", map.putIfAbsent("t1", "11111222211"));
        log.info(":{}", map.computeIfAbsent("t2", (t) -> "222222222"));
        log.info(":{}", map.computeIfAbsent("t2", (t) -> "2222221111"));
    }

    public static void main(String[] args) {
        put1();
    }

}
