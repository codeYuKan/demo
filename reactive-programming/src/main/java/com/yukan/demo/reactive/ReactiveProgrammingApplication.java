package com.yukan.demo.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yukan.demo.reactive.*")
public class ReactiveProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveProgrammingApplication.class, args);
    }

}
