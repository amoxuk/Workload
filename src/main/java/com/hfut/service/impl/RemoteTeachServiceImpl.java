package com.hfut.service.impl;

import com.hfut.entity.RemoteTeachWorkload;
import com.hfut.entity.RemoteTeachWorkloadExample;
import com.hfut.exception.CustomException;
import com.hfut.mapper.RemoteTeachWorkloadMapper;
import com.hfut.service.RemoteTeachService;
import com.hfut.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RemoteTeachServiceImpl implements RemoteTeachService {

    @Autowired
    private RemoteTeachWorkloadMapper workloadMapper;

    @Override
    public List<RemoteTeachWorkload> insertLoadByList(List<RemoteTeachWorkload> workloads) throws Exception {
        ArrayList<RemoteTeachWorkload> ret = new ArrayList<RemoteTeachWorkload>();
        for (RemoteTeachWorkload workload : workloads) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean insertLoad(RemoteTeachWorkload workload) throws Exception {
        try {

            int people = workload.getPeople();
            //46个人为一个班，每增加一个班增加0.1系数

            workload.setClassCoefficient((float) (Math.round(people / 46F) * 0.1 + 0.9));
            //计算工作量 课时
            workload.setWorkload(workload.getPeriod() * workload.getClassCoefficient());
            //计算酬金
            workload.setMoney(PropertyUtil.getAllowance() * workload.getWorkload());
        } catch (NullPointerException|DataIntegrityViolationException nop) {
            throw new CustomException("请输入班级人数，学时,教学班");
        }

        if (workloadMapper.insertSelective(workload) == 0) {
            return false;
        }
        return true;
    }


    @Override
    public List<RemoteTeachWorkload> getList(Integer years, String teacher, Integer page, Integer limit) throws Exception {

        RemoteTeachWorkloadExample example = new RemoteTeachWorkloadExample();
        RemoteTeachWorkloadExample.Criteria criteria = example.createCriteria();



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
    public List<RemoteTeachWorkload> findLoadByTeacher(String teacher) throws Exception {
        RemoteTeachWorkloadExample example = new RemoteTeachWorkloadExample();
        RemoteTeachWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andTeacherEqualTo(teacher);

        return workloadMapper.selectByExample(example);
    }

    @Override
    public List<RemoteTeachWorkload> findLoadByTeacher(int teacher) throws Exception {
        return null;
    }

    @Override
    public List<RemoteTeachWorkload> findLoadByYear(int years, int offset, int limit) throws Exception {
        RemoteTeachWorkloadExample example = new RemoteTeachWorkloadExample();
        RemoteTeachWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andYearsEqualTo(years);
        example.setOffset(offset);
        example.setLimit(limit);

        return workloadMapper.selectByExample(example);
    }

    @Override
    public List<RemoteTeachWorkload> findLoadByCollege(String college, int offset, int limit) throws Exception {
        RemoteTeachWorkloadExample example = new RemoteTeachWorkloadExample();
        RemoteTeachWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andCollegeEqualTo(college);
        example.setOffset(offset);
        example.setLimit(limit);

        return workloadMapper.selectByExample(example);
    }

    /**
     * 根据list更新教学补贴
     *
     * @param workloads
     * @return 出错的数据
     * @throws Exception
     */
    @Override
    public List<RemoteTeachWorkload> updateLoadByList(List<RemoteTeachWorkload> workloads) throws Exception {
        ArrayList<RemoteTeachWorkload> ret = new ArrayList<RemoteTeachWorkload>();
        for (RemoteTeachWorkload workload : workloads) {
            if (!updateLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    /**
     * 更新单个数据
     *
     * @param workload
     * @return 成或失败
     * @throws Exception
     */
    @Override
    public boolean updateLoad(RemoteTeachWorkload workload) throws Exception {
        RemoteTeachWorkloadExample workloadExample = new RemoteTeachWorkloadExample();
        int people = workload.getPeople();
        //46个人为一个班，每增加一个班增加0.1系
        workload.setClassCoefficient((float) (Math.round(people / 46F)* 0.1 + 0.9));
        //计算工作量 课时
        workload.setWorkload(workload.getPeriod() * workload.getClassCoefficient());
        //计算酬金
        workload.setMoney(PropertyUtil.getAllowance() * workload.getWorkload());

        RemoteTeachWorkloadExample.Criteria criteria = workloadExample.createCriteria();
        criteria.andIdEqualTo(workload.getId());
        if (workloadMapper.updateByExample(workload, workloadExample) == 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean removeLoad(int id) throws Exception {
        RemoteTeachWorkloadExample example = new RemoteTeachWorkloadExample();
        RemoteTeachWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        if (workloadMapper.deleteByExample(example) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean removeLoad(List ids) throws Exception {
        RemoteTeachWorkloadExample example = new RemoteTeachWorkloadExample();
        RemoteTeachWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        if (workloadMapper.deleteByExample(example) == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int getCount(Integer years, String teacher) throws Exception {
        RemoteTeachWorkloadExample example = new RemoteTeachWorkloadExample();
        RemoteTeachWorkloadExample.Criteria criteria = example.createCriteria();
        if (years != 0) {
            criteria.andYearsEqualTo(years);
        }
        if (!"all".equals(teacher)) {
            criteria.andTeacherEqualTo(teacher);
        }
        return workloadMapper.countByExample(example);
    }
}
