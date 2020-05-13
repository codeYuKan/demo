package com.yukan.demo.component.util;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Des 加密解密工具
 *
 * @author yukan
 * @date 2020/5/11
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class DesUtil {

    private static final String DEFAULT_ALGORITHM = "DES";

    private static final String DEFAULT_KEY = "sudowoodo";

    // 随机生成key 需要保存
    private static Key generateRandomKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(DEFAULT_ALGORITHM);
        keyGenerator.init(56);
        return keyGenerator.generateKey();
    }

    //根据自定义的key生成key
    private static Key generateKey() throws GeneralSecurityException {
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec keySpec = new DESKeySpec(DEFAULT_KEY.getBytes(StandardCharsets.UTF_8));
        keyFactory.generateSecret(keySpec);
        return keyFactory.generateSecret(keySpec);
    }

    public static Optional<String> encrypt(String plainText) {
        try {
            // 创建Cipher对象
            // 现支持 AES / DES / DESede / RSA
            // 简单形式:"算法" "DES" 使用默认模式和默认填充方式
            // 完整形式:"算法/模式/填充" "DES/CBC/PKCS5Padding"  "DES/ECB/PKCS5Padding"(默认)
            Cipher cipher = Cipher.getInstance(DEFAULT_ALGORITHM);

            // 初始化cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, generateKey());
            //String cipherText =  new String(cipher.doFinal(plainText.getBytes()), StandardCharsets.UTF_8);
            //String cipherText =  bytesToString(cipher.doFinal(plainText.getBytes()));
            String cipherText =  Base64.encode(cipher.doFinal(plainText.getBytes()));
            if (StringUtils.isNotEmpty(cipherText)) {
                return Optional.of(cipherText);
            }
        } catch (Exception e) {
           log.error("DesUtil.encrypt.error:", e);
        }
        return Optional.empty();
    }

    public static Optional<String> decrypt(String cipherText) {
        try {
            // 初始化cipher对象
            Cipher cipher = Cipher.getInstance(DEFAULT_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, generateKey());
            return Optional.of(new String(cipher.doFinal(Base64.decode(cipherText))));
        } catch (Exception e) {
            log.error("DesUtil.decrypt.error:", e);
        }
        return Optional.empty();
    }

    private static String bytesToString(byte[] b) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            String plainText = Integer.toHexString(0xFF & b[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, String> map = new HashMap<>();
        map.put("name", "张三三");
        map.put("mobile", "12345678901");
        String cipherText = encrypt(JSON.toJSONString(map)).orElseGet(() -> "123");
        System.out.println(cipherText);
        String plainText = decrypt(cipherText).orElseGet(() -> "321");
        System.out.println(plainText);
    }

}