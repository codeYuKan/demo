package com.yukan.demo.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式相关工具类
 *
 * @author yukan
 */
public class RegexUtil {

    public static final String CHINESE_REGEX = "[\u4e00-\u9fa5]";

    /**
     * 替换字符串中的中文为*空*
     *
     * @param originStr
     * @return
     */
    public static String replaceChinese(String originStr){
        if(StringUtils.isEmpty(originStr)){
            return originStr;
        }
        //中文匹配器
        Pattern pattern = Pattern.compile(CHINESE_REGEX);
        Matcher mat = pattern.matcher(originStr);
        return mat.replaceAll("");
    }

    /**
     * 去除字符串中的数字
     */
    public static String replaceDigit(String originStr){
        if(StringUtils.isEmpty(originStr)){
            return originStr;
        }
        //数字匹配器
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher mat = pattern.matcher(originStr);
        return mat.replaceAll("");
    }


    /**
     * 去除字符串中的字母
     */
    public static String replaceLetter(String originStr){
        if(StringUtils.isEmpty(originStr)){
            return originStr;
        }
        //字母匹配器
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher mat = pattern.matcher(originStr);
        return mat.replaceAll("");
    }

}
