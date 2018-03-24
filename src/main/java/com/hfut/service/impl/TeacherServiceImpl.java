package com.hfut.service.impl;

import com.hfut.entity.Teacher;
import com.hfut.entity.TeacherExample;
import com.hfut.exception.CustomException;
import com.hfut.mapper.ProcedureMapper;
import com.hfut.mapper.TeacherMapper;
import com.hfut.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private ProcedureMapper procedureMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    private Logger logger = Logger.getLogger(TeacherServiceImpl.class);

    @Override
    public List getTeacherList(String type, Integer page, Integer limit) {
        procedureMapper.updateTeacher(); //调用过程更新教师表
        List list;
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        if ("local".equals(type)) {
            criteria.andLocationEqualTo(1);
        } else {
            criteria.andLocationEqualTo(0);
        }
        if (page != 0) {

            page -= 1;
        }
        example.setOffset(page);
        example.setLimit(limit);
        list = teacherMapper.selectByExample(example);
        return list;
    }

    @Override
    public List getTeacherList(String college, String teacher, Integer type, Integer page, Integer limit) {

        List list;
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        if (!"null".equals(college)) {
            criteria.andCollegeEqualTo(college);
        }
        if (!"null".equals(teacher)) {
            criteria.andNameEqualTo(teacher);
        }

        criteria.andLocationEqualTo(type);

        if (page != 0) {
            page -= 1;
        }
        example.setOffset(page);
        example.setLimit(limit);
        list = teacherMapper.selectByExample(example);

        return list;
    }

    @Override
    public boolean deleteTeacher(ArrayList<Integer> list) {
        boolean ret = false;
        for (Integer i : list) {
            if (teacherMapper.deleteByPrimaryKey(i) > 0) {
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public List<String> getCollege() {
        return teacherMapper.selectCollege();
    }

    @Override
    public void deleteTeacher(String name) {
        TeacherExample example = new TeacherExample();
        TeacherExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        teacherMapper.deleteByExample(example);
    }

    @Override
    public boolean addTeacher(Teacher teacher) throws CustomException {
        logger.info(teacher);

        try {
            int ret = teacherMapper.insert(teacher);
            if (ret > 0) {
                return true;
            } else {
                return false;
            }
        } catch (DuplicateKeyException e1) {
            throw new CustomException("用户已存在。");
        } catch (DataIntegrityViolationException e0) {
            e0.printStackTrace();
            throw new CustomException("必填项不能为空。");
        }

    }

    @Override
    public boolean updateTeacher(Teacher teacher) throws CustomException {
        logger.info(teacher);

        try {
            int ret = teacherMapper.updateByPrimaryKey(teacher);
            if (ret > 0) {
                return true;
            } else {
                return false;
            }
        } catch (DuplicateKeyException e1) {
            throw new CustomException("用户已存在。");
        } catch (DataIntegrityViolationException e0) {
            e0.printStackTrace();
            throw new CustomException("必填项不能为空。");
        }
    }


}
