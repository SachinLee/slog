package com.sachin.slog.exception;

import com.sachin.slog.common.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class HandlerException {

    /**
     * 查询结果为找到异常
     * @return
     */
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public JsonResult notFoundHandler() {
        return JsonResult.createByErrorMsg("当前结果不存在!");
    }

    /**
     * 系统异常
     * @return
     */
    @ExceptionHandler(value = SysException.class)
    @ResponseBody
    public JsonResult sysErrorHandler() {
        return JsonResult.createByErrorMsg("系统异常，请稍后重试!");
    }


}
