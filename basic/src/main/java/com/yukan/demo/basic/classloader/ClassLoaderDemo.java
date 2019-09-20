package com.yukan.demo.basic.classloader;

import java.net.URL;

/**
 * @author yukan
 * @date 2019/8/21
 * @email yukan.cn.mail@gmail.com
 */
public class ClassLoaderDemo {

    static class xxx extends ClassLoader{

    }

    public static void main(String[] args) {
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }

        System.out.println("********************* 这是分割线 *********************");

        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(System.getProperty("java.class.path"));

        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);

        xxx xx = new xxx();
        System.out.println(xx.getParent().getParent().getClass());
    }
}