package com.yukan.demo.basic.lombok;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yukan
 * @date 2019/10/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
@Getter
//@Setter
@RequiredArgsConstructor
public class NonNullDemo {

    @NonNull private String name;
    //
    //public NonNullDemo(@NonNull String name) {
    //    this.name = name;
    //}

    public void test(@NonNull String name){
        log.info("name:{}", name);
    }

    public static void main(String[] args) {
        // 会抛空指针异常
        // Exception in thread "main" java.lang.NullPointerException: name is marked non-null but is null
        // 可以通过lombok.config(放在resources目录下不起作用，生效范围为文件所在目录及子目录下)里的参数来调整异常类型
        NonNullDemo demo = new NonNullDemo(null);
        demo.test(null);
        log.info("demo:{}", demo.getName());
    }

}
