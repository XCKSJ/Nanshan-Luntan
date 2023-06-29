package com.cque.nanshanluntan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.Reply;

import javax.servlet.http.HttpSession;

public interface ReplyService extends IService<Reply> {
    /**
     * 添加回帖
     * @param reply
     * @return
     */
    R addReply(Reply reply, HttpSession session);

    /**
     * 获取回帖
     * @param postId
     * @return
     */
    R getReply(Integer postId);
}
