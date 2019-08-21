package com.yukan.demo.basic;

/**
 * @author yukan
 * @date 2019/8/20
 * @email yukan.cn.mail@gmail.com
 */
public class AnonymousInnerClassDemo {

    class A{
        A(int i){
            System.out.println(i);
        }
    }

    class B extends A{
        B(int i){
            super(i);
        }

        A test(int j){
            return new A(j){
                {
                    System.out.println("Anonymous Inner Class");
                }
            };
        }
    }

    public static void main(String[] args) {
        AnonymousInnerClassDemo demo = new AnonymousInnerClassDemo();
        B b = demo.new B(1);
        A a = b.test(2);
    }
}
