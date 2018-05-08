package com.lany.blog.controller;

import com.lany.blog.entity.Article;
import com.lany.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {
    @Autowired
    ArticleService mArticleService;
//
//    @RequestMapping("/detail")
//    public Article detail(@RequestParam String id) {
//        return mArticleService.
//    }

    @RequestMapping("/search")
    public List<Article> search(@RequestParam String keyword) {
        return mArticleService.search(keyword);
    }
//
//    @RequestMapping("/info2")
//    public List<User> findByNickname(@RequestParam String name) {
//        return mArticleService.findByNickname(name);
//    }
}
