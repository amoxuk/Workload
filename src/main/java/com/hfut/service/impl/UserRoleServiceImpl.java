package com.hfut.service.impl;

import com.hfut.entity.UserRole;
import com.hfut.mapper.UserRoleMapper;
import com.hfut.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public UserRole findByid(Integer level) throws Exception {
        return userRoleMapper.selectByPrimaryKey(level);
    }
}
