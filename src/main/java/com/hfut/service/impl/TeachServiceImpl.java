package com.hfut.service.impl;

import com.hfut.entity.WorkLoad;
import com.hfut.entity.WorkLoadExample;
import com.hfut.mapper.WorkLoadMapper;
import com.hfut.service.TeachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TeachServiceImpl implements TeachService {
    @Autowired
    WorkLoadMapper workLoadMapper;

    @Override
    public List<WorkLoad> findAllWorkLoad(int page, int limit) throws Exception {
        WorkLoadExample workLoadExample = new WorkLoadExample();
 /*       workLoadExample.setOffset(page);
        workLoadExample.setLimit(limit);*/
        WorkLoadExample.Criteria criteria = workLoadExample.createCriteria();
        criteria.andIdIsNotNull();
        List<WorkLoad> workLoads = workLoadMapper.selectByExample(workLoadExample);
        if (workLoads.size() > 0) {
            return workLoads;
        } else {
            return null;
        }
    }

    @Override
    public boolean inserAllWorkLoad(List<WorkLoad> workLoads) throws Exception {
        for (WorkLoad workLoad : workLoads) {
            workLoadMapper.insert(workLoad);
        }
        return true;
    }

    @Override
    public boolean updateWorkLoad(WorkLoad workLoad) throws Exception {
        if (workLoadMapper.updateByPrimaryKey(workLoad) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateWorkLoad(List<WorkLoad> workLoads) throws Exception {
        for (WorkLoad workLoad : workLoads) {
            workLoadMapper.updateByPrimaryKey(workLoad);
        }
        return true;
    }

    @Override
    public WorkLoad findByTeacher(String teacher) throws Exception {
        WorkLoadExample workLoadExample = new WorkLoadExample();
        WorkLoadExample.Criteria criteria = workLoadExample.createCriteria();
        criteria.andTeacherEqualTo(teacher);
        List<WorkLoad> workLoad = workLoadMapper.selectByExample(workLoadExample);
        if (workLoad.size() > 0) {
            return workLoad.get(0);
        } else {
            return null;
        }
    }

    @Override
    public WorkLoad findByYear(int year) throws Exception {
        WorkLoadExample workLoadExample = new WorkLoadExample();
        WorkLoadExample.Criteria criteria = workLoadExample.createCriteria();
        criteria.andYearsEqualTo(year);
        List<WorkLoad> workLoad = workLoadMapper.selectByExample(workLoadExample);
        if (workLoad.size() > 0) {
            return workLoad.get(0);
        } else {
            return null;
        }
    }

    @Override
    public int getWorkLoadCount() throws Exception {
        WorkLoadExample workLoadExample = new WorkLoadExample();
        WorkLoadExample.Criteria criteria = workLoadExample.createCriteria();
        criteria.andIdIsNotNull();
        return workLoadMapper.countByExample(workLoadExample);
    }
}
