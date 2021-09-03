package com.song.springboot.config;


import com.song.springboot.utils.ProjectProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置容器
 * @params :
 * @returns :
 */
@PropertySource(value = {"classpath:application.properties"})
@Configuration
@Order(10)
public class SystemPropertiesLoadConfig {

    @Bean
    boolean loadProperties(ResourceLoader resourceLoader) {
        Resource applicationResource = resourceLoader.getResource("classpath:application.properties");
        try {
        	Properties properties = new Properties();
            properties.load(applicationResource.getInputStream());
            ProjectProperties.addProperty(properties);
        } catch (IOException ignored) {
        }
        return true;
    }
}
