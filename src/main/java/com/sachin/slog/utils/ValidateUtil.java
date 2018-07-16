package com.sachin.slog.utils;

import com.sachin.slog.common.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

/**
 * 获取实体类字段验证信息
 *
 * @author sachin
 * @create 2018-07-12 20:23
 */
public final class ValidateUtil {

    private ValidateUtil() { }

    /**
     * 获取字段校验错误信息
     * @param errors 错误信息
     * @return 返回json结果
     */
    public static JsonResult getParamError(BindingResult errors) {
        StringBuffer msg = new StringBuffer();
        errors.getAllErrors().stream().forEach(error -> addError(error, msg));
        return JsonResult.createByErrorMsg(msg.toString());
    }

    /**
     * 组合错误信息
     * @param error 错误信息
     * @param msg 错误信息字符串
     * @return 返回字符串
     */
    private static String addError(ObjectError error, StringBuffer msg) {
        if (StringUtils.isEmpty(msg)) {
            msg.append(error);
        } else {
            msg.append(",");
            msg.append(error.getDefaultMessage());
        }
        return msg.toString();
    }
}
