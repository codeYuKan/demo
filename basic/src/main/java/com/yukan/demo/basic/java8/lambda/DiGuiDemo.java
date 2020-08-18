package com.yukan.demo.basic.java8.lambda;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2020/8/13
 * @email yukan.cn.mail@gmail.com
 */
interface Caller {
    int call(int n);
}

@Slf4j
public class DiGuiDemo {

    Caller caller;

    public DiGuiDemo() {
        caller = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        caller.call(n - 1) + caller.call(n - 2);
    }


}
