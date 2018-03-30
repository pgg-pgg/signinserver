package com.example.signinserver.dao;


import com.example.signinserver.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    /**
     * 注册用户
     * POST
     * @return
     */
    void insertUser(User user);
    /**
     * 得到一个用户
     */
    User searchUserById(String id);
}
