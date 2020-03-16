package com.yukan.demo.basic.enums;

import java.util.Random;

/**
 * @author yukan
 * @date 2020/3/12
 * @email yukan.cn.mail@gmail.com
 */
public class Enums {

    private static Random random = new Random(47);
    public static <E extends Enum> E random(Class<E> eClass) {
        return random(eClass.getEnumConstants());
    }

    private static <E> E random(E[] vals) {
        return vals[random.nextInt(vals.length)];
    }
}
