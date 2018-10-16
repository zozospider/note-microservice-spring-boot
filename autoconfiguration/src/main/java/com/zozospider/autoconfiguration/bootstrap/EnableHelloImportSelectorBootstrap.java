package com.zozospider.autoconfiguration.bootstrap;

import com.zozospider.autoconfiguration.annotation.EnableHelloImportSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableHelloImportSelector
public class EnableHelloImportSelectorBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloImportSelectorBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 查找 Bean
        String hello = context.getBean("hello", String.class);

        System.out.println("hello Bean: " + hello);

        // 关闭上下文
        context.close();
    }

}
