package com.jia.model.vo;

import com.jia.model.entity.User;

/**
 * @Auther: jia
 * @Date: 2018/7/24 15:28
 * @Description:
 */
public class UserVO {

    public String name;

    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * UserVO 转换
     * @param user
     * @return
     */
    public static UserVO convertToVo(User user) {
        if(user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setName(user.getName());
        userVO.setAge(user.getAge());
        return userVO;
    }
}
