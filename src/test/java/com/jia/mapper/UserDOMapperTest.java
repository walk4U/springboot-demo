package com.jia.mapper;

import com.jia.ApplicationTests;
import com.jia.model.entity.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDOMapperTest extends ApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    @Transactional
    public void insert() {
        UserDO userDO = new UserDO();
        userDO.setName("李四");
        userDO.setAge(20);
        userMapper.insert(userDO);
    }

    @Test
    public void selectAll() {
        List<UserDO> userDOS = userMapper.selectAll();
        Assert.assertTrue(userDOS != null);
    }

    @Test
    public void selectByAccount() {
        UserDO lili = userMapper.selectByAccount("lili");
        System.out.println(lili);
    }
}