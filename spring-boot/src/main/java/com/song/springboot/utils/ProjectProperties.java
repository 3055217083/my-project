package com.song.springboot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * 配置文件全局变量
 * @params :
 * @returns :
 */
public class ProjectProperties {

    private static final Logger log = LoggerFactory.getLogger(ProjectProperties.class);
    public static Properties properties = new Properties();

    public static void addProperty(Properties properties) {
        if (properties != null) {
            for (Object key : properties.keySet()) {
                if (key != null) {
                    if (ProjectProperties.properties.containsKey(key)) {
                        log.error("系统Properties配置项 {} 重复", key);
                    }
                    ProjectProperties.properties.put(key, properties.get(key));
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static Properties getProperties() {
        return properties;
    }
}
