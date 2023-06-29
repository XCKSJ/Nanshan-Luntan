package com.cque.nanshanluntan.controller;

import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.Post;
import com.cque.nanshanluntan.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Resource
    PostService postService;

    /**
     * 添加帖子
     * @param post 帖子
     * @return
     */
    @PostMapping("/addPost")
    public R addPost(@RequestBody Post post, HttpSession session){
        return postService.addPost(post, session);
    }

    /**
     * 按时间降序帖子数据
     * @return
     */
    @GetMapping("/getPostAll")
    public R getPostAll(Integer currentPage, Integer pageSize, HttpSession session){
        return postService.getPostAll(currentPage, pageSize,session);
    }

    /**
     * 删除帖子
     * @param id 用户帖子
     * @return
     */
    @DeleteMapping("/deletePostById")
    public R deletePostById(Integer id){
        return postService.deletePostById(id);
    }

    /**
     * 按用户名获取一页帖子数据
     * @return
     */
    @GetMapping("/getPostAll2")
    public R getPostAll2(Integer currentPage, Integer pageSize, HttpSession session){
        return postService.getPostAll2(currentPage, pageSize, session);
    }

    /**
     * 修改浏览数、回帖数
     * @param post
     * @return
     */
    @PutMapping("/updatePostView")
    public R updatePostView(@RequestBody Post post){
        return postService.updatePostView(post);
    }


}
