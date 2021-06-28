package com.yukan.demo.springbootdemo.redis;

import com.yukan.demo.springbootdemo.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author yukan
 * @date 2021/6/28
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class RedisUtilTest extends BaseTest {

    private static final String KEY_NAME = "name";

    @Test
    public void testSetGet() {
        RedisUtil.set(KEY_NAME, "yukan");
        String r = RedisUtil.get(KEY_NAME);
        log.info("result1:{}", r);
        RedisUtil.delete(KEY_NAME);
        r = RedisUtil.get(KEY_NAME);
        log.info("result2:{}", r);
    }

}
