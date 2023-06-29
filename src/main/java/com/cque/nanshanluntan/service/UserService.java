package com.cque.nanshanluntan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
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
     * @return
     */
    R logOut(HttpSession session);

    /**
     * 获取缓存中的用户名
     * @return
     */
    R getUserName(HttpSession session);

    /**
     * 获取所有用户数据
     * @return
     */
    R getUserAll(Integer currentPage, Integer pageSize);

    /**
     * 修改用户信息
     * @return
     */
    R updateUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    R deleteUserById(Integer id);

    /**
     * 获取登录用户信息
     * @return
     */
    R getUser(HttpSession session);
}
