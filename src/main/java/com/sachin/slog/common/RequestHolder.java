package com.sachin.slog.common;

import com.sachin.slog.pojo.User;

import javax.servlet.http.HttpServletRequest;

public class RequestHolder {

    private static final ThreadLocal<User> USER_HOLDER = new ThreadLocal<>();

    private static final ThreadLocal<HttpServletRequest> REQUEST_HOLDER = new ThreadLocal<>();

    protected RequestHolder() { }

    /**
     * 添加用户
     * @param user 用户信息
     */
    public static void add(User user) {
        USER_HOLDER.set(user);
    }

    /**
     * 添加请求信息
     * @param request 请求信息
     */
    public static void add(HttpServletRequest request) {
        REQUEST_HOLDER.set(request);
    }

    /**
     * 获取当前请求信息
     * @return 返回当前请求信息
     */
    public static HttpServletRequest getCurrentRequest() {
        return REQUEST_HOLDER.get();
    }

    /**
     * 获取当前用户信息
     * @return 返回用户信息
     */
    public static User getCurrentUser() {
        return USER_HOLDER.get();
    }

    /**
     * 移除当前用户和请求信息
     */
    public static void remove() {
        USER_HOLDER.remove();
        REQUEST_HOLDER.remove();
    }
}
