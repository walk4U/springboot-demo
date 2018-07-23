package com.jia.controller;

import com.jia.model.User;
import com.jia.model.result.CodeMsg;
import com.jia.model.result.Result;
import com.jia.service.UserService;
import com.jia.service.redis.RedisService;
import com.jia.shiro.PasswordEncrypt;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncrypt passwordEncrypt;

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
            return Result.success(users);
        } else {
            return  Result.success(allUser);
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(User user) {
        if(user == null || StringUtils.isBlank(user.getAccount())
                || StringUtils.isBlank(user.getPassword())
                || StringUtils.isBlank(user.getName())) {
            return Result.fail(CodeMsg.PARAMETER_ISNULL);
        }
        passwordEncrypt.encryptPassword(user);
        int i = userService.insert(user);
        if(i==1) {
            return Result.success();
        } else {
            return Result.fail(CodeMsg.USER_REGISTER_FAIL);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Result login(String account, String password) {
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
            return Result.fail(CodeMsg.PARAMETER_ISNULL);
        }
        // 创建用户登录信息
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        token.setRememberMe(false);
        try {
            // 登录，如果失败，会有相应的异常抛出
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            return Result.fail(CodeMsg.USER_NOT_EXIST);
        } catch (IncorrectCredentialsException e) {
            return Result.fail(CodeMsg.ACCOUNT_OR_PSW_ERR);
        } catch (LockedAccountException e) {
            return Result.fail(CodeMsg.ACCOUNT_LOCKED);
        } catch (AuthenticationException e) {
            return Result.fail(CodeMsg.AUTHOR_ERR);
        }
        return Result.success();
    }

    @RequestMapping(value = "/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.success();
    }
}
