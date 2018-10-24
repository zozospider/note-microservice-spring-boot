package com.zozospider.springwebmvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * {@link ExceptionHandler} demo
 *
 * @author zozo
 * @since 1.0
 */
@Controller
public class ExceptionController {

    @RequestMapping("/ex")
    public String ex(@RequestParam int name,
                        Model model) {
        System.out.println("ex");
        return "ex";
    }

    /**
     * 发生异常时处理
     * @param throwable 异常类型
     * @return 返回实体对象
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable) {
        System.out.println("onException: " + throwable.getMessage());
        return ResponseEntity.ok("ex error: " + throwable.getMessage());
    }

}
