package com.yukan.demo.basic.uri;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yukan
 * @date 2019/9/16
 * @email yukan.cn.mail@gmail.com
 */
public class UriDownloadDemo {

    public static byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024*4];
        int n=0;
        while ( (n=in.read(buffer)) !=-1) {
            out.write(buffer,0,n);
        }
        return out.toByteArray();
    }

    /**
     * 网络文件转换为byte二进制
     * @Title: toByteArray
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param url
     * @param @return
     * @param @throws IOException    设定文件
     * @return byte[]    返回类型
     * @throws
     */
    public static byte[] toByteArray(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        byte[] buffer=new byte[1024*4];
        int n=0;
        while ( (n=in.read(buffer)) !=-1) {
            out.write(buffer,0,n);
        }
        return out.toByteArray();
    }

    /**
     * @throws IOException
     * 网络文件转换为本地文件
     * @Title: toByteArray
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param url
     * @param @return
     * @param @throws IOException    设定文件
     * @return byte[]    返回类型
     * @throws
     */
    public static void toLocalFile(String urlStr, String localUrl) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        DataInputStream in = new DataInputStream(conn.getInputStream());
        byte[] data=toByteArray(in);
        in.close();
        FileOutputStream out=new FileOutputStream(localUrl);
        out.write(data);
        out.close();
    }

    /**
     * 获取网络文件的输入流
     * @param urlStr
     * @return
     */
    public static InputStream getInputStreamByUrl(String urlStr){
        DataInputStream in = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            in = new DataInputStream(conn.getInputStream());
        } catch (IOException e) {
            //log.error("url转换输入流失败,错误信息{}",e.getMessage());
        }
        return in;
    }

    static String uri = "http://thirdwx.qlogo.cn/mmopen/AJz33SXmyv5icSGf4CxM5ZXc9UXhROzAZjVLwGAmnZBWzKbS8r9OyJwy1ic9qyArmHqcukD6MMT5D6Xs39KGTyu0qXfzqHIxdJ/132";

    public static void main(String[] args) {
        try {
            toLocalFile(uri, "d:\\test.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
