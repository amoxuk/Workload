package com.hfut.service.impl;

import com.hfut.entity.RemoteGraduateWorkload;
import com.hfut.entity.RemoteGraduateWorkloadExample;
import com.hfut.mapper.RemoteGraduateWorkloadMapper;
import com.hfut.service.RemoteGraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteGraServiceImpl implements RemoteGraService {
    @Autowired
    private RemoteGraduateWorkloadMapper graduateMapper;

    @Override
    public List<RemoteGraduateWorkload> getList(Integer years, String teacher, Integer page, Integer limit) {
      RemoteGraduateWorkloadExample example = new RemoteGraduateWorkloadExample();
        RemoteGraduateWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        if (page != 0) {
            example.setOffset(page);
            example.setLimit(limit);
        }
        return graduateMapper.selectByExample(example);
    }

    @Override
    public int getCount(Integer years, String teacher) throws Exception {
        RemoteGraduateWorkloadExample example = new RemoteGraduateWorkloadExample();
        RemoteGraduateWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return graduateMapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(RemoteGraduateWorkload workload) throws Exception {
        workload.setWorkload((float) Math.round(0.9 * workload.getPeople() * workload.getWeeks()));
        return graduateMapper.updateByPrimaryKeySelective(workload) == 1;
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        RemoteGraduateWorkloadExample example = new RemoteGraduateWorkloadExample();
        RemoteGraduateWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return graduateMapper.deleteByExample(example) == 1;
    }

    @Override
    public List<RemoteGraduateWorkload> insertLoadByList(List<RemoteGraduateWorkload> list) throws Exception {
        ArrayList<RemoteGraduateWorkload> ret = new ArrayList<>();
        for (RemoteGraduateWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean insertLoad(RemoteGraduateWorkload workload) throws Exception {
        workload.setWorkload((float) Math.round(0.9 * workload.getPeople() * workload.getWeeks()));
        return graduateMapper.insertSelective(workload) == 1;
    }

    @Override
    public boolean removeLoad(List list) {
        RemoteGraduateWorkloadExample example = new RemoteGraduateWorkloadExample();
        RemoteGraduateWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        return graduateMapper.deleteByExample(example) != 0;
    }


}
