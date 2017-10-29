package com.hfut.service.impl;

import com.hfut.entity.Teacher;
import com.hfut.entity.TeacherExample;
import com.hfut.mapper.TeacherMapper;
import com.hfut.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher findByName(String name) throws Exception {
        TeacherExample teacherExample = new TeacherExample();
        TeacherExample.Criteria criteria = teacherExample.createCriteria();
        criteria.andNameEqualTo(name);

        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        if (teachers.size() > 0) {
            return teachers.get(0);
        } else {
            return null;
        }

    }
}
