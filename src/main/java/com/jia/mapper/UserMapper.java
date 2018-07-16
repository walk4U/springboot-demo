package com.jia.mapper;

import com.jia.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    List<User> selectAll();
}
