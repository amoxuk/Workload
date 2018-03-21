package com.hfut.service.impl;


import com.hfut.entity.LGraDesignWorkload;
import com.hfut.entity.LGraDesignWorkloadExample;
import com.hfut.mapper.LGraDesignWorkloadMapper;
import com.hfut.service.LocalGraDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocalGraDesignServiceImpl implements LocalGraDesignService {
    @Autowired
    private LGraDesignWorkloadMapper workloadMapper;

    @Override
    public List<LGraDesignWorkload> getList(Integer years, String teacher, Integer page, Integer limit) throws Exception {
        LGraDesignWorkloadExample example = new LGraDesignWorkloadExample();
        LGraDesignWorkloadExample.Criteria criteria = example.createCriteria();

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
        LGraDesignWorkloadExample example = new LGraDesignWorkloadExample();
        LGraDesignWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }


    @Override
    public boolean updateLoad(LGraDesignWorkload workload) throws Exception {
        //计算工作量 课时
        workload.setWorkload((float) (Math.round(workload.getCoefficient() * workload.getPeople() * workload.getWeeks() * 100) / 100));

        LGraDesignWorkloadExample workloadExample = new LGraDesignWorkloadExample();
        LGraDesignWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        LGraDesignWorkloadExample expWorkloadExample = new LGraDesignWorkloadExample();
        LGraDesignWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insertLoad(LGraDesignWorkload workload) throws Exception {

        workload.setWorkload((float) (Math.round(workload.getCoefficient() * workload.getPeople() * workload.getWeeks() * 100) / 100));

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<LGraDesignWorkload> insertLoadByList(List<LGraDesignWorkload> list) throws Exception {
        ArrayList<LGraDesignWorkload> ret = new ArrayList<LGraDesignWorkload>();
        for (LGraDesignWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean removeLoad(List list) {
        LGraDesignWorkloadExample expWorkloadExample = new LGraDesignWorkloadExample();
        LGraDesignWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }


}

