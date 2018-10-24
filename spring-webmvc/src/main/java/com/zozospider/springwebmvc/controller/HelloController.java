package com.zozospider.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello {@link Controller}
 *
 * @author zozo
 * @since 1.0
 */
@Controller
public class HelloController {

    /**
     * Request 入口
     * @param host 请求参数（可选项）
     * @param model
     * @return
     */
    @RequestMapping("")
    public String index(@RequestHeader("Host") String host,
                        Model model) {
        System.out.println("Hello RequestHeader Host: " + host);
        // 与 @ModelAttribute(name) 等同
        model.addAttribute("msg", "Hello msg");
        return "index";
    }

    /**
     * @ModelAttribute(name) 等同于 model.addAttribute(attributeName, attributeValue);
     * @return attributeValue
     */
    @ModelAttribute("message")
    public String message() {
        return "Hello message";
    }

    /**
     * @ModelAttribute(name) 等同于 model.addAttribute(attributeName, attributeValue);
     * @param acceptLanguage 请求参数（可选项）
     * @return attributeValue
     */
    @ModelAttribute("acceptLanguageReturn")
    public String acceptLanguageReturn(@RequestHeader("Accept-Language") String acceptLanguage) {
        System.out.println("Hello RequestHeader Accept-Language: " + acceptLanguage);
        return acceptLanguage;
    }

}
