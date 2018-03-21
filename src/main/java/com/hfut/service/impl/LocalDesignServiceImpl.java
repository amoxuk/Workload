package com.hfut.service.impl;

import com.hfut.entity.LocalDesignWorkload;
import com.hfut.entity.LocalDesignWorkloadExample;
import com.hfut.mapper.LocalDesignWorkloadMapper;
import com.hfut.service.LocalDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocalDesignServiceImpl implements LocalDesignService {

    @Autowired
    private LocalDesignWorkloadMapper workloadMapper;

    @Override
    public boolean updateLoad(LocalDesignWorkload workload) throws Exception {
        if(workload.getPeople()>25){
            workload.setWorkload((float) (workload.getWeeks()*((workload.getPeople()-25)*0.6+25*0.8)));
        }
        else{
            workload.setWorkload((float) (workload.getPeople() * workload.getWeeks() * 0.8));
        }
        workload.setWorkload((float) (Math.round(workload.getWorkload() * 100) / 100));

        LocalDesignWorkloadExample workloadExample = new LocalDesignWorkloadExample();
        LocalDesignWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        LocalDesignWorkloadExample expWorkloadExample = new LocalDesignWorkloadExample();
        LocalDesignWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean insertLoad(LocalDesignWorkload workload) throws Exception {
        if(workload.getPeople()>25){
            workload.setWorkload((float) (workload.getWeeks()*((workload.getPeople()-25)*0.6+25*0.8)));
        }
        else{
            workload.setWorkload((float) (workload.getPeople() * workload.getWeeks() * 0.8));
        }
        workload.setWorkload((float) (Math.round(workload.getWorkload() * 100) / 100));

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }
    @Override
    public List<LocalDesignWorkload> insertLoadByList(List<LocalDesignWorkload> list) throws Exception {
        ArrayList<LocalDesignWorkload> ret = new ArrayList<LocalDesignWorkload>();
        for (LocalDesignWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean removeLoad(List list) throws Exception {
        LocalDesignWorkloadExample expWorkloadExample = new LocalDesignWorkloadExample();
        LocalDesignWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }



    @Override
    public int getCount(Integer years, String teacher) {
        LocalDesignWorkloadExample example = new LocalDesignWorkloadExample();
        LocalDesignWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }


    @Override
    public List<LocalDesignWorkload> getList(Integer years, String teacher, Integer page, Integer limit) {
        LocalDesignWorkloadExample example = new LocalDesignWorkloadExample();
        LocalDesignWorkloadExample.Criteria criteria = example.createCriteria();
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
}
