package com.sachin.slog.exception;

import com.sachin.slog.common.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class HandlerException {

    /**
     * 查询结果为找到异常
     * @param e 异常信息
     * @return
     */
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public JsonResult notFoundHandler(Exception e) {
        return JsonResult.createByErrorMsg(e.getMessage());
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

    /**
     * 需要登录处理的异常
     * @return 返回登录界面
     */
    public ModelAndView needLoginHandler() {
        return new ModelAndView("login");
    }
}
