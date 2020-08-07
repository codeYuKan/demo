package com.yukan.demo.component.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * 读取二进制文件
 *
 * @author yukan
 * @date 2020/6/8
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class BinaryFile {

    public static byte[] read(File file) throws IOException {
        try (BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = new byte[bf.available()];
            bf.read(bytes);
            return bytes;
        }
    }

    public static byte[] read(String fileName) throws IOException {
        return read(new File(fileName).getAbsoluteFile());

    }
}
