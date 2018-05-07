package com.lany.blog.controller;

import com.lany.blog.result.ResponseResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class NotFoundController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/error")
    public ResponseResult error(HttpServletResponse response, HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        result.setCode(404);
        result.setMsg("接口不存在");
        return result;
    }
}