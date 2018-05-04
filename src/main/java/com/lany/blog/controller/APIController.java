package com.lany.blog.controller;

import com.lany.blog.entity.Result;
import com.lany.blog.entity.User;
import com.lany.blog.service.APIService;
import com.lany.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class APIController {
    @Autowired
    APIService mAPIService;

    @RequestMapping("/info")
    public Result findByUsername(@RequestParam String name) {
        return mAPIService.findByUsername(name);
    }

    @RequestMapping("/info2")
    public Result findByNickname(@RequestParam String name) {
        return mAPIService.findByNickname(name);
    }
}
