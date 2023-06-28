package com.cque.nanshanluntan.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
 * 前端不会接收到密码（只写）
 * 后端可以写，可以读
 */
@Data
public class User {
    private Integer id; // 用户id
    private String userName; // 用户名
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password; // 密码
    private Integer userType; // 用户类型
    private Integer locked; // 用户状态
}
