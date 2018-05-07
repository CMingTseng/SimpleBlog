package com.lany.blog.service;


import com.lany.blog.entity.APIResult;

public interface APIService {

    APIResult findByUsername(String name);

    APIResult findByNickname(String name);
}