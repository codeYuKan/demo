package com.yukan.demo.springbootdemo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author yukan
 * @date 2021/6/28
 * @email yukan.cn.mail@gmail.com
 */
@Configuration
public class LettuceRedisTemplate {

    /**
     * Lettuce 是 一种可伸缩，线程安全，完全非阻塞的Redis客户端
     * 多个线程可以共享一个RedisConnection
     * 它利用Netty NIO 框架来高效地管理多个连接，从而提供了异步和同步数据访问方式，用于构建非阻塞的反应性应用程序。
     */
    @Bean
    public RedisTemplate<String, Object> myRedisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
}
