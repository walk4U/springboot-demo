package com.jia.shiro;

import com.jia.model.User;
import com.jia.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @Auther: jia
 * @Date: 2018/7/23 11:17
 * @Description:
 */
public class MyShiroRealm extends AuthorizingRealm{

    @Resource
    UserService userService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = authenticationToken.getPrincipal().toString();
        User user = userService.getUserByName(account);
        if(user == null) {
            throw new UnknownAccountException();
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,//认证通过后，存放在session,一般存放user对象
                user.getPassword(), //密码
                new ShiroByteSource(user.getSalt()),
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
