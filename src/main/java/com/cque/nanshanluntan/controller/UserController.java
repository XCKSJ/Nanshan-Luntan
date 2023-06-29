package com.cque.nanshanluntan.controller;

import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;
import com.cque.nanshanluntan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
     * @return
     */
    @GetMapping("/logOut")
    public R logOut(HttpSession session){
        return userService.logOut(session);
    }

    /**
     * 获取缓存中的用户名
     * @return
     */
    @GetMapping("/getUserName")
    public R getUserName(HttpSession session){
        return userService.getUserName(session);
    }

    /**
     * 获取一页用户数据
     * @return
     */
    @GetMapping("/getUserAll")
    public R getUserAll(Integer currentPage, Integer pageSize){
        return userService.getUserAll(currentPage, pageSize);
    }

    /**
     * 修改用户信息
     * @return
     */
    @PostMapping("/updateUser")
    public R updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    @DeleteMapping("/deleteUserById")
    public R deleteUserById(Integer id){
        return userService.deleteUserById(id);
    }
}
