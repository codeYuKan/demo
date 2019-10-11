package com.yukan.demo.basic.lombok;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

/**
 * @author yukan
 * @date 2019/10/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ValDemo {

    public static void main(String[] args) {
        /*
        The existence of this type on a local variable declaration triggers
        both the adding of the final keyword as well as copying the type of the initializing expression
        which overwrites the 'fake' val type.
         */
        val test = "123";
        // Error:(36, 9) java: 无法为最终变量test分配值
        //test = "333";
    }
}
