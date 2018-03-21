package com.hfut.service.impl;

import com.hfut.entity.Expriment;
import com.hfut.entity.ExprimentExample;
import com.hfut.mapper.ExprimentMapper;
import com.hfut.service.ExprimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExprimentServiceImpl implements ExprimentService {
    @Autowired
    private ExprimentMapper workloadMapper;

    private Expriment checkDate(Expriment workload) {
        if (workload.getType().indexOf("非理工") >= 0 || workload.getType().indexOf("上机") >= 0) {
            workload.setCoefficient(0.03F);
        } else if (workload.getType().indexOf("基础") >= 0) {
            workload.setCoefficient(0.025F);

        } else if (workload.getType().indexOf("理工") >= 0) {
            workload.setCoefficient(0.01F);
        } else if (workload.getType().indexOf("实习") >= 0 || workload.getType().indexOf("实训") >= 0) {
            workload.setCoefficient(0.3F);
        } else if (workload.getType().indexOf("课程设计") >= 0) {
            workload.setCoefficient(0.02F);
            if (workload.getPeroid() <= 0) {
                workload.setPeroid(workload.getCredit() * 16);
            }
        } else {
            workload.setCoefficient(1F);
        }
        return workload;
    }

    @Override
    public List<Expriment> getList(Integer years, String teacher, Integer page, Integer limit) {
        ExprimentExample example = new ExprimentExample();
        ExprimentExample.Criteria criteria = example.createCriteria();

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
        ExprimentExample example = new ExprimentExample();
        ExprimentExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }


    @Override
    public boolean updateLoad(Expriment workload) throws Exception {
        //计算工作量 课时


        workload.setWorkload(workload.getCoefficient() * workload.getPeople() * workload.getPeroid());
        workload.setWorkload((float) (Math.round(workload.getWorkload() * 100) / 100));

        ExprimentExample workloadExample = new ExprimentExample();
        ExprimentExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        ExprimentExample expWorkloadExample = new ExprimentExample();
        ExprimentExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insertLoad(Expriment workload) throws Exception {
        workload = checkDate(workload);

        workload.setWorkload(workload.getCoefficient() * workload.getPeople() * workload.getPeroid());
        workload.setWorkload((float) (Math.round(workload.getWorkload() * 100) / 100));

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<Expriment> insertLoadByList(List<Expriment> list) throws Exception {
        ArrayList<Expriment> ret = new ArrayList<Expriment>();
        for (Expriment workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean removeLoad(List list) {
        ExprimentExample expWorkloadExample = new ExprimentExample();
        ExprimentExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }


}
