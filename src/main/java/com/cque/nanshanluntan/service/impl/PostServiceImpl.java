package com.cque.nanshanluntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.Post;
import com.cque.nanshanluntan.domain.User;
import com.cque.nanshanluntan.mapper.PostMapper;
import com.cque.nanshanluntan.service.PostService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    /**
     * 添加帖子
     * @param post 帖子
     * @return
     */
    @Override
    public R addPost(Post post, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        post.setUserName(userName);

        boolean save = this.save(post);
        if(save){
            return new R(200, "添加成功", true);
        }
        return new R(201, "添加失败", false);
    }

    /**
     * 获取一页帖子数据
     * @return
     */
    @Override
    public R getPostAll(Integer currentPage, Integer pageSize, HttpSession session) {
        LambdaQueryWrapper<Post> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Post::getCreateTime);

        Page<Post> page = this.page(new Page<>(currentPage, pageSize), queryWrapper);

        if(page != null){
            return new R(200, "查询成功", page);
        }
        return new R(201, "网络不好，请重试", null);
    }

    /**
     * 删除帖子
     * @param id 用户帖子
     * @return
     */
    @Override
    public R deletePostById(Integer id) {
        boolean remove = this.removeById(id);

        if(remove){
            return new R(200, "删除成功", true);
        }
        return new R(201, "删除失败", false);
    }

    /**
     * 有条件获取一页帖子数据
     * @return
     */
    @Override
    public R getPostAll2(Integer currentPage, Integer pageSize, HttpSession session) {
        String userName = (String) session.getAttribute("userName");

        LambdaQueryWrapper<Post> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Post::getUserName, userName);

        Page<Post> page = this.page(new Page<>(currentPage, pageSize), queryWrapper);

        if(page != null){
            return new R(200, "查询成功", page);
        }
        return new R(201, "网络不好，请重试", null);
    }

    /**
     * 修改浏览数、回帖数
     * @param post
     * @return
     */
    @Override
    public R updatePostView(Post post) {
        System.out.println(post.getPostView()+1);
        post.setPostView(post.getPostView()+1);
        boolean update = this.updateById(post);
        if(update){
            return new R(200, "修改成功", post);
        }
        return new R(201, "修改失败", false);
    }
}
