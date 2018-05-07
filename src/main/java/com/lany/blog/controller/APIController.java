package com.lany.blog.controller;

import com.lany.blog.result.ResponseResult;
import com.lany.blog.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult hello() {
        return new ResponseResult(0, "请求成功", "this is hello");
    }

    @RequestMapping("/info")
    public ResponseResult findByUsername(@RequestParam String name) {
        return mAPIService.findByUsername(name);
    }

    @RequestMapping("/info2")
    public ResponseResult findByNickname(@RequestParam String name) {
        return mAPIService.findByNickname(name);
    }
}
