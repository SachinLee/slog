package com.sachin.slog.controller.back;

import com.sachin.slog.common.PageResult;
import com.sachin.slog.pojo.Menu;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    @GetMapping(value = "/getMenuByKey/{key}")
    public PageResult<Menu> getMenuByKey(@PathVariable String key) {
        return null;
    }

}
