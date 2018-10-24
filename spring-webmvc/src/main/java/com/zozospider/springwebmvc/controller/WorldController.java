package com.zozospider.springwebmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * World {@link Controller}
 *
 * @author zozo
 * @since 1.0
 */
@Controller
public class WorldController {

    /**
     * Request 入口
     * @param host 请求参数（可选项）
     * @param model
     * @return
     */
    @RequestMapping("/world")
    public String world(@RequestHeader("Host") String host,
                        Model model) {
        System.out.println("World RequestHeader Host: " + host);
        // 与 @ModelAttribute(name) 等同
        model.addAttribute("msg", "World msg");
        return "world";
    }

}
