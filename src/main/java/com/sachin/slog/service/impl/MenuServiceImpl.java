package com.sachin.slog.service.impl;

import com.sachin.slog.common.base.BaseServiceImpl;
import com.sachin.slog.dao.MenuDao;
import com.sachin.slog.pojo.Menu;
import com.sachin.slog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<Menu> findByKey(String key) {
        return menuDao.findByKey(key);
    }
}
