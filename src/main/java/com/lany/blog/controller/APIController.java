package com.lany.blog.controller;

import com.lany.blog.entity.Result;
import com.lany.blog.entity.User;
import com.lany.blog.service.APIService;
import com.lany.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class APIController {
    @Autowired
    APIService mAPIService;

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public User putUser(@PathVariable Long id) {
//        User user = new User();
//        user.setId(id);
//        user.setAge(18);
//        user.setName("user" + id);
//        return user;
//    }

    @RequestMapping("/hello")
    public Result hello() {
        return new Result(0, "请求成功", "this is hello");
    }

    @RequestMapping("/info")
    public Result findByUsername(@RequestParam String name) {
        return mAPIService.findByUsername(name);
    }

    @RequestMapping("/info2")
    public Result findByNickname(@RequestParam String name) {
        return mAPIService.findByNickname(name);
    }
}
