package com.yukan.demo.designpattern.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/10/29
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class PrototypeDemo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Award award = new Award("zhangsan", "boy", "c1");
        award.display();

        Award award2 = award.clone();
        award2.setName("lisi");
        award2.display();
    }
}

/**
 * 奖状
 */
@Slf4j
class Award implements Cloneable {

    @Getter
    @Setter
    String name;

    String info;

    String college;

    public Award(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        log.info("award created!");
    }

    void display() {
        log.info("{}", name + info + college);
    }

    public Award clone() throws CloneNotSupportedException {
        log.info("clone success!");
        return (Award) super.clone();
    }

}
