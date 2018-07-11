package com.sachin.slog.service;

import com.sachin.slog.common.base.BaseService;
import com.sachin.slog.pojo.Menu;

import java.util.List;

public interface MenuService extends BaseService<Menu, String> {


    List<Menu> findByKey(String key);

}
