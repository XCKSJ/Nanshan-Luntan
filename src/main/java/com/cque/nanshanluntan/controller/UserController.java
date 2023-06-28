package com.cque.nanshanluntan.controller;

import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;
import com.cque.nanshanluntan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public R login(String userName, String password, HttpSession session){
        return userService.login(userName, password, session);
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

    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping("/logOut")
    public R logOut(HttpSession session){
        return userService.logOut(session);
    }
}
