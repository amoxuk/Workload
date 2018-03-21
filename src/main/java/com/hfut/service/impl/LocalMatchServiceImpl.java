package com.hfut.service.impl;

import com.hfut.entity.LMatchWorkload;
import com.hfut.entity.LMatchWorkloadExample;
import com.hfut.mapper.LMatchWorkloadMapper;
import com.hfut.service.LocalMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocalMatchServiceImpl implements LocalMatchService {
    @Autowired
    private LMatchWorkloadMapper workloadMapper;


    @Override
    public List<LMatchWorkload> getList(Integer years, String teacher, Integer page, Integer limit) {
        LMatchWorkloadExample example = new LMatchWorkloadExample();
        LMatchWorkloadExample.Criteria criteria = example.createCriteria();

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
        return workloadMapper.selectByExample(example);
    }

    @Override
    public int getCount(Integer years, String teacher) throws Exception {
        LMatchWorkloadExample example = new LMatchWorkloadExample();
        LMatchWorkloadExample.Criteria criteria = example.createCriteria();

        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }

        return workloadMapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(LMatchWorkload workload) throws Exception {
        //计算工作量 课时

        LMatchWorkloadExample workloadExample = new LMatchWorkloadExample();
        LMatchWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        LMatchWorkloadExample expWorkloadExample = new LMatchWorkloadExample();
        LMatchWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insertLoad(LMatchWorkload workload) throws Exception {

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<LMatchWorkload> insertLoadByList(List<LMatchWorkload> list) throws Exception {
        ArrayList<LMatchWorkload> ret = new ArrayList<LMatchWorkload>();
        for (LMatchWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean removeLoad(List list) throws Exception {
        LMatchWorkloadExample expWorkloadExample = new LMatchWorkloadExample();
        LMatchWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }


}
