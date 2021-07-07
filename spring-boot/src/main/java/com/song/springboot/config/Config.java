package com.song.springboot.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/6/21 9:57
 */

/* basePackages 等于 value 懂？*/
@ServletComponentScan
@Configuration
@ComponentScan(value = {"com.song.springboot.controller"
        , "com.song.springboot.service"
        , "com.song.springboot.exception"
        , "com.song.springboot.mq"
        , "com.song.springboot.mapper"
})
public class Config {
}
