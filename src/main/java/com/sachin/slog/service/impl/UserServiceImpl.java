package com.sachin.slog.service.impl;

import com.google.common.collect.Lists;
import com.sachin.slog.common.base.BaseServiceImpl;
import com.sachin.slog.dao.UserDao;
import com.sachin.slog.pojo.User;
import com.sachin.slog.service.UserService;
import com.sachin.slog.vo.SecurityUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户Service实现
 *
 * @author sachin
 * @create 2018-07-29 11:23
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public JpaRepository getDao() {
        return userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(login)) {
            return null;
        }
        User user = userDao.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("账号不存在");
        }

        //TODO 获取用户的权限信息
        List<GrantedAuthority> authorities = Lists.newArrayList();

        SecurityUser securityUser = new SecurityUser(user.getId(),
                user.getLogin(), user.getPassword(), authorities);



        return null;
    }

    @Override
    public User createUser(User user) {
        // TODO 验证信息是否重复；

        user.setEncodePassword(user.getPassword());
        User createUser = super.save(user);
        return createUser;
    }
}
