package com.lany.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIResult {
    private int code;
    private String msg;
    private Object data;

    public APIResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}