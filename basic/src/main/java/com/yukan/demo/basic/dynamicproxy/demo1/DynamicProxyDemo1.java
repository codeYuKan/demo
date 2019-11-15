package com.yukan.demo.basic.dynamicproxy.demo1;

import com.yukan.demo.basic.dynamicproxy.Person;
import com.yukan.demo.basic.dynamicproxy.ZhangSan;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/11/13
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class DynamicProxyDemo1 {

    public static void main(String[] args) {
        ProxySaler proxySaler = new ProxySaler();
        /*
        动态代理只能代理接口，要代理类需要使用第三方的CGLIB等工具
        不然将下面语句的Person替换为ZhangSan则会抛出如下异常:
        Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to com.yukan.demo.basic.dynamicproxy.ZhangSan
         */
        Person object = (Person) proxySaler.proxyInstance(new ZhangSan("zhangsan", "big house"));
        object.buy();
        object.buy1();

    }
}
