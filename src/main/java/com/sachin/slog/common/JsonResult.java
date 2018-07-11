package com.sachin.slog.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回包含单个对象的结果对象
 * @param <T>
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) //过时了,推荐使用下边的注解。
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResult<T> implements Serializable {

    private int code;

    private String message;

    private T data;

    private JsonResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
    private JsonResult(ResultEnum resultEnum, String message) {
        this.code = resultEnum.getCode();
        this.message = message;
    }
    private JsonResult(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.data = data;
    }
    private JsonResult(ResultEnum resultEnum, String message, T data) {
        this.code = resultEnum.getCode();
        this.message = message;
        this.data = data;
    }

    private JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private JsonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.code == ResultEnum.SUCCESS.getCode();
    }

    public static <T> JsonResult<T> createBySuccess() {
        return new JsonResult<T>(ResultEnum.SUCCESS);
    }
    public static  <T> JsonResult<T> createBySuccessMsg(String message) {
        return new JsonResult<T>(ResultEnum.SUCCESS, message);
    }
    public static <T> JsonResult<T> createBySuccessData(T data) {
        return new JsonResult<T>(ResultEnum.SUCCESS, data);
    }
    public static  <T> JsonResult<T> createBySuccessMsgAndData(String message, T data) {
        return new JsonResult<T>(ResultEnum.SUCCESS, message,data);
    }

    public static  <T> JsonResult<T> createByError() {
        return new JsonResult<T>(ResultEnum.ERROR);
    }
    public static  <T> JsonResult<T> createByErrorMsg(String message) {
        return new JsonResult<T>(ResultEnum.ERROR, message);
    }
    public static  <T> JsonResult<T> createByErrorData(T data) {
        return new JsonResult<T>(ResultEnum.ERROR, data);
    }
    public static  <T> JsonResult<T> createByErrorMsgAndData(String message, T data) {
        return new JsonResult<T>(ResultEnum.ERROR, message,data);
    }
}
