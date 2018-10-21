package com.zozospider.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Hello {@link Controller}
 *
 * @author zozo
 * @since 1.0
 */
@Controller
public class HelloController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

}
