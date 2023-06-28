package com.cque.nanshanluntan.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Post {
    private Integer id; // 帖子id
    private Integer postUserId; // 用户id
    private String postTitle; // 帖子标题
    private String postPicture; // 帖子图片
    private String postText; // 帖子内容
    private Integer postView; // 帖子浏览数
    private Integer postReplies; // 帖子回帖数
    private Date createTime; // 发帖时间
}
