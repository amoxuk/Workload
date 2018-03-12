package com.hfut.service;

import com.hfut.entity.LProjectWorkload;

import java.util.List;

public interface LocalProjectService {

    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(LProjectWorkload workload) throws Exception;

    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LProjectWorkload workload) throws Exception;

    List<LProjectWorkload> insertLoadByList(List<LProjectWorkload> list) throws Exception;

    boolean removeLoad(List list);

    List<LProjectWorkload> getList(Integer years, String teacher, Integer page, Integer limit);
}
