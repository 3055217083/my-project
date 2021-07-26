package com.song.springboot.config;

import com.song.springboot.config.interceptor.MyPlugin;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/26 14:25
 */
@org.springframework.context.annotation.Configuration
@MapperScan("com.song.springboot.mapper")
public class MapperConfig {

    //将插件加入到mybatis插件拦截链中
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                //插件拦截链采用了责任链模式，执行顺序和加入连接链的顺序有关
                MyPlugin myPlugin = new MyPlugin();
                //设置参数，比如阈值等，可以在配置文件中配置，这里直接写死便于测试
                Properties properties = new Properties();
                //这里设置慢查询阈值为1毫秒，便于测试
                properties.setProperty("time", "0.0001");
                myPlugin.setProperties(properties);
                configuration.addInterceptor(myPlugin);
            }
        };
    }
}
