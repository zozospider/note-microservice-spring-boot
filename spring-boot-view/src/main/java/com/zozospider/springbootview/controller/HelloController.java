package com.zozospider.springbootview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello-thymeleaf"; // View 逻辑名称
    }

    @ModelAttribute("message")
    public String message() {
        return "I am message";
    }

}
