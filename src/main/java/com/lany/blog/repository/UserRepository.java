package com.lany.blog.repository;

import com.lany.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);

    List<User> findByUserNameOrEmailOrNickName(String userName, String email, String nickName);
}