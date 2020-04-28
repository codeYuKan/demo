package com.yukan.demo.basic.java8.stream;

import com.yukan.demo.basic.model.Student;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yukan
 * @date 2020/4/15
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StreamToMapExceptionDemo {

    private static final List<Student> STUDENTS = new ArrayList<Student>(){{
        add(Student.randomStudent());
        add(Student.randomStudent());
        add(Student.randomStudent());
    }};

    public void nullExceptionTest() {
        Map<String, Student> studentMap = STUDENTS.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        //log.info(JSON);
    }
}
