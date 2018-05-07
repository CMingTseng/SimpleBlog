package com.lany.blog.service.impl;

import com.lany.blog.entity.APIResult;
import com.lany.blog.entity.User;
import com.lany.blog.service.APIService;
import com.lany.blog.service.UserService;
import com.lany.blog.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class APIServiceImpl implements APIService {
    @Autowired
    UserService mUserService;

    @Override
    public APIResult findByUsername(String name) {
        List<User> users = mUserService.findByUsername(name);
        APIResult APIResult = new APIResult(1, "请求成功");
        if (!ListUtils.isEmpty(users)) {
            APIResult.setData(users);
        }
        return APIResult;
    }

    @Override
    public APIResult findByNickname(String name) {
        List<User> users = mUserService.findByNickname(name);
        APIResult APIResult = new APIResult(1, "请求成功");
        if (!ListUtils.isEmpty(users)) {
            APIResult.setData(users);
        }
        return APIResult;
    }
}
