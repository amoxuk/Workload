package com.hfut.service;

import com.hfut.entity.LNetWorkload;

import java.util.List;

public interface LocalNetService {

    int getCount(Integer years, String teacher) throws Exception;

    boolean updateLoad(LNetWorkload workload) throws Exception;


    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LNetWorkload workload) throws Exception;

    List<LNetWorkload> insertLoadByList(List<LNetWorkload> list) throws Exception;

    boolean removeLoad(List list);

    List<LNetWorkload> getList(Integer years, String teacher, Integer page, Integer limit);
}
