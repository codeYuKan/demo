package com.yukan.demo.basic.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Objects;

/**
 * @author yukan
 * @date 2021/2/26
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class FileOperateDemo {

    public static final String LINE_SEPARATOR = java.security.AccessController.doPrivileged(
            new sun.security.action.GetPropertyAction("line.separator"));

    /**
     * 文本文件
     * 获取文件中带关键字的行，并保存到新文件
     */
    public static void genNewFileWithoutKeywordLine(File oldFile, File newFile, String keyword) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(oldFile))) {
            String line = bufferedReader.readLine();
            while (Objects.nonNull(line)) {
                if (line.contains(keyword)) {
                    // 包含关键字 输入到新的文件
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

                line = bufferedReader.readLine();
            }
            bufferedWriter.flush();
        }
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFile));
        //BufferedReader bufferedReader = new BufferedReader(new FileReader(oldFile));

        //bufferedReader.close();
        //bufferedReader.close();
    }

    /**
     * 二进制文件
     */
    public static void genNewFile(File oldFile, File newFile, String keyword) {

    }

    public static void main(String[] args) throws IOException {
        genNewFileWithoutKeywordLine(new File("D:\\test\\124.txt"), new File("D:\\test\\123.txt"), "测试");
    }
}
