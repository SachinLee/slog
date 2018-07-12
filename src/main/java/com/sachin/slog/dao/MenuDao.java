package com.sachin.slog.dao;

import com.sachin.slog.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuDao extends JpaRepository<Menu, String> {

    Menu findByKeyWord(String key);

    List<Menu> findByPid(String pid);
}
