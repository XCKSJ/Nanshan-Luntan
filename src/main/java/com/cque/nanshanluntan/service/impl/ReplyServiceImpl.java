package com.cque.nanshanluntan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cque.nanshanluntan.common.R;
import com.cque.nanshanluntan.domain.Reply;
import com.cque.nanshanluntan.mapper.ReplyMapper;
import com.cque.nanshanluntan.service.ReplyService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {
    /**
     * 添加回帖
     * @param reply
     * @return
     */
    @Override
    public R addReply(Reply reply, HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        reply.setUserName(userName);

        boolean save = this.save(reply);
        if(save){
            return new R(200, "添加成功", true);
        }
        return new R(201, "添加失败", false);
    }

    /**
     * 获取回帖
     * @param postId
     * @return
     */
    @Override
    public R getReply(Integer postId) {
        LambdaQueryWrapper<Reply> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Reply::getPostId, postId);

        List<Reply> list = this.list(queryWrapper);

        if(list.isEmpty()){
            return new R(201, "查询失败", false);
        }
        return new R(200, "查询成功", list);
    }
}
