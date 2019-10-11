package com.yukan.demo.basic.lombok;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author yukan
 * @date 2019/10/10
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class CleanupDemo {

    public static void main(String[] args) throws IOException {
        // call your close methods safely with no hassle;
        // use ("method name") to call your own close method(no-argument!)
        @Cleanup("close") InputStream in = new FileInputStream(args[0]);
        @Cleanup OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[1000];
        while (true) {
            int r = in.read(b);
            if(r == -1){
                break;
            }
            out.write(b, 0, r);
        }
    }
}
