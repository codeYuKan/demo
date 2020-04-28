package com.yukan.demo.basic.java8;

import com.yukan.demo.basic.model.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author yukan
 * @date 2020/4/24
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class OptionalDemo {

    public static  <T> Optional<T> get(T t){
        return Optional.ofNullable(t);
    }

    public Integer testMap() {
        return get(Student.randomStudent()).map(Student::getAge).orElse(0);
    }

    @SuppressWarnings("ConstantConditions")
    public String testOptionalInsteadOfNullJudge() {
        // 直接 get会报错 当为空Optional的时候。所以使用orElse之类的。
        return Optional.ofNullable(Student.randomStudent()).map(Function.identity()).map(Student::getName).orElse("zzz");
    }

    @SuppressWarnings("ConstantConditions")
    public Integer testOptionalInsteadOfNullJudge2() {
        return Optional.ofNullable(Student.randomStudent()).map(Student::getAge).orElse(0);
    }

    @SuppressWarnings("ConstantConditions")
    public Integer testOptionalInsteadOfNullJudge3() {
        return Optional.ofNullable(Student.randomStudent()).map(Student::getAge).orElseThrow(() -> new RuntimeException("student 为空"));
    }

    /**
     * 用于和上一个方法比较用
     */
    @SuppressWarnings("ConstantConditions")
    public Integer nullJudge() {
        Student student = Student.randomStudent();
        if (Objects.nonNull(student)) {
            return student.getAge();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        OptionalDemo demo = new OptionalDemo();
        System.out.println(demo.testOptionalInsteadOfNullJudge());
    }
}
