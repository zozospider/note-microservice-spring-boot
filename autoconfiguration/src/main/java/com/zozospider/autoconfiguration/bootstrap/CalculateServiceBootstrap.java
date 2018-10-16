package com.zozospider.autoconfiguration.bootstrap;

import com.zozospider.autoconfiguration.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link CalculateService} 引导类
 *
 * @author zozo
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zozospider.autoconfiguration.service")
public class CalculateServiceBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java7") // 配置方式条件装配
                .run(args);

        // 查找 Bean
        CalculateService calculateService = context.getBean(CalculateService.class);

        System.out.println("calculateService sum(1...10): " +
                calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        // 关闭上下文
        context.close();

    }

}
