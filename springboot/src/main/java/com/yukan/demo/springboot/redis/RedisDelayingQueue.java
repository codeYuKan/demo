package com.yukan.demo.springboot.redis;

import com.alibaba.fastjson.TypeReference;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.Set;

/**
 * @author yukan
 * @date 2021/6/28
 * @email yukan.cn.mail@gmail.com
 */
@Slf4j
public class RedisDelayingQueue<T> {

    // cant static : because T info is from this(this cant referenced from a static var)
    private final Type type = new TypeReference<TaskItem<T>>(){}.getType() ;

    @Getter
    @Setter
    static class TaskItem<T> {

        private String id;

        private T t;
    }

    private String queueKey;

    public RedisDelayingQueue(String queueKey) {
        this.queueKey = queueKey;
    }

    public void loop() {
        while (!Thread.interrupted()) {
            Set<String> values = RedisUtil.zRangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
        }
    }

}
