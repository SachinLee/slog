package com.sachin.slog.exception;

/**
 * 未登录异常
 *
 * @author sachin
 * @create 2018-07-29 20:26
 */
public class NeedLoginException extends RuntimeException {

    public NeedLoginException(String message) {
        super(message);
    }
}
