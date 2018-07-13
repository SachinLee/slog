package com.sachin.slog.service;

import com.sachin.slog.common.base.BaseService;
import com.sachin.slog.pojo.Menu;
import com.sachin.slog.utils.TreeNode;
import com.sachin.slog.vo.MenuVo;

import java.util.List;

public interface MenuService extends BaseService<Menu, String> {


    List<MenuVo> findByKey(String key);

    List<TreeNode> findByPid(String pid);

}
