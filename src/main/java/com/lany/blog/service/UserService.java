package com.lany.blog.service;


import com.lany.blog.entity.User;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    List<User> findByUsername(String name);

    List<User> findByNickname(String name);
}