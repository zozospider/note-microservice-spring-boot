package com.zozospider.springapplication.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Before {@link ConfigFileApplicationListener} 实现
 *
 * @zozo
 * @since 1.0
 */
public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {

    /**
     * 参考 ConfigFileApplicationListener 实现
     * @param eventType
     * @return
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    /**
     * 参考 ConfigFileApplicationListener 实现
     * @param aClass
     * @return
     */
    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    /**
     * 参考 ConfigFileApplicationListener 实现，并试图获取 application.properties 中配置的 name 对应的值。
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            ConfigurableEnvironment environment = preparedEvent.getEnvironment();
            String name = environment.getProperty("name");
            System.out.println("Before environment getProperty name: " + name);
        }
        if (event instanceof ApplicationPreparedEvent) {

        }
    }

    /**
     * 比 ConfigFileApplicationListener 优先级更高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }

}
