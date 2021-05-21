package com.yukan.demo.springbootdemo.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * 监听Servlet上下文，初始化数据，用于缓存
 *
 * @author yukan
 * @date 2020/4/8
 * @email yukan.cn.mail@gmail.com
 */
@Component
public class ServletContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // get application context
        ApplicationContext context = event.getApplicationContext();
        ServletContext servletContext = context.getBean(ServletContext.class);
        servletContext.setAttribute("test", "test");
        System.out.println(servletContext.getAttributeNames());
    }
}
