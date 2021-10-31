package com.song.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021.8.3 16:46
 */
@Configuration
public class LuaConfiguration {
    /**
     * TODO
     * @params :
     * @returns :
     */
    @Bean
    public DefaultRedisScript<Boolean> redisScript() {
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/FirstLua.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }
    /**
     * 解析 lua 转为 脚本
     * @params :
     * @returns :
     */
    public static String getScript(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = LuaConfiguration.class.getClassLoader().getResourceAsStream(path);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return stringBuilder.toString();
    }
}
