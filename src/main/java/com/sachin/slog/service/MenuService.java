package com.sachin.slog.service;

import com.sachin.slog.common.base.BaseService;
import com.sachin.slog.pojo.Menu;
import com.sachin.slog.vo.MenuVo;

import java.util.List;

/**
 * 菜单 service接口
 */
public interface MenuService extends BaseService<Menu, String> {

    /**
     * 通过关键字获取菜单列表
     * @param key 菜单查询关键字
     * @return 返回菜单列表
     */
    List<MenuVo> findByKey(String key);

}
