package com.zozospider.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * First {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 *
 * @author zozo
 * @since 1.0
 */
public class FirstApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("First ApplicationListener: " + event.getApplicationContext().getId()
                + ", timestamp: " + event.getTimestamp());
    }

}
