package com.song.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhixian.song
 */
@SpringBootApplication(scanBasePackages = {"com.song.springboot.config"})
@EnableSwagger2
@EnableFeignClients(basePackages = {"com.song.springboot.outcall"})
public class Application {
    public static void main(String[] args) {
        System.setProperty("APP_NAME", "api");
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println("返回Bean工厂定义的所有BeanName:"+name);
        }
    }
}
