package com.lany.blog.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult {
    private int code;
    private String msg;
    private Object data;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
