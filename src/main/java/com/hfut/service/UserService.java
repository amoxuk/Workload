package com.hfut.service;

import com.hfut.entity.User;
import com.hfut.exception.CustomException;

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

    /**
     * 添加版主/记者
     *
     * @param levelId 权限id
     * @param userId  用户id
     * @throws Exception
     */
    boolean addManage(int levelId, int userId) throws Exception;

    //删除版主/记者
    boolean removeManage(int typeId, int userId) throws Exception;

    //删除用户
    boolean removeUser(int userId) throws Exception;

    //根据类型查询用户
    List<User> getListByType(int typeId) throws Exception;

    List<User> getListByType(int typeId,int page) throws Exception;

    //根据类型查询用户
    List<User> getListByType(int typeId,int page,int limit) throws Exception;

    int getNewsCount(int typeId) throws Exception;

}
