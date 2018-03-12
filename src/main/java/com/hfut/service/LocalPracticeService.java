package com.hfut.service;

import com.hfut.entity.LPracticeWorkload;

import java.util.List;

public interface LocalPracticeService {
    List<LPracticeWorkload> getList(Integer years, String teacher,Integer page, Integer limit) throws Exception;

    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(LPracticeWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LPracticeWorkload workload) throws Exception;

    List<LPracticeWorkload> insertLoadByList(List<LPracticeWorkload> list) throws Exception;

    boolean removeLoad(List list) throws Exception;

}
