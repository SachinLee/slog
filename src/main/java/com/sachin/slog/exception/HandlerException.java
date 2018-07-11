package com.sachin.slog.exception;

import com.sachin.slog.common.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(value = NotFoundException.class)
    public JsonResult jsonErrorHandler() {
        return JsonResult.createByErrorMsg("当前结果不存在");
    }



}
