package com.yukan.demo.basic.clazz;

/**
 * @author yukan
 * @date 2020/8/7
 * @email yukan.cn.mail@gmail.com
 */
class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    private Lettuce l = new Lettuce();
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

public class ClassDemo2 extends PortableLunch {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public ClassDemo2() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new ClassDemo2();
    }
}
