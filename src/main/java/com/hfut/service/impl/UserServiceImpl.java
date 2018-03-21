package com.hfut.service.impl;

import com.hfut.entity.User;
import com.hfut.entity.UserExample;
import com.hfut.exception.CustomException;
import com.hfut.mapper.UserMapper;
import com.hfut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) throws Exception {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserEqualTo(name);
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() == 0) {
            return null;
        } else {
            return list.get(0);
        }

    }

    @Override
    public void register(User user) throws Exception {

        System.out.println("user register:" + user.getUser() + " " + user.getPassword() + " " + user.getMail());
        if (StringUtils.isEmpty(user.getUser()) || StringUtils.isEmpty(user.getPassword())) {
            throw new CustomException("用户或密码不能为空！");
        } else if (StringUtils.isEmpty(user.getMail())) {
            throw new CustomException("邮箱不能为空！");
        } else if (user.getPassword().length() < 6) {
            throw new CustomException("密码过短！");
        }

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserEqualTo(user.getUser());
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size() != 0) {
            throw new CustomException("账号已存在！");
        }
        userExample = new UserExample();
        criteria = userExample.createCriteria();
        criteria.andMailEqualTo(user.getMail());
        list = userMapper.selectByExample(userExample);
        if (list.size() != 0) {
            throw new CustomException("邮箱已存在！");
        }
        user.setLevel(0);
        userMapper.insert(user);
    }

    @Override
    public void removeByName(String name) throws Exception {

    }

    @Override
    public void removeById(int id) throws Exception {

    }

    @Transient
    @Override
    public void updateUser(User user) throws CustomException {
        user.setPassword(userMapper.selectByPrimaryKey(user.getId()).getPassword());
        int ret = userMapper.updateByPrimaryKey(user);
        if (ret == 1) {
            return;
        } else {
            throw new CustomException("更新失败，请联系管理员。");
        }
    }
    @Transient
    @Override
    public void alterPassword(User user) throws CustomException {
        int ret = userMapper.updateByPrimaryKey(user);
        if (ret == 1) {
            return;
        } else {
            throw new CustomException("更新失败，请联系管理员。");
        }
    }

    @Override
    public boolean removeUser(int userId) throws Exception {
        return false;
    }

    @Override
    public List<User> getList(Integer page, Integer limit) throws Exception {
        UserExample example = new UserExample();
        example.setLimit(limit);
        if (page != 0) {
            page -= 1;
        }
        example.setOffset(page);
        List<User> list = userMapper.selectByExample(example);
        for (User user : list) {
            user.setPassword("*****");
        }
        return list;
    }

    @Override
    public List<User> getList(int typeId, int page, int limit) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andLevelEqualTo(typeId);
        example.setLimit(limit);
        if (page != 0) {
            page -= 1;
        }
        example.setOffset(page);
        List<User> list = userMapper.selectByExample(example);
        for (User user : list) {
            user.setPassword("*****");
        }
        return list;
    }




    @Override
    public boolean addUser(User user) {

        if (0 != userMapper.insert(user)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeUser(ArrayList<Integer> list) {
        boolean re = false;
        try {

            for (int i : list) {
                removeById(i);
            }
            re = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return re;
    }

}

