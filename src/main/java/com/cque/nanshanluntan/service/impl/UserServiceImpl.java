package com.cque.nanshanluntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;
import com.cque.nanshanluntan.mapper.UserMapper;
import com.cque.nanshanluntan.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 登录
     * @return
     */
    @Override
    public R login(String userName, String password) {
        System.out.println(userName+"---"+password);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, userName);

        User user = this.getOne(queryWrapper);

        if(user == null){
            return new R(201, "用户不存在", null);
        }

        if(password.equals(user.getPassword())){
            if(user.getLocked() == 1){
                // 未锁定
                return new R(200, "登录成功", user);
            }
            return new R(201, "用户被锁定", null);
        }
        return new R(201, "登录密码不正确", null);
    }

    /**
     * 注册
     * @param user 用 user 接收参数
     * @return
     */
    @Override
    public R register(User user) {
        System.out.println(user);

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, user.getUserName());
        User u = this.getOne(queryWrapper);
        if(u != null){
            return new R(201, "用户名重复，请重新输入", false);
        }

        boolean status = this.save(user);

        if(status){
            return new R(200, "注册成功", true);
        }
        return new R(201, "服务器错误，请稍后重试", false);
    }
}
