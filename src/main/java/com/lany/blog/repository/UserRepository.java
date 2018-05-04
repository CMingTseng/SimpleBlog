package com.lany.blog.repository;

import com.lany.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "from User u where u.username like :name")
    List<User> findByUsername(@Param("name") String name);

    @Query(value = "from User u where u.nickname=:name")
    List<User> findByNickname(@Param("name") String name);
}