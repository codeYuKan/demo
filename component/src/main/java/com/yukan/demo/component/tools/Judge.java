package com.yukan.demo.component.tools;

import java.util.function.Predicate;

/**
 * 判断工具
 *
 * @author yukan
 * @date 2020/3/26
 * @email yukan.cn.mail@gmail.com
 */
public class Judge {

    private Judge() throws InstantiationException {
        throw new InstantiationException("not allow to instantiate Judge!");
    }

    public static <T> T check(T t, Predicate<T> predicate) {
        return predicate.test(t) ? t : null;
    }

}
