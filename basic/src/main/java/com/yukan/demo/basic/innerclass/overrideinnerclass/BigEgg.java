package com.yukan.demo.basic.innerclass.overrideinnerclass;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/11/22
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class BigEgg extends Egg {
    public class Yolk extends Egg.Yolk {
        private Yolk() {
            System.out.println("BigEgg.Yolk()");
        }

        public void f() {
            System.out.println("BigEgg.Yolk.f()");
        }
    }

    private BigEgg() {
        System.out.println("new BigEgg()");
        changeYolk(new Yolk());
    }

    /**
     * result:
     * Egg.Yolk()
     * new Egg()
     * new BigEgg()
     * Egg.Yolk()
     * BigEgg.Yolk()
     * BigEgg.Yolk.f()
     */
    public static void main(String[] args) {
        Egg e = new BigEgg();
        e.g();
    }
}

class Egg {
    protected class Yolk {
        Yolk() {
            System.out.println("Egg.Yolk()");
        }

        public void f() {
            System.out.println("Egg.Yolk.f()");
        }
    }

    private Yolk y = new Yolk();

    Egg() {
        System.out.println("new Egg()");
    }

    void changeYolk(Yolk yy) {
        y = yy;
    }

    void g() {
        y.f();
    }
}