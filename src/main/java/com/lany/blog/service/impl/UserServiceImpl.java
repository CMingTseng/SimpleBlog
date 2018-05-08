package com.lany.blog.service.impl;

import com.lany.blog.entity.User;
import com.lany.blog.repository.UserRepository;
import com.lany.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository mRepository;

    @Override
    public User findById(Long id) {
        Optional<User> optional = mRepository.findById(id);
        return optional.get();
    }

    @Override
    public List<User> findByUserName(String userName) {
        return mRepository.findByUserName(userName);
    }

    @Override
    public List<User> search(String keyword) {
        return mRepository.findByUserNameOrEmailOrNickName(keyword,keyword,keyword);
    }

//    @Override
//    public List<User> findByNickname(String nickName) {
//        //创建查询条件数据对象
//        User user = new User();
//        user.setNickName(nickName);
//
//        //创建匹配器，即如何使用查询条件
//        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
//                .withMatcher("nickname", ExampleMatcher.GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
//                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//        //创建实例
//        Example<User> example = Example.of(user, matcher);
//        //查询
//        return mRepository.findAll(example);
//    }

}
