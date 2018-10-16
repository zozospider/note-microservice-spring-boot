package com.zozospider.autoconfiguration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hello 配置
 *
 * @author zozo
 * @since 1.0
 */
@Configuration
public class HelloConfiguration {

    @Bean
    public String hello() { // 方法名即 Bean 名称
        return "Hello Bean";
    }

}
