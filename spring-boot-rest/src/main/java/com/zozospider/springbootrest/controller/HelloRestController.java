package com.zozospider.springbootrest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello {@link RestController} 实现
 *
 * @author zozo
 * @since 1.0
 */
@RestController
public class HelloRestController {

    @GetMapping(value = "hello")
    public String hello(@RequestParam(required = false) String msg) {
        System.out.println("msg: " + msg);
        return "hello: " + msg;
    }

}
