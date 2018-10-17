package com.zozospider.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * {@link SpringApplication} 引导类
 *
 * @author zozo
 * @since 1.0
 */
public class SpringApplicationBootstrap3 {

    public static void main(String[] args) {

        // 配置class名称
        Set<String> sources = new HashSet();
        sources.add(ApplicationConfiguration.class.getName());

        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        // 运行并获取上下文
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println("Bean: " + context.getBean(ApplicationConfiguration.class));

    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }

}
