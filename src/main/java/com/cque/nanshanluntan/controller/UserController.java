package com.cque.nanshanluntan.controller;

import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;
import com.cque.nanshanluntan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    UserService userService;

    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public R login(String userName, String password){
        return userService.login(userName, password);
    }

    /**
     * 注册
     * @param user 用 user 接收参数
     * @return
     */
    @PostMapping("/register")
    public R register(@RequestBody User user){
        return userService.register(user);
    }
}
