package com.yukan.demo.basic.jvm.classloading.passiveinit;

import lombok.extern.slf4j.Slf4j;

/**
 * 被动使用类字段demo2
 * 通过数组定义来引用类，不会触发此类的初始化
 *
 * @author yukan
 * @date 2019/9/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PassiveDemo2 {

    public static void main(String[] args) {
        /*
        触发了另外一个名为“[Lcom.yukan.demo.basic.jvm.classloading.passiveinit.SuperClass”的类的初始化阶段，
        它是一个由虚拟机自动生成的、直接继承于Object的子类，创建动作由字节码指令newarray触发。
        这个类代表了元素类型为com.yukan.demo.basic.jvm.classloading.passiveinit.SuperClass的一维数组，
        数组中应有的属性和方法都是现在这个类里
         */
        SuperClass[] superClasses = new SuperClass[10];
    }
}
