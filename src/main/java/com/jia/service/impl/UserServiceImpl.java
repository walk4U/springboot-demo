package com.jia.service.impl;

import com.jia.mapper.UserMapper;
import com.jia.model.entity.User;
import com.jia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public User getUserByName(String account) {
        return userMapper.selectByAccount(account);
    }
}
