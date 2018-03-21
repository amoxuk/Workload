package com.hfut.service.impl;

import com.hfut.entity.LProjectWorkload;
import com.hfut.entity.LProjectWorkloadExample;
import com.hfut.mapper.LProjectWorkloadMapper;
import com.hfut.service.LocalProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocalProjectServiceImpl implements LocalProjectService {
    @Autowired
    private LProjectWorkloadMapper workloadMapper;


    @Override
    public List<LProjectWorkload> getList(Integer years, String teacher, Integer page, Integer limit) {
        LProjectWorkloadExample example = new LProjectWorkloadExample();
        LProjectWorkloadExample.Criteria criteria = example.createCriteria();
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
        LProjectWorkloadExample example = new LProjectWorkloadExample();
        LProjectWorkloadExample.Criteria criteria = example.createCriteria();

        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(LProjectWorkload workload) throws Exception {
        //计算工作量 课时
        String type = workload.getLevel();

        if (type != null && type.indexOf("国") >= 0) {
            workload.setWorkload((float) 48);
        } else if (type != null && type.indexOf("省") >= 0) {
            workload.setWorkload((float) 24);
        } else if (type != null && type.indexOf("校") >= 0) {
            workload.setWorkload((float) 16);
        }
        LProjectWorkloadExample workloadExample = new LProjectWorkloadExample();
        LProjectWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        LProjectWorkloadExample expWorkloadExample = new LProjectWorkloadExample();
        LProjectWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insertLoad(LProjectWorkload workload) throws Exception {
        String type = workload.getLevel();

        if (type != null && type.indexOf("国") >= 0) {
            workload.setWorkload((float) 48);
        } else if (type != null && type.indexOf("省") >= 0) {
            workload.setWorkload((float) 24);
        } else if (type != null && type.indexOf("校") >= 0) {
            workload.setWorkload((float) 16);
        }
        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<LProjectWorkload> insertLoadByList(List<LProjectWorkload> list) throws Exception {
        ArrayList<LProjectWorkload> ret = new ArrayList<LProjectWorkload>();
        for (LProjectWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean removeLoad(List list) {
        LProjectWorkloadExample expWorkloadExample = new LProjectWorkloadExample();
        LProjectWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

}
