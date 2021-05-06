package com.yukan.demo.basic.java8.optional;

import com.yukan.demo.basic.model.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

/**
 * @author yukan
 * @date 2020/9/21
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class OptionalCreateDemo {

    static void test() {
        // will throw NPE
        Optional<String> o1 = Optional.of(null);
        // will produce a o3 and won't throw NPE
        Optional<String> o2 = Optional.ofNullable(null);
        Optional<String> o3 = Optional.empty();

        // orElse
        String s1 = o3.orElse("xxx");
        String s2 = o3.orElseGet(() ->"xxx");
        String s3 = o3.orElseThrow(() -> new NullPointerException());

    }

    static void action1(Student student) {
        String name;
        if (Objects.nonNull(student)) {
            Student deskMate = student.getDeskMate();
            if (Objects.nonNull(deskMate)) {
                name = deskMate.getName();
            } else {
                name = "默认姓名";
            }
        }
        // old =>=> java8 optional
        name = Optional.ofNullable(student)
                .map(Student::getDeskMate)
                .map(Student::getName)
                //.ifPresent(System.out::println);
                .orElse("默认姓名");
    }

    static void action2(Student student) {
        Student result;
        if (Objects.nonNull(student)) {
            if ("张三".equals(student.getName())) {
                result = student;
            } else {
                Student s = new Student();
                s.setName("张三");
                result = s;
            }
        }
        // old =>=> java8 optional
        Optional.ofNullable(student)
                .filter(s -> "张三".equals(s.getName()))
                .orElseGet(() -> {
                    Student s = new Student();
                    s.setName("张三");
                    return s;
                });

    }

    public static void main(String[] args) {
        test();
    }
}
