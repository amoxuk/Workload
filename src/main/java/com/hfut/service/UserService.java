package com.hfut.service;

import com.hfut.entity.User;
import com.hfut.exception.CustomException;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

public interface UserService {
    User findByName(String name) throws Exception;

    //保存用户登录信息
    void register(User userlogin) throws Exception;

    //根据姓名删除
    void removeByName(String name) throws Exception;

    void removeById(int id) throws Exception;

    //根据用户名更新
    void updateUser(User userlogin) throws CustomException;


    @Transient
    void alterPassword(User user) throws CustomException;

    //删除用户
    boolean removeUser(int userId) throws Exception;

    //根据类型查询用户
    List<User> getList(Integer page, Integer limit) throws Exception;

    //根据类型查询用户
    List<User> getList(int typeId,int page,int limit) throws Exception;

    boolean addUser(User user);

    boolean removeUser(ArrayList<Integer> list);
}
