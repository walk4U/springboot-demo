package com.jia.shiro;

import com.jia.model.entity.User;
import org.apache.shiro.SecurityUtils;

/**
 * @Auther: jia
 * @Date: 2018/7/24 13:44
 * @Description:
 */
public class ShiroUtil {

    public static User getUser() {
        return (User)SecurityUtils.getSubject().getPrincipal();
    }
}
