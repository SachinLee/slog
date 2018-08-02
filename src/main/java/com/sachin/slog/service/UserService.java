package com.sachin.slog.service;

import com.sachin.slog.common.base.BaseService;
import com.sachin.slog.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author sachin
 * @create 2018-07-29 11:22
 * 用户Service
 */
public interface UserService extends BaseService<User, String>, UserDetailsService {

    /**
     * 创建用户信息
     * @param user 用户对象
     * @return 返回创建的用户
     */
    public User createUser(User user);
}
