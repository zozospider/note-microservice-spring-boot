package com.zozospider.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * First {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 *
 * @author zozo
 * @since 1.0
 */
@Order(Ordered.HIGHEST_PRECEDENCE) // 进行排序，并指定为高级别
public class FirstApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("First ApplicationListener: " + event.getApplicationContext().getId()
                + ", timestamp: " + event.getTimestamp());
    }

}
