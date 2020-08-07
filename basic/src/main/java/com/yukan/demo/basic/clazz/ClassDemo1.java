package com.yukan.demo.basic.clazz;

import com.yukan.demo.basic.array.ArrayTypeDemo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yukan
 * @date 2020/5/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class ClassDemo1 {

    public void test () {
        new ClassDemo11();
    }

    public class ClassDemo11 extends ArrayTypeDemo {

    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("150200,110000,510100,441900,440600,350100,440100,330100,340100,441300,370100,440700,530100,410300,360100,320100,320600,411300,350300,320681,370200,441800,350500,350200,411400,310000,440300,320500,140100,320200,420100,411000,430100,410100,442000,500000,440400".split(","));
        List<String> aa = new ArrayList<>(a);
        List<String> b = Arrays.asList("440100,310000,420100,411400,410100,411000,411300,410300,320200,350100,350200,350500,441300,440300,442000,441900,320100,330100,370100,110000,340100,510100,320681,440700,350300,510100,150200,500000,530100,360100,441800,140100".split(","));
        List<String> bb = new ArrayList<>(b);
        aa.removeAll(bb);
        System.out.println(aa);
    }
}
