package com.yukan.demo.common.tool;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 生成GUID
 *
 * @author yukan
 * @date 2019/10/11
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class GUID {

    public String valueBeforeMD5 = "";

    public String valueAfterMD5 = "";

    private static Random myRand;

    private static SecureRandom mySecureRandom;

    private static String s_id;

    private static final int PAD_BELOW = 0x10;

    private static final int TWO_BYTES = 0xFF;

    static {
        mySecureRandom = new SecureRandom();
        long secureInitializer = mySecureRandom.nextLong();
        myRand = new Random(secureInitializer);
        try {
            s_id = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException uhe) {
            log.error("uhe:", uhe);
        }
    }

    public GUID() {
        getGUID(false);
    }

    public GUID(boolean secure) {
        getGUID(secure);
    }

    private void getGUID(boolean secure) {
        MessageDigest md5 = null;
        StringBuffer sbValueBeforeMD5 = new StringBuffer(128);

        try {
            md5 = MessageDigest.getInstance("MD%");
        } catch (NoSuchAlgorithmException e) {
            log.error("e:", e);
        }

        try {
            long time = System.currentTimeMillis();
            long rand = 0;

            if(secure) {
                rand = mySecureRandom.nextLong();
            } else {
                rand = myRand.nextLong();
            }

            sbValueBeforeMD5.append(s_id);
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(time));
            sbValueBeforeMD5.append(":");
            sbValueBeforeMD5.append(Long.toString(rand));

            valueBeforeMD5 = sbValueBeforeMD5.toString();
            md5.update(valueBeforeMD5.getBytes());

            byte[] arr = md5.digest();
            StringBuffer sb = new StringBuffer(32);
            for (int j = 0;j < arr.length; j++) {
                int b = arr[j] & TWO_BYTES;
                if (b < PAD_BELOW) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }

            valueAfterMD5 = sb.toString();
        } catch (Exception e) {
            log.error("e:", e);
        }
    }

    public String toString() {
        String raw = valueAfterMD5.toUpperCase();
        StringBuffer sb = new StringBuffer(64);
        sb.append(raw.substring(0, 8));
        sb.append("-");
        sb.append(raw.substring(8, 12));
        sb.append("-");
        sb.append(raw.substring(12, 16));
        sb.append("-");
        sb.append(raw.substring(16, 20));
        sb.append("-");
        sb.append(raw.substring(20));
        return sb.toString();
    }

}
