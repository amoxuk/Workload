package com.hfut.mapper;

import com.hfut.entity.User;
import com.hfut.entity.UserExample;

import java.util.List;

public interface IUserMapper extends UserMapper {
    @Override
    List<User> selectByExample(UserExample example);

    @Override
    User selectByPrimaryKey(Integer id);
}