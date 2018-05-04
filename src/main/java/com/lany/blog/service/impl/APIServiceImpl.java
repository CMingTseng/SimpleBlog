package com.lany.blog.service.impl;

import com.lany.blog.entity.Result;
import com.lany.blog.service.APIService;
import com.lany.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class APIServiceImpl implements APIService {
    @Autowired
    UserService mUserService;

    @Override
    public Result findByUsername(String name) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData(mUserService.findByUsername(name));
        return result;
    }

    @Override
    public Result findByNickname(String name) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("请求成功");
        result.setData(mUserService.findByNickname(name));
        return result;
    }
}
