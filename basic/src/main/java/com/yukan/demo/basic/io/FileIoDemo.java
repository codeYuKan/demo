package com.yukan.demo.basic.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Objects;

/**
 * @author yukan
 * @date 2020/6/5
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FileIoDemo {

    /**
     * BufferedReader(FileReader)
     */
    public static String read1(String fileName) throws IOException {
        String s;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            while (Objects.nonNull(s = bf.readLine())) {
                // readline 会删除换行符
                sb.append(s).append('\n');
            }
        }
        return sb.toString();
    }

    public static void read2(String fileName) throws IOException {
        char c;
        try (StringReader sr = new StringReader(read1(fileName))) {
            while ((c = (char)sr.read()) != -1) {
                System.out.println(c);
            }
        }
    }


}
