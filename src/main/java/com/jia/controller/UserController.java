package com.jia.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jia.model.User;
import com.jia.model.result.Result;
import com.jia.service.UserService;
import com.jia.service.redis.RedisService;
import com.jia.utils.RedisObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Result getAllUser() {
        logger.info("Start to get all user");
        Object allUser = redisService.get("USERS");
        List<User> users;
        if(allUser == null) {
            users = userService.findAllUser();
            redisService.set("USERS", users);
        } else {
            users = RedisObjectUtil.convertToList(allUser, User.class);
        }
        return Result.success(users);
    }


}
