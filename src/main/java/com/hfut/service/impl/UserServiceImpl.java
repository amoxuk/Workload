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
    public void updateUser(User userlogin) throws CustomException {

        UserExample userExample = new UserExample();

        UserExample.Criteria criterion = userExample.createCriteria();
        criterion.andIdEqualTo(userlogin.getId());

        int ret = userMapper.updateByExample(userlogin, userExample);
        if (ret == 1) {
            return;
        } else {
            throw new CustomException("更新失败，请联系管理员。");
        }
    }
    @Override
    public boolean addManage(int levelId, int userId) throws Exception {
        return false;
    }

    @Override
    public boolean removeManage(int typeId, int userId) throws Exception {
        return false;
    }

    @Override
    public boolean removeUser(int userId) throws Exception {
        return false;
    }

    @Override
    public List<User> getListByType(int typeId) throws Exception {
        return null;
    }

    @Override
    public List<User> getListByType(int typeId, int page) throws Exception {
        return null;
    }

    @Override
    public List<User> getListByType(int typeId, int page, int limit) throws Exception {
        return null;
    }

    @Override
    public int getNewsCount(int typeId) throws Exception {
        return 0;
    }
}

