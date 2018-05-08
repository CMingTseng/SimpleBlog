package com.lany.blog.controller;

import com.lany.blog.entity.User;
import com.lany.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService mUserService;

    @RequestMapping("/detail")
    public User detail(@RequestParam long id) {
        return mUserService.findById(id);
    }

    @RequestMapping("/search")
    public List<User> search(@RequestParam String keyword) {
        return mUserService.search(keyword);
    }
}
