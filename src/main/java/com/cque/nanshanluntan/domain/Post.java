package com.cque.nanshanluntan.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private Integer id; // 帖子id
    private String userName; // 发帖人
    private String postTitle; // 帖子标题
    private String postText; // 帖子内容
    private Integer postView; // 帖子浏览数
    private Integer postReplies; // 帖子回帖数
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 发帖时间

    public void setPostView(Integer num)
    {
        this.postView=num;
    }
}
