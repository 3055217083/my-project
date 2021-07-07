package com.song.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhixian.song
 */
@SpringBootApplication(scanBasePackages = {"com.song.springboot.config"})
@MapperScan("com.song.springboot.mapper")
@EnableSwagger2
public class Application {
    public static void main(String[] args) {
        System.setProperty("APP_NAME", "api");
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}
