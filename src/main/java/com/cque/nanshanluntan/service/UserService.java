package com.cque.nanshanluntan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;

public interface UserService extends IService<User> {
    /**
     * 登录
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    R login(String userName, String password);

    /**
     * 注册
     * @param user 用 user 接收参数
     * @return
     */
    R register(User user);
}
