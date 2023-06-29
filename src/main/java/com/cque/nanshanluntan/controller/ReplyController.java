package com.cque.nanshanluntan.controller;

import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.Post;
import com.cque.nanshanluntan.domain.Reply;
import com.cque.nanshanluntan.service.ReplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/replys")
public class ReplyController {
    @Resource
    ReplyService replyService;

    /**
     * 添加回帖
     * @param reply
     * @return
     */
    @PostMapping("/addReply")
    public R addReply(@RequestBody Reply reply, HttpSession session){
        return replyService.addReply(reply, session);
    }

    /**
     * 获取回帖
     * @param postId
     * @return
     */
    @GetMapping("/getReply")
    public R getReply(Integer postId){
        return replyService.getReply(postId);
    }
}
