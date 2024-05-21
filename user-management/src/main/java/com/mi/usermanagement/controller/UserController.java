package com.mi.usermanagement.controller;

import com.mi.usermanagement.model.Result;
import com.mi.usermanagement.model.User;
import com.mi.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/user-management")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody @Validated User user) {
        if (userService.findByUserName(user.getUserName()) == null) {
            userService.register(user);
            return Result.success("注册成功");
        } else {
            return Result.error("用户名已被注册");
        }
    }

    @PostMapping("/login")
    public Result login(@RequestBody @Validated User user) {
        User loggedInUser = userService.login(user);
        if (loggedInUser != null) {
            return Result.success("登录成功", loggedInUser);
        } else {
            return Result.error("用户名或密码错误");
        }
    }
}
