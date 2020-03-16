package com.yukan.demo.basic.invokeoperate;

import lombok.extern.slf4j.Slf4j;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author yukan
 * @date 2019/12/18
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class MethodHandleDemo {

    Object o = "a";

    public void methodHandle() {
        MethodType mt = MethodType.methodType(int.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle mh = null;

        try {
            mh = lookup.findVirtual(o.getClass(), "hashCode", mt);
            try {
                int ret = (int) mh.invoke(o);
                System.out.println(ret);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MethodHandleDemo().methodHandle();
    }

}
