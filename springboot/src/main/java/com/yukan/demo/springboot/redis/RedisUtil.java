package com.yukan.demo.springboot.redis;


import com.yukan.demo.component.util.SpringUtils;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * @author yukan
 * @date 2021/6/28
 * @email yukan.cn.mail@gmail.com
 */
@SuppressWarnings("unchecked")
public class RedisUtil {

    @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private static final RedisTemplate<String, Object> myRedisTemplate = SpringUtils.getBean("myRedisTemplate", RedisTemplate.class);

    @Getter(value = AccessLevel.PRIVATE, lazy = true)
    private static final RedisTemplate<String, String> stringRedisTemplate = SpringUtils.getBean("stringRedisTemplate", RedisTemplate.class);

    public static <T> void set(String key, T value) {
        getMyRedisTemplate().opsForValue().set(key, value);
    }

    public static String getStr(String key) {
        return getStringRedisTemplate().opsForValue().get(key);
    }

    public static <T> T get(String key) {
        return (T)getMyRedisTemplate().opsForValue().get(key);
    }

    public static Boolean delete(String key) {
        return getMyRedisTemplate().delete(key);
    }

    public static <T> Set<T> zRangeByScore(String key, double min, double max, long offset, long count) {
        return (Set<T>) getMyRedisTemplate().opsForZSet().rangeByScore(key, min, max, offset, count);
    }

}
