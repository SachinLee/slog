package com.sachin.slog.controller.back;

import com.sachin.slog.common.JsonResult;
import com.sachin.slog.common.base.BaseController;
import com.sachin.slog.pojo.User;
import com.sachin.slog.service.UserService;
import com.sachin.slog.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户管理部分Controller
 *
 * @author sachin
 * @create 2018-07-29 20:23
 */
@RestController
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 创建用户
     * @param user 用户对象
     * @param errors 验证结果
     * @return 返回创建结果
     */
    @PostMapping(value = "/createUser")
    public JsonResult createUser(@Valid User user, BindingResult errors) {
        JsonResult result = ValidateUtil.getParamError(errors);
        if (result.isSuccess()) {
            userService.save(user);
        }
        return result;
    }

}
