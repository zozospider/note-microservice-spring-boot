package com.zozospider.autoconfiguration.bootstrap;

import com.zozospider.autoconfiguration.annotation.EnableHelloConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link EnableAutoConfiguration} 引导类
 *
 * @author zozo
 * @since 1.0
 */
@EnableHelloConfiguration
public class EnableHelloConfigurationBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 查找 Bean
        String hello = context.getBean("hello", String.class);

        System.out.println("hello Bean: " + hello);

        // 关闭上下文
        context.close();

    }

}
