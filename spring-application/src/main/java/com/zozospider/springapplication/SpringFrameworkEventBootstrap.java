package com.zozospider.springapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring Framework 事件引导类
 *
 * @author zozo
 * @since 1.0
 */
public class SpringFrameworkEventBootstrap {

    public static void main(String[] args) {

        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            System.out.println("监听到事件: " + event);
        });

        // 启动上下文
        context.refresh();

        context.publishEvent("Hello Event 1");
        context.publishEvent("Hello Event 2");
        context.publishEvent(new ApplicationEvent("Hello Application Event") {

        });

        // 关闭上下文
        context.close();

    }

}
