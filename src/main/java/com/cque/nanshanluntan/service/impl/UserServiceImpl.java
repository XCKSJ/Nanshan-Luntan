package com.cque.nanshanluntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.User;
import com.cque.nanshanluntan.mapper.UserMapper;
import com.cque.nanshanluntan.service.UserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * 登录
     * @return
     */
    @Override
    public R login(String userName, String password, HttpSession session) {
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
                session.setAttribute("id", user.getId());
                session.setAttribute("userName", user.getUserName());

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

    /**
     * 退出登录
     * @return
     */
    @Override
    public R logOut(HttpSession session) {
        session.removeAttribute("id");
        session.removeAttribute("userName");

        return new R(200, "退出成功", true);
    }

    /**
     * 获取缓存中的用户名
     * @return
     */
    @Override
    public R getUserName(HttpSession session) {
        Object userName = session.getAttribute("userName");
        return new R(200, "用户名", userName);
    }

    /**
     * 获取一页用户数据
     * @return
     */
    @Override
    public R getUserAll(Integer currentPage, Integer pageSize) {
        Page<User> page = this.page(new Page<>(currentPage, pageSize));
        if(page != null){
            return new R(200, "查询成功", page);
        }
        return new R(201, "网络不好，请重试", null);
    }

    /**
     * 修改用户信息
     * @return
     */
    @Override
    public R updateUser(User user) {
        boolean update = this.updateById(user);
        if(update){
            return new R(200, "修改成功", true);
        }
        return new R(201, "修改失败", false);
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    @Override
    public R deleteUserById(Integer id) {
        boolean remove = this.removeById(id);

        if(remove){
            return new R(200, "删除成功", true);
        }
        return new R(201, "删除失败", false);
    }
}
