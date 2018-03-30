package com.example.signinserver.service.impl;

import com.example.signinserver.dao.UserDao;
import com.example.signinserver.domain.User;
import com.example.signinserver.service.UserEbi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserEbo implements UserEbi{
    @Resource
    public UserDao userDao;


    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User searchUserById(String id) {
        return userDao.searchUserById(id);
    }
}
