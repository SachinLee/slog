package com.sachin.slog.controller.back;

import com.sachin.slog.common.PageResult;
import com.sachin.slog.common.ResultEnum;
import com.sachin.slog.pojo.Menu;
import com.sachin.slog.service.MenuService;
import com.sachin.slog.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/getMenuByKey/{key}")
    public PageResult<MenuVo> getMenuByKey(@PathVariable String key) {

        List<MenuVo> menus = menuService.findByKey(key);

        return new PageResult<>(ResultEnum.SUCCESS, menus);
    }

}
