package com.hfut.service.impl;

import com.hfut.entity.LocalTotalView;
import com.hfut.entity.LocalTotalViewExample;
import com.hfut.entity.RemoteTotalView;
import com.hfut.entity.RemoteTotalViewExample;
import com.hfut.mapper.LocalTotalViewMapper;
import com.hfut.mapper.RemoteTotalViewMapper;
import com.hfut.service.TotalService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TotalServiceImpl implements TotalService {
    @Autowired
    private RemoteTotalViewMapper remoteMapper;
    @Autowired
    private LocalTotalViewMapper localMapper;

    Logger logger = Logger.getLogger(TotalServiceImpl.class);


    @Override
    public List  getRemoteTotal(Integer years) {
        RemoteTotalViewExample example = new RemoteTotalViewExample();
        RemoteTotalViewExample.Criteria criteria = example.createCriteria();
        criteria.andYearsEqualTo(years);
        List<RemoteTotalView> list = remoteMapper.selectByExample(example);
        for (RemoteTotalView localTotal : list) {
            logger.info(localTotal.toString());
        }
        return list;
    }

    @Override
    public List getLocalTotal(Integer years) {
        LocalTotalViewExample example = new LocalTotalViewExample();
        LocalTotalViewExample.Criteria criteria = example.createCriteria();
        criteria.andYearsEqualTo(years);
        List<LocalTotalView> list = localMapper.selectByExample(example);
        for (LocalTotalView localTotal : list) {
            logger.info(localTotal.toString());
        }
        return list;
    }
    /**
     *
     * Integer REMOTE = 1;
     * Integer LOCAL = 2;
     *
     * */
    @Override
    public List getTotalByName(Integer years, String teacher, Integer local) {

        if (1 == local) {
            RemoteTotalViewExample example = new RemoteTotalViewExample();
            RemoteTotalViewExample.Criteria criteria = example.createCriteria();
            criteria.andYearsEqualTo(years);
            criteria.andTeacherEqualTo(teacher);
            List<RemoteTotalView> list = remoteMapper.selectByExample(example);
            return list;
        } else if (2 == local) {
            LocalTotalViewExample example = new LocalTotalViewExample();
            LocalTotalViewExample.Criteria criteria = example.createCriteria();
            criteria.andYearsEqualTo(years);
            criteria.andTeacherEqualTo(teacher);
            List<LocalTotalView> list = localMapper.selectByExample(example);
            return list;

        } else {
            return null;
        }
    }

}
