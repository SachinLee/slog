package com.sachin.slog.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 返回包含List的结果对象
 * @param <T>
 */
@Data
public class PageResult<T> implements Serializable {

    private int code;

    private String msg;

    private int count;

    private List<T> data;

    public PageResult(){}

    public PageResult(ResultEnum resultEnum, List<T> data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMessage();
        this.data = data;
    }
    public PageResult(ResultEnum resultEnum, int count, List<T> data) {
        this(resultEnum, data);
        this.count = count;
    }

    public PageResult(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
