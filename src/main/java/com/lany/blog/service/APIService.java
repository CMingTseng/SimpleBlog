package com.lany.blog.service;


import com.lany.blog.result.ResponseResult;

public interface APIService {

    ResponseResult findByUsername(String name);

    ResponseResult findByNickname(String name);
}