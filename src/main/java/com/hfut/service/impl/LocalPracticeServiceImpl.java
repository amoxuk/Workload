package com.hfut.service.impl;

import com.hfut.entity.LPracticeWorkload;
import com.hfut.entity.LPracticeWorkloadExample;
import com.hfut.mapper.LPracticeWorkloadMapper;
import com.hfut.service.LocalPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalPracticeServiceImpl implements LocalPracticeService {

    @Autowired
    private LPracticeWorkloadMapper workloadMapper;

    @Override
    public List<LPracticeWorkload> getList(Integer years, String teacher,Integer page, Integer limit) throws Exception {
        LPracticeWorkloadExample example = new LPracticeWorkloadExample();
        LPracticeWorkloadExample.Criteria criteria = example.createCriteria();
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
        LPracticeWorkloadExample example = new LPracticeWorkloadExample();
        LPracticeWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }

        return workloadMapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(LPracticeWorkload workload) throws Exception {
        //计算工作量 课时
        String place = workload.getPlace().trim();
        if ("本市".equals(place)) {
            workload.setWorkload((float) (Math.round(18 * workload.getClassNumber() * workload.getWeeks() * 100) / 100));
        } else if ("外地".equals(place)){
            workload.setWorkload((float) (Math.round(20 * workload.getClassNumber() * workload.getWeeks() * 100) / 100));
        } else if ("野外".equals(place)) {
            workload.setWorkload((float) (Math.round(24 * workload.getClassNumber() * workload.getWeeks() * 100) / 100));
        }
        LPracticeWorkloadExample workloadExample = new LPracticeWorkloadExample();
        LPracticeWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        LPracticeWorkloadExample expWorkloadExample = new LPracticeWorkloadExample();
        LPracticeWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean removeLoad(List list) throws Exception {
        LPracticeWorkloadExample expWorkloadExample = new LPracticeWorkloadExample();
        LPracticeWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }


    @Override
    public boolean insertLoad(LPracticeWorkload workload) throws Exception {
        String place = workload.getPlace().trim();
        if ("本市".equals(place)) {
            workload.setWorkload((float) (Math.round(18 * workload.getClassNumber() * workload.getWeeks() * 100) / 100));
        } else if ("外地".equals(place)){
            workload.setWorkload((float) (Math.round(20 * workload.getClassNumber() * workload.getWeeks() * 100) / 100));
        } else if ("野外".equals(place)) {
            workload.setWorkload((float) (Math.round(24 * workload.getClassNumber() * workload.getWeeks() * 100) / 100));
        }

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<LPracticeWorkload> insertLoadByList(List<LPracticeWorkload> list) throws Exception {
        ArrayList<LPracticeWorkload> ret = new ArrayList<LPracticeWorkload>();
        for (LPracticeWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }


}
