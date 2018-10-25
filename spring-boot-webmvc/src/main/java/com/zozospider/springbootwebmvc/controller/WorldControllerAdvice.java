package com.zozospider.springbootwebmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * {@link WorldController} 通知
 *
 * @author zozo
 * @since 1.0
 */
@ControllerAdvice(assignableTypes = WorldController.class)
public class WorldControllerAdvice {

    /**
     * @ModelAttribute(name) 等同于 model.addAttribute(attributeName, attributeValue);
     * @return attributeValue
     */
    @ModelAttribute("message")
    public String message() {
        return "World message";
    }

    /**
     * @ModelAttribute(name) 等同于 model.addAttribute(attributeName, attributeValue);
     * @param acceptLanguage 请求参数（可选项）
     * @return attributeValue
     */
    @ModelAttribute("acceptLanguageReturn")
    public String acceptLanguageReturn(@RequestHeader("Accept-Language") String acceptLanguage) {
        System.out.println("World RequestHeader Accept-Language: " + acceptLanguage);
        return acceptLanguage;
    }

}
