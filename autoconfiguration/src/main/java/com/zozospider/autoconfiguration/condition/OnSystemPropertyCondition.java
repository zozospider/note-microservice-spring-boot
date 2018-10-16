package com.zozospider.autoconfiguration.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * 系统属性 条件判断
 *
 * @author zozo
 * @since 1.0
 */
public class OnSystemPropertyCondition implements Condition {

    /**
     * 是否匹配，匹配 True 才满足装配的条件
     *
     * @param context  Spring 上下文
     * @param metadata 元信息，包含 ConditionalOnSystemProperty name 和 value 值
     * @return 是否匹配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 获取 ConditionalOnSystemProperty 的元信息
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        // 注解条件 name
        String propertyName = String.valueOf(attributes.get("name"));
        // 注解条件 value
        String propertyValue = String.valueOf(attributes.get("value"));

        System.out.println("propertyName: " + propertyName + ", propertyValue: " + propertyValue);

        // 系统自带 value
        String javaPropertyValue = System.getProperty(propertyName);

        System.out.println("javaPropertyValue: " + javaPropertyValue);

        // 注解条件 name 对应的 value 和 系统自带 name 对应 value 是否相等
        return javaPropertyValue.equals(propertyValue);

    }

}
