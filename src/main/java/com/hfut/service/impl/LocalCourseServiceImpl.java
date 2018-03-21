package com.hfut.service.impl;

import com.hfut.entity.LocalCourseWorkload;
import com.hfut.entity.LocalCourseWorkloadExample;
import com.hfut.mapper.LocalCourseWorkloadMapper;
import com.hfut.service.LocalCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LocalCourseServiceImpl implements LocalCourseService {

    @Autowired
    private LocalCourseWorkloadMapper workloadMapper;

    @Override
    public List<LocalCourseWorkload> getList(Integer years, String teacher, Integer page, Integer limit) throws Exception {
        LocalCourseWorkloadExample example = new LocalCourseWorkloadExample();
        LocalCourseWorkloadExample.Criteria criteria = example.createCriteria();

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
        LocalCourseWorkloadExample example = new LocalCourseWorkloadExample();
        LocalCourseWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(LocalCourseWorkload workload) throws Exception {
        LocalCourseWorkloadExample workloadExample = new LocalCourseWorkloadExample();
        //计算工作量 课时
        int people = workload.getPeople();
        if (people<=45) {
            workload.setCoefficient(1.0F);
        }else if (people>45&&people<=135) {
            workload.setCoefficient((float) (1.0 + Math.ceil((people - 45)/10F) * 0.1));
        }else if (people>136) {
            workload.setCoefficient((float) (1.9 + Math.ceil((people - 135)/20F) * 0.1));
        }

        if ("工程图学".indexOf(workload.getLesson()) < 0) {
            if (workload.getCoefficient() > 3.0F) {
                workload.setCoefficient(3.0F);
            }
            workload.setWorkload(workload.getPeriod() * workload.getCoefficient());
        } else {
            workload.setWorkload(1.2F * workload.getPeriod() * workload.getCoefficient());
        }

        LocalCourseWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(Integer id) {
        LocalCourseWorkloadExample expWorkloadExample = new LocalCourseWorkloadExample();
        LocalCourseWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }
    @Override
    public boolean removeLoad(List list) throws Exception {
        LocalCourseWorkloadExample expWorkloadExample = new LocalCourseWorkloadExample();
        LocalCourseWorkloadExample.Criteria criteria = expWorkloadExample.createCriteria();
        criteria.andIdIn(list);
        if (workloadMapper.deleteByExample(expWorkloadExample) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean insertLoad(LocalCourseWorkload workload) throws Exception {
        //计算工作量 课时
        int people = workload.getPeople();
        if (people<=45) {
            workload.setCoefficient(1.0F);
        }else if (people>45&&people<=135) {
            workload.setCoefficient((float) (1.0 + Math.ceil((people - 45)/10F) * 0.1));
        }else if (people>136) {
            workload.setCoefficient((float) (1.9 + Math.ceil((people - 135)/20F) * 0.1));
        }

        if ("工程图学".indexOf(workload.getLesson()) < 0) {
            if (workload.getCoefficient() > 3.0F) {
                workload.setCoefficient(3.0F);
            }
            workload.setWorkload(workload.getPeriod() * workload.getCoefficient());
        } else {
            workload.setWorkload(1.2F * workload.getPeriod() * workload.getCoefficient());
        }

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<LocalCourseWorkload> insertLoadByList(List<LocalCourseWorkload> list) throws Exception {
        ArrayList<LocalCourseWorkload> ret = new ArrayList<LocalCourseWorkload>();
        for (LocalCourseWorkload workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }



}
