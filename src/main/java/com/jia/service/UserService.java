package com.jia.service;

import com.jia.model.entity.User;

import java.util.List;

public interface UserService {

    int insert(User user);

    List<User> findAllUser();

    User getUserByName(String account);
}
