package com.jia.mapper;

import com.jia.ApplicationTests;
import com.jia.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserMapperTest extends ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    @Transactional
    public void insert() {
        User user = new User();
        user.setName("李四");
        user.setAge(20);
        userMapper.insert(user);
    }

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        Assert.assertTrue(users != null);
    }

    @Test
    public void selectByAccount() {
        User lili = userMapper.selectByAccount("lili");
        System.out.println(lili);
    }
}