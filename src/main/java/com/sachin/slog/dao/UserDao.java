package com.sachin.slog.dao;

import com.sachin.slog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户Dao层
 *
 * @author sachin
 * @create 2018-07-29 11:06
 */
public interface UserDao extends JpaRepository<User, String> {
    /**
     * 通过登录账号查询用户
     * @param login 登录账号
     * @return 返回用户对象
     */
    User findByLogin(String login);
}
