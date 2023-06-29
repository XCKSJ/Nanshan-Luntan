package com.cque.nanshanluntan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.Post;

import javax.servlet.http.HttpSession;

public interface PostService extends IService<Post> {
    /**
     * 添加帖子
     * @param post 帖子
     * @return
     */
    R addPost(Post post, HttpSession session);

    /**
     * 获取一页帖子数据
     * @return
     */
    R getPostAll(Integer currentPage, Integer pageSize, HttpSession session);

    /**
     * 删除帖子
     * @param id 用户帖子
     * @return
     */
    R deletePostById(Integer id);

    /**
     * 有条件获取一页帖子数据
     * @return
     */
    R getPostAll2(Integer currentPage, Integer pageSize, HttpSession session);

    /**
     * 修改浏览数、回帖数
     * @param post
     * @return
     */
    R updatePostView(Post post);
}
