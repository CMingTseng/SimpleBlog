package com.lany.blog.controller;

import com.lany.blog.exception.TokenOverTimeException;
import com.lany.blog.exception.ValidationException;
import com.lany.blog.result.ResponseResult;
import com.lany.blog.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.Collections;

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
    public void hello() {
        throw new ValidationException();
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
