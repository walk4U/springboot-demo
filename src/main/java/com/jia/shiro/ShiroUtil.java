package com.jia.shiro;

import com.jia.model.entity.UserDO;
import org.apache.shiro.SecurityUtils;

/**
 * @Auther: jia
 * @Date: 2018/7/24 13:44
 * @Description:
 */
public class ShiroUtil {

    public static UserDO getUser() {
        return (UserDO)SecurityUtils.getSubject().getPrincipal();
    }
}
