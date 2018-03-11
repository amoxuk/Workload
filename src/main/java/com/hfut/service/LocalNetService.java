package com.hfut.service;

import com.hfut.entity.LNetWorkload;

import java.util.List;

public interface LocalNetService {
    List<LNetWorkload> findAllLoad(Integer page, Integer limit) throws Exception;

    int getCount() throws Exception;

    boolean updateLoad(LNetWorkload workload) throws Exception;


    boolean removeLoad(Integer id) throws Exception;

    boolean insertLoad(LNetWorkload workload) throws Exception;

    List<LNetWorkload> insertLoadByList(List<LNetWorkload> list) throws Exception;

    boolean removeLoad(List list);
}
