package com.hfut.service.impl;


import com.hfut.entity.LGraPracticeWorkload;
import com.hfut.entity.LGraPracticeWorkloadExample;
import com.hfut.mapper.LGraPracticeWorkloadMapper;
import com.hfut.service.LocalGraPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalGraPracticeServiceImpl implements LocalGraPracticeService {
    @Autowired
    private LGraPracticeWorkloadMapper workloadMapper;

    @Override
    public List<LGraPracticeWorkload> getList(Integer years, String teacher, Integer page, Integer limit) throws Exception {
        LGraPracticeWorkloadExample example = new LGraPracticeWorkloadExample();
        LGraPracticeWorkloadExample.Criteria criteria = example.createCriteria();

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
        LGraPracticeWorkloadExample example = new LGraPracticeWorkloadExample();
        LGraPracticeWorkloadExample.Criteria criteria = example.createCriteria();

        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(LGraPracticeWorkload workload) throws Exception {
        //计算工作量 课时
        String place = workload.getPlace();
        if ("本市".equals(place)) {
            workload.setWorkload((float) (Math.round(0.9 * workload.getPeople() * workload.getWeeks() * 100) / 100));
        } else {
            workload.setWorkload((float) (Math.round(1.0 * workload.getPeople() * workload.getWeeks() * 100) / 100));
        }
        LGraPracticeWorkloadExample workloadExample = new LGraPracticeWorkloadExample();
        LGraPracticeWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        LGraPracticeWorkloadExample expWorkloadExample = new LGraPracticeWorkloadExample();
        LGraPracticeWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insertLoad(LGraPracticeWorkload workload) throws Exception {
        String place = workload.getPlace();
        if ("本市".equals(place)) {
            workload.setWorkload((float) (Math.round(0.9 * workload.getPeople() * workload.getWeeks() * 100) / 100));
        } else {
            workload.setWorkload((float) (Math.round(1.0 * workload.getPeople() * workload.getWeeks() * 100) / 100));
        }
        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<LGraPracticeWorkload> insertLoadByList(List<LGraPracticeWorkload> list) throws Exception {
        List<LGraPracticeWorkload> ret = new ArrayList<LGraPracticeWorkload>();
        for (LGraPracticeWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean removeLoad(List list) {
        LGraPracticeWorkloadExample expWorkloadExample = new LGraPracticeWorkloadExample();
        LGraPracticeWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

}
