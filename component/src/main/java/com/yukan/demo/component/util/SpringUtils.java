package com.yukan.demo.component.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author yukan
 * @date 2021/6/28
 * @email yukan.cn.mail@gmail.com
 */
@Configuration
@SuppressWarnings({"NullableProblems", "unchecked"})
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name) {
        if (applicationContext.containsBean(name)) {
            return (T)applicationContext.getBean(name);
        } else {
            return null;
        }
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        if (applicationContext.containsBean(name)) {
            return applicationContext.getBean(name, clazz);
        } else {
            return null;
        }
    }
}

