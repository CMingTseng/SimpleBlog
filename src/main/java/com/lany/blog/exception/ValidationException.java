package com.lany.blog.exception;

public class ValidationException  extends RuntimeException {

    public ValidationException() {
        super("参数验证失败");
    }
}