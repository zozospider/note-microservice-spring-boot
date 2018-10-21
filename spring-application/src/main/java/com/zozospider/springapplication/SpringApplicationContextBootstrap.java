package com.zozospider.springapplication;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("ConfigurableApplicationContext: " + context.getClass().getName());
        System.out.println("ConfigurableApplicationContext getEnvironment: "+ context.getEnvironment().getClass().getName());

        // 关闭上下文
        context.close();

    }

}
