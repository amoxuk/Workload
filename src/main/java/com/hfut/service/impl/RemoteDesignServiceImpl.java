package com.hfut.service.impl;

import com.hfut.entity.RemoteDesignWorkload;
import com.hfut.entity.RemoteDesignWorkloadExample;
import com.hfut.mapper.RemoteDesignWorkloadMapper;
import com.hfut.service.RemoteDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteDesignServiceImpl implements RemoteDesignService {
    @Autowired
    private RemoteDesignWorkloadMapper designWorkloadMapper;
    @Override
    public List<RemoteDesignWorkload> getList(Integer years, String teacher, Integer page, Integer limit) {

        RemoteDesignWorkloadExample example = new RemoteDesignWorkloadExample();
        RemoteDesignWorkloadExample.Criteria criteria = example.createCriteria();
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

        return designWorkloadMapper.selectByExample(example);
    }

    @Override
    public int getCount(Integer years, String teacher) throws Exception {
        RemoteDesignWorkloadExample example = new RemoteDesignWorkloadExample();
        RemoteDesignWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return designWorkloadMapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(RemoteDesignWorkload workload) throws Exception {
        return designWorkloadMapper.updateByPrimaryKeySelective(workload) == 1;
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        RemoteDesignWorkloadExample example = new RemoteDesignWorkloadExample();
        RemoteDesignWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return designWorkloadMapper.deleteByExample(example) == 1;
    }

    @Override
    public List<RemoteDesignWorkload> insertLoadByList(List<RemoteDesignWorkload> list) throws Exception {
        ArrayList<RemoteDesignWorkload> ret = new ArrayList<>();
        for (RemoteDesignWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean insertLoad(RemoteDesignWorkload workload) throws Exception {
        if (workload.getPeople()<=50) {
            workload.setLoadCoefficient(0.6F);
            workload.setWorkload((float) Math.round(workload.getLoadCoefficient()*workload.getPeople()*workload.getWeeks()));
        }else{
            workload.setLoadCoefficient(0.3F);
            workload.setWorkload((float) Math.round((0.6 * 50 + 0.3 * (workload.getPeople() - 50)) * workload.getWeeks()));
        }
        return designWorkloadMapper.insertSelective(workload) == 1;
    }

    @Override
    public boolean removeLoad(List list) {
        RemoteDesignWorkloadExample example = new RemoteDesignWorkloadExample();
        RemoteDesignWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        return designWorkloadMapper.deleteByExample(example) != 0;
    }



}
