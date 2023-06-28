package com.cque.nanshanluntan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpSession;

public interface UserService extends IService<User> {
    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    R login(String userName, String password, HttpSession session);

    /**
     * 注册
     * @param user 用 user 接收参数
     * @return
     */
    R register(User user);

    /**
     * 退出登录
     * @param session
     * @return
     */
    R logOut(HttpSession session);
}
