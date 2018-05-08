package com.lany.blog.service;


import com.lany.blog.entity.Article;

import java.util.List;

public interface ArticleService extends BaseService<Article, Long> {
    List<Article> search(String keyword);
}