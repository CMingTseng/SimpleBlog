package com.lany.blog.service.impl;

import com.lany.blog.entity.User;
import com.lany.blog.repository.UserRepository;
import com.lany.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findByUsername(String name) {
        User user = new User();
        user.setUsername(name);
        Example<User> example = Example.of(user);
        return userRepository.findAll(example);
    }

    @Override
    public List<User> findByNickname(String name) {
        //创建查询条件数据对象
        User user = new User();
        user.setNickname(name);

        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
        //创建实例
        Example<User> example = Example.of(user, matcher);
        //查询
        List<User> users = userRepository.findAll(example);
        return users;
    }
}
