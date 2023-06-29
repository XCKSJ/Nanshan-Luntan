package com.cque.nanshanluntan.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
 * 在属性上加上注解，对日期进行格式化
 * 解决：后端为日期格式，前端接收到的不是日期格式
 */
@Data
public class Reply {
    private Integer id; // 回帖id
    private String userName; // 回帖人
    private String replyText; // 回帖内容
    private Integer postId; // 帖子id
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 回帖时间
}
