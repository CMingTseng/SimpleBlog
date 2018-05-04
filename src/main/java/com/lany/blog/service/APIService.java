package com.lany.blog.service;


import com.lany.blog.entity.Result;

public interface APIService {

    Result findByUsername(String name);

    Result findByNickname(String name);
}