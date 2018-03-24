package com.hfut.service.impl;

import com.hfut.mapper.TeacherMapper;
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
public class TeacherServiceImplTest {
    Logger logger = Logger.getLogger(TeacherServiceImplTest.class);
    @Autowired
    TeacherMapper teacherMapper;
    @Test
    public void getCollege() {
        List<String> s = teacherMapper.selectCollege();
        Assert.assertEquals(s.size(), 2);
    }
}