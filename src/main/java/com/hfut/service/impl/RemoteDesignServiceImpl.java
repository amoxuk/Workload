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
    public List<RemoteDesignWorkload> findAllLoad(Integer page, Integer limit) throws Exception {
        RemoteDesignWorkloadExample example = new RemoteDesignWorkloadExample();
        RemoteDesignWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        example.setOffset(page);
        example.setLimit(limit);

        return designWorkloadMapper.selectByExample(example);
    }

    @Override
    public int getCount() throws Exception {
        RemoteDesignWorkloadExample example = new RemoteDesignWorkloadExample();
        RemoteDesignWorkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
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

}
