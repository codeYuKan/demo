package com.yukan.demo.basic.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * HashMap:通过对key计算hashCode()，通过空间换时间的方式，直接到定位到value所在的内部数组的索引
 * EnumMap:内部以一个非常紧凑的数组存储value，并且根据enum类型的key直接定位到内部数组的索引，
 *  并不需要计算hashCode()，不但效率最高，而且没有额外的空间浪费。
 *
 *  p.s.
 *  1.使用EnumMap的时候，可以用Map接口来引用他，因此实际上把HashMap和EnumMap互换，在客户端看来没有任何区别
 *
 * @author yukan
 * @date 2020/3/16
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class EnumMapDemo {

    private static final EnumSet<DemoEnum> DEMO_ENUM_ENUM_SET = EnumSet.of(DemoEnum.BBBBBBBBBB, DemoEnum.CCCCCCCCCC);

    EnumMap<DemoEnum, List<EnumObject>> groupByEnum(List<EnumObject> list) {
        EnumMap<DemoEnum, List<EnumObject>> enumMap = new EnumMap<>(DemoEnum.class);

        list.forEach(o -> {
            DemoEnum status = o.getStatus();

            if (enumMap.containsKey(status)) {
                enumMap.get(status).add(o);
            } else {
                List<EnumObject> l = new ArrayList<>();
                l.add(o);
                enumMap.put(status, l);
            }
        });
        return enumMap;
    }

    public static void main(String[] args) {
        Map<DemoEnum, List<EnumObject>> map = new HashMap<>(4);

    }
}
