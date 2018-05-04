package com.lany.blog.service;

import com.lany.blog.entity.Result;
import com.lany.blog.entity.User;
import com.lany.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result<List<User>> findByUsername(String name) {
        Result<List<User>> result = new Result<>();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData(userRepository.findByUsername(name));
        return result;
    }

    @Override
    public Result<List<User>> findByNickname(String name) {
        Result<List<User>> result = new Result<>();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData(userRepository.findByNickname(name));
        return result;
    }
}
