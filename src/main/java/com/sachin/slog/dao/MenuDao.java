package com.sachin.slog.dao;

import com.sachin.slog.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 菜单dao
 */
public interface MenuDao extends JpaRepository<Menu, String> {

    /**
     * 通过关键字获取菜单
     * @param key 菜单关键字
     * @return
     */
    Menu findByKeyWord(String key);

    /**
     * 通过父节点ID查询菜单列表
     * @param pid 父节点ID
     * @return 返回菜单列表
     */
    List<Menu> findByPid(String pid);
}
