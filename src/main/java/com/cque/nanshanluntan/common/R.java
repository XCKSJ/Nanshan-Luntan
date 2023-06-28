package com.cque.nanshanluntan.common;

import lombok.Data;

@Data
public class R {
    private Integer code; // 状态码
    private String msg; // 信息
    private Object data; // 数据

    public R() {
    }

    public R(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
