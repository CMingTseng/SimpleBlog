package com.lany.blog.service;


import com.lany.blog.entity.Result;
import com.lany.blog.entity.User;

import java.util.List;

public interface UserService {

    Result<List<User>> findByUsername(String name);

    Result<List<User>> findByNickname(String name);
}