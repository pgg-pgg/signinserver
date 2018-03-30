package com.example.signinserver.service;

import com.example.signinserver.domain.User;

public interface UserEbi {

    /**
     * 注册一个用户
     */
    void insertUser(User user);

    /**
     * 通过id找到一个用户
     * @param id
     * @return
     */
    User searchUserById(String id);
}
