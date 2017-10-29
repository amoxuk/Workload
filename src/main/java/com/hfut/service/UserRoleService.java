package com.hfut.service;

import com.hfut.entity.UserRole;

public interface UserRoleService {
    UserRole findByid(Integer level) throws Exception;
}
