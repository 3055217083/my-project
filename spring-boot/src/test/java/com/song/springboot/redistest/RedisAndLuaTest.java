package com.song.springboot.redistest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.3 16:48
 */
@SpringBootTest
class RedisAndLuaTest {

    @Resource
    private DefaultRedisScript<Boolean> redisScript;
    @Test
    void lua() {
        List<String> keys = Arrays.asList("testLua", "hello lua");
        Boolean execute = stringRedisTemplate.execute(redisScript, keys, "100");
        assert execute != null;
    }

    @Resource
    private StringRedisTemplate stringRedisTemplate;
}
