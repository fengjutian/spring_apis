package com.fjtneo4j.demo.repository;

import com.fjtneo4j.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 这里你可以添加自定义的查询方法，如：
    User findByEmail(String email);
}
