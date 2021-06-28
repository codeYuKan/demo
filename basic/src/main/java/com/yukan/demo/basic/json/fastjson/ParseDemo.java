package com.yukan.demo.basic.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2021/5/21
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ParseDemo {

    @Getter
    @Setter
    static class A {
        private String code;

        private JSONObject t;
    }

    @Getter
    @Setter
    static class B {

        private String f1;
    }

    @Getter
    @Setter
    static class C {

        private String f2;
    }

    public static void main(String[] args) {
        //A<B> a1 = new A<>();
        //B b = new B();
        //b.setF1("f1");
        //a1.setCode("b");
        //a1.setT(b);
        //// {"code":"b","t":{"f1":"f1"}}
        //log.info(JSON.toJSONString(a1));

        String s = "{\"code\":\"b\",\"t\":{\"f1\":\"f1\"}}";
        A a = JSON.parseObject(s, A.class);
        log.info("a:{}", a);
        B b = JSON.toJavaObject(a.getT(), B.class);
        log.info("111");

    }
}
