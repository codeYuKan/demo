package com.yukan.demo.basic.jvm.classloading.passiveinit;

import lombok.extern.slf4j.Slf4j;

/**
 * 被动使用类字段demo3
 * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
 *
 * @author yukan
 * @date 2019/9/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PassiveDemo3 {

    public static void main(String[] args) {
        /*
        没有输出 ConstClass init! ，因为引用的常量，其实在编译阶段通过常量传播优化，已经将此常量的值存储到了
        PassiveDemo3类的常量池中，以后PassiveDemo3对常量ConstClass.CONST的引用都转化为了PassiveDemo3类
        对自身常量池的引用了。也就是说，PassiveDemo3的class文件中并没有ConstClass类的符号引用入口，这两个类
        在编译成Class文件之后就不存在联系了。
         */
        log.info(ConstClass.CONST);
    }
}
