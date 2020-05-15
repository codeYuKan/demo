package com.yukan.demo.component.util;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author yukan
 * @date 2020/5/14
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class StringUtil {

    public static byte[] strToByteArray(String str) {
        return str.getBytes();
    }

    /**
     * @see java.nio.charset.StandardCharsets
     */
    public static byte[] strToByteArray(String str, Charset charset) {
        return str.getBytes(charset);
    }


    public static byte[] hexStrToByteArray(String hexStr) {
        if (Objects.isNull(hexStr)) {
            return null;
        }
        if (hexStr.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray= new byte[hexStr.length() / 2];
        for (int i = 0; i < byteArray.length; i++) {
            String subStr = hexStr.substring(i * 2, i * 2 + 2);
            byteArray[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return byteArray;


        //char[] hexArray = "01234567890ABCDEF".toCharArray();
        //char[] hexChars = new char[bytes.length * 2];
        //for (int j = 0; j < bytes.length; j++) {
        //    int value = bytes[j] & 0xFF;
        //    hexChars[j * 2] = hexArray[value >>> 4];
        //    hexChars[j * 2 + 1] = hexArray[value & 0x0F];
        //}
        //return new String(hexChars);
    }

    public static String byteArrayToStr(byte[] bytes) {
        return new String(bytes);
    }

    public static String byteArrayToStr(byte[] bytes, Charset charset) {
        return new String(bytes, charset);
    }

    public static String byteArrayToHexStr(byte[] bytes) {
        if (Objects.isNull(bytes)) {
            return null;
        }
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int value = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[value >>> 4];
            hexChars[j * 2 + 1] = hexArray[value & 0x0F];
        }
        return new String(hexChars);
    }

    public static void main(String[] args) throws Base64DecodingException {
        //byte[] bs = strToByteArray("测试中文，test english,✔", StandardCharsets.UTF_8);
        //byte[] bs = "测试中文，test english,✔".getBytes(StandardCharsets.UTF_8);
        //System.out.println(Arrays.toString(bs));
        //String b = Base64.encode(bs);
        //System.out.println(b);
        //String s = byteArrayToStr(bs);
        //System.out.println(s);
        //s = byteArrayToStr(Base64.decode(b));
        //System.out.println(s);
        hexStrToByteArray(byteArrayToHexStr(strToByteArray("测试中文，test english,✔", StandardCharsets.UTF_8)));
    }
}
