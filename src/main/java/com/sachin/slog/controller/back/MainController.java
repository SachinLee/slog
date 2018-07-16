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

    /**
     * 主页面
     * @return 返回这页面html
     */
    @GetMapping(value = {"/", "/index"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * 主页面的首页内容
     * @return
     */
    @GetMapping(value = "/main")
    public ModelAndView main() {
        return new ModelAndView("page/main");
    }
}
