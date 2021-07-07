package com.song.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.song.springboot.api")
@Configuration
@ConditionalOnExpression("'api'.equals('${APP_NAME}')")
public class APIConfig {
}
