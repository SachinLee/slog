package com.sachin.slog.common;

import lombok.Getter;

import java.util.stream.Stream;


@Getter
public enum ResultEnum {

    SUCCESS(0, "请求成功"),
    ERROR(-1, "请求失败");

    private int code;

    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultEnum getResultByCode(int code) {
        /*for (ResultEnum resultEnum : values()) {
            if (resultEnum.getCode() == code) {
                return resultEnum;
            }
        }
        return null;*/
        return Stream.of(values()).filter(r -> r.getCode() == code).findAny().orElse(null);
    }
}
