package com.sachin.slog.common.base;

import com.sachin.slog.exception.NeedLoginException;
import com.sachin.slog.vo.SecurityUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * BaseController
 *
 * @author sachin
 * @create 2018-07-29 20:23
 */
public abstract class BaseController {

    /**
     * 获取当前登录用户
     *
     * @return SecurityUser
     */
    @ModelAttribute("currentUser")
    public SecurityUser getCurrentUser() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SecurityUser) {
            return (SecurityUser) obj;
        }
        throw new NeedLoginException("请重新登录");
    }

}
