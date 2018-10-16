package com.zozospider.autoconfiguration.bootstrap;

import com.zozospider.autoconfiguration.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link ConditionalOnSystemProperty} 引导类
 *
 * @author zozo
 * @since 1.0
 */
public class ConditionalOnSystemPropertyBootstrap {

    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "Administrator")
    public String hello() {
        return "Hello Bean";
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 查找 Bean（ConditionalOnSystemProperty条件满足才可用）
        String hello = context.getBean("hello", String.class);

        System.out.println("hello Bean: " + hello);

        // 关闭上下文
        context.close();
    }

}
