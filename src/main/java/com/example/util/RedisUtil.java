package com.example.util;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

/**
 * @author: peng.c.zhang
 * @DATE: 2021/2/24 12:02
 */
public class RedisUtil {
    private static RedisTemplate redisTemplate = new RedisTemplate();

    public static void put(String key, String value) {
        if (Objects.nonNull(key) && Objects.nonNull(value)) {
            redisTemplate.opsForValue().set(key, value);
        }
    }
}
