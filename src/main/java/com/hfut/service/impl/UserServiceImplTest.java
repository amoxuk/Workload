package com.hfut.service.impl;

import com.hfut.entity.User;
import org.junit.Test;

public class UserServiceImplTest {
    @Test
    public void register1() throws Exception {
        User user = new User();
        user.setUser("amoxu");
        user.setPassword("123456");
        user.setMail("amoxu@qq.com");

        UserServiceImpl userService = new UserServiceImpl();
        userService.register(user);
    }

}
