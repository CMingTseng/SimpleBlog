package com.lany.blog.exception;

public class TokenOverTimeException extends RuntimeException {

    public TokenOverTimeException() {
        super("token已过期，请重新登录");
    }
}
