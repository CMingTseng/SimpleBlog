package com.lany.blog.service.impl;

import com.lany.blog.entity.Article;
import com.lany.blog.repository.ArticleRepository;
import com.lany.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository mRepository;

    @Override
    public Article findById(Long id) {
        Optional<Article> article = mRepository.findById(id);
        return article.get();
    }

    @Override
    public List<Article> search(String keyword) {
        //创建查询条件数据对象
        Article article = new Article();
        article.setContent(keyword);
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
        //创建实例
        Example<Article> example = Example.of(article, matcher);
        return mRepository.findAll(example);
    }
}