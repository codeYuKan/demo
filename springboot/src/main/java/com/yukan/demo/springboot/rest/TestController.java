package com.yukan.demo.springboot.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yukan
 * @date 2020/4/8
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
@RestController("/test")
public class TestController {

    @GetMapping("/test")
    public void test(HttpServletRequest request) {
        ServletContext servletContext = request.getServletContext();
        log.info("test:{}", servletContext.getAttribute("test"));
    }
}