package com.yukan.demo.basic.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yukan
 * @date 2020/4/15
 * @email yukan.cn.mail@gmail.com
 */
@Getter
@Setter
public class Student {

    private String name;

    private int age;

    private String sex;

    private Student deskMate;

    public static Student randomStudent() {
        Student student = new Student();
        //student.setName();
        //student.setAge();
        //student.setSex();
        return student;
    }

    public void printName() {
        System.out.println(name);
    }

}
