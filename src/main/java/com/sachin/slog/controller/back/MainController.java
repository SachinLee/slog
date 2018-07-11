package com.sachin.slog.controller.back;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 后台管理界面
 */
@RestController
@RequestMapping("/admin")
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public ModelAndView main() {
        return new ModelAndView("index");
    }

}
