package com.yukan.demo.component.tools;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author yukan
 * @date 2020/4/8
 * @email yukan.cn.mail@gmail.com
 */
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static AbstractApplicationContext APPLICATION_CONTEXT;

    @Override
    public void setApplicationContext(@NotNull ApplicationContext applicationContext) throws BeansException {
        APPLICATION_CONTEXT = (AbstractApplicationContext)applicationContext;
    }

    public static <T> T getBean(Class<T> tClass) {
        return APPLICATION_CONTEXT.getBean(tClass);
    }

    public static Object getBean(String name) {
        return APPLICATION_CONTEXT.getBean(name);
    }
}
