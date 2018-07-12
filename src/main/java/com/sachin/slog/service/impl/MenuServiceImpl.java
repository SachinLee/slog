package com.sachin.slog.service.impl;

import com.google.common.collect.Lists;
import com.sachin.slog.common.base.BaseServiceImpl;
import com.sachin.slog.dao.MenuDao;
import com.sachin.slog.exception.SysException;
import com.sachin.slog.pojo.Menu;
import com.sachin.slog.service.MenuService;
import com.sachin.slog.vo.MenuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class MenuServiceImpl extends BaseServiceImpl<Menu, String> implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public JpaRepository getDao() {
        return menuDao;
    }

    @Override
    public List<MenuVo> findByKey(String key) {
        try {
            return this.getByKey(key);
        } catch (Exception e) {
            log.error("获取菜单失败，失败原因:{}", e.getMessage());
            throw new SysException(e.getMessage());
        }
    }

    private List<MenuVo> getByKey(String key) {
        MenuVo menuVo = new MenuVo();

        Menu menu = menuDao.findByKeyWord(key);

        this.getByPid(menu.getId(), menuVo);

        return menuVo.getChildren();
    }

    private void getByPid(String pid, MenuVo menuVo) {
        List<Menu> menus = menuDao.findByPid(pid);
        List<MenuVo> menuVos = menus.parallelStream().map(m -> {
            MenuVo menuVoItem = new MenuVo();
            BeanUtils.copyProperties(m, menuVoItem);
            return menuVoItem;
        }).collect(Collectors.toList());

        menuVo.setChildren(menuVos);

        for (MenuVo menuVo1 : menuVos) {
            getByPid(menuVo1.getId(), menuVo1);
        }
    }

}
