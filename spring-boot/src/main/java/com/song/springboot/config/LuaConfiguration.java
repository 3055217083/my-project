package com.song.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.3 16:46
 */
@Configuration
public class LuaConfiguration {
    @Bean
    public DefaultRedisScript<Boolean> redisScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/FirstLua.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
}