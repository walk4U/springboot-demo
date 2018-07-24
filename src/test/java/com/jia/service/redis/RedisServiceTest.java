package com.jia.service.redis;

import com.jia.ApplicationTests;
import com.jia.model.entity.User;
import com.jia.redis.RedisService;
import com.jia.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RedisServiceTest extends ApplicationTests {

    @Autowired
    RedisService redisService;

    @Autowired
    UserService userService;

    @Test
    public void set() {
        List<User> allUser = userService.findAllUser();
        boolean res = redisService.set("allUser", allUser);
        System.out.println(res);
    }

    @Test
    public void set1() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void removePattern() {
    }

    @Test
    public void remove1() {
    }

    @Test
    public void exists() {
    }

    @Test
    public void get() {
        Object result = redisService.get("allUser");
        System.out.println(result);
    }

    @Test
    public void hmSet() {
    }

    @Test
    public void hmGet() {
    }

    @Test
    public void lPush() {
    }

    @Test
    public void lRange() {
    }

    @Test
    public void add() {
    }

    @Test
    public void setMembers() {
    }

    @Test
    public void zAdd() {
    }

    @Test
    public void rangeByScore() {
    }
}