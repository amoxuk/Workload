package com.hfut.service.impl;

import com.hfut.entity.LocalExpWorkload;
import com.hfut.entity.LocalExpWorkloadExample;
import com.hfut.mapper.LocalExpWorkloadMapper;
import com.hfut.service.LocalExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocalExpServiceImpl implements LocalExpService {
    @Autowired
    private LocalExpWorkloadMapper workloadMapper;


    @Override
    public List<LocalExpWorkload> getList(Integer years,String teacher, Integer page, Integer limit) throws Exception {
        LocalExpWorkloadExample example = new LocalExpWorkloadExample();
        LocalExpWorkloadExample.Criteria criteria = example.createCriteria();
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
    public int getCount(Integer years,String teacher) throws Exception {
        LocalExpWorkloadExample example = new LocalExpWorkloadExample();
        LocalExpWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }


    @Override
    public boolean updateLoad(LocalExpWorkload workload) throws Exception {

        //计算工作量 课时
        String type = workload.getType().toUpperCase();
        switch (type) {
            case "A":
                workload.setTypeCoefficient(1.1F);
                break;
            case "B":
                workload.setTypeCoefficient(1.2F);
                break;
            case "C":
                workload.setTypeCoefficient(1.4F);
                break;
            default:
                workload.setTypeCoefficient(1.1F);
        }

        int people = workload.getPeople();
        if (people<=45) {
            workload.setLoadCoefficient(1.0F);
        }else if (people>45&&people<=135) {
            workload.setLoadCoefficient((float) (1.0 + Math.ceil((people - 45)/10F) * 0.1));
        }else if (people>136) {
            workload.setLoadCoefficient((float) (1.9 + Math.ceil((people - 135)/20F) * 0.1));
        }

        workload.setWorkload(workload.getPeriod() * workload.getTypeCoefficient() * workload.getLoadCoefficient());

        workload.setWorkload((float) (Math.round(workload.getWorkload() * 100) / 100));


        LocalExpWorkloadExample workloadExample = new LocalExpWorkloadExample();
        LocalExpWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean removeLoad(List list) throws Exception {
        LocalExpWorkloadExample expWorkloadExample = new LocalExpWorkloadExample();
        LocalExpWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean removeLoad(Integer id) throws Exception {
        LocalExpWorkloadExample expWorkloadExample = new LocalExpWorkloadExample();
        LocalExpWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean insertLoad(LocalExpWorkload workload) throws Exception {
        String type = workload.getType().toUpperCase();
        switch (type) {
            case "A":
                workload.setTypeCoefficient(1.1F);
                break;
            case "B":
                workload.setTypeCoefficient(1.2F);
                break;
            case "C":
                workload.setTypeCoefficient(1.4F);
                break;
            default:
                workload.setTypeCoefficient(1.1F);
        }
        int people = workload.getPeople();
        if (people<=45) {
            workload.setLoadCoefficient(1.0F);
        }else if (people>45&&people<=135) {
            workload.setLoadCoefficient((float) (1.0 + Math.ceil((people - 45)/10F) * 0.1));
        }else if (people>136) {
            workload.setLoadCoefficient((float) (1.9 + Math.ceil((people - 135)/20F) * 0.1));
        }

        workload.setWorkload(workload.getPeriod() * workload.getTypeCoefficient() * workload.getLoadCoefficient());

        workload.setWorkload((float) (Math.round(workload.getWorkload() * 100) / 100));

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }
    @Override
    public List<LocalExpWorkload> insertLoadByList(List<LocalExpWorkload> list) throws Exception {
        ArrayList<LocalExpWorkload> ret = new ArrayList<LocalExpWorkload>();
        for (LocalExpWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }


}
