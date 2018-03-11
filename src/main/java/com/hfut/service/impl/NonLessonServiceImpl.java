package com.hfut.service.impl;

import com.hfut.entity.RemoteNonLesson;
import com.hfut.entity.RemoteNonLessonExample;
import com.hfut.mapper.RemoteNonLessonMapper;
import com.hfut.service.NonLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NonLessonServiceImpl implements NonLessonService {
    @Autowired
    private RemoteNonLessonMapper mapper;

    private RemoteNonLesson checkData(RemoteNonLesson workload) {
        workload.setAlldays(workload.getDays() * workload.getWeeks());
        workload.setAllownce((float) (workload.getAlldays() * 120));
        return workload;
    }

    @Override
    public List<RemoteNonLesson> getList(Integer page, Integer limit) throws Exception {
        RemoteNonLessonExample example = new RemoteNonLessonExample();
        example.setLimit(limit);
        example.setOffset(page);

        List<RemoteNonLesson> lessons = mapper.selectByExample(example);

        return lessons;
    }

    @Override
    public int getCount() throws Exception {
        RemoteNonLessonExample example = new RemoteNonLessonExample();

        return mapper.countByExample(example);
    }

    @Override
    public boolean updateLoad(RemoteNonLesson workload) throws Exception {
        workload = checkData(workload);
        int num = mapper.updateByPrimaryKey(workload);
        if (0 == num) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean removeLoad(Integer id) throws Exception {
        RemoteNonLessonExample example = new RemoteNonLessonExample();
        RemoteNonLessonExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        int num = mapper.deleteByExample(example);
        if (0 == num) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<RemoteNonLesson> insertLoadByList(List<RemoteNonLesson> list) throws Exception {

        ArrayList<RemoteNonLesson> ret = new ArrayList<RemoteNonLesson>();
        for (RemoteNonLesson workload : list) {
            if (!insertLoad(workload)) {
                ret.add(workload);
            }
        }
        return ret;
    }

    @Override
    public boolean insertLoad(RemoteNonLesson workload) throws Exception {
        workload = checkData(workload);

        if (0 == mapper.insertSelective(workload)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeLoad(List list) {
        RemoteNonLessonExample example = new RemoteNonLessonExample();
        RemoteNonLessonExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(list);
        if (mapper.deleteByExample(example) == 0) {
            return false;
        } else {
            return true;
        }
    }
}
