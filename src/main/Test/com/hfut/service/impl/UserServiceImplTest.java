package com.hfut.service.impl;

import com.hfut.entity.User;
import com.hfut.entity.UserExample;
import com.hfut.mapper.IUserMapper;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"})
public class UserServiceImplTest {
    Logger logger = Logger.getLogger(UserServiceImplTest.class);

    @Autowired
    private IUserMapper userMapper;

    @Test
    public void findByName() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(10000);
        List<User> userList = userMapper.selectByExample(example);

        Assert.assertEquals(userList.get(0).getUserRole().getName(), "超级管理员");
    }

    @Test
    public void selectLike() {
        List<User> userList = userMapper.selectByLike("amo", 1, 10);
        logger.info(userList);

        Assert.assertNotEquals(userList.size(), 0);
    }

    @Test
    public void countLike() {
        Assert.assertEquals(userMapper.countByLike("amo"), 3);
    }
}