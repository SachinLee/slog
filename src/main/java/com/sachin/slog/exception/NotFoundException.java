package com.sachin.slog.exception;

/**
 * 未找到结果异常
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String msg) {
        super(msg);
    }

}
