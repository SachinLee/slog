package com.sachin.slog.controller.back;

import com.sachin.slog.common.PageResult;
import com.sachin.slog.common.ResultEnum;
import com.sachin.slog.service.MenuService;
import com.sachin.slog.utils.TreeNode;
import com.sachin.slog.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 菜单管理 控制层
 */
@RestController
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 返回菜单管理界面
     * @return 返回用户管理界面
     */
    @GetMapping(value = "/list")
    public ModelAndView list() {
        return new ModelAndView("page/menu/menuList");
    }

    /**
     * 首页查询菜单
     * @param key 相关的关键字内容
     * @return 返回分页对象
     */
    @GetMapping(value = "/getMenuByKey/{key}")
    public PageResult<MenuVo> getMenuByKey(@PathVariable String key) {

        List<MenuVo> menus = menuService.findByKey(key);

        return new PageResult<>(ResultEnum.SUCCESS, menus);
    }

    /**
     * 获取菜单树
     * @param pid 父节点id
     * @return 返回分页对象
     */
    @GetMapping(value = "/getTree")
    public PageResult<TreeNode> getTreeNode(String pid) {
        List<TreeNode> treeNodes = menuService.findByPid(pid);
        return new PageResult<>(ResultEnum.SUCCESS, treeNodes);
    }


}
