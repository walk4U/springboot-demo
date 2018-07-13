package com.jia.mapper;

import com.jia.ApplicationTests;
import com.jia.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest extends ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        Assert.assertTrue(users != null);
    }

}